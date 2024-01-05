package com.tenco.projectinit.controller.mng;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mng")
public class MngIndexController {
    @GetMapping({"/","index"})
    public String index(){
        System.out.println("여기 오냐 ?");
        return "/mng/index";
    }
}
