package com.tenco.projectinit.controller.mng;

import com.tenco.projectinit.dto.mng.payListRequestDTO;
import com.tenco.projectinit.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mng")
public class MngIndexController {

    @Autowired
    SaleService saleService;

    @GetMapping({"/","index"})
    public String index(Model model){
        List<payListRequestDTO.payListDTO> payList = saleService.getPayList();
        payListRequestDTO.MngTotalDTO totalDTO = saleService.findByCreatedAt();
        Integer count = saleService.getSaleCount();
//        List<Integer> countList = saleService.getCategoryCount();
//        List<payListRequestDTO.MngMonthDTO> totalDTO = saleService.getMonthlySales();
        System.out.println(totalDTO.toString());
        model.addAttribute("dtos",totalDTO.getMngMonthDTO());
        model.addAttribute("payList", payList);
        model.addAttribute("count", count);
//        model.addAttribute("countList", countList);
        return "/mng/index";
    }
}
