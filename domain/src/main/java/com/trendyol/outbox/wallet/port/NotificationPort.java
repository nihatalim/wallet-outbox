package com.trendyol.outbox.wallet.port;

import com.trendyol.outbox.wallet.model.Notification;

public interface NotificationPort {
    void send(Notification notificationModel);
}

