package com.tenco.projectinit.dto;

import com.tenco.projectinit.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResponseDTO {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoginDTO {
        private String tel;
    }

    @Data
    public static class JoinDTO {
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
