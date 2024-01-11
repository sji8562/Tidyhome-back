package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.KakaoPayment;
import com.tenco.projectinit.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KakaoPaymentJPARepository extends JpaRepository<KakaoPayment, Integer> {
    Optional<KakaoPayment> findByUser(User user);
}
