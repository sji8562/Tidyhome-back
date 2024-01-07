package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.sub_entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionJPARepository extends JpaRepository<Option, Integer> {
}
