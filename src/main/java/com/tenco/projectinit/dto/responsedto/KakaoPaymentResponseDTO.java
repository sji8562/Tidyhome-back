package com.tenco.projectinit.dto.responsedto;

import lombok.Data;

public class KakaoPaymentResponseDTO {
    @Data
    public static class KakaoReadyDTO {
        private String tid;
        private String nextRedirectMobileUrl; // 앱 url
        private String createdAt;

        public KakaoReadyDTO(String tid, String nextRedirectMobileUrl, String createdAt) {
            this.tid = tid;
            this.nextRedirectMobileUrl = nextRedirectMobileUrl;
            this.createdAt = createdAt;
        }
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

        public KakaoApproveResponse(String aid, String tid, String cid, String sid, String partnerOrderId, String partnerUserId, String paymentMethodType, Amount amount, String itemName, String itemCode, int quantity, String createdAt, String approvedAt, String payload) {
            this.aid = aid;
            this.tid = tid;
            this.cid = cid;
            this.sid = sid;
            this.partnerOrderId = partnerOrderId;
            this.partnerUserId = partnerUserId;
            this.paymentMethodType = paymentMethodType;
            this.amount = amount;
            this.itemName = itemName;
            this.itemCode = itemCode;
            this.quantity = quantity;
            this.createdAt = createdAt;
            this.approvedAt = approvedAt;
            this.payload = payload;
        }
    }

    @Data
    public static class Amount {
        private int total; // 총 결제 금액
        private int tax_free; // 비과세 금액
        private int tax; // 부가세 금액
        private int point; // 사용한 포인트
        private int discount; // 할인금액
        private int green_deposit; // 컵 보증금

        public Amount(int total, int tax_free, int tax, int point, int discount, int green_deposit) {
            this.total = total;
            this.tax_free = tax_free;
            this.tax = tax;
            this.point = point;
            this.discount = discount;
            this.green_deposit = green_deposit;
        }
    }

    @Data
    public static class KakaoCancleDTO {
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

        public KakaoCancleDTO(String aid, String tid, String cid, String sid, String partnerOrderId, String partnerUserId, String paymentMethodType, Amount amount, String itemName, String itemCode, int quantity, String createdAt, String approvedAt, String payload) {
            this.aid = aid;
            this.tid = tid;
            this.cid = cid;
            this.sid = sid;
            this.partnerOrderId = partnerOrderId;
            this.partnerUserId = partnerUserId;
            this.paymentMethodType = paymentMethodType;
            this.amount = amount;
            this.itemName = itemName;
            this.itemCode = itemCode;
            this.quantity = quantity;
            this.createdAt = createdAt;
            this.approvedAt = approvedAt;
            this.payload = payload;
        }
    }
}