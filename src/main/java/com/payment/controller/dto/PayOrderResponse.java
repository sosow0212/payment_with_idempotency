package com.payment.controller.dto;

import com.payment.domain.Payment;

public record PayOrderResponse(
        Long memberId,
        String idempotency,
        Long orderId
) {

    public static PayOrderResponse from(final Payment payment) {
        return new PayOrderResponse(
                payment.getMemberId(),
                payment.getIdempotency(),
                payment.getOrderId()
        );
    }
}
