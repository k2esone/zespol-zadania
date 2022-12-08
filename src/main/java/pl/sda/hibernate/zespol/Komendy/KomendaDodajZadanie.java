package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.*;

import java.util.Locale;
import java.util.Optional;

public class KomendaDodajZadanie implements Komenda {
    private DataAccessObject<CzlonekZespolu> daoCzlonek = new DataAccessObject<>();
    private DataAccessObject<Zespol> daoZespol = new DataAccessObject<>();
    private DataAccessObject<Zadanie> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj zadanie";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id czlonka zespolu, ktoremu chcesz dodac zadanie");
        Long id = Long.parseLong(Komenda.scanner.nextLine());
        Optional<CzlonekZespolu> czlonekZespolu = daoCzlonek.find(CzlonekZespolu.class, id);
        if (czlonekZespolu.isEmpty()) {
            System.err.println("Nie znaleziono czlonka");
        } else {

            System.out.println("Podaj tytul");
            String tytul = Komenda.scanner.nextLine();

            System.out.println("Podaj opis");
            String opis = Komenda.scanner.nextLine();

            System.out.println("Podaj priorytet MALY/SREDNI/WYSOKI");
            Priorytet priorytet = Priorytet
                    .valueOf(Komenda.scanner.nextLine().toUpperCase(Locale.ROOT));

            Zadanie zadanie = Zadanie.builder()
                    .tytul(tytul)
                    .opis(opis)
                    .priorytet(priorytet)
                    .czlonekZespolu(czlonekZespolu.get())
                    .build();

            dao.insert(zadanie);

        }
    }
}
