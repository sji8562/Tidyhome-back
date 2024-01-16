package com.tenco.projectinit.dto.responsedto;

import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

public class ReservationDetailResponseDTO {

    @Data
    public static class ReservationList {
        private Integer reservationId;
        private String reservationDate;
        private String reservationTime;
        private String firstCategory;

        public ReservationList(Integer reservationId, String reservationDate, String reservationTime, String firstCategory) {
            this.reservationId = reservationId;
            this.reservationDate = reservationDate;
            this.reservationTime = reservationTime;
            this.firstCategory = firstCategory;
        }
    }
    @Data
    public static class ReservationCompleteList {
        private Integer reservationId;
        private String reservationDate;
        private String reservationTime;
        private String firstCategory;
        private Integer status;
        public ReservationCompleteList(Integer reservationId, String reservationDate, String reservationTime, String firstCategory,Integer status) {
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
    private String reservationDate;
    private String reservationTime;
    private Boolean pet;

    // sale_tb
    private Integer price;

    private String firstCategory;
    private String secondCategory;
    private String option;

        public ReservationDetail(String address, String addressDetail, String reservationDate,
                                 String reservationTime, Boolean pet, Integer price, String firstCategory,
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
        private String reservationDate;
        private String reservationTime;

        public ReservationDateTime(String reservationDate, String reservationTime) {
            this.reservationDate = reservationDate;
            this.reservationTime = reservationTime;
        }
    }

    @Data
    public static class ReservationResult {
        private String reservationDate;
        private String reservationTime;
        private Boolean pet;
        private String address;
        private String addressDetail;
        private String optionName;


        public ReservationResult(Reservation reservation) {
            this.reservationDate = reservation.getInfo().getReservationDate();
            this.reservationTime = reservation.getInfo().getReservationTime();
            this.pet = reservation.getInfo().getPet();
            this.address = reservation.getAddressInfo().getAddress();
            this.addressDetail = reservation.getAddressInfo().getAddressDetail();
            this.optionName = reservation.getInfo().getOption().getName();
        }
    }

}
