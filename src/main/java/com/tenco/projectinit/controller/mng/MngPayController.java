package com.tenco.projectinit.controller.mng;

import com.tenco.projectinit.dto.mng.payListRequestDTO;
import com.tenco.projectinit.repository.entity.Sale;
import com.tenco.projectinit.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mng/pay")
public class MngPayController {
    @Autowired
    private SaleService saleService;

    @GetMapping("list")
    public String payList(Model model) {
        List<Sale> saleList = saleService.getList();
        List<payListRequestDTO.payListDTO> payList = saleService.getCategoryName(saleList);
        model.addAttribute("payList", payList);
        return "/mng/pay/list";
    }

}
