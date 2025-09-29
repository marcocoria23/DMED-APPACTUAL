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

public class BeanTEMP_TEPJF_RESOLUCIONES extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_TEPJF_EXPEDIENTE;
private String ID_TEPJF_RESOLUCIONES;
private String FECHA_RESOL;
private String TP_SESION;
private String TP_RESOLUCION;
private String OTRO_TP_RESOLUCION;
private String TP_RESOLUCION_F;
private String SENTIDO_RESOLUCION_F;
private String OTRO_SENTIDO_RESOLUCION_F;
private String SENTIDO_RESOLUCION_NF;
private String OTRO_SENTIDO_RESOLUCION_NF;
private String DURACION_PROCESO;
private String COND_IMPUGN;
private String FECHA_ACUERDO_CUMPL;
private String OBSERVACIONES;

    public String GetID_TEPJF_EXPEDIENTE() {
        return ID_TEPJF_EXPEDIENTE;
    }

    public void SetID_TEPJF_EXPEDIENTE(String ID_TEPJF_EXPEDIENTE) {
        this.ID_TEPJF_EXPEDIENTE = ID_TEPJF_EXPEDIENTE;
    }

    public String GetID_TEPJF_RESOLUCIONES() {
        return ID_TEPJF_RESOLUCIONES;
    }

    public void SetID_TEPJF_RESOLUCIONES(String ID_TEPJF_RESOLUCIONES) {
        this.ID_TEPJF_RESOLUCIONES = ID_TEPJF_RESOLUCIONES;
    }


 
    public String GetFECHA_RESOL() {
        return FECHA_RESOL;
    }

    public void SetFECHA_RESOL(String FECHA_RESOL) {
        this.FECHA_RESOL = FECHA_RESOL;
    }

    public String GetTP_SESION() {
        return TP_SESION;
    }

    public void SetTP_SESION(String TP_SESION) {
        this.TP_SESION = TP_SESION;
    }

    public String GetTP_RESOLUCION() {
        return TP_RESOLUCION;
    }

    public void SetTP_RESOLUCION(String TP_RESOLUCION) {
        this.TP_RESOLUCION = TP_RESOLUCION;
    }

    public String GetOTRO_TP_RESOLUCION() {
        return OTRO_TP_RESOLUCION;
    }

    public void SetOTRO_TP_RESOLUCION(String OTRO_TP_RESOLUCION) {
        this.OTRO_TP_RESOLUCION = OTRO_TP_RESOLUCION;
    }

    public String GetTP_RESOLUCION_F() {
        return TP_RESOLUCION_F;
    }

    public void SetTP_RESOLUCION_F(String TP_RESOLUCION_F) {
        this.TP_RESOLUCION_F = TP_RESOLUCION_F;
    }

    public String GetSENTIDO_RESOLUCION_F() {
        return SENTIDO_RESOLUCION_F;
    }

    public void SetSENTIDO_RESOLUCION_F(String SENTIDO_RESOLUCION_F) {
        this.SENTIDO_RESOLUCION_F = SENTIDO_RESOLUCION_F;
    }

    public String GetOTRO_SENTIDO_RESOLUCION_F() {
        return OTRO_SENTIDO_RESOLUCION_F;
    }

    public void SetOTRO_SENTIDO_RESOLUCION_F(String OTRO_SENTIDO_RESOLUCION_F) {
        this.OTRO_SENTIDO_RESOLUCION_F = OTRO_SENTIDO_RESOLUCION_F;
    }

    public String GetSENTIDO_RESOLUCION_NF() {
        return SENTIDO_RESOLUCION_NF;
    }

    public void SetSENTIDO_RESOLUCION_NF(String SENTIDO_RESOLUCION_NF) {
        this.SENTIDO_RESOLUCION_NF = SENTIDO_RESOLUCION_NF;
    }

    public String GetOTRO_SENTIDO_RESOLUCION_NF() {
        return OTRO_SENTIDO_RESOLUCION_NF;
    }

    public void SetOTRO_SENTIDO_RESOLUCION_NF(String OTRO_SENTIDO_RESOLUCION_NF) {
        this.OTRO_SENTIDO_RESOLUCION_NF = OTRO_SENTIDO_RESOLUCION_NF;
    }

    public String GetDURACION_PROCESO() {
        return DURACION_PROCESO;
    }

    public void SetDURACION_PROCESO(String DURACION_PROCESO) {
        this.DURACION_PROCESO = DURACION_PROCESO;
    }

    public String GetCOND_IMPUGN() {
        return COND_IMPUGN;
    }

    public void SetCOND_IMPUGN(String COND_IMPUGN) {
        this.COND_IMPUGN = COND_IMPUGN;
    }

    public String GetFECHA_ACUERDO_CUMPL() {
        return FECHA_ACUERDO_CUMPL;
    }

    public void SetFECHA_ACUERDO_CUMPL(String FECHA_ACUERDO_CUMPL) {
        this.FECHA_ACUERDO_CUMPL = FECHA_ACUERDO_CUMPL;
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
            GetID_TEPJF_EXPEDIENTE(),
            GetID_TEPJF_RESOLUCIONES(),
            GetFECHA_RESOL(),
            GetTP_SESION(),
            GetTP_RESOLUCION(),
            GetOTRO_TP_RESOLUCION(),
            GetTP_RESOLUCION_F(),
            GetSENTIDO_RESOLUCION_F(),
            GetOTRO_SENTIDO_RESOLUCION_F(),
            GetSENTIDO_RESOLUCION_NF(),
            GetOTRO_SENTIDO_RESOLUCION_NF(),
            GetDURACION_PROCESO(),
            GetCOND_IMPUGN(),
            GetFECHA_ACUERDO_CUMPL(),
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
