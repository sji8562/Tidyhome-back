package com.tenco.projectinit.dto.requestdto;

import lombok.Data;

public class RequestRequestDTO {

    @Data
    public static class EtcDTO{
        private Integer etcInfoId;
        private String special;
        private String other;
    }
}
