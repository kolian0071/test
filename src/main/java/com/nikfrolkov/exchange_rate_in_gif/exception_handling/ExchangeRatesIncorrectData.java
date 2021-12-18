package com.nikfrolkov.exchange_rate_in_gif.exception_handling;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExchangeRatesIncorrectData {
    private String info;
}
