package com.nikfrolkov.exchange_rate_in_gif.service;

import com.nikfrolkov.exchange_rate_in_gif.controller.dto.GifResponse;

public interface GifService {
    GifResponse getGif(String currency);
}
