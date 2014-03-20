/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jokerpokers.git.jokerspokers;
import Pelaaja.*;
import jokerpokers.git.jokerspokers.Kortti.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 *
 * @author Jomppa
 */
public class KorttiTest{
    
    private Pokerikasi pokerikasi;
    private Korttipakka pakka;
    
    public KorttiTest() {
       this.pakka = new Korttipakka();
       this.pokerikasi = new Pokerikasi();
       pokerikasi.luoPokeriKasi(pakka);
    }
    
    @Test
     public void onkoPokeriKasilegit() {
         this.pokerikasi.luoPokeriKasi(pakka);
         assertEquals(5, pokerikasi.getKorttienlkm());
    }
      @Test
     public void poistuukoKortti() {
         this.pokerikasi.poistaKortti(1);
         assertEquals(4, pokerikasi.getKorttienlkm());
    }


}
