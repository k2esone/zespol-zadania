package pl.sda.hibernate.zespol.Komendy;

import pl.sda.hibernate.zespol.database.DataAccessObject;
import pl.sda.hibernate.zespol.zadania.CzlonekZespolu;
import pl.sda.hibernate.zespol.zadania.Zespol;

import java.util.List;

public class KomendaListaCzlonekZespolu implements Komenda{
    private DataAccessObject<CzlonekZespolu> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista czlonek zespolu";
    }

    @Override
    public void obsluga() {
        List<CzlonekZespolu> list = dao.findAll(CzlonekZespolu.class);
        for (CzlonekZespolu czlonekZespolu : list) {
            System.out.println(czlonekZespolu);
        }

    }
}
