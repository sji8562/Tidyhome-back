package com.tenco.projectinit.repository.entity.sub_entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tenco.projectinit.repository.entity.Sale;
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
@Table(name = "reservation_suc_tb")
public class ReservationSuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Reservation reservation;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;

    @Column(length = 256)
    @CreationTimestamp
    private Timestamp createdAt;
}