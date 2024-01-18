package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

public class RequestResponseDTO {
    @Data
    public static class RequestDTO{
        private String special;
        private String otherRequest;

        public RequestDTO(String special, String otherRequest) {
            this.special = special;
            this.otherRequest = otherRequest;
        }
    }

}