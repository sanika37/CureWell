package com.sanika.curewell_backend.controller;

import com.sanika.curewell_backend.dto.DoctorDto;
import com.sanika.curewell_backend.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @PostMapping
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorDto doctorDto) {
        return new ResponseEntity<>(doctorService.addDoctor(doctorDto), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@PathVariable("id") Long id, @RequestBody  DoctorDto doctorDto) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable("id") Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}