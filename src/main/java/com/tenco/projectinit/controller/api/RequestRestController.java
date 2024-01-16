package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.RequestRequestDTO;
import com.tenco.projectinit.dto.responsedto.RequestResponseDTO;
import com.tenco.projectinit.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/request")
public class RequestRestController {

    @Autowired
    private RequestService requestService;

    @GetMapping("/inquiry")
    public ResponseEntity<?> inquiry(@RequestParam Integer requestId){
       RequestResponseDTO.RequestDTO requestDTO = requestService.inquiry(requestId);
        return ResponseEntity.ok().body(ApiUtils.success(requestDTO));
    }

    // 기타 요청사항
    @PostMapping("/etc")
    public ResponseEntity<?> requestEtc(@RequestBody RequestRequestDTO.EtcDTO etcDTO) {
        RequestResponseDTO.RequestDTO requestDTO = requestService.requestEtc(etcDTO);
        return ResponseEntity.ok().body(ApiUtils.success(requestDTO));
    }

    // 기타 요청사항 삭제
    @PostMapping("/etc-delete")
    public ResponseEntity<?> requestDelete(@RequestBody RequestRequestDTO.EtcDeleteDTO etcDeleteDTO) {
        requestService.requestDelete(etcDeleteDTO);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }


}
