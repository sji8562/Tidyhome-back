package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

public class RequestResponseDTO {
    @Data
    public static class RequestDTO{
        private Integer reservationId;
        private String special;
        private String otherRequest;

        public RequestDTO(Integer reservationId, String special, String otherRequest) {
            this.reservationId = reservationId;
            this.special = special;
            this.otherRequest = otherRequest;
        }
    }

}