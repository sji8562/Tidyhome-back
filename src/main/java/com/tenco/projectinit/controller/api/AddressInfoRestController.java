package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.responsedto.AddressInfoResponseDTO;
import com.tenco.projectinit.repository.entity.AddressInfo;
import com.tenco.projectinit.service.AddressInfoService;
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

    // 주소 추가
    @PostMapping("/add")
    public ResponseEntity<?> addAddressInfo(@RequestBody AddressInfoResponseDTO request, @RequestParam int userId) {
       addressInfoService.addAddress(request, userId);
       return ResponseEntity.status(HttpStatus.CREATED).body(ApiUtils.success(null));
    }

    // 주소 목록
    @GetMapping("/list/{userId}")
    public ResponseEntity<?> getAddressList(@PathVariable int userId) {
        List<AddressInfo> addressList = addressInfoService.getAddress(userId);
        return ResponseEntity.ok().body(ApiUtils.success(addressList));
    }
}
