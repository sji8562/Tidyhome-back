package com.tenco.projectinit.repository.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int id;
    private String loginId;
    private String password;
}
