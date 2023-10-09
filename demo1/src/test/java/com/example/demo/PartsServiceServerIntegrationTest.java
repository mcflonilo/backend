package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class PartsServiceServerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetListOfParts() throws Exception {
        mockMvc
                .perform(get("/api/parts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("cog")));
    }
    @Test
    void shouldAddPart() throws Exception {
        mockMvc
                .perform(post("/api/parts").content("{\"name\":\"testefaen\"}").contentType("application/json"));

        mockMvc
                .perform(get("/api/parts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("testefaen")));

    }
}
