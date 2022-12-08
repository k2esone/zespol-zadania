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

    @Enumerated(value = EnumType.STRING)
    private Priorytet priorytet;


    @OneToMany(mappedBy = "zadanie")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Komentarz> komentarze;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CzlonekZespolu czlonekZespolu;

}
