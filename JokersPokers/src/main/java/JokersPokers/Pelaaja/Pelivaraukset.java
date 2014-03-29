/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JokersPokers.Pelaaja;

public class Pelivaraukset {

    private double rahat;
    
    public Pelivaraukset () {
    rahat = 0;
}
    public void lisaaPelivarauksia (double summa) {
        //pelivaruaksia voi lisätä 20e asti
        if (summa + getRahat()<=20) {
            rahat += summa;
        }
        
    }
    
    public double getRahat () {
        return this.rahat;
    }
    
    public void poistaPanos (double panos) {
        if (getRahat()>= panos) {
            this.rahat = this.rahat - panos;
        }
        
    }
    
    public void lisaaVoitto(double panos, int kerroin) {
        rahat = rahat + (panos*kerroin);
        //pelivaraukset rajattu 500e
        if (getRahat()>500) {
            this.rahat = 500;
        }
    }
    
}


