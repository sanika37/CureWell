package com.sanika.curewell_backend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class DoctorSpecDto {
    private Long doctorId;
    private String specCode;
    private LocalDate specializationDate;
}