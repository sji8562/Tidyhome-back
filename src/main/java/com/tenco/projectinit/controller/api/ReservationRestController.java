package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.ReservationRequestDTO;
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

import java.util.List;
import java.util.Map;

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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getUserReservationInfo(@PathVariable Integer userId) {
        List<Map<String, Object>> reservationInfoList = reservationService.getUserReservationInfo(userId);

        if (reservationInfoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Map<String, Object>>>(reservationInfoList, HttpStatus.OK);
        }
    }
}