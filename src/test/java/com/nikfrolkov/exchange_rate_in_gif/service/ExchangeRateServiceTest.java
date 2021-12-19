package com.nikfrolkov.exchange_rate_in_gif.service;

import com.nikfrolkov.exchange_rate_in_gif.AbstractGifTest;
import com.nikfrolkov.exchange_rate_in_gif.client.ExchangeRateClient;
import com.nikfrolkov.exchange_rate_in_gif.client.dto.ExchangeRateDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ExchangeRateServiceTest extends AbstractGifTest {

    @MockBean
    private ExchangeRateClient exchangeRateClient;

    @Test
    void getRate() {

        ExchangeRateDto exchangeRateDto = new ExchangeRateDto(
                Mockito.anyString(), Mockito.anyString(),Mockito.anyInt(), Mockito.anyString(), Mockito.anyMap());
        Mockito.when(exchangeRateClient.getHistoricalRate(
                Mockito.any(), Mockito.anyString(), Mockito.anyString(), "RUB"))
                .thenReturn((ExchangeRateDto) Mockito.doThrow(Exception.class));

        
    }
}
