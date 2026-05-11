package ma.enset.fatimaelabbadiexamjee.services;

import lombok.RequiredArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.dto.ContratAutomobileDTO;
import ma.enset.fatimaelabbadiexamjee.dto.ContratHabitationDTO;
import ma.enset.fatimaelabbadiexamjee.dto.ContratSanteDTO;
import ma.enset.fatimaelabbadiexamjee.entities.Client;
import ma.enset.fatimaelabbadiexamjee.entities.ContratAutomobile;
import ma.enset.fatimaelabbadiexamjee.entities.ContratHabitation;
import ma.enset.fatimaelabbadiexamjee.entities.ContratSante;
import ma.enset.fatimaelabbadiexamjee.enums.StatutContrat;
import ma.enset.fatimaelabbadiexamjee.exceptions.ResourceNotFoundException;
import ma.enset.fatimaelabbadiexamjee.mappers.ContratMapper;
import ma.enset.fatimaelabbadiexamjee.repositories.ClientRepository;
import ma.enset.fatimaelabbadiexamjee.repositories.ContratAutomobileRepository;
import ma.enset.fatimaelabbadiexamjee.repositories.ContratHabitationRepository;
import ma.enset.fatimaelabbadiexamjee.repositories.ContratSanteRepository;
import ma.enset.fatimaelabbadiexamjee.services.IContratService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final ContratAutomobileRepository autoRepository;
    private final ContratHabitationRepository habRepository;
    private final ContratSanteRepository santeRepository;
    private final ClientRepository clientRepository;
    private final ContratMapper contratMapper;

    private Client findClient(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client introuvable avec l'id : " + clientId));
    }

    @Override
    public ContratAutomobileDTO saveContratAutomobile(ContratAutomobileDTO dto) {
        ContratAutomobile contrat = contratMapper.toEntity(dto);
        contrat.setClient(findClient(dto.getClientId()));
        return contratMapper.toDTO(autoRepository.save(contrat));
    }

    @Override
    public ContratAutomobileDTO updateContratAutomobile(Long id, ContratAutomobileDTO dto) {
        ContratAutomobile contrat = autoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat automobile introuvable avec l'id : " + id));
        contratMapper.updateEntity(dto, contrat);
        if (dto.getClientId() != null)
            contrat.setClient(findClient(dto.getClientId()));
        return contratMapper.toDTO(autoRepository.save(contrat));
    }

    @Override
    public ContratHabitationDTO saveContratHabitation(ContratHabitationDTO dto) {
        ContratHabitation contrat = contratMapper.toEntity(dto);
        contrat.setClient(findClient(dto.getClientId()));
        return contratMapper.toDTO(habRepository.save(contrat));
    }

    @Override
    public ContratHabitationDTO updateContratHabitation(Long id, ContratHabitationDTO dto) {
        ContratHabitation contrat = habRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat habitation introuvable avec l'id : " + id));
        contratMapper.updateEntity(dto, contrat);
        if (dto.getClientId() != null)
            contrat.setClient(findClient(dto.getClientId()));
        return contratMapper.toDTO(habRepository.save(contrat));
    }

    @Override
    public ContratSanteDTO saveContratSante(ContratSanteDTO dto) {
        ContratSante contrat = contratMapper.toEntity(dto);
        contrat.setClient(findClient(dto.getClientId()));
        return contratMapper.toDTO(santeRepository.save(contrat));
    }

    @Override
    public ContratSanteDTO updateContratSante(Long id, ContratSanteDTO dto) {
        ContratSante contrat = santeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat santé introuvable avec l'id : " + id));
        contratMapper.updateEntity(dto, contrat);
        if (dto.getClientId() != null)
            contrat.setClient(findClient(dto.getClientId()));
        return contratMapper.toDTO(santeRepository.save(contrat));
    }

    @Override
    public void deleteContrat(Long id) {
        if (!autoRepository.existsById(id) && !habRepository.existsById(id) && !santeRepository.existsById(id))
            throw new ResourceNotFoundException("Contrat introuvable avec l'id : " + id);
        autoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ContratAutomobileDTO getContratAutomobileById(Long id) {
        return contratMapper.toDTO(autoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat automobile introuvable avec l'id : " + id)));
    }

    @Override
    @Transactional(readOnly = true)
    public ContratHabitationDTO getContratHabitationById(Long id) {
        return contratMapper.toDTO(habRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat habitation introuvable avec l'id : " + id)));
    }

    @Override
    @Transactional(readOnly = true)
    public ContratSanteDTO getContratSanteById(Long id) {
        return contratMapper.toDTO(santeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat santé introuvable avec l'id : " + id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratAutomobileDTO> getAllContratsAutomobile() {
        return autoRepository.findAll().stream().map(contratMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratHabitationDTO> getAllContratsHabitation() {
        return habRepository.findAll().stream().map(contratMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratSanteDTO> getAllContratsSante() {
        return santeRepository.findAll().stream().map(contratMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratAutomobileDTO> getContratsAutomobileByClient(Long clientId) {
        return autoRepository.findByClientId(clientId).stream().map(contratMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratHabitationDTO> getContratsHabitationByClient(Long clientId) {
        return habRepository.findByClientId(clientId).stream().map(contratMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContratSanteDTO> getContratsSanteByClient(Long clientId) {
        return santeRepository.findByClientId(clientId).stream().map(contratMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ContratAutomobileDTO updateStatutContrat(Long id, StatutContrat statut) {
        ContratAutomobile contrat = autoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat introuvable avec l'id : " + id));
        contrat.setStatut(statut);
        return contratMapper.toDTO(autoRepository.save(contrat));
    }
}
