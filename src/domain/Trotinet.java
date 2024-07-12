package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Trotinet extends AbstractDomainObject{

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

    @Override
    public String nazivTabele() {
        return " trotinet ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Trotinet t = new Trotinet(rs.getLong("trotinetID"),
                    VrstaTrotinetaEnum.valueOf(rs.getString("vrstaTrotineta")),
                    rs.getString("model"));

            lista.add(t);
        }
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (vrstaTrotineta, model) ";
    }

    @Override
    public String uslov() {
        return "trotinetID = " + trotinetID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + vrstaTrotineta + "', '" + model + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
       return  " vrstaTrotineta = '" + vrstaTrotineta + "', model = '" + model + "'";
    }

    @Override
    public String uslovZaSelect() {
        return "WHERE trotinetID = " + trotinetID;
    }
}
