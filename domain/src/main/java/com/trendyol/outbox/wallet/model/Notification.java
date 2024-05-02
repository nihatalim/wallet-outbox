package com.trendyol.outbox.wallet.model;

import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class Notification {
    Long id;
    BigDecimal amount;
    NotificationType notificationType;
    String message;
}
