package com.trendyol.outbox.wallet.rest.dto;

import com.trendyol.outbox.wallet.usecase.AddAmountUseCase;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class AddAmountRequest {

    @Positive
    private BigDecimal amount;

    public AddAmountUseCase to(Long memberId) {
        return AddAmountUseCase.of(memberId,amount);
    }
}
