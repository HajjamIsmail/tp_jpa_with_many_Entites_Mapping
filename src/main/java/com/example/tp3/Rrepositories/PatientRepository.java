package com.example.tp3.Rrepositories;

import com.example.tp3.enitites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String str);
}
