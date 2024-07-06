package domain;

import java.io.Serializable;

public class Korisnik implements Serializable {

    private Long korisnikID;
    private Long brojLicneKarte;
    private String ime;
    private String prezime;
    private String email;
    private GradEnum grad;
    private String telefon;
    private String username;
    private String sifra;
    private TipKorisnika tipKorisnika;

    public Korisnik() {
    }

    public Korisnik(Long korisnikID, String ime, String prezime, String email, GradEnum grad, String telefon, String username, String sifra) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.email = email;
        this.prezime = prezime;
        this.sifra = sifra;
        this.username = username;
        this.grad = grad;
        this.telefon = telefon;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public GradEnum getGrad() {
        return grad;
    }

    public void setGrad(GradEnum grad) {
        this.grad = grad;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Long getkorisnikID() {
        return korisnikID;
    }

    public void setkorisnikID(Long korisnikID) {
        this.korisnikID = korisnikID;
    }

    public TipKorisnika getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(TipKorisnika tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }

    public Long getBrojLicneKarte() {
        return brojLicneKarte;
    }

    public void setBrojLicneKarte(Long brojLicneKarte) {
        this.brojLicneKarte = brojLicneKarte;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "korisnikID=" + korisnikID +
                ", brojLicneKarte=" + brojLicneKarte +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", grad=" + grad +
                ", telefon='" + telefon + '\'' +
                ", username='" + username + '\'' +
                ", sifra='" + sifra + '\'' +
                ", tipKorisnika=" + tipKorisnika +
                '}';
    }
}
