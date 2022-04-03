package com.example.tp3.Rrepositories;

import com.example.tp3.enitites.Medecin;
import com.example.tp3.enitites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String str);
}
