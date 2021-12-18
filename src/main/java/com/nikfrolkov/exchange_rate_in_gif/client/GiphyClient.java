package com.nikfrolkov.exchange_rate_in_gif.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "gifs-api", url = "${giphy.url}")
public interface GiphyClient extends Giphy {

    @GetMapping("/random")
    ResponseEntity<Map> getRandomGif(@RequestParam("api_key") String api_key, @RequestParam("tag") String tag);

}
