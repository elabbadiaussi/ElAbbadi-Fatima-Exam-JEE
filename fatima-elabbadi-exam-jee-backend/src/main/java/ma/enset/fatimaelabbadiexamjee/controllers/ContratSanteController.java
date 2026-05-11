package ma.enset.fatimaelabbadiexamjee.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.dto.ContratSanteDTO;
import ma.enset.fatimaelabbadiexamjee.services.IContratService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats/sante")
@RequiredArgsConstructor
@Tag(name = "Contrats Santé", description = "Gestion des contrats d'assurance santé")
public class ContratSanteController {

    private final IContratService contratService;

    @GetMapping
    @Operation(summary = "Liste de tous les contrats santé")
    public ResponseEntity<List<ContratSanteDTO>> getAll() {
        return ResponseEntity.ok(contratService.getAllContratsSante());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un contrat santé par ID")
    public ResponseEntity<ContratSanteDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.getContratSanteById(id));
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Contrats santé d'un client")
    public ResponseEntity<List<ContratSanteDTO>> getByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(contratService.getContratsSanteByClient(clientId));
    }

    @PostMapping
    @Operation(summary = "Créer un contrat santé")
    public ResponseEntity<ContratSanteDTO> save(@Valid @RequestBody ContratSanteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.saveContratSante(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un contrat santé")
    public ResponseEntity<ContratSanteDTO> update(@PathVariable Long id,
                                                   @Valid @RequestBody ContratSanteDTO dto) {
        return ResponseEntity.ok(contratService.updateContratSante(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un contrat santé")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contratService.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}
