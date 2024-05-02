package com.trendyol.outbox.notification.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendyol.outbox.common.outbox.adapter.entity.OutboxEntity;
import com.trendyol.outbox.common.outbox.adapter.entity.Status;
import com.trendyol.outbox.common.outbox.adapter.jpa.OutboxRepository;
import com.trendyol.outbox.wallet.model.Notification;
import com.trendyol.outbox.wallet.port.NotificationPort;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationAdapter implements NotificationPort {

    private final OutboxRepository outboxRepository;

    @SneakyThrows
    @Override
    public void send(Notification notificationModel) {
        var outboxEntity = new OutboxEntity();
        ObjectMapper objectMapper = new ObjectMapper();


        outboxEntity.setKey(String.valueOf(notificationModel.getId()));
        outboxEntity.setStatus(Status.WAITING);
        outboxEntity.setCreatedDate(LocalDateTime.now());
        outboxEntity.setOperationType(notificationModel.getNotificationType().toString());
        outboxEntity.setRetryCount(0);
        outboxEntity.setCorrelationId(UUID.randomUUID().toString());
        outboxEntity.setPayload(objectMapper.writeValueAsString(notificationModel));
        outboxRepository.save(outboxEntity);
    }
}
