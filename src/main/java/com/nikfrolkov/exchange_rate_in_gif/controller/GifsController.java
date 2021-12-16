package com.nikfrolkov.exchange_rate_in_gif.controller;

import com.nikfrolkov.exchange_rate_in_gif.client.GifsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class GifsController {

    private GifsClient gifsClient;

    @Autowired
    public GifsController(GifsClient gifsClient) {
        this.gifsClient = gifsClient;
    }

    @GetMapping("/gif")
    ResponseEntity<Map> getGifRich(){
        return ok(gifsClient.getGifRich().getBody());
    }
}
