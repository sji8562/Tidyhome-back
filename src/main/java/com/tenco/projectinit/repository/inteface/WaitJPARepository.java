package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.sub_entity.Wait;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaitJPARepository extends JpaRepository<Wait, Integer> {
    Wait findByReservationSuc_Reservation_Id(Integer reservationId);
}
