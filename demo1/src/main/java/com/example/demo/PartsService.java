package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsService {


    @Autowired
    private PartsRepository partsRepository;

    public List<Part> getParts() {
        return partsRepository.getParts();
    }

    public void addPart(Part part) {
        partsRepository.addPart(part);
    }
}
