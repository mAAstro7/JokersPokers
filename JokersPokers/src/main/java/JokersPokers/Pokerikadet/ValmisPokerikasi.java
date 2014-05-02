/**
 * Luokka hoitaa valmiin pokerikäden, siihen sisältyy arvojärjesty joka on 
 * jokin luku jonka annan että käsiä voidaan vertailla (yleensä kerroin)
 * Kerroin määrää voitto kertoimen kyseiselle kädelle 
 * (ei voida käyddää vertailussa koska hai ja pari molemmat 0 kertoimisia)
 * Kasi on käsi itse kirjoitettuna
 */
package JokersPokers.Pokerikadet;


public class ValmisPokerikasi implements Comparable<ValmisPokerikasi> {
    private int arvojarjestys;
    private String kasi;
    private int kerroin;

/**
 *  Konstruktori luo Valmiin Pokerikaden
 * 
 * @param kerroin  on pokerikaden voitto kerroin, hai kadelle annetaan kertoimeksi erikseen -1 jotta vertailu häviävien käsien välillä on mahdollista
 * @param kasi Stringinä pokerikaden nimi, esim suora
 */
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

/**
 * Käsiä voidaan vertailla arvojärjestyksen avulla
 */
    @Override
    public int compareTo(ValmisPokerikasi o) {
        if (this.arvojarjestys>o.getArvojarjestys()) {
            return 1;
        } else {
            return -1;
        }
    }
    
  
    
}
