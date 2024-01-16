package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.EnterRequestDTO;
import com.tenco.projectinit.dto.responsedto.EnterResponseDTO;
import com.tenco.projectinit.service.EnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enter")
public class EnterRestController {
    @Autowired
    private EnterService enterService;

    @GetMapping("/inquiry")
    public ResponseEntity<?> inquiry(@RequestParam Integer reservationId){
     EnterResponseDTO.InquiryDTO inquiryDTO  = enterService.inquiry(reservationId);
     return ResponseEntity.ok().body(ApiUtils.success(inquiryDTO));
    }

    // 출입
    @PostMapping("/")
    public ResponseEntity<?> Enter(@RequestBody EnterRequestDTO.EnterDTO enterDTO) {
        EnterResponseDTO.EnterDTO enter = enterService.Enter(enterDTO);
        return ResponseEntity.ok().body(ApiUtils.success(enter));
    }

    // 삭제
    @PostMapping("/delete")
    public ResponseEntity<?> EnterDelete(@RequestBody EnterRequestDTO.EnterDeleteDTO enterDeleteDTO) {
        enterService.EnterDelete(enterDeleteDTO);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }
}
