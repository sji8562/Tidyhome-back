package com.tenco.projectinit.dto.responsedto;

import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.entity.User;
import lombok.Getter;

public class PartnerResponseDTO {
    @Getter
    public static class TokenDTO {
        private String jwt;
        private Partner partner;

        public TokenDTO(String jwt, Partner partner) {
            this.jwt = jwt;
            this.partner = partner;
        }

    }
}
