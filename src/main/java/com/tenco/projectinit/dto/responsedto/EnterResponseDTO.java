package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

@Data
public class EnterResponseDTO {
    private String enter;
    private String enterPassword;

    public EnterResponseDTO(String enter, String enterPassword) {
        this.enter = enter;
        this.enterPassword = enterPassword;
    }
}
