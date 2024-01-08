package com.tenco.projectinit.dto.responsedto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.util.List;

public class OptionResponseDTO {
    @Data
    public static class OptionDetail {
        private List<OptionPrice> optionPrices;

        public OptionDetail(List<OptionPrice> optionPrices) {
            this.optionPrices = optionPrices;
        }
    }

    @Data
    public static class OptionPrice {
        private Integer id;
        private String name;
        private Integer price;

        public OptionPrice(Integer id, String name, Integer price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
}
