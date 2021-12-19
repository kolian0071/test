package com.nikfrolkov.exchange_rate_in_gif.service.utils;

import com.nikfrolkov.exchange_rate_in_gif.AbstractGifTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateUtilsGifTest extends AbstractGifTest {

    @Test
    void today() {
        assertEquals(LocalDate.now(), DateUtils.today());
    }

    @Test
    void yesterday() {
        assertEquals(LocalDate.now().minusDays(1), DateUtils.yesterday());
    }
}