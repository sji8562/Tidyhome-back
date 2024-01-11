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

    @PostMapping
    public ResponseEntity<?> request(@RequestBody RequestRequestDTO.EtcDTO etcDTO) {
        RequestResponseDTO.RequestDTO requestDTO = requestService.request(etcDTO);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

}
