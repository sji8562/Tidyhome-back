package com.tenco.projectinit.controller.mng;

import com.tenco.projectinit.dto.mng.FaqResponseDTO;
import com.tenco.projectinit.service.MngFaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mng/faq")
public class MngFaqController {

    @Autowired
    MngFaqService mngFaqService;
    @GetMapping("list")
    public String faqList(Model model){
        System.out.println("여기왔어");
        List<FaqResponseDTO.faqListDTO> faqListDTOList = mngFaqService.findAll();
        System.out.println(faqListDTOList);
        model.addAttribute("faqListDTOList",faqListDTOList);
        return "/mng/board/faq/list";
    }
    @GetMapping("detail")
    public String faqDetail(Model model){
        return "/mng/board/faq/list";
    }
    @GetMapping("save")
    public String faqSave(Model model){
        return "/mng/board/faq/list";
    }
    @GetMapping("update")
    public String faqUpdate(Model model){
        return "/mng/board/faq/list";
    }
    @GetMapping("delete")
    public String faqDelete(Model model){
        return "/mng/board/faq/list";
    }

}
