package ma.enset.fatimaelabbadiexamjee;

import ma.enset.fatimaelabbadiexamjee.entities.*;
import ma.enset.fatimaelabbadiexamjee.enums.*;
import ma.enset.fatimaelabbadiexamjee.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ContratAutomobileRepository contratAutoRepository;
    private final ContratHabitationRepository contratHabRepository;
    private final ContratSanteRepository contratSanteRepository;
    private final PaiementRepository paiementRepository;

    public DataInitializer(ClientRepository clientRepository,
                           ContratAutomobileRepository contratAutoRepository,
                           ContratHabitationRepository contratHabRepository,
                           ContratSanteRepository contratSanteRepository,
                           PaiementRepository paiementRepository) {
        this.clientRepository = clientRepository;
        this.contratAutoRepository = contratAutoRepository;
        this.contratHabRepository = contratHabRepository;
        this.contratSanteRepository = contratSanteRepository;
        this.paiementRepository = paiementRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // ── Création des clients ──────────────────────────────
        Client c1 = clientRepository.save(
                Client.builder()
                        .nom("Fatima Elabbadi")
                        .email("fatima@gmail.com")
                        .build());

        Client c2 = clientRepository.save(
                Client.builder()
                        .nom("Ahmed Benali")
                        .email("ahmed@gmail.com")
                        .build());

        Client c3 = clientRepository.save(
                Client.builder()
                        .nom("Sara Idrissi")
                        .email("sara@gmail.com")
                        .build());

        ContratAutomobile ca1 = contratAutoRepository.save(
                ContratAutomobile.builder()
                        .dateSouscription(LocalDate.of(2024, 1, 15))
                        .statut(StatutContrat.EN_COURS)
                        .montantCotisation(1200.0)
                        .dureeContrat(12)
                        .tauxCouverture(80.0)
                        .numImmatriculation("12345-A-7")
                        .marqueVehicule("Renault")
                        .modeleVehicule("Clio")
                        .client(c1)
                        .build());

        ContratAutomobile ca2 = contratAutoRepository.save(
                ContratAutomobile.builder()
                        .dateSouscription(LocalDate.of(2023, 6, 10))
                        .statut(StatutContrat.VALIDE)
                        .dateValidation(LocalDate.of(2023, 6, 12))
                        .montantCotisation(1800.0)
                        .dureeContrat(24)
                        .tauxCouverture(90.0)
                        .numImmatriculation("67890-B-5")
                        .marqueVehicule("Toyota")
                        .modeleVehicule("Corolla")
                        .client(c2)
                        .build());

        ContratHabitation ch1 = contratHabRepository.save(
                ContratHabitation.builder()
                        .dateSouscription(LocalDate.of(2024, 3, 1))
                        .statut(StatutContrat.EN_COURS)
                        .montantCotisation(600.0)
                        .dureeContrat(12)
                        .tauxCouverture(75.0)
                        .typeLogement(TypeLogement.APPARTEMENT)
                        .adresse("12 Rue Mohammed V, Casablanca")
                        .superficie(85.0)
                        .client(c1)
                        .build());

        ContratHabitation ch2 = contratHabRepository.save(
                ContratHabitation.builder()
                        .dateSouscription(LocalDate.of(2023, 9, 20))
                        .statut(StatutContrat.VALIDE)
                        .dateValidation(LocalDate.of(2023, 9, 22))
                        .montantCotisation(900.0)
                        .dureeContrat(24)
                        .tauxCouverture(85.0)
                        .typeLogement(TypeLogement.MAISON)
                        .adresse("5 Avenue Hassan II, Rabat")
                        .superficie(150.0)
                        .client(c3)
                        .build());

        ContratSante cs1 = contratSanteRepository.save(
                ContratSante.builder()
                        .dateSouscription(LocalDate.of(2024, 2, 1))
                        .statut(StatutContrat.EN_COURS)
                        .montantCotisation(500.0)
                        .dureeContrat(12)
                        .tauxCouverture(70.0)
                        .niveauCouverture(NiveauCouverture.INTERMEDIAIRE)
                        .nbPersonnesCouvertes(3)
                        .client(c2)
                        .build());

        ContratSante cs2 = contratSanteRepository.save(
                ContratSante.builder()
                        .dateSouscription(LocalDate.of(2023, 11, 5))
                        .statut(StatutContrat.RESILIE)
                        .montantCotisation(300.0)
                        .dureeContrat(6)
                        .tauxCouverture(50.0)
                        .niveauCouverture(NiveauCouverture.BASIQUE)
                        .nbPersonnesCouvertes(1)
                        .client(c3)
                        .build());

        paiementRepository.save(Paiement.builder()
                .date(LocalDate.of(2024, 1, 15))
                .montant(100.0)
                .type(TypePaiement.MENSUALITE)
                .contrat(ca1)
                .build());

        paiementRepository.save(Paiement.builder()
                .date(LocalDate.of(2024, 2, 15))
                .montant(100.0)
                .type(TypePaiement.MENSUALITE)
                .contrat(ca1)
                .build());

        paiementRepository.save(Paiement.builder()
                .date(LocalDate.of(2023, 6, 10))
                .montant(1800.0)
                .type(TypePaiement.PAIEMENT_ANNUEL)
                .contrat(ca2)
                .build());

        paiementRepository.save(Paiement.builder()
                .date(LocalDate.of(2024, 3, 1))
                .montant(50.0)
                .type(TypePaiement.MENSUALITE)
                .contrat(ch1)
                .build());

        paiementRepository.save(Paiement.builder()
                .date(LocalDate.of(2024, 1, 10))
                .montant(500.0)
                .type(TypePaiement.PAIEMENT_EXCEPTIONNEL)
                .contrat(cs1)
                .build());

        // ── Affichage des résultats dans la console ───────────
        System.out.println("========================================");
        System.out.println("   BASE DE DONNÉES INITIALISÉE");
        System.out.println("========================================");
        System.out.println("Clients         : " + clientRepository.count());
        System.out.println("Contrats Auto   : " + contratAutoRepository.count());
        System.out.println("Contrats Hab    : " + contratHabRepository.count());
        System.out.println("Contrats Santé  : " + contratSanteRepository.count());
        System.out.println("Paiements       : " + paiementRepository.count());
        System.out.println("========================================");

        System.out.println("\n--- Liste des clients ---");
        clientRepository.findAll().forEach(c ->
                System.out.println("  > " + c.getId() + " | " + c.getNom() + " | " + c.getEmail()));

        System.out.println("\n--- Contrats de Fatima ---");
        contratAutoRepository.findByClientId(c1.getId()).forEach(c ->
                System.out.println("  AUTO > " + c.getMarqueVehicule() + " " + c.getModeleVehicule() + " | " + c.getStatut()));
        contratHabRepository.findByClientId(c1.getId()).forEach(c ->
                System.out.println("  HAB  > " + c.getAdresse() + " | " + c.getStatut()));

        System.out.println("\n--- Paiements du contrat Auto 1 ---");
        paiementRepository.findByContratId(ca1.getId()).forEach(p ->
                System.out.println("  > " + p.getDate() + " | " + p.getMontant() + " DH | " + p.getType()));

        System.out.println("\n--- Total payé contrat Auto 1 ---");
        System.out.println("  > " + paiementRepository.sumMontantByContratId(ca1.getId()) + " DH");
        System.out.println("========================================");
    }
}