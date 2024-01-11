package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.sub_entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestJPARepository extends JpaRepository <Request, Integer> {
    
}
