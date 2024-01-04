package com.tenco.projectinit.repository.inteface;

import com.tenco.projectinit.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Integer> {
    User findByTel(String tel);
}
