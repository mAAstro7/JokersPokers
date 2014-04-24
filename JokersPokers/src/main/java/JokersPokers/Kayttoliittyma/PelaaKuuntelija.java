package JokersPokers.Kayttoliittyma;

import JokersPokers.Kortti.Kortti;
import JokersPokers.Kortti.Korttipakka;
import JokersPokers.Pelaaja.*;
import JokersPokers.Pelaaja.*;
import JokersPokers.Pokerikadet.ValmiitPokerikadet;
import JokersPokers.Pokerikadet.ValmisPokerikasi;
import JokersPokers.Tunnistaja.KadenTunnistaja;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PelaaKuuntelija implements ActionListener {

    private KadenTunnistaja tunnistaja;
    private ValmiitPokerikadet listaValmiistaKasista;
    private Pokerikasi pkasi;
    private JLabel kortti1;
    private JLabel kortti2;
    private JLabel kortti3;
    private JLabel kortti4;
    private JLabel kortti5;
    private JButton kortinvaihto;
    private JButton panos;
    private JButton pelaa;
    private Pelivaraukset pelivaraukset;
    private JLabel pelivarauksettext;
    private Korttipakka pakka;
    private JButton ekaL;
    private JButton tokaL;
    private JButton kolL;
    private JButton nelL;
    private JButton viidL;
    private JLabel viimeisinvoitto;

    public PelaaKuuntelija(Pokerikasi pkasi, JLabel kortti1, JLabel kortti2, JLabel kortti3, JLabel kortti4, JLabel kortti5) {
        this.pkasi = pkasi;
        this.kortti1 = kortti1;
        this.kortti2 = kortti2;
        this.kortti3 = kortti3;
        this.kortti4 = kortti4;
        this.kortti5 = kortti5;
    }

    public void setViimeisinvoitto(JLabel viimeisinvoitto) {
        this.viimeisinvoitto = viimeisinvoitto;
    }

    public void setTunnistaja(KadenTunnistaja tunnistaja) {
        this.tunnistaja = tunnistaja;
    }

    public void setPakka(Korttipakka pakka) {
        this.pakka = pakka;
    }

    public void setListaValmiistaKasista(ValmiitPokerikadet listaValmiistaKasista) {
        this.listaValmiistaKasista = listaValmiistaKasista;
    }

    public void setPelivarauksettext(JLabel pelivarauksettext) {
        this.pelivarauksettext = pelivarauksettext;
    }

    public void setPelaa(JButton pelaa) {
        this.pelaa = pelaa;
    }

    public void setLukinnat(JButton ekaL, JButton tokaL, JButton kolmasL, JButton neljasL, JButton viidesL) {
        this.ekaL = ekaL;
        this.tokaL = tokaL;
        this.kolL = kolmasL;
        this.nelL = neljasL;
        this.viidL = viidesL;

    }

    public void setPelivaraukset(Pelivaraukset pelivaraukset) {
        this.pelivaraukset = pelivaraukset;
    }

    public void setPanos(JButton panos) {
        this.panos = panos;
    }

    public void setKortinvaihtoButton(JButton b) {
        this.kortinvaihto = b;
    }

    public void setPokerikasi(Pokerikasi k) {
        this.pkasi = k;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.ekaL) {

//            pkasi.vaihdaKortti(pakka, pkasi.getKortti(0));
            pkasi.vaihdaKorttiIndeksilla(pakka, 0);
        } else if (e.getSource() == tokaL) {
            pkasi.vaihdaKorttiIndeksilla(pakka, 1);
//            pkasi.vaihdaKortti(pakka, pkasi.getKortti(1));

        } else if (e.getSource() == kolL) {
            pkasi.vaihdaKorttiIndeksilla(pakka, 2);
//            pkasi.vaihdaKortti(pakka, pkasi.getKortti(2));

        } else if (e.getSource() == nelL) {
            pkasi.vaihdaKorttiIndeksilla(pakka, 3);
//            pkasi.vaihdaKortti(pakka, pkasi.getKortti(3));

        } else if (e.getSource() == viidL) {
            pkasi.vaihdaKorttiIndeksilla(pakka, 4);
//            pkasi.vaihdaKortti(pakka, pkasi.getKortti(4));


        } else if (e.getSource() == pelaa) {
            viimeisinvoitto.setText("Viimeisin voitto: " + pelivaraukset.getViimeisinvoitto() + "e");
            pakka.luoKorttipakka();
            Pokerikasi kasi = new Pokerikasi();
            kasi.luoPokeriKasi(pakka);
            this.pkasi = kasi;
            ImageIcon im = new ImageIcon("kuvat/" + pkasi.getKortti(0).toString() + ".png");
            kortti1.setIcon(im);
            ImageIcon im2 = new ImageIcon("kuvat/" + pkasi.getKortti(1).toString() + ".png");
            kortti2.setIcon(im2);
            ImageIcon im3 = new ImageIcon("kuvat/" + pkasi.getKortti(2).toString() + ".png");
            kortti3.setIcon(im3);
            ImageIcon im4 = new ImageIcon("kuvat/" + pkasi.getKortti(3).toString() + ".png");
            kortti4.setIcon(im4);
            ImageIcon im5 = new ImageIcon("kuvat/" + pkasi.getKortti(4).toString() + ".png");
            kortti5.setIcon(im5);

            panos.setEnabled(false);
            pelaa.setEnabled(false);
            kortinvaihto.setEnabled(true);
            pelivaraukset.poistaPanos();
            pelivarauksettext.setText("Pelivaraukset: " + pelivaraukset.getRahat() + "" + "e");

        } else if (e.getSource() == kortinvaihto) {

            ImageIcon im = new ImageIcon("kuvat/" + pkasi.getKortti(0).toString() + ".png");
            kortti1.setIcon(im);
            ImageIcon im2 = new ImageIcon("kuvat/" + pkasi.getKortti(1).toString() + ".png");
            kortti2.setIcon(im2);
            ImageIcon im3 = new ImageIcon("kuvat/" + pkasi.getKortti(2).toString() + ".png");
            kortti3.setIcon(im3);
            ImageIcon im4 = new ImageIcon("kuvat/" + pkasi.getKortti(3).toString() + ".png");
            kortti4.setIcon(im4);
            ImageIcon im5 = new ImageIcon("kuvat/" + pkasi.getKortti(4).toString() + ".png");
            kortti5.setIcon(im5);
            panos.setEnabled(true);
            pelaa.setEnabled(true);
            tarkistaVoitto();
                if (pelivaraukset.getRahat() == 0) {
                pelivaraukset.lisaaPelivarauksia(5);
                pelivarauksettext.setText("Pelivaraukset: " + pelivaraukset.getRahat() + "" + "e");
            viimeisinvoitto.setText("Hävisit kaiken, ota 5e lisää");
            } else {
            pelivarauksettext.setText("Pelivaraukset: " + pelivaraukset.getRahat() + "" + "e");
            viimeisinvoitto.setText("Viimeisin voitto: " + pelivaraukset.getViimeisinvoitto() + "e");
 
                }
        
 
            
        } else {
            
        }
    }

    public void tarkistaVoitto() {
        if (tunnistaja.onkoKuningasVarisuora(pkasi)) {
            pelivaraukset.lisaaVoitto(listaValmiistaKasista.getTiettykasi(10).getKerroin());
        } else if (tunnistaja.onkoVarisuora(pkasi)) {
            pelivaraukset.lisaaVoitto(listaValmiistaKasista.getTiettykasi(8).getKerroin());
        } else if (tunnistaja.onkoNeloset(pkasi)) {
            pelivaraukset.lisaaVoitto(listaValmiistaKasista.getTiettykasi(7).getKerroin());
        } else if (tunnistaja.onkoTaysKasi(pkasi)) {
            pelivaraukset.lisaaVoitto(listaValmiistaKasista.getTiettykasi(6).getKerroin());
        } else if (tunnistaja.onkoVari(pkasi)) {
            pelivaraukset.lisaaVoitto(listaValmiistaKasista.getTiettykasi(5).getKerroin());
        } else if (tunnistaja.onkoSuora(pkasi)) {
            pelivaraukset.lisaaVoitto(listaValmiistaKasista.getTiettykasi(4).getKerroin());
        } else if (tunnistaja.onkoKolmoset(pkasi)) {
            pelivaraukset.lisaaVoitto(listaValmiistaKasista.getTiettykasi(3).getKerroin());
        } else if (tunnistaja.onkoRattaat(pkasi)) {
            pelivaraukset.lisaaVoitto(listaValmiistaKasista.getTiettykasi(2).getKerroin());
        }

        kortinvaihto.setEnabled(false);
    }
}
