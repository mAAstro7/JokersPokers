/**
 * Luokka käsien tunnistamista varten
 */
package JokersPokers.Tunnistaja;

import JokersPokers.Pelaaja.Pokerikasi;
import JokersPokers.Pokerikadet.ValmiitPokerikadet;
import JokersPokers.Pokerikadet.ValmisPokerikasi;
import java.util.*;

public class KadenTunnistaja {

    private ValmiitPokerikadet valmiitkadet;

    public KadenTunnistaja() {
        valmiitkadet = new ValmiitPokerikadet();
        valmiitkadet.luoListaKasista();

    }

    public void setValmiitPokerikadet(ValmiitPokerikadet kasi) {
        this.valmiitkadet = kasi;
    }

    public ValmisPokerikasi palautaKasi(Pokerikasi kasi) {

        return null;
    }

    /**
     * Metodi tarkistaa onko annettu pokerikäsi hai arraylistin avulla.
     *
     * @return false/true Palauttaa tiedon onko käsi hai
     */
    public boolean onkoHai(Pokerikasi kasi) {

        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            if (!lista.contains(kasi.getKortti(i).getArvo())) {
                lista.add(kasi.getKortti(i).getArvo());
            }

        }
        if (lista.size() == 5) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi tarkistaa onko annettu pokerikäsi neloset apumuuttujan avulla
     *
     * @return false/true Palauttaa tiedon onko käsi neloset
     */
    public boolean onkoNeloset(Pokerikasi kasi) {
        int apum = 0;
        for (int i = 0; i < 2; i++) {
            for (int k = i + 1; k < 5; k++) {
                if (kasi.getKortti(i).getArvo() == kasi.getKortti(k).getArvo()) {
                    apum++;
                }
            }
            if (apum == 3) {
                return true;
            } else {
                apum = 0;
            }
        }
        return false;

    }

    /**
     * Metodi tarkistaa onko annettu pokerikäsi Täyskäsi arraylistin avulla.
     *
     * @return false/true Palauttaa tiedon onko käsi täyskäsi
     */
    public boolean onkoTaysKasi(Pokerikasi kasi) {
        ArrayList<Integer> lista = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            lista.add(kasi.getKortti(i).getArvo());
        }
        Collections.sort(lista);
        if (lista.get(0) == lista.get(2)) {
            if (lista.get(3) == lista.get(4)) {
                return true;
            } else {
                return false;
            }

        } else if (lista.get(0) == lista.get(1)) {
            if (lista.get(2) == lista.get(4)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * Metodi tarkistaa onko annettu pokerikäsi kolmoset apumuuttjien avulla.
     * apum pitää laskee monta samaa korttia kädessä on, kolmostenArvo pitää
     * huolen että kolmosiksi ei lasketa kahtaparia koska Arraylistin contains
     * metodiin ei voida laittaa hakuehtoa.
     *
     * @return false/true Palauttaa tiedon onko käsi kolmoset
     */
    public boolean onkoKolmoset(Pokerikasi kasi) {
        int apum = 0;
        int kolmostenArvo = 0;
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            if (lista.contains(kasi.getKortti(i).getArvo())) {
                if (kolmostenArvo == 0 || kolmostenArvo == kasi.getKortti(i).getArvo()) {
                    apum++;
                    kolmostenArvo = kasi.getKortti(i).getArvo();
                }

            } else {
                lista.add(kasi.getKortti(i).getArvo());
            }
        }

        if (apum == 2) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Metodi tarkistaa onko annettu pokerikäsi kaksi paria arraylistin avulla.
     * Tälläisenään metodi palauttaa myös true kolmosilla, tästä ei tarvitse
     * huolehtia koska käden tarkistus ainaa alka parhaasta mahdollisesta joten
     * metodia ei tarvita jos käsi on kolmoset.
     *
     *
     * @return false/true Palauttaa tiedon onko käsi väri
     */
    public boolean onkoRattaat(Pokerikasi kasi) { //rattaat = kaksi paria

        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(kasi.getKortti(0).getArvo());
        for (int i = 1; i < kasi.getKorttienlkmKadessa(); i++) {
            if (!lista.contains(kasi.getKortti(i).getArvo())) {
                lista.add(kasi.getKortti(i).getArvo());
            }
        }
        if (lista.size() == 3) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Metodi tarkistaa onko annettu pokerikäsi väri arraylistin avulla.
     *
     * @return false/true Palauttaa tiedon onko käsi väri
     */
    public boolean onkoVari(Pokerikasi kasi) {
        ArrayList<String> lista = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            if (!lista.contains(kasi.getKortti(i).getMaa())) {
                lista.add(kasi.getKortti(i).getMaa());
            }

        }
        System.out.println(lista.toString());
        if (lista.size() == 1) {

            return true;
        } else {
            return false;
        }

    }

    /**
     * Metodi tarkistaa onko annettu pokerikäsi suora arraylistin avulla.
     *
     * @return false/true Palauttaa tiedon onko käsi suora
     */
    public boolean onkoSuora(Pokerikasi kasi) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            if (!lista.contains(kasi.getKortti(i).getArvo())) {
                lista.add(kasi.getKortti(i).getArvo());
            } else {
                return false;
            }
        }

        Collections.sort(lista);
        if (lista.get(4) - lista.get(0) == 4) {
            return true;
        } else if (lista.get(4) == 14 && lista.get(3) == 5) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Metodi tarkistaa onko annettu pokerikäsi värisuora metodien onkoSuora ja
     * onkoVari avulla.
     *
     * @return false/true Palauttaa tiedon onko käsi värisuora
     */
    public boolean onkoVarisuora(Pokerikasi kasi) {
        if (onkoSuora(kasi) && onkoVari(kasi)) {
            return true;
        }
        return false;
    }

    /**
     * Metodi tarkistaa onko annettu pokerikäsi roylflush eli kuningasvärisuora
     * metodin onko värisuora avulla tässä joudutaan myös testaamaan että
     * jokainen kortti on arvoltaan välillä 10-14
     *
     * @return false/true Palauttaa tiedon onko käsi royalflush
     */
    public boolean onkoKuningasVarisuora(Pokerikasi kasi) {
        if (onkoVarisuora(kasi)) {
            for (int i = 0; i < kasi.getKorttienlkmKadessa(); i++) {
                if (kasi.getKortti(i).getArvo() < 10) {
                    return false;
                }
            }
            return true;

        } else {
            return false;
        }

    }
}
