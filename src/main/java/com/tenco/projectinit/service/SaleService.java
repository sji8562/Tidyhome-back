package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.mng.PartnerRequestDTO;
import com.tenco.projectinit.dto.mng.payListRequestDTO;
import com.tenco.projectinit.repository.entity.Sale;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import com.tenco.projectinit.repository.inteface.ReservationJPARepository;
import com.tenco.projectinit.repository.inteface.SaleJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleJPARepository saleJPARepository;
    @Autowired
    private ReservationJPARepository reservationJPARepository;

    // 결제 내역 조회
//    public List<Sale> getList () {
//        return saleJPARepository.findAllSalesWithUsers();
//    }

    // 카테고리 이름 (관리자)
    public List<payListRequestDTO.payListDTO> getPayList() {
        List<Reservation> reservations = reservationJPARepository.findAll();
        List<payListRequestDTO.payListDTO> payList = new ArrayList<>();
        for (Reservation reservation : reservations) {
            Sale sale = reservation.getSale();
            payListRequestDTO.payListDTO dto = new payListRequestDTO.payListDTO(sale, reservation);
            payList.add(dto);
        }
        return payList;
    }
}
