package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.ReservationRequestDTO;
import com.tenco.projectinit.dto.responsedto.ReservationDetailResponseDTO;
import com.tenco.projectinit.dto.responsedto.ReservationResponseDTO;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.service.ReservationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/success")
    public ResponseEntity<?> reservationSuccess(@RequestBody ReservationRequestDTO.ReservationSuccessDTO successDTO, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        User sessionUser = (User) session.getAttribute("sessionUser");
        Integer reservationSuccesId = reservationService.reservationSuccess(successDTO, sessionUser.getId());
        return ResponseEntity.ok().body(ApiUtils.success(new ReservationResponseDTO.ReservationSuccessDTO(reservationSuccesId)));
    }

    @PostMapping
    public ResponseEntity<?> reservationRegister(@RequestBody ReservationRequestDTO.ReservationRegister request) {
        Integer reservationID = reservationService.reservationRegister(request);
        return ResponseEntity.ok().body(ApiUtils.success(new ReservationResponseDTO.ReservationDTO(reservationID)));
    }

    // 예약 내역 목록
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserReservationInfo(@PathVariable Integer userId) {
        Optional<ReservationDetailResponseDTO.ReservationList> reservationList = reservationService.getReservationList(userId);
        return reservationList.map(detail -> new ResponseEntity<>(detail, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 예약 상세 내역 조회
    @GetMapping("/detail/{reservationId}")
    public ResponseEntity<?> getReservationDetail(@PathVariable Integer reservationId) {
        Optional<ReservationDetailResponseDTO.ReservationDetail> reservationDetail = reservationService.getReservationDetail(reservationId);
        return reservationDetail.map(detail -> new ResponseEntity<>(detail, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 일정 변경
    @PostMapping("/detail/{reservationId}/update")
    public ResponseEntity<String> updateDateTime(@PathVariable Integer reservationId, @RequestBody ReservationDetailResponseDTO.ReservationDateTime request,
                               @RequestParam Date newReservationDate, @RequestParam Time newReservationTime) {
        try {
            reservationService.updateReservationDateTime(reservationId, newReservationDate, newReservationTime);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 일정 취소

    // 출입방법 입력

    // 기타 요청사항 입력
}