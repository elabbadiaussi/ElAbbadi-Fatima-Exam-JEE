package ma.enset.fatimaelabbadiexamjee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.enums.StatutContrat;
import ma.enset.fatimaelabbadiexamjee.enums.TypeLogement;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContratHabitationDTO {
    private Long id;
    private LocalDate dateSouscription;
    private StatutContrat statut;
    private LocalDate dateValidation;

    @NotNull(message = "Le montant de la cotisation est obligatoire")
    private Double montantCotisation;

    @NotNull(message = "La durée du contrat est obligatoire")
    private Integer dureeContrat;

    @NotNull(message = "Le taux de couverture est obligatoire")
    private Double tauxCouverture;

    private Long clientId;
    private String clientNom;

    @NotNull(message = "Le type de logement est obligatoire")
    private TypeLogement typeLogement;

    @NotBlank(message = "L'adresse est obligatoire")
    private String adresse;

    @NotNull(message = "La superficie est obligatoire")
    private Double superficie;
}
