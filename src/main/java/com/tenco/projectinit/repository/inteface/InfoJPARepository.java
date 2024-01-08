package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoJPARepository extends JpaRepository<Info, Integer> {
}
