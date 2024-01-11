package com.tenco.projectinit.dto.mng;

import com.tenco.projectinit.repository.entity.Sale;
import lombok.Data;

public class payListRequestDTO {

    @Data
    public static class payListDTO {
        private Sale sale;
        private String categoryName;

        public payListDTO(Sale sale, String categoryName) {
            this.sale = sale;
            this.categoryName = categoryName;
        }
    }
}
