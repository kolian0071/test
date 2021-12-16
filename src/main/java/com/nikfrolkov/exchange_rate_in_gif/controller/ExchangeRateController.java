package com.nikfrolkov.exchange_rate_in_gif.controller;

import com.nikfrolkov.exchange_rate_in_gif.client.ExchangeRatesClient;
import com.nikfrolkov.exchange_rate_in_gif.client.GifsClient;
import com.nikfrolkov.exchange_rate_in_gif.model.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ExchangeRateController {

    private ExchangeRatesClient exchangeRatesClient;

    @Autowired
    public ExchangeRateController(ExchangeRatesClient exchangeRatesClient, GifsClient gifsClient) {
        this.exchangeRatesClient = exchangeRatesClient;
    }

    @GetMapping("/latest/RUB")
    ResponseEntity<ExchangeRate> getLatestRate(){
        return ok(exchangeRatesClient.getLatestRate().getBody());
    }

    @GetMapping("/historical/RUB")
    ResponseEntity<ExchangeRate> getHistoricalRate(){
        return ok(exchangeRatesClient.getHistoricalRate().getBody());
    }
}
