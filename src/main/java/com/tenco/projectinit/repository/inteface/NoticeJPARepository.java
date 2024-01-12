package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeJPARepository extends JpaRepository<Notice, Integer> {
    List<Notice> findAllByOrderByCreatedAtDesc();
    Notice findById(int id);

    @Modifying
    @Query(value = "update Notice n set n.title = :title, n.content = :content where n.id = :id")
    void updateById(Integer id, String title, String content);

}
