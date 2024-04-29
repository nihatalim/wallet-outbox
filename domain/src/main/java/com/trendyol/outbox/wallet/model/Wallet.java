package com.trendyol.outbox.wallet.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Wallet {
    private Long id;
    private Long memberId;
    private BigDecimal amount;
    private Long version;

    public void addAmount(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }
}
