package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

public class ReservationDetailResponseDTO {

    @Data
    public static class ReservationList {
        private Integer reservationId;
        private Date reservationDate;
        private Time reservationTime;
        private String firstCategory;

        public ReservationList(Integer reservationId, Date reservationDate, Time reservationTime, String firstCategory) {
            this.reservationId = reservationId;
            this.reservationDate = reservationDate;
            this.reservationTime = reservationTime;
            this.firstCategory = firstCategory;
        }
    }
    @Data
    public static class ReservationCompleteList {
        private Integer reservationId;
        private Date reservationDate;
        private Time reservationTime;
        private String firstCategory;
        private Integer status;
        public ReservationCompleteList(Integer reservationId, Date reservationDate, Time reservationTime, String firstCategory,Integer status) {
            this.reservationId = reservationId;
            this.reservationDate = reservationDate;
            this.reservationTime = reservationTime;
            this.firstCategory = firstCategory;
            this.status = status;
        }
    }

    @Data
    public static class ReservationDetail {
    // addressInfo_tb
    private String address;
    private String addressDetail;

    // info_tb
    private Date reservationDate;
    private Time reservationTime;
    private Boolean pet;

    // sale_tb
    private Integer price;

    private String firstCategory;
    private String secondCategory;
    private String option;

        public ReservationDetail(String address, String addressDetail, Date reservationDate,
                                 Time reservationTime, Boolean pet, Integer price, String firstCategory,
                                 String secondCategory, String option) {
            this.address = address;
            this.addressDetail = addressDetail;
            this.reservationDate = reservationDate;
            this.reservationTime = reservationTime;
            this.pet = pet;
            this.price = price;
            this.firstCategory = firstCategory;
            this.secondCategory = secondCategory;
            this.option = option;
        }
    }

    @Data
    public static class ReservationDateTime {
        private Date reservationDate;
        private Time reservationTime;

        public ReservationDateTime(Date reservationDate, Time reservationTime) {
            this.reservationDate = reservationDate;
            this.reservationTime = reservationTime;
        }
    }

}
