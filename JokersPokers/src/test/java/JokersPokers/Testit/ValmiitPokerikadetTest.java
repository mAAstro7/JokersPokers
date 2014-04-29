/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.JokersPokers.Testit;

import main.java.JokersPokers.Pokerikadet.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jomppa
 */
public class ValmiitPokerikadetTest {

    private ValmiitPokerikadet listakasisata = new ValmiitPokerikadet();

    public ValmiitPokerikadetTest() {
        listakasisata.luoListaKasista();
    }
    
    @Test
    public void ovatkoKaikkikadetListalla() {

        assertEquals(11, listakasisata.getKasienlkm());
    }
    
    @Test
    public void toimiikoVertailu() {
        ValmisPokerikasi isompitesti;
        ValmisPokerikasi pienempitesti;
        pienempitesti = listakasisata.getTiettykasi("Pari");
        isompitesti = listakasisata.getTiettykasi("Suora");
        ValmisPokerikasi vertailussaSuurempi;
        if (isompitesti.compareTo(pienempitesti)>0) {
            vertailussaSuurempi = isompitesti;
        } else {
            vertailussaSuurempi = pienempitesti;
        }
        assertEquals("Suora", vertailussaSuurempi.getKasi());
    }
    
    @Test
    public void onkoVarisuoranKerroinOiekin() {
        ValmisPokerikasi testi;
        testi = listakasisata.getTiettykasi("Värisuora");
        assertEquals(40, testi.getKerroin());
    }
    
    @Test
    public void testataanSuurinKerroin () {
        int suurin = 0;
        for (int i = 0; i<listakasisata.getKasienlkm();i++) {
            if (listakasisata.getTiettykasi(i).getKerroin()>suurin) {
                suurin = listakasisata.getTiettykasi(i).getKerroin();
            } 
        }
        assertEquals(200, suurin);
    }
    
    @Test
    public void onkoTayskadenNimiOiekin() {
        ValmisPokerikasi testi;
        testi = listakasisata.getTiettykasi("Täyskäsi");
        System.out.println(testi.getKasi());
        assertEquals("Täyskäsi", testi.getKasi());
    }
}
