package com.tenco.projectinit.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tenco.projectinit.repository.entity.sub_entity.Enter;
import com.tenco.projectinit.repository.entity.sub_entity.Request;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "etc_info_tb")
public class EtcInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Info info;

    @JsonIgnore
    @OneToOne(mappedBy = "etcInfo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Enter enter;

    @JsonIgnore
    @OneToOne(mappedBy = "etcInfo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Request request;
}
