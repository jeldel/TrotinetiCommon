package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class IznajmljivanjeTrotineta extends AbstractDomainObject {

    private Long iznajmljivanjeID;
    private Date datumVreme;
    private double brojSati;
    private Cenovnik cena = new Cenovnik();
    private double ukupnaCena;
    private Korisnik korisnik;
    private Trotinet trotinet;
    private Osoba osoba;


    public IznajmljivanjeTrotineta() {
    }

    public IznajmljivanjeTrotineta(Long iznajmljivanjeID, Date datumVreme, double brojSati, Korisnik korisnik, Trotinet trotinet, Osoba osoba) {
        this.iznajmljivanjeID = iznajmljivanjeID;
        this.datumVreme = datumVreme;
        this.brojSati = brojSati;
        this.korisnik = korisnik;
        this.trotinet = trotinet;
        this.osoba = osoba;
    }

    public Long getIznajmljivanjeID() {
        return iznajmljivanjeID;
    }

    public void setIznajmljivanjeID(Long iznajmljivanjeID) {
        this.iznajmljivanjeID = iznajmljivanjeID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public Double getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(Double brojSati) {
        this.brojSati = brojSati;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public double getUkupnaCena() {
        return izracunajUkupnuCenu(this.brojSati, this.cena.getPocetnaCena(this.trotinet), this.cena.getCenaPoSatu(), this.trotinet);
    }

    private double izracunajUkupnuCenu(Double brojSati, Double pocetnaCena, Double cenaPoSatu, Trotinet t) {
        this.ukupnaCena = cena.getPocetnaCena(t) + (brojSati * cena.getCenaPoSatu());
        return ukupnaCena;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    public Trotinet getTrotinet() {
        return trotinet;
    }

    public void setTrotinet(Trotinet trotinet) {
        this.trotinet = trotinet;
    }

    @Override
    public String toString() {
        return "IznajmljivanjeTrotineta{" +
                "iznajmljivanjeID=" + iznajmljivanjeID +
                ", datumVreme=" + datumVreme +
                ", brojSati=" + brojSati +
                ", cena=" + cena +
                ", ukupnaCena=" + ukupnaCena +
                ", korisnik=" + korisnik +
                ", trotinet=" + trotinet +
                ", osoba=" + osoba +
                '}';
    }

    @Override
    public String nazivTabele() {
        return " iznajmljivanjeTrotineta ";
    }

    @Override
    public String alijas() {
        return " it ";
    }

    @Override
    public String join() {
        return  "INNER JOIN trotinet t ON it.trotinetID = t.trotinetID " +
                "INNER JOIN korisnik k ON it.korisnikID = k.korisnikID " +
                "INNER JOIN osoba o ON it.osobaBrojLK = o.brojLicneKarte";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            IznajmljivanjeTrotineta it = new IznajmljivanjeTrotineta();
            it.setIznajmljivanjeID(rs.getLong("it.iznajmljivanjeID"));
            it.setDatumVreme(rs.getDate("it.datumVreme"));
            it.setBrojSati(rs.getDouble("it.brojSati"));
            it.setUkupnaCena(rs.getDouble("it.ukupnaCena"));

            Trotinet t = new Trotinet();
            t.setTrotinetID(rs.getLong("t.trotinetID"));
            t.setVrstaTrotineta(VrstaTrotinetaEnum.valueOf(rs.getString("t.vrstaTrotineta")));
            t.setModel(rs.getString("t.model"));
            it.setTrotinet(t);

            Korisnik k = new Korisnik();
            k.setkorisnikID(rs.getLong("k.korisnikID"));
            k.setIme(rs.getString("k.ime"));
            k.setPrezime(rs.getString("k.prezime"));
            k.setEmail(rs.getString("k.email"));
            k.setGrad(GradEnum.valueOf(rs.getString("k.grad")));
            k.setTelefon(rs.getString("k.telefon"));
            k.setUsername(rs.getString("k.username"));
            k.setSifra(rs.getString("k.sifra"));
            it.setKorisnik(k);

            Osoba o = new Osoba();
            o.setBrojLicneKarte(rs.getLong("o.brojLicneKarte"));
            o.setIme(rs.getString("o.ime"));
            o.setPrezime(rs.getString("o.prezime"));
            it.setOsoba(o);

            lista.add(it);
        }
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (datumVreme, brojSati, ukupnaCena, korisnikID, trotinetID, osobaBrojLK) ";
    }

    @Override
    public String uslov() {
        return " k.username = '" + korisnik.getUsername() + "'";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new java.sql.Date(datumVreme.getTime()) + "', " + brojSati + ", "
                + izracunajUkupnuCenu(brojSati, cena.getPocetnaCena(trotinet), cena.getCenaPoSatu(), trotinet )
                + " , " + korisnik.getkorisnikID()
                + " , " + trotinet.getTrotinetID() + ", " + osoba.getBrojLicneKarte();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslovZaSelect() {
        return " WHERE k.username = '" + korisnik.getUsername() + "'";
    }
}
