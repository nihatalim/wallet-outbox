package com.trendyol.outbox.common.outbox.scheduled;

import com.trendyol.outbox.common.outbox.entity.OutboxEntity;
import com.trendyol.outbox.common.outbox.entity.Status;
import com.trendyol.outbox.common.outbox.jpa.OutboxRepository;
import com.trendyol.outbox.wallet.model.NotificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddAmountOutboxScheduler {

    private final OutboxRepository outboxRepository;

    @Scheduled(fixedDelay = 1000)
    public void handle() {
        log.info("AddAmountOutboxScheduler started {}", LocalDateTime.now());

        List<OutboxEntity> outboxEntities = outboxRepository.findByOperationTypeAndStatusAndRetryCountIsLessThan(NotificationType.WALLET_ADD_AMOUNT.toString(), Status.WAITING.name(), 10, 100);

        for (OutboxEntity outboxEntity : outboxEntities) {
            try {
                log.info(outboxEntity.getPayload());
                outboxEntity.setStatus(Status.SENT);
                outboxRepository.save(outboxEntity);
            } catch (Exception ex) {
                outboxEntity.increaseRetryCount();
                outboxRepository.save(outboxEntity);
            }
        }

        log.info("AddAmountOutboxScheduler finished {}", LocalDateTime.now());
    }
}
