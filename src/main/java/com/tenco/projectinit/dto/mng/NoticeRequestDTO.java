package com.tenco.projectinit.dto.mng;

import lombok.Data;

public class NoticeRequestDTO {
    @Data
    public static class NoticeSaveDTO{
        private String title;
        private String content;
    }
    @Data
    public static class NoticeUpdateDTO{
        private Integer id;
        private String title;
        private String content;
    }

}
