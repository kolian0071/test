package com.nikfrolkov.exchange_rate_in_gif.exception_handling;

public class NoSuchExchangeRatesException extends RuntimeException {

    public NoSuchExchangeRatesException(String message) {
        super(message);
    }
}
