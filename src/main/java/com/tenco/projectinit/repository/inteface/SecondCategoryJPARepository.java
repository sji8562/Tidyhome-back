package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.SecondCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecondCategoryJPARepository extends JpaRepository<SecondCategory, Integer> {
    List<SecondCategory> findByFirstCategoryId(Integer firstCategoryId);


}
