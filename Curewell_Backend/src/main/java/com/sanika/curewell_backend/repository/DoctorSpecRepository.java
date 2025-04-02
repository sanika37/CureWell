package com.sanika.curewell_backend.repository;

import com.sanika.curewell_backend.entity.DoctorSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorSpecRepository extends JpaRepository<DoctorSpec, Long> {
    // You can add custom query methods here if needed
}