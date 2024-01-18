package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception404;
import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit.dto.requestdto.ReservationRequestDTO;

import com.tenco.projectinit.dto.responsedto.EnterResponseDTO;
import com.tenco.projectinit.dto.responsedto.RequestResponseDTO;


import com.tenco.projectinit.dto.responsedto.ReservationDetailResponseDTO;
import com.tenco.projectinit.repository.entity.*;


import com.tenco.projectinit.repository.entity.sub_entity.*;
import com.tenco.projectinit.repository.inteface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private OptionJPARepository optionJPARepository;
    @Autowired
    private InfoJPARepository infoJPARepository;
    @Autowired
    private AddressInfoJPARepository addressInfoJPARepository;

    @Autowired
    private ReservationJPARepository reservationJPARepository;



    // 예약 목록을 보여주는 메서드
    public List<Reservation> getReservationList(Integer userId) {
        return reservationJPARepository.findByAddressInfo_User_IdAndStatusIn(userId, Arrays.asList(1, 2));
    }

    // 완료 목록을 보여주는 메서드
    public List<Reservation> getCompletedReservationList(Integer userId) {
        return reservationJPARepository.findByAddressInfo_User_IdAndStatusIn(userId, Arrays.asList(3, 4));
    }

    // 예약 상세 내역을 조회하는 메서드
    // 예약 상세 내역을 조회하는 메서드
    public Optional<ReservationDetailResponseDTO.ReservationDetail> getReservationDetail(Integer reservationId) {
        Optional<Reservation> reservation = reservationJPARepository.findById(reservationId);
        return reservation.map(ReservationDetailResponseDTO.ReservationDetail::new);
    }


    // 예약 일정을 변경하는 메서드
    @Transactional
    public void updateReservationDateTime(Integer reservationId, String newReservationDate, String newReservationTime) {
        Reservation reservation = reservationJPARepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + reservationId));

        Info info = reservation.getInfo();

        info.setReservationDate(newReservationDate);
        info.setReservationTime(newReservationTime);

       try {
           infoJPARepository.save(info);
       } catch(Exception e){
           System.out.println("info세이브 실패");
       }
    }


    // 출입 방법 입력 메서드
    public void updateEnter(Integer reservationId, EnterResponseDTO.EnterDTO request) {
        Info info = infoJPARepository.findByReservationId(reservationId);
        info.setEnter(request.getEnter());
        info.setEnterPassword(request.getPassword());
        infoJPARepository.save(info);
    }

    // 출입 방법 삭제 메서드
    public void deleteEnter(Integer reservationId) {
        Info info = infoJPARepository.findByReservationId(reservationId);
        info.setEnter(null);
        info.setEnterPassword(null);
        infoJPARepository.save(info);
    }

    // 기타 요청사항 입력 메서드
    public void updateRequest(Integer reservationId, RequestResponseDTO.RequestDTO request) {
        Info info = infoJPARepository.findByReservationId(reservationId);
        info.setSpecial(request.getSpecial());
        info.setOtherRequest(request.getOtherRequest());
        infoJPARepository.save(info);
    }

    // 기타 요청사항 삭제 메서드
    public void deleteRequest(Integer reservationId) {
        Info info = infoJPARepository.findByReservationId(reservationId);
        info.setSpecial(null);
        info.setOtherRequest(null);
        infoJPARepository.save(info);
    }


    @Transactional
    public int reservationRegister(ReservationRequestDTO.ReservationRegister reservationRegister) {
        // 옵션 찾기
        Integer optionId = reservationRegister.getOptionId();
        Option option = optionJPARepository.findById(optionId)
                .orElseThrow(() -> new Exception500("옵션이 없습니다"));
        // 인포 엔티티 만들기

        Info info = Info.builder()
                .option(option)
                .reservationTime(reservationRegister.getReservationTime())
                .reservationDate(reservationRegister.getReservationDate())
                .pet(reservationRegister.isPet())
                .enter(reservationRegister.getEnter())
                .enterPassword(reservationRegister.getEnterPassword())
                .special(reservationRegister.getSpecial())
                .otherRequest(reservationRegister.getOtherRequest())
                .build();
        // 인포엔티티 저장
        try{
            infoJPARepository.save(info);
        } catch(Exception e){
            throw new Exception500("인포 저장 실패");
        }

        // 어드레스 엔티티 찾기
        Integer addressInfoId = reservationRegister.getAddressInfoId();
        AddressInfo addressInfo = addressInfoJPARepository.findById(addressInfoId)
                .orElseThrow(() -> new Exception500("주소가 없습니다"));
        // 어드레스랑 인포로 레저베이션 만들기
        System.out.println("5까지");
        Reservation reservation = Reservation.builder()
                .addressInfo(addressInfo)
                .info(info)
                .build();
        // 레저베이션 저장하고
        System.out.println("6까지");

        try{
            reservationJPARepository.save(reservation);
        }catch(Exception e){
            throw new Exception500("예약 저장 실패");

        }
        // 레저베이션 아이디 리턴
        return reservation.getId();

    }

//    public Integer reservationSuccess(ReservationRequestDTO.ReservationSuccessDTO successDTO, Integer userId) {
//        // 예약 아이디 가져오기
//        Integer reservationId = successDTO.getReservationId();
//        // 예약엔티티 가져오기
//        Reservation reservation = reservationRepository.findById(reservationId)
//                .orElseThrow(() -> new Exception404("예약이 없습니다"));
//        // 옵션 가져오기
//        Option option = reservation.getInfo().getOption();
//        // 옵션에서 price 가져오기
//        Integer price = option.getPrice();
//        // 유저 가져오기
//        User user = userJPARepository.findById(userId)
//                .orElseThrow(() -> new Exception404("사용자가 없습니다"));
//        // 카카오페이먼트 가져오기
//        Integer kakaoPaymentId = successDTO.getKakaoPaymentId();
//        KakaoPayment kakaoPayment = kakaoPaymentJPARepository.findById(kakaoPaymentId)
//                .orElseThrow(() -> new Exception404("카카오페이먼트가 없습니다"));
//        // tid 가져오기
//        String tid = successDTO.getTid();
//
//        // sale 만들기
//        Sale sale = Sale.builder()
//                .kakaoPayment(kakaoPayment)
//                .price(price)
//                .user(user)
//                .tid(tid)
//                .build();
//        saleJPARepository.save(sale);
//        ReservationSuc reservationSuc = ReservationSuc.builder()
//                .reservation(reservation)
//                .sale(sale)
//                .build();
//        reservationSucJPARepository.save(reservationSuc);
//        return reservationSuc.getId();
//    }

    public Reservation findById(int id){
        return reservationJPARepository.findById(id);
    }

    @Transactional
    public void save(Reservation reservation){
       try {
           reservationJPARepository.save(reservation);
       } catch(Exception e){
           throw new Exception500("예약 업데이트 실패");
       }
    }

}
