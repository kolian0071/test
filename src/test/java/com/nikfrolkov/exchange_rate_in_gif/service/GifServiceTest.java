package com.nikfrolkov.exchange_rate_in_gif.service;

import com.nikfrolkov.exchange_rate_in_gif.AbstractGifTest;
import com.nikfrolkov.exchange_rate_in_gif.client.GifClient;
import com.nikfrolkov.exchange_rate_in_gif.controller.dto.DataDto;
import com.nikfrolkov.exchange_rate_in_gif.controller.dto.GifResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GifServiceTest extends AbstractGifTest {

    @MockBean
    private ExchangeRateService rateService;

    @MockBean
    private GifClient gifClient;

    @Autowired
    private GifService gifService;


    @Test
    void getRichGif() {
        Mockito.when(rateService.getRate(Mockito.any(), Mockito.anyString()))
                .thenReturn(BigDecimal.valueOf(74.35))
                .thenReturn(BigDecimal.valueOf(73.35));

        GifResponse gifResponse = new GifResponse(
                new DataDto("some_type", "some_title", "some_url"), "rich"
        );

        Mockito.when(gifClient.getRandomGif(Mockito.any(), Mockito.anyString()))
                .thenReturn(gifResponse);

        GifResponse response = gifService.getGif("RUB");

        assertNotNull(response.getData());
        assertEquals("some_type", response.getData().getType());
        assertEquals("some_url", response.getData().getUrl());
        assertEquals("some_title", response.getData().getTitle());
        assertEquals("rich", response.getTag());
    }

    @Test
    void getBrokeGif() {
        Mockito.when(rateService.getRate(Mockito.any(), Mockito.anyString()))
                .thenReturn(BigDecimal.valueOf(73.35))
                .thenReturn(BigDecimal.valueOf(74.35));

        GifResponse gifResponse = new GifResponse(
                new DataDto("some_type", "some_title", "some_url"), "broke"
        );

        Mockito.when(gifClient.getRandomGif(Mockito.any(), Mockito.anyString()))
                .thenReturn(gifResponse);

        GifResponse response = gifService.getGif("RUB");

        assertNotNull(response.getData());
        assertEquals("some_type", response.getData().getType());
        assertEquals("some_url", response.getData().getUrl());
        assertEquals("some_title", response.getData().getTitle());
        assertEquals("broke", response.getTag());
    }
}