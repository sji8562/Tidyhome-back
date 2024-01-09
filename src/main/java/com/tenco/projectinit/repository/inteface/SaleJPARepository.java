package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleJPARepository extends JpaRepository<Sale, Integer> {
}
