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
public class BeanTMP_SENAP_VICTIMAS_DELITO extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String VICTIMASDELITOID;
    private String VICTIMASDELITOID_FISCALIA;
    private String DELITOID;
    private String VICTIMAID;
    private String CATFISCALIAID;
    private String BORRADO;
    private String FECHAALTA;
    private String USUARIOALTA;
    private String DELITOID_FISCALIA;
    private String VICTIMAID_FISCALIA;
    private String CARPETAID;
    private String FECHACORTE;
    private String FECHAACTUALIZACION;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
    }

    public String GetVICTIMASDELITOID() {
        return VICTIMASDELITOID;
    }

    public void SetVICTIMASDELITOID(String VICTIMASDELITOID) {
        this.VICTIMASDELITOID = VICTIMASDELITOID;
    }

    public String GetVICTIMASDELITOID_FISCALIA() {
        return VICTIMASDELITOID_FISCALIA;
    }

    public void SetVICTIMASDELITOID_FISCALIA(String VICTIMASDELITOID_FISCALIA) {
        this.VICTIMASDELITOID_FISCALIA = VICTIMASDELITOID_FISCALIA;
    }

    public String GetDELITOID() {
        return DELITOID;
    }

    public void SetDELITOID(String DELITOID) {
        this.DELITOID = DELITOID;
    }

    public String GetVICTIMAID() {
        return VICTIMAID;
    }

    public void SetVICTIMAID(String VICTIMAID) {
        this.VICTIMAID = VICTIMAID;
    }

    public String GetCATFISCALIAID() {
        return CATFISCALIAID;
    }

    public void SetCATFISCALIAID(String CATFISCALIAID) {
        this.CATFISCALIAID = CATFISCALIAID;
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

    public String GetDELITOID_FISCALIA() {
        return DELITOID_FISCALIA;
    }

    public void SetDELITOID_FISCALIA(String DELITOID_FISCALIA) {
        this.DELITOID_FISCALIA = DELITOID_FISCALIA;
    }

    public String GetVICTIMAID_FISCALIA() {
        return VICTIMAID_FISCALIA;
    }

    public void SetVICTIMAID_FISCALIA(String VICTIMAID_FISCALIA) {
        this.VICTIMAID_FISCALIA = VICTIMAID_FISCALIA;
    }

    public String GetCARPETAID() {
        return CARPETAID;
    }

    public void SetCARPETAID(String CARPETAID) {
        this.CARPETAID = CARPETAID;
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
            GetVICTIMASDELITOID(),
            GetVICTIMASDELITOID_FISCALIA(),
            GetDELITOID(),
            GetVICTIMAID(),
            GetCATFISCALIAID(),
            GetBORRADO(),
            GetFECHAALTA(),
            GetUSUARIOALTA(),
            GetDELITOID_FISCALIA(),
            GetVICTIMAID_FISCALIA(),
            GetCARPETAID(),
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
