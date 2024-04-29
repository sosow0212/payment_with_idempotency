package com.payment.domain;

import com.payment.domain.vo.Card;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CardTest {

    @Test
    void 만료일이_지나면_예외_발생한다() {
        // when & then
        assertThatThrownBy(() -> new Card(1234, 1999, 02, 01))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
