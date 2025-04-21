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
public class BeanTMP_SENAP_DELITOS extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String DELITOID;
    private String DELITOID_FISCALIA;
    private String CATFISCALIAID;
    private String CARPETAID;
    private String DELITOLEYPENAL;
    private String SENALAMIENTONORMATIVO;
    private String CATFUEROID;
    private String CATDELITONORMATECNICAID;
    private String FECHAOCURRENCIA;
    private String HORAOCURRENCIA;
    private String DIRECCIONUBICACIONID;
    private String CATTIPOSITIOOCURRENCIAID;
    private String CATGRADOCONSUMACIONID;
    private String CATCALIFICACIONDELITOID;
    private String CATFORMACOMISIONID;
    private String CATFORMAACCIONID;
    private String CATMODALIDADID;
    private String CATINSTRUMENTOSCOMISIONID;
    private String CATCONTEXTOSITUACIONALID;
    private String CATMOMENTORECLASIFICACIONID;
    private String FECHARECLASIFICACION;
    private String BORRADO;
    private String FECHAALTA;
    private String USUARIOALTA;
    private String CARPETAID_FISCALIA;
    private String DELITOID_RECLASIFICADO;
    private String RECLASIFICACIONACTUAL;
    private String FECHACORTE;
    private String HUBORECLASIFICACION;
    private String FECHAACTUALIZACION;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
    }

    public String GetDELITOID() {
        return DELITOID;
    }

    public void SetDELITOID(String DELITOID) {
        this.DELITOID = DELITOID;
    }

    public String GetDELITOID_FISCALIA() {
        return DELITOID_FISCALIA;
    }

    public void SetDELITOID_FISCALIA(String DELITOID_FISCALIA) {
        this.DELITOID_FISCALIA = DELITOID_FISCALIA;
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

    public String GetDELITOLEYPENAL() {
        return DELITOLEYPENAL;
    }

    public void SetDELITOLEYPENAL(String DELITOLEYPENAL) {
        this.DELITOLEYPENAL = DELITOLEYPENAL;
    }

    public String GetSENALAMIENTONORMATIVO() {
        return SENALAMIENTONORMATIVO;
    }

    public void SetSENALAMIENTONORMATIVO(String SENALAMIENTONORMATIVO) {
        this.SENALAMIENTONORMATIVO = SENALAMIENTONORMATIVO;
    }

    public String GetCATFUEROID() {
        return CATFUEROID;
    }

    public void SetCATFUEROID(String CATFUEROID) {
        this.CATFUEROID = CATFUEROID;
    }

    public String GetCATDELITONORMATECNICAID() {
        return CATDELITONORMATECNICAID;
    }

    public void SetCATDELITONORMATECNICAID(String CATDELITONORMATECNICAID) {
        this.CATDELITONORMATECNICAID = CATDELITONORMATECNICAID;
    }

    public String GetFECHAOCURRENCIA() {
        return FECHAOCURRENCIA;
    }

    public void SetFECHAOCURRENCIA(String FECHAOCURRENCIA) {
        this.FECHAOCURRENCIA = FECHAOCURRENCIA;
    }

    public String GetHORAOCURRENCIA() {
        return HORAOCURRENCIA;
    }

    public void SetHORAOCURRENCIA(String HORAOCURRENCIA) {
        this.HORAOCURRENCIA = HORAOCURRENCIA;
    }

    public String GetDIRECCIONUBICACIONID() {
        return DIRECCIONUBICACIONID;
    }

    public void SetDIRECCIONUBICACIONID(String DIRECCIONUBICACIONID) {
        this.DIRECCIONUBICACIONID = DIRECCIONUBICACIONID;
    }

    public String GetCATTIPOSITIOOCURRENCIAID() {
        return CATTIPOSITIOOCURRENCIAID;
    }

    public void SetCATTIPOSITIOOCURRENCIAID(String CATTIPOSITIOOCURRENCIAID) {
        this.CATTIPOSITIOOCURRENCIAID = CATTIPOSITIOOCURRENCIAID;
    }

    public String GetCATGRADOCONSUMACIONID() {
        return CATGRADOCONSUMACIONID;
    }

    public void SetCATGRADOCONSUMACIONID(String CATGRADOCONSUMACIONID) {
        this.CATGRADOCONSUMACIONID = CATGRADOCONSUMACIONID;
    }

    public String GetCATCALIFICACIONDELITOID() {
        return CATCALIFICACIONDELITOID;
    }

    public void SetCATCALIFICACIONDELITOID(String CATCALIFICACIONDELITOID) {
        this.CATCALIFICACIONDELITOID = CATCALIFICACIONDELITOID;
    }

    public String GetCATFORMACOMISIONID() {
        return CATFORMACOMISIONID;
    }

    public void SetCATFORMACOMISIONID(String CATFORMACOMISIONID) {
        this.CATFORMACOMISIONID = CATFORMACOMISIONID;
    }

    public String GetCATFORMAACCIONID() {
        return CATFORMAACCIONID;
    }

    public void SetCATFORMAACCIONID(String CATFORMAACCIONID) {
        this.CATFORMAACCIONID = CATFORMAACCIONID;
    }

    public String GetCATMODALIDADID() {
        return CATMODALIDADID;
    }

    public void SetCATMODALIDADID(String CATMODALIDADID) {
        this.CATMODALIDADID = CATMODALIDADID;
    }

    public String GetCATINSTRUMENTOSCOMISIONID() {
        return CATINSTRUMENTOSCOMISIONID;
    }

    public void SetCATINSTRUMENTOSCOMISIONID(String CATINSTRUMENTOSCOMISIONID) {
        this.CATINSTRUMENTOSCOMISIONID = CATINSTRUMENTOSCOMISIONID;
    }

    public String GetCATCONTEXTOSITUACIONALID() {
        return CATCONTEXTOSITUACIONALID;
    }

    public void SetCATCONTEXTOSITUACIONALID(String CATCONTEXTOSITUACIONALID) {
        this.CATCONTEXTOSITUACIONALID = CATCONTEXTOSITUACIONALID;
    }

    public String GetCATMOMENTORECLASIFICACIONID() {
        return CATMOMENTORECLASIFICACIONID;
    }

    public void SetCATMOMENTORECLASIFICACIONID(String CATMOMENTORECLASIFICACIONID) {
        this.CATMOMENTORECLASIFICACIONID = CATMOMENTORECLASIFICACIONID;
    }

    public String GetFECHARECLASIFICACION() {
        return FECHARECLASIFICACION;
    }

    public void SetFECHARECLASIFICACION(String FECHARECLASIFICACION) {
        this.FECHARECLASIFICACION = FECHARECLASIFICACION;
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

    public String GetCARPETAID_FISCALIA() {
        return CARPETAID_FISCALIA;
    }

    public void SetCARPETAID_FISCALIA(String CARPETAID_FISCALIA) {
        this.CARPETAID_FISCALIA = CARPETAID_FISCALIA;
    }

    public String GetDELITOID_RECLASIFICADO() {
        return DELITOID_RECLASIFICADO;
    }

    public void SetDELITOID_RECLASIFICADO(String DELITOID_RECLASIFICADO) {
        this.DELITOID_RECLASIFICADO = DELITOID_RECLASIFICADO;
    }

    public String GetRECLASIFICACIONACTUAL() {
        return RECLASIFICACIONACTUAL;
    }

    public void SetRECLASIFICACIONACTUAL(String RECLASIFICACIONACTUAL) {
        this.RECLASIFICACIONACTUAL = RECLASIFICACIONACTUAL;
    }

    public String GetFECHACORTE() {
        return FECHACORTE;
    }

    public void SetFECHACORTE(String FECHACORTE) {
        this.FECHACORTE = FECHACORTE;
    }

    public String GetHUBORECLASIFICACION() {
        return HUBORECLASIFICACION;
    }

    public void SetHUBORECLASIFICACION(String HUBORECLASIFICACION) {
        this.HUBORECLASIFICACION = HUBORECLASIFICACION;
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
            GetDELITOID(),
            GetDELITOID_FISCALIA(),
            GetCATFISCALIAID(),
            GetCARPETAID(),
            GetDELITOLEYPENAL(),
            GetSENALAMIENTONORMATIVO(),
            GetCATFUEROID(),
            GetCATDELITONORMATECNICAID(),
            GetFECHAOCURRENCIA(),
            GetHORAOCURRENCIA(),
            GetDIRECCIONUBICACIONID(),
            GetCATTIPOSITIOOCURRENCIAID(),
            GetCATGRADOCONSUMACIONID(),
            GetCATCALIFICACIONDELITOID(),
            GetCATFORMACOMISIONID(),
            GetCATFORMAACCIONID(),
            GetCATMODALIDADID(),
            GetCATINSTRUMENTOSCOMISIONID(),
            GetCATCONTEXTOSITUACIONALID(),
            GetCATMOMENTORECLASIFICACIONID(),
            GetFECHARECLASIFICACION(),
            GetBORRADO(),
            GetFECHAALTA(),
            GetUSUARIOALTA(),
            GetCARPETAID_FISCALIA(),
            GetDELITOID_RECLASIFICADO(),
            GetRECLASIFICACIONACTUAL(),
            GetFECHACORTE(),
            GetHUBORECLASIFICACION(),
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
