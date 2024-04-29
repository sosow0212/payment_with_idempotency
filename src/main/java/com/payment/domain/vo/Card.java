package com.payment.domain.vo;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Card {

    private final int number;
    private final int expirationYear;
    private final int expirationMonth;
    private final int password;

    private Card(final int number, final int expirationYear, final int expirationMonth, final int password) {
        this.number = number;
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
        this.password = password;
    }

    public static Card createWithValidateDate(final int number, final int expirationYear, final int expirationMonth, final int password) {
        validateExpirationDate(expirationYear, expirationMonth);
        return new Card(
                number,
                expirationYear,
                expirationMonth,
                password
        );
    }

    private static void validateExpirationDate(final int expirationYear, final int expirationMonth) {
        LocalDateTime serverLocalDate = LocalDateTime.now();
        LocalDateTime userCardExpirationDate = LocalDateTime.of(expirationYear, expirationMonth, 1, 0, 0);

        if (serverLocalDate.isAfter(userCardExpirationDate)) {
            throw new IllegalArgumentException("유저 카드가 만료되었습니다.");
        }
    }
}
