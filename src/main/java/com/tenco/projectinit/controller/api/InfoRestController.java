package com.tenco.projectinit.controller.api;

import com.tenco.projectinit.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
public class InfoRestController {
    @Autowired
    private InfoService infoService;


}
