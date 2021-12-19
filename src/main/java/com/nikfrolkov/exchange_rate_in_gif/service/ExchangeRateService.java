package com.nikfrolkov.exchange_rate_in_gif.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ExchangeRateService {

    BigDecimal getRate(LocalDate date, String currency);
}
