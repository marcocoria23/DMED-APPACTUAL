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
public class BeanTMP_SENAP_VICTIMAS extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String VICTIMAID;
    private String VICTIMAID_FISCALIA;
    private String CATFISCALIAID;
    private String CARPETAID;
    private String NOMBREVICTIMA;
    private String CATTIPOVICTIMAID;
    private String CURP;
    private String FECHANACIMIENTO;
    private String EDADMOMSUCHEC;
    private String CATSEXOID;
    private String CATSITUACIONCONYUGALID;
    private String VESTIMENTARASGOSVISIBLES;
    private String CATNACIONALIDADID;
    private String CATSITUACIONMIGRATORIAID;
    private String CATPAISNACIMIENTOID;
    private String CATENTIDADNACIMIENTOID;
    private String CATMUNICIPIOID;
    private String CATPAISRESHAB;
    private String DIRECCIONUBICACIONID;
    private String NUMEROTELEFONICO;
    private String HABLAESPANIOL;
    private String HABLALENGUAEXTRANJERA;
    private String CATTIPLEGEXT;
    private String HABLALENGUAINDIGENA;
    private String CATTIPOLENGUAINDIGENAID;
    private String UTITRAINT;
    private String PRESENTADISCAPACIDAD;
    private String CATTIPODISCAPACIDADID;
    private String MEDIOTECDISCAPACIDAD;
    private String PERPOPIND;
    private String CATTIPPOPIND;
    private String PERPOBLGBTTTI;
    private String CATTIPOLGBTTTIID;
    private String PERPOBSITCALLE;
    private String SABELEERESCRIBIR;
    private String CATNIVELESCOLARIDADID;
    private String CATOCUPACIONID;
    private String RANINGMENNET;
    private String HECANTVICMANSUFVIOL;
    private String CONTOASESORJURIDICO;
    private String CATTIPOASESORJURIDICOID;
    private String RECIBIOATENCIONMEDICA;
    private String RECATEPSICO;
    private String BORRADO;
    private String FECHAALTA;
    private String USUARIOALTA;
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

    public String GetVICTIMAID() {
        return VICTIMAID;
    }

    public void SetVICTIMAID(String VICTIMAID) {
        this.VICTIMAID = VICTIMAID;
    }

    public String GetVICTIMAID_FISCALIA() {
        return VICTIMAID_FISCALIA;
    }

    public void SetVICTIMAID_FISCALIA(String VICTIMAID_FISCALIA) {
        this.VICTIMAID_FISCALIA = VICTIMAID_FISCALIA;
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

    public String GetNOMBREVICTIMA() {
        return NOMBREVICTIMA;
    }

    public void SetNOMBREVICTIMA(String NOMBREVICTIMA) {
        this.NOMBREVICTIMA = NOMBREVICTIMA;
    }

    public String GetCATTIPOVICTIMAID() {
        return CATTIPOVICTIMAID;
    }

    public void SetCATTIPOVICTIMAID(String CATTIPOVICTIMAID) {
        this.CATTIPOVICTIMAID = CATTIPOVICTIMAID;
    }

    public String GetCURP() {
        return CURP;
    }

    public void SetCURP(String CURP) {
        this.CURP = CURP;
    }

    public String GetFECHANACIMIENTO() {
        return FECHANACIMIENTO;
    }

    public void SetFECHANACIMIENTO(String FECHANACIMIENTO) {
        this.FECHANACIMIENTO = FECHANACIMIENTO;
    }

    public String GetEDADMOMSUCHEC() {
        return EDADMOMSUCHEC;
    }

    public void SetEDADMOMSUCHEC(String EDADMOMSUCHEC) {
        this.EDADMOMSUCHEC = EDADMOMSUCHEC;
    }

    public String GetCATSEXOID() {
        return CATSEXOID;
    }

    public void SetCATSEXOID(String CATSEXOID) {
        this.CATSEXOID = CATSEXOID;
    }

    public String GetCATSITUACIONCONYUGALID() {
        return CATSITUACIONCONYUGALID;
    }

    public void SetCATSITUACIONCONYUGALID(String CATSITUACIONCONYUGALID) {
        this.CATSITUACIONCONYUGALID = CATSITUACIONCONYUGALID;
    }

    public String GetVESTIMENTARASGOSVISIBLES() {
        return VESTIMENTARASGOSVISIBLES;
    }

    public void SetVESTIMENTARASGOSVISIBLES(String VESTIMENTARASGOSVISIBLES) {
        this.VESTIMENTARASGOSVISIBLES = VESTIMENTARASGOSVISIBLES;
    }

    public String GetCATNACIONALIDADID() {
        return CATNACIONALIDADID;
    }

    public void SetCATNACIONALIDADID(String CATNACIONALIDADID) {
        this.CATNACIONALIDADID = CATNACIONALIDADID;
    }

    public String GetCATSITUACIONMIGRATORIAID() {
        return CATSITUACIONMIGRATORIAID;
    }

    public void SetCATSITUACIONMIGRATORIAID(String CATSITUACIONMIGRATORIAID) {
        this.CATSITUACIONMIGRATORIAID = CATSITUACIONMIGRATORIAID;
    }

    public String GetCATPAISNACIMIENTOID() {
        return CATPAISNACIMIENTOID;
    }

    public void SetCATPAISNACIMIENTOID(String CATPAISNACIMIENTOID) {
        this.CATPAISNACIMIENTOID = CATPAISNACIMIENTOID;
    }

    public String GetCATENTIDADNACIMIENTOID() {
        return CATENTIDADNACIMIENTOID;
    }

    public void SetCATENTIDADNACIMIENTOID(String CATENTIDADNACIMIENTOID) {
        this.CATENTIDADNACIMIENTOID = CATENTIDADNACIMIENTOID;
    }

    public String GetCATMUNICIPIOID() {
        return CATMUNICIPIOID;
    }

    public void SetCATMUNICIPIOID(String CATMUNICIPIOID) {
        this.CATMUNICIPIOID = CATMUNICIPIOID;
    }

    public String GetCATPAISRESHAB() {
        return CATPAISRESHAB;
    }

    public void SetCATPAISRESHAB(String CATPAISRESHAB) {
        this.CATPAISRESHAB = CATPAISRESHAB;
    }

    public String GetDIRECCIONUBICACIONID() {
        return DIRECCIONUBICACIONID;
    }

    public void SetDIRECCIONUBICACIONID(String DIRECCIONUBICACIONID) {
        this.DIRECCIONUBICACIONID = DIRECCIONUBICACIONID;
    }

    public String GetNUMEROTELEFONICO() {
        return NUMEROTELEFONICO;
    }

    public void SetNUMEROTELEFONICO(String NUMEROTELEFONICO) {
        this.NUMEROTELEFONICO = NUMEROTELEFONICO;
    }

    public String GetHABLAESPANIOL() {
        return HABLAESPANIOL;
    }

    public void SetHABLAESPANIOL(String HABLAESPANIOL) {
        this.HABLAESPANIOL = HABLAESPANIOL;
    }

    public String GetHABLALENGUAEXTRANJERA() {
        return HABLALENGUAEXTRANJERA;
    }

    public void SetHABLALENGUAEXTRANJERA(String HABLALENGUAEXTRANJERA) {
        this.HABLALENGUAEXTRANJERA = HABLALENGUAEXTRANJERA;
    }

    public String GetCATTIPLEGEXT() {
        return CATTIPLEGEXT;
    }

    public void SetCATTIPLEGEXT(String CATTIPLEGEXT) {
        this.CATTIPLEGEXT = CATTIPLEGEXT;
    }

    public String GetHABLALENGUAINDIGENA() {
        return HABLALENGUAINDIGENA;
    }

    public void SetHABLALENGUAINDIGENA(String HABLALENGUAINDIGENA) {
        this.HABLALENGUAINDIGENA = HABLALENGUAINDIGENA;
    }

    public String GetCATTIPOLENGUAINDIGENAID() {
        return CATTIPOLENGUAINDIGENAID;
    }

    public void SetCATTIPOLENGUAINDIGENAID(String CATTIPOLENGUAINDIGENAID) {
        this.CATTIPOLENGUAINDIGENAID = CATTIPOLENGUAINDIGENAID;
    }

    public String GetUTITRAINT() {
        return UTITRAINT;
    }

    public void SetUTITRAINT(String UTITRAINT) {
        this.UTITRAINT = UTITRAINT;
    }

    public String GetPRESENTADISCAPACIDAD() {
        return PRESENTADISCAPACIDAD;
    }

    public void SetPRESENTADISCAPACIDAD(String PRESENTADISCAPACIDAD) {
        this.PRESENTADISCAPACIDAD = PRESENTADISCAPACIDAD;
    }

    public String GetCATTIPODISCAPACIDADID() {
        return CATTIPODISCAPACIDADID;
    }

    public void SetCATTIPODISCAPACIDADID(String CATTIPODISCAPACIDADID) {
        this.CATTIPODISCAPACIDADID = CATTIPODISCAPACIDADID;
    }

    public String GetMEDIOTECDISCAPACIDAD() {
        return MEDIOTECDISCAPACIDAD;
    }

    public void SetMEDIOTECDISCAPACIDAD(String MEDIOTECDISCAPACIDAD) {
        this.MEDIOTECDISCAPACIDAD = MEDIOTECDISCAPACIDAD;
    }

    public String GetPERPOPIND() {
        return PERPOPIND;
    }

    public void SetPERPOPIND(String PERPOPIND) {
        this.PERPOPIND = PERPOPIND;
    }

    public String GetCATTIPPOPIND() {
        return CATTIPPOPIND;
    }

    public void SetCATTIPPOPIND(String CATTIPPOPIND) {
        this.CATTIPPOPIND = CATTIPPOPIND;
    }

    public String GetPERPOBLGBTTTI() {
        return PERPOBLGBTTTI;
    }

    public void SetPERPOBLGBTTTI(String PERPOBLGBTTTI) {
        this.PERPOBLGBTTTI = PERPOBLGBTTTI;
    }

    public String GetCATTIPOLGBTTTIID() {
        return CATTIPOLGBTTTIID;
    }

    public void SetCATTIPOLGBTTTIID(String CATTIPOLGBTTTIID) {
        this.CATTIPOLGBTTTIID = CATTIPOLGBTTTIID;
    }

    public String GetPERPOBSITCALLE() {
        return PERPOBSITCALLE;
    }

    public void SetPERPOBSITCALLE(String PERPOBSITCALLE) {
        this.PERPOBSITCALLE = PERPOBSITCALLE;
    }

    public String GetSABELEERESCRIBIR() {
        return SABELEERESCRIBIR;
    }

    public void SetSABELEERESCRIBIR(String SABELEERESCRIBIR) {
        this.SABELEERESCRIBIR = SABELEERESCRIBIR;
    }

    public String GetCATNIVELESCOLARIDADID() {
        return CATNIVELESCOLARIDADID;
    }

    public void SetCATNIVELESCOLARIDADID(String CATNIVELESCOLARIDADID) {
        this.CATNIVELESCOLARIDADID = CATNIVELESCOLARIDADID;
    }

    public String GetCATOCUPACIONID() {
        return CATOCUPACIONID;
    }

    public void SetCATOCUPACIONID(String CATOCUPACIONID) {
        this.CATOCUPACIONID = CATOCUPACIONID;
    }

    public String GetRANINGMENNET() {
        return RANINGMENNET;
    }

    public void SetRANINGMENNET(String RANINGMENNET) {
        this.RANINGMENNET = RANINGMENNET;
    }

    public String GetHECANTVICMANSUFVIOL() {
        return HECANTVICMANSUFVIOL;
    }

    public void SetHECANTVICMANSUFVIOL(String HECANTVICMANSUFVIOL) {
        this.HECANTVICMANSUFVIOL = HECANTVICMANSUFVIOL;
    }

    public String GetCONTOASESORJURIDICO() {
        return CONTOASESORJURIDICO;
    }

    public void SetCONTOASESORJURIDICO(String CONTOASESORJURIDICO) {
        this.CONTOASESORJURIDICO = CONTOASESORJURIDICO;
    }

    public String GetCATTIPOASESORJURIDICOID() {
        return CATTIPOASESORJURIDICOID;
    }

    public void SetCATTIPOASESORJURIDICOID(String CATTIPOASESORJURIDICOID) {
        this.CATTIPOASESORJURIDICOID = CATTIPOASESORJURIDICOID;
    }

    public String GetRECIBIOATENCIONMEDICA() {
        return RECIBIOATENCIONMEDICA;
    }

    public void SetRECIBIOATENCIONMEDICA(String RECIBIOATENCIONMEDICA) {
        this.RECIBIOATENCIONMEDICA = RECIBIOATENCIONMEDICA;
    }

    public String GetRECATEPSICO() {
        return RECATEPSICO;
    }

    public void SetRECATEPSICO(String RECATEPSICO) {
        this.RECATEPSICO = RECATEPSICO;
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
            GetVICTIMAID(),
            GetVICTIMAID_FISCALIA(),
            GetCATFISCALIAID(),
            GetCARPETAID(),
            GetNOMBREVICTIMA(),
            GetCATTIPOVICTIMAID(),
            GetCURP(),
            GetFECHANACIMIENTO(),
            GetEDADMOMSUCHEC(),
            GetCATSEXOID(),
            GetCATSITUACIONCONYUGALID(),
            GetVESTIMENTARASGOSVISIBLES(),
            GetCATNACIONALIDADID(),
            GetCATSITUACIONMIGRATORIAID(),
            GetCATPAISNACIMIENTOID(),
            GetCATENTIDADNACIMIENTOID(),
            GetCATMUNICIPIOID(),
            GetCATPAISRESHAB(),
            GetDIRECCIONUBICACIONID(),
            GetNUMEROTELEFONICO(),
            GetHABLAESPANIOL(),
            GetHABLALENGUAEXTRANJERA(),
            GetCATTIPLEGEXT(),
            GetHABLALENGUAINDIGENA(),
            GetCATTIPOLENGUAINDIGENAID(),
            GetUTITRAINT(),
            GetPRESENTADISCAPACIDAD(),
            GetCATTIPODISCAPACIDADID(),
            GetMEDIOTECDISCAPACIDAD(),
            GetPERPOPIND(),
            GetCATTIPPOPIND(),
            GetPERPOBLGBTTTI(),
            GetCATTIPOLGBTTTIID(),
            GetPERPOBSITCALLE(),
            GetSABELEERESCRIBIR(),
            GetCATNIVELESCOLARIDADID(),
            GetCATOCUPACIONID(),
            GetRANINGMENNET(),
            GetHECANTVICMANSUFVIOL(),
            GetCONTOASESORJURIDICO(),
            GetCATTIPOASESORJURIDICOID(),
            GetRECIBIOATENCIONMEDICA(),
            GetRECATEPSICO(),
            GetBORRADO(),
            GetFECHAALTA(),
            GetUSUARIOALTA(),
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
