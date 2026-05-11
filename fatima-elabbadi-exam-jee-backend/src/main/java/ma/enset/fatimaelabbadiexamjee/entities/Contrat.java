package ma.enset.fatimaelabbadiexamjee.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import ma.enset.fatimaelabbadiexamjee.enums.StatutContrat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contrats")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name = "TYPE_CONTRAT",             
                     discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder                   
public abstract class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateSouscription;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutContrat statut;

    private LocalDate dateValidation;

    @Column(nullable = false)
    private Double montantCotisation;

    @Column(nullable = false)
    private Integer dureeContrat;       

    @Column(nullable = false)
    private Double tauxCouverture;     

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Client client;

    @OneToMany(mappedBy = "contrat",
               cascade = CascadeType.ALL,
               fetch = FetchType.LAZY,
               orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    // @SuperBuilder.ObtainVia(delegate = true)
    @Builder.Default
    private List<Paiement> paiements = new ArrayList<>();
}