package com.tenco.projectinit.dto.requestdto;

import lombok.Data;

public class UserRequestDTO {
    @Data
    public static class SmsSendDTO{
         private String tel;
    }

    @Data
    public static class SmsCheckDTO{
        private String tel;
        private String code;
    }
}
