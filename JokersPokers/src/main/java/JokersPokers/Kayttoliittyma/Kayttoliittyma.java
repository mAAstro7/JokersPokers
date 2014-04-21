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

    private void luoKomponentit(Container container) {
        LuoKorttipakka();
        LuoPelaaja();
        LuoKadenTunnistaja();
        LuoListaValmiistaKasista();
        container.add(LuoKortit(), BorderLayout.CENTER);
        container.add(LuoAlariviPainikkeet(), BorderLayout.SOUTH);
        container.add(LuoYlariviSetit(), BorderLayout.NORTH);


    }

    private JPanel LuoKortit() {

        JPanel panel = new JPanel(new GridLayout(1, 5));
        JButton yksi = new JButton("KORTTI");
        JButton kaksi = new JButton("KORTTI");
        JButton kolme = new JButton("KORTTI");
        JButton nelja = new JButton("KORTTI");
        JButton viisi = new JButton("KORTTI");


        panel.add(yksi);
        panel.add(kaksi);
        panel.add(kolme);
        panel.add(nelja);
        panel.add(viisi);

        this.pelaaKuuntelija = new PelaaKuuntelija(this.pelaaja.getHanska(), yksi, kaksi, kolme, nelja, viisi);
        return panel;

    }

    private JPanel LuoYlariviSetit() {
        JPanel panel = new JPanel(new GridLayout(1, 3));

        JLabel panos = new JLabel("Panos: " + this.pelaaja.getPelivaraukset().getPanos() + "e");
        JLabel pelivaraukset = new JLabel("Pelivaraukset: " + this.pelaaja.getPelivaraukset().getRahat() + "" + "e");
        JLabel kolme = new JLabel("Viimeisin voitto: " + this.pelaaja.getPelivaraukset().getViimeisinvoitto() + "e");

        panel.add(panos);
        panel.add(kolme);
        panel.add(pelivaraukset);

        pvKuuntelija.setPanosKenttä(panos);




        return panel;
    }

    private JPanel LuoAlariviPainikkeet() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton panos = new JButton("Kasvata panosta");
        JButton pelaa = new JButton("Pelaa");
        JButton vaihdaKortit = new JButton("Vaihda valitut kortit");

        panel.add(panos);
        panel.add(vaihdaKortit);
        panel.add(pelaa);


        this.pvKuuntelija = new PelivarauksetKuuntelija(panos, this.pelaaja.getPelivaraukset());
        panos.addActionListener(pvKuuntelija);
        pelaa.addActionListener(pelaaKuuntelija);
        pelaaKuuntelija.setKortinvaihtoButton(vaihdaKortit);
        vaihdaKortit.addActionListener(pelaaKuuntelija);

        return panel;
    }

    public void LuoKorttipakka() {
        this.pakka = new Korttipakka();
        pakka.luoKorttipakka();
    }

    public void LuoPelaaja() {
        this.pelaaja = new Pelaaja();
        pelaaja.luoPelikasi(pakka);
        pelaaja.getPelivaraukset().lisaaPelivarauksia(10.00);

    }

    public void LuoKadenTunnistaja() {
        this.tunnistaja = new KadenTunnistaja();

    }

    public void LuoListaValmiistaKasista() {
        this.listaValmiistaKasista = new ValmiitPokerikadet();
        listaValmiistaKasista.luoListaKasista();

    }
}
