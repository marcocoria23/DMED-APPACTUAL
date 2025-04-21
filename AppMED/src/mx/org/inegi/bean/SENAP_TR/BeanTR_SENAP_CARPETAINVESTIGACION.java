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
public class BeanTR_SENAP_CARPETAINVESTIGACION extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String CARPETAID;
    private String CARPETAID_FISCALIA;
    private String CATFISCALIAID;
    private String NOTICIACRIMINALID_FISCALIA;
    private String NOTICIACRIMINALID;
    private String NOMBREFISREGIOESPECIALIZADA;
    private String CATFISREGIOESPECIALIZADAID;
    private String NOMBREAGEMINISTERIOPUBLICO;
    private String CATTIPOAGENCIAID;
    private String NOMAGEMINISTERIOPUBLICORESP;
    private String IDAGEMINISTERIOPUBLICORESP;
    private String CATMEDCONOCHECHOSID;
    private String NUMCARPINVE;
    private String NUMERICOANIOCARPETA;
    private String FECHACARINVE;
    private String HORAPECARINVE;
    private String CATFORMINICARINVEID;
    private String REALACTINVE;
    private String CANTIDADDELITOS;
    private String CANTIDADVICTIMAS;
    private String CANTIDADIMPUTADOS;
    private String REALIZARONASEGURAMIENTOS;
    private String FOLIOCARPETA;
    private String ANIOFOLIOCARPETA;
    private String DETERMINACIONID_ULTIMO;
    private String BORRADO;
    private String FECHAALTA;
    private String USUARIOALTA;
    private String DIRECCIONUBICACIONID;
    private String FECHACORTE;
    private String CATHECHOCIID;
    private String CATETAPAPROCESALID;
    private String DESCRIPCIONHECHOS;
    private String FECHAACTUALIZACION;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
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

    public String GetCATFISCALIAID() {
        return CATFISCALIAID;
    }

    public void SetCATFISCALIAID(String CATFISCALIAID) {
        this.CATFISCALIAID = CATFISCALIAID;
    }

    public String GetNOTICIACRIMINALID_FISCALIA() {
        return NOTICIACRIMINALID_FISCALIA;
    }

    public void SetNOTICIACRIMINALID_FISCALIA(String NOTICIACRIMINALID_FISCALIA) {
        this.NOTICIACRIMINALID_FISCALIA = NOTICIACRIMINALID_FISCALIA;
    }

    public String GetNOTICIACRIMINALID() {
        return NOTICIACRIMINALID;
    }

    public void SetNOTICIACRIMINALID(String NOTICIACRIMINALID) {
        this.NOTICIACRIMINALID = NOTICIACRIMINALID;
    }

    public String GetNOMBREFISREGIOESPECIALIZADA() {
        return NOMBREFISREGIOESPECIALIZADA;
    }

    public void SetNOMBREFISREGIOESPECIALIZADA(String NOMBREFISREGIOESPECIALIZADA) {
        this.NOMBREFISREGIOESPECIALIZADA = NOMBREFISREGIOESPECIALIZADA;
    }

    public String GetCATFISREGIOESPECIALIZADAID() {
        return CATFISREGIOESPECIALIZADAID;
    }

    public void SetCATFISREGIOESPECIALIZADAID(String CATFISREGIOESPECIALIZADAID) {
        this.CATFISREGIOESPECIALIZADAID = CATFISREGIOESPECIALIZADAID;
    }

    public String GetNOMBREAGEMINISTERIOPUBLICO() {
        return NOMBREAGEMINISTERIOPUBLICO;
    }

    public void SetNOMBREAGEMINISTERIOPUBLICO(String NOMBREAGEMINISTERIOPUBLICO) {
        this.NOMBREAGEMINISTERIOPUBLICO = NOMBREAGEMINISTERIOPUBLICO;
    }

    public String GetCATTIPOAGENCIAID() {
        return CATTIPOAGENCIAID;
    }

    public void SetCATTIPOAGENCIAID(String CATTIPOAGENCIAID) {
        this.CATTIPOAGENCIAID = CATTIPOAGENCIAID;
    }

    public String GetNOMAGEMINISTERIOPUBLICORESP() {
        return NOMAGEMINISTERIOPUBLICORESP;
    }

    public void SetNOMAGEMINISTERIOPUBLICORESP(String NOMAGEMINISTERIOPUBLICORESP) {
        this.NOMAGEMINISTERIOPUBLICORESP = NOMAGEMINISTERIOPUBLICORESP;
    }

    public String GetIDAGEMINISTERIOPUBLICORESP() {
        return IDAGEMINISTERIOPUBLICORESP;
    }

    public void SetIDAGEMINISTERIOPUBLICORESP(String IDAGEMINISTERIOPUBLICORESP) {
        this.IDAGEMINISTERIOPUBLICORESP = IDAGEMINISTERIOPUBLICORESP;
    }

    public String GetCATMEDCONOCHECHOSID() {
        return CATMEDCONOCHECHOSID;
    }

    public void SetCATMEDCONOCHECHOSID(String CATMEDCONOCHECHOSID) {
        this.CATMEDCONOCHECHOSID = CATMEDCONOCHECHOSID;
    }

    public String GetNUMCARPINVE() {
        return NUMCARPINVE;
    }

    public void SetNUMCARPINVE(String NUMCARPINVE) {
        this.NUMCARPINVE = NUMCARPINVE;
    }

    public String GetNUMERICOANIOCARPETA() {
        return NUMERICOANIOCARPETA;
    }

    public void SetNUMERICOANIOCARPETA(String NUMERICOANIOCARPETA) {
        this.NUMERICOANIOCARPETA = NUMERICOANIOCARPETA;
    }

    public String GetFECHACARINVE() {
        return FECHACARINVE;
    }

    public void SetFECHACARINVE(String FECHACARINVE) {
        this.FECHACARINVE = FECHACARINVE;
    }

    public String GetHORAPECARINVE() {
        return HORAPECARINVE;
    }

    public void SetHORAPECARINVE(String HORAPECARINVE) {
        this.HORAPECARINVE = HORAPECARINVE;
    }

    public String GetCATFORMINICARINVEID() {
        return CATFORMINICARINVEID;
    }

    public void SetCATFORMINICARINVEID(String CATFORMINICARINVEID) {
        this.CATFORMINICARINVEID = CATFORMINICARINVEID;
    }

    public String GetREALACTINVE() {
        return REALACTINVE;
    }

    public void SetREALACTINVE(String REALACTINVE) {
        this.REALACTINVE = REALACTINVE;
    }

    public String GetCANTIDADDELITOS() {
        return CANTIDADDELITOS;
    }

    public void SetCANTIDADDELITOS(String CANTIDADDELITOS) {
        this.CANTIDADDELITOS = CANTIDADDELITOS;
    }

    public String GetCANTIDADVICTIMAS() {
        return CANTIDADVICTIMAS;
    }

    public void SetCANTIDADVICTIMAS(String CANTIDADVICTIMAS) {
        this.CANTIDADVICTIMAS = CANTIDADVICTIMAS;
    }

    public String GetCANTIDADIMPUTADOS() {
        return CANTIDADIMPUTADOS;
    }

    public void SetCANTIDADIMPUTADOS(String CANTIDADIMPUTADOS) {
        this.CANTIDADIMPUTADOS = CANTIDADIMPUTADOS;
    }

    public String GetREALIZARONASEGURAMIENTOS() {
        return REALIZARONASEGURAMIENTOS;
    }

    public void SetREALIZARONASEGURAMIENTOS(String REALIZARONASEGURAMIENTOS) {
        this.REALIZARONASEGURAMIENTOS = REALIZARONASEGURAMIENTOS;
    }

    public String GetFOLIOCARPETA() {
        return FOLIOCARPETA;
    }

    public void SetFOLIOCARPETA(String FOLIOCARPETA) {
        this.FOLIOCARPETA = FOLIOCARPETA;
    }

    public String GetANIOFOLIOCARPETA() {
        return ANIOFOLIOCARPETA;
    }

    public void SetANIOFOLIOCARPETA(String ANIOFOLIOCARPETA) {
        this.ANIOFOLIOCARPETA = ANIOFOLIOCARPETA;
    }

    public String GetDETERMINACIONID_ULTIMO() {
        return DETERMINACIONID_ULTIMO;
    }

    public void SetDETERMINACIONID_ULTIMO(String DETERMINACIONID_ULTIMO) {
        this.DETERMINACIONID_ULTIMO = DETERMINACIONID_ULTIMO;
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

    public String GetDIRECCIONUBICACIONID() {
        return DIRECCIONUBICACIONID;
    }

    public void SetDIRECCIONUBICACIONID(String DIRECCIONUBICACIONID) {
        this.DIRECCIONUBICACIONID = DIRECCIONUBICACIONID;
    }

    public String GetFECHACORTE() {
        return FECHACORTE;
    }

    public void SetFECHACORTE(String FECHACORTE) {
        this.FECHACORTE = FECHACORTE;
    }

    public String GetCATHECHOCIID() {
        return CATHECHOCIID;
    }

    public void SetCATHECHOCIID(String CATHECHOCIID) {
        this.CATHECHOCIID = CATHECHOCIID;
    }

    public String GetCATETAPAPROCESALID() {
        return CATETAPAPROCESALID;
    }

    public void SetCATETAPAPROCESALID(String CATETAPAPROCESALID) {
        this.CATETAPAPROCESALID = CATETAPAPROCESALID;
    }

    public String GetDESCRIPCIONHECHOS() {
        return DESCRIPCIONHECHOS;
    }

    public void SetDESCRIPCIONHECHOS(String DESCRIPCIONHECHOS) {
        this.DESCRIPCIONHECHOS = DESCRIPCIONHECHOS;
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
            GetCARPETAID(),
            GetCARPETAID_FISCALIA(),
            GetCATFISCALIAID(),
            GetNOTICIACRIMINALID_FISCALIA(),
            GetNOTICIACRIMINALID(),
            GetNOMBREFISREGIOESPECIALIZADA(),
            GetCATFISREGIOESPECIALIZADAID(),
            GetNOMBREAGEMINISTERIOPUBLICO(),
            GetCATTIPOAGENCIAID(),
            GetNOMAGEMINISTERIOPUBLICORESP(),
            GetIDAGEMINISTERIOPUBLICORESP(),
            GetCATMEDCONOCHECHOSID(),
            GetNUMCARPINVE(),
            GetNUMERICOANIOCARPETA(),
            GetFECHACARINVE(),
            GetHORAPECARINVE(),
            GetCATFORMINICARINVEID(),
            GetREALACTINVE(),
            GetCANTIDADDELITOS(),
            GetCANTIDADVICTIMAS(),
            GetCANTIDADIMPUTADOS(),
            GetREALIZARONASEGURAMIENTOS(),
            GetFOLIOCARPETA(),
            GetANIOFOLIOCARPETA(),
            GetDETERMINACIONID_ULTIMO(),
            GetBORRADO(),
            GetFECHAALTA(),
            GetUSUARIOALTA(),
            GetDIRECCIONUBICACIONID(),
            GetFECHACORTE(),
            GetCATHECHOCIID(),
            GetCATETAPAPROCESALID(),
            GetDESCRIPCIONHECHOS(),
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
