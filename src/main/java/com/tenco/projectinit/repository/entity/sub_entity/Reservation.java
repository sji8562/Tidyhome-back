package com.tenco.projectinit.repository.entity.sub_entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tenco.projectinit.repository.entity.AddressInfo;
import com.tenco.projectinit.repository.entity.Info;
import com.tenco.projectinit.repository.entity.Sale;
import com.tenco.projectinit.repository.entity.User;
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

    @OneToOne(fetch = FetchType.LAZY)  // FetchType.LAZY로 변경
    private AddressInfo addressInfo;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Info info;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;

    private Integer status;

    @Column(length = 256)
    @CreationTimestamp
    private Timestamp createdAt;

    public String statusToString() {
        if (status == 1) return "결제전";
        else if (status == 2) return "결제후";
        else if (status == 3) return "서비스완료";
        else return "예약취소";
    }
}
