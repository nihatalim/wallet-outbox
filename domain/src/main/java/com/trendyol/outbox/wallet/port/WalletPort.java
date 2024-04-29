package com.trendyol.outbox.wallet.port;

import com.trendyol.outbox.wallet.model.Wallet;

import java.util.Optional;

public interface WalletPort {
    Optional<Wallet> getWalletById(Long walletId);

    void save(Wallet wallet);
}
