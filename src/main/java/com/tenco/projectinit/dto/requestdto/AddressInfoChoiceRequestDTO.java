package com.tenco.projectinit.dto.requestdto;


import com.tenco.projectinit.repository.entity.AddressInfo;
import lombok.Data;

@Data
public class AddressInfoChoiceRequestDTO {
    private Integer userId;
    private Integer addressInfoId;
}
