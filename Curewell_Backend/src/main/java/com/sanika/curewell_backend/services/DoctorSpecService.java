package com.sanika.curewell_backend.services;

import com.sanika.curewell_backend.dto.DoctorSpecDto;

import java.util.List;

public interface DoctorSpecService {
    List<DoctorSpecDto> getAllDoctorSpecs();
    DoctorSpecDto addDoctorSpec(DoctorSpecDto doctorSpecDto);
}