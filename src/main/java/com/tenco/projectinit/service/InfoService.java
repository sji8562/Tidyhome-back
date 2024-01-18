package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit.dto.requestdto.InfoRequestDTO;
import com.tenco.projectinit.dto.responsedto.InfoResponseDTO;
import com.tenco.projectinit.repository.entity.AddressInfo;
import com.tenco.projectinit.repository.entity.Info;
import com.tenco.projectinit.repository.entity.sub_entity.Option;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import com.tenco.projectinit.repository.inteface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InfoService {
    @Autowired
    private ReservationJPARepository reservationJPARepository;
    @Autowired
    private InfoJPARepository infoJPARepository;
    @Autowired
    private OptionJPARepository optionJPARepository;

    public InfoResponseDTO.InfoDTO info(Integer reservationId) {
        Reservation reservation = reservationJPARepository.findById(reservationId).orElseThrow(() -> new Exception500("리저베이션이 없습니다."));
        Info info = reservation.getInfo();
        Integer infoId = info.getId();
        AddressInfo addressInfo = reservation.getAddressInfo();
        Option option = info.getOption();

        InfoResponseDTO.InfoDTO infoDTO = new InfoResponseDTO.InfoDTO(
                infoId, reservation.getStatus(), info.getReservationDate(), info.getReservationTime(), addressInfo.getPostNumber(), addressInfo.getAddress(), addressInfo.getAddressDetail(), info.getPet(), info.getEnter(), info.getEnterPassword(), info.getSpecial(), info.getOtherRequest(), option.getPrice()
        );
        return infoDTO;
    }

    @Transactional
    public void save(InfoRequestDTO.InfoSaveRequestDTO dto) {
        Integer optionId = dto.getOptionId();
        Option option = optionJPARepository.findById(optionId).orElseThrow(() -> new Exception500("옵션이 없습니다"));

        Info info = Info.builder()
                .option(option)
                .reservationDate(dto.getReservationDate())
                .reservationTime(dto.getReservationTime())
                .pet(dto.isPet())
                .build();

        infoJPARepository.save(info);
        infoJPARepository.flush();

        Reservation reservation = new Reservation();
        reservation.setInfo(info);
        reservation.setStatus(1);


        reservationJPARepository.save(reservation);
    }
}