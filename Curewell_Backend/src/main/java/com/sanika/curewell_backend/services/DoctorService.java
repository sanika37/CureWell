package com.sanika.curewell_backend.services;

import com.sanika.curewell_backend.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> getAllDoctors();
    DoctorDto getDoctorById(Long docId);
    DoctorDto addDoctor(DoctorDto doctorDto);
    DoctorDto updateDoctor(Long docId, DoctorDto doctorDto);
    void deleteDoctor(Long docId);
}