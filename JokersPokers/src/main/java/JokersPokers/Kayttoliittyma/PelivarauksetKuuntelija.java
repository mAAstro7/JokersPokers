/**
 * Luokka hoitaa pelivarauksen graafisessa käyttöliittymässä.
 * 
 */


package JokersPokers.Kayttoliittyma;

import JokersPokers.Pelaaja.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class PelivarauksetKuuntelija implements ActionListener {

    private JButton panosKasvaa;
    private JLabel panos;
    private Pelivaraukset pvaraus;

    public PelivarauksetKuuntelija(JButton button, Pelivaraukset varaus) {

        this.panosKasvaa = button;
        this.pvaraus = varaus;
        
    }
    
    public void setPanosKenttä(JLabel laabeli) {
            panos = laabeli;
    }
    
    
    /**
 * Muuttaa panoksen sekä JLabelin joka näyttää panoksen oikeaksi. 
 * Tätä käytetään kun panos ylittää pelivaraukset hävityn kierroksen jälkeen
 
 */
        public void setPanos () {
            if(pvaraus.getPanos()>pvaraus.getRahat()) {
                  
                 panos.setText("Panos: "+ pvaraus.getRahat()+"e");
                 pvaraus.setPanos(pvaraus.getRahat());
            }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panosKasvaa) {
            pvaraus.kasvataPanosta();
            panos.setText("Panos: "+ pvaraus.getPanos()+"e");
        }
        
        
    }
}
