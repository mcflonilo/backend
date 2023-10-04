package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
@Slf4j
public class PartsController {
    @Autowired
    private PartsService partsService;

    @GetMapping()
    public List<Part> getParts() {

        return partsService.getParts();
    }
    @PostMapping()
    public void addPart(Part part) {
        log.info("Part: " + part);
        partsService.addPart(part);
    }
}