package ma.fsm.projet04_rachid_el_kadah.web;

import ma.fsm.projet04_rachid_el_kadah.entities.Patient;
import ma.fsm.projet04_rachid_el_kadah.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @GetMapping("/patients")
    public List<Patient> patientList() {
          return patientRepository.findAll();
    }

}
