package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.InfoRequestDTO;
import com.tenco.projectinit.dto.responsedto.InfoResponseDTO;
import com.tenco.projectinit.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/info")
public class InfoRestController {

    @Autowired
    private InfoService infoService;

    //info 생성
    @PostMapping("/save")
    public ResponseEntity<?> infoSave(@RequestBody InfoRequestDTO.InfoSaveRequestDTO infoSaveRequestDTO) {
        infoService.save(infoSaveRequestDTO);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    //예약 아이디로 예약정보 조회
    @GetMapping("/")
    public ResponseEntity<?> info(@RequestParam Integer reservationId) {
        InfoResponseDTO.InfoDTO infoDTO = infoService.info(reservationId);
        return ResponseEntity.ok().body(ApiUtils.success(infoDTO));
    }
}