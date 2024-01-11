package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.requestdto.KakaoPaymentRequestDTO;
import com.tenco.projectinit.dto.responsedto.KakaoPaymentResponseDTO;
import com.tenco.projectinit.repository.entity.*;
import com.tenco.projectinit.repository.entity.sub_entity.Option;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import com.tenco.projectinit.repository.entity.sub_entity.ReservationSuc;
import com.tenco.projectinit.repository.inteface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Service
public class KakaoPaymentServiece {
    static final String cid = "TC0ONETIME";// 가맹점 테스트 코드
    static final String admin_Key = "${7eff7caa1d6f4a4a46347e1abbc525d2}"; // 공개 조심! 본인 애플리케이션의 어드민 키를 넣어주세요
    @Autowired
    private KakaoPaymentJPARepository kakaoPaymentJPARepository;
    @Autowired
    private PaymentDetailsJPARepository paymentDetailsJPARepository;
    @Autowired
    private ReservationJPARepository reservationJPARepository;
    @Autowired
    private SaleJPARepository saleJPARepository;
    @Autowired
    private UserJPARepository userJPARepository;
    @Autowired
    private ReservationSucJPARepository reservationSucJPARepository;

    public KakaoPaymentResponseDTO.KakaoReadyDTO kakaoPayReady(Integer userId, Integer reservationId) {
        // TODO : 예약 ID 받아서 옵션 상품명 금액 으로 변경해야함
        // 카카오페이 요청 양식
        Optional<Reservation> optReservation = reservationJPARepository.findById(reservationId);
        Reservation reservation = optReservation.get();
        Info info = reservation.getInfo();
        Option option = info.getOption();
        String optionName = option.getName();
        Integer price = option.getPrice();
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        String orderNumber = UUID.randomUUID().toString();
        parameters.add("partner_order_id", orderNumber);
        parameters.add("partner_user_id", userId.toString());
        parameters.add("item_name", optionName);
        parameters.add("quantity", Integer.valueOf(1).toString());
        parameters.add("total_amount", price.toString()); // 가격
        parameters.add("tax_free_amount", Integer.valueOf(0).toString());
        parameters.add("approval_url", "http://localhost:80/payment/success"); // 성공 시 redirect url
        parameters.add("cancel_url", "http://localhost:80/payment/cancel"); // 취소 시 redirect url
        parameters.add("fail_url", "http://localhost:80/payment/fail"); // 실패 시 redirect url

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, getHeaders());

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        KakaoPaymentResponseDTO.KakaoReadyDTO kakaoReady = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/ready",
                requestEntity,
                KakaoPaymentResponseDTO.KakaoReadyDTO.class);

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .tid(kakaoReady.getTid())
                .partnerOrderId(orderNumber)
                .partnerUserId(userId.toString())
                .reservationId(reservationId)
                .build();

        paymentDetailsJPARepository.save(paymentDetails);

        return kakaoReady;
    }

    /**
     * 카카오 요구 헤더값
     */
    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();

        String auth = "KakaoAK " + admin_Key;

        httpHeaders.set("Authorization", auth);
        httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return httpHeaders;
    }

    /**
     * 결제 완료 승인
     */


    public KakaoPaymentResponseDTO.KakaoApproveResponse kakaoPayApprove(KakaoPaymentRequestDTO.KakaoApproveDTO kakaoApproveDTO, Integer userId) {
        String pgToken = kakaoApproveDTO.getPgToken();
        String tid = kakaoApproveDTO.getTid();
        // 페이먼트 디테일 찾기
        Optional<PaymentDetails> optionalPaymentDetails = paymentDetailsJPARepository.findByTid(tid);
        PaymentDetails paymentDetails = optionalPaymentDetails.get();
        // 페이먼트 디테일에서 파트너오더 아이디 꺼내기
        String partnerOrderId = paymentDetails.getPartnerOrderId();
        String partnerUserId = paymentDetails.getPartnerUserId();
        // 카카오 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", tid);
        parameters.add("partner_order_id", partnerOrderId);
        parameters.add("partner_user_id", partnerUserId);
        parameters.add("pg_token", pgToken);

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        KakaoPaymentResponseDTO.KakaoApproveResponse approveResponse = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/approve",
                requestEntity,
                KakaoPaymentResponseDTO.KakaoApproveResponse.class);
        // 레저베이션 엔티티 가져오기
        Optional<Reservation> optionalReservation = reservationJPARepository.findById(kakaoApproveDTO.getReservationId());
        Reservation reservation = optionalReservation.get();
        Optional<User> optionalUser = userJPARepository.findById(userId);
        User user = optionalUser.get();
        Info info = reservation.getInfo();
        Option option = info.getOption();
        Integer price = option.getPrice();
        Optional<KakaoPayment> optionalKakaoPayment = kakaoPaymentJPARepository.findByUser(user);
        KakaoPayment kakaoPayment = optionalKakaoPayment.get();
        Sale sale = new Sale(null, user, price, kakaoPayment, null, tid);
        saleJPARepository.save(sale);
        ReservationSuc reservationSuc = new ReservationSuc(null, reservation, sale, null);

        reservationSucJPARepository.save(reservationSuc);

        return approveResponse;
    }

    public KakaoPaymentResponseDTO.KakaoApproveResponse kakaoPayCancle(KakaoPaymentRequestDTO.KakaoApproveDTO kakaoApproveDTO, Integer id) {
        Optional<ReservationSuc> optionalReservationSuc = reservationSucJPARepository.findById(kakaoApproveDTO.getReservationId());
        ReservationSuc reservationSuc = optionalReservationSuc.get();
        Reservation reservation = reservationSuc.getReservation();

        // 카카오페이 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", "환불할 결제 고유 번호");
        parameters.add("cancel_amount", "환불 금액");
        parameters.add("cancel_tax_free_amount", "환불 비과세 금액");
        parameters.add("cancel_vat_amount", "환불 부가세");

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        KakaoPaymentResponseDTO.KakaoApproveResponse cancelResponse = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/cancel",
                requestEntity,
                KakaoPaymentResponseDTO.KakaoApproveResponse.class);

        reservationSucJPARepository.delete(reservationSuc);

        return cancelResponse;

    }
}
