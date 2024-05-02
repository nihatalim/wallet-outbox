package com.trendyol.outbox.common.outbox.adapter.entity;

import com.trendyol.outbox.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "outbox")
@EqualsAndHashCode(callSuper = true)
@SequenceGenerator(name = "id_generator", sequenceName = "seq_notify")
public class OutboxEntity extends BaseEntity {

    @Column(name = "payload",nullable = false)
    private String payload;

    @Column(name = "key")
    private String key;

    @Column(name = "correlation_id")
    private String correlationId;

    @Column(name = "operation_type")
    private String operationType;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "retry_count")
    private Integer retryCount;

    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;

    @Version
    private Long version;
}
