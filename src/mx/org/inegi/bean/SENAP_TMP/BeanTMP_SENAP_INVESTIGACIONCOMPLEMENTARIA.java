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
public class BeanTMP_SENAP_INVESTIGACIONCOMPLEMENTARIA extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String INVESTIGACIONCOMPLEMENTARIAID;
    private String INVESTIGACIONCOMPLEMENTARIAID_FISCALIA;
    private String PROCESOID;
    private String PROCESOID_FISCALIA;
    private String FORMULACIONIMPUTACION;
    private String FECHFORMIMP;
    private String CATVINCPROSID;
    private String FECHVINCPROS;
    private String MEDIDACAUTELAR;
    private String FECHCIERREINV;
    private String ACUSACION;
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

    public String GetINVESTIGACIONCOMPLEMENTARIAID() {
        return INVESTIGACIONCOMPLEMENTARIAID;
    }

    public void SetINVESTIGACIONCOMPLEMENTARIAID(String INVESTIGACIONCOMPLEMENTARIAID) {
        this.INVESTIGACIONCOMPLEMENTARIAID = INVESTIGACIONCOMPLEMENTARIAID;
    }

    public String GetINVESTIGACIONCOMPLEMENTARIAID_FISCALIA() {
        return INVESTIGACIONCOMPLEMENTARIAID_FISCALIA;
    }

    public void SetINVESTIGACIONCOMPLEMENTARIAID_FISCALIA(String INVESTIGACIONCOMPLEMENTARIAID_FISCALIA) {
        this.INVESTIGACIONCOMPLEMENTARIAID_FISCALIA = INVESTIGACIONCOMPLEMENTARIAID_FISCALIA;
    }

    public String GetPROCESOID() {
        return PROCESOID;
    }

    public void SetPROCESOID(String PROCESOID) {
        this.PROCESOID = PROCESOID;
    }

    public String GetPROCESOID_FISCALIA() {
        return PROCESOID_FISCALIA;
    }

    public void SetPROCESOID_FISCALIA(String PROCESOID_FISCALIA) {
        this.PROCESOID_FISCALIA = PROCESOID_FISCALIA;
    }

    public String GetFORMULACIONIMPUTACION() {
        return FORMULACIONIMPUTACION;
    }

    public void SetFORMULACIONIMPUTACION(String FORMULACIONIMPUTACION) {
        this.FORMULACIONIMPUTACION = FORMULACIONIMPUTACION;
    }

    public String GetFECHFORMIMP() {
        return FECHFORMIMP;
    }

    public void SetFECHFORMIMP(String FECHFORMIMP) {
        this.FECHFORMIMP = FECHFORMIMP;
    }

    public String GetCATVINCPROSID() {
        return CATVINCPROSID;
    }

    public void SetCATVINCPROSID(String CATVINCPROSID) {
        this.CATVINCPROSID = CATVINCPROSID;
    }

    public String GetFECHVINCPROS() {
        return FECHVINCPROS;
    }

    public void SetFECHVINCPROS(String FECHVINCPROS) {
        this.FECHVINCPROS = FECHVINCPROS;
    }

    public String GetMEDIDACAUTELAR() {
        return MEDIDACAUTELAR;
    }

    public void SetMEDIDACAUTELAR(String MEDIDACAUTELAR) {
        this.MEDIDACAUTELAR = MEDIDACAUTELAR;
    }

    public String GetFECHCIERREINV() {
        return FECHCIERREINV;
    }

    public void SetFECHCIERREINV(String FECHCIERREINV) {
        this.FECHCIERREINV = FECHCIERREINV;
    }

    public String GetACUSACION() {
        return ACUSACION;
    }

    public void SetACUSACION(String ACUSACION) {
        this.ACUSACION = ACUSACION;
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
            GetINVESTIGACIONCOMPLEMENTARIAID(),
            GetINVESTIGACIONCOMPLEMENTARIAID_FISCALIA(),
            GetPROCESOID(),
            GetPROCESOID_FISCALIA(),
            GetFORMULACIONIMPUTACION(),
            GetFECHFORMIMP(),
            GetCATVINCPROSID(),
            GetFECHVINCPROS(),
            GetMEDIDACAUTELAR(),
            GetFECHCIERREINV(),
            GetACUSACION(),
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
