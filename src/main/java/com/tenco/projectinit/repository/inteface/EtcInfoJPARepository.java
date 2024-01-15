package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.EtcInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EtcInfoJPARepository extends JpaRepository<EtcInfo, Integer> {
    @Query("SELECT ei " +
            "FROM EtcInfo ei " +
            "JOIN Info i ON i.id = ei.info.id " +
            "JOIN Reservation r ON r.info.id = i.id " +
            "WHERE r.id = :reservationId")
   EtcInfo findEtcInfoIdByReservationId(@Param("reservationId") Integer reservationId);
}
