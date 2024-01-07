package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.FirstCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstCategoryJPARepository extends JpaRepository<FirstCategory, Integer> {
}
