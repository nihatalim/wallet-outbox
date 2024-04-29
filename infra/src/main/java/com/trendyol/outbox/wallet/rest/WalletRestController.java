package com.trendyol.outbox.wallet.rest;

import com.trendyol.outbox.wallet.usecase.AddAmountUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletRestController {
    private final

    @PostMapping("/amount/{memberId}")
    void addAmount(@RequestBody AddAmountUseCase addAmountUseCase) {

    }
}
