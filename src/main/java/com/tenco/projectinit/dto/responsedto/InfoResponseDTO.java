package com.tenco.projectinit.dto.responsedto;

import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import lombok.Data;

public class InfoResponseDTO {

    @Data
    public static class InfoDTO {
        private ReservationInfoDTO reservationInfoDTO;
        private EnterDTO enterDTO;
        private RequestDTO requestDTO;
        private PaymentDTO paymentDTO;

        public InfoDTO(ReservationInfoDTO reservationInfoDTO, EnterDTO enterDTO, RequestDTO requestDTO, PaymentDTO paymentDTO) {
            this.reservationInfoDTO = reservationInfoDTO;
            this.enterDTO = enterDTO;
            this.requestDTO = requestDTO;
            this.paymentDTO = paymentDTO;
        }
    }

    @Data
    public static class ReservationInfoDTO {
        private Integer infoId;
        private Integer reservationId;
        private String schedule;
        private String reservationDate;
        private String reservationTime;
        private String postNumber;
        private String address;
        private String addressDetail;
        private boolean pet;
        private Integer price;

        public ReservationInfoDTO(Integer infoId, Integer reservationId, String schedule, String reservationDate, String reservationTime, String postNumber, String address, String addressDetail, boolean pet, Integer price) {
            this.infoId = infoId;
            this.reservationId = reservationId;
            this.schedule = schedule;
            this.reservationDate = reservationDate;
            this.reservationTime = reservationTime;
            this.postNumber = postNumber;
            this.address = address;
            this.addressDetail = addressDetail;
            this.pet = pet;
            this.price = price;
        }
    }

    @Data
    public static class EnterDTO {
        private Integer enterId;
        private String enter;
        private String password;

        public EnterDTO(Integer enterId, String enter, String password) {
            this.enterId = enterId;
            this.enter = enter;
            this.password = password;
        }
    }

    @Data
    public static class RequestDTO {
        private Integer requestId;
        private String special;
        private String etc;

        public RequestDTO(Integer requestId, String special, String etc) {
            this.requestId = requestId;
            this.special = special;
            this.etc = etc;
        }
    }

    @Data
    public static class PaymentDTO {
        private Integer reservationSucId;
        private Integer saleId;
        private String tid;
        private Integer price;
        private String PaymentMeans; // 결제 수단(카카오)

        public PaymentDTO(Integer reservationSucId, Integer saleId, String tid, Integer price) {
            this.reservationSucId = reservationSucId;
            this.saleId = saleId;
            this.tid = tid;
            this.price = price;
            this.PaymentMeans = "카카오";
        }
    }


}