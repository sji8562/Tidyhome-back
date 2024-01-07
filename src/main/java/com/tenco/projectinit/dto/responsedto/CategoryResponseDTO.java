package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

import java.util.List;

public class CategoryResponseDTO {

    @Data
    public static class FirstCategoryListDTO{
        private List<FirstCategoryDTO> firstCategories;

        public FirstCategoryListDTO(List<FirstCategoryDTO> firstCategories) {
            this.firstCategories = firstCategories;
        }
    }


    @Data
    public static class FirstCategoryDTO{
        private Integer id;
        private String name;

        public FirstCategoryDTO(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
