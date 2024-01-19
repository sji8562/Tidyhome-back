package com.tenco.projectinit.dto.mng;

import com.tenco.projectinit.repository.entity.Sale;
import com.tenco.projectinit.repository.entity.sub_entity.Reservation;
import lombok.Data;

import java.util.List;

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

    @Data
    public static class MngTotalDTO{
        private List<MngMonthDTO> mngMonthDTO;
        private Integer payOff;

    }
    @Data
    public static class MngMonthDTO{
        private Integer month;
        private Integer totalSales;
        private Integer count;

        public MngMonthDTO(Integer month, Long totalSales, Long count) {
            this.month = month;
            this.totalSales = totalSales.intValue();
            this.count = count.intValue();
        }
    }


}
