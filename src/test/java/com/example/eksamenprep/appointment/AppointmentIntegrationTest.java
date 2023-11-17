package com.example.eksamenprep.appointment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AppointmentIntegrationTest {
    @Autowired
    MockMvc mockMvc;


    @Test
    void shouldGetListOfAppointments() throws Exception {
        mockMvc.perform(get("/api/appointment"))
                .andExpect(status().isOk())
                .andDo(result -> System.out.println(result));
    }
}
