package com.nikfrolkov.exchange_rate_in_gif.service;

import com.nikfrolkov.exchange_rate_in_gif.client.ExchangeRateClient;
import com.nikfrolkov.exchange_rate_in_gif.client.dto.ExchangeRateDto;
import com.nikfrolkov.exchange_rate_in_gif.exception_handling.RateExchangeException;
import com.nikfrolkov.exchange_rate_in_gif.service.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Value("${rates-api.app_id}")
    private String app_id;

    @Value("${rates-api.base_currency}")
    private String baseCurrency;

    private final ExchangeRateClient exchangeRateClient;

    public BigDecimal getRate(LocalDate date, String currency) {
        BigDecimal exchangeRate;
        try {
            exchangeRate = getExchangeRate(DateUtils.today(), currency);
        } catch (Exception exception) {
            throw new RateExchangeException("Can not get exchange rate");
        }
        return exchangeRate;
    }

    private BigDecimal getExchangeRate(LocalDate date, String currency) {
        ExchangeRateDto exchangeRateDto = exchangeRateClient
                .getHistoricalRate(date.toString(), app_id, baseCurrency, currency);
        return exchangeRateDto.getRates().get(currency);
    }
}
