package com.tenco.projectinit.dto.responsedto;

import com.tenco.projectinit.repository.entity.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
public class UserResponseDTO {

    @Getter
    public static class TokenDTO {
        private String jwt;
        private User user;

        public TokenDTO(String jwt, User user) {
            this.jwt = jwt;
            this.user = user;
        }

    }


}
