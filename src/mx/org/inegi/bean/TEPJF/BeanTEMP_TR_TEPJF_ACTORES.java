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

public class BeanTEMP_TR_TEPJF_ACTORES extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_TEMP_TEPJF_EXPEDIENTE;
    private String ID_TEMP_TEPJF_ACTORES;
    private String CLASE_ACTOR;
    private String OTRO_CLASE_ACTOR;
    private String SEXO;
    private String COND_REPRES_ACTOR;
    private String PART_POLITICO_NAC_ACTOR;
    private String PART_POLITICO_LOCAL_ACTOR;
    private String SALA_ACTOR;
    private String OBSERVACIONES;

    public String GetID_TEMP_TEPJF_EXPEDIENTE() {
        return ID_TEMP_TEPJF_EXPEDIENTE;
    }

    public void SetID_TEMPT_EPJF_EXPEDIENTE(String ID_TEPJF_EXPEDIENTE) {
        this.ID_TEMP_TEPJF_EXPEDIENTE = ID_TEPJF_EXPEDIENTE;
    }

    public String GetID_TEMP_TEPJF_ACTORES() {
        return ID_TEMP_TEPJF_ACTORES;
    }

    public void SetID_TEMP_TEPJF_ACTORES(String ID_TEPJF_ACTORES) {
        this.ID_TEMP_TEPJF_ACTORES = ID_TEPJF_ACTORES;
    }

    public String GetCLASE_ACTOR() {
        return CLASE_ACTOR;
    }

    public void SetCLASE_ACTOR(String CLASE_ACTOR) {
        this.CLASE_ACTOR = CLASE_ACTOR;
    }

    public String GetOTRO_CLASE_ACTOR() {
        return OTRO_CLASE_ACTOR;
    }

    public void SetOTRO_CLASE_ACTOR(String OTRO_CLASE_ACTOR) {
        this.OTRO_CLASE_ACTOR = OTRO_CLASE_ACTOR;
    }

    public String GetSEXO() {
        return SEXO;
    }

    public void SetSEXO(String SEXO) {
        this.SEXO = SEXO;
    }

    public String GetCOND_REPRES_ACTOR() {
        return COND_REPRES_ACTOR;
    }

    public void SetCOND_REPRES_ACTOR(String COND_REPRES_ACTOR) {
        this.COND_REPRES_ACTOR = COND_REPRES_ACTOR;
    }

    public String GetPART_POLITICO_NAC_ACTOR() {
        return PART_POLITICO_NAC_ACTOR;
    }

    public void SetPART_POLITICO_NAC_ACTOR(String PART_POLITICO_NAC_ACTOR) {
        this.PART_POLITICO_NAC_ACTOR = PART_POLITICO_NAC_ACTOR;
    }

    public String GetPART_POLITICO_LOCAL_ACTOR() {
        return PART_POLITICO_LOCAL_ACTOR;
    }

    public void SetPART_POLITICO_LOCAL_ACTOR(String PART_POLITICO_LOCAL_ACTOR) {
        this.PART_POLITICO_LOCAL_ACTOR = PART_POLITICO_LOCAL_ACTOR;
    }

    public String GetSALA_ACTOR() {
        return SALA_ACTOR;
    }

    public void SetSALA_ACTOR(String SALA_ACTOR) {
        this.SALA_ACTOR = SALA_ACTOR;
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
            GetID_TEMP_TEPJF_EXPEDIENTE(),
            GetID_TEMP_TEPJF_ACTORES(),
            GetCLASE_ACTOR(),
            GetOTRO_CLASE_ACTOR(),
            GetSEXO(),
            GetCOND_REPRES_ACTOR(),
            GetPART_POLITICO_NAC_ACTOR(),
            GetPART_POLITICO_LOCAL_ACTOR(),
            GetSALA_ACTOR(),
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
