/**
 * Luokka korttipakkaa varten. Pakka tietää jokaisen kortin
 * 
 */
package JokersPokers.Kortti;

import java.util.*;


public class Korttipakka {

    private ArrayList<String> maat;
    private ArrayList<Kortti> korttipakka;

    public Korttipakka() {
        korttipakka = new ArrayList<Kortti>();
        maat = new ArrayList<String>();

    }
/**
 * Palauttaa korttien lukumäärän eli 53 (13+13+13+13+1)
 */
    public int getKorttienlkmPakassa() {       
        return korttipakka.size();
    }
/**
 * Poistaa pakasta tietyn kortin
 
  * @param poistettava Käyttäjän valitsema poistettava kortti
 
 */

    
    public Kortti gerKortti(int i) {
        return korttipakka.get(i);
    }

/**
 * Arpoo pakasta kortin, tätä käytetään 
 * esimerkiksi mahdollisen tuplauksen kanssa sekä arpoessa pelaajalle kortteja
 */
    public Kortti arvoKortti() {
        Random random = new Random();
        int arpa = random.nextInt(korttipakka.size());
        Kortti arvottuKortti = korttipakka.get(arpa);
        korttipakka.remove(arpa);
        return arvottuKortti;
    }

    @Override
    public String toString() {
        return korttipakka.toString();
    }

/**
 *  Luodaan korttipakka for-looppien avulla
 */
    public void luoKorttipakka() {
        korttipakka.clear();
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

        Kortti kortti = new Kortti("jokeri", 0);
        korttipakka.add(kortti);

    }
    
 /**
 *  Luodaan korttipakka for-looppien avulla mutta ei lisätä jokeria.
 */
        public void luoKorttipakkaIlmanJokeria() {
        korttipakka.clear();
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

    }
         /**
 *  Lisätään korttipakkaan jokeri, käytetään mahdollisesti extrajokerin lisäämiseen
 */
        public void lisaaJokeri () {
            korttipakka.add(new Kortti("jokeri", 0));
        }
                
}
