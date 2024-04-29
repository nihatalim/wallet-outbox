package com.trendyol.outbox.common.exception;

public class WalletBusinessException extends RuntimeException {
    private final String key;
    private final String[] args;

    public WalletBusinessException(String key) {
        super(key);
        this.key = key;
        this.args = new String[0];
    }

    public WalletBusinessException(String key, String... args) {
        super(key);
        this.key = key;
        this.args = args;
    }

    public String getKey() {
        return key;
    }

    public String[] getArgs() {
        return args;
    }
}
