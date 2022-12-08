package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.Komentarz;
import pl.sda.hibernate.zespol.zadania.Zespol;

import java.util.List;

public class KomendaListaKomentarz implements Komenda{
    private DataAccessObject<Komentarz> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista komentarz";
    }

    @Override
    public void obsluga() {
        List<Komentarz> list = dao.findAll(Komentarz.class);
        for (Komentarz komentarz : list) {
            System.out.println(komentarz);
        }

    }
}
