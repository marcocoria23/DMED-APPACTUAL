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
public class BeanTMP_SENAP_DETERMINACION extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String DETERMINACIONID;
    private String DETERMINACIONID_FISCALIA;
    private String CATFISCALIAID;
    private String CARPETAID;
    private String CARPETAID_FISCALIA;
    private String CATESTATUSCARPETAID;
    private String CATSENDETID;
    private String CATACURECID;
    private String HUBOREACTCARPETAINVEST;
    private String FECHADETERMINACION;
    private String BORRADO;
    private String FECHAALTA;
    private String USUARIOALTA;
    private String FECHACORTE;
    private String FECHAACTUALIZACION;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
    }

    public String GetDETERMINACIONID() {
        return DETERMINACIONID;
    }

    public void SetDETERMINACIONID(String DETERMINACIONID) {
        this.DETERMINACIONID = DETERMINACIONID;
    }

    public String GetDETERMINACIONID_FISCALIA() {
        return DETERMINACIONID_FISCALIA;
    }

    public void SetDETERMINACIONID_FISCALIA(String DETERMINACIONID_FISCALIA) {
        this.DETERMINACIONID_FISCALIA = DETERMINACIONID_FISCALIA;
    }

    public String GetCATFISCALIAID() {
        return CATFISCALIAID;
    }

    public void SetCATFISCALIAID(String CATFISCALIAID) {
        this.CATFISCALIAID = CATFISCALIAID;
    }

    public String GetCARPETAID() {
        return CARPETAID;
    }

    public void SetCARPETAID(String CARPETAID) {
        this.CARPETAID = CARPETAID;
    }

    public String GetCARPETAID_FISCALIA() {
        return CARPETAID_FISCALIA;
    }

    public void SetCARPETAID_FISCALIA(String CARPETAID_FISCALIA) {
        this.CARPETAID_FISCALIA = CARPETAID_FISCALIA;
    }

    public String GetCATESTATUSCARPETAID() {
        return CATESTATUSCARPETAID;
    }

    public void SetCATESTATUSCARPETAID(String CATESTATUSCARPETAID) {
        this.CATESTATUSCARPETAID = CATESTATUSCARPETAID;
    }

    public String GetCATSENDETID() {
        return CATSENDETID;
    }

    public void SetCATSENDETID(String CATSENDETID) {
        this.CATSENDETID = CATSENDETID;
    }

    public String GetCATACURECID() {
        return CATACURECID;
    }

    public void SetCATACURECID(String CATACURECID) {
        this.CATACURECID = CATACURECID;
    }

    public String GetHUBOREACTCARPETAINVEST() {
        return HUBOREACTCARPETAINVEST;
    }

    public void SetHUBOREACTCARPETAINVEST(String HUBOREACTCARPETAINVEST) {
        this.HUBOREACTCARPETAINVEST = HUBOREACTCARPETAINVEST;
    }

    public String GetFECHADETERMINACION() {
        return FECHADETERMINACION;
    }

    public void SetFECHADETERMINACION(String FECHADETERMINACION) {
        this.FECHADETERMINACION = FECHADETERMINACION;
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
            GetDETERMINACIONID(),
            GetDETERMINACIONID_FISCALIA(),
            GetCATFISCALIAID(),
            GetCARPETAID(),
            GetCARPETAID_FISCALIA(),
            GetCATESTATUSCARPETAID(),
            GetCATSENDETID(),
            GetCATACURECID(),
            GetHUBOREACTCARPETAINVEST(),
            GetFECHADETERMINACION(),
            GetBORRADO(),
            GetFECHAALTA(),
            GetUSUARIOALTA(),
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
