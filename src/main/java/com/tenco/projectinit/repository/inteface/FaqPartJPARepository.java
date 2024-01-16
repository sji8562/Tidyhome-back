package com.tenco.projectinit.repository.inteface;


import com.tenco.projectinit.dto.responsedto.FaqPartResponseDTO;
import com.tenco.projectinit.repository.entity.FaqPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FaqPartJPARepository extends JpaRepository<FaqPart, Integer> {

}