package com.payment.service;

import com.payment.domain.vo.Card;

public interface CardValidationRequester {

    void validate(final Card card);
}
