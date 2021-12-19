package com.nikfrolkov.exchange_rate_in_gif.controller;

import com.nikfrolkov.exchange_rate_in_gif.AbstractGifTest;
import com.nikfrolkov.exchange_rate_in_gif.controller.dto.DataDto;
import com.nikfrolkov.exchange_rate_in_gif.controller.dto.GifResponse;
import com.nikfrolkov.exchange_rate_in_gif.service.GifService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ControllerGifTest extends AbstractGifTest {

    @MockBean
    GifService gifService;

    @Test
    void getGifByCurrencyTest() {

        GifResponse gifResponse = new GifResponse(
                new DataDto("some_type", "some_title", "some_url"), "some_tag"
        );

        Mockito.when(gifService.getGif("some_currency")).thenReturn(gifResponse);

        assertNotNull(gifResponse.getData());
        assertEquals("some_type", gifResponse.getData().getType());
        assertEquals("some_url", gifResponse.getData().getUrl());
        assertEquals("some_title", gifResponse.getData().getTitle());
        assertEquals("some_tag", gifResponse.getTag());
    }
}
