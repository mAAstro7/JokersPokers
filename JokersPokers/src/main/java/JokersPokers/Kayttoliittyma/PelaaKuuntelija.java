package JokersPokers.Kayttoliittyma;

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

    public void setPelivaraukset(Pelivaraukset pelivaraukset) {
        this.pelivaraukset = pelivaraukset;
    }

    public void setPanos(JButton panos) {
        this.panos = panos;
    }

    public PelaaKuuntelija(Pokerikasi pkasi, JLabel kortti1, JLabel kortti2, JLabel kortti3, JLabel kortti4, JLabel kortti5) {
        this.pkasi = pkasi;
        this.kortti1 = kortti1;
        this.kortti2 = kortti2;
        this.kortti3 = kortti3;
        this.kortti4 = kortti4;
        this.kortti5 = kortti5;
    }

    public void setKortinvaihtoButton(JButton b) {
        this.kortinvaihto = b;
    }

    public void setPokerikasi(Pokerikasi k) {
        this.pkasi = k;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pelaa) { 
            pakka.luoKorttipakka();
            Pokerikasi uusikasi = new Pokerikasi();
            uusikasi.luoPokeriKasi(pakka);
            this.pkasi = uusikasi;
            this.pakka = pakka;
            
            System.out.println(pkasi.getKortti(0).toString());

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

            panos.setEnabled(true);
            pelaa.setEnabled(true);
            tarkistaVoitto();
            pelivarauksettext.setText("Pelivaraukset: " + pelivaraukset.getRahat() + "" + "e");
            
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
