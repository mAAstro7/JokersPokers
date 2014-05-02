/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JokersPokers.Testit;


import JokersPokers.Kortti.*;
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
        assertEquals(53, pakka.getKorttienlkmPakassa());
    }
  
    @Test
    public void onkoPakkaLuotuOikeinIlmanJokeria() {
        this.pakka = new Korttipakka();
        pakka.luoKorttipakkaIlmanJokeria();
        assertEquals(52, pakka.getKorttienlkmPakassa());
    }
    
        @Test
    public void lisaytyykoJokeri() {
        this.pakka = new Korttipakka();
        pakka.luoKorttipakkaIlmanJokeria();
        pakka.lisaaJokeri();
        assertEquals(53, pakka.getKorttienlkmPakassa());
        
    }
        
  @Test
  public void poistuukoKorttiArvottaessa() {
      Kortti kortti;
      kortti = pakka.arvoKortti();
      assertEquals(52, pakka.getKorttienlkmPakassa());
    }
  
  @Test
  public void poistuukoKortitkunluodaanKasi() {
      Pokerikasi kasi = new Pokerikasi();
      kasi.luoPokeriKasi(pakka);
      assertEquals(48, pakka.getKorttienlkmPakassa());
  }
}
