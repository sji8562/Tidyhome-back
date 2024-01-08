package com.tenco.projectinit.controller.api;

import com.tenco.projectinit.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("reservation")
public class ReservationRestController {

    @Autowired
    private ReservationService reservationService;

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