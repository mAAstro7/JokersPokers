/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JokersPokers.Korttii;

/**
 *
 * @author Jomppa
 */
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
