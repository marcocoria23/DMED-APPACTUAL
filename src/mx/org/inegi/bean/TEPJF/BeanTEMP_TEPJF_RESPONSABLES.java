/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.bean.TEPJF;

/**
 *
 * @author ANTONIO.CORIA
 */
import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class BeanTEMP_TEPJF_RESPONSABLES extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_TEPJF_EXPEDIENTE;
    private String ID_TEPJF_RESPONSABLES;
    private String CLASE_RESPONSABLE;
    private String OTRO_CLASE_RESPONSABLE;
    private String PART_POLITICO_NAC_RESPONS;
    private String PART_POLITICO_LOCAL_RESPONS;
    private String SALA_RESPONSABLE;
    private String OBSERVACIONES;

    public String getID_TEPJF_EXPEDIENTE() {
        return ID_TEPJF_EXPEDIENTE;
    }

    public void setID_TEPJF_EXPEDIENTE(String ID_TEPJF_EXPEDIENTE) {
        this.ID_TEPJF_EXPEDIENTE = ID_TEPJF_EXPEDIENTE;
    }

    public String getID_TEPJF_RESPONSABLES() {
        return ID_TEPJF_RESPONSABLES;
    }

    public void setID_TEPJF_RESPONSABLES(String ID_TEPJF_RESPONSABLES) {
        this.ID_TEPJF_RESPONSABLES = ID_TEPJF_RESPONSABLES;
    }

    public String GetCLASE_RESPONSABLE() {
        return CLASE_RESPONSABLE;
    }

    public void SetCLASE_RESPONSABLE(String CLASE_RESPONSABLE) {
        this.CLASE_RESPONSABLE = CLASE_RESPONSABLE;
    }

    public String GetOTRO_CLASE_RESPONSABLE() {
        return OTRO_CLASE_RESPONSABLE;
    }

    public void SetOTRO_CLASE_RESPONSABLE(String OTRO_CLASE_RESPONSABLE) {
        this.OTRO_CLASE_RESPONSABLE = OTRO_CLASE_RESPONSABLE;
    }

    public String GetPART_POLITICO_NAC_RESPONS() {
        return PART_POLITICO_NAC_RESPONS;
    }

    public void SetPART_POLITICO_NAC_RESPONS(String PART_POLITICO_NAC_RESPONS) {
        this.PART_POLITICO_NAC_RESPONS = PART_POLITICO_NAC_RESPONS;
    }

    public String GetPART_POLITICO_LOCAL_RESPONS() {
        return PART_POLITICO_LOCAL_RESPONS;
    }

    public void SetPART_POLITICO_LOCAL_RESPONS(String PART_POLITICO_LOCAL_RESPONS) {
        this.PART_POLITICO_LOCAL_RESPONS = PART_POLITICO_LOCAL_RESPONS;
    }

    public String GetSALA_RESPONSABLE() {
        return SALA_RESPONSABLE;
    }

    public void SetSALA_RESPONSABLE(String SALA_RESPONSABLE) {
        this.SALA_RESPONSABLE = SALA_RESPONSABLE;
    }

    public String GetOBSERVACIONES() {
        return OBSERVACIONES;
    }

    public void SetOBSERVACIONES(String OBSERVACIONES) {
        this.OBSERVACIONES = OBSERVACIONES;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return SQLTypeName;
        //throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getLlave() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        Object[] array = {
            getID_TEPJF_EXPEDIENTE(),
            getID_TEPJF_RESPONSABLES(),
            GetCLASE_RESPONSABLE(),
            GetOTRO_CLASE_RESPONSABLE(),
            GetPART_POLITICO_NAC_RESPONS(),
            GetPART_POLITICO_LOCAL_RESPONS(),
            GetSALA_RESPONSABLE(),
            GetOBSERVACIONES()
        };
        return array;
    }

    @Override
    public void setAtributos(Object[] obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaDesc(Connection conn) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String ots(Object obj) {
        String val = null;
        if (obj != null) {
            val = obj.toString();
        }
        return val;
    }

    private Integer oti(Object obj) {
        Integer num = null;
        if (obj != null) {
            try {
                num = (Integer) obj;
            } catch (Exception ex) {
                System.out.println("Error en casteo de numero [" + obj + "]");
            }
        }
        return num;
    }

}
