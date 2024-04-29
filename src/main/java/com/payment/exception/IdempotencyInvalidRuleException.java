package com.payment.exception;

public class IdempotencyInvalidRuleException extends RuntimeException {

    public IdempotencyInvalidRuleException() {
        super("멱등키가 잘못된 형식입니다.");
    }
}
