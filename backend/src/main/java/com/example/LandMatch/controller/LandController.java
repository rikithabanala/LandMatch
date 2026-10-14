package com.example.LandMatch.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LandMatch.entity.Land;
import com.example.LandMatch.repository.LandRepository;

@RestController
@RequestMapping("/api/lands")
@CrossOrigin(origins = "*")
public class LandController {

    private final LandRepository landRepository;

    public LandController(LandRepository landRepository) {
        this.landRepository = landRepository;
    }

    // Add a new land
    @PostMapping
    public Land addLand(@RequestBody Land land) {
        return landRepository.save(land);
    }

    // Get all lands
    @GetMapping
    public List<Land> getAllLands() {
        return landRepository.findAll();
    }

    // Get land by ID
    @GetMapping("/{id}")
    public Land getLandById(@PathVariable Long id) {
        return landRepository.findById(id).orElse(null);
    }

    // Delete land
    @DeleteMapping("/{id}")
    public String deleteLand(@PathVariable Long id) {

        landRepository.deleteById(id);

        return "Land deleted successfully";
    }
}