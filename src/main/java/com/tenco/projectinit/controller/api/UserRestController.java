package com.tenco.projectinit.controller.api;

import com.tenco.projectinit._core.utils.ApiUtils;
import com.tenco.projectinit.dto.UserResponseDTO;
import com.tenco.projectinit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserRestController {

    @Autowired
    private UserService userService;
    private String fromNumber = "";
    private String APIKEY = "";
    private String APISECRETKEY = "";
    private String uri = "https://api.coolsms.co.kr";
    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserResponseDTO.LoginDTO loginDTO){
         UserResponseDTO.TokenDTO tokenDTO =  userService.login(loginDTO);
        return ResponseEntity.ok().header("Authorization", "Bearer " + tokenDTO.getJwt())
                .body(ApiUtils.success((tokenDTO.getUser())));
    }

    // 회원가입
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserResponseDTO.JoinDTO joinDTO){
        userService.join(joinDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiUtils.success(null));
    }
    // 회원탈퇴
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody UserResponseDTO.LoginDTO loginDTO){
        userService.delete(loginDTO);
        return ResponseEntity.ok().body(ApiUtils.success(null));
    }
    @GetMapping("/check/{tel}")
    public ResponseEntity<?> check(@PathVariable String tel){
        System.out.println("여기 들어오지 ?");
        userService.check(tel);
        System.out.println(userService.check(tel));
//        return ResponseEntity.ok().body(ApiUtils.success());
        return null;
    }
}
