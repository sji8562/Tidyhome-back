package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception400;
import com.tenco.projectinit._core.utils.JwtTokenUtils;
import com.tenco.projectinit.dto.UserResponseDTO;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.repository.inteface.UserJPARepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserJPARepository userJPARepository;
    @Autowired
    private HttpSession session;
    public UserResponseDTO.TokenDTO login(UserResponseDTO.LoginDTO loginDTO) {
        log.info("tel = {}", loginDTO.getTel());
        User user = userJPARepository.findByTel(loginDTO.getTel());
        if (user == null) {
            System.out.println("로그인 서비스 : 존재하지 않는 아이디 입니다");
            throw new Exception400("존재하지 않는 아이디 입니다.");
        }
        System.out.println("로그인 서비스 : 성공");
        User userPS = UserResponseDTO.UserPSDTO.hideUserPS(user);
        return new UserResponseDTO.TokenDTO(JwtTokenUtils.create(userPS), userPS);


    }
}
