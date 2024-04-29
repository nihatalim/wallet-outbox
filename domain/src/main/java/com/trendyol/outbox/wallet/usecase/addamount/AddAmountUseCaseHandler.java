package com.trendyol.outbox.wallet.usecase.addamount;

import com.trendyol.outbox.wallet.model.NotificationModel;
import com.trendyol.outbox.wallet.model.Wallet;
import com.trendyol.outbox.common.DomainComponent;
import com.trendyol.outbox.common.exception.WalletBusinessException;
import com.trendyol.outbox.wallet.port.NotificationPort;
import com.trendyol.outbox.wallet.port.WalletPort;
import com.trendyol.outbox.wallet.usecase.AddAmountUseCase;

@DomainComponent
public class AddAmountUseCaseHandler {
    private final WalletPort walletPort;
    private final NotificationPort notificationPort;

    public AddAmountUseCaseHandler(WalletPort walletPort, NotificationPort notificationPort) {
        this.walletPort = walletPort;
        this.notificationPort = notificationPort;
    }

    public void handle(AddAmountUseCase useCase) {
        Wallet wallet = walletPort.getWalletById(useCase.getMemberId()).orElseThrow(() -> new WalletBusinessException("wallet.not.found"));
        wallet.addAmount(useCase.getAmount());
        walletPort.save(wallet);

        notificationPort.notify(NotificationModel.of(useCase.getMemberId(), "wallet.amount.update"));
    }
}
