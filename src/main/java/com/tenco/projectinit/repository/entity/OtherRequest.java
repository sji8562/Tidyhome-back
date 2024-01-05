package com.tenco.projectinit.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "other_request_tb")
public class OtherRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String especially; // 특히 신경 쓸 곳
    private String etcMessage; // 기타 요청사항

    @Builder
    public OtherRequest(Integer id, String especially, String etcMessage) {
        this.id = id;
        this.especially = especially;
        this.etcMessage = etcMessage;
    }
}
