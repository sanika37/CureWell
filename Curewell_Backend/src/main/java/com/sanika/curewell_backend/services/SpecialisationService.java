package com.sanika.curewell_backend.services;

import com.sanika.curewell_backend.dto.SpecialisationDto;

import java.util.List;

public interface SpecialisationService {
    List<SpecialisationDto> getAllSpecialisations();
    SpecialisationDto getSpecialisationById(String specCode);
    SpecialisationDto addSpecialisation(SpecialisationDto specialisationDto);
    SpecialisationDto updateSpecialisation(String specCode, SpecialisationDto specialisationDto);
    void deleteSpecialisation(String specCode);
}