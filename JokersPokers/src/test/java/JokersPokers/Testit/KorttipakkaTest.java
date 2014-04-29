/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.JokersPokers.Testit;

import main.java.JokersPokers.Kortti.Kortti;
import main.java.JokersPokers.Kortti.Korttipakka;
import main.java.JokersPokers.Pelaaja.Pokerikasi;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jomppa
 */
public class KorttipakkaTest {
    private Korttipakka pakka;
    
    public KorttipakkaTest() {
        this.pakka = new Korttipakka();
        pakka.luoKorttipakka();
    }
    
  @Test
    public void onkoPakkaLuotuOikein() {
        assertEquals(53, pakka.getKorttienlkmPakassa());
    }
  @Test
  public void poistuukoKortti() {
      Kortti kortti;
      kortti = pakka.arvoKortti();
      pakka.poistaKortti(kortti);
      assertEquals(52, pakka.getKorttienlkmPakassa());
    }
  @Test
  public void poistuukoKortitkunluodaanKasi() {
      Pokerikasi kasi = new Pokerikasi();
      kasi.luoPokeriKasi(pakka);
      assertEquals(48, pakka.getKorttienlkmPakassa());
  }
}
