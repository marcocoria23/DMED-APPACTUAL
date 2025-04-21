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
public class BeanTMP_SENAP_NOTICIACRIMINAL extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String NOTICIACRIMINALID;
    private String NOTICIACRIMINALID_FISCALIA;
    private String CATFISCALIAID;
    private String NOMBREFISREGIOESPECIALIZADA;
    private String CATFISREGIOESPECIALIZADAID;
    private String NOMBREAGEMINISTERIOPUBLICO;
    private String CATTIPOAGENCIAID;
    private String NOMAGEMINISTERIOPUBLICORESP;
    private String IDAGEMINISTERIOPUBLICORESP;
    private String CATMEDCONOCHECHOSID;
    private String FECHAPRESDENUNQUERELLA;
    private String HORAREPREDENUNQUERELLA;
    private String CATAUTORDENUNQUERELLAID;
    private String INICIOCARPETAINVESTIGACION;
    private String CARPETAID;
    private String BRINDOALGUNTIPOATENCION;
    private String FOLIONOTICIA;
    private String ANIOFOLIONOTICIA;
    private String BORRADO;
    private String FECHAALTA;
    private String USUARIOALTA;
    private String DIRECCIONUBICACIONID;
    private String CARPETAID_FISCALIA;
    private String FECHACORTE;
    private String FECHAACTUALIZACION;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
    }

    public String GetNOTICIACRIMINALID() {
        return NOTICIACRIMINALID;
    }

    public void SetNOTICIACRIMINALID(String NOTICIACRIMINALID) {
        this.NOTICIACRIMINALID = NOTICIACRIMINALID;
    }

    public String GetNOTICIACRIMINALID_FISCALIA() {
        return NOTICIACRIMINALID_FISCALIA;
    }

    public void SetNOTICIACRIMINALID_FISCALIA(String NOTICIACRIMINALID_FISCALIA) {
        this.NOTICIACRIMINALID_FISCALIA = NOTICIACRIMINALID_FISCALIA;
    }

    public String GetCATFISCALIAID() {
        return CATFISCALIAID;
    }

    public void SetCATFISCALIAID(String CATFISCALIAID) {
        this.CATFISCALIAID = CATFISCALIAID;
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

    public String GetFECHAPRESDENUNQUERELLA() {
        return FECHAPRESDENUNQUERELLA;
    }

    public void SetFECHAPRESDENUNQUERELLA(String FECHAPRESDENUNQUERELLA) {
        this.FECHAPRESDENUNQUERELLA = FECHAPRESDENUNQUERELLA;
    }

    public String GetHORAREPREDENUNQUERELLA() {
        return HORAREPREDENUNQUERELLA;
    }

    public void SetHORAREPREDENUNQUERELLA(String HORAREPREDENUNQUERELLA) {
        this.HORAREPREDENUNQUERELLA = HORAREPREDENUNQUERELLA;
    }

    public String GetCATAUTORDENUNQUERELLAID() {
        return CATAUTORDENUNQUERELLAID;
    }

    public void SetCATAUTORDENUNQUERELLAID(String CATAUTORDENUNQUERELLAID) {
        this.CATAUTORDENUNQUERELLAID = CATAUTORDENUNQUERELLAID;
    }

    public String GetINICIOCARPETAINVESTIGACION() {
        return INICIOCARPETAINVESTIGACION;
    }

    public void SetINICIOCARPETAINVESTIGACION(String INICIOCARPETAINVESTIGACION) {
        this.INICIOCARPETAINVESTIGACION = INICIOCARPETAINVESTIGACION;
    }

    public String GetCARPETAID() {
        return CARPETAID;
    }

    public void SetCARPETAID(String CARPETAID) {
        this.CARPETAID = CARPETAID;
    }

    public String GetBRINDOALGUNTIPOATENCION() {
        return BRINDOALGUNTIPOATENCION;
    }

    public void SetBRINDOALGUNTIPOATENCION(String BRINDOALGUNTIPOATENCION) {
        this.BRINDOALGUNTIPOATENCION = BRINDOALGUNTIPOATENCION;
    }

    public String GetFOLIONOTICIA() {
        return FOLIONOTICIA;
    }

    public void SetFOLIONOTICIA(String FOLIONOTICIA) {
        this.FOLIONOTICIA = FOLIONOTICIA;
    }

    public String GetANIOFOLIONOTICIA() {
        return ANIOFOLIONOTICIA;
    }

    public void SetANIOFOLIONOTICIA(String ANIOFOLIONOTICIA) {
        this.ANIOFOLIONOTICIA = ANIOFOLIONOTICIA;
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

    public String GetCARPETAID_FISCALIA() {
        return CARPETAID_FISCALIA;
    }

    public void SetCARPETAID_FISCALIA(String CARPETAID_FISCALIA) {
        this.CARPETAID_FISCALIA = CARPETAID_FISCALIA;
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
            GetNOTICIACRIMINALID(),
            GetNOTICIACRIMINALID_FISCALIA(),
            GetCATFISCALIAID(),
            GetNOMBREFISREGIOESPECIALIZADA(),
            GetCATFISREGIOESPECIALIZADAID(),
            GetNOMBREAGEMINISTERIOPUBLICO(),
            GetCATTIPOAGENCIAID(),
            GetNOMAGEMINISTERIOPUBLICORESP(),
            GetIDAGEMINISTERIOPUBLICORESP(),
            GetCATMEDCONOCHECHOSID(),
            GetFECHAPRESDENUNQUERELLA(),
            GetHORAREPREDENUNQUERELLA(),
            GetCATAUTORDENUNQUERELLAID(),
            GetINICIOCARPETAINVESTIGACION(),
            GetCARPETAID(),
            GetBRINDOALGUNTIPOATENCION(),
            GetFOLIONOTICIA(),
            GetANIOFOLIONOTICIA(),
            GetBORRADO(),
            GetFECHAALTA(),
            GetUSUARIOALTA(),
            GetDIRECCIONUBICACIONID(),
            GetCARPETAID_FISCALIA(),
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
