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
    public void eiLisaaJosMeneeYli20e() {
        rolli.lisaaPelivarauksia(10);
        rolli.lisaaPelivarauksia(19);
        assertEquals(10.00, rolli.getRahat(), 0.01);
    }

    @Test
    public void kasvattaaVoittoa1() {
        rolli.lisaaPelivarauksia(1);
        rolli.setPanos(1);
        rolli.lisaaVoitto(8);
        assertEquals(9.00, rolli.getRahat(), 0.01);
    }

    @Test
    public void kasvattaaVoittoa2() {
        rolli.lisaaPelivarauksia(15);
        rolli.setPanos(2);
        rolli.lisaaVoitto(25);
        assertEquals(65.00, rolli.getRahat(), 0.01);
    }

    @Test
    public void poistaPanos() {
        rolli.lisaaPelivarauksia(6.00);
        rolli.setPanos(2.5);
        rolli.poistaPanos();
        assertEquals(3.50, rolli.getRahat(), 0.01);
    }

    @Test
    public void liianSuuriPanos() {
        rolli.lisaaPelivarauksia(1);
        rolli.setPanos(2);

        assertEquals(1.00, rolli.getRahat(), 0.01);
    }

    @Test
    public void kasvataPanostaKerran() {
        rolli.lisaaPelivarauksia(10.4);
        rolli.kasvataPanosta();
        assertEquals(0.40, rolli.getPanos(), 0.01);
    }

    @Test
    public void kasvataPanostaYli2E() {
        rolli.lisaaPelivarauksia(10.4);
        rolli.setPanos(1.8);
        rolli.kasvataPanosta();
        rolli.kasvataPanosta();
        assertEquals(0.20, rolli.getPanos(), 0.01);
    }

    @Test
    public void testaaEtteiMenePelivarauksenYliJaMenee20snt() {
        rolli.lisaaPelivarauksia(0.4);
        rolli.kasvataPanosta();
        rolli.kasvataPanosta();
        assertEquals(0.20, rolli.getPanos(), 0.01);
    }
}
