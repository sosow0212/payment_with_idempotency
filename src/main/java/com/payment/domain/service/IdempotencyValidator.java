package com.payment.domain.service;

public interface IdempotencyValidator {

    void isValidRule(final String idempotency);
}
