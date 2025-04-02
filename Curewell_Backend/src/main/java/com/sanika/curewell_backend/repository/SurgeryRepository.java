package com.sanika.curewell_backend.repository;

import com.sanika.curewell_backend.entity.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
    List<Surgery> findBySurgeryDate(LocalDate date);
}