package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.responsedto.OptionResponseDTO;
import com.tenco.projectinit.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/option")
public class OptionRestController {

    @Autowired
    private OptionService optionService;
    @GetMapping
    public ResponseEntity<?> optionDetail(@RequestParam Integer secondCategoryId){
        OptionResponseDTO.OptionDetail optionDetail = optionService.getOptionDetail(secondCategoryId);
        return ResponseEntity.ok().body(ApiUtils.success(optionDetail));
    }
}
