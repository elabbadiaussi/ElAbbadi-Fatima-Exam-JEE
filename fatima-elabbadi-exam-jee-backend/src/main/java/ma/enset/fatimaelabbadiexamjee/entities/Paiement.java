package ma.enset.fatimaelabbadiexamjee.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.enset.fatimaelabbadiexamjee.enums.TypePaiement;

import java.time.LocalDate;

@Entity
@Table(name = "paiements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double montant;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypePaiement type;     // MENSUALITE, PAIEMENT_ANNUEL, PAIEMENT_EXCEPTIONNEL

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contrat_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Contrat contrat;
}