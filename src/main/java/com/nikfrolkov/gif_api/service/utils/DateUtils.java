package com.nikfrolkov.gif_api.service.utils;

import java.time.LocalDate;

public class DateUtils {

    public static LocalDate today() {
        return LocalDate.now();
    }

    public static LocalDate yesterday() {
        return LocalDate.now().minusDays(1);
    }
}
