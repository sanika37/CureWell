package com.sanika.curewell_backend.services.impl;

import com.sanika.curewell_backend.dto.DoctorDto;
import com.sanika.curewell_backend.entity.Doctor;
import com.sanika.curewell_backend.exception.ResourceNotFoundException;
import com.sanika.curewell_backend.repository.DoctorRepository;
import com.sanika.curewell_backend.services.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(doctor -> modelMapper.map(doctor, DoctorDto.class)).collect(Collectors.toList());
    }

    @Override
    public DoctorDto getDoctorById(Long docId) {
        Doctor doctor = doctorRepository.findById(docId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", docId));
        return modelMapper.map(doctor, DoctorDto.class);
    }

    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(savedDoctor, DoctorDto.class);
    }

    @Override
    public DoctorDto updateDoctor(Long docId, DoctorDto doctorDto) {
        Doctor doctor = doctorRepository.findById(docId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", docId));
        modelMapper.map(doctorDto, Doctor.class);
        doctor.setDoctorId(docId);
        Doctor updatedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(updatedDoctor, DoctorDto.class);
    }

    @Override
    public void deleteDoctor(Long docId) {
        doctorRepository.deleteById(docId);
    }
}