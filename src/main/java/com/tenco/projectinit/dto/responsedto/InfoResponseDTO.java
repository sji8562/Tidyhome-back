package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

public class InfoResponseDTO {

    @Data
    public static class InfoDTO {
        private Integer infoId;
        private Integer status;
        private Integer reservationId;
        private String reservationDate;
        private String reservationTime;
        private String postNumber;
        private String address;
        private String addressDetail;
        private boolean pet;
        private String enter;
        private String enterPassword;
        private String special;
        private String otherRequest;
        private Integer price;

        public InfoDTO(Integer infoId, Integer status, Integer reservationId, String reservationDate, String reservationTime, String postNumber, String address, String addressDetail, boolean pet, String enter, String enterPassword, String special, String otherRequest, Integer price) {
            this.infoId = infoId;
            this.status = status;
            this.reservationId = reservationId;
            this.reservationDate = reservationDate;
            this.reservationTime = reservationTime;
            this.postNumber = postNumber;
            this.address = address;
            this.addressDetail = addressDetail;
            this.pet = pet;
            this.enter = enter;
            this.enterPassword = enterPassword;
            this.special = special;
            this.otherRequest = otherRequest;
            this.price = price;
        }
    }
}


