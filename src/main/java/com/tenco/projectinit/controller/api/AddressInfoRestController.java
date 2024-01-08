package com.tenco.projectinit.controller.api;

import com.tenco.projectinit.dto.responsedto.AddressInfoResponseDTO;
import com.tenco.projectinit.repository.entity.AddressInfo;
import com.tenco.projectinit.service.AddressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressInfoRestController {

    @Autowired
    private AddressInfoService addressInfoService;

    @PostMapping("/add")
    public ResponseEntity<String> addAddressInfo(@RequestBody AddressInfoResponseDTO request, @RequestParam int userId) {
       addressInfoService.addAddress(request, userId);
       return ResponseEntity.ok("주소가 성공적으로 추가되었습니다.");

    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<AddressInfo>> getAddressList(@PathVariable int userId) {
        List<AddressInfo> addressList = addressInfoService.getAddress(userId);
        return ResponseEntity.ok(addressList);
    }
}
