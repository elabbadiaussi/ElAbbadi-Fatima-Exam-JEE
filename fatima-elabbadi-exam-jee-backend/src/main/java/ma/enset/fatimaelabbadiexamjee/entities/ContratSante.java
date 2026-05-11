package ma.enset.fatimaelabbadiexamjee.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.enset.fatimaelabbadiexamjee.enums.NiveauCouverture;

@Entity
@DiscriminatorValue("SANTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ContratSante extends Contrat {

    @Enumerated(EnumType.STRING)
    @Column(name = "niveau_couverture")
    private NiveauCouverture niveauCouverture;  

    @Column(name = "nb_personnes_couvertes")
    private Integer nbPersonnesCouvertes;
}