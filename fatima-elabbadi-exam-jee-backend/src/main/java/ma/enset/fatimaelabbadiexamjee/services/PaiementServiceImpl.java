package ma.enset.fatimaelabbadiexamjee.services;

import lombok.RequiredArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.dto.PaiementDTO;
import ma.enset.fatimaelabbadiexamjee.entities.Contrat;
import ma.enset.fatimaelabbadiexamjee.entities.Paiement;
import ma.enset.fatimaelabbadiexamjee.exceptions.ResourceNotFoundException;
import ma.enset.fatimaelabbadiexamjee.mappers.PaiementMapper;
import ma.enset.fatimaelabbadiexamjee.repositories.ContratRepository;
import ma.enset.fatimaelabbadiexamjee.repositories.PaiementRepository;
import ma.enset.fatimaelabbadiexamjee.services.IPaiementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final PaiementRepository paiementRepository;
    private final ContratRepository contratRepository;
    private final PaiementMapper paiementMapper;

    @Override
    public PaiementDTO savePaiement(PaiementDTO dto) {
        Contrat contrat = contratRepository.findById(dto.getContratId())
                .orElseThrow(() -> new ResourceNotFoundException("Contrat introuvable avec l'id : " + dto.getContratId()));
        Paiement paiement = paiementMapper.toEntity(dto);
        paiement.setContrat(contrat);
        return paiementMapper.toDTO(paiementRepository.save(paiement));
    }

    @Override
    public void deletePaiement(Long id) {
        if (!paiementRepository.existsById(id))
            throw new ResourceNotFoundException("Paiement introuvable avec l'id : " + id);
        paiementRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public PaiementDTO getPaiementById(Long id) {
        return paiementMapper.toDTO(paiementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paiement introuvable avec l'id : " + id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaiementDTO> getPaiementsByContrat(Long contratId) {
        return paiementRepository.findByContratId(contratId)
                .stream()
                .map(paiementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaiementDTO> getPaiementsByClient(Long clientId) {
        return paiementRepository.findByClientId(clientId)
                .stream()
                .map(paiementMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Double getTotalPaiementsByContrat(Long contratId) {
        Double total = paiementRepository.sumMontantByContratId(contratId);
        return total != null ? total : 0.0;
    }
}
