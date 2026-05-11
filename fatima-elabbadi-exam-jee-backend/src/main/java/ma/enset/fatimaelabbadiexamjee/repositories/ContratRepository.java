package ma.enset.fatimaelabbadiexamjee.repositories;

import ma.enset.fatimaelabbadiexamjee.entities.Contrat;
import ma.enset.fatimaelabbadiexamjee.enums.StatutContrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

    List<Contrat> findByClientId(Long clientId);

    List<Contrat> findByStatut(StatutContrat statut);

    List<Contrat> findByClientIdAndStatut(Long clientId, StatutContrat statut);

    List<Contrat> findByDateSouscriptionBetween(LocalDate debut, LocalDate fin);

    List<Contrat> findByMontantCotisationLessThanEqual(Double montant);

    long countByClientId(Long clientId);

    @Query("SELECT DISTINCT c FROM Contrat c LEFT JOIN FETCH c.paiements WHERE c.client.id = :clientId")
    List<Contrat> findByClientIdWithPaiements(@Param("clientId") Long clientId);
}