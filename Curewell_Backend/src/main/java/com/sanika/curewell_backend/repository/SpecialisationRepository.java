package com.sanika.curewell_backend.repository;

import com.sanika.curewell_backend.entity.Specialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisationRepository extends JpaRepository<Specialisation, String> {
    // You can add custom query methods here if needed
}