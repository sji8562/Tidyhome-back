package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.KakaoPaymentRequestDTO;
import com.tenco.projectinit.dto.responsedto.KakaoPaymentResponseDTO;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.service.KakaoPaymentServiece;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class KaokaopayRestController {

    @Autowired
    private KakaoPaymentServiece kakaoPaymentServiece;

    @PostMapping("/ready")
    public ResponseEntity<?> kakaoPayReady(@RequestBody KakaoPaymentRequestDTO.KakaoReadyDTO kakaoReadyDTO ,HttpSession session) {
        Integer reservationId = kakaoReadyDTO.getReservationId();
        User sessionUser = (User) session.getAttribute("sessionUser");
      KakaoPaymentResponseDTO.KakaoReadyDTO kakaoPay = kakaoPaymentServiece.kakaoPayReady(sessionUser.getId(), reservationId);
        return ResponseEntity.ok().body(ApiUtils.success(kakaoPay));
    }
    // 아이디 찾아서 그걸로 가격을 꺼내라

    @PostMapping("/approve")
    public ResponseEntity<?> kakaoPayApprove(@RequestBody KakaoPaymentRequestDTO.KakaoApproveDTO kakaoApproveDTO, HttpSession session){
        User sessionUser = (User) session.getAttribute("sessionUser");
        KakaoPaymentResponseDTO.KakaoApproveResponse kakaoApproveResponse = kakaoPaymentServiece.kakaoPayApprove(kakaoApproveDTO, sessionUser.getId());
        return ResponseEntity.ok().body(ApiUtils.success(kakaoApproveResponse));
    }
}
