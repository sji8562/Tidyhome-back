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
    @ManyToOne
    private User user;

    private String cid;



    @Builder
    public KakaoPayment(User user) {
        this.user = user;
    }
}
