package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception404;
import com.tenco.projectinit.repository.entity.Cancel;
import com.tenco.projectinit.repository.entity.Sale;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import com.tenco.projectinit.repository.inteface.CancelJPARepository;
import com.tenco.projectinit.repository.inteface.ReservationJPARepository;
import com.tenco.projectinit.repository.inteface.SaleJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class CancelService {
    @Autowired
    private CancelJPARepository cancelJPARepository;
    @Autowired
    private SaleJPARepository saleJPARepository;
    @Autowired
    private ReservationJPARepository reservationJPARepository;

    // (관리자) 환불 신청 승인
    public void cancelApprove(Integer saleId) {
        Cancel cancel = cancelJPARepository.findBySaleId(saleId);
        Reservation reservation = reservationJPARepository.findBySaleId(saleId);
        Sale sale = saleJPARepository.findById(saleId).orElseThrow(() -> new Exception404("결제 내역이 없습니다."));
        if(cancel != null) {
            cancel.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            cancel.setPrice(sale.getPrice());
            reservation.setStatus(4);
            cancelJPARepository.save(cancel);
        }
    }

    // (사용자) 환불 신청
}
