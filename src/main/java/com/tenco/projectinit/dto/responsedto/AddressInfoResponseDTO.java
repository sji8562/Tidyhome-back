package com.tenco.projectinit.dto.responsedto;

import com.tenco.projectinit.repository.entity.AddressInfo;
import com.tenco.projectinit.repository.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressInfoResponseDTO {

    private Integer id;
    private String address;
    private String addressDetail;
    private boolean choice;
    private Integer userId;


    public AddressInfo convertToAddressInfo(User user) {
        return AddressInfo.builder()
                .address(this.address)
                .addressDetail(this.addressDetail)
                .choice(this.choice)
                .user(user)
                .build();
    }
}

