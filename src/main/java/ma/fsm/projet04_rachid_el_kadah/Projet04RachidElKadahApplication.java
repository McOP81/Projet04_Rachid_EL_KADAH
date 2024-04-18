package ma.fsm.projet04_rachid_el_kadah;

import ma.fsm.projet04_rachid_el_kadah.entities.*;
import ma.fsm.projet04_rachid_el_kadah.repositories.ConsultationRepository;
import ma.fsm.projet04_rachid_el_kadah.repositories.MedecinRepository;
import ma.fsm.projet04_rachid_el_kadah.repositories.PatientRepository;
import ma.fsm.projet04_rachid_el_kadah.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Projet04RachidElKadahApplication  {

	public static void main(String[] args) {

		SpringApplication.run(Projet04RachidElKadahApplication.class, args);
	}
	@Bean
	CommandLineRunner start(
			PatientRepository patientRepository,
			MedecinRepository medecinRepository,
			RendezVousRepository rendezVousRepository,
			ConsultationRepository consultationRepository
	){
		return args -> {
			Stream.of("Mohamed","Hassan","Najat").forEach(name->{
				Patient patient = new Patient();
				patient.setNom(name);
				patient.setDateNaissance(new Date());
				patient.setMalade(false);
				patientRepository.save(patient);
			});
			Stream.of("Aymane","Hassan","Ayoub").forEach(name->{
				Medecin medecin = new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name+"@gmail.com");
				medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
				medecinRepository.save(medecin);
			});
		Patient patient = patientRepository.findById(1L).orElse(null);
		Patient patient1 = patientRepository.findByNom("Mohamed");

		Medecin medecin = medecinRepository.findByNom("Ayoub");

		RendezVous rendezVous = new RendezVous();
		rendezVous.setDate(new Date());
		rendezVous.setStatus(StatusRDV.PENDING);
		rendezVous.setMedecin(medecin);
		rendezVous.setPatient(patient);
		rendezVousRepository.save(rendezVous);

		RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);

		Consultation consultation = new Consultation();
		consultation.setDateConsultaion(new Date());
		consultation.setRendezVous(rendezVous1);
		consultation.setRapport("Rapport de consultation ");
		consultationRepository.save(consultation);


		};
	}


}
