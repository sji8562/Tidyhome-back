//package com.tenco.projectinit.service;
//
//import com.tenco.projectinit.dto.responsedto.InfoResponseDTO;
//import com.tenco.projectinit.repository.entity.EtcInfo;
//import com.tenco.projectinit.repository.entity.Info;
//import com.tenco.projectinit.repository.entity.sub_entity.Enter;
//import com.tenco.projectinit.repository.entity.sub_entity.Request;
//import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
//import com.tenco.projectinit.repository.inteface.EnterJPARepository;
//import com.tenco.projectinit.repository.inteface.EtcInfoJPARepository;
//import com.tenco.projectinit.repository.inteface.RequestJPARepository;
//import com.tenco.projectinit.repository.inteface.ReservationJPARepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class InfoService {
//    @Autowired
//    private ReservationJPARepository reservationJPARepository;
//    @Autowired
//    private EnterJPARepository enterJPARepository;
//    @Autowired
//    private RequestJPARepository requestJPARepository;
//    @Autowired
//    private EtcInfoJPARepository etcInfoJPARepository;
//
//    public InfoResponseDTO.InfoDTO info(Integer reservationId) {
//        // 레저베이션 찾기
//        Optional<Reservation> optionalReservation = reservationJPARepository.findById(reservationId);
//        Reservation reservation = optionalReservation.get();
//        // 레저 > 인포 가져오기
//        Info info = reservation.getInfo();
//        // 엔터 찾기
//        Optional<EtcInfo> optEtc = etcInfoJPARepository.findById(info.getId());
//        EtcInfo etcInfo = optEtc.get();
//        List<Enter> enters = etcInfo.getEnters();
//        requestJPARepository.findById();
//        Enter enter = null;
//        if (enters.size() > 1) {
//            enter = enters.get(0);
//        }
//        InfoResponseDTO.EnterDTO enterDTO = null;
//        if (enter != null) {
//            enterDTO = new InfoResponseDTO.EnterDTO();
//        }
//
//        List<Request> requests = etcInfo.getRequests();
//        Request request = null;
//        if (requests.size() > 1) {
//            request = requests.get(0);
//        }
//        InfoResponseDTO.RequestDTO requestDTO = null;
//        if (request != null) {
//            requestDTO = new InfoResponseDTO.RequestDTO();
//        }
//
//
//
//
//        return null;
//    }
//}