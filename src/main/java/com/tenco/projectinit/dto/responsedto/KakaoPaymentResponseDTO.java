package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

public class KakaoPaymentResponseDTO {
    @Data
    public static class KakaoReadyDTO {
        private String tid;
        private String nextRedirectMobileUrl; // 앱 url
        private String createdAt;
    }

    @Data
    public static class KakaoApproveResponse {

        private String aid; // 요청 고유 번호
        private String tid; // 결제 고유 번호
        private String cid; // 가맹점 코드
        private String sid; // 정기결제용 ID
        private String partnerOrderId; // 가맹점 주문 번호
        private String partnerUserId; // 가맹점 회원 id
        private String paymentMethodType; // 결제 수단
        private Amount amount; // 결제 금액 정보
        private String itemName; // 상품명
        private String itemCode; // 상품 코드
        private int quantity; // 상품 수량
        private String createdAt; // 결제 요청 시간
        private String approvedAt; // 결제 승인 시간
        private String payload; // 결제 승인 요청에 대해 저장 값, 요청 시 전달 내용
    }

    @Data
    public static class Amount {
        private int total; // 총 결제 금액
        private int tax_free; // 비과세 금액
        private int tax; // 부가세 금액
        private int point; // 사용한 포인트
        private int discount; // 할인금액
        private int green_deposit; // 컵 보증금
    }

    @Data
    public static class KakaoCancelDTO{
        private String aid; // 요청 고유 번호
        private String tid; // 결제 고유 번호
        private String cid; // 가맹점 코드
        private String sid; // 정기결제용 ID
        private String partnerOrderId; // 가맹점 주문 번호
        private String partnerUserId; // 가맹점 회원 id
        private String paymentMethodType; // 결제 수단
        private Amount amount; // 결제 금액 정보
        private String itemName; // 상품명
        private String itemCode; // 상품 코드
        private int quantity; // 상품 수량
        private String createdAt; // 결제 요청 시간
        private String approvedAt; // 결제 승인 시간
        private String payload; // 결제 승인 요청에 대해 저장 값, 요청 시 전달 내용
    }
}
