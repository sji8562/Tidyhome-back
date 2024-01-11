package com.tenco.projectinit.dto.mng;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

public class PartnerRequestDTO {
    @Data
    public static class UpdateDTO{
        private Integer id;
        private String username;
        private String businessNumber;
        private String tel;
        private String picUrl;
        private String category;
    }
}
