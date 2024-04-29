package com.payment.domain.event;

public record CreatedPaymentEvent(
        String idempotency,
        Long orderId
) {
}
