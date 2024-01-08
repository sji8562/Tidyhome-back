package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Integer> {
    Optional<User> findByTel(String tel);



    Page<User> findByTelContaining(String keyword, Pageable pageable);
}
