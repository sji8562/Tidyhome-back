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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {

    @Autowired
    private ReservationService reservationService;


    // 예약 등록
    @PostMapping("/save")
    public ResponseEntity<?> reservationRegister(@RequestBody ReservationRequestDTO.ReservationRegister request) {
        int reservationId = reservationService.reservationRegister(request);
        ReservationDetailResponseDTO.ReservationResult responseDTO = new ReservationDetailResponseDTO.ReservationResult(reservationService.findById(reservationId));
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }


    // 예약 내역 목록
    @GetMapping("/list")
    public ResponseEntity<?> getUserReservationInfo(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("sessionUser");
        List<Reservation> reservations = reservationService.getReservationList(user.getId());
        List<ReservationDetailResponseDTO.JReservationList> reservationList = reservations.stream()
                .map(reservation -> new ReservationDetailResponseDTO.JReservationList(reservation))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(ApiUtils.success(reservationList));
    }

    // 예약 내역 목록 (완료된 목록)
    @GetMapping("/list/completed")
    public ResponseEntity<?> getUserCompletedReservationInfo(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("sessionUser");
        List<Reservation> reservations = reservationService.getCompletedReservationList(user.getId());
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
}