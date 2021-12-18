package com.nikfrolkov.exchange_rate_in_gif.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRatesClientDTO {
    private String disclaimer;
    private String license;
    private Integer timestamp;
    private String base;
    private Map<String, BigDecimal> rates;
}
