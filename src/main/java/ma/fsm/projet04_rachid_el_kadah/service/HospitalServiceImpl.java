package ma.fsm.projet04_rachid_el_kadah.service;

import jakarta.transaction.Transactional;
import ma.fsm.projet04_rachid_el_kadah.entities.Consultation;
import ma.fsm.projet04_rachid_el_kadah.entities.Medecin;
import ma.fsm.projet04_rachid_el_kadah.entities.Patient;
import ma.fsm.projet04_rachid_el_kadah.entities.RendezVous;
import ma.fsm.projet04_rachid_el_kadah.repositories.ConsultationRepository;
import ma.fsm.projet04_rachid_el_kadah.repositories.MedecinRepository;
import ma.fsm.projet04_rachid_el_kadah.repositories.PatientRepository;
import ma.fsm.projet04_rachid_el_kadah.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
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
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
