package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.Zespol;

import java.util.List;

public class KomendaListaZespol implements Komenda{
    private DataAccessObject<Zespol> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista zespol";
    }

    @Override
    public void obsluga() {
        List<Zespol> list = dao.findAll(Zespol.class);
        for (Zespol zespol : list) {
            System.out.println(zespol);
        }

    }
}
