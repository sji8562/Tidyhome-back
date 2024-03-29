package com.tenco.projectinit.dto.requestdto;

import com.tenco.projectinit.repository.entity.KakaoPayment;
import lombok.Data;

import java.time.LocalDate;

public class ReservationRequestDTO {
    @Data
    public static class ReservationRegister{
        private Integer addressInfoId;
        private Integer optionId;
        private String reservationDate;
        private String reservationTime;
        private boolean pet;
        private String enter;
        private String enterPassword;
        private String special;
        private String otherRequest;
        private Integer status;
    }

    @Data
    public static class ReservationSuccessDTO{
        private Integer saleId;
        private Integer reservationId;
        private String tid;
    }
}
