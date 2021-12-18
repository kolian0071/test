package com.nikfrolkov.exchange_rate_in_gif.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface GiphyService {
    ResponseEntity<Map> getGif(String gifTag);
}
