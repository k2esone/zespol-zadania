package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.CzlonekZespolu;
import pl.sda.hibernate.zespol.zadania.Komentarz;
import pl.sda.hibernate.zespol.zadania.Zadanie;

import java.util.Optional;

public class KomendaDodajKomentarz implements Komenda{
    private DataAccessObject<Komentarz> dao = new DataAccessObject<>();
    private DataAccessObject<Zadanie> daoZad = new DataAccessObject<>();
    private DataAccessObject<CzlonekZespolu> daoCz = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj komentarz";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id zadania, do ktorego chcesz dodac komentarz");
        Long idZad = Long.parseLong(Komenda.scanner.nextLine());
        Optional<Zadanie> zadanie = daoZad.find(Zadanie.class, idZad);

        if (zadanie.isEmpty()){
            System.err.println("Nie znaleziono zadania");
            return;
        } else {
            System.out.println("Podaj id czlonka zespolu, ktory dodaje komentarz");
            Long idCz = Long.parseLong(Komenda.scanner.nextLine());
            Optional<CzlonekZespolu> czlonekZespolu = daoCz.find(CzlonekZespolu.class, idCz);
            if (czlonekZespolu.isEmpty()){
                System.err.println("Nie znaleziono czlonka zespolu");
                return;
            } else {
                System.out.println("Podaj tresc komentarza");
                String tresc = Komenda.scanner.nextLine();

                Komentarz komentarz = Komentarz.builder()
                        .tresc(tresc)
                        .zadanie(zadanie.get())
                        .czlonekZespolu(czlonekZespolu.get())
                        .build();

                dao.insert(komentarz);

            }
        }

    }
}
