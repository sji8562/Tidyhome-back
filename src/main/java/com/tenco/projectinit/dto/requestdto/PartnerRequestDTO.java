package com.tenco.projectinit.dto.requestdto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

public class PartnerRequestDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JoinDTO {
        @NotBlank(message = "아이디는 필수 입력값입니다.")
        private String tel;
        @NotBlank(message = "회사이름은 필수 입력값입니다.")
        private String username;
        @NotBlank(message = "사업자 번호는 필수 입력값입니다.")
        private String businessNumber;
        private String picUrl;
        private String categoryId;
        private String location;

    }
}