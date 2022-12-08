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
public class Zespol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime dataCzasDodania;

    private String nazwa;
    private String odpowiedzialnosc;


    @OneToMany(mappedBy = "zespol")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<CzlonekZespolu> czlonkowieZespolu;

}
