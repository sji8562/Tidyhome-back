package com.tenco.projectinit.controller.api;

import com.tenco.projectinit.repository.entity.Card;
import com.tenco.projectinit.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payment")
public class PaymentRestController {
    @Autowired
    PaymentService paymentService;

    // 카드 등록
    @PostMapping
    public ResponseEntity<Card> registerPayment(@RequestBody Card card) {
        Card saveCard = paymentService.saveCard(card);
        return new ResponseEntity<>(saveCard, HttpStatus.CREATED);
    }

    // 카드 목록
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Card>> getUserCard(@PathVariable Integer userId) {
        List<Card> userCard = paymentService.getUserCard(userId);
        return new ResponseEntity<>(userCard, HttpStatus.OK);
    }

}
