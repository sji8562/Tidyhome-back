package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.ReservationRequestDTO;
import com.tenco.projectinit.dto.responsedto.ReservationResponseDTO;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.service.SaleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor

public class SaleRestController {

    private final SaleService saleService;

    // 결제정보 저장
    @PostMapping("/save")
    public ResponseEntity<?> savePayment(@RequestBody ReservationRequestDTO.ReservationSuccessDTO successDTO, HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        User sessionUser = (User) session.getAttribute("sessionUser");
        Integer saleId = saleService.savePayment(successDTO, sessionUser.getId());
        System.out.println("세선유저 :" +sessionUser);
        return ResponseEntity.ok().body(ApiUtils.success(new ReservationResponseDTO.ReservationSuccessDTO(saleId)));
    }
}
