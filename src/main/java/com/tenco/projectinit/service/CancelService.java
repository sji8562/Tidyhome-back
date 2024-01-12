package com.tenco.projectinit.service;

import com.tenco.projectinit.repository.entity.Cancel;
import com.tenco.projectinit.repository.entity.Sale;
import com.tenco.projectinit.repository.inteface.CancelJPARepository;
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

    // (관리자) 환불 신청 승인
    public void cancelApprove(Integer saleId) {
        Cancel cancel = cancelJPARepository.findBySaleId(saleId);
        Sale sale = saleJPARepository.findById(saleId)
                .orElseThrow(() -> new RuntimeException("Sale not found with id: " + saleId));
        if(cancel != null) {
            cancel.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            cancel.setPrice(sale.getPrice());
            sale.setStatus(4);
            cancelJPARepository.save(cancel);
            saleJPARepository.save(sale);
        }
    }

    // (사용자) 환불 신청
}
