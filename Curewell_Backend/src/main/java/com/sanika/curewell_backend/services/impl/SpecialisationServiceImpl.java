package com.sanika.curewell_backend.services.impl;

import com.sanika.curewell_backend.dto.SpecialisationDto;
import com.sanika.curewell_backend.entity.Specialisation;
import com.sanika.curewell_backend.exception.ResourceNotFoundException;
import com.sanika.curewell_backend.repository.SpecialisationRepository;
import com.sanika.curewell_backend.services.SpecialisationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialisationServiceImpl implements SpecialisationService {

    @Autowired
    private SpecialisationRepository specialisationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SpecialisationDto> getAllSpecialisations() {
        List<Specialisation> specialisations = specialisationRepository.findAll();
        return specialisations.stream().map(specialisation -> modelMapper.map(specialisation, SpecialisationDto.class)).collect(Collectors.toList());
    }

    @Override
    public SpecialisationDto getSpecialisationById(String specCode) {
        Specialisation specialisation = specialisationRepository.findById(specCode)
                .orElseThrow(() -> new ResourceNotFoundException("Specialisation", "code", specCode));
        return modelMapper.map(specialisation, SpecialisationDto.class);
    }

    @Override
    public SpecialisationDto addSpecialisation(SpecialisationDto specialisationDto) {
        Specialisation specialisation = modelMapper.map(specialisationDto, Specialisation.class);
        Specialisation savedSpecialisation = specialisationRepository.save(specialisation);
        return modelMapper.map(savedSpecialisation, SpecialisationDto.class);
    }

    @Override
    public SpecialisationDto updateSpecialisation(String specCode, SpecialisationDto specialisationDto) {
        Specialisation specialisation = specialisationRepository.findById(specCode)
                .orElseThrow(() -> new ResourceNotFoundException("Specialisation", "code", specCode));
        modelMapper.map(specialisationDto, Specialisation.class);
        specialisation.setSpecCode(specCode);
        Specialisation updatedSpecialisation = specialisationRepository.save(specialisation);
        return modelMapper.map(updatedSpecialisation, SpecialisationDto.class);
    }

    @Override
    public void deleteSpecialisation(String specCode) {
        specialisationRepository.deleteById(specCode);
    }
}