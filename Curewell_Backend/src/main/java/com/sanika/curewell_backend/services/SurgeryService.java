package com.sanika.curewell_backend.services;

import com.sanika.curewell_backend.dto.SurgeryDto;

import java.util.List;

public interface SurgeryService {
    List<SurgeryDto> getAllSurgeries();
    SurgeryDto getSurgeryById(Long surgId);
    SurgeryDto addSurgery(SurgeryDto surgeryDto);
    SurgeryDto updateSurgery(Long surgId, SurgeryDto surgeryDto);
    void deleteSurgery(Long surgId);
    List<SurgeryDto> getSurgeriesByDate();
}