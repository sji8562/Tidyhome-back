package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

public class EnterResponseDTO {
    @Data
    public static class EnterDTO{
        private Integer enterId;
        private Integer etcInfo;
        private String enter;
        private String password;

        public EnterDTO(Integer enterId, Integer etcInfo, String enter, String password) {
            this.enterId = enterId;
            this.etcInfo = etcInfo;
            this.enter = enter;
            this.password = password;
        }
    }
}
