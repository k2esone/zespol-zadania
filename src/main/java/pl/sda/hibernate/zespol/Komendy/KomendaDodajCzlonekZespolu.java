package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.CzlonekZespolu;
import pl.sda.hibernate.zespol.zadania.CzyJestCzlonkiem;
import pl.sda.hibernate.zespol.zadania.Zespol;

import java.util.Locale;
import java.util.Optional;

public class KomendaDodajCzlonekZespolu implements Komenda {
    private DataAccessObject<CzlonekZespolu> dao = new DataAccessObject<>();
    private DataAccessObject<Zespol> daoZespol = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj czlonek zespolu";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj imie");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj nazwisko");
        String nazwisko = Komenda.scanner.nextLine();

        System.out.println("Czy jest czlonkiem?");
        CzyJestCzlonkiem czyJestCzlonkiem = CzyJestCzlonkiem
                .valueOf(Komenda.scanner.nextLine().toUpperCase(Locale.ROOT));

        if (czyJestCzlonkiem.equals(CzyJestCzlonkiem.TAK)) {
            System.out.println("Podaj id zespolu, do ktorego nalezy czlonek");
            Long id = Long.parseLong(Komenda.scanner.nextLine());

            Optional<Zespol> zespol = daoZespol.find(Zespol.class, id);

            CzlonekZespolu czlonek = CzlonekZespolu.builder()
                    .imie(imie)
                    .nazwisko(nazwisko)
                    .czyJestCzlonkiem(czyJestCzlonkiem)
                    .zespol(zespol.get())
                    .build();

            dao.insert(czlonek);
        } else if (czyJestCzlonkiem.equals(CzyJestCzlonkiem.NIE)) {
            CzlonekZespolu czlonek = CzlonekZespolu.builder()
                    .imie(imie)
                    .nazwisko(nazwisko)
                    .czyJestCzlonkiem(czyJestCzlonkiem)
                    .build();

            dao.insert(czlonek);

        } else {
            System.err.println("Blad");
        }

    }
}
