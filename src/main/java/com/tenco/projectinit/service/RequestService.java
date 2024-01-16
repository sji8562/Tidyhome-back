package com.tenco.projectinit.service;

import com.tenco.projectinit.dto.requestdto.RequestRequestDTO;
import com.tenco.projectinit.dto.responsedto.RequestResponseDTO;
import com.tenco.projectinit.repository.entity.EtcInfo;
import com.tenco.projectinit.repository.entity.Info;
import com.tenco.projectinit.repository.entity.sub_entity.Request;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import com.tenco.projectinit.repository.entity.sub_entity.ReservationSuc;
import com.tenco.projectinit.repository.inteface.EtcInfoJPARepository;
import com.tenco.projectinit.repository.inteface.RequestJPARepository;
import com.tenco.projectinit.repository.inteface.ReservationJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    private RequestJPARepository requestJPARepository;
    @Autowired
    private ReservationJPARepository reservationJPARepository;
    @Autowired
    private EtcInfoJPARepository etcInfoJPARepository;

    @Transactional
    public RequestResponseDTO.RequestDTO requestEtc(RequestRequestDTO.EtcDTO etcDTO) {

        // 예약 아이디 찾기
        Integer reservationId = etcDTO.getReservationId();
        Optional<Reservation> optionalReservation = reservationJPARepository.findById(reservationId);
        Reservation reservation = optionalReservation.get();
        Info info = reservation.getInfo();

        EtcInfo etcInfo = EtcInfo.builder()
                .info(info)
                .build();

        etcInfoJPARepository.save(etcInfo);

        // 아이디 찾아서 엔티티 생성
        Request request = Request.builder()
                .special(etcDTO.getSpecial())
                .otherRequest(etcDTO.getOther())
                .etcInfo(etcInfo)
                .build();

        requestJPARepository.save(request);


        return new RequestResponseDTO.RequestDTO(request.getId() ,request.getSpecial(), request.getOtherRequest());
    }

    public void requestDelete(RequestRequestDTO.EtcDeleteDTO etcDeleteDTO) {
        Integer requestId = etcDeleteDTO.getRequestId();
        Optional<Request> optionalRequest = requestJPARepository.findById(requestId);
        Request request = optionalRequest.get();
        requestJPARepository.delete(request);
    }


    public RequestResponseDTO.RequestDTO inquiry(Integer reservationId) {
        Optional<Request> optionalRequest = requestJPARepository.findById(reservationId);
        Request request = optionalRequest.get();
        String special = request.getSpecial();
        String otherRequest = request.getOtherRequest();
        return new RequestResponseDTO.RequestDTO(reservationId ,special, otherRequest);
    }
}

