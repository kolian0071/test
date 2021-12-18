package com.nikfrolkov.exchange_rate_in_gif.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExchangeRatesGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExchangeRatesIncorrectData> handlerException(NoSuchExchangeRatesException exception) {
        ExchangeRatesIncorrectData data = new ExchangeRatesIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
