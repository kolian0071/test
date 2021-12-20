package com.nikfrolkov.gif_api.controller.dto;

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
