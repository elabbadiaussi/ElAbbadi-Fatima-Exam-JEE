package ma.enset.fatimaelabbadiexamjee.services;

import ma.enset.fatimaelabbadiexamjee.dto.PaiementDTO;

import java.util.List;

public interface IPaiementService {
    PaiementDTO savePaiement(PaiementDTO dto);
    void deletePaiement(Long id);
    PaiementDTO getPaiementById(Long id);
    List<PaiementDTO> getPaiementsByContrat(Long contratId);
    List<PaiementDTO> getPaiementsByClient(Long clientId);
    Double getTotalPaiementsByContrat(Long contratId);
}
