package com.trendyol.outbox.wallet.adapter.wallet;

import com.trendyol.outbox.common.BaseRepository;

import java.util.Optional;

public interface WalletRepository extends BaseRepository<WalletEntity> {
    Optional<WalletEntity> findByMemberId(Long memberId);
}
