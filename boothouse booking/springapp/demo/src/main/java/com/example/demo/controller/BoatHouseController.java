package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.BoatHouse;
import com.example.demo.repository.BoatHouseRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boathouses")
public class BoatHouseController {

    @Autowired
    private BoatHouseRepository boatHouseRepository;

    @GetMapping
    public List<BoatHouse> getAllBoatHouses() {
        return boatHouseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoatHouse> getBoatHouseById(@PathVariable Long id) {
        Optional<BoatHouse> boatHouse = boatHouseRepository.findById(id);
        return boatHouse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public BoatHouse createBoatHouse(@RequestBody BoatHouse boatHouse) {
        return boatHouseRepository.save(boatHouse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoatHouse> updateBoatHouse(@PathVariable Long id, @RequestBody BoatHouse boatHouseDetails) {
        Optional<BoatHouse> boatHouse = boatHouseRepository.findById(id);
        if (boatHouse.isPresent()) {
            BoatHouse updatedBoatHouse = boatHouse.get();
            updatedBoatHouse.setName(boatHouseDetails.getName());
            updatedBoatHouse.setLocation(boatHouseDetails.getLocation());
            updatedBoatHouse.setAmenities(boatHouseDetails.getAmenities());
            updatedBoatHouse.setOwner(boatHouseDetails.getOwner());
            boatHouseRepository.save(updatedBoatHouse);
            return ResponseEntity.ok(updatedBoatHouse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoatHouse(@PathVariable Long id) {
        if (boatHouseRepository.existsById(id)) {
            boatHouseRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
