package pl.sda.hibernate.zespol.Komendy;

import java.util.Scanner;

public interface Komenda {
    Scanner scanner = new Scanner(System.in);

    String getKomenda();

    void obsluga();
}
