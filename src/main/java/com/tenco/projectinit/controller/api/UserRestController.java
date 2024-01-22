package com.tenco.projectinit.controller.api;

import com.google.api.Http;
import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.responsedto.UserResponseDTO;
import com.tenco.projectinit.dto.requestdto.UserRequestDTO;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserRestController {


    private final UserService userService;
    private String fromNumber = "";
    private String APIKEY = "";
    private String APISECRETKEY = "";
    private String uri = "https://api.coolsms.co.kr";


    private final HttpSession session;

    // 인증번호 발송
    @PostMapping("/sms-send")
    public ResponseEntity<?> sms(@RequestBody UserRequestDTO.SmsSendDTO smsSendDTO){
        userService.sendSms(smsSendDTO.getTel());
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    //인증번호 확인
    @PostMapping("/sms-check")
    public ResponseEntity<?> smsCheck(@RequestBody UserRequestDTO.SmsCheckDTO smsCheckDTO){
        userService.smsCheck(smsCheckDTO.getTel(), smsCheckDTO.getCode());
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }
    // 회원가입 & 로그인
    @PostMapping("/login")
    public ResponseEntity<?> joinAndLogin(@Valid @RequestBody UserRequestDTO.JoinDTO joinDTO){
        UserResponseDTO.TokenDTO tokenDTO = userService.join(joinDTO);
        return ResponseEntity.status(HttpStatus.CREATED).header("Authorization", "Bearer " + tokenDTO.getJwt())
                .body(ApiUtils.success((tokenDTO.getUser())));
    }

    // 회원탈퇴
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        userService.delete(id);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

}
