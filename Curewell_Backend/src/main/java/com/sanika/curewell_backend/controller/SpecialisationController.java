package com.sanika.curewell_backend.controller;

import com.sanika.curewell_backend.dto.SpecialisationDto;
import com.sanika.curewell_backend.services.SpecialisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping("/api/specialisations")
public class SpecialisationController {

    @Autowired
    private SpecialisationService specialisationService;

    @GetMapping
    public ResponseEntity<List<SpecialisationDto>> getAllSpecialisations() {
        return ResponseEntity.ok(specialisationService.getAllSpecialisations());
    }

    @GetMapping("/{code}")
    public ResponseEntity<SpecialisationDto> getSpecialisationById(@PathVariable("code") String code) {
        return ResponseEntity.ok(specialisationService.getSpecialisationById(code));
    }

    @PostMapping
    public ResponseEntity<SpecialisationDto> addSpecialisation(@RequestBody SpecialisationDto specialisationDto) {
        return new ResponseEntity<>(specialisationService.addSpecialisation(specialisationDto), HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<SpecialisationDto> updateSpecialisation(@PathVariable String code, @RequestBody SpecialisationDto specialisationDto) {
        return ResponseEntity.ok(specialisationService.updateSpecialisation(code, specialisationDto));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deleteSpecialisation(@PathVariable("code") String code) {
        specialisationService.deleteSpecialisation(code);
        return ResponseEntity.ok("Specialisation deleted successfully");
    }
}