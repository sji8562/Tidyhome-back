package com.tenco.projectinit.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "kakao_payment_tb")
public class KakaoPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private User user;


    @Builder
    public KakaoPayment(User user) {
        this.user = user;
    }
}
