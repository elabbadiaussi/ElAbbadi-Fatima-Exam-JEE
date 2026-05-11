package ma.enset.fatimaelabbadiexamjee.mappers;

import ma.enset.fatimaelabbadiexamjee.dto.ClientDTO;
import ma.enset.fatimaelabbadiexamjee.dto.ClientRequestDTO;
import ma.enset.fatimaelabbadiexamjee.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public ClientDTO toDTO(Client client) {
        if (client == null) return null;
        return ClientDTO.builder()
                .id(client.getId())
                .nom(client.getNom())
                .email(client.getEmail())
                .nombreContrats(client.getContrats() != null ? client.getContrats().size() : 0)
                .build();
    }

    public Client toEntity(ClientRequestDTO dto) {
        if (dto == null) return null;
        return Client.builder()
                .nom(dto.getNom())
                .email(dto.getEmail())
                .build();
    }

    public void updateEntity(ClientRequestDTO dto, Client client) {
        if (dto == null || client == null) return;
        client.setNom(dto.getNom());
        client.setEmail(dto.getEmail());
    }
}