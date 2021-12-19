package com.nikfrolkov.exchange_rate_in_gif.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataDto {
    private String type;
    private String title;
    private String url;
}
