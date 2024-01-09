package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.KakaoPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KakaoPaymentJPARepository extends JpaRepository<KakaoPayment, Integer> {
}
