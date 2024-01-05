package com.tenco.projectinit.repository.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tenco.projectinit.repository.entity.sub_entity.Question;
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
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Question questionId;


    private Integer isFromSender;

    private String content;


    private Integer readStatus;

    @Column(length = 256)
    @CreationTimestamp
    private Timestamp createdAt;

    // Getters and setters (omitted for brevity)
}
