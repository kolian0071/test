package com.nikfrolkov.exchange_rate_in_gif.controller;

import com.nikfrolkov.exchange_rate_in_gif.service.ExchangeRateService;
import com.nikfrolkov.exchange_rate_in_gif.service.GiphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RESTController {

    private final ExchangeRateService exchangeRateService;
    private final GiphyService giphyService;

    @Autowired
    public RESTController(ExchangeRateService exchangeRateService, GiphyService giphyService) {
        this.exchangeRateService = exchangeRateService;
        this.giphyService = giphyService;
    }

    @GetMapping("/gif/{symbol}")
    public ResponseEntity<Map> getGifRich(@PathVariable("symbol") String currency) {
        ResponseEntity<Map> result = null;
        String gifTag = exchangeRateService.getGifTag(currency);
        result = giphyService.getGif(gifTag);
        return result;
    }

}
