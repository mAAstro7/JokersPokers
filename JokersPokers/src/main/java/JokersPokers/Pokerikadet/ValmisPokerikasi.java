/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JokersPokers.Pokerikadet;
import JokersPokers.Pelaaja.Pokerikasi;

/**
 *
 * @author Jomppa
 */
public class ValmisPokerikasi implements Comparable<ValmisPokerikasi> {
    private int arvojarjestys;
    private String kasi;
    private int kerroin;

    public ValmisPokerikasi(int kerroin,  String kasi) {
        this.arvojarjestys = kerroin;
        this.kasi = kasi;
        this.kerroin = kerroin;
    }

    public int getKerroin() {
        return kerroin;
    }

    public void setKerroin(int kerroin) {
        this.kerroin = kerroin;
    }

    public String getKasi() {
        return kasi;
    }

    public void setKasi(String kasi) {
        this.kasi = kasi;
    }

    public void setArvojarjestys(int arvojarjestys) {
        this.arvojarjestys = arvojarjestys;
    }

    public int getArvojarjestys() {
        return arvojarjestys;
    }

    @Override
    public String toString() {
        return "Käsi: "+this.kasi + " Kerroin: " + this.kerroin;
    }

    @Override
    public int compareTo(ValmisPokerikasi o) {
        if (this.arvojarjestys>o.getArvojarjestys()) {
            return 1;
        } else {
            return -1;
        }
    }
    
  
    
}
