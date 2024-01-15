package com.tenco.projectinit.dto.requestdto;

import lombok.Data;

public class RequestRequestDTO {

    @Data
    public static class EtcDTO {
        private Integer reservationId;
        private String special;
        private String other;
    }

    @Data
    public static class EtcDeleteDTO {
        private Integer requestId;
    }


}
