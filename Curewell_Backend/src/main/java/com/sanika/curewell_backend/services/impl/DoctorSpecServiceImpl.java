package com.sanika.curewell_backend.services.impl;

import com.sanika.curewell_backend.entity.Doctor;
import com.sanika.curewell_backend.entity.DoctorSpec;
import com.sanika.curewell_backend.entity.Specialisation;
import com.sanika.curewell_backend.exception.ResourceNotFoundException;
import com.sanika.curewell_backend.repository.DoctorRepository;
import com.sanika.curewell_backend.repository.DoctorSpecRepository;
import com.sanika.curewell_backend.repository.SpecialisationRepository;
import com.sanika.curewell_backend.services.DoctorSpecService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.sanika.curewell_backend.dto.DoctorSpecDto;

@Service
public class DoctorSpecServiceImpl implements DoctorSpecService {

    @Autowired
    private DoctorSpecRepository doctorSpecRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SpecialisationRepository specialisationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<DoctorSpecDto> getAllDoctorSpecs() {
        List<DoctorSpec> doctorSpecs = doctorSpecRepository.findAll();
        return doctorSpecs.stream().map(doctorSpec -> modelMapper.map(doctorSpec, DoctorSpecDto.class)).collect(Collectors.toList());
    }

    @Override
    public DoctorSpecDto addDoctorSpec(DoctorSpecDto doctorSpecDto) {
        Doctor doctor = doctorRepository.findById(doctorSpecDto.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", doctorSpecDto.getDoctorId()));
        Specialisation specialisation = specialisationRepository.findById(doctorSpecDto.getSpecCode())
                .orElseThrow(() -> new ResourceNotFoundException("Specialisation", "code", doctorSpecDto.getSpecCode()));
        DoctorSpec doctorSpec = modelMapper.map(doctorSpecDto, DoctorSpec.class);
        doctorSpec.setDoctor(doctor);
        doctorSpec.setSpecialisation(specialisation);
        DoctorSpec savedDoctorSpec = doctorSpecRepository.save(doctorSpec);
        return modelMapper.map(savedDoctorSpec, DoctorSpecDto.class);
    }
}