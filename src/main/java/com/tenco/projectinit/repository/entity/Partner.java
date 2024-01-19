package com.tenco.projectinit.repository.entity;

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
@Table(name = "partner_tb")
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tel;
    private String username;
    private String picUrl;
    private String categoryId;
    private String location;
    private String businessNumber;
    private Integer level;
    @Column(length = 256)
    @CreationTimestamp
    private Timestamp createdAt;
}