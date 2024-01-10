package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeJPARepository extends JpaRepository<Notice, Integer> {
    List<Notice> findAllByOrderByCreatedAtDesc();
    Notice findById(int id);
}
