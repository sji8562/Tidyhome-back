package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.InfoRequestDTO;
import com.tenco.projectinit.dto.responsedto.InfoResponseDTO;
import com.tenco.projectinit.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/info")
@RequiredArgsConstructor
public class InfoRestController {


    private final InfoService infoService;



    //예약 아이디로 예약정보 조회
    @GetMapping("/")
    public ResponseEntity<?> info(@RequestParam Integer reservationId) {
        InfoResponseDTO.InfoDTO infoDTO = infoService.info(reservationId);
        return ResponseEntity.ok().body(ApiUtils.success(infoDTO));
    }
}