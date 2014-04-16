package JokersPokers.JokersPokers;

import JokersPokers.Kayttoliittyma.Kayttoliittyma;
import JokersPokers.Kortti.Kortti;
import JokersPokers.Pelaaja.Pokerikasi;
import JokersPokers.Kortti.Korttipakka;
import JokersPokers.Pelaaja.Pelivaraukset;
import JokersPokers.Pokerikadet.*;
import JokersPokers.Tunnistaja.KadenTunnistaja;
import javax.swing.SwingUtilities;

public class Ohjelma {

    
    public static void main(String[] args) {
        Kayttoliittyma kayttis = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttis);

    }
}
