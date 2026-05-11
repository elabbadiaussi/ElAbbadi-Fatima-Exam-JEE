package ma.enset.fatimaelabbadiexamjee.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.enset.fatimaelabbadiexamjee.dto.PaiementDTO;
import ma.enset.fatimaelabbadiexamjee.services.IPaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
@RequiredArgsConstructor
@Tag(name = "Paiements", description = "Gestion des paiements")
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un paiement par ID")
    public ResponseEntity<PaiementDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(paiementService.getPaiementById(id));
    }

    @GetMapping("/contrat/{contratId}")
    @Operation(summary = "Paiements d'un contrat")
    public ResponseEntity<List<PaiementDTO>> getByContrat(@PathVariable Long contratId) {
        return ResponseEntity.ok(paiementService.getPaiementsByContrat(contratId));
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Paiements d'un client")
    public ResponseEntity<List<PaiementDTO>> getByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(paiementService.getPaiementsByClient(clientId));
    }

    @GetMapping("/contrat/{contratId}/total")
    @Operation(summary = "Total des paiements d'un contrat")
    public ResponseEntity<Double> getTotal(@PathVariable Long contratId) {
        return ResponseEntity.ok(paiementService.getTotalPaiementsByContrat(contratId));
    }

    @PostMapping
    @Operation(summary = "Enregistrer un paiement")
    public ResponseEntity<PaiementDTO> save(@Valid @RequestBody PaiementDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paiementService.savePaiement(dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un paiement")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paiementService.deletePaiement(id);
        return ResponseEntity.noContent().build();
    }
}
