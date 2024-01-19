package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.UserRequestDTO;
import com.tenco.projectinit.repository.entity.Services;
import com.tenco.projectinit.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor

public class ServiceRestController {


    private final ServiceService serviceService;

    @GetMapping("list")
    public ResponseEntity<?> serviceList(){
        List<Services> servicesList = serviceService.findAll();
        return ResponseEntity.ok().body(ApiUtils.success(servicesList));
    }
}
