package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.Cancel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancelJPARepository extends JpaRepository<Cancel, Integer> {
}
