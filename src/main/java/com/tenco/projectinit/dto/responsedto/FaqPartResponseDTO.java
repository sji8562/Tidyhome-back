package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

public class FaqPartResponseDTO {
    @Data
    public static class FaqJoinPartDTO{
        private Integer faqId;
        private String name;
        private Integer partId;
        private String title;
        private String content;
        private Integer code;
    }
}
