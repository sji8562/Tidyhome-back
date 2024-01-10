package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit.repository.entity.Notice;
import com.tenco.projectinit.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        try {
            List<Notice> notices = noticeService.getAllNotice();
            return new ResponseEntity<>(notices, HttpStatus.OK);
        } catch (Exception500 e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 공지사항 내용 조회
    @GetMapping("/{id}")
    public ResponseEntity<Notice> getNoticeDetail(@PathVariable int id) {
        try {
            Notice notice = noticeService.getNoticeDetail(id);
            return new ResponseEntity<>(notice, HttpStatus.OK);
        } catch (Exception500 e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
