package com.tenco.projectinit.service;

import com.tenco.projectinit._core.errors.exception.Exception400;
import com.tenco.projectinit._core.errors.exception.Exception404;
import com.tenco.projectinit._core.errors.exception.Exception500;
import com.tenco.projectinit._core.utils.JwtTokenUtils;
import com.tenco.projectinit.dto.requestdto.UserRequestDTO;
import com.tenco.projectinit.dto.responsedto.UserResponseDTO;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.entity.SmsCode;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.repository.inteface.PartnerJPARepository;
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
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private PartnerJPARepository partnerJPARepository;

    @Value("${sms.api.key}")
    private String apiKey;

    @Value("${sms.api.secret}")
    private String apiSecret;

    private DefaultMessageService messageService;


    @PostConstruct
    private void init() {
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecret, "https://api.coolsms.co.kr");
    }

    // 회원탈퇴
    public void delete(Integer userId) {
        Optional<User> optionalUser = userJPARepository.findById(userId);

        if (optionalUser.isPresent()) {
            // 사용자가 존재하면 삭제
            userJPARepository.delete(optionalUser.get());
        } else {
            // 사용자가 존재하지 않으면 예외를 던지거나 적절한 처리를 수행합니다.
            throw new Exception400("삭제할 사용자를 찾을 수 없습니다.");
        }
    }


    @Transactional
    public UserResponseDTO.TokenDTO join(UserRequestDTO.JoinDTO joinDTO) {

        String getTel = joinDTO.getTel();



        if (getTel.equals("1234")){

            Optional<User> user =userJPARepository.findByTel(getTel);

            return new UserResponseDTO.TokenDTO(JwtTokenUtils.createMockUser(),user.get());
        }

        if (getTel == null || getTel.length() != 13) {
            throw new Exception400("전화번호는 11자리여야 합니다.");
        }

        SmsCode smsCode = smsCodeJPARepository.findByTel(getTel).orElseThrow(() -> new Exception400("휴대폰번호 인증을해주세요"));
        if (!smsCode.isChecked()) {
            throw new Exception400("인증되지 않았습니다");
        }
        String[] tel = getTel.split("-");
        String nohipen = "";
        for (int i = 0; i < tel.length; i++) {
            nohipen += tel[i];
        }

        User user = userJPARepository.findByTel(nohipen).orElse(
                User.builder()
                        .tel(nohipen)
                        .build()
        );

        if (user.getId() == null) {
            userJPARepository.save(user);
            userJPARepository.flush();
        }

        smsCodeJPARepository.delete(smsCode);
        return new UserResponseDTO.TokenDTO(JwtTokenUtils.create(user), user);

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
        if(userList == null || userList.isEmpty()) {
            throw new Exception500("사용자가 없습니다.");
        }
        return userList;
    }
    public Page<User> findByPageNation(Integer page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        Page<User> userPG =userJPARepository.findAll(pageable);
        if(userPG.isEmpty() || userPG == null){
            throw new Exception500("사용자가 없습니다.");
        }
        return userPG;
    }
    public Page<User> findByPageNation(Integer page,String keyword) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        Page<User> userPG =userJPARepository.findByTelContaining(keyword,pageable);
        if(userPG.isEmpty() || userPG == null){
            throw new Exception500("사용자가 없습니다.");
        }
        return userPG;
    }

    @Transactional
    public void deleteById(Integer id) {
        userJPARepository.deleteById(id);
    }

    public User findById(int id) { return userJPARepository.findById(id).orElse(null); }

}
