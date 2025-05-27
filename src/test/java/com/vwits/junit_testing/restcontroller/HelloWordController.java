package com.vwits.junit_testing.restcontroller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWordController.class)
 class HelloWordControllerTest {

    @SuppressWarnings("unused")
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWord() throws Exception {
        //call helloWord
        RequestBuilder request = MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON);
                /*Response matchers is used to check the response and status*/
                 mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello I am Masha"))
                .andReturn();

        //verify Hello Word

    }

}
