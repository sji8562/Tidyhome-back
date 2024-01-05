package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception400;
import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit._core.utils.JwtTokenUtils;
import com.tenco.projectinit.dto.UserResponseDTO;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.repository.inteface.UserJPARepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserJPARepository userJPARepository;
    @Autowired
    private HttpSession session;
    // 로그인
    public UserResponseDTO.TokenDTO login(UserResponseDTO.LoginDTO loginDTO) {
        log.info("tel = {}", loginDTO.getTel());
        Optional<User> optUser = userJPARepository.findByTel(loginDTO.getTel());
        if (optUser.isEmpty()) {
            System.out.println("로그인 서비스 : 존재하지 않는 아이디 입니다");
            throw new Exception400("존재하지 않는 아이디 입니다.");
        }
        System.out.println("로그인 서비스 : 성공");
        User user = optUser.get();
        return new UserResponseDTO.TokenDTO(JwtTokenUtils.create(user), user);
    }
    // 회원탈퇴
    public void delete(UserResponseDTO.LoginDTO loginDTO) {
        String loginId = loginDTO.getTel();
        Optional<User> optionalUser = userJPARepository.findByTel(loginId);

        if (optionalUser.isPresent()) {
            // 사용자가 존재하면 삭제
            userJPARepository.delete(optionalUser.get());
        } else {
            // 사용자가 존재하지 않으면 예외를 던지거나 적절한 처리를 수행합니다.
            throw new Exception400("삭제할 사용자를 찾을 수 없습니다.");
        }
    }

    public String check(String tel) {
        System.out.println("여기 들어오지 ?");
        Optional<User> user = userJPARepository.findByTel(tel);
        System.out.println("여기 들어오지 ?");
         if( user != null|| !user.isEmpty()){
            throw new Exception500("이미 사용중인 번호입니다.");
         }
        System.out.println("여기 들어오지 ?");
        Random random = new Random(9);
         int rand = 0;
         String key = null;
        for (int i = 0; i < 6; i++) {
            rand = random.nextInt();
            key += rand;
        }
        return key;
    }
    @Transactional
    public void join(UserResponseDTO.JoinDTO joinDTO) {
        // 1. 회원가입시 아이디 중복 체크
        Optional<User> existingUser = userJPARepository.findByTel(joinDTO.getTel());
        if (existingUser.isPresent()) {
            throw new Exception400("중복된 아이디입니다.");
        }
        // 2. 전화번호 형식 유효성 검사 (11자리 여부 확인)
        String tel = joinDTO.getTel();
        if (tel == null || tel.length() != 11) {
            throw new Exception400("전화번호는 11자리여야 합니다.");
        }
        // 3. 디비 저장
        User newUser = User.builder()
                .tel(joinDTO.getTel())
                .build();
        User savedUser = userJPARepository.save(newUser);
    }

}
