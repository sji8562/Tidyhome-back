package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.dto.responsedto.ReservationDetailResponseDTO;
import com.tenco.projectinit.repository.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InfoJPARepository extends JpaRepository<Info, Integer> {

}
