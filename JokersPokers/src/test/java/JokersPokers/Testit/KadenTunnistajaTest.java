/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JokersPokers.Testit;

import JokersPokers.Kortti.Kortti;
import JokersPokers.Kortti.Korttipakka;
import JokersPokers.Pelaaja.Pokerikasi;
import JokersPokers.Pokerikadet.ValmiitPokerikadet;
import JokersPokers.Tunnistaja.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jomppa
 */
public class KadenTunnistajaTest {

    private KadenTunnistaja tunnistaja;
    private ValmiitPokerikadet kadet;
    private Pokerikasi kasi;

    public KadenTunnistajaTest() {

        this.kadet = new ValmiitPokerikadet();
        tunnistaja = new KadenTunnistaja();
        kadet.luoListaKasista();
        tunnistaja.setValmiitPokerikadet(kadet);

    
    }

    @Test
    public void tunnistaakoHain() {
        Kortti kortti1 = new Kortti("pata", 2);
        Kortti kortti2 = new Kortti("pata", 3);
        Kortti kortti3 = new Kortti("pata", 4);
        Kortti kortti4 = new Kortti("pata", 5);
        Kortti kortti5 = new Kortti("ruutu", 9);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(true, tunnistaja.onkoHai(kasi));
    }
    @Test
     public void tunnistaakoVarin() {
        Kortti kortti1 = new Kortti("pata", 2);
        Kortti kortti2 = new Kortti("pata", 3);
        Kortti kortti3 = new Kortti("pata", 4);
        Kortti kortti4 = new Kortti("pata", 5);
        Kortti kortti5 = new Kortti("pata", 9);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(true, tunnistaja.onkoVari(kasi));
    }
}
