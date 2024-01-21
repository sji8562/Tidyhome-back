package com.tenco.projectinit.controller.mng;

import com.tenco.projectinit.dto.mng.FaqResponseDTO;
import com.tenco.projectinit.repository.entity.FaqPart;
import com.tenco.projectinit.service.FaqService;
import com.tenco.projectinit.service.MngFaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("mng/faq")
public class MngFaqController {

    @Autowired
    FaqService faqService;

    @Autowired
    MngFaqService mngFaqService;

    @GetMapping("list")
    public String faqList(Model model){
        List<FaqResponseDTO.FaqListDTO> faqListDTOList = faqService.findAllWithFaqPart();
        model.addAttribute("faqListDTOList",faqListDTOList);
        return "/mng/board/faq/list";
    }
    @GetMapping("{id}/detail")
    public String faqDetail(@PathVariable Integer id, Model model){
        FaqPart faqPart = mngFaqService.getDetail(id);
        model.addAttribute("board", faqPart);
        return "/mng/board/faq/detail";
    }
    @GetMapping("{id}/update")
    public String faqUpdate(@PathVariable Integer id, Model model){
        FaqPart faqPart = mngFaqService.getDetail(id);
        model.addAttribute("board", faqPart);
        return "/mng/board/faq/update";
    }
    @GetMapping("update-proc")
    public String faqUpdateProc(){
        return "/mng/board/faq/list";
    }
    @GetMapping("save")
    public String faqSave(Model model){
        return "/mng/board/faq/list";
    }

    @GetMapping("{id}/delete")
    public String faqDelete(@PathVariable Integer id){
        mngFaqService.deleteFaq(id);
        return "redirect:/mng/faq/list";
    }

}
