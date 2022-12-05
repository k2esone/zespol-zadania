package pl.sda.hibernate.zespol.zadania;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Zadanie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate dataDodania;

    private String tytul;
    private String opis;
    private Priorytet priorytet;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Zespol zespol;

    @OneToMany(mappedBy = "zadanie")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Komenatarz> komentarze;

}
