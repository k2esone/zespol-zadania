package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.Komentarz;
import pl.sda.hibernate.zespol.zadania.Zespol;

public class KomendaUsunKomentarz implements Komenda{
    private DataAccessObject<Komentarz> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "usun komentarz";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id komentarza, ktory chcesz usunac");
        Long id = Long.parseLong(Komenda.scanner.nextLine());
        if (dao.delete(Komentarz.class, id)) {
            System.out.println("Poprawnie usunieto komentarz");
        } else {
            System.err.println("Nie udalo sie usunac komentarza");
        }
    }
}
