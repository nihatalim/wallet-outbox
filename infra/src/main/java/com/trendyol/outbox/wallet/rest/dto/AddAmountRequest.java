package com.trendyol.outbox.wallet.rest.dto;

import com.trendyol.outbox.wallet.usecase.AddAmountUseCase;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddAmountRequest {
    private Long memberId;
    private BigDecimal amount;

    public AddAmountUseCase to() {
        return AddAmountUseCase.of(memberId, amount);
    }
}
