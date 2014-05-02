/**
 * Luokka hoitaa pelaajan pelivaraukset, eli rahat
import main.java.JokersPokers.Pelaaja.*;
 */
package main.java.JokersPokers.Pelaaja;

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
        this.panos = Math.round(panos * 100);
        this.panos = panos / 100;
        if (this.panos > 2) {
            this.panos = 0.2;
        } else if (this.panos > getRahat()) {
            this.panos = 0.2;
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
            this.rahat = Math.round(rahat * 100);
            this.rahat = rahat / 100;
        }

    }

    /**
     * metodi lisää pelivarauksiin rahaa (panos*kerroin) Maksimi määrä rahaa on
     * rajattu 500:n
     *
     * @param panos Panos millä on pelattu
     * @param kerroin Voittavan käden kerroin
     */
    public void lisaaVoitto(double kerroin) {
        viimeisinvoitto = panos * kerroin;
        rahat = viimeisinvoitto + rahat;
        this.viimeisinvoitto = Math.round(viimeisinvoitto * 100);
        this.viimeisinvoitto = viimeisinvoitto / 100;
        this.rahat = Math.round(rahat * 100);
        this.rahat = rahat / 100;

        //pelivaraukset rajattu 500e
        if (getRahat() > 500) {
            this.rahat = 500;
        }
    }
}
