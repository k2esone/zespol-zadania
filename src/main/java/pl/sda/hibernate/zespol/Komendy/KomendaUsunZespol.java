package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.Zespol;

public class KomendaUsunZespol implements Komenda{
    private DataAccessObject<Zespol> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "usun zespol";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id zespolu, ktory chcesz usunac");
        Long id = Long.parseLong(Komenda.scanner.nextLine());
        if (dao.delete(Zespol.class, id)) {
            System.out.println("Poprawnie usunieto zespol");
        } else {
            System.err.println("Nie udalo sie usunac zespolu");
        }
    }
}
