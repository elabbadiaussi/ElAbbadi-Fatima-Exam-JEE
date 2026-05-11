package ma.enset.fatimaelabbadiexamjee.services;

import ma.enset.fatimaelabbadiexamjee.dto.ClientDTO;
import ma.enset.fatimaelabbadiexamjee.dto.ClientRequestDTO;

import java.util.List;

public interface IClientService {
    ClientDTO saveClient(ClientRequestDTO dto);
    ClientDTO updateClient(Long id, ClientRequestDTO dto);
    void deleteClient(Long id);
    ClientDTO getClientById(Long id);
    List<ClientDTO> getAllClients();
    List<ClientDTO> searchClients(String nom);
}
