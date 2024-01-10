package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

public class ReservationResponseDTO {
    @Data
    public static class ReservationDTO{
        private Integer reservationId;

        public ReservationDTO(Integer reservationId) {
            this.reservationId = reservationId;
        }
    }

    @Data
    public static class ReservationSuccessDTO{
        private Integer reservationSuccessId;

        public ReservationSuccessDTO(Integer reservationSuccessId) {
            this.reservationSuccessId = reservationSuccessId;
        }
    }
}
