package com.example.tp3.service;

import com.example.tp3.Rrepositories.ConsultationRepository;
import com.example.tp3.Rrepositories.MedecinRepository;
import com.example.tp3.Rrepositories.PatientRepository;
import com.example.tp3.Rrepositories.RendezVousRepository;
import com.example.tp3.enitites.Consultation;
import com.example.tp3.enitites.Medecin;
import com.example.tp3.enitites.Patient;
import com.example.tp3.enitites.RendezVous;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    /*@Autowired
    private PatientRepository p;
    @Autowired
    private MedecinRepository m;
    @Autowired
    private RendezVousRepository r;
    @Autowired
    private ConsultationRepository c;*/
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        //genere string aléatoire unique
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
