package com.nikfrolkov.exchange_rate_in_gif.exception_handling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateErrorResponse {
    private LocalDateTime dateTime;
    private String message;
}
