package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.SecondCategory;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SecondCategoryJPARepository extends JpaRepository<SecondCategory, Integer> {
    List<SecondCategory> findByFirstCategoryId(Integer firstCategoryId);


    SecondCategory findByFirstCategoryIdAndName(Integer firstCategoryId, String name);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO second_category_tb (first_category_id, name) VALUES (:fCategoryId, :name)",nativeQuery = true)
    int saveByFirstCategoryIdWithName(@Param("fCategoryId") Integer fCategoryId, @Param("name") String name);

    SecondCategory findById(int sId);
}
