package ma.enset.fatimaelabbadiexamjee.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.dto.ClientDTO;
import ma.enset.fatimaelabbadiexamjee.dto.ClientRequestDTO;
import ma.enset.fatimaelabbadiexamjee.services.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
@Tag(name = "Clients", description = "Gestion des clients")
public class ClientController {

    private final IClientService clientService;

    @GetMapping
    @Operation(summary = "Liste de tous les clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un client par ID")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @GetMapping("/search")
    @Operation(summary = "Rechercher des clients par nom")
    public ResponseEntity<List<ClientDTO>> searchClients(@RequestParam String nom) {
        return ResponseEntity.ok(clientService.searchClients(nom));
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau client")
    public ResponseEntity<ClientDTO> saveClient(@Valid @RequestBody ClientRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un client")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id,
                                                   @Valid @RequestBody ClientRequestDTO dto) {
        return ResponseEntity.ok(clientService.updateClient(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un client")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
