package com.sanika.curewell_backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "doctor_specs")
public class DoctorSpec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spec_code", nullable = false)
    private Specialisation specialisation;

    private LocalDate specializationDate;

    public DoctorSpec() {
    }

    public DoctorSpec(Doctor doctor, Specialisation specialisation, LocalDate specializationDate) {
        this.doctor = doctor;
        this.specialisation = specialisation;
        this.specializationDate = specializationDate;
    }
}