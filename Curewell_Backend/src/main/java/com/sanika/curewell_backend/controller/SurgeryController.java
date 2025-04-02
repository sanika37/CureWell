package com.sanika.curewell_backend.controller;

import com.sanika.curewell_backend.dto.SurgeryDto;
import com.sanika.curewell_backend.services.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping("/api/surgeries")
public class SurgeryController {

    @Autowired
    private SurgeryService surgeryService;

    @GetMapping
    public ResponseEntity<List<SurgeryDto>> getAllSurgeries() {
        return ResponseEntity.ok(surgeryService.getAllSurgeries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurgeryDto> getSurgeryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(surgeryService.getSurgeryById(id));
    }

    @PostMapping
    public ResponseEntity<SurgeryDto> addSurgery(@RequestBody SurgeryDto surgeryDto) {
        return new ResponseEntity<>(surgeryService.addSurgery(surgeryDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurgeryDto> updateSurgery(@PathVariable("id") Long id, @RequestBody SurgeryDto surgeryDto) {
        return ResponseEntity.ok(surgeryService.updateSurgery(id, surgeryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSurgery(@PathVariable("id") Long id) {
        surgeryService.deleteSurgery(id);
        return ResponseEntity.ok("Surgery deleted successfully");
    }

    @GetMapping("/today")
    public ResponseEntity<List<SurgeryDto>> getSurgeriesByDate() {
        return ResponseEntity.ok(surgeryService.getSurgeriesByDate());
    }
}