/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JokersPokers.Testit;

import JokersPokers.Kortti.Kortti;
import JokersPokers.Kortti.Korttipakka;
import JokersPokers.Pelaaja.Pokerikasi;
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
        assertEquals(52, pakka.getKorttienlkmPakassa());
    }
  @Test
  public void poistuukoKortti() {
      Kortti kortti;
      kortti = pakka.arvoKortti();
      pakka.poistaKortti(kortti);
      assertEquals(51, pakka.getKorttienlkmPakassa());
    }
  @Test
  public void poistuukoKortitkunluodaanKasi() {
      Pokerikasi kasi = new Pokerikasi();
      kasi.luoPokeriKasi(pakka);
      assertEquals(47, pakka.getKorttienlkmPakassa());
  }
}
