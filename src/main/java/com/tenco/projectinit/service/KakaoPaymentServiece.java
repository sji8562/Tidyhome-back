package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.responsedto.KakaoPaymentResponseDTO;
import com.tenco.projectinit.repository.entity.PaymentDetails;
import com.tenco.projectinit.repository.inteface.KakaoPaymentJPARepository;
import com.tenco.projectinit.repository.inteface.PaymentDetailsJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class KakaoPaymentServiece {
    static final String cid = "TC0ONETIME";// 가맹점 테스트 코드
    static final String admin_Key = "${7eff7caa1d6f4a4a46347e1abbc525d2}"; // 공개 조심! 본인 애플리케이션의 어드민 키를 넣어주세요
    @Autowired
    private KakaoPaymentJPARepository kakaoPaymentJPARepository;
    @Autowired
    private PaymentDetailsJPARepository paymentDetailsJPARepository;

    public KakaoPaymentResponseDTO.KakaoReadyDTO kakaoPayReady(Integer userId) {
        // TODO : 예약 ID 받아서 옵션 상품명 금액 으로 변경해야함
        // 카카오페이 요청 양식
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        String orderNumber = UUID.randomUUID().toString();
        parameters.add("partner_order_id", orderNumber);
        parameters.add("partner_user_id", userId.toString());
        parameters.add("item_name", "감자");
        parameters.add("quantity", Integer.valueOf(1).toString());
        parameters.add("total_amount", Integer.valueOf(19000).toString());
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
    public KakaoPaymentResponseDTO.KakaoApproveResponse ApproveResponse(String pgToken) {

        // 카카오 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", ApproveResponse(pgToken).getTid());
        parameters.add("partner_order_id", ApproveResponse(pgToken).getPartnerOrderId());
        parameters.add("partner_user_id", ApproveResponse(pgToken).getPartnerUserId());
        parameters.add("pg_token", pgToken);

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        KakaoPaymentResponseDTO.KakaoApproveResponse approveResponse = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/approve",
                requestEntity,
                KakaoPaymentResponseDTO.KakaoApproveResponse.class);



        return approveResponse;
    }

}
