package com.tenco.projectinit.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "enter_way_tb")
public class EnterWay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String commonEnterace; // 공동 현관 출입 방법
    private String doorPassword; // 자택 현관 비밀 번호

    @Builder
    public EnterWay(Integer id, String commonEnterace, String doorPassword) {
        this.id = id;
        this.commonEnterace = commonEnterace;
        this.doorPassword = doorPassword;
    }
}
