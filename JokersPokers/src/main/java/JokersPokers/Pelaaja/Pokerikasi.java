/**
 * Luokka pokerikädelle
 */
package JokersPokers.Pelaaja;

import JokersPokers.Kortti.Kortti;
import JokersPokers.Kortti.Korttipakka;
import java.util.*;

public class Pokerikasi {

    private ArrayList<Kortti> pokerikasi;
    private String arvo;

    public Pokerikasi() {
        pokerikasi = new ArrayList<Kortti>();
    }

    public Pokerikasi(Kortti kortti1, Kortti kortti2, Kortti kortti3, Kortti kortti4, Kortti kortti5) {
        pokerikasi = new ArrayList<Kortti>();
        pokerikasi.add(kortti1);
        pokerikasi.add(kortti2);
        pokerikasi.add(kortti3);
        pokerikasi.add(kortti4);
        pokerikasi.add(kortti5);
    }

    /**
     * Metodi luo pokerikäden
     *
     * @param pakka Valmiiksi luotu korttipakka
     *
     */
    public void luoPokeriKasi(Korttipakka pakka) {

        while (pokerikasi.size()<5) {
            Kortti kortti = pakka.arvoKortti();
            pokerikasi.add(kortti);
            pakka.poistaKortti(kortti);
        }

    }

    /**
     * Metodi hakee halutun kortin arvon
     *
     * @param indeksi Kortin indeksi
     * @return pokerikasi.get(indeksi).getArvo(); Palauttaa kortin arvon (2-14)
     *
     */
    public Kortti getKortti(int indeksi) {
        return pokerikasi.get(indeksi);
    }

    /**
     * Metodi poistaa tietyn kortin
     *
     * @param kortti Poistettava kortti (Kortti olio)
     *
     */
    public void poistaKortti(Kortti kortti) {
        pokerikasi.remove(kortti);
    }
       /**
     * Metodi poistaa tietyn kortin
     *
     * @param kortti Poistettava kortti.toString eli esim hertta7
     *
     */
    public void poistaKorttiString(String kortti) {
        for(int i = 0;i<getKorttienlkmKadessa();i++) {
            if (pokerikasi.get(i).toString().equals(kortti)) {
                pokerikasi.remove(i);
                //jokerilla testatessa mahdollisesti 2x hertta7 joten ei haluta molempien poistuvan
                break;
            }
        }
    }

    /**
     * Metodi poistaa tietyn kortin indeksin avulla
     *
     * @param indeksi Poistettavan kortin indeksi
     *
     */
    public void poistaKorttiIndex(int indeksi) {
        pokerikasi.remove(indeksi);
    }

    /**
     * Metodi vaihtaa kortin
     *
     * @param pakka Korttipakka josta kortti arvotaan
     * @param kortti poistettava kortti
     *
     * @return pakka Korttipakka josta on poistettu pelaajalle arvottu kortti
     *
     */
    public void vaihdaKortti(Korttipakka pakka, Kortti kortti) {

        poistaKortti(kortti);
        Kortti arvottu = pakka.arvoKortti();
        lisaaKortti(arvottu);

    }

    /**
     * Metodi vaihtaa kortin
     *
     * @param pakka Korttipakka josta kortti arvotaan
     * @param i poistettavan kortin indeksi
     *
     * @return pakka Korttipakka josta on poistettu pelaajalle arvottu kortti
     *
     */
    public void vaihdaKorttiIndeksilla(Korttipakka pakka, int i) {

        pokerikasi.remove(i);
        pokerikasi.add(i, pakka.arvoKortti());

    }

    /**
     * Metodi vaihtaa lisäää käteen kortin jos käsi ei ole täysi (= sisältää jo
     * 5 korttia)
     *
     * @param kortti Lisättävä kortti
     */
    public void lisaaKortti(Kortti kortti) {
        if (pokerikasi.size() < 5) {
            pokerikasi.add(kortti);
        }

    }

    public Kortti getViimeinenKortti() {
        return pokerikasi.get(4);
    }

    public String toString() {
        return pokerikasi.toString();
    }

    public int getKorttienlkmKadessa() {
        return pokerikasi.size();
    }
}
