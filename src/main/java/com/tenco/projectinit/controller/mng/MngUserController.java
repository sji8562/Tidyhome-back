package com.tenco.projectinit.controller.mng;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mng/user")
public class MngUserController {
    public String userList(){
        return "/mng/list";
    }
}
