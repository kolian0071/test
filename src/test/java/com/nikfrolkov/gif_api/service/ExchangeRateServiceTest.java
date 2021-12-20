package com.nikfrolkov.gif_api.service;

import com.nikfrolkov.gif_api.AbstractGifTest;
import com.nikfrolkov.gif_api.client.ExchangeRateClient;
import com.nikfrolkov.gif_api.client.dto.ExchangeRateDto;
import com.nikfrolkov.gif_api.exception_handling.RateExchangeException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExchangeRateServiceTest extends AbstractGifTest {

    @MockBean
    private ExchangeRateClient exchangeRateClient;

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Test
    void getRate() {

        Map<String, BigDecimal> rates = new HashMap<>();
        rates.put("some_rate", BigDecimal.ONE);

        ExchangeRateDto exchangeRateDto = new ExchangeRateDto(
                "some_disclaimer", "some_license",11, "some_base", rates);

        Mockito.when(exchangeRateClient.getHistoricalRate(
                Mockito.any(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                .thenReturn(exchangeRateDto);

        assertThrows(RateExchangeException.class, () -> exchangeRateService.getRate(LocalDate.now(), "some_currency"));
    }
}