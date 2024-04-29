package com.payment.service.dto;

public record PayOrderRequest(
        Long orderId,
        String orderName,
        Integer amount,
        Long memberId,
        Integer cardNumber,
        Integer cardExpirationYear,
        Integer cardExpirationMonth,
        Integer cardPassword,
        Integer customerIdentityNumber
) {
}
