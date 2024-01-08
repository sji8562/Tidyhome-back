package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception400;
import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit._core.utils.JwtTokenUtils;
import com.tenco.projectinit.dto.requestdto.UserRequestDTO;
import com.tenco.projectinit.dto.responsedto.UserResponseDTO;
import com.tenco.projectinit.repository.entity.SmsCode;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.repository.inteface.SmsCodeJPARepository;
import com.tenco.projectinit.repository.inteface.UserJPARepository;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private UserJPARepository userJPARepository;
    @Autowired
    private HttpSession session;

    @Autowired
    private SmsCodeJPARepository smsCodeJPARepository;

    @Value("${sms.api.key}")
    private String apiKey;

    @Value("${sms.api.secret}")
    private String apiSecret;

    private DefaultMessageService messageService;


    @PostConstruct
    private void init() {
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecret, "https://api.coolsms.co.kr");
    }

    // 로그인
    public UserResponseDTO.TokenDTO login(UserRequestDTO.LoginDTO loginDTO) {
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
    public void delete(UserRequestDTO.LoginDTO loginDTO) {
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


    @Transactional
    public void join(UserRequestDTO.JoinDTO joinDTO) {

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

//        3. sms인증코드 인증확인
        SmsCode smsCode = smsCodeJPARepository.findByTel(joinDTO.getTel()).orElseThrow(() -> new Exception400("휴대폰번호 인증을해주세요"));
        if (!smsCode.isChecked()) {
            throw new Exception400("인증되지 않았습니다");
        }

        // 3. 디비 저장
        User newUser = User.builder()
                .tel(joinDTO.getTel())
                .build();
        User savedUser = userJPARepository.save(newUser);
//        smsCodeJPARepository.delete(smsCode);
    }

    @Transactional
    public void sendSms(String tel) {
        Optional<SmsCode> optCode = smsCodeJPARepository.findByTel(tel);
        optCode.ifPresent((smsCode -> {
            smsCodeJPARepository.delete(smsCode);
        }));
        SmsCode smsCode = new SmsCode(tel);

        Message message = new Message();
        message.setFrom("01093971773");
        message.setTo(tel);
        message.setText(smsCode.getCode());

        messageService.sendOne(new SingleMessageSendingRequest(message));
        smsCodeJPARepository.save(smsCode);

    }

    @Transactional
    public void smsCheck(String tel, String code) {
        Optional<SmsCode> optCode = smsCodeJPARepository.findByTel(tel);
        if (optCode.isEmpty()) {
            throw new Exception400("인증코드를 입력하여주세요");
        }

        SmsCode smsCode = optCode.get();
        if (!smsCode.getCode().equals(code)) {
            throw new Exception400("인증코드가 다릅니다");
        }
        if (smsCode.getExpiry().isBefore(LocalDateTime.now())) {
            smsCodeJPARepository.delete(smsCode);
            throw new Exception400("인증기한이 만료되었습니다");
        }
        smsCode.check();
    }

    public List<User> findAll() {
        List<User> userList = userJPARepository.findAll();
        return userList;
    }
}
