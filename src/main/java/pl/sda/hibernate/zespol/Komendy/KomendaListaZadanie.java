package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.Zadanie;
import pl.sda.hibernate.zespol.zadania.Zespol;

import java.util.List;

public class KomendaListaZadanie implements Komenda{
    private DataAccessObject<Zadanie> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista zadanie";
    }

    @Override
    public void obsluga() {
        List<Zadanie> list = dao.findAll(Zadanie.class);
        for (Zadanie zadanie : list) {
            System.out.println(zadanie);
        }

    }
}
