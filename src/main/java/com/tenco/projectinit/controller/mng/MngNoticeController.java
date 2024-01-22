package com.tenco.projectinit.controller.mng;

import com.tenco.projectinit.dto.mng.NoticeRequestDTO;
import com.tenco.projectinit.repository.entity.Notice;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.service.MngNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mng/notice")
public class MngNoticeController {

    @Autowired
    MngNoticeService mngNoticeService;
    @GetMapping("list")
    public String noticeList(@RequestParam(defaultValue = "0") Integer page,Model model){

        Page<Notice> noticeList = mngNoticeService.findByPageNation(page);

        model.addAttribute("noticeList",noticeList);
        model.addAttribute("prevPage", noticeList.getNumber() - 1);
        model.addAttribute("nextPage", noticeList.getNumber() + 1);
        return "/mng/board/notice/list";
    }
    @GetMapping("{id}/detail")
    public String noticeDetail(@PathVariable Integer id, Model model){
        Optional<Notice> notice = mngNoticeService.findById(id);
        model.addAttribute("notice",notice.get());
        return "/mng/board/notice/detail";
    }
    @GetMapping("save")
    public String noticeSave(){
        return "/mng/board/notice/submit";
    }
    @PostMapping("save-proc")
    public String noticeSave(NoticeRequestDTO.NoticeSaveDTO dto){
        mngNoticeService.save(dto);
        return "redirect:/mng/notice/list";
    }
    @GetMapping("{id}/update")
    public String noticeUpdate(@PathVariable Integer id, Model model){
        Optional<Notice> notice = mngNoticeService.findById(id);
        model.addAttribute("notice" , notice.get());
        return "/mng/board/notice/update";
    }
    @PostMapping("update-proc")
    public String noticeUpdateProc(NoticeRequestDTO.NoticeUpdateDTO dto){
        mngNoticeService.udpate(dto);
        return "redirect:/mng/notice/list";
    }
    @GetMapping("{id}/delete")
    public String noticeDelete(@PathVariable Integer id){
        mngNoticeService.delete(id);
        return "redirect:/mng/notice/list";
    }
}
