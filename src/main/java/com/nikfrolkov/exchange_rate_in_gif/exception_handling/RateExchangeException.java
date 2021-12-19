package com.nikfrolkov.exchange_rate_in_gif.exception_handling;

public class RateExchangeException extends RuntimeException {

    public RateExchangeException(String message) {
        super(message);
    }
}
