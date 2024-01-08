package com.tenco.projectinit.dto.requestdto;

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
    }

}
