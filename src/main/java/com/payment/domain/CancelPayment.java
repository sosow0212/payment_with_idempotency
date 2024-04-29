package com.payment.domain;

import com.payment.domain.service.IdempotencyValidator;
import com.payment.domain.vo.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class CancelPayment {

    @Id
    private Long id;

    @Column(nullable = false)
    private String idempotency;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public static CancelPayment createStatusOfProgress(
            final String idempotency,
            final Long memberId,
            final Long orderId,
            final IdempotencyValidator idempotencyValidator
    ) {
        idempotencyValidator.isValidRule(idempotency);
        return CancelPayment.builder()
                .idempotency(idempotency)
                .memberId(memberId)
                .orderId(orderId)
                .status(Status.PROGRESS)
                .build();
    }
}
