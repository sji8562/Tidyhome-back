package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.responsedto.UserResponseDTO;
import com.tenco.projectinit.dto.requestdto.UserRequestDTO;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;
    private String fromNumber = "";
    private String APIKEY = "";
    private String APISECRETKEY = "";
    private String uri = "https://api.coolsms.co.kr";

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
        System.out.println("로그인 여기까지");
        return ResponseEntity.status(HttpStatus.CREATED).header("Authorization", "Bearer " + tokenDTO.getJwt())
                .body(ApiUtils.success((tokenDTO.getUser())));
    }

    // 회원탈퇴
    @PostMapping("/delete")
    public ResponseEntity<?> delete(HttpSession session){
        User sessionUser = (User) session.getAttribute("sessionUser");
        userService.delete(sessionUser.getId());
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    // 파트너 가입
    @PostMapping("/partner-info")
    public ResponseEntity<?> partnerInfo(@RequestBody UserRequestDTO.partnerDTO partnerDTO,
        HttpServletRequest httpServletRequest) {
            HttpSession session = httpServletRequest.getSession();
            Partner partner = (Partner) session.getAttribute("sessionPartner");
            userService.updatePartner(partner.getId(), partnerDTO);
            return ResponseEntity.ok().body(ApiUtils.success(null));
    }
}
