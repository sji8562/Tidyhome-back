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

    // 예약 성공
    @PostMapping("/success")
    public ResponseEntity<?> reservationSuccess(@RequestBody ReservationRequestDTO.ReservationSuccessDTO successDTO, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        User sessionUser = (User) session.getAttribute("sessionUser");
        Integer reservationSuccesId = reservationService.reservationSuccess(successDTO, sessionUser.getId());
        return ResponseEntity.ok().body(ApiUtils.success(new ReservationResponseDTO.ReservationSuccessDTO(reservationSuccesId)));
    }

    // 예약 등록
    @PostMapping("/")
    public ResponseEntity<?> reservationRegister(@RequestBody ReservationRequestDTO.ReservationRegister request) {
        Integer reservationID = reservationService.reservationRegister(request);
        return ResponseEntity.ok().body(ApiUtils.success(new ReservationResponseDTO.ReservationDTO(reservationID)));
    }


    // 예약 내역 목록
    @GetMapping("/list")
    public ResponseEntity<?> getUserReservationInfo(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("sessionUser");
        Optional<ReservationDetailResponseDTO.ReservationList> reservationList = reservationService.getReservationList(user.getId());
        return ResponseEntity.ok().body(ApiUtils.success(reservationList));
    }

    // 예약 상세 내역 조회
    @GetMapping("/list/{reservationId}")
    public ResponseEntity<?> getReservationDetail(@PathVariable Integer reservationId) {
        Optional<ReservationDetailResponseDTO.ReservationDetail> reservationDetail = reservationService.getReservationDetail(reservationId);
        return ResponseEntity.ok().body(ApiUtils.success(reservationDetail));
    }

    // 일정 변경
    @PostMapping("/list/{reservationId}/update")
    public ResponseEntity<?> updateDateTime(@PathVariable Integer reservationId, @RequestBody ReservationDetailResponseDTO.ReservationDateTime request,
                               @RequestParam Date newReservationDate, @RequestParam Time newReservationTime) {
        try {
            reservationService.updateReservationDateTime(reservationId, newReservationDate, newReservationTime);
            return ResponseEntity.ok(ApiUtils.success(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
        }
    }

    // 일정 취소

    // 출입방법 입력

    // 기타 요청사항 입력
}