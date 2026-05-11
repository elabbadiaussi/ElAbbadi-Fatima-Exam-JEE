package ma.enset.fatimaelabbadiexamjee.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("AUTOMOBILE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ContratAutomobile extends Contrat {

    @Column(name = "num_immatriculation")
    private String numImmatriculation;     

    @Column(name = "marque_vehicule")
    private String marqueVehicule;         

    @Column(name = "modele_vehicule")
    private String modeleVehicule;        
}