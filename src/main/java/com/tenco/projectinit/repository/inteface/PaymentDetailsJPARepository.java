package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentDetailsJPARepository extends JpaRepository <PaymentDetails, Integer> {
    Optional<PaymentDetails> findByTid(String tid);
}
