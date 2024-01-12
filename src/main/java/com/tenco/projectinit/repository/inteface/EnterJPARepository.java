package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.sub_entity.Enter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterJPARepository extends JpaRepository<Enter, Integer> {
}
