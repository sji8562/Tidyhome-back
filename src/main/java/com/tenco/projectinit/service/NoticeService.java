package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit.repository.entity.Notice;
import com.tenco.projectinit.repository.inteface.NoticeJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    NoticeJPARepository noticeJPARepository;

    // 공지사항 목록 조회
    public List<Notice> getAllNotice() {
        List<Notice> notices = noticeJPARepository.findAllByOrderByCreatedAtDesc();
        if (notices.isEmpty() || notices == null) {
            throw new Exception500("공지사항이 없습니다.");
        }
        return notices;
    }

    // 공지사항 내용 조회
    public Notice getNoticeDetail(int id) {
        Notice notice = noticeJPARepository.findById(id);
        if (notice == null) {
            throw new Exception500("해당 공지사항이 없습니다.");
        }
        return notice;
    }
}
