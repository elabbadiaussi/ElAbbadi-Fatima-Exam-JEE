package ma.enset.fatimaelabbadiexamjee.repositories;

import ma.enset.fatimaelabbadiexamjee.entities.Paiement;
import ma.enset.fatimaelabbadiexamjee.enums.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {

    List<Paiement> findByContratId(Long contratId);

    List<Paiement> findByType(TypePaiement type);

    List<Paiement> findByContratIdAndType(Long contratId, TypePaiement type);

    List<Paiement> findByDateBetween(LocalDate debut, LocalDate fin);

    @Query("SELECT SUM(p.montant) FROM Paiement p WHERE p.contrat.id = :contratId")
    Double sumMontantByContratId(@Param("contratId") Long contratId);

    @Query("SELECT p FROM Paiement p WHERE p.contrat.client.id = :clientId ORDER BY p.date DESC")
    List<Paiement> findByClientId(@Param("clientId") Long clientId);
}