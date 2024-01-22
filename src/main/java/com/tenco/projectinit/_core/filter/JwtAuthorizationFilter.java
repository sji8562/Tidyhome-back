package com.tenco.projectinit._core.filter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenco.projectinit._core.errors.exception.Exception401;
import com.tenco.projectinit._core.utils.JwtTokenUtils;
import com.tenco.projectinit.repository.entity.Partner;
import com.tenco.projectinit.repository.entity.User;
import com.tenco.projectinit.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.io.IOException;
import java.io.PrintWriter;

public class JwtAuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        AntPathMatcher antPathMatcher = new AntPathMatcher();
        if (
                !(request.getRequestURI().equals("/api/users/login")
                        || antPathMatcher.match("/h2-console/**", request.getRequestURI())
                        || antPathMatcher.match("/assets/**", request.getRequestURI())
                        || antPathMatcher.match("/images/**", request.getRequestURI())
                        || antPathMatcher.match("/api/users/sms-send", request.getRequestURI())
                        || antPathMatcher.match("/api/users/sms-check", request.getRequestURI())
                        || antPathMatcher.match("/reservation/**", request.getRequestURI())
                        || antPathMatcher.match("/api/partner/login", request.getRequestURI())
                )
        ) {
            String jwt = request.getHeader("Authorization");
            if (jwt == null || jwt.isEmpty()) {
                onError(response, "토큰이 없습니다");
                return;
            }

            try {
                DecodedJWT decodedJWT = JwtTokenUtils.verify(jwt);
                int id = decodedJWT.getClaim("id").asInt();
                System.out.println("id값 잘 가져오나? " + id);
                String userId = decodedJWT.getClaim("tel").asString();
                System.out.println("userId값 잘 가져오나? " + userId);
                HttpSession session = request.getSession();
                System.out.println("세션 안에 뭐있나---------------");
                System.out.println(session.toString());
                System.out.println(session);

                User sessionUser = User.builder().id(id).tel(userId).build();
                session.setAttribute("sessionUser", sessionUser);

            } catch (SignatureVerificationException | JWTDecodeException e1) {
                onError(response, "토큰 검증 실패");
                return; // 에러가 발생하면 더 이상 진행하지 않도록 return 추가
            } catch (TokenExpiredException e2) {
                onError(response, "토큰 시간 만료");
                return; // 에러가 발생하면 더 이상 진행하지 않도록 return 추가
            }
        }

        chain.doFilter(request, response); // 이후의 처리는 필터 체인에 의해 다음 필터로 넘어가게 됨
    }

    private void onError(HttpServletResponse response, String msg) {
        Exception401 e401 = new Exception401(msg);

        try {
            String body = new ObjectMapper().writeValueAsString(e401.body());
            response.setStatus(e401.status().value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            PrintWriter out = response.getWriter();
            out.println(body);
        } catch (Exception e) {
            System.out.println("파싱 에러가 날 수 없음");
        }
    }
}