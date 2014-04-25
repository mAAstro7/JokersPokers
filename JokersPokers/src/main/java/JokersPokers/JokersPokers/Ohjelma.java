package JokersPokers.JokersPokers;

import JokersPokers.Kayttoliittyma.Kayttoliittyma;
import javax.swing.*;

public class Ohjelma {

    
    public static void main(String[] args) {
        Kayttoliittyma kayttis = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttis);

    }
}
