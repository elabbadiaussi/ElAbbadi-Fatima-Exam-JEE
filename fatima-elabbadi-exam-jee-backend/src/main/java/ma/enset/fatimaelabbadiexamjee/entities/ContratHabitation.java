package ma.enset.fatimaelabbadiexamjee.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.enset.fatimaelabbadiexamjee.enums.TypeLogement;

@Entity
@DiscriminatorValue("HABITATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ContratHabitation extends Contrat {

    @Enumerated(EnumType.STRING)
    @Column(name = "type_logement")
    private TypeLogement typeLogement;     

    @Column(name = "adresse_logement")
    private String adresse;

    @Column(name = "superficie")
    private Double superficie;             
}