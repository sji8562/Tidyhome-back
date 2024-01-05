//package com.tenco.projectinit._core.utils;
//
//import net.nurigo.sdk.Coolsms;
//import net.nurigo.sdk.message.ServiceType;
//import net.nurigo.sdk.message.TemplateMessage;
//import net.nurigo.sdk.message.configs.Coolsms.Config;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Smsutils {
//
//    private final String apiKey = "YOUR_API_KEY";
//    private final String apiSecretKey = "YOUR_API_SECRET_KEY";
//
//    public void sendVerificationCode(String to, String verificationCode) {
//        Coolsms coolsms = new Coolsms(new Config(apiKey, apiSecretKey));
//
//        try {
//            TemplateMessage templateMessage = new TemplateMessage();
//            templateMessage.setTo(to);
//            templateMessage.setFrom("발신번호"); // 발신번호 설정
//            templateMessage.setType("SMS");
//            templateMessage.setTemplateId("템플릿ID");
//            templateMessage.setTemplateValue("{인증코드=" + verificationCode + "}");
//
//            // 메시지 발송
//            coolsms.send(templateMessage, ServiceType.SMS);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // 예외 처리 로직 추가
//        }
//    }
//}
