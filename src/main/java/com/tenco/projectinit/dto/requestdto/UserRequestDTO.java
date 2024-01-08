package com.tenco.projectinit.dto.requestdto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequestDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoginDTO {
        @NotBlank(message = "아이디는 필수 입력값입니다.")
        private String tel;
    }

    @Data
    public static class JoinDTO {
        @NotBlank(message = "아이디는 필수 입력값입니다.")
        private String tel;
    }
    @Data
    public static class SmsSendDTO{
         private String tel;
    }

    @Data
    public static class SmsCheckDTO{
        private String tel;
        private String code;
    }
}
