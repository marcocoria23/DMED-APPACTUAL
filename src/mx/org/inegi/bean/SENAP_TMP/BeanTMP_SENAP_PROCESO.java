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
public class BeanTMP_SENAP_PROCESO extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String PROCESOID;
    private String PROCESOID_FISCALIA;
    private String CATFISCALIAID;
    private String IMPUTADOID;
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
            GetPROCESOID(),
            GetPROCESOID_FISCALIA(),
            GetCATFISCALIAID(),
            GetIMPUTADOID(),
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
