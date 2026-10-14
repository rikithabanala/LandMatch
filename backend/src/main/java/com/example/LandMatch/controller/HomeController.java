package com.example.LandMatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.LandMatch.entity.Land;
import com.example.LandMatch.repository.LandRepository;

@Controller
public class HomeController {

    private final LandRepository landRepository;

    public HomeController(LandRepository landRepository) {
        this.landRepository = landRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/lands")
public String lands(org.springframework.ui.Model model) {
    model.addAttribute("lands", landRepository.findAll());
    return "lands";
}

    @GetMapping("/add-land")
    public String addLand() {
        return "add-land";
    }

    @PostMapping("/save-land")
    public String saveLand(
            @RequestParam String ownerName,
            @RequestParam String location,
            @RequestParam double area,
            @RequestParam double price,
            @RequestParam String description) {

        Land land = new Land();

        land.setOwnerName(ownerName);
        land.setLocation(location);
        land.setArea(area);
        land.setPrice(price);
        land.setDescription(description);

        landRepository.save(land);

        return "redirect:/lands";
    }
}