package com.tenco.projectinit.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Entity
@Data
@NoArgsConstructor
public class SmsCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String tel;
    private LocalDateTime expiry;
    private boolean checked;
    public SmsCode(String tel) {
        this.tel = tel;
        this.code = createdRandomCode();
        this.expiry = LocalDateTime.now().plusMinutes(3L);
    }

    private String createdRandomCode(){
        Random random = new Random();
        int checkNum = random.nextInt(888888) + 111111;

        return String.valueOf(checkNum);
    }

    public void check(){
        this.checked = true;
    }

}
