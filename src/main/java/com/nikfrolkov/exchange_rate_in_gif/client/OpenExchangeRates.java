package com.nikfrolkov.exchange_rate_in_gif.client;

import com.nikfrolkov.exchange_rate_in_gif.client.dto.ExchangeRatesClientDTO;

public interface OpenExchangeRates {
    ExchangeRatesClientDTO getLatestRate(String app_id);

    ExchangeRatesClientDTO getHistoricalRate(String date, String app_id);
}
