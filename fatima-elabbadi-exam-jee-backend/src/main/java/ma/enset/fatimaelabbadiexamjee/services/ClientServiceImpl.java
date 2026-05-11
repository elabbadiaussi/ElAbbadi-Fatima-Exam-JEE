package ma.enset.fatimaelabbadiexamjee.services;

import lombok.RequiredArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.dto.ClientDTO;
import ma.enset.fatimaelabbadiexamjee.dto.ClientRequestDTO;
import ma.enset.fatimaelabbadiexamjee.entities.Client;
import ma.enset.fatimaelabbadiexamjee.exceptions.ResourceNotFoundException;
import ma.enset.fatimaelabbadiexamjee.mappers.ClientMapper;
import ma.enset.fatimaelabbadiexamjee.repositories.ClientRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDTO saveClient(ClientRequestDTO dto) {
        Client client = clientMapper.toEntity(dto);
        return clientMapper.toDTO(clientRepository.save(client));
    }

    @Override
    public ClientDTO updateClient(Long id, ClientRequestDTO dto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client introuvable avec l'id : " + id));
        clientMapper.updateEntity(dto, client);
        return clientMapper.toDTO(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id))
            throw new ResourceNotFoundException("Client introuvable avec l'id : " + id);
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientDTO getClientById(Long id) {
        Client client = clientRepository.findByIdWithContrats(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client introuvable avec l'id : " + id));
        return clientMapper.toDTO(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientDTO> searchClients(String nom) {
        return clientRepository.findByNomContainingIgnoreCase(nom)
                .stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }
}
