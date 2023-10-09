package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
@Slf4j
public class PartsController {
    @Autowired
    private PartsService partsService;

    @GetMapping()
    public ResponseEntity<List<Part>> getParts() {
        return ResponseEntity.ok(partsService.getParts());
    }
    @PostMapping()
    public void addPart(@RequestBody Part part) {
        partsService.addPart(part);
    }
    @DeleteMapping()
    public void deletePart(@PathVariable String name) {

    }
}