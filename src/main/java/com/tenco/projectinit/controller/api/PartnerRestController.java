package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.PartnerRequestDTO;
import com.tenco.projectinit.dto.requestdto.UserRequestDTO;
import com.tenco.projectinit.dto.responsedto.PartnerResponseDTO;
import com.tenco.projectinit.dto.responsedto.UserResponseDTO;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.service.PartnerService;
import com.tenco.projectinit.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerRestController {

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private HttpSession session;


    @PostMapping("/sms-send")
    public ResponseEntity<?> sms(@RequestBody UserRequestDTO.SmsSendDTO smsSendDTO){
        partnerService.sendSms(smsSendDTO.getTel());
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }

    //인증번호 확인
    @PostMapping("/sms-check")
    public ResponseEntity<?> smsCheck(@RequestBody UserRequestDTO.SmsCheckDTO smsCheckDTO){
        partnerService.smsCheck(smsCheckDTO.getTel(), smsCheckDTO.getCode());
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }



    @PostMapping("/login")
    public ResponseEntity<?> join(@Valid @RequestBody PartnerRequestDTO.JoinDTO joinDTO) {
        PartnerResponseDTO.TokenDTO tokenDTO = partnerService.join(joinDTO);
        session.setAttribute("partner", tokenDTO.getPartner());
        return ResponseEntity.status(HttpStatus.CREATED).header("Authorization", "Bearer " + tokenDTO.getJwt())
                .body(ApiUtils.success(tokenDTO.getPartner()));
    }

    // 파트너 가입
    @PostMapping("/partner-info")
    public ResponseEntity<?> partnerInfo(@RequestBody UserRequestDTO.partnerDTO partnerDTO,
                                         HttpServletRequest httpServletRequest) {
//        HttpSession session = httpServletRequest.getSession();
//        Partner partner = (Partner) session.getAttribute("sessionPartner");
        partnerService.updatePartner(1, partnerDTO);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }
}
