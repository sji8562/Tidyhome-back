package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception404;
import com.tenco.projectinit.dto.mng.PartnerRequestDTO;
import com.tenco.projectinit.dto.mng.payListRequestDTO;
import com.tenco.projectinit.dto.requestdto.ReservationRequestDTO;
import com.tenco.projectinit.repository.entity.Sale;

import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.repository.entity.sub_entity.Option;

import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import com.tenco.projectinit.repository.inteface.ReservationJPARepository;
import com.tenco.projectinit.repository.inteface.SaleJPARepository;
import com.tenco.projectinit.repository.inteface.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleJPARepository saleJPARepository;
    @Autowired

    private UserJPARepository userJPARepository;
    @Autowired
    private ReservationJPARepository reservationJPARepository;
    // 결제 저장
    public Integer savePayment(ReservationRequestDTO.ReservationSuccessDTO successDTO, Integer userId) {
        // 예약 아이디 가져오기
        Integer reservationId = successDTO.getReservationId();
        // 예약엔티티 가져오기
        Reservation reservation = reservationJPARepository.findById(reservationId)
                .orElseThrow(() -> new Exception404("예약이 없습니다"));
        // 옵션 가져오기
        Option option = reservation.getInfo().getOption();
        // 옵션에서 price 가져오기
        Integer price = option.getPrice();
        // 유저 가져오기
        User user = userJPARepository.findById(userId)
                .orElseThrow(() -> new Exception404("사용자가 없습니다"));
        // tid 가져오기
        String tid = successDTO.getTid();

        // sale 만들기
        Sale sale = Sale.builder()

                .price(price)
                .user(user)
                .tid(tid)
                .build();
        saleJPARepository.save(sale);
        return sale.getId();

    }


    // 결제 내역 조회
    public List<Sale> getList() {
        return saleJPARepository.findAllSalesWithUsers();
    }


    // 카테고리 이름 (관리자)
    public List<payListRequestDTO.payListDTO> getPayList() {
        List<Reservation> reservations = reservationJPARepository.findAll();
        List<payListRequestDTO.payListDTO> payList = new ArrayList<>();

        for (Reservation reservation : reservations) {
            Sale sale = reservation.getSale();
            payListRequestDTO.payListDTO dto = new payListRequestDTO.payListDTO(sale, reservation);

//         for (int i = 0; i < saleList.size(); i++) {
//             payListRequestDTO.payListDTO dto = new payListRequestDTO.payListDTO(saleList.get(i), categoryNames.get(i));
            payList.add(dto);
        }
        return payList;
    }
}
