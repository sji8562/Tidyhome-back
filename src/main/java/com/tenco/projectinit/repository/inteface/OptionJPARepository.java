package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.sub_entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionJPARepository extends JpaRepository<Option, Integer> {
    List<Option> findBySecondCategoryId(Integer secondCategoryId);
}
