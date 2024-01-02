package com.tenco.projectinit._core.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tenco.projectinit.repository.entity.User;

import java.time.Instant;

public class JwtTokenUtils {

    public static String create(User user) {
        String jwt = JWT.create()
                .withSubject("tok-key") // 해당 토큰 이름 정하는 메소드
                .withClaim("id", user.getId()) // 페이로드에 담길 정보(인증된 회원의 유효한 정보 담을 수 있음)
                .withClaim("loginId", user.getLoginId())
                .withExpiresAt(Instant.now().plusMillis(1000 * 60 * 60 * 24 * 7L)) // 해당 토큰 유효기간 만료 정하는 메소드
                .sign(Algorithm.HMAC512("meta")); // 비밀 키 값을 입력하여 어떤 알고리즘으로 암호화할지 결정
        return jwt;
    }

    public static String createMockUser() {
        String jwt = JWT.create()
                .withSubject("tok-key")
                .withClaim("id", 1)
                .withClaim("email", "ssar@nate.com")
                .withExpiresAt(Instant.now().plusMillis(1000 * 60 * 60 * 24 * 7L))
                .sign(Algorithm.HMAC512("meta"));
        return jwt;
    }

    public static DecodedJWT verify(String jwt)
            throws SignatureVerificationException, TokenExpiredException {
        jwt = jwt.replace("Bearer ", "");

        // JWT를 검증한 후, 검증이 완료되면, header, payload를 base64로 복호화함.
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("meta"))
                .build().verify(jwt);
        return decodedJWT;
    }

}