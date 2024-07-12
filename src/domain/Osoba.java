package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Osoba extends AbstractDomainObject {

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

    @Override
    public String nazivTabele() {
        return " osoba ";
    }

    @Override
    public String alijas() {
        return " o ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Osoba o = new Osoba(rs.getLong("brojLicneKarte"),
                    rs.getString("ime"),
                    rs.getString("prezime"));

            lista.add(o);
        }
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (brojLicneKarte, ime, prezime) ";
    }

    @Override
    public String uslov() {
        return "brojLicneKarte = " + brojLicneKarte;
    }

    @Override
    public String vrednostiZaInsert() {
        return brojLicneKarte + ",'" + ime + "', '" + prezime + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslovZaSelect() {
        return "WHERE brojLicneKarte = " + brojLicneKarte;
    }
}