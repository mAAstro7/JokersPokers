package Pelaaja;

import java.util.*;
import jokerpokers.git.jokerspokers.Kortti.*;

public class Pokerikasi extends Korttipakka {

    private ArrayList<Kortti> pokerikasi;

    public Pokerikasi() {
        pokerikasi = new ArrayList<Kortti>();
    }

    public void luoPokeriKasi(Korttipakka pakka) {
        if (pokerikasi.size()>1) {
           pokerikasi = new ArrayList<Kortti>(); 
        }
        
        for (int i = 0; i < 5; i++) {
            pokerikasi.add(pakka.arvoKortti());
        }

    }
    
    public String getKortti (int indeksi) {
        return pokerikasi.get(indeksi).toString();
    }

    public void poistaKortti(int indeksi) {
        pokerikasi.remove(indeksi);
    }
    


    public int getKorttienlkm() {
        return pokerikasi.size();
    }
}
