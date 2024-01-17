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

        public FaqJoinPartDTO(Integer faqId, String name, Integer partId, String title, String content, Integer code) {
            this.faqId = faqId;
            this.name = name;
            this.partId = partId;
            this.title = title;
            this.content = content;
            this.code = code;
        }
    }
}
