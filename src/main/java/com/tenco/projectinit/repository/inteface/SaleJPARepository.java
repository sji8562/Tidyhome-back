package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaleJPARepository extends JpaRepository<Sale, Integer> {
    // 결제 내역 목록
    @Query("SELECT s FROM Sale s JOIN FETCH s.user")
    List<Sale> findAllSalesWithUsers();

    // 카테고리 이름
//    @Query("SELECT fc.name " +
//            "FROM FirstCategory fc " +
//            "JOIN SecondCategory sc ON fc.id = sc.firstCategory.id " +
//            "JOIN Option o ON sc.id = o.secondCategory.id " +
//            "JOIN Info i ON o.id = i.option.id " +
//            "JOIN Reservation r ON i.id = r.info.id " +
//            "JOIN Sale s ON r.sale.id = s.id " +
//            "WHERE s.id = :saleId")
//    String findFirstCategoryNameBySaleId(Integer saleId);
}
