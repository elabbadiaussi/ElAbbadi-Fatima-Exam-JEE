package ma.enset.fatimaelabbadiexamjee.mappers;

import ma.enset.fatimaelabbadiexamjee.dto.ContratAutomobileDTO;
import ma.enset.fatimaelabbadiexamjee.dto.ContratHabitationDTO;
import ma.enset.fatimaelabbadiexamjee.dto.ContratSanteDTO;
import ma.enset.fatimaelabbadiexamjee.entities.ContratAutomobile;
import ma.enset.fatimaelabbadiexamjee.entities.ContratHabitation;
import ma.enset.fatimaelabbadiexamjee.entities.ContratSante;
import org.springframework.stereotype.Component;

@Component
public class ContratMapper {

    public ContratAutomobileDTO toDTO(ContratAutomobile c) {
        if (c == null) return null;
        return ContratAutomobileDTO.builder()
                .id(c.getId())
                .dateSouscription(c.getDateSouscription())
                .statut(c.getStatut())
                .dateValidation(c.getDateValidation())
                .montantCotisation(c.getMontantCotisation())
                .dureeContrat(c.getDureeContrat())
                .tauxCouverture(c.getTauxCouverture())
                .clientId(c.getClient() != null ? c.getClient().getId() : null)
                .clientNom(c.getClient() != null ? c.getClient().getNom() : null)
                .numImmatriculation(c.getNumImmatriculation())
                .marqueVehicule(c.getMarqueVehicule())
                .modeleVehicule(c.getModeleVehicule())
                .build();
    }

    public ContratAutomobile toEntity(ContratAutomobileDTO dto) {
        if (dto == null) return null;
        return ContratAutomobile.builder()
                .dateSouscription(dto.getDateSouscription())
                .statut(dto.getStatut())
                .dateValidation(dto.getDateValidation())
                .montantCotisation(dto.getMontantCotisation())
                .dureeContrat(dto.getDureeContrat())
                .tauxCouverture(dto.getTauxCouverture())
                .numImmatriculation(dto.getNumImmatriculation())
                .marqueVehicule(dto.getMarqueVehicule())
                .modeleVehicule(dto.getModeleVehicule())
                .build();
    }

    public void updateEntity(ContratAutomobileDTO dto, ContratAutomobile c) {
        if (dto == null || c == null) return;
        c.setDateSouscription(dto.getDateSouscription());
        c.setStatut(dto.getStatut());
        c.setDateValidation(dto.getDateValidation());
        c.setMontantCotisation(dto.getMontantCotisation());
        c.setDureeContrat(dto.getDureeContrat());
        c.setTauxCouverture(dto.getTauxCouverture());
        c.setNumImmatriculation(dto.getNumImmatriculation());
        c.setMarqueVehicule(dto.getMarqueVehicule());
        c.setModeleVehicule(dto.getModeleVehicule());
    }

    public ContratHabitationDTO toDTO(ContratHabitation c) {
        if (c == null) return null;
        return ContratHabitationDTO.builder()
                .id(c.getId())
                .dateSouscription(c.getDateSouscription())
                .statut(c.getStatut())
                .dateValidation(c.getDateValidation())
                .montantCotisation(c.getMontantCotisation())
                .dureeContrat(c.getDureeContrat())
                .tauxCouverture(c.getTauxCouverture())
                .clientId(c.getClient() != null ? c.getClient().getId() : null)
                .clientNom(c.getClient() != null ? c.getClient().getNom() : null)
                .typeLogement(c.getTypeLogement())
                .adresse(c.getAdresse())
                .superficie(c.getSuperficie())
                .build();
    }

    public ContratHabitation toEntity(ContratHabitationDTO dto) {
        if (dto == null) return null;
        return ContratHabitation.builder()
                .dateSouscription(dto.getDateSouscription())
                .statut(dto.getStatut())
                .dateValidation(dto.getDateValidation())
                .montantCotisation(dto.getMontantCotisation())
                .dureeContrat(dto.getDureeContrat())
                .tauxCouverture(dto.getTauxCouverture())
                .typeLogement(dto.getTypeLogement())
                .adresse(dto.getAdresse())
                .superficie(dto.getSuperficie())
                .build();
    }

    public void updateEntity(ContratHabitationDTO dto, ContratHabitation c) {
        if (dto == null || c == null) return;
        c.setDateSouscription(dto.getDateSouscription());
        c.setStatut(dto.getStatut());
        c.setDateValidation(dto.getDateValidation());
        c.setMontantCotisation(dto.getMontantCotisation());
        c.setDureeContrat(dto.getDureeContrat());
        c.setTauxCouverture(dto.getTauxCouverture());
        c.setTypeLogement(dto.getTypeLogement());
        c.setAdresse(dto.getAdresse());
        c.setSuperficie(dto.getSuperficie());
    }

    public ContratSanteDTO toDTO(ContratSante c) {
        if (c == null) return null;
        return ContratSanteDTO.builder()
                .id(c.getId())
                .dateSouscription(c.getDateSouscription())
                .statut(c.getStatut())
                .dateValidation(c.getDateValidation())
                .montantCotisation(c.getMontantCotisation())
                .dureeContrat(c.getDureeContrat())
                .tauxCouverture(c.getTauxCouverture())
                .clientId(c.getClient() != null ? c.getClient().getId() : null)
                .clientNom(c.getClient() != null ? c.getClient().getNom() : null)
                .niveauCouverture(c.getNiveauCouverture())
                .nbPersonnesCouvertes(c.getNbPersonnesCouvertes())
                .build();
    }

    public ContratSante toEntity(ContratSanteDTO dto) {
        if (dto == null) return null;
        return ContratSante.builder()
                .dateSouscription(dto.getDateSouscription())
                .statut(dto.getStatut())
                .dateValidation(dto.getDateValidation())
                .montantCotisation(dto.getMontantCotisation())
                .dureeContrat(dto.getDureeContrat())
                .tauxCouverture(dto.getTauxCouverture())
                .niveauCouverture(dto.getNiveauCouverture())
                .nbPersonnesCouvertes(dto.getNbPersonnesCouvertes())
                .build();
    }

    public void updateEntity(ContratSanteDTO dto, ContratSante c) {
        if (dto == null || c == null) return;
        c.setDateSouscription(dto.getDateSouscription());
        c.setStatut(dto.getStatut());
        c.setDateValidation(dto.getDateValidation());
        c.setMontantCotisation(dto.getMontantCotisation());
        c.setDureeContrat(dto.getDureeContrat());
        c.setTauxCouverture(dto.getTauxCouverture());
        c.setNiveauCouverture(dto.getNiveauCouverture());
        c.setNbPersonnesCouvertes(dto.getNbPersonnesCouvertes());
    }
}