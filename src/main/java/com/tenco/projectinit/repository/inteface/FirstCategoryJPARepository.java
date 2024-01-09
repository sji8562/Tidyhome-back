package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.FirstCategory;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface FirstCategoryJPARepository extends JpaRepository<FirstCategory, Integer> {
    FirstCategory findByName(String fCategoryName);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO first_category_tb (name) VALUES (:name)", nativeQuery = true)
    int saveByName(String name);
}
