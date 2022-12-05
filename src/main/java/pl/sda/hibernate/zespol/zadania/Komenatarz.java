package pl.sda.hibernate.zespol.zadania;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Komenatarz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate dataDodania;

    private String tresc;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CzlonekZespolu czlonekZespolu;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Zadanie zadanie;
}
