/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JokersPokers.Pokerikadet;

import java.util.*;

/**
 *
 * @author Jomppa
 */
public class ValmiitPokerikadet {
    private List<ValmisPokerikasi> kadet;

    public ValmiitPokerikadet() {
        kadet = new ArrayList<ValmisPokerikasi>();
    }
    
    public ValmisPokerikasi getTiettykasi (int i) {
        return kadet.get(i);
    }
       public ValmisPokerikasi getTiettykasi (String mjono) {
        for (int i = 0; i<kadet.size();i++) {
            if (mjono.equals(kadet.get(i).getKasi())) {
                return kadet.get(i);
            }
        }
        return null;
    }

    public List<ValmisPokerikasi> getKadet() {
        return kadet;
    }
    
    public int getKasienlkm() {
        return kadet.size();
    }
    
    public void luoListaKasista() {
       //luodaan jokainen käsi yksitellen, :(
       ValmisPokerikasi kasi0 = new ValmisPokerikasi(0, "Hai");   
       kasi0.setArvojarjestys(-1);
       kadet.add(kasi0);
       ValmisPokerikasi kasi1 = new ValmisPokerikasi(0, "Pari");    
       kadet.add(kasi1);
       ValmisPokerikasi kasi2 = new ValmisPokerikasi(2, "Kaksi paria");    
       kadet.add(kasi2);
       ValmisPokerikasi kasi3 = new ValmisPokerikasi(2, "Kolmoset");   
       kadet.add(kasi3);
       ValmisPokerikasi kasi4 = new ValmisPokerikasi(3, "Suora");    
       kadet.add(kasi4);
       ValmisPokerikasi kasi5 = new ValmisPokerikasi(4, "Väri");    
       kadet.add(kasi5);
       ValmisPokerikasi kasi6 = new ValmisPokerikasi(8, "Täyskäsi");    
       kadet.add(kasi6);
       ValmisPokerikasi kasi7 = new ValmisPokerikasi(15, "Neloset");    
       kadet.add(kasi7);
       ValmisPokerikasi kasi8 = new ValmisPokerikasi(40, "Värisuora");    
       kadet.add(kasi8);
       ValmisPokerikasi kasi9 = new ValmisPokerikasi(100, "Viitoset");  
       kadet.add(kasi9);
       ValmisPokerikasi kasi10 = new ValmisPokerikasi(200, "Kuningasvärisuora");  
       kadet.add(kasi10);
       
        
    }
    
}