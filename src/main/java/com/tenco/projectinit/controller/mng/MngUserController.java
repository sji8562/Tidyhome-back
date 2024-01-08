package com.tenco.projectinit.controller.mng;

import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mng/user")
public class MngUserController {

    @Autowired
    UserService userService;
    @GetMapping("list")
    public String userList(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "/mng/user/list";
    }
}
