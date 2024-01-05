package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.SmsCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SmsCodeJPARepository extends JpaRepository<SmsCode, Integer> {
    Optional<SmsCode> findByTel(String tel);
}
