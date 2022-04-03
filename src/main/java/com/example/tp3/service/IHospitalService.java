package com.example.tp3.service;

import com.example.tp3.enitites.Consultation;
import com.example.tp3.enitites.Medecin;
import com.example.tp3.enitites.Patient;
import com.example.tp3.enitites.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
