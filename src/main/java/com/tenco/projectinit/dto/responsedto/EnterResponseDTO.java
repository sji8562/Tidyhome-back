package com.tenco.projectinit.dto.responsedto;

import lombok.Data;


public class EnterResponseDTO {
    @Data
    public static class EnterDTO{
        private String enter;
        private String password;

        public EnterDTO(String enter, String password) {
            this.enter = enter;
            this.password = password;
        }
    }

    @Data
    public static class InquiryDTO{
        private Integer reservationId;
        private String enter;
        private String pasword;

        public InquiryDTO(Integer reservationId, String enter, String pasword) {
            this.reservationId = reservationId;
            this.enter = enter;
            this.pasword = pasword;
        }
    }
}
