/**
 * Luokka kortteja varten. Jokainen kortti tietää arvonsa sekä maansa
 * 
 */
package JokersPokers.Kortti;


public class Kortti extends Korttipakka {

    private int arvo;
    private String maa;

    public Kortti(String maa, int arvo) {
        this.arvo = arvo;
        this.maa = maa;

    }
    
    @Override
    public String toString(){

        return this.getMaa() + this.getArvo();
        
    }

    public int getArvo() {
        return arvo;
    }

    public String getMaa() {
        return maa;
    }
}
