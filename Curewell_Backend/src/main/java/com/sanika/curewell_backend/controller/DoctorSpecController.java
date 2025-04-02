package com.sanika.curewell_backend.controller;

import com.sanika.curewell_backend.dto.DoctorSpecDto;
import com.sanika.curewell_backend.services.DoctorSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping("/api/doctor-specs")
public class DoctorSpecController {

    @Autowired
    private DoctorSpecService doctorSpecService;

    @GetMapping
    public ResponseEntity<List<DoctorSpecDto>> getAllDoctorSpecs() {
        return ResponseEntity.ok(doctorSpecService.getAllDoctorSpecs());
    }

    @PostMapping
    public ResponseEntity<DoctorSpecDto> addDoctorSpec(@RequestBody DoctorSpecDto doctorSpecDto) {
        return new ResponseEntity<>(doctorSpecService.addDoctorSpec(doctorSpecDto), HttpStatus.CREATED);
    }
}