package com.tenco.projectinit.controller.mng;

import com.tenco.projectinit.dto.mng.payListRequestDTO;
import com.tenco.projectinit.dto.responsedto.KakaoPaymentResponseDTO;
import com.tenco.projectinit.repository.entity.Sale;
import com.tenco.projectinit.service.CancelService;


import com.tenco.projectinit.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mng/pay")
public class MngPayController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private CancelService cancelService;



    // 결제 내역 목록 조회
    @GetMapping("list")
    public String payList(Model model) {
        List<payListRequestDTO.payListDTO> payList = saleService.getPayList();
        model.addAttribute("payList", payList);
        return "/mng/pay/list";
    }

    // 환불 신청 승인 - 카카오페이 환불 추가해야함
    @PostMapping("cancel")
    public String cancelApprove(@RequestParam Integer saleId) {
        cancelService.cancelApprove(saleId);
//        kakaoPaymentServiece.kakaoPayCancel();
        return "redirect:/mng/pay/list";
    }

}
