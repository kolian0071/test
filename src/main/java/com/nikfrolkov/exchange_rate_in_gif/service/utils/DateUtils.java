package com.nikfrolkov.exchange_rate_in_gif.service.utils;

import java.time.LocalDate;

public class DateUtils {

    public static LocalDate today() {
        return LocalDate.now();
    }

    public static LocalDate yesterday() {
        return LocalDate.now().minusDays(1);
    }
}
