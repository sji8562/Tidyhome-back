package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerJPARepository extends JpaRepository<Partner, Integer> {
    Page<Partner> findByUsernameContaining(String keyword, Pageable pageable);
}