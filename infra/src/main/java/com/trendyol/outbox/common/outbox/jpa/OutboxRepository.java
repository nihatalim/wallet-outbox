package com.trendyol.outbox.common.outbox.jpa;

import com.trendyol.outbox.common.BaseRepository;
import com.trendyol.outbox.common.outbox.entity.OutboxEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OutboxRepository extends BaseRepository<OutboxEntity> {

    @Query(nativeQuery = true, value = "select * from outbox where operation_type = ?1 and status = ?2 and retry_count < ?3 order by id limit ?4")
    List<OutboxEntity> findByOperationTypeAndStatusAndRetryCountIsLessThan(String operationType, String status, Integer retryCount, Integer limit);
}
