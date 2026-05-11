package ma.enset.fatimaelabbadiexamjee.repositories;

import ma.enset.fatimaelabbadiexamjee.entities.ContratSante;
import ma.enset.fatimaelabbadiexamjee.enums.NiveauCouverture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratSanteRepository extends JpaRepository<ContratSante, Long> {

    List<ContratSante> findByNiveauCouverture(NiveauCouverture niveauCouverture);

    List<ContratSante> findByNbPersonnesCouvertesGreaterThanEqual(Integer nb);

    List<ContratSante> findByClientId(Long clientId);
}