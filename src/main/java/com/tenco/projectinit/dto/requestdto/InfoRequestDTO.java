package com.tenco.projectinit.dto.requestdto;

import lombok.Data;

import java.sql.Timestamp;

public class InfoRequestDTO {

    @Data
    public static class InfoSaveRequestDTO{
        private Integer optionId;
        private String reservationDate;
        private String reservationTime;
        private boolean pet;
        private Timestamp createdAt;
    }

}
