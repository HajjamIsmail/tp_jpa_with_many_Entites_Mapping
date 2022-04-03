package com.example.tp3;

import com.example.tp3.Rrepositories.ConsultationRepository;
import com.example.tp3.Rrepositories.MedecinRepository;
import com.example.tp3.Rrepositories.PatientRepository;
import com.example.tp3.Rrepositories.RendezVousRepository;
import com.example.tp3.enitites.*;
import com.example.tp3.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp3Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService HospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository,
                            ConsultationRepository consultationRepository){
        return args -> {
            Stream.of("PatientA","PatientB","PatientC")
                    .forEach(name->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaiss(new Date());
                        patient.setMalade(false);
                        HospitalService.savePatient(patient);
                    });
            Stream.of("MedecinA","MedecinB","MedecinC")
                    .forEach(name->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        HospitalService.saveMedecin(medecin);
                    });
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("PatientA");
            Medecin medecin=medecinRepository.findByNom("MedecinA");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(statusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            HospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("bla bla ce si est un rapport !..........");
            HospitalService.saveConsultation(consultation);
        };
    }
}
