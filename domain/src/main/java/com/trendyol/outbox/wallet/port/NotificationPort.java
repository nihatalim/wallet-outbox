package com.trendyol.outbox.wallet.port;

import com.trendyol.outbox.wallet.model.NotificationModel;

public interface NotificationPort {
    void notify(NotificationModel notificationModel);
}

