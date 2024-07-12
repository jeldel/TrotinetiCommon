package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Korisnik extends AbstractDomainObject {

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

    public Korisnik(Long korisnikID, Long brojLicneKarte, String ime, String prezime, String email, GradEnum grad, String telefon, String username, String sifra, TipKorisnika tipKorisnika) {
        this.korisnikID = korisnikID;
        this.brojLicneKarte = brojLicneKarte;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.grad = grad;
        this.telefon = telefon;
        this.username = username;
        this.sifra = sifra;
        this.tipKorisnika = tipKorisnika;
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

    @Override
    public String nazivTabele() {
        return " korisnik ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Korisnik k = new Korisnik(rs.getLong("korisnikID"),
                    rs.getLong("brojLicneKarte"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getString("email"),
                    GradEnum.valueOf(rs.getString("grad")),
                    rs.getString("telefon"),
                    rs.getString("username"),
                    rs.getString("sifra"),
                    TipKorisnika.valueOf(rs.getString("tipKorisnika")));

            lista.add(k);
        }
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (brojLicneKarte, ime, prezime, email, grad, telefon, username, sifra, tipKorisnika) ";
    }

    @Override
    public String uslov() {
        return "username = '" + username + "'";
    }

    @Override
    public String vrednostiZaInsert() {
        return brojLicneKarte + ",'" + ime + "', '" + prezime + "', "
                + "'" + email + "', '" + grad + "', '" + telefon + "', "
                + "'" + username + "', '" + sifra + "', '" + tipKorisnika + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " brojLicneKarte = " + brojLicneKarte + ", ime = '" + ime
                + "', prezime = '" + prezime + "', email = '" + email + "', grad = '" + grad
                + "', telefon = '" + telefon + "', username = '" + username + "', sifra = '" + sifra
                + "', tipKorisnika = '" +
                "" + tipKorisnika + "'";
    }

    @Override
    public String uslovZaSelect() {
        return " WHERE username = '" + username + "'";
    }
}
