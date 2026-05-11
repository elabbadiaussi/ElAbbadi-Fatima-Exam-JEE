package ma.enset.fatimaelabbadiexamjee.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.dto.ContratHabitationDTO;
import ma.enset.fatimaelabbadiexamjee.services.IContratService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats/habitation")
@RequiredArgsConstructor
@Tag(name = "Contrats Habitation", description = "Gestion des contrats d'assurance habitation")
public class ContratHabitationController {

    private final IContratService contratService;

    @GetMapping
    @Operation(summary = "Liste de tous les contrats habitation")
    public ResponseEntity<List<ContratHabitationDTO>> getAll() {
        return ResponseEntity.ok(contratService.getAllContratsHabitation());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un contrat habitation par ID")
    public ResponseEntity<ContratHabitationDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(contratService.getContratHabitationById(id));
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Contrats habitation d'un client")
    public ResponseEntity<List<ContratHabitationDTO>> getByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(contratService.getContratsHabitationByClient(clientId));
    }

    @PostMapping
    @Operation(summary = "Créer un contrat habitation")
    public ResponseEntity<ContratHabitationDTO> save(@Valid @RequestBody ContratHabitationDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.saveContratHabitation(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un contrat habitation")
    public ResponseEntity<ContratHabitationDTO> update(@PathVariable Long id,
                                                        @Valid @RequestBody ContratHabitationDTO dto) {
        return ResponseEntity.ok(contratService.updateContratHabitation(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un contrat habitation")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contratService.deleteContrat(id);
        return ResponseEntity.noContent().build();
    }
}
