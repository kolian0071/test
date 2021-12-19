package com.nikfrolkov.exchange_rate_in_gif.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GifResponse {
    private DataDto data;
    private String tag;
}
