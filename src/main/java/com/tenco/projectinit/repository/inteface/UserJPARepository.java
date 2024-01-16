package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<User, Integer> {
    Optional<User> findByTel(String tel);

    @Query(value = "select u.id,u.tel from User u where u.tel =:tel")
    User findByPhone(String tel);


    Page<User> findByTelContaining(String keyword, Pageable pageable);
}
