package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardJPARepository extends JpaRepository<Card, Integer> {
    List<Card> findByUserId(Integer userId);
}
