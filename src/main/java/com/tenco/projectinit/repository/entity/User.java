package com.tenco.projectinit.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tel;
    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public User(Integer id, String tel, Timestamp createdAt) {
        this.id = id;
        this.tel = tel;
        this.createdAt = createdAt;
    }
}
