package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit.dto.mng.NoticeRequestDTO;
import com.tenco.projectinit.repository.entity.Notice;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.inteface.NoticeJPARepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MngNoticeService {
    @Autowired
    NoticeJPARepository noticeJPARepository;
    public List<Notice> findAll() {
        return noticeJPARepository.findAll();
    }
    public Page<Notice> findByPageNation(Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        Page<Notice> noticePG = noticeJPARepository.findAll(pageable);
        if (noticePG.isEmpty() || noticePG == null) {
            throw new Exception500("공지사항이 없습니다.");
        }
        return noticePG;
    }
    public Optional<Notice> findById(Integer id) {
        return noticeJPARepository.findById(id);
    }

    @Transactional
    public void save(NoticeRequestDTO.NoticeSaveDTO dto) {
        Notice notice = Notice.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        noticeJPARepository.save(notice);
        noticeJPARepository.flush();
    }

    @Transactional
    public void udpate(NoticeRequestDTO.NoticeUpdateDTO dto) {
        noticeJPARepository.updateById(dto.getId(),dto.getTitle(),dto.getContent());
        noticeJPARepository.flush();

    }

    public void delete(Integer id) {
        noticeJPARepository.deleteById(id);
    }
}
