package com.nikfrolkov.exchange_rate_in_gif.controller;

import com.nikfrolkov.exchange_rate_in_gif.AbstractGifTest;
import com.nikfrolkov.exchange_rate_in_gif.controller.dto.DataDto;
import com.nikfrolkov.exchange_rate_in_gif.controller.dto.GifResponse;
import com.nikfrolkov.exchange_rate_in_gif.service.GifService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class GifControllerTest extends AbstractGifTest {

    @MockBean
    private GifService gifService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getGifByCurrency() throws Exception {

        GifResponse gifResponse = new GifResponse();
        DataDto dataDto = new DataDto();
        dataDto.setTitle("some_title");
        dataDto.setType("gif");
        dataDto.setUrl("some_url");
        gifResponse.setData(dataDto);
        gifResponse.setTag("some_tag");

        when(gifService.getGif("RUB")).thenReturn(gifResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/gif/RUB"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("tag", Matchers.is(gifResponse.getTag())));
    }
}