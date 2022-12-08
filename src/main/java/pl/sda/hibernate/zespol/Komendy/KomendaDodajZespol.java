package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.Zespol;

public class KomendaDodajZespol implements Komenda {
    private DataAccessObject<Zespol> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj zespol";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nazwe zespolu");
        String nazwa = Komenda.scanner.nextLine();

        System.out.println("Podaj odpowiedzialnosc zespolu");
        String odpowiedzialnosc = Komenda.scanner.nextLine();

        Zespol zespol = Zespol.builder()
                .nazwa(nazwa)
                .odpowiedzialnosc(odpowiedzialnosc)
                .build();

        dao.insert(zespol);
    }
}
