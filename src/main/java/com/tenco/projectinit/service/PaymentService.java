package com.tenco.projectinit.service;

import com.tenco.projectinit.repository.entity.Card;
import com.tenco.projectinit.repository.inteface.CardJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    CardJPARepository cardJPARepository;

    // 카드 정보 저장하는 메소드
    public Card saveCard(Card card) {
        return cardJPARepository.save(card);
    }

    // 저장된 카드 정보를 보는 메소드
    public List<Card> getUserCard(Integer userId) {
        return cardJPARepository.findByUserId(userId);
    }
}
