package com.tenco.projectinit.controller.mng;

import com.tenco.projectinit._core.errors.exception.CustomRestfullException;
import com.tenco.projectinit._core.utils.Define;
import com.tenco.projectinit.dto.mng.PartnerRequestDTO;
import com.tenco.projectinit.repository.entity.AddressInfo;
import com.tenco.projectinit.repository.entity.FirstCategory;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.repository.inteface.AddressInfoJPARepository;
import com.tenco.projectinit.service.CategoryService;
import com.tenco.projectinit.service.PartnerService;
import com.tenco.projectinit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/mng/user")
public class MngUserController {

    @Autowired
    UserService userService;

    @Autowired
    PartnerService partnerService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AddressInfoJPARepository addressInfoJPARepository;

    @GetMapping("list")
    public String userList(Model model) {
        System.out.println("여기오지?");
        List<User> userPG = userService.findAll();
        List<Partner> partnerPG = partnerService.findByLevel();
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
            userPG = userService.findByPageNation(page);
        } else {
            userPG = userService.findByPageNation(page, keyword);
        }
        model.addAttribute("userPG", userPG);
        model.addAttribute("prevPage", userPG.getNumber() - 1);
        model.addAttribute("nextPage", userPG.getNumber() + 1);

        return "/mng/user/customer/list";
    }

    @GetMapping("user-list/{userId}")
    public String showUserAddress(@PathVariable int userId, Model model) {
        List<AddressInfo> addressInfoList = addressInfoJPARepository.findByUserId(userId);
        model.addAttribute("addressInfoList", addressInfoList);
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

    @GetMapping("/{id}/user-delete")
    public String userDelete(@PathVariable Integer id) {
        userService.deleteById(id);
        return "redirect:/mng/user/user-list";
    }

    @GetMapping("/{id}/partner-delete")
    public String partnerDelete(@PathVariable Integer id) {
        partnerService.deleteById(id);
        return "redirect:/mng/user/partner-list";
    }

//    @GetMapping("{id}/partner-update")
//    public String partnerUpdate(@PathVariable Integer id,Model model) {
//        Optional<Partner> partner = partnerService.findById(id);
//        List<FirstCategory> firstCategoryList = categoryService.findAll();
//        System.out.println("여기말하는거야 ?" + firstCategoryList.stream().toList());
//        System.out.println(partner.get());
//         model.addAttribute("partner", partner.get());
//         model.addAttribute("firstCategoryList", firstCategoryList);
//
//        return "/mng/user/partner/update";
//    }

//    @PostMapping("partner-update-proc")
//    public String partnerUpdateProc(PartnerRequestDTO.UpdateDTO dto) {
//        System.out.println(dto.toString());
//        partnerService.updateById(dto);
//
//        return "redirect:/mng/user/{id}/partner-list";
//    }

    @GetMapping("{id}/partner-detail")
    public String partnerDetail(@PathVariable Integer id, Model model) {
        Optional<Partner> partner = partnerService.findById(id);
        System.out.println(partner.get());
        model.addAttribute("partner", partner.get());
        return "/mng/user/partner/detail";
    }

}