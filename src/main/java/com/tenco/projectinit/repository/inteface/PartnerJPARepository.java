package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.dto.mng.PartnerRequestDTO;
import com.tenco.projectinit.repository.entity.Partner;

import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PartnerJPARepository extends JpaRepository<Partner, Integer> {
    Page<Partner> findByUsernameContaining(String keyword, Pageable pageable);



//    @Modifying
//    @Transactional
//    @Query(value = "update Partner p set p.username = :username, p.tel = :tel, p.gender = :gender , p.categoryId = :categoryId where p.id = :id")
//    void updateByPartnerId(Optional<Partner>  partner);

//    void updateByPartnerId(@Param("id") Integer id,@Param("username") String username,@Param("tel") String tel,@Param("categoryId") String temp);
}
