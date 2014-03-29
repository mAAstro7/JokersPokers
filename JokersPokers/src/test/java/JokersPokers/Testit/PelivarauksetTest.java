/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JokersPokers.Testit;

import JokersPokers.Pelaaja.Pelivaraukset;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jomppa
 */
public class PelivarauksetTest {
    private Pelivaraukset rolli;
    
    public PelivarauksetTest() {
        this.rolli = new Pelivaraukset();
    }
    
     @Test
    public void lisaakoPelivaraukset() {
        rolli.lisaaPelivarauksia(8);
        assertEquals(8.00, rolli.getRahat(), 0.01);
    }
     
     @Test
     public void eiLisaaJosMeneeYli20e () {
         rolli.lisaaPelivarauksia(10);
         rolli.lisaaPelivarauksia(19);
         assertEquals(10.00, rolli.getRahat(), 0.01);
     }
     
     @Test
     public void kasvattaaVoittoa1() {
         rolli.lisaaPelivarauksia(1);
         rolli.lisaaVoitto(1, 8); 
         assertEquals(9.00, rolli.getRahat(), 0.01);
     }    
     
     @Test
     public void kasvattaaVoittoa2() {
         rolli.lisaaPelivarauksia(15);
         rolli.lisaaVoitto(2, 25); 
         assertEquals(65.00, rolli.getRahat(), 0.01);
     }    
     
     @Test
     public void poistaPanos () {
         rolli.lisaaPelivarauksia(6.00);
         rolli.poistaPanos(2.50);
         assertEquals(3.50, rolli.getRahat(), 0.01);
}
     
     @Test
     public void liianSuuriPanos () {
         rolli.lisaaPelivarauksia(1);
         rolli.poistaPanos(2);
         assertEquals(1.00, rolli.getRahat(), 0.01);
     }
}
