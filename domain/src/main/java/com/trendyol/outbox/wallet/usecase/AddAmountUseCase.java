package com.trendyol.outbox.wallet.usecase;

import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class AddAmountUseCase {
    Long memberId;
    BigDecimal amount;
}
