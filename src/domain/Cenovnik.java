package domain;

import java.io.Serializable;

public class Cenovnik implements Serializable {
    Long cenovnikID;
    double cenaPoSatu = 40;
    double pocetnaCena;

    public Cenovnik() {
    }

    public Cenovnik(Long cenovnikID, double cenaPoSatu, double pocetnaCena) {
        this.cenovnikID = cenovnikID;
        this.cenaPoSatu = cenaPoSatu;
        this.pocetnaCena = pocetnaCena;
    }

    private double vratiCenuPoTipu(Trotinet t) {
        VrstaTrotinetaEnum vrsta = t.getVrstaTrotineta();

        switch (vrsta) {
            case Sharp:
                pocetnaCena = 80;
                break;
            case Soflow:
                pocetnaCena = 100;
                break;
            case Segway:
                pocetnaCena = 75;
                break;
            default:
            case XIAOMI:
                pocetnaCena = 110;
                break;
            case MS_Energy:
                pocetnaCena = 60;
                break;
        }
        return pocetnaCena;
    }

    public double getPocetnaCena(Trotinet t) {
        return vratiCenuPoTipu(t);
    }

    public double getCenaPoSatu() {
        return cenaPoSatu;
    }

    public Long getCenovnikID() {
        return cenovnikID;
    }

    public void setCenovnikID(Long cenovnikID) {
        this.cenovnikID = cenovnikID;
    }
}
