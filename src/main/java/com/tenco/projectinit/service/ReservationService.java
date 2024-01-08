package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception404;
import com.tenco.projectinit.dto.requestdto.ReservationRequestDTO;
import com.tenco.projectinit.repository.entity.AddressInfo;
import com.tenco.projectinit.repository.entity.Info;
import com.tenco.projectinit.repository.entity.sub_entity.Option;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import com.tenco.projectinit.repository.inteface.AddressInfoJPARepository;
import com.tenco.projectinit.repository.inteface.InfoJPARepository;
import com.tenco.projectinit.repository.inteface.OptionJPARepository;
import com.tenco.projectinit.repository.inteface.ReservationJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;

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


    // 예약 내역을 보여주는 메서드
    public List<Map<String, Object>> getUserReservationInfo(Integer userId) {
        return reservationRepository.findUserAddressInfo(userId);
    }


    public Integer reservationRegister(ReservationRequestDTO.ReservationRegister request) {
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
}
