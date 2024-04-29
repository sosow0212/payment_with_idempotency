package com.payment.domain.event;

public record CanceledPaymentEvent(
        String idempotency,
        Long orderId
) {
}
