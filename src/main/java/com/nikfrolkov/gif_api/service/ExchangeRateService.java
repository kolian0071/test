package com.nikfrolkov.gif_api.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ExchangeRateService {

    BigDecimal getRate(LocalDate date, String currency);
}
