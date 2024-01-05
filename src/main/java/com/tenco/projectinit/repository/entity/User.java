package com.tenco.projectinit.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tel; // 유저아이디
    private int level; // 0: 사용자 1: 워커 9: 관리자

    public User(int id, String tel, int level) {
        this.id = id;
        this.tel = tel;
        this.level = level;
    }
}
