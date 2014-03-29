/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JokersPokers.Kortti;

import java.util.*;

/**
 *
 * @author Jomppa
 */
public class Korttipakka {

    private ArrayList<String> maat;
    private ArrayList<Kortti> korttipakka;

    public Korttipakka() {
        korttipakka = new ArrayList<Kortti>();
        maat = new ArrayList<String>();

    }
    
    public int getKorttienlkmPakassa() {       
        return korttipakka.size();
    }

    public void poistaKortti(Kortti poistettava) {
        korttipakka.remove(poistettava);
    }

    public Kortti arvoKortti() {
        Random random = new Random();
        int arpa = random.nextInt(korttipakka.size());
        Kortti arvottuKortti = korttipakka.get(arpa);
        poistaKortti(arvottuKortti);
        return arvottuKortti;
    }

    @Override
    public String toString() {
        return korttipakka.toString();
    }

    public void luoKorttipakka() {
        maat.add("pata");
        maat.add("hertta");
        maat.add("ruutu");
        maat.add("risti");
        for (int i = 0; i < 4; i++) {
            for (int k = 2; k <= 14; k++) {
                Kortti kortti = new Kortti(maat.get(i), k);
                korttipakka.add(kortti);
            }
        }
        Kortti kortti = new Kortti("Jokeri", 0);
        korttipakka.add(kortti);
    }
}
