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
    private PelivarauksetKuuntelija pvKuuntelija;

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
        container.add(LuoAlariviPainikkeet(), BorderLayout.SOUTH);
        container.add(LuoYlariviSetit(), BorderLayout.NORTH);
        container.add(LuoKortit(),BorderLayout.CENTER);

    }

    private JPanel LuoKortit() {

        JPanel panel = new JPanel(new GridLayout(1, 5));
        JButton yksi = new JButton("Kasvata panosta");
        JButton kaksi = new JButton("Pelaa");
        JButton kolme = new JButton("Kasvata panosta");
        JButton nelja = new JButton("Pelaa");
        JButton viisi = new JButton("Kasvata panosta");


        panel.add(yksi);
        panel.add(kaksi);
        panel.add(kolme);
        panel.add(nelja);
        panel.add(viisi);




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
        JLabel tyhja = new JLabel("");

        panel.add(panos);
        panel.add(tyhja);
        panel.add(pelaa);


        this.pvKuuntelija = new PelivarauksetKuuntelija(panos, this.pelaaja.getPelivaraukset());
        panos.addActionListener(pvKuuntelija);

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
