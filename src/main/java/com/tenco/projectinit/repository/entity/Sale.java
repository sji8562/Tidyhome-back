package com.tenco.projectinit.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sale_tb")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private Integer price;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private KakaoPayment kakaoPayment;

    @Column(length = 256)
    @CreationTimestamp
    private Timestamp createdAt;

    // 카카오페이 결제번호? - 환불할 때 필요함
    private String tid;

    private Integer status;

    public String statusToString() {
        if (status == 2) {return "예약 취소";}
        else if (status == 3) {return "서비스 완료";}
        else if (status == 4) {return "환불 완료";}
        else {return "예약 완료";}
    }
}

