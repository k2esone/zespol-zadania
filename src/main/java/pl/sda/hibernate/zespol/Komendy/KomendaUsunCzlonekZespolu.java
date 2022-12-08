package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.CzlonekZespolu;
import pl.sda.hibernate.zespol.zadania.Zespol;

public class KomendaUsunCzlonekZespolu implements Komenda{
    private DataAccessObject<CzlonekZespolu> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "usun czlonek zespolu";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id czlonka zespolu, ktorego chcesz usunac");
        Long id = Long.parseLong(Komenda.scanner.nextLine());
        if (dao.delete(CzlonekZespolu.class, id)) {
            System.out.println("Poprawnie usunieto czlonka zespolu");
        } else {
            System.err.println("Nie udalo sie usunac czlonka zespolu");
        }
    }
}
