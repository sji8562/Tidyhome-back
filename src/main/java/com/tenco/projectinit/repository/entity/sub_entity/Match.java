package com.tenco.projectinit.repository.entity.sub_entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tenco.projectinit.repository.entity.Partner;
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
@Table(name = "match_tb")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Wait wait;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Partner partner;

    @Column(length = 256)
    @CreationTimestamp
    private Timestamp createdAt;
}

