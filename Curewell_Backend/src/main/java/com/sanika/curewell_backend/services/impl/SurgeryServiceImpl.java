package com.sanika.curewell_backend.services.impl;

import com.sanika.curewell_backend.dto.SurgeryDto;
import com.sanika.curewell_backend.entity.Doctor;
import com.sanika.curewell_backend.entity.Surgery;
import com.sanika.curewell_backend.exception.ResourceNotFoundException;
import com.sanika.curewell_backend.repository.DoctorRepository;
import com.sanika.curewell_backend.repository.SurgeryRepository;
import com.sanika.curewell_backend.services.SurgeryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurgeryServiceImpl implements SurgeryService {

    @Autowired
    private SurgeryRepository surgeryRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SurgeryDto> getAllSurgeries() {
        List<Surgery> surgeries = surgeryRepository.findAll();
        return surgeries.stream().map(surgery -> modelMapper.map(surgery, SurgeryDto.class)).collect(Collectors.toList());
    }

    @Override
    public SurgeryDto getSurgeryById(Long surgId) {
        Surgery surgery = surgeryRepository.findById(surgId)
                .orElseThrow(() -> new ResourceNotFoundException("Surgery", "id", surgId));
        return modelMapper.map(surgery, SurgeryDto.class);
    }

    @Override
    public SurgeryDto addSurgery(SurgeryDto surgeryDto) {
        Doctor doctor = doctorRepository.findById(surgeryDto.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", surgeryDto.getDoctorId()));
        Surgery surgery = modelMapper.map(surgeryDto, Surgery.class);
        surgery.setDoctor(doctor);
        Surgery savedSurgery = surgeryRepository.save(surgery);
        return modelMapper.map(savedSurgery, SurgeryDto.class);
    }

    @Override
    public SurgeryDto updateSurgery(Long surgId, SurgeryDto surgeryDto) {
        Surgery surgery = surgeryRepository.findById(surgId)
                .orElseThrow(() -> new ResourceNotFoundException("Surgery", "id", surgId));
        Doctor doctor = doctorRepository.findById(surgeryDto.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "id", surgeryDto.getDoctorId()));
        modelMapper.map(surgeryDto, Surgery.class);
        surgery.setSurgId(surgId);
        surgery.setDoctor(doctor);
        Surgery updatedSurgery = surgeryRepository.save(surgery);
        return modelMapper.map(updatedSurgery, SurgeryDto.class);
    }

    @Override
    public void deleteSurgery(Long surgId) {
        surgeryRepository.deleteById(surgId);
    }

    @Override
    public List<SurgeryDto> getSurgeriesByDate() {
        LocalDate today = LocalDate.now();
        List<Surgery> surgeries = surgeryRepository.findBySurgeryDate(today);
        return surgeries.stream().map(surgery -> modelMapper.map(surgery, SurgeryDto.class)).collect(Collectors.toList());
    }
}