/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.JokersPokers.Testit;

import main.java.JokersPokers.Pelaaja.Pokerikasi;
import main.java.JokersPokers.Kortti.Kortti;
import main.java.JokersPokers.Kortti.Korttipakka;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jomppa
 */
public class PokeriKasiTest {

    private Pokerikasi pokerikasi;
    private Korttipakka pakka;

    public PokeriKasiTest() {
        this.pakka = new Korttipakka();
        this.pokerikasi = new Pokerikasi();
        pakka.luoKorttipakka();
        pokerikasi.luoPokeriKasi(pakka);
    }

    @Test
    public void onkoPokeriKasiLuotuOikeint() {
        assertEquals(5, pokerikasi.getKorttienlkmKadessa());
    }

    @Test
    public void poistuukoKortti() {
        Kortti kortti = pokerikasi.getViimeinenKortti();
        this.pokerikasi.poistaKortti(kortti);
        assertEquals(4, pokerikasi.getKorttienlkmKadessa());
    }
        @Test
    public void poistuukoKorttiIndeksinavulla() {
        this.pokerikasi.poistaKorttiIndex(2);
        assertEquals(4, pokerikasi.getKorttienlkmKadessa());
    }
    @Test
    public void testaaVaihtuukoKortti() {
        String vanhahanska = pokerikasi.toString();
        Kortti kortti = pokerikasi.getViimeinenKortti();
        this.pokerikasi.vaihdaKortti(pakka, kortti);
        assertFalse("samat on", pokerikasi.toString().equals(vanhahanska));
    }
    
}
