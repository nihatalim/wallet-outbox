package com.trendyol.outbox.wallet.adapter.wallet;

import com.trendyol.outbox.wallet.model.Wallet;
import com.trendyol.outbox.wallet.port.WalletPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WalletPortAdapter implements WalletPort {
    private final WalletRepository walletRepository;

    @Override
    public Optional<Wallet> getWalletById(Long walletId) {
        return walletRepository.findById(walletId).map(WalletEntity::to);
    }

    @Override
    public void save(Wallet wallet) {
        walletRepository.save(WalletEntity.of(wallet));
    }
}
