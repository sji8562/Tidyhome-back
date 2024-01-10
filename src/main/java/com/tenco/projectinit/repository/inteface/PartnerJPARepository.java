package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.dto.mng.PartnerRequestDTO;
import com.tenco.projectinit.repository.entity.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartnerJPARepository extends JpaRepository<Partner, Integer> {
    Page<Partner> findByUsernameContaining(String keyword, Pageable pageable);


//    int updateByPartnerId(Partner partner);
}
