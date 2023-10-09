package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class PartsControllerUnitTest {
    @MockBean
    private PartsService partsService;

    @Autowired
    private PartsController partsController;

    @Test
    void shouldReturnResult() {
        ArrayList<Part> parts = new ArrayList<>(List.of(new Part("pogo")));
        when(partsService.getParts()).thenReturn(parts);

        assert (partsController.getParts().getBody().size() == 1);
        assert (partsController.getParts().getBody().get(0).name().equals("pogo"));
    }
}