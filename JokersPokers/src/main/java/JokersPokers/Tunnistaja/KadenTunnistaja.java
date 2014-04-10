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
    public boolean onkoVari (Pokerikasi kasi) {
        ArrayList<String> lista = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
             if (!lista.contains(kasi.getKortti(i).getMaa())) {
                 lista.add(kasi.getKortti(i).getMaa());
             }
        }
        System.out.println(lista.toString());
        if (lista.size()== 1) {
            
            return true;
        } else {
             return false;
        }
       
        
    }
}
