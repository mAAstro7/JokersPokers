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

    @Test
    public void tunnistaakoEtteiOleVari() {
        Kortti kortti1 = new Kortti("pata", 2);
        Kortti kortti2 = new Kortti("pata", 3);
        Kortti kortti3 = new Kortti("ruutu", 4);
        Kortti kortti4 = new Kortti("pata", 5);
        Kortti kortti5 = new Kortti("pata", 9);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(false, tunnistaja.onkoVari(kasi));
    }

    @Test
    public void tunnistaako26Suoran() {
        Kortti kortti1 = new Kortti("pata", 2);
        Kortti kortti2 = new Kortti("hertta", 3);
        Kortti kortti3 = new Kortti("risti", 4);
        Kortti kortti4 = new Kortti("pata", 5);
        Kortti kortti5 = new Kortti("pata", 6);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(true, tunnistaja.onkoSuora(kasi));
    }

    @Test
    public void tunnistaakoEtteiOleSuora() {
        Kortti kortti1 = new Kortti("pata", 2);
        Kortti kortti2 = new Kortti("hertta", 3);
        Kortti kortti3 = new Kortti("risti", 4);
        Kortti kortti4 = new Kortti("pata", 9);
        Kortti kortti5 = new Kortti("pata", 6);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(false, tunnistaja.onkoSuora(kasi));
    }

    @Test
    public void tunnistaakoATSuoran() {
        Kortti kortti1 = new Kortti("pata", 14);
        Kortti kortti2 = new Kortti("hertta", 13);
        Kortti kortti3 = new Kortti("risti", 11);
        Kortti kortti4 = new Kortti("pata", 10);
        Kortti kortti5 = new Kortti("pata", 12);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(true, tunnistaja.onkoSuora(kasi));
    }

    @Test
    public void tunnistaakoA5Suoran() {
        Kortti kortti1 = new Kortti("pata", 14);
        Kortti kortti2 = new Kortti("hertta", 2);
        Kortti kortti3 = new Kortti("risti", 3);
        Kortti kortti4 = new Kortti("pata", 4);
        Kortti kortti5 = new Kortti("pata", 5);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(true, tunnistaja.onkoSuora(kasi));
    }

    @Test
    public void tunnistaakoVarisuoran() {
        Kortti kortti1 = new Kortti("pata", 7);
        Kortti kortti2 = new Kortti("pata", 6);
        Kortti kortti3 = new Kortti("pata", 3);
        Kortti kortti4 = new Kortti("pata", 4);
        Kortti kortti5 = new Kortti("pata", 5);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(true, tunnistaja.onkoVarisuora(kasi));
    }

    @Test
    public void tunnistaakoRoyalVarisuoran() {
        Kortti kortti1 = new Kortti("hertta", 10);
        Kortti kortti2 = new Kortti("hertta", 11);
        Kortti kortti3 = new Kortti("hertta", 13);
        Kortti kortti4 = new Kortti("hertta", 12);
        Kortti kortti5 = new Kortti("hertta", 14);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(true, tunnistaja.onkoKuningasVarisuora(kasi));
    }

    @Test
    public void tunnistaakoNeloset() {
        Kortti kortti1 = new Kortti("hertta", 14);
        Kortti kortti2 = new Kortti("ruutu", 10);
        Kortti kortti3 = new Kortti("pata", 10);
        Kortti kortti4 = new Kortti("risti", 10);
        Kortti kortti5 = new Kortti("hertta", 10);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(true, tunnistaja.onkoNeloset(kasi));
    }

    @Test
    public void tunnistaakoEtteKasiEiOleNeloset() {
        Kortti kortti1 = new Kortti("hertta", 10);
        Kortti kortti2 = new Kortti("ruutu", 7);
        Kortti kortti3 = new Kortti("pata", 10);
        Kortti kortti4 = new Kortti("risti", 10);
        Kortti kortti5 = new Kortti("hertta", 14);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(false, tunnistaja.onkoNeloset(kasi));
    }

    @Test
    public void tunnistaakoTayskaden() {
        Kortti kortti1 = new Kortti("hertta", 4);
        Kortti kortti2 = new Kortti("ruutu", 10);
        Kortti kortti3 = new Kortti("pata", 10);
        Kortti kortti4 = new Kortti("risti", 10);
        Kortti kortti5 = new Kortti("ruutu", 4);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(true, tunnistaja.onkoTaysKasi(kasi));
    }
    
     @Test
    public void tunnistaakoEttaKasiEiOleTayskasi() {
        Kortti kortti1 = new Kortti("hertta", 4);
        Kortti kortti2 = new Kortti("ruutu", 10);
        Kortti kortti3 = new Kortti("pata", 10);
        Kortti kortti4 = new Kortti("risti", 2);
        Kortti kortti5 = new Kortti("ruutu", 4);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(false, tunnistaja.onkoTaysKasi(kasi));
    }
    
         @Test
    public void tunnistaakoKolmoset() {
        Kortti kortti1 = new Kortti("hertta", 4);
        Kortti kortti2 = new Kortti("ruutu", 10);
        Kortti kortti3 = new Kortti("pata", 10);
        Kortti kortti4 = new Kortti("risti", 2);
        Kortti kortti5 = new Kortti("ruutu", 10);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(true, tunnistaja.onkoKolmoset(kasi));
    }
        @Test
    public void tunnistaakoepaKolmoset() {
        Kortti kortti1 = new Kortti("hertta", 4);
        Kortti kortti2 = new Kortti("ruutu", 10);
        Kortti kortti3 = new Kortti("pata", 2);
        Kortti kortti4 = new Kortti("risti", 2);
        Kortti kortti5 = new Kortti("ruutu", 10);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(false, tunnistaja.onkoKolmoset(kasi));
    }
    
          @Test
    public void tunnistaakoKaksiParia() {
        Kortti kortti1 = new Kortti("hertta", 4);
        Kortti kortti2 = new Kortti("ruutu", 10);
        Kortti kortti3 = new Kortti("pata", 2);
        Kortti kortti4 = new Kortti("risti", 2);
        Kortti kortti5 = new Kortti("ruutu", 10);
        this.kasi = new Pokerikasi(kortti1, kortti2, kortti3, kortti4, kortti5);
        assertEquals(true, tunnistaja.onkoRattaat(kasi));
    }
}
