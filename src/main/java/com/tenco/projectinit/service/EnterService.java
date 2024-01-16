package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.requestdto.EnterRequestDTO;
import com.tenco.projectinit.dto.responsedto.EnterResponseDTO;
import com.tenco.projectinit.repository.entity.EtcInfo;
import com.tenco.projectinit.repository.entity.Info;
import com.tenco.projectinit.repository.entity.sub_entity.Enter;
import com.tenco.projectinit.repository.entity.sub_entity.Request;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import com.tenco.projectinit.repository.inteface.EnterJPARepository;
import com.tenco.projectinit.repository.inteface.EtcInfoJPARepository;
import com.tenco.projectinit.repository.inteface.RequestJPARepository;
import com.tenco.projectinit.repository.inteface.ReservationJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EnterService {
    @Autowired
    private EnterJPARepository enterJPARepository;
    @Autowired
    private ReservationJPARepository reservationJPARepository;
    @Autowired
    private EtcInfoJPARepository etcInfoJPARepository;

    @Transactional
    public EnterResponseDTO.EnterDTO Enter(EnterRequestDTO.EnterDTO enterDTO) {
        Integer reservationId = enterDTO.getReservationId();
        Optional<Reservation> optionalReservation = reservationJPARepository.findById(reservationId);
        Reservation reservation = optionalReservation.get();
        Info info = reservation.getInfo();

        EtcInfo etcInfo = EtcInfo.builder()
                .info(info)
                .build();

        etcInfoJPARepository.save(etcInfo);

        Enter enter = Enter.builder()
                .etcInfo(etcInfo)
                .enter(enterDTO.getEnter())
                .enterPassword(enterDTO.getPassword())
                .build();

        enterJPARepository.save(enter);

        return  new EnterResponseDTO.EnterDTO(enter.getId(), etcInfo.getId(), enter.getEnter(), enter.getEnterPassword());
    }

    public void EnterDelete(EnterRequestDTO.EnterDeleteDTO enterDeleteDTO) {
        Integer enterId = enterDeleteDTO.getEnterId();
        Optional<Enter> optionalEnter = enterJPARepository.findById(enterId);
        Enter enter = optionalEnter.get();
        enterJPARepository.delete(enter);
    }

    public EnterResponseDTO.InquiryDTO inquiry(Integer reservationId) {
        Optional<Enter> optionalEnter = enterJPARepository.findEnterById(reservationId);
        Enter enter = optionalEnter.get();
        String howenter = enter.getEnter();
        String enterPassword = enter.getEnterPassword();
        return new EnterResponseDTO.InquiryDTO(reservationId, howenter, enterPassword);
    }
}
