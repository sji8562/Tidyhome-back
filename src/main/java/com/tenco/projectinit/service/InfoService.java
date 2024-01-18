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

import java.util.Optional;

@Service
public class InfoService {
    @Autowired
    private ReservationJPARepository reservationJPARepository;
    @Autowired
    private InfoJPARepository infoJPARepository;

    @Autowired
    private OptionJPARepository optionJPARepository;

    public InfoResponseDTO.InfoDTO info(Integer infoId) {
        Optional<Info> optionalInfo = infoJPARepository.findById(infoId);
        Info info = optionalInfo.get();
        Optional<Reservation> optionalReservation = reservationJPARepository.findByInfo(info);
        Reservation reservation = optionalReservation.get();
        Option option = info.getOption();
        AddressInfo addressInfo = reservation.getAddressInfo();

        InfoResponseDTO.InfoDTO infoDTO = new InfoResponseDTO.InfoDTO(
                infoId, reservation.getStatus(), info.getReservationDate(), info.getReservationTime(), addressInfo.getPostNumber(), addressInfo.getAddress(), addressInfo.getAddressDetail(), info.getPet(), info.getEnter(), info.getEnterPassword(), info.getSpecial(), info.getOtherRequest(), option.getPrice()
        );

        return infoDTO;
    }

    public void save(InfoRequestDTO.InfoSaveRequestDTO dto) {
        System.out.println("여기2"+dto.toString());
        Integer optionId = dto.getOptionId();
        Option option = optionJPARepository.findById(optionId).orElseThrow(() -> new Exception500("옵션이 없습니다"));
        System.out.println("여기3");
        Info info = Info.builder()
                .option(option)
                .reservationDate(dto.getReservationDate())
                .reservationTime(dto.getReservationTime())
                .pet(dto.isPet())
                .build();
        System.out.println("여기4");

        infoJPARepository.save(info);
        infoJPARepository.flush();
        System.out.println("여기5");
    }
}