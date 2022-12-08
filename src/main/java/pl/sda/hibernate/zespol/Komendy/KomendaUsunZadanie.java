package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.Komentarz;
import pl.sda.hibernate.zespol.zadania.Zadanie;

public class KomendaUsunZadanie implements Komenda{
    private DataAccessObject<Zadanie> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "usun zadanie";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id zadania, ktore chcesz usunac");
        Long id = Long.parseLong(Komenda.scanner.nextLine());
        if (dao.delete(Zadanie.class, id)) {
            System.out.println("Poprawnie usunieto zadanie");
        } else {
            System.err.println("Nie udalo sie usunac zadania");
        }
    }
}
