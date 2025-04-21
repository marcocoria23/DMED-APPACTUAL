/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.bean.SENAP_TR;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANTONIO.CORIA
 */
public class BeanTR_SENAP_MEDIDASCAUTELARES extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String MEDIDACAUTELARID;
    private String MEDIDACAUTELARID_FISCALIA;
    private String CARPETAID;
    private String CARPETAID_FISCALIA;
    private String PROCESOIMPUTADOID;
    private String PROCESOIMPUTADOID_FISCALIA;
    private String IMPUTADOID;
    private String IMPUTADOID_FISCALIA;
    private String CATFISCALIAID;
    private String PROCESOID;
    private String PROCESOID_FISCALIA;
    private String CATMEDIDAID;
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

    public String GetMEDIDACAUTELARID() {
        return MEDIDACAUTELARID;
    }

    public void SetMEDIDACAUTELARID(String MEDIDACAUTELARID) {
        this.MEDIDACAUTELARID = MEDIDACAUTELARID;
    }

    public String GetMEDIDACAUTELARID_FISCALIA() {
        return MEDIDACAUTELARID_FISCALIA;
    }

    public void SetMEDIDACAUTELARID_FISCALIA(String MEDIDACAUTELARID_FISCALIA) {
        this.MEDIDACAUTELARID_FISCALIA = MEDIDACAUTELARID_FISCALIA;
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

    public String GetPROCESOIMPUTADOID() {
        return PROCESOIMPUTADOID;
    }

    public void SetPROCESOIMPUTADOID(String PROCESOIMPUTADOID) {
        this.PROCESOIMPUTADOID = PROCESOIMPUTADOID;
    }

    public String GetPROCESOIMPUTADOID_FISCALIA() {
        return PROCESOIMPUTADOID_FISCALIA;
    }

    public void SetPROCESOIMPUTADOID_FISCALIA(String PROCESOIMPUTADOID_FISCALIA) {
        this.PROCESOIMPUTADOID_FISCALIA = PROCESOIMPUTADOID_FISCALIA;
    }

    public String GetIMPUTADOID() {
        return IMPUTADOID;
    }

    public void SetIMPUTADOID(String IMPUTADOID) {
        this.IMPUTADOID = IMPUTADOID;
    }

    public String GetIMPUTADOID_FISCALIA() {
        return IMPUTADOID_FISCALIA;
    }

    public void SetIMPUTADOID_FISCALIA(String IMPUTADOID_FISCALIA) {
        this.IMPUTADOID_FISCALIA = IMPUTADOID_FISCALIA;
    }

    public String GetCATFISCALIAID() {
        return CATFISCALIAID;
    }

    public void SetCATFISCALIAID(String CATFISCALIAID) {
        this.CATFISCALIAID = CATFISCALIAID;
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

    public String GetCATMEDIDAID() {
        return CATMEDIDAID;
    }

    public void SetCATMEDIDAID(String CATMEDIDAID) {
        this.CATMEDIDAID = CATMEDIDAID;
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
            GetMEDIDACAUTELARID(),
            GetMEDIDACAUTELARID_FISCALIA(),
            GetCARPETAID(),
            GetCARPETAID_FISCALIA(),
            GetPROCESOIMPUTADOID(),
            GetPROCESOIMPUTADOID_FISCALIA(),
            GetIMPUTADOID(),
            GetIMPUTADOID_FISCALIA(),
            GetCATFISCALIAID(),
            GetPROCESOID(),
            GetPROCESOID_FISCALIA(),
            GetCATMEDIDAID(),
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
