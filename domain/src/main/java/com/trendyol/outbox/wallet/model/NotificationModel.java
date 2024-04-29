package com.trendyol.outbox.wallet.model;

import lombok.Value;

@Value(staticConstructor = "of")
public class NotificationModel {
    Long memberId;
    String message;
}
