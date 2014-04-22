
package JokersPokers.Kayttoliittyma;

import JokersPokers.Pelaaja.*;
import JokersPokers.Pelaaja.*;
import java.awt.event.*;
import javax.swing.*;


public class PelaaKuuntelija implements ActionListener {

    private Pokerikasi pkasi;
    private JButton kortti1;
    private JButton kortti2;
    private JButton kortti3;
    private JButton kortti4;
    private JButton kortti5;
    private JButton kortinvaihto;
    private JButton panos;
    private JButton pelaa;
    private Pelivaraukset pelivaraukset;
    private JLabel pelivarauksettext;

    public void setPelivarauksettext(JLabel pelivarauksettext) {
        this.pelivarauksettext = pelivarauksettext;
    }

    public void setPelaa(JButton pelaa) {
        this.pelaa = pelaa;
    }

    public void setPelivaraukset(Pelivaraukset pelivaraukset) {
        this.pelivaraukset = pelivaraukset;
    }

    public void setPanos(JButton panos) {
        this.panos = panos;
    }

    public PelaaKuuntelija(Pokerikasi pkasi, JButton kortti1, JButton kortti2, JButton kortti3, JButton kortti4, JButton kortti5) {
        this.pkasi = pkasi;
        this.kortti1 = kortti1;
        this.kortti2 = kortti2;
        this.kortti3 = kortti3;
        this.kortti4 = kortti4;
        this.kortti5 = kortti5;
    }
    
    public void setKortinvaihtoButton (JButton b) {
        this.kortinvaihto = b;
    }
    

    public void setPokerikasi (Pokerikasi k) {
        this.pkasi = k;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == kortinvaihto ) {
             
        kortti1.setText(pkasi.getKortti(1).toString());
        kortti2.setText(pkasi.getKortti(1).toString());
        kortti3.setText(pkasi.getKortti(1).toString());
        kortti4.setText(pkasi.getKortti(1).toString());
        kortti5.setText(pkasi.getKortti(1).toString());
        
            
        } else {

        kortti1.setText(pkasi.getKortti(0).toString());
        kortti2.setText(pkasi.getKortti(1).toString());
        kortti3.setText(pkasi.getKortti(2).toString());
        kortti4.setText(pkasi.getKortti(3).toString());
        kortti5.setText(pkasi.getKortti(4).toString());
        panos.setEnabled(false);
        pelaa.setEnabled(false);
        kortinvaihto.setEnabled(true);
        pelivaraukset.poistaPanos();
        pelivarauksettext.setText("Pelivaraukset: " + pelivaraukset.getRahat() + "" + "e");
        
        }
    }
    
    
    
}
