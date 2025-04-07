package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Owner;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner ownerDetails) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isPresent()) {
            Owner updatedOwner = owner.get();
            updatedOwner.setName(ownerDetails.getName());
            updatedOwner.setContactInfo(ownerDetails.getContactInfo());
            ownerRepository.save(updatedOwner);
            return ResponseEntity.ok(updatedOwner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        if (ownerRepository.existsById(id)) {
            ownerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
