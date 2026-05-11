package ma.enset.fatimaelabbadiexamjee.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.dto.ContratAutomobileDTO;
import ma.enset.fatimaelabbadiexamjee.enums.StatutContrat;
import ma.enset.fatimaelabbadiexamjee.services.IContratService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats/automobile")
@RequiredArgsConstructor
@Tag(name = "Contrats Automobile", description = "Gestion des contrats d'assurance automobile")
public class ContratAutomobileController {

    private final IContratService contratService;

    @GetMapping
    @Operation(summary = "Liste de tous les contrats automobile")
    public ResponseEntity<List<ContratAutomobileDTO>> getAll() {
        return ResponseEntity.ok(contratService.getAllContratsAutomobile());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un contrat automobile par ID")
    public ResponseEntity<ContratAutomobileDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.getContratAutomobileById(id));
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Contrats automobile d'un client")
    public ResponseEntity<List<ContratAutomobileDTO>> getByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(contratService.getContratsAutomobileByClient(clientId));
    }

    @PostMapping
    @Operation(summary = "Créer un contrat automobile")
    public ResponseEntity<ContratAutomobileDTO> save(@Valid @RequestBody ContratAutomobileDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.saveContratAutomobile(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un contrat automobile")
    public ResponseEntity<ContratAutomobileDTO> update(@PathVariable Long id,
                                                        @Valid @RequestBody ContratAutomobileDTO dto) {
        return ResponseEntity.ok(contratService.updateContratAutomobile(id, dto));
    }

    @PatchMapping("/{id}/statut")
    @Operation(summary = "Changer le statut d'un contrat automobile")
    public ResponseEntity<ContratAutomobileDTO> updateStatut(@PathVariable Long id,
                                                              @RequestParam StatutContrat statut) {
        return ResponseEntity.ok(contratService.updateStatutContrat(id, statut));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un contrat automobile")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contratService.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}
