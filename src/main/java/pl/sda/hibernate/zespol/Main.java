package pl.sda.hibernate.zespol;

import pl.sda.hibernate.zespol.Komendy.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Komenda> listKomend = new ArrayList<>(
                List.of(
                        new KomendaDodajZespol(),
                        new KomendaDodajCzlonekZespolu(),
                        new KomendaDodajZadanie(),
                        new KomendaDodajKomentarz(),
                        new KomendaListaZespol(),
                        new KomendaListaCzlonekZespolu(),
                        new KomendaListaZadanie(),
                        new KomendaListaKomentarz(),
                        new KomendaUsunZespol(),
                        new KomendaUsunCzlonekZespolu(),
                        new KomendaUsunZadanie(),
                        new KomendaUsunKomentarz()

                        )
        );

        String komenda;
        do {
            System.out.println("Lista dostepnych komend:");
            for (int i = 0; i < listKomend.size(); i++) {
                System.out.println(i + 1 + ". " + listKomend.get(i).getKomenda());
            }
            System.out.println("Podaj komende:");
            komenda = Komenda.scanner.nextLine();

            for (Komenda dostepnaKomenda : listKomend) {
                if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                    dostepnaKomenda.obsluga();
                }
            }
        } while (!komenda.equalsIgnoreCase("exit"));
    }
}
