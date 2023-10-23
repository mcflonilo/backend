package com.example.jdbcdayone.PartsService;

import com.example.jdbcdayone.model.Part;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
public class PartController {
    private final PartsService partsService;
    @Autowired
    public PartController(PartsService partsService) {
        this.partsService = partsService;
    }
    @GetMapping("/parts")
    public List<Part> getParts() {
        return partsService.getParts();
    }
    @GetMapping("{id}")
    public Part getPartById(@PathVariable Integer id) {
        return partsService.getPartById(id);
    }
    @PostMapping
    public Part createPart(@RequestBody Part part) {
        return partsService.createPart(part);
    }
    @DeleteMapping
    public void deletePart(@RequestBody Part part) {
        partsService.deletePart(part);
    }
    @PutMapping
    public Part updatePart(@RequestBody Part part) {
        return partsService.updatePart(part);
    }
}
