package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception404;
import com.tenco.projectinit.dto.requestdto.ReservationRequestDTO;

import com.tenco.projectinit.dto.responsedto.EnterResponseDTO;
import com.tenco.projectinit.dto.responsedto.RequestResponseDTO;
import com.tenco.projectinit.dto.responsedto.ReservationDetailResponseDTO;


import com.tenco.projectinit.repository.entity.*;


import com.tenco.projectinit.repository.entity.sub_entity.*;
import com.tenco.projectinit.repository.inteface.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationJPARepository reservationRepository;
    @Autowired
    private OptionJPARepository optionJPARepository;
    @Autowired
    private InfoJPARepository infoJPARepository;
    @Autowired
    private AddressInfoJPARepository addressInfoJPARepository;
    @Autowired
    private UserJPARepository userJPARepository;
    @Autowired
    private KakaoPaymentJPARepository kakaoPaymentJPARepository;
    @Autowired
    private ReservationSucJPARepository reservationSucJPARepository;
    @Autowired
    private SaleJPARepository saleJPARepository;
    @Autowired
    private EnterJPARepository enterJPARepository;
    @Autowired
    private EtcInfoJPARepository etcInfoJPARepository;
    @Autowired
    private RequestJPARepository requestJPARepository;
    @Autowired
    private WaitJPARepository waitJPARepository;



    // 예약 목록을 보여주는 메서드
    public List<ReservationDetailResponseDTO.ReservationList> getReservationList(Integer userId) {
        return reservationRepository.findReservationByUserId(userId);
    }

    // 완료 목록을 보여주는 메서드
    public List<ReservationDetailResponseDTO.ReservationCompleteList> getCompletedReservationList(Integer userId) {
        return reservationRepository.findCompletedReservationByUserId(userId);
    }

    // 예약 상세 내역을 조회하는 메서드
    public ReservationDetailResponseDTO.ReservationDetail getReservationDetail(Integer reservationId) {
        return reservationRepository.findReservationDetailById(reservationId);
    }


    // 예약 일정을 변경하는 메서드
    @Transactional
    public void updateReservationDateTime(Integer reservationId, Date newReservationDate, Time newReservationTime) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + reservationId));

        Info info = reservation.getInfo();

        info.setReservationDate(newReservationDate);
        info.setReservationTime(newReservationTime);

        infoJPARepository.save(info);
    }


    // 출입 방법 입력 메서드
//    public void updateEnter(Integer reservationId, EnterResponseDTO responseDTO) {
//        EtcInfo etcInfo = etcInfoJPARepository.findEtcInfoIdByReservationId(reservationId);
//        Enter enter = Enter.builder()
//                .etcInfo(etcInfo)
//                .enter(responseDTO.getEnter())
//                .enterPassword(responseDTO.getEnterPassword())
//                .build();

    // 출입 방법 입력 메서드
    public void updateEnter(Integer reservationId, EnterResponseDTO.EnterDTO request) {
        Info info = infoJPARepository.findByReservationId(reservationId);

        Wait wait = waitJPARepository.findByReservationSuc_Reservation_Id(reservationId);

        EtcInfo etcInfo = wait.getEtcInfo();
        if(etcInfo == null) {
            etcInfo = EtcInfo.builder()
                    .info(info)
                    .build();
            etcInfoJPARepository.save(etcInfo);
            wait.setEtcInfo(etcInfo);
        }

        Enter enter = Enter.builder()
                .etcInfo(etcInfo)
                .enter(request.getEnter())
                .enterPassword(request.getPassword())
                .build();


        enterJPARepository.save(enter);
    }

    // 출입 방법 삭제 메서드
    public void deleteEnter(Integer reservationId) {
        Optional<Enter> optionalEnter = enterJPARepository.findEnterById(reservationId);
        if(optionalEnter.isPresent()) {
            Enter enter = optionalEnter.get();
            enterJPARepository.delete(enter);
        }
    }

    // 기타 요청사항 입력 메서드
    public void updateRequest(Integer reservationId, RequestResponseDTO.RequestDTO responseDTO) {
        Info info = infoJPARepository.findByReservationId(reservationId);

        Wait wait = waitJPARepository.findByReservationSuc_Reservation_Id(reservationId);

        EtcInfo etcInfo = wait.getEtcInfo();
        if(etcInfo == null) {
            etcInfo = EtcInfo.builder()
                    .info(info)
                    .build();
            etcInfoJPARepository.save(etcInfo);
            wait.setEtcInfo(etcInfo);
        }

        Request request = Request.builder()
                .etcInfo(etcInfo)
                .special(responseDTO.getSpecial())
                .otherRequest(responseDTO.getOtherRequest())
                .build();
        requestJPARepository.save(request);
    }

    // 기타 요청사항 삭제 메서드
    public void deleteRequest(Integer reservationId) {
        Optional<Request> optionalRequest = requestJPARepository.findEnterById(reservationId);
        if(optionalRequest.isPresent()) {
            Request request = optionalRequest.get();
            requestJPARepository.delete(request);
        }
    }



    public int reservationRegister(ReservationRequestDTO.ReservationRegister request) {
        // 옵션 찾기
        Integer optionId = request.getOptionId();
        Option option = optionJPARepository.findById(optionId)
                .orElseThrow(() -> new Exception404("옵션이 없습니다"));
        // 인포 엔티티 만들기
        Info info = Info.builder()
                .option(option)
                .reservationTime(Time.valueOf(request.getReservationTime()))
                .reservationDate(Date.valueOf(request.getReservationDate()))
                .pet(request.isPet())
                .build();
        // 인포엔티티 저장
        infoJPARepository.save(info);
        // 어드레스 엔티티 찾기
        Integer addressInfoId = request.getAddressInfoId();
        AddressInfo addressInfo = addressInfoJPARepository.findById(addressInfoId)
                .orElseThrow(() -> new Exception404("주소가 없습니다"));
        // 어드레스랑 인포로 레저베이션 만들기
        Reservation reservation = Reservation.builder()
                .addressInfo(addressInfo)
                .info(info)
                .build();
        // 레저베이션 저장하고
        reservationRepository.save(reservation);
        // 레저베이션 아이디 리턴
        return reservation.getId();

    }

    public Integer reservationSuccess(ReservationRequestDTO.ReservationSuccessDTO successDTO, Integer userId) {
        // 예약 아이디 가져오기
        Integer reservationId = successDTO.getReservationId();
        // 예약엔티티 가져오기
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new Exception404("예약이 없습니다"));
        // 옵션 가져오기
        Option option = reservation.getInfo().getOption();
        // 옵션에서 price 가져오기
        Integer price = option.getPrice();
        // 유저 가져오기
        User user = userJPARepository.findById(userId)
                .orElseThrow(() -> new Exception404("사용자가 없습니다"));
        // 카카오페이먼트 가져오기
        Integer kakaoPaymentId = successDTO.getKakaoPaymentId();
        KakaoPayment kakaoPayment = kakaoPaymentJPARepository.findById(kakaoPaymentId)
                .orElseThrow(() -> new Exception404("카카오페이먼트가 없습니다"));
        // tid 가져오기
        String tid = successDTO.getTid();

        // sale 만들기
        Sale sale = Sale.builder()
                .kakaoPayment(kakaoPayment)
                .price(price)
                .user(user)
                .tid(tid)
                .build();
        saleJPARepository.save(sale);
        ReservationSuc reservationSuc = ReservationSuc.builder()
                .reservation(reservation)
                .sale(sale)
                .build();
        reservationSucJPARepository.save(reservationSuc);
        return reservationSuc.getId();
    }
}
