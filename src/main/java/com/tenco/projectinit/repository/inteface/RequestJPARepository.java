package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.sub_entity.Enter;
import com.tenco.projectinit.repository.entity.sub_entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RequestJPARepository extends JpaRepository <Request, Integer> {
    @Query("SELECT rq FROM Request rq " +
            "JOIN EtcInfo ei ON ei.id = rq.etcInfo.id " +
            "JOIN Info i ON i.id = ei.info.id " +
            "JOIN Reservation r ON r.info.id = i.id " +
            "WHERE r.id = :reservationId")
    Optional<Request> findEnterById(Integer reservationId);
}
