package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.UserResponseDTO;
import com.tenco.projectinit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private  UserService userService;

    // 로그인
    @PostMapping("/api/users/login")
    public ResponseEntity<?> login(@RequestBody UserResponseDTO.LoginDTO loginDTO){
         UserResponseDTO.TokenDTO tokenDTO =  userService.login(loginDTO);
        return ResponseEntity.ok().header("Authorization", "Bearer " + tokenDTO.getJwt())
                .body(ApiUtils.success((tokenDTO.getUser())));
    }

}
