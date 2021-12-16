package com.nikfrolkov.exchange_rate_in_gif.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(value = "gifs-api", url = "https://api.giphy.com/v1/gifs")
public interface GifsClient {

    @GetMapping("/random?api_key=kpEF41jptjKmP5mx1lNI1MUg9iOH08RE&tag=rich")
    ResponseEntity<Map> getGifRich();
}
