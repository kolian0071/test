package com.nikfrolkov.exchange_rate_in_gif.client;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface Giphy {
    ResponseEntity<Map> getRandomGif(String api_key, String tag);

}
