package ma.enset.fatimaelabbadiexamjee.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.enums.NiveauCouverture;
import ma.enset.fatimaelabbadiexamjee.enums.StatutContrat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContratSanteDTO {
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

    @NotNull(message = "Le niveau de couverture est obligatoire")
    private NiveauCouverture niveauCouverture;

    @NotNull(message = "Le nombre de personnes couvertes est obligatoire")
    private Integer nbPersonnesCouvertes;
}
