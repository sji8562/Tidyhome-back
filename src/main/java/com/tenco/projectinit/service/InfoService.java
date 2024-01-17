package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.responsedto.InfoResponseDTO;
import com.tenco.projectinit.repository.entity.AddressInfo;
import com.tenco.projectinit.repository.entity.Info;
import com.tenco.projectinit.repository.entity.sub_entity.Option;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import com.tenco.projectinit.repository.inteface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InfoService {
    @Autowired
    private ReservationJPARepository reservationJPARepository;
    @Autowired
    private InfoJPARepository infoJPARepository;

    public InfoResponseDTO.InfoDTO info(Integer infoId) {
        Optional<Info> optionalInfo = infoJPARepository.findById(infoId);
        Info info = optionalInfo.get();
        Integer id = info.getId();
        Optional<Reservation> optionalReservation = reservationJPARepository.findById(id);
        Option option = info.getOption();
        Reservation reservation = optionalReservation.get();
        Integer reservationId = reservation.getId();
        AddressInfo addressInfo = reservation.getAddressInfo();

        InfoResponseDTO.InfoDTO infoDTO = new InfoResponseDTO.InfoDTO(
                infoId, reservation.getStatus(), reservationId, info.getReservationDate(), info.getReservationTime(), addressInfo.getPostNumber(), addressInfo.getAddress(), addressInfo.getAddressDetail(), info.getPet(), info.getEnter(), info.getEnterPassword(), info.getSpecial(), info.getOtherRequest(), option.getPrice()
        );

        return infoDTO;
    }
}