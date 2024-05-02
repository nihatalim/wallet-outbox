package com.trendyol.outbox.wallet.rest;

import com.trendyol.outbox.wallet.rest.dto.AddAmountRequest;
import com.trendyol.outbox.wallet.usecase.AddAmountUseCase;
import com.trendyol.outbox.wallet.usecase.addamount.AddAmountUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletRestController {

    private final AddAmountUseCaseHandler addAmountUseCaseHandler;

    @PutMapping("/amount/{memberId}")
    void addAmount(@RequestBody @Valid AddAmountRequest addAmountRequest, @PathVariable Long memberId) {
        var addAmountUseCase = addAmountRequest.to(memberId);
        addAmountUseCaseHandler.handle(addAmountUseCase);
    }
}
