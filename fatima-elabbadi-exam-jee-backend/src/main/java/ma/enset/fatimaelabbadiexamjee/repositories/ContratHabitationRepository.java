package ma.enset.fatimaelabbadiexamjee.repositories;

import ma.enset.fatimaelabbadiexamjee.entities.ContratHabitation;
import ma.enset.fatimaelabbadiexamjee.enums.TypeLogement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratHabitationRepository extends JpaRepository<ContratHabitation, Long> {

    List<ContratHabitation> findByTypeLogement(TypeLogement typeLogement);

    List<ContratHabitation> findByAdresseContainingIgnoreCase(String adresse);

    List<ContratHabitation> findBySuperficieGreaterThanEqual(Double superficie);

    List<ContratHabitation> findByClientId(Long clientId);
}