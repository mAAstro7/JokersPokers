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
    public Pokerikasi(Kortti kortti1,Kortti kortti2,Kortti kortti3,Kortti kortti4,Kortti kortti5) {
        pokerikasi = new ArrayList<Kortti>();
        pokerikasi.add(kortti1);
        pokerikasi.add(kortti2);
        pokerikasi.add(kortti3);
        pokerikasi.add(kortti4);
        pokerikasi.add(kortti5);
    }

    public void luoPokeriKasi(Korttipakka pakka) {

        for (int i = pokerikasi.size(); i < 5; i++) {
            pokerikasi.add(pakka.arvoKortti());
        }

    }
    
    public Kortti getKortti (int indeksi) {
        return pokerikasi.get(indeksi);
    }
    
    public int getKorttiArvo (int indeksi) {
        return pokerikasi.get(indeksi).getArvo();
    }


    public void poistaKortti(Kortti kortti) {
        pokerikasi.remove(kortti);
    }
    
        public void poistaKorttiIndex(int i) {
        pokerikasi.remove(i);
    }
    
    public void vaihdaKortti(Korttipakka pakka, Kortti kortti) {
   
            poistaKortti(kortti); 
            pokerikasi.add(pakka.arvoKortti());      
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
