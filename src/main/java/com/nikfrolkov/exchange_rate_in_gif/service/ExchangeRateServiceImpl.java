package com.nikfrolkov.exchange_rate_in_gif.service;

import com.nikfrolkov.exchange_rate_in_gif.client.OpenExchangeRatesClient;
import com.nikfrolkov.exchange_rate_in_gif.service.model.ExchangeRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final OpenExchangeRatesClient openExchangeRatesClient;

    @Value("${openexchangerates.app_id}")
    private String app_id;

    @Autowired
    public ExchangeRateServiceImpl(OpenExchangeRatesClient client) {
        this.openExchangeRatesClient = client;
    }

    public double getTodayExcangeRate(String currency) {
        ExchangeRates todayExcangeRates = openExchangeRatesClient.getHistoricalRate(Date.getToday().toString(), app_id);
        return todayExcangeRates.getRates().get(currency);
    }

    public double getYesterdayExcangeRate(String currency) {
        ExchangeRates yesterdayExcangeRates = openExchangeRatesClient.getHistoricalRate(Date.getYesterday().toString(), app_id);
        return yesterdayExcangeRates.getRates().get(currency);
    }

    public String getGifTag(double todayExchangeRate, double yesterdayExchangeRate) {
        String gifTag;
        if (todayExchangeRate > yesterdayExchangeRate) {
            gifTag = "rich";
        } else {
            gifTag = "broke";
        }
        return gifTag;
    }


    public String getGifTag(String currency) {
        double todayExchangeRate = getTodayExcangeRate(currency);
        double yesterdayExchangeRate = getYesterdayExcangeRate(currency);
        return getGifTag(todayExchangeRate, yesterdayExchangeRate);
    }
}
