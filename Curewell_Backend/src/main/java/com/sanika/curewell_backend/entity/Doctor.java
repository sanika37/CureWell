package com.sanika.curewell_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long doctorId;

    @NotEmpty(message = "Name is required")
    @Column(nullable = false, unique = true)
    private String doctorName;
    // Add other fields as needed
}