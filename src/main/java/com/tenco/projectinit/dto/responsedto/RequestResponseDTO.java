package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

public class RequestResponseDTO {
    @Data
    public static class RequestDTO{
        private Integer requestId;
        private Integer etcInfo;
        private String special;
        private String otherRequest;

        public RequestDTO(Integer requestId, Integer etcInfo, String special, String otherRequest) {
            this.requestId = requestId;
            this.etcInfo = etcInfo;
            this.special = special;
            this.otherRequest = otherRequest;
        }
    }
}
