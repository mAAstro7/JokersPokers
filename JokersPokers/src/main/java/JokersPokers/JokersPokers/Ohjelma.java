package main.java.JokersPokers.JokersPokers;

import main.java.JokersPokers.Kayttoliittyma.Kayttoliittyma;
import javax.swing.*;

public class Ohjelma {

    
    public static void main(String[] args) {
        Kayttoliittyma kayttis = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttis);

    }
}
