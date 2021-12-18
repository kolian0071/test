package com.nikfrolkov.exchange_rate_in_gif.service;

import com.nikfrolkov.exchange_rate_in_gif.client.OpenExchangeRatesClient;
import com.nikfrolkov.exchange_rate_in_gif.service.converter.ExchangeRatesConverter;
import com.nikfrolkov.exchange_rate_in_gif.service.model.ExchangeRates;
import com.nikfrolkov.exchange_rate_in_gif.service.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final OpenExchangeRatesClient openExchangeRatesClient;
    private final ExchangeRatesConverter exchangeRatesConverter;

    @Value("${openexchangerates.app_id}")
    private String app_id;

    @Autowired
    public ExchangeRateServiceImpl(OpenExchangeRatesClient client, ExchangeRatesConverter exchangeRatesConverter) {
        this.openExchangeRatesClient = client;
        this.exchangeRatesConverter = exchangeRatesConverter;
    }

    private BigDecimal getTodayExcangeRate(String currency) {
        ExchangeRates todayExcangeRates = exchangeRatesConverter.mapToExchangeRates(openExchangeRatesClient
                .getHistoricalRate(DateUtils.today().toString(), app_id));
        return todayExcangeRates.getRates().get(currency);
    }

    private BigDecimal getYesterdayExcangeRate(String currency) {
        ExchangeRates yesterdayExcangeRates = exchangeRatesConverter.mapToExchangeRates(openExchangeRatesClient
                .getHistoricalRate(DateUtils.yesterday().toString(), app_id));
        return yesterdayExcangeRates.getRates().get(currency);
    }

    private String getGifTag(BigDecimal todayExchangeRate, BigDecimal yesterdayExchangeRate) {
        String gifTag;
        if (todayExchangeRate.compareTo(yesterdayExchangeRate) > 0) {
            gifTag = "rich";
        } else {
            gifTag = "broke";
        }
        return gifTag;
    }


    public String getGifTag(String currency) {
        BigDecimal todayExchangeRate = getTodayExcangeRate(currency);
        BigDecimal yesterdayExchangeRate = getYesterdayExcangeRate(currency);
        return getGifTag(todayExchangeRate, yesterdayExchangeRate);
    }
}
