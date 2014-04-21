/**
 * Luokka hoitaa pelaajan pelivaraukset, eli rahat
 */
package JokersPokers.Pelaaja;

public class Pelivaraukset {

    private double rahat;
    private double panos;
    private double viimeisinvoitto = 0;

    public Pelivaraukset() {
        rahat = 0;
        panos = 0.2;
    }

    /**
     * metodi lisää pelivarauksia pelivaruaksia voi lisätä 20e asti
     *
     * @param summa Käyttäjän antama summa
     */
    public void lisaaPelivarauksia(double summa) {
        if (summa + getRahat() <= 20) {
            rahat += summa;
        }

    }

    public void setPanos(double betsi) {
        this.panos = betsi;
    }

    /**
     * metodi kasvattaa panosta panosta voi lisätä 2e asti, jonka jälkeen
     * aloitetaan 20snt uudestaan
     *
     */
    public void kasvataPanosta() {
        this.panos = 0.2 + this.panos;
        if (this.panos > 2) {
            this.panos = 0.2;
        } else if (this.panos > getRahat()) {
            this.panos = 0.2;
        }
        
        //alla olevat iffit karsivat pois doublen tyhmän virheen jossa panos voi esim olla 1,6000000001
        if (this.panos > 0.5 && this.panos < 0.7) {
            this.panos = 0.6;
        } else if (this.panos > 1.5 && this.panos < 1.7) {
            this.panos = 1.6;
        }

    }

    public double getViimeisinvoitto() {
        return this.viimeisinvoitto;
    }

    public double getPanos() {
        return this.panos;
    }

    public double getRahat() {
        return this.rahat;
    }

    /**
     * metodi poistaa panoksen verran pelivarauksista jos pelivarauksissa on
     * tarpeeksi rahaa
     *
     * @param panos Käyttäjän valitsema panos
     */
    public void poistaPanos() {
        if (getRahat() >= this.panos) {
            this.rahat = this.rahat - panos;
        }

    }

    /**
     * metodi lisää pelivarauksiin rahaa (panos*kerroin) Maksimi määrä rahaa on
     * rajattu 500:n
     *
     * @param panos Panos millä on pelattu
     * @param kerroin Voittavan käden kerroin
     */
    public void lisaaVoitto(int kerroin) {
        viimeisinvoitto = panos * kerroin;
        rahat = viimeisinvoitto + rahat;

        //pelivaraukset rajattu 500e
        if (getRahat() > 500) {
            this.rahat = 500;
        }
    }
}
