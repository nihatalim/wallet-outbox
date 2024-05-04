package com.trendyol.outbox.wallet.usecase.addamount;

import com.trendyol.outbox.common.DomainComponent;
import com.trendyol.outbox.wallet.model.Notification;
import com.trendyol.outbox.wallet.model.NotificationType;
import com.trendyol.outbox.wallet.model.Wallet;
import com.trendyol.outbox.wallet.port.NotificationPort;
import com.trendyol.outbox.wallet.port.WalletPort;
import com.trendyol.outbox.wallet.usecase.AddAmountUseCase;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class AddAmountUseCaseHandler {

    private final WalletPort walletPort;
    private final NotificationPort notificationPort;

    public void handle(AddAmountUseCase useCase) {
        Wallet wallet = walletPort.getWalletByMemberId(useCase.getMemberId()).orElseGet(() -> Wallet.of(useCase.getMemberId()));
        wallet.addAmount(useCase.getAmount());
        wallet = walletPort.save(wallet);

        notificationPort.send(Notification.of(wallet.getId(),wallet.getAmount(), NotificationType.WALLET_ADD_AMOUNT,"wallet.amount.update"));
    }
}
