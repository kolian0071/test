package com.nikfrolkov.exchange_rate_in_gif.service;

import java.time.LocalDate;

public class Date {
    public static LocalDate getToday() {
        return LocalDate.now();
    }

    public static LocalDate getYesterday() {
        return LocalDate.now().minusDays(1);
    }
}
