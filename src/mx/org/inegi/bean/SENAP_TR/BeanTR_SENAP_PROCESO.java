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
public class BeanTR_SENAP_PROCESO extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String PROCESOIMPUTADOID;
    private String PROCESOIMPUTADOID_FISCALIA;
    private String PROCESOID;
    private String PROCESOID_FISCALIA;
    private String CARPETAID;
    private String CARPETAID_FISCALIA;
    private String CATETAPAPROCESALID;
    private String CATFISCALIAID;
    private String IMPUTADOID;
    private String IMPUTADODELITOID;
    private String IMPUTADODELITOID_FISCALIA;
    private String PROCESOCAUSA;
    private String FECHAINICIO;
    private String ANIOPROCESO;
    private String HUBOCELEBRACIONAUDIENCIAINICIAL;
    private String CATMOTIVOAUDIENCIAINICIALID;
    private String BORRADO;
    private String FECHAALTA;
    private String USUARIOALTA;
    private String IMPUTADOID_FISCALIA;
    private String FECHAAUDIENCIAINICIAL;
    private String OTROMOTIVO;
    private String ULTIMOESTATUSPROCESOID;
    private String FECHAULTIMOESTATUSPROCESO;
    private String FECHACORTE;
    private String TIENESUSPENSIONCONDICIONAL;
    private String DERIVOMASC;
    private String FECHAACTUALIZACION;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
    }
    
    public String GetPROCESOIMPUTADOID(){
        return PROCESOIMPUTADOID;
    }
    
    public void SetPROCESOIMPUTADOID(String PROCESOIMPUTADOID){
        this.PROCESOIMPUTADOID = PROCESOIMPUTADOID;
    }
    
    public String GetPROCESOIMPUTADOID_FISCALIA() {
        return PROCESOIMPUTADOID_FISCALIA;
    }

    public void SetPROCESOIMPUTADOID_FISCALIA(String PROCESOIMPUTADOID_FISCALIA) {
        this.PROCESOIMPUTADOID_FISCALIA = PROCESOIMPUTADOID_FISCALIA;
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

    public String GetIMPUTADOID() {
        return IMPUTADOID;
    }

    public void SetIMPUTADOID(String IMPUTADOID) {
        this.IMPUTADOID = IMPUTADOID;
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

    public String GetPROCESOCAUSA() {
        return PROCESOCAUSA;
    }

    public void SetPROCESOCAUSA(String PROCESOCAUSA) {
        this.PROCESOCAUSA = PROCESOCAUSA;
    }

    public String GetFECHAINICIO() {
        return FECHAINICIO;
    }

    public void SetFECHAINICIO(String FECHAINICIO) {
        this.FECHAINICIO = FECHAINICIO;
    }

    public String GetANIOPROCESO() {
        return ANIOPROCESO;
    }

    public void SetANIOPROCESO(String ANIOPROCESO) {
        this.ANIOPROCESO = ANIOPROCESO;
    }

    public String GetHUBOCELEBRACIONAUDIENCIAINICIAL() {
        return HUBOCELEBRACIONAUDIENCIAINICIAL;
    }

    public void SetHUBOCELEBRACIONAUDIENCIAINICIAL(String HUBOCELEBRACIONAUDIENCIAINICIAL) {
        this.HUBOCELEBRACIONAUDIENCIAINICIAL = HUBOCELEBRACIONAUDIENCIAINICIAL;
    }

    public String GetCATMOTIVOAUDIENCIAINICIALID() {
        return CATMOTIVOAUDIENCIAINICIALID;
    }

    public void SetCATMOTIVOAUDIENCIAINICIALID(String CATMOTIVOAUDIENCIAINICIALID) {
        this.CATMOTIVOAUDIENCIAINICIALID = CATMOTIVOAUDIENCIAINICIALID;
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

    public String GetIMPUTADOID_FISCALIA() {
        return IMPUTADOID_FISCALIA;
    }

    public void SetIMPUTADOID_FISCALIA(String IMPUTADOID_FISCALIA) {
        this.IMPUTADOID_FISCALIA = IMPUTADOID_FISCALIA;
    }

    public String GetFECHAAUDIENCIAINICIAL() {
        return FECHAAUDIENCIAINICIAL;
    }

    public void SetFECHAAUDIENCIAINICIAL(String FECHAAUDIENCIAINICIAL) {
        this.FECHAAUDIENCIAINICIAL = FECHAAUDIENCIAINICIAL;
    }

    public String GetOTROMOTIVO() {
        return OTROMOTIVO;
    }

    public void SetOTROMOTIVO(String OTROMOTIVO) {
        this.OTROMOTIVO = OTROMOTIVO;
    }

    public String GetULTIMOESTATUSPROCESOID() {
        return ULTIMOESTATUSPROCESOID;
    }

    public void SetULTIMOESTATUSPROCESOID(String ULTIMOESTATUSPROCESOID) {
        this.ULTIMOESTATUSPROCESOID = ULTIMOESTATUSPROCESOID;
    }

    public String GetFECHAULTIMOESTATUSPROCESO() {
        return FECHAULTIMOESTATUSPROCESO;
    }

    public void SetFECHAULTIMOESTATUSPROCESO(String FECHAULTIMOESTATUSPROCESO) {
        this.FECHAULTIMOESTATUSPROCESO = FECHAULTIMOESTATUSPROCESO;
    }

    public String GetFECHACORTE() {
        return FECHACORTE;
    }

    public void SetFECHACORTE(String FECHACORTE) {
        this.FECHACORTE = FECHACORTE;
    }

    public String GetTIENESUSPENSIONCONDICIONAL() {
        return TIENESUSPENSIONCONDICIONAL;
    }

    public void SetTIENESUSPENSIONCONDICIONAL(String TIENESUSPENSIONCONDICIONAL) {
        this.TIENESUSPENSIONCONDICIONAL = TIENESUSPENSIONCONDICIONAL;
    }

    public String GetDERIVOMASC() {
        return DERIVOMASC;
    }

    public void SetDERIVOMASC(String DERIVOMASC) {
        this.DERIVOMASC = DERIVOMASC;
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
            GetPROCESOIMPUTADOID(),
            GetPROCESOIMPUTADOID_FISCALIA(),
            GetPROCESOID(),
            GetPROCESOID_FISCALIA(),
            GetCARPETAID(),
            GetCARPETAID_FISCALIA(),
            GetCATETAPAPROCESALID(),
            GetCATFISCALIAID(),
            GetIMPUTADOID(),
            GetIMPUTADODELITOID(),
            GetIMPUTADODELITOID_FISCALIA(),
            GetPROCESOCAUSA(),
            GetFECHAINICIO(),
            GetANIOPROCESO(),
            GetHUBOCELEBRACIONAUDIENCIAINICIAL(),
            GetCATMOTIVOAUDIENCIAINICIALID(),
            GetBORRADO(),
            GetFECHAALTA(),
            GetUSUARIOALTA(),
            GetIMPUTADOID_FISCALIA(),
            GetFECHAAUDIENCIAINICIAL(),
            GetOTROMOTIVO(),
            GetULTIMOESTATUSPROCESOID(),
            GetFECHAULTIMOESTATUSPROCESO(),
            GetFECHACORTE(),
            GetTIENESUSPENSIONCONDICIONAL(),
            GetDERIVOMASC(),
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
