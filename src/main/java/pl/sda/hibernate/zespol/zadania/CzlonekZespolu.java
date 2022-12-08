package pl.sda.hibernate.zespol.zadania;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CzlonekZespolu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime dataCzasDolaczenia;

    private String imie;
    private String nazwisko;

    @Enumerated(value = EnumType.STRING)
    private CzyJestCzlonkiem czyJestCzlonkiem;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Zespol zespol;

    @OneToMany(mappedBy = "czlonekZespolu")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Komentarz> komentarze;

    @OneToMany(mappedBy = "czlonekZespolu")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Zadanie> zadania;

}
