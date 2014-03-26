/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JokersPokers.Testit;

import JokersPokers.Pokerikadet.*;
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
    public void onkoVarisuoranKerroinOiekin() {
        ValmisPokerikasi testi;
        testi = listakasisata.getTiettykasi("Värisuora");
        assertEquals(40, testi.getKerroin());
    }
    
    @Test
    public void onkoTayskadenNimiOiekin() {
        ValmisPokerikasi testi;
        testi = listakasisata.getTiettykasi("Täyskäsi");
        System.out.println(testi.getKasi());
        assertEquals("Täyskäsi", testi.getKasi());
    }
}
