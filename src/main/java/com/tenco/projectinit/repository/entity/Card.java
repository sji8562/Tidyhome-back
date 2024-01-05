package com.tenco.projectinit.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card_tb")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String provider; // 카드사
    private String cardNumber; // 카드번호
    private String yearMonth; // YY-MM
    private String cardPassword; // 카드 비밀번호
    private String birth; // 생년월일
}
