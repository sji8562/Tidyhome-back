package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.responsedto.FaqPartResponseDTO;
import com.tenco.projectinit.repository.entity.Faq;
import com.tenco.projectinit.repository.entity.Services;
import com.tenco.projectinit.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faq")
public class FaqRestController {

    @Autowired
    FaqService faqService;

    @GetMapping("/{id}/list/{partId}")
    public ResponseEntity<?> serviceList(@PathVariable Integer id, @PathVariable Integer partId){
        List<FaqPartResponseDTO.FaqJoinPartDTO> dto;
            dto = faqService.findAllAndServicesIdAndPartId(id,partId);
            return ResponseEntity.ok().body(ApiUtils.success(dto));
    }
}
