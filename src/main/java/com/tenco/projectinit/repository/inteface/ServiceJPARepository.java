package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceJPARepository extends JpaRepository<Services,Integer> {


}
