package ma.fsm.projet04_rachid_el_kadah.repositories;

import ma.fsm.projet04_rachid_el_kadah.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
