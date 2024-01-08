package com.tenco.projectinit.controller.api;

import com.tenco.projectinit.repository.entity.Notice;
import com.tenco.projectinit.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/notice")
public class NoticeRestController {
    @Autowired
    private NoticeService noticeService;

    // 공지사항 목록 조회
    @GetMapping
    public ResponseEntity<List<Notice>> getAllNotice() {
        List<Notice> notices = noticeService.getAllNotice();
        return new ResponseEntity<>(notices, HttpStatus.OK);
    }
}
