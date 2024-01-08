package com.tenco.projectinit.service;

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
        return noticeJPARepository.findAllByOrderByCreatedAtDesc();
    }
}
