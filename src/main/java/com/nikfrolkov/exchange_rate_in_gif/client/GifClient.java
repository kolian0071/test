package com.nikfrolkov.exchange_rate_in_gif.client;

import com.nikfrolkov.exchange_rate_in_gif.controller.dto.GifResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gif-api", url = "${gif-api.url}")
public interface GifClient {

    @GetMapping("/random")
    GifResponse getRandomGif(@RequestParam("api_key") String api_key, @RequestParam("tag") String tag);

}
