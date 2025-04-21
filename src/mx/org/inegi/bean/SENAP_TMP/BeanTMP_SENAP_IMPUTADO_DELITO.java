/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.bean.SENAP_TMP;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANTONIO.CORIA
 */
public class BeanTMP_SENAP_IMPUTADO_DELITO extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String IMPUTADODELITOID;
    private String IMPUTADODELITOID_FISCALIA;
    private String DELITOSDELITOID;
    private String IMPUTADOIMPUTADOID;
    private String DELITOID_FISCALIA;
    private String IMPUTADOID_FISCALIA;
    private String BORRADO;
    private String FECHAALTA;
    private String USUARIOALTA;
    private String CATFISCALIAID;
    private String FECHACORTE;
    private String FECHAACTUALIZACION;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
    }

    public String GetIMPUTADODELITOID() {
        return IMPUTADODELITOID;
    }

    public void SetIMPUTADODELITOID(String IMPUTADODELITOID) {
        this.IMPUTADODELITOID = IMPUTADODELITOID;
    }

    public String GetIMPUTADODELITOID_FISCALIA() {
        return IMPUTADODELITOID_FISCALIA;
    }

    public void SetIMPUTADODELITOID_FISCALIA(String IMPUTADODELITOID_FISCALIA) {
        this.IMPUTADODELITOID_FISCALIA = IMPUTADODELITOID_FISCALIA;
    }

    public String GetDELITOSDELITOID() {
        return DELITOSDELITOID;
    }

    public void SetDELITOSDELITOID(String DELITOSDELITOID) {
        this.DELITOSDELITOID = DELITOSDELITOID;
    }

    public String GetIMPUTADOIMPUTADOID() {
        return IMPUTADOIMPUTADOID;
    }

    public void SetIMPUTADOIMPUTADOID(String IMPUTADOIMPUTADOID) {
        this.IMPUTADOIMPUTADOID = IMPUTADOIMPUTADOID;
    }

    public String GetDELITOID_FISCALIA() {
        return DELITOID_FISCALIA;
    }

    public void SetDELITOID_FISCALIA(String DELITOID_FISCALIA) {
        this.DELITOID_FISCALIA = DELITOID_FISCALIA;
    }

    public String GetIMPUTADOID_FISCALIA() {
        return IMPUTADOID_FISCALIA;
    }

    public void SetIMPUTADOID_FISCALIA(String IMPUTADOID_FISCALIA) {
        this.IMPUTADOID_FISCALIA = IMPUTADOID_FISCALIA;
    }

    public String GetBORRADO() {
        return BORRADO;
    }

    public void SetBORRADO(String BORRADO) {
        this.BORRADO = BORRADO;
    }

    public String GetFECHAALTA() {
        return FECHAALTA;
    }

    public void SetFECHAALTA(String FECHAALTA) {
        this.FECHAALTA = FECHAALTA;
    }

    public String GetUSUARIOALTA() {
        return USUARIOALTA;
    }

    public void SetUSUARIOALTA(String USUARIOALTA) {
        this.USUARIOALTA = USUARIOALTA;
    }

    public String GetCATFISCALIAID() {
        return CATFISCALIAID;
    }

    public void SetCATFISCALIAID(String CATFISCALIAID) {
        this.CATFISCALIAID = CATFISCALIAID;
    }

    public String GetFECHACORTE() {
        return FECHACORTE;
    }

    public void SetFECHACORTE(String FECHACORTE) {
        this.FECHACORTE = FECHACORTE;
    }

    public String GetFECHAACTUALIZACION() {
        return FECHAACTUALIZACION;
    }

    public void SetFECHAACTUALIZACION(String FECHAACTUALIZACION) {
        this.FECHAACTUALIZACION = FECHAACTUALIZACION;
    }

    public String GetPERIODO() {
        return PERIODO;
    }

    public void SetPERIODO(String PERIODO) {
        this.PERIODO = PERIODO;
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
            GetENTIDADID(),
            GetIMPUTADODELITOID(),
            GetIMPUTADODELITOID_FISCALIA(),
            GetDELITOSDELITOID(),
            GetIMPUTADOIMPUTADOID(),
            GetDELITOID_FISCALIA(),
            GetIMPUTADOID_FISCALIA(),
            GetBORRADO(),
            GetFECHAALTA(),
            GetUSUARIOALTA(),
            GetCATFISCALIAID(),
            GetFECHACORTE(),
            GetFECHAACTUALIZACION(),
            GetPERIODO()
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
