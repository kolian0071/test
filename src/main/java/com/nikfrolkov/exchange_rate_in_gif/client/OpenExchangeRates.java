package com.nikfrolkov.exchange_rate_in_gif.client;

import com.nikfrolkov.exchange_rate_in_gif.service.model.ExchangeRates;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface OpenExchangeRates {
    ExchangeRates getLatestRate(String app_id);

    ExchangeRates getHistoricalRate(String date, String app_id);
}
