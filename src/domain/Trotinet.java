package domain;

import java.io.Serializable;

public class Trotinet implements Serializable {

    private Long trotinetID;
    private VrstaTrotinetaEnum vrstaTrotineta;
    private String model;

    public Trotinet(Long trotinetID, VrstaTrotinetaEnum vrstaTrotineta, String model) {
        this.trotinetID = trotinetID;
        this.vrstaTrotineta = vrstaTrotineta;
        this.model = model;
    }

    public Long getTrotinetID() {
        return trotinetID;
    }

    public void setTrotinetID(Long trotinetID) {
        this.trotinetID = trotinetID;
    }

    public Trotinet() {
    }

    public VrstaTrotinetaEnum getVrstaTrotineta() {
        return vrstaTrotineta;
    }

    public void setVrstaTrotineta(VrstaTrotinetaEnum vrstaTrotineta) {
        this.vrstaTrotineta = vrstaTrotineta;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return "Trotinet{" +
                "trotinetID=" + trotinetID +
                ", vrstaTrotineta=" + vrstaTrotineta +
                ", model='" + model +
                '}';
    }
}
