package com.payment.infrastructure;

import com.payment.domain.service.IdempotencyValidator;
import com.payment.exception.IdempotencyInvalidRuleException;
import org.springframework.stereotype.Component;

@Component
public class IdempotencyDefaultRuleValidator implements IdempotencyValidator {

    private static final String DEFAULT_PREFIX = "toss";
    private static final int DEFAULT_RULE_LENGTH = 8;

    @Override
    public void isValidRule(final String idempotency) {
        if (!isValidPrefix(idempotency) || !isValidLength(idempotency)) {
            throw new IdempotencyInvalidRuleException();
        }
    }

    private static boolean isValidPrefix(final String idempotency) {
        return idempotency.startsWith(DEFAULT_PREFIX);
    }

    private static boolean isValidLength(final String idempotency) {
        return idempotency.length() == DEFAULT_RULE_LENGTH;
    }
}
