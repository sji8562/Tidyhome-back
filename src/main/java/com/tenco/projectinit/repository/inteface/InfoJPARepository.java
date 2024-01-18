package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.dto.responsedto.ReservationDetailResponseDTO;
import com.tenco.projectinit.repository.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InfoJPARepository extends JpaRepository<Info, Integer> {
    @Query("SELECT i FROM Info i WHERE i.id IN (SELECT r.info.id FROM Reservation r WHERE r.id = :reservationId)")
    Info findByReservationId(@Param("reservationId") Integer reservationId);



}
