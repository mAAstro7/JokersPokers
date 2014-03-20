package JokersPokers.JokersPokers;

import JokersPokers.Pelaaja.Pokerikasi;
import JokersPokers.Korttii.Korttipakka;

public class Ohjelma {

    public static void main(String[] args) {

        Korttipakka pakka = new Korttipakka();
        pakka.luoKorttipakka();
        Pokerikasi kasi = new Pokerikasi();
        kasi.luoPokeriKasi(pakka);
        System.out.println(kasi.toString());
        System.out.println(kasi.getKorttienlkmKadessa());
        kasi.vaihdaKortti(pakka, kasi.getViimeinenKortti());
        System.out.println(kasi.toString());
        System.out.println(kasi.getKorttienlkmKadessa());
    }
}
