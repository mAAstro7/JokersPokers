package JokersPokers.Kayttoliittyma;

import JokersPokers.Kortti.*;
import JokersPokers.Pelaaja.*;
import JokersPokers.Pokerikadet.ValmiitPokerikadet;
import JokersPokers.Tunnistaja.KadenTunnistaja;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
    private boolean kierroskesken = true;
    //kuuntelijat
    private PelivarauksetKuuntelija pvKuuntelija;
    private PelaaKuuntelija pelaaKuuntelija;

    @Override
    public void run() {
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(900, 750));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        luoKomponentit(frame);
        
    }
    
/**
 * Metodi luo kaikki komponentit mitä käyttöliittymään tarvitaan. Käyttöliittymä on jaettu 3 ryhmään: 
 * 1: alaosa joka pitää sisällään panoksen kasvatuksen, korttienvaihton ja pelaa painikkeen
 * 2: keskiosa jossa näkyvät itse kortit sekä kortin vaihto painikkeet
 * 3: yläpsa jossa näkyvät pelivaraukset, panos sekä viimeisin voitto

 */

    private void luoKomponentit(Container container) {
        this.pelaaKuuntelija = new PelaaKuuntelija(null, null, null, null, null, null);
        LuoKorttipakka();
        LuoPelaaja();
        LuoKadenTunnistaja();
        LuoListaValmiistaKasista();
        container.add(LuoKortit(), BorderLayout.CENTER);
        container.add(LuoAlariviPainikkeet(), BorderLayout.SOUTH);
        container.add(LuoYlariviSetit(), BorderLayout.NORTH);
       this.pelaaKuuntelija.setPvkuuntelija(pvKuuntelija);

    }

    /**
 *Metodi luo kortit sekä kyseisen kortin vaihtopainikkeen.

 */
    private JPanel LuoKortit() {

        JPanel panel = new JPanel(new GridLayout(2, 5));

        JLabel kuva1 = new JLabel();
        JLabel kuva2 = new JLabel();
        JLabel kuva3 = new JLabel();
        JLabel kuva4 = new JLabel();
        JLabel kuva5 = new JLabel();

        JButton yksi = new JButton("VAIHDA");
        JButton kaksi = new JButton("VAIHDA");
        JButton kolme = new JButton("VAIHDA");
        JButton nelja = new JButton("VAIHDA");
        JButton viisi = new JButton("VAIHDA");

        panel.add(kuva1);
        panel.add(kuva2);
        panel.add(kuva3);
        panel.add(kuva4);
        panel.add(kuva5);
        panel.add(yksi);
        panel.add(kaksi);
        panel.add(kolme);
        panel.add(nelja);
        panel.add(viisi);

        this.pelaaKuuntelija = new PelaaKuuntelija(this.pelaaja.getHanska(), kuva1, kuva2, kuva3, kuva4, kuva5);
        this.pelaaKuuntelija.setLukinnat(yksi, kaksi, kolme, nelja, viisi);

        yksi.addActionListener(pelaaKuuntelija);
        kaksi.addActionListener(pelaaKuuntelija);
        kolme.addActionListener(pelaaKuuntelija);
        nelja.addActionListener(pelaaKuuntelija);
        viisi.addActionListener(pelaaKuuntelija);

        return panel;

    }

    /**
 * Metodi luo ylariville tarvittavat JLabelit. Panos, viimeisinvoitto sekä pelivaraukset
 * Peli antaa 10e oletus pelivarauksena

 */
    private JPanel LuoYlariviSetit() {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JLabel panos = new JLabel("Panos: " + this.pelaaja.getPelivaraukset().getPanos() + "e");
        JLabel pelivaraukset = new JLabel("Pelivaraukset: " + this.pelaaja.getPelivaraukset().getRahat() + "" + "e");
        JLabel kolme = new JLabel("Viimeisin voitto: " + this.pelaaja.getPelivaraukset().getViimeisinvoitto() + "e");

        panel.add(panos);
        panel.add(kolme);
        panel.add(pelivaraukset);
        

        pelaaKuuntelija.setViimeisinvoitto(kolme);
        pvKuuntelija.setPanosKenttä(panos);
        pelaaKuuntelija.setPelivarauksettext(pelivaraukset);



        return panel;
    }

    private JPanel LuoAlariviPainikkeet() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton panos = new JButton("Kasvata panosta");
        JButton pelaa = new JButton("Pelaa");
        JButton vaihdaKortit = new JButton("Vaihda kortit");

        panel.add(panos);
        panel.add(vaihdaKortit);
        panel.add(pelaa);

        //pelivarauksia annetaan oletuksena 10e
        pelaaja.setRollit(10);
        this.pvKuuntelija = new PelivarauksetKuuntelija(panos, this.pelaaja.getPelivaraukset());
        panos.addActionListener(pvKuuntelija);
        pelaa.addActionListener(pelaaKuuntelija);
        vaihdaKortit.setEnabled(false);
        pelaaKuuntelija.setKortinvaihtoButton(vaihdaKortit);
        vaihdaKortit.addActionListener(pelaaKuuntelija);
        pelaaKuuntelija.setPanos(panos);
        pelaaKuuntelija.setPelaa(pelaa);
        pelaaKuuntelija.setPelivaraukset(pelaaja.getPelivaraukset());
        pelaaKuuntelija.setListaValmiistaKasista(listaValmiistaKasista);
        pelaaKuuntelija.setTunnistaja(tunnistaja);
        pelaaKuuntelija.setPakka(pakka);

        return panel;
    }

    public void LuoKorttipakka() {
        this.pakka = new Korttipakka();
        pakka.luoKorttipakka();
    }

    public void LuoPelaaja() {
        this.pelaaja = new Pelaaja();

    }

    public void LuoKadenTunnistaja() {
        this.tunnistaja = new KadenTunnistaja();

    }

    public void LuoListaValmiistaKasista() {
        this.listaValmiistaKasista = new ValmiitPokerikadet();
        listaValmiistaKasista.luoListaKasista();

    }

}
