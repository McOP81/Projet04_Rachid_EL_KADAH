package ma.fsm.projet04_rachid_el_kadah.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateConsultaion;
    private String rapport;
    @OneToOne
    private RendezVous rendezVous;
}
