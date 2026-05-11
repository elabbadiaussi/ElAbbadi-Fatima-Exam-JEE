package ma.enset.fatimaelabbadiexamjee.mappers;

import ma.enset.fatimaelabbadiexamjee.dto.PaiementDTO;
import ma.enset.fatimaelabbadiexamjee.entities.Paiement;
import org.springframework.stereotype.Component;

@Component
public class PaiementMapper {

    public PaiementDTO toDTO(Paiement p) {
        if (p == null) return null;
        return PaiementDTO.builder()
                .id(p.getId())
                .date(p.getDate())
                .montant(p.getMontant())
                .type(p.getType())
                .contratId(p.getContrat() != null ? p.getContrat().getId() : null)
                .build();
    }

    public Paiement toEntity(PaiementDTO dto) {
        if (dto == null) return null;
        return Paiement.builder()
                .date(dto.getDate())
                .montant(dto.getMontant())
                .type(dto.getType())
                .build();
    }
}