package com.tenco.projectinit.dto;

import com.tenco.projectinit.repository.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Valid
public class UserResponseDTO {

    @Getter
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
        private String msg;

        public JoinDTO(String tel, String msg) {
            this.tel = tel;
            this.msg = msg;
        }
    }

    @Getter
    public static class TokenDTO {
        private String jwt;
        private User user;

        public TokenDTO(String jwt, User user) {
            this.jwt = jwt;
            this.user = UserPSDTO.hideUserPS(user);
        }

    }

    @Getter
    @AllArgsConstructor
    public static class UserPSDTO {
        public static User hideUserPS(User user) {
            User userPS = User.builder()
                    .id(user.getId())
                    .tel(user.getTel())
                    .build();

            return userPS;
        }

    }

}
