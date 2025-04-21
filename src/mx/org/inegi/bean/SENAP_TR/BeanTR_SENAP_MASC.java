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
public class BeanTR_SENAP_MASC extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String MASCID;
    private String MASCID_FISCALIA;
    private String CARPETAID;
    private String CARPETAID_FISCALIA;
    private String PROCESOIMPUTADOID;
    private String PROCESOIMPUTADOID_FISCALIA;
    private String CATFISCALIAID;
    private String IMPUTADOID;
    private String IMPUTADOID_FISCALIA;
    private String CATAUTORIDADDERIVAMASCID;
    private String FECHADERIVAMASC;
    private String CATTIPOMASCID;
    private String CATTIPOCUMPLIMIENTOID;
    private String FECHACUMPLIMENTOMASC;
    private String MONTOREPARACIONDANIO;
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

    public String GetMASCID() {
        return MASCID;
    }

    public void SetMASCID(String MASCID) {
        this.MASCID = MASCID;
    }

    public String GetMASCID_FISCALIA() {
        return MASCID_FISCALIA;
    }

    public void SetMASCID_FISCALIA(String MASCID_FISCALIA) {
        this.MASCID_FISCALIA = MASCID_FISCALIA;
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

    public String GetCATFISCALIAID() {
        return CATFISCALIAID;
    }

    public void SetCATFISCALIAID(String CATFISCALIAID) {
        this.CATFISCALIAID = CATFISCALIAID;
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

    public String GetCATAUTORIDADDERIVAMASCID() {
        return CATAUTORIDADDERIVAMASCID;
    }

    public void SetCATAUTORIDADDERIVAMASCID(String CATAUTORIDADDERIVAMASCID) {
        this.CATAUTORIDADDERIVAMASCID = CATAUTORIDADDERIVAMASCID;
    }

    public String GetFECHADERIVAMASC() {
        return FECHADERIVAMASC;
    }

    public void SetFECHADERIVAMASC(String FECHADERIVAMASC) {
        this.FECHADERIVAMASC = FECHADERIVAMASC;
    }

    public String GetCATTIPOMASCID() {
        return CATTIPOMASCID;
    }

    public void SetCATTIPOMASCID(String CATTIPOMASCID) {
        this.CATTIPOMASCID = CATTIPOMASCID;
    }

    public String GetCATTIPOCUMPLIMIENTOID() {
        return CATTIPOCUMPLIMIENTOID;
    }

    public void SetCATTIPOCUMPLIMIENTOID(String CATTIPOCUMPLIMIENTOID) {
        this.CATTIPOCUMPLIMIENTOID = CATTIPOCUMPLIMIENTOID;
    }

    public String GetFECHACUMPLIMENTOMASC() {
        return FECHACUMPLIMENTOMASC;
    }

    public void SetFECHACUMPLIMENTOMASC(String FECHACUMPLIMENTOMASC) {
        this.FECHACUMPLIMENTOMASC = FECHACUMPLIMENTOMASC;
    }

    public String GetMONTOREPARACIONDANIO() {
        return MONTOREPARACIONDANIO;
    }

    public void SetMONTOREPARACIONDANIO(String MONTOREPARACIONDANIO) {
        this.MONTOREPARACIONDANIO = MONTOREPARACIONDANIO;
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
            GetMASCID(),
            GetMASCID_FISCALIA(),
            GetCARPETAID(),
            GetCARPETAID_FISCALIA(),
            GetPROCESOIMPUTADOID(),
            GetPROCESOIMPUTADOID_FISCALIA(),
            GetCATFISCALIAID(),
            GetIMPUTADOID(),
            GetIMPUTADOID_FISCALIA(),
            GetCATAUTORIDADDERIVAMASCID(),
            GetFECHADERIVAMASC(),
            GetCATTIPOMASCID(),
            GetCATTIPOCUMPLIMIENTOID(),
            GetFECHACUMPLIMENTOMASC(),
            GetMONTOREPARACIONDANIO(),
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
