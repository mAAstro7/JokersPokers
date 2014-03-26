/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JokersPokers.Testit;

import JokersPokers.Pelaaja.Pokerikasi;
import JokersPokers.Kortti.Kortti;
import JokersPokers.Kortti.Korttipakka;
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
    public void testaaVaihtuukoKortti() {
        String vanhapakka = pokerikasi.toString();
        Kortti kortti = pokerikasi.getViimeinenKortti();
        this.pokerikasi.vaihdaKortti(pakka, kortti);
        assertFalse("samat on", pokerikasi.toString().equals(vanhapakka));
    }
    
}
