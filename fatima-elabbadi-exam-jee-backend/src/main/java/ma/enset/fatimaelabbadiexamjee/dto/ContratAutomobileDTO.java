package ma.enset.fatimaelabbadiexamjee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.enums.StatutContrat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContratAutomobileDTO {
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

    @NotBlank(message = "Le numéro d'immatriculation est obligatoire")
    private String numImmatriculation;

    @NotBlank(message = "La marque du véhicule est obligatoire")
    private String marqueVehicule;

    @NotBlank(message = "Le modèle du véhicule est obligatoire")
    private String modeleVehicule;
}
