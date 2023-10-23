package com.example.jdbcdayone.PartsService;

import com.example.jdbcdayone.model.Part;
import com.example.jdbcdayone.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsService {
    private final PartRepository partsRepository;
    @Autowired
    public  PartsService(PartRepository partsRepository) {
        this.partsRepository = partsRepository;
    }
    public List<Part> getParts() {
        return partsRepository.findAll();
    }
    public Part getPartById(Integer id) {
        return partsRepository.findById(id).orElse(null);
    }
    public Part createPart(Part part) {
        return partsRepository.save(part);
    }
    public void deletePart(Part part) {
        partsRepository.delete(part);
    }
    public Part updatePart(Part part) {
        return partsRepository.save(part);
    }
}
