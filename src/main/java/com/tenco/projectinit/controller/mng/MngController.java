package com.tenco.projectinit.controller.mng;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MngController {
    @GetMapping("/index")
    public String index(){
        return "mng/index";
    }
}
