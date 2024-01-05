package com.tenco.projectinit.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "housekeeper_register_tb")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HouseKeeperRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cleanCycle; // 청소주기
    private String serviceTimePrice; // 서비스 요금
    private boolean isRegularity; // 정기유무
    private String cleanDate; // 청소 날짜
    private String cleanStartTime; // 청소 시작 시간
    private boolean hasPet; // 애완동물 유무
    private boolean isMove; // 이사 유무
    private String address; // 주소
}
