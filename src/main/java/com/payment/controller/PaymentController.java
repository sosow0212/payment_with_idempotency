package com.payment.controller;

import com.payment.controller.dto.CancelResponse;
import com.payment.controller.dto.PayOrderResponse;
import com.payment.domain.CancelPayment;
import com.payment.domain.Payment;
import com.payment.service.PaymentService;
import com.payment.service.dto.PayOrderRequest;
import com.payment.service.dto.PaymentCancelRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payments")
    public ResponseEntity<PayOrderResponse> payOrder(
            @RequestHeader(name = "Idempotency-Key") final String idempotency,
            @RequestBody final PayOrderRequest payOrderRequest
    ) {
        Payment payment = paymentService.pay(idempotency, payOrderRequest);
        return ResponseEntity.ok(PayOrderResponse.from(payment));
    }

    @PostMapping("/payments/cancel")
    public ResponseEntity<CancelResponse> cancelOrder(
            @RequestHeader(name = "Idempotency-Key") final String idempotency,
            @RequestBody final PaymentCancelRequest paymentCancelRequest
    ) {
        CancelPayment cancel = paymentService.cancel(idempotency, paymentCancelRequest);
        return ResponseEntity.ok(CancelResponse.from(cancel));
    }
}
