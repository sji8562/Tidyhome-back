package com.tenco.projectinit.dto.requestdto;

import lombok.Data;

public class EnterRequestDTO {
    @Data
    public static class EnterDTO{
        private Integer reservationId;
        private String enter;
        private String password;
    }

    @Data
    public static class EnterDeleteDTO{
        private Integer enterId;
    }
}
