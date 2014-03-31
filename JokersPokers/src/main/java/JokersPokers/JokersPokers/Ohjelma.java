package JokersPokers.JokersPokers;

import JokersPokers.Kortti.Kortti;
import JokersPokers.Pelaaja.Pokerikasi;
import JokersPokers.Kortti.Korttipakka;
import JokersPokers.Pelaaja.Pelivaraukset;
import JokersPokers.Pokerikadet.*;
import JokersPokers.Tunnistaja.KadenTunnistaja;

public class Ohjelma {

    
    public static void main(String[] args) {
        Kortti kortti1 = new Kortti("pata", 2);
        Kortti kortti2 = new Kortti("pata", 3);
        Kortti kortti3 = new Kortti("pata", 4);
        Kortti kortti4 = new Kortti("pata", 5);
        Kortti kortti5 = new Kortti("ruutu", 9);
        Pokerikasi kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        KadenTunnistaja tunnistaja = new KadenTunnistaja();
        if (tunnistaja.onkoHai(kasi)) {
            System.out.println("ON KÄSIII");
        } else {
            System.out.println("tänne ei päästä");
        }
    }
}
