package com.sanika.curewell_backend.dto;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class SurgeryDto {
    private Long surgId;
    private Long doctorId; // Assuming you'll use the doctor's ID
    private String surgeryName;
    private String specCode;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate surgeryDate;
}