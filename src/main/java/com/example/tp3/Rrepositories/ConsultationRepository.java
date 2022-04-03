package com.example.tp3.Rrepositories;

import com.example.tp3.enitites.Consultation;
import com.example.tp3.enitites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
