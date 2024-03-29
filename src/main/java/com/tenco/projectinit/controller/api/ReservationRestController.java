package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.ReservationRequestDTO;
import com.tenco.projectinit.dto.responsedto.EnterResponseDTO;
import com.tenco.projectinit.dto.responsedto.RequestResponseDTO;
import com.tenco.projectinit.dto.responsedto.ReservationDetailResponseDTO;
import com.tenco.projectinit.dto.responsedto.ReservationResponseDTO;
import com.tenco.projectinit.repository.entity.User;


import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import com.tenco.projectinit.service.ReservationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationRestController {


    private final ReservationService reservationService;

    // 예약 등록
    @PostMapping("/save")
    public ResponseEntity<?> reservationRegister(@RequestBody ReservationRequestDTO.ReservationRegister reservationRegister) {
        int reservationId = reservationService.reservationRegister(reservationRegister);
        ReservationDetailResponseDTO.ReservationResult responseDTO = new ReservationDetailResponseDTO.ReservationResult(reservationService.findById(reservationId));
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }


    // 예약 내역 목록
    @GetMapping("/list/all/{userId}")
    public ResponseEntity<?> getUserReservationInfo(@PathVariable Integer userId) {
        List<Reservation> reservations = reservationService.getReservationList(userId);
        System.out.println("예약리스트 조회중");
        List<ReservationDetailResponseDTO.JReservationList> reservationList = reservations.stream()
                .map(reservation -> new ReservationDetailResponseDTO.JReservationList(reservation))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(ApiUtils.success(reservationList));
    }

    // 예약 내역 목록 (완료된 목록)
    @GetMapping("/list/completed/{id}")
    public ResponseEntity<?> getUserCompletedReservationInfo(@PathVariable Integer id) {
        List<Reservation> reservations = reservationService.getCompletedReservationList(id);
        List<ReservationDetailResponseDTO.JReservationList> reservationList = reservations.stream()
                .map(reservation -> new ReservationDetailResponseDTO.JReservationList(reservation))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(ApiUtils.success(reservationList));
    }

    // 예약 상세 내역 조회
    @GetMapping("/list/{reservationId}")
    public ResponseEntity<?> getReservationDetail(@PathVariable Integer reservationId) {
        Optional<ReservationDetailResponseDTO.ReservationDetail> reservationDetailOptional = reservationService.getReservationDetail(reservationId);

        if (reservationDetailOptional.isPresent()) {
            ReservationDetailResponseDTO.ReservationDetail reservationDetail = reservationDetailOptional.get();
            return ResponseEntity.ok().body(ApiUtils.success(reservationDetail));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 일정 변경
    @PostMapping("/list/{reservationId}/update")
    public ResponseEntity<?> updateDateTime(@PathVariable Integer reservationId, @RequestBody ReservationDetailResponseDTO.ReservationDateTime request) {
        try {
            reservationService.updateReservationDateTime(reservationId, request.getReservationDate(), request.getReservationTime());
            return ResponseEntity.ok(ApiUtils.success(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    // 일정 취소 -> 카카오페이 환불

    // 출입방법 입력
    @PostMapping("/list/{reservationId}/enter")
    public ResponseEntity<?> updateEnter(@PathVariable Integer reservationId, @RequestBody EnterResponseDTO.EnterDTO request) {
        try {
            reservationService.updateEnter(reservationId, request);
            return ResponseEntity.ok(ApiUtils.success(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    // 출입방법 삭제
    @PostMapping("/list/{reservationId}/enter/delete")
    public ResponseEntity<?> deleteEnter(@PathVariable Integer reservationId) {
        try {
            reservationService.deleteEnter(reservationId);
            return ResponseEntity.ok(ApiUtils.success(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    // 기타 요청사항 입력
    @PostMapping("/list/{reservationId}/request")
    public ResponseEntity<?> updateRequest(@PathVariable Integer reservationId, @RequestBody RequestResponseDTO.RequestDTO request) {
        try {
            reservationService.updateRequest(reservationId, request);
            return ResponseEntity.ok(ApiUtils.success(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    // 기타 요청사항 삭제
    @PostMapping("/list/{reservationId}/request/delete")
    public ResponseEntity<?> deleteRequest(@PathVariable Integer reservationId) {
        try {
            reservationService.deleteRequest(reservationId);
            return ResponseEntity.ok(ApiUtils.success(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    //예약 취소(상태를 4로 설정)
    @PostMapping("/cancel/{id}")
    public ResponseEntity<?> canselReservation(@PathVariable Integer id){
        System.out.println("여기찍히나?");
        Reservation reservation = reservationService.findById(id);
        reservation.setStatus(4);
        try {
            reservationService.save(reservation);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
        return ResponseEntity.ok(ApiUtils.success(null));
    }


}