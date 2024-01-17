package com.tenco.projectinit._core.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.entity.User;

import java.time.Instant;

public class JwtTokenUtils {

    public static String create(User user) {
        String jwt = JWT.create()
                .withSubject("tok-key") // 해당 토큰 이름 정하는 메소드
                .withClaim("id", user.getId()) // 페이로드에 담길 정보(인증된 회원의 유효한 정보 담을 수 있음)
                .withClaim("loginId", user.getTel())
                .withExpiresAt(Instant.now().plusMillis(1000 * 60 * 60 * 24 * 7L)) // 해당 토큰 유효기간 만료 정하는 메소드
                .sign(Algorithm.HMAC512("tenco")); // 비밀 키 값을 입력하여 어떤 알고리즘으로 암호화할지 결정
        return jwt;
    }
    public static String create(Partner partner) {
        String jwt = JWT.create()
                .withSubject("tok-key") // 해당 토큰 이름 정하는 메소드
                .withClaim("id", partner.getId()) // 페이로드에 담길 정보(인증된 회원의 유효한 정보 담을 수 있음)
                .withClaim("loginId", partner.getTel())
                .withClaim("username",partner.getUsername())
                .withClaim("categoryId",partner.getCategoryId())
                .withClaim("location",partner.getLocation())
                .withClaim("picUrl",partner.getPicUrl())
                .withExpiresAt(Instant.now().plusMillis(1000 * 60 * 60 * 24 * 7L)) // 해당 토큰 유효기간 만료 정하는 메소드
                .sign(Algorithm.HMAC512("tenco")); // 비밀 키 값을 입력하여 어떤 알고리즘으로 암호화할지 결정
        return jwt;
    }

    public static String createMockUser() {
        String jwt = JWT.create()
                .withSubject("tok-key")
                .withClaim("id", 1)
                .withClaim("tel", "1234")
                .withExpiresAt(Instant.now().plusMillis(1000 * 60 * 60 * 24 * 7L*31))
                .sign(Algorithm.HMAC512("tenco"));
        return jwt;
    }
    public static String createMockPartner() {
        String jwt = JWT.create()
                .withSubject("tok-key") // 해당 토큰 이름 정하는 메소드
                .withClaim("id", 1) // 페이로드에 담길 정보(인증된 회원의 유효한 정보 담을 수 있음)
                .withClaim("loginId", 1234)
                .withClaim("username","타이디홈")
                .withClaim("categoryId","1,2")
                .withClaim("location","금정구, 해운대구")
                .withClaim("picUrl","null")
                .withExpiresAt(Instant.now().plusMillis(1000 * 60 * 60 * 24 * 7L)) // 해당 토큰 유효기간 만료 정하는 메소드
                .sign(Algorithm.HMAC512("tenco")); // 비밀 키 값을 입력하여 어떤 알고리즘으로 암호화할지 결정
        return jwt;
    }

    public static DecodedJWT verify(String jwt)
            throws SignatureVerificationException, TokenExpiredException {
        jwt = jwt.replace("Bearer ", "");

        // JWT를 검증한 후, 검증이 완료되면, header, payload를 base64로 복호화함.
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("tenco"))
                .build().verify(jwt);
        return decodedJWT;
    }

}