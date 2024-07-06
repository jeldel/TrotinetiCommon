package domain;

import java.io.Serializable;

public class Osoba implements Serializable {

    private Long brojLicneKarte;
    private String ime;
    private String prezime;

    public Osoba(Long brojLicneKarte, String ime, String prezime) {
        this.brojLicneKarte = brojLicneKarte;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Osoba() {
    }

    public Long getBrojLicneKarte() {
        return brojLicneKarte;
    }

    public void setBrojLicneKarte(Long brojLicneKarte) {
        this.brojLicneKarte = brojLicneKarte;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", brojLicneKarte=" + brojLicneKarte +
                '}';
    }
}