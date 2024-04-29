package com.trendyol.outbox.wallet.adapter.wallet;

import com.trendyol.outbox.common.BaseEntity;
import com.trendyol.outbox.wallet.model.Wallet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wallet")
@EqualsAndHashCode(callSuper = true)
@SequenceGenerator(name = "id_generator", sequenceName = "seq_wallet")
public class WalletEntity extends BaseEntity {

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "current_amount", nullable = false)
    private BigDecimal currentAmount;

    @Version
    private Long version;

    public static WalletEntity of(Wallet wallet) {
        return WalletEntity.builder()
                .id(wallet.getId())
                .memberId(wallet.getMemberId())
                .currentAmount(wallet.getAmount())
                .version(wallet.getVersion())
                .build();
    }

    public Wallet to() {
        return Wallet.builder()
                .id(getId())
                .memberId(getMemberId())
                .amount(getCurrentAmount())
                .version(getVersion())
                .build();
    }
}