package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.sub_entity.Enter;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnterJPARepository extends JpaRepository<Enter, Integer> {
    @Query("SELECT e FROM Enter e " +
            "JOIN EtcInfo ei ON ei.id = e.etcInfo.id " +
            "JOIN Info i ON i.id = ei.info.id " +
            "JOIN Reservation r ON r.info.id = i.id " +
            "WHERE r.id = :reservationId")
    Optional<Enter> findEnterById(Integer reservationId);

}
