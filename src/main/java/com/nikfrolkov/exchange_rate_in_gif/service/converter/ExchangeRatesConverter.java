package com.nikfrolkov.exchange_rate_in_gif.service.converter;

import com.nikfrolkov.exchange_rate_in_gif.client.dto.ExchangeRatesClientDTO;
import com.nikfrolkov.exchange_rate_in_gif.service.model.ExchangeRates;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRatesConverter {

    public ExchangeRates mapToExchangeRates(ExchangeRatesClientDTO exchangeRatesClientDTO) {
        return ExchangeRates.builder()
                .base(exchangeRatesClientDTO.getBase())
                .disclaimer(exchangeRatesClientDTO.getDisclaimer())
                .license(exchangeRatesClientDTO.getLicense())
                .rates(exchangeRatesClientDTO.getRates())
                .timestamp(exchangeRatesClientDTO.getTimestamp())
                .build();
    }

    public ExchangeRatesClientDTO mapToExchangeRatesClientDTO(ExchangeRates exchangeRates) {
        return ExchangeRatesClientDTO.builder()
                .base(exchangeRates.getBase())
                .disclaimer(exchangeRates.getDisclaimer())
                .license(exchangeRates.getLicense())
                .rates(exchangeRates.getRates())
                .timestamp(exchangeRates.getTimestamp())
                .build();
    }
}
