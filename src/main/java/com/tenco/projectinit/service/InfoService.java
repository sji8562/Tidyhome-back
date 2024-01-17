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

    public InfoResponseDTO.InfoDTO info(Integer reservationId) {
        Optional<Reservation> optionalReservation = reservationJPARepository.findById(reservationId);
        Reservation reservation = optionalReservation.get();
        Info info = reservation.getInfo();
        Integer infoId = info.getId();
        AddressInfo addressInfo = reservation.getAddressInfo();
        Option option = info.getOption();

        InfoResponseDTO.InfoDTO infoDTO = new InfoResponseDTO.InfoDTO(
                infoId, reservation.getStatus(), reservationId, info.getReservationDate(), info.getReservationTime(), addressInfo.getPostNumber(), addressInfo.getAddress(), addressInfo.getAddressDetail(), info.getPet(), info.getEnter(), info.getEnterPassword(), info.getSpecial(), info.getOtherRequest(), option.getPrice()
        );

        return infoDTO;
    }
}