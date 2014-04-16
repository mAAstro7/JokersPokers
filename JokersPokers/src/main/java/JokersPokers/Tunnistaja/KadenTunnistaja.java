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
