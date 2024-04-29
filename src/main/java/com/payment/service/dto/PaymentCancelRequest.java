package com.payment.service.dto;

public record PaymentCancelRequest(
        Long orderId,
        Long memberId
) {
}
