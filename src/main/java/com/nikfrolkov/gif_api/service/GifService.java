package com.nikfrolkov.gif_api.service;

import com.nikfrolkov.gif_api.controller.dto.GifResponse;

public interface GifService {
    GifResponse getGif(String currency);
}
