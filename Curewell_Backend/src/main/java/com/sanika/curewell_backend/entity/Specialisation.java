package com.sanika.curewell_backend.entity;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "specialisations")
public class Specialisation {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private String specCode;
    private String specName;
}