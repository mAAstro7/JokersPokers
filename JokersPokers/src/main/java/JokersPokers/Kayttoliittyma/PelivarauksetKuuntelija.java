
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panosKasvaa) {
            pvaraus.kasvataPanosta();
            panos.setText("Panos: "+ pvaraus.getPanos()+"e");
        }
        
        
    }
}
