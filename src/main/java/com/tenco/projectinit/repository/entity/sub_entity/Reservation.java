package com.tenco.projectinit.repository.entity.sub_entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tenco.projectinit.repository.entity.AddressInfo;
import com.tenco.projectinit.repository.entity.Info;
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
@Table(name = "reservation_tb")
public class Reservation{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private AddressInfo addressInfo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Info info;

    @Column(length = 256)
    @CreationTimestamp
    private Timestamp createdAt;
}
