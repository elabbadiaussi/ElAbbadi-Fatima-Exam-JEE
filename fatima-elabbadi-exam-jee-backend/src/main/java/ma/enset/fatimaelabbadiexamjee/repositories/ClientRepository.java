package ma.enset.fatimaelabbadiexamjee.repositories;

import ma.enset.fatimaelabbadiexamjee.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmail(String email);

    List<Client> findByNomContainingIgnoreCase(String nom);

    boolean existsByEmail(String email);

    @Query("SELECT DISTINCT c FROM Client c LEFT JOIN FETCH c.contrats WHERE c.id = :id")
    Optional<Client> findByIdWithContrats(@Param("id") Long id);
}