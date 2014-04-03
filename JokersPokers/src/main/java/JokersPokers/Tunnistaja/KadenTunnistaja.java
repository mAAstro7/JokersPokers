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
      
    }
    
   
    public void setValmiitPokerikadet(ValmiitPokerikadet kasi) {
        this.valmiitkadet = kasi;
    }
    
 

    public ValmisPokerikasi palautaKasi(Pokerikasi kasi) {
        
        return null;     
    }
    
/**
 * Metodi tarkistaa onko annettu pokerikäsi hai
 * 
 * @return false/true  Palauttaa tiedon onko käsi hai
 */
    public boolean onkoHai (Pokerikasi kasi) {
       
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
     
            lista.add(kasi.getKortti(i).getArvo());
        } 
        if (lista.size() == 5) {
            return true;
        } else {
            return false;
        }
        
        
    }
   
    
}
