package com.tenco.projectinit.dto.mng;

import lombok.Data;

public class FaqResponseDTO {
    @Data
    public static class faqListDTO{
        private Integer id;
        private String name;
        private String title;
        private Integer code;
    }
}
