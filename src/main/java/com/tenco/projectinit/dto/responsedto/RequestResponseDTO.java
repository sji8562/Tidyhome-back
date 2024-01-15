package com.tenco.projectinit.dto.responsedto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

public class RequestResponseDTO {
    @Data
    public static class RequestDTO{
        private Integer requestId;
        private String special;
        private String otherRequest;

        public RequestDTO(Integer requestId, String special, String otherRequest) {
            this.requestId = requestId;
            this.special = special;
            this.otherRequest = otherRequest;
        }
    }

}
