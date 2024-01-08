package com.tenco.projectinit.controller.mng;

import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.service.PartnerService;
import com.tenco.projectinit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/mng/user")
public class MngUserController {

    @Autowired
    UserService userService;

    @Autowired
    PartnerService partnerService;

    @GetMapping("list")
    public String userList(Model model) {
        System.out.println("여기오지?");
        List<User> userPG = userService.findAll();
        List<Partner> partnerPG = partnerService.findAll();
        System.out.println(userPG.stream().toList());
        model.addAttribute("userPG", userPG);
        model.addAttribute("partnerPG", partnerPG);
        return "/mng/user/list";
    }

    @GetMapping("user-list")
    public String customerList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "") String keyword, Model model) {
        Page<User> userPG = null;
        model.addAttribute("keyword", keyword);
        if (keyword.isBlank()) {
            System.out.println("여기오지?");
            userPG = userService.findByPageNation(page);
        } else {
            userPG = userService.findByPageNation(page, keyword);
        }
        System.out.println(userPG.stream().toList());
        model.addAttribute("userPG", userPG);
        model.addAttribute("prevPage", userPG.getNumber() - 1);
        model.addAttribute("nextPage", userPG.getNumber() + 1);
        return "/mng/user/customer/list";
    }

    @GetMapping("partner-list")
    public String partnerList(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "") String keyword, Model model) {
        Page<Partner> partnerPG = null;
        model.addAttribute("keyword", keyword);
        if (keyword.isBlank()) {
            System.out.println("여기오지?");
            partnerPG = partnerService.findByPageNation(page);
        } else {
            partnerPG = partnerService.findByPageNation(page, keyword);
        }
        System.out.println(partnerPG.stream().toList());
        model.addAttribute("partnerPG", partnerPG);
        model.addAttribute("prevPage", partnerPG.getNumber() - 1);
        model.addAttribute("nextPage", partnerPG.getNumber() + 1);
        return "/mng/user/partner/list";
    }
}
