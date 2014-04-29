/**
 * 404
 */
package main.java.JokersPokers.Pelaaja;

import main.java.JokersPokers.Kortti.Korttipakka;


public class Pelaaja {
    
    private Pokerikasi hanska;
    private Pelivaraukset rollit;
    
    public Pelaaja () {
        hanska = new Pokerikasi();
        rollit = new Pelivaraukset();
    }
    /**
 * Metodi luo uuden pelikäden pelaajalle
 * 
 * @param pakka  Korttipakka josta käsi luodaan
 */
    public void luoPelikasi (Korttipakka pakka) {
        hanska.luoPokeriKasi(pakka);
    }


    public Pokerikasi getHanska() {
        return hanska;
    }


    public void setHanska(Pokerikasi hanska) {
        this.hanska = hanska;
    }

 
    public Pelivaraukset getPelivaraukset() {
        return rollit;
    }
    

    public void setRollit(double raha) {
        if (raha>0) {
        Pelivaraukset rollz = new Pelivaraukset();
        rollz.lisaaPelivarauksia(raha);
        this.rollit = rollz; 
        }
        
    }
    
}
