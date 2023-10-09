package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@SpringBootTest
public class PartsRepoUnitTest {

    @MockBean
    private PartsRepository partsRepository;

    @Autowired
    private PartsService partsService;
    @Test
    void ShouldRetrievevalueFromRepo() {
        PartsRepository partsRepository = new PartsRepository();
        assert(partsRepository.getParts().size() == 2);
    }
    @Test
    void addingPartShouldIncreaseSize() {
        PartsRepository partsRepository = new PartsRepository();
        partsRepository.addPart(new Part("test"));
        assert(partsRepository.getParts().size() == 3);
    }
    @Test
    void removingPartShouldDecreaseSize(){
        PartsRepository partsRepository = new PartsRepository();
        Part part = new Part("cummer");
        partsRepository.addPart(part);
        assert(partsRepository.getParts().size() == 3);
        partsRepository.removePart(part);
        assert(partsRepository.getParts().size() == 2);
    }
    @Test
    void shouldGetPartsFromService(){
        ArrayList<Part> parts = new ArrayList<>(List.of(new Part("pogo")));
        when(partsRepository.getParts()).thenReturn(parts);

        assert(partsService.getParts().size() == 1);
        assert(partsService.getParts().get(0).name().equals("pogo"));
    }

}
