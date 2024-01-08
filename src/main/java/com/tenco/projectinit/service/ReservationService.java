package com.tenco.projectinit.service;

import com.tenco.projectinit.repository.inteface.ReservationJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReservationService {
    @Autowired
    private ReservationJPARepository reservationRepository;

    // 예약 내역을 보여주는 메서드
    public List<Map<String, Object>> getUserReservationInfo(Integer userId) {
        return reservationRepository.findUserAddressInfo(userId);
    }


}
