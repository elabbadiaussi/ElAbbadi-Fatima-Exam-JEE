package ma.enset.fatimaelabbadiexamjee.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.enums.TypePaiement;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaiementDTO {
    private Long id;

    @NotNull(message = "La date est obligatoire")
    private LocalDate date;

    @NotNull(message = "Le montant est obligatoire")
    private Double montant;

    @NotNull(message = "Le type de paiement est obligatoire")
    private TypePaiement type;

    @NotNull(message = "L'identifiant du contrat est obligatoire")
    private Long contratId;
}
