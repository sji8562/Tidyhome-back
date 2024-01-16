package com.tenco.projectinit.dto.requestdto;

import lombok.Data;

public class KakaoPaymentRequestDTO {
    @Data
    public static class KakaoReadyDTO {
        private Integer reservationId;
    }


    @Data
    public static class KakaoApproveDTO {
        private Integer reservationId;
        private String tid;
        private String pgToken;
    }
    @Data
    public static class KakaoCancleDTO{
        private Integer reservationId;
        private String tid;
        private String pgToken;
    }
}