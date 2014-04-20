package JokersPokers.Kayttoliittyma;

import JokersPokers.Kortti.*;
import JokersPokers.Pelaaja.*;
import JokersPokers.Pokerikadet.ValmiitPokerikadet;
import JokersPokers.Tunnistaja.KadenTunnistaja;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author vujo@
 */

    public class Kayttoliittyma implements Runnable {

        private JFrame frame;
        private Korttipakka pakka;
        private Pelaaja pelaaja;
        private KadenTunnistaja tunnistaja;
        private ValmiitPokerikadet listaValmiistaKasista;

        @Override
        public void run() {
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(900, 750));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);      
        frame.pack();
        frame.setVisible(true);
        luoKomponentit(frame);
        
        }
        
        private void luoKomponentit(Container container) {
        LuoKorttipakka();
        LuoPelaaja();
        LuoKadenTunnistaja();
        LuoListaValmiistaKasista();
     
    }
        
        public void LuoKorttipakka() {
            this.pakka = new Korttipakka();
            pakka.luoKorttipakka();
        }
        
        public void LuoPelaaja() {
            this.pelaaja = new Pelaaja();
            pelaaja.luoPelikasi(pakka);
            
        }
        
        public void LuoKadenTunnistaja() {
            this.tunnistaja = new KadenTunnistaja();
            
        }
        
        public void LuoListaValmiistaKasista() {
            this.listaValmiistaKasista = new ValmiitPokerikadet();
            listaValmiistaKasista.luoListaKasista();
                    
        }
         
    }


