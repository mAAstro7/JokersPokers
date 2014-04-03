/**
 * Luokka hoitaa pelaajan pelivaraukset, eli rahat
 */
package JokersPokers.Pelaaja;

public class Pelivaraukset {

    private double rahat;

    public Pelivaraukset() {
        rahat = 0;
    }

/**
     * metodi lisää pelivarauksia
     * pelivaruaksia voi lisätä 20e asti
     * @param summa Käyttäjän antama summa
     */
    public void lisaaPelivarauksia(double summa) {
        if (summa + getRahat() <= 20) {
            rahat += summa;
        }

    }

    public double getRahat() {
        return this.rahat;
    }

/**
     * metodi poistaa panoksen verran pelivarauksista jos pelivarauksissa on tarpeeksi rahaa
     * @param panos Käyttäjän valitsema panos
     */
    public void poistaPanos(double panos) {
        if (getRahat() >= panos) {
            this.rahat = this.rahat - panos;
        }

    }

/**
     * metodi lisää pelivarauksiin rahaa (panos*kerroin)
     * Maksimi määrä rahaa on rajattu 500:n
     * @param panos  Panos millä on pelattu
     * @param kerroin  Voittavan käden kerroin
     */
    public void lisaaVoitto(double panos, int kerroin) {
        rahat = rahat + (panos * kerroin);
        //pelivaraukset rajattu 500e
        if (getRahat() > 500) {
            this.rahat = 500;
        }
    }
}
