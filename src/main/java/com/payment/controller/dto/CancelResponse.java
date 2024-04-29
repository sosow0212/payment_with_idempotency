package com.payment.controller.dto;

import com.payment.domain.CancelPayment;

public record CancelResponse(
        Long memberId,
        String idempotency,
        Long orderId
) {

    public static CancelResponse from(final CancelPayment cancelPayment) {
        return new CancelResponse(
                cancelPayment.getMemberId(),
                cancelPayment.getIdempotency(),
                cancelPayment.getOrderId()
        );
    }
}
