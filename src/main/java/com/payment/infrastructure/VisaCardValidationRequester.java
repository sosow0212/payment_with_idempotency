package com.payment.infrastructure;

import com.payment.domain.vo.Card;
import com.payment.service.CardValidationRequester;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class VisaCardValidationRequester implements CardValidationRequester {

    private RestTemplate restTemplate;

    @Override
    public void validate(final Card card) {
        // card 유효성 검사
    }
}
