package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.errors.exception.Exception401;
import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.requestdto.AddressInfoChoiceRequestDTO;
import com.tenco.projectinit.dto.responsedto.AddressInfoResponseDTO;
import com.tenco.projectinit.repository.entity.AddressInfo;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.service.AddressInfoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressInfoRestController {

    @Autowired
    private AddressInfoService addressInfoService;

    @Autowired
    private HttpSession session;
    // 주소 추가
    @PostMapping("/add")
    public ResponseEntity<?> addAddressInfo(@RequestBody AddressInfoResponseDTO request) {
        if(session == null){
            throw new Exception401("로그인 하고 오세요");
        }
        User sessionUser = (User) session.getAttribute("sessionUser");
      AddressInfo addressInfo = addressInfoService.addAddress(request, sessionUser.getId());
       return ResponseEntity.status(HttpStatus.CREATED).body(ApiUtils.success(addressInfo));
    }

    // 주소 목록
    @GetMapping("/list/{userId}")
    public ResponseEntity<?> getAddressList(@PathVariable int userId) {
        List<AddressInfo> addressList = addressInfoService.getAddress(userId);
        return ResponseEntity.ok().body(ApiUtils.success(addressList));
    }

    // 대표 주소 등록
    @PostMapping("/add/first-address")
    public ResponseEntity<?> addFirstAddressInfo(@RequestBody AddressInfoChoiceRequestDTO request) {
        addressInfoService.setFirstAddress(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiUtils.success(null));
    }
}
