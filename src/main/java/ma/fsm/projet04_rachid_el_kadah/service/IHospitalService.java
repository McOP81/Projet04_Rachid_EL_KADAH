package ma.fsm.projet04_rachid_el_kadah.service;

import ma.fsm.projet04_rachid_el_kadah.entities.Consultation;
import ma.fsm.projet04_rachid_el_kadah.entities.Medecin;
import ma.fsm.projet04_rachid_el_kadah.entities.Patient;
import ma.fsm.projet04_rachid_el_kadah.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
