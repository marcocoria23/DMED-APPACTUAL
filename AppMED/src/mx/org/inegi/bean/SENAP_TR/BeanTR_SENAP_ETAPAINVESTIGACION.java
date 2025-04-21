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
public class BeanTR_SENAP_ETAPAINVESTIGACION extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String ETAPAINVESTIGACIONID;
    private String CARPETAID;
    private String CARPETAID_FISCALIA;
    private String PROCESOID;
    private String PROCESOID_FISCALIA;
    private String IMPUTADOID;
    private String IMPUTADOID_FISCALIA;
    private String IMPUTADODELITOID;
    private String IMPUTADODELITOID_FISCALIA;
    private String CATETAPAPROCESALID;
    private String CATFISCALIAID;
    private String ESTATUSPROCESOID;
    private String FECHAESTATUSPROCESO;
    private String REGISTROID;
    private String FECHAETAPA;
    private String FECHACORTE;
    private String FECHAACTUALIZACION;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
    }

    public String GetETAPAINVESTIGACIONID() {
        return ETAPAINVESTIGACIONID;
    }

    public void SetETAPAINVESTIGACIONID(String ETAPAINVESTIGACIONID) {
        this.ETAPAINVESTIGACIONID = ETAPAINVESTIGACIONID;
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

    public String GetCATETAPAPROCESALID() {
        return CATETAPAPROCESALID;
    }

    public void SetCATETAPAPROCESALID(String CATETAPAPROCESALID) {
        this.CATETAPAPROCESALID = CATETAPAPROCESALID;
    }

    public String GetCATFISCALIAID() {
        return CATFISCALIAID;
    }

    public void SetCATFISCALIAID(String CATFISCALIAID) {
        this.CATFISCALIAID = CATFISCALIAID;
    }

    public String GetESTATUSPROCESOID() {
        return ESTATUSPROCESOID;
    }

    public void SetESTATUSPROCESOID(String ESTATUSPROCESOID) {
        this.ESTATUSPROCESOID = ESTATUSPROCESOID;
    }

    public String GetFECHAESTATUSPROCESO() {
        return FECHAESTATUSPROCESO;
    }

    public void SetFECHAESTATUSPROCESO(String FECHAESTATUSPROCESO) {
        this.FECHAESTATUSPROCESO = FECHAESTATUSPROCESO;
    }

    public String GetREGISTROID() {
        return REGISTROID;
    }

    public void SetREGISTROID(String REGISTROID) {
        this.REGISTROID = REGISTROID;
    }

    public String GetFECHAETAPA() {
        return FECHAETAPA;
    }

    public void SetFECHAETAPA(String FECHAETAPA) {
        this.FECHAETAPA = FECHAETAPA;
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
            GetETAPAINVESTIGACIONID(),
            GetCARPETAID(),
            GetCARPETAID_FISCALIA(),
            GetPROCESOID(),
            GetPROCESOID_FISCALIA(),
            GetIMPUTADOID(),
            GetIMPUTADOID_FISCALIA(),
            GetIMPUTADODELITOID(),
            GetIMPUTADODELITOID_FISCALIA(),
            GetCATETAPAPROCESALID(),
            GetCATFISCALIAID(),
            GetESTATUSPROCESOID(),
            GetFECHAESTATUSPROCESO(),
            GetREGISTROID(),
            GetFECHAETAPA(),
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
