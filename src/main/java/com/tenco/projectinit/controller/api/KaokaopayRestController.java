package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.responsedto.KakaoPaymentResponseDTO;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.service.KakaoPaymentServiece;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class KaokaopayRestController {

    @Autowired
    private KakaoPaymentServiece kakaoPaymentServiece;

    @PostMapping("/ready")
    public ResponseEntity<?> kakaoPayReady(HttpSession session) {
        User sessionUser = (User) session.getAttribute("sessionUser");
      KakaoPaymentResponseDTO.KakaoReadyDTO kakaoPay = kakaoPaymentServiece.kakaoPayReady(sessionUser.getId());
        return ResponseEntity.ok().body(ApiUtils.success(kakaoPay));
    }

    @PostMapping("/approve")
    public ResponseEntity<?> kakaPayApprove(HttpSession session){
        //

        return ResponseEntity.ok().body(ApiUtils.success(null));
    }
}
