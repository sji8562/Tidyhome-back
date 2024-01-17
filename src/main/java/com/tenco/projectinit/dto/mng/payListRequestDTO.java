package com.tenco.projectinit.dto.mng;

import com.tenco.projectinit.repository.entity.Sale;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import lombok.Data;

public class payListRequestDTO {

    @Data
    public static class payListDTO {
        private Sale sale;
        private String categoryName;
        private String status;

        public payListDTO(Sale sale, Reservation reservation) {
            this.sale = sale;
            this.categoryName = reservation.getInfo().getOption().getSecondCategory().getFirstCategory().getName();
            this.status = reservation.statusToString();
        }
    }
}
