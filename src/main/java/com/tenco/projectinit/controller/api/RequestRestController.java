package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.RequestRequestDTO;
import com.tenco.projectinit.dto.responsedto.RequestResponseDTO;
import com.tenco.projectinit.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request")
public class RequestRestController {

    @Autowired
    private RequestService requestService;

    // 기타 요청사항
    @PostMapping("/etc")
    public ResponseEntity<?> request(@RequestBody RequestRequestDTO.EtcDTO etcDTO) {
        RequestResponseDTO.RequestDTO requestDTO = requestService.request(etcDTO);
        return ResponseEntity.ok().body(ApiUtils.success(requestDTO));
    }

    @PostMapping("/etc-delete")
    public ResponseEntity<?> requestDelete(@RequestBody RequestRequestDTO.EtcDeleteDTO etcDeleteDTO) {
        requestService.requestDelete(etcDeleteDTO);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

}
