package com.tenco.projectinit.dto.mng;

import lombok.Data;

public class FaqResponseDTO {
    @Data
    public static class FaqListDTO {
        private Integer id;
        private String name;
        private String title;
        private Integer code;

        public FaqListDTO(Integer id, String name, String title, Integer code) {
            this.id = id;
            this.name = name;
            this.title = title;
            this.code = code;
        }
    }
}
