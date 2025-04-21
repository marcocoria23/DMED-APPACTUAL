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
public class BeanTMP_SENAP_IMPUTADO extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String IMPUTADOID;
    private String IMPUTADOID_FISCALIA;
    private String CATFISCALIAID;
    private String CARPETAID;
    private String NOMBREIMPUTADO;
    private String ALIASAPODO;
    private String CATTIPOPERSONAMORALID;
    private String CURP;
    private String FECHANACIMIENTO;
    private String EDADMOMENTOSUCEDIERONHECHOS;
    private String CATSEXOID;
    private String CATSITUACIONCONYUGALID;
    private String MEDIAFILIACION;
    private String CATNACIONALIDADID;
    private String CATSITUACIONMIGRATORIAID;
    private String CATPAISNACIMIENTOID;
    private String CATENTIDADNACIMIENTOID;
    private String CATMUNICIPIOID;
    private String CATPAISRESIDENCIAHABITUALID;
    private String UBICACIONID;
    private String NUMEROTELEFONICO;
    private String HABLAESPANIOL;
    private String HABLALENGUAEXTRANJERA;
    private String CATTIPOLENGUAEXTRANJERAID;
    private String HABLALENGUAINDIGENA;
    private String CATTIPOLENGUAINDIGENAID;
    private String UTILIZOTRADUCTORINTERPRETE;
    private String PRESENTADISCAPACIDAD;
    private String CATTIPODISCAPACIDADID;
    private String MEDIOTECDISCAPACIDAD;
    private String PERTENECEPOBLACIONINDIGENA;
    private String CATTIPOPOBLACIONINDIGENAID;
    private String PERTENECEPOBLACIONLGBTTTI;
    private String CATTIPOLGBTTTIID;
    private String PERTENECEPOBLACIONSITUACIONCALLE;
    private String SABELEERESCRIBIR;
    private String CATNIVELESCOLARIDADID;
    private String CATOCUPACIONID;
    private String RANGOINGRESOMENSUALNETO;
    private String IMPUTADOPERTENECEGRUPODELICTIVO;
    private String GRUPODELICTIVO;
    private String CATCOMISIONDELITOID;
    private String ANTECEDENTESPENALES;
    private String CATESTADOPSICOFISICOID;
    private String CONTODEFENSOR;
    private String CATTIPODEFENSORID;
    private String CATFORMAPROCESOID;
    private String FECHADETENCION;
    private String HORADETENCION;
    private String CATTIPODETENCIONID;
    private String CATAUTORIDADCARGODETENCIONID;
    private String IMPUTADOFUELIBERADO;
    private String FECHAAUDIENCIACONTROLDETENCION;
    private String CALIFICOLEGALDETENCION;
    private String BORRADO;
    private String FECHAALTA;
    private String USUARIOALTA;
    private String CARPETAID_FISCALIA;
    private String DIRECCIONUBICACIONID;
    private String FECHACORTE;
    private String CATTIPOPERSONAIMPUTADAID;
    private String FECHAACTUALIZACION;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
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

    public String GetCARPETAID() {
        return CARPETAID;
    }

    public void SetCARPETAID(String CARPETAID) {
        this.CARPETAID = CARPETAID;
    }

    public String GetNOMBREIMPUTADO() {
        return NOMBREIMPUTADO;
    }

    public void SetNOMBREIMPUTADO(String NOMBREIMPUTADO) {
        this.NOMBREIMPUTADO = NOMBREIMPUTADO;
    }

    public String GetALIASAPODO() {
        return ALIASAPODO;
    }

    public void SetALIASAPODO(String ALIASAPODO) {
        this.ALIASAPODO = ALIASAPODO;
    }

    public String GetCATTIPOPERSONAMORALID() {
        return CATTIPOPERSONAMORALID;
    }

    public void SetCATTIPOPERSONAMORALID(String CATTIPOPERSONAMORALID) {
        this.CATTIPOPERSONAMORALID = CATTIPOPERSONAMORALID;
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

    public String GetEDADMOMENTOSUCEDIERONHECHOS() {
        return EDADMOMENTOSUCEDIERONHECHOS;
    }

    public void SetEDADMOMENTOSUCEDIERONHECHOS(String EDADMOMENTOSUCEDIERONHECHOS) {
        this.EDADMOMENTOSUCEDIERONHECHOS = EDADMOMENTOSUCEDIERONHECHOS;
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

    public String GetMEDIAFILIACION() {
        return MEDIAFILIACION;
    }

    public void SetMEDIAFILIACION(String MEDIAFILIACION) {
        this.MEDIAFILIACION = MEDIAFILIACION;
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

    public String GetCATPAISRESIDENCIAHABITUALID() {
        return CATPAISRESIDENCIAHABITUALID;
    }

    public void SetCATPAISRESIDENCIAHABITUALID(String CATPAISRESIDENCIAHABITUALID) {
        this.CATPAISRESIDENCIAHABITUALID = CATPAISRESIDENCIAHABITUALID;
    }

    public String GetUBICACIONID() {
        return UBICACIONID;
    }

    public void SetUBICACIONID(String UBICACIONID) {
        this.UBICACIONID = UBICACIONID;
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

    public String GetCATTIPOLENGUAEXTRANJERAID() {
        return CATTIPOLENGUAEXTRANJERAID;
    }

    public void SetCATTIPOLENGUAEXTRANJERAID(String CATTIPOLENGUAEXTRANJERAID) {
        this.CATTIPOLENGUAEXTRANJERAID = CATTIPOLENGUAEXTRANJERAID;
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

    public String GetUTILIZOTRADUCTORINTERPRETE() {
        return UTILIZOTRADUCTORINTERPRETE;
    }

    public void SetUTILIZOTRADUCTORINTERPRETE(String UTILIZOTRADUCTORINTERPRETE) {
        this.UTILIZOTRADUCTORINTERPRETE = UTILIZOTRADUCTORINTERPRETE;
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

    public String GetPERTENECEPOBLACIONINDIGENA() {
        return PERTENECEPOBLACIONINDIGENA;
    }

    public void SetPERTENECEPOBLACIONINDIGENA(String PERTENECEPOBLACIONINDIGENA) {
        this.PERTENECEPOBLACIONINDIGENA = PERTENECEPOBLACIONINDIGENA;
    }

    public String GetCATTIPOPOBLACIONINDIGENAID() {
        return CATTIPOPOBLACIONINDIGENAID;
    }

    public void SetCATTIPOPOBLACIONINDIGENAID(String CATTIPOPOBLACIONINDIGENAID) {
        this.CATTIPOPOBLACIONINDIGENAID = CATTIPOPOBLACIONINDIGENAID;
    }

    public String GetPERTENECEPOBLACIONLGBTTTI() {
        return PERTENECEPOBLACIONLGBTTTI;
    }

    public void SetPERTENECEPOBLACIONLGBTTTI(String PERTENECEPOBLACIONLGBTTTI) {
        this.PERTENECEPOBLACIONLGBTTTI = PERTENECEPOBLACIONLGBTTTI;
    }

    public String GetCATTIPOLGBTTTIID() {
        return CATTIPOLGBTTTIID;
    }

    public void SetCATTIPOLGBTTTIID(String CATTIPOLGBTTTIID) {
        this.CATTIPOLGBTTTIID = CATTIPOLGBTTTIID;
    }

    public String GetPERTENECEPOBLACIONSITUACIONCALLE() {
        return PERTENECEPOBLACIONSITUACIONCALLE;
    }

    public void SetPERTENECEPOBLACIONSITUACIONCALLE(String PERTENECEPOBLACIONSITUACIONCALLE) {
        this.PERTENECEPOBLACIONSITUACIONCALLE = PERTENECEPOBLACIONSITUACIONCALLE;
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

    public String GetRANGOINGRESOMENSUALNETO() {
        return RANGOINGRESOMENSUALNETO;
    }

    public void SetRANGOINGRESOMENSUALNETO(String RANGOINGRESOMENSUALNETO) {
        this.RANGOINGRESOMENSUALNETO = RANGOINGRESOMENSUALNETO;
    }

    public String GetIMPUTADOPERTENECEGRUPODELICTIVO() {
        return IMPUTADOPERTENECEGRUPODELICTIVO;
    }

    public void SetIMPUTADOPERTENECEGRUPODELICTIVO(String IMPUTADOPERTENECEGRUPODELICTIVO) {
        this.IMPUTADOPERTENECEGRUPODELICTIVO = IMPUTADOPERTENECEGRUPODELICTIVO;
    }

    public String GetGRUPODELICTIVO() {
        return GRUPODELICTIVO;
    }

    public void SetGRUPODELICTIVO(String GRUPODELICTIVO) {
        this.GRUPODELICTIVO = GRUPODELICTIVO;
    }

    public String GetCATCOMISIONDELITOID() {
        return CATCOMISIONDELITOID;
    }

    public void SetCATCOMISIONDELITOID(String CATCOMISIONDELITOID) {
        this.CATCOMISIONDELITOID = CATCOMISIONDELITOID;
    }

    public String GetANTECEDENTESPENALES() {
        return ANTECEDENTESPENALES;
    }

    public void SetANTECEDENTESPENALES(String ANTECEDENTESPENALES) {
        this.ANTECEDENTESPENALES = ANTECEDENTESPENALES;
    }

    public String GetCATESTADOPSICOFISICOID() {
        return CATESTADOPSICOFISICOID;
    }

    public void SetCATESTADOPSICOFISICOID(String CATESTADOPSICOFISICOID) {
        this.CATESTADOPSICOFISICOID = CATESTADOPSICOFISICOID;
    }

    public String GetCONTODEFENSOR() {
        return CONTODEFENSOR;
    }

    public void SetCONTODEFENSOR(String CONTODEFENSOR) {
        this.CONTODEFENSOR = CONTODEFENSOR;
    }

    public String GetCATTIPODEFENSORID() {
        return CATTIPODEFENSORID;
    }

    public void SetCATTIPODEFENSORID(String CATTIPODEFENSORID) {
        this.CATTIPODEFENSORID = CATTIPODEFENSORID;
    }

    public String GetCATFORMAPROCESOID() {
        return CATFORMAPROCESOID;
    }

    public void SetCATFORMAPROCESOID(String CATFORMAPROCESOID) {
        this.CATFORMAPROCESOID = CATFORMAPROCESOID;
    }

    public String GetFECHADETENCION() {
        return FECHADETENCION;
    }

    public void SetFECHADETENCION(String FECHADETENCION) {
        this.FECHADETENCION = FECHADETENCION;
    }

    public String GetHORADETENCION() {
        return HORADETENCION;
    }

    public void SetHORADETENCION(String HORADETENCION) {
        this.HORADETENCION = HORADETENCION;
    }

    public String GetCATTIPODETENCIONID() {
        return CATTIPODETENCIONID;
    }

    public void SetCATTIPODETENCIONID(String CATTIPODETENCIONID) {
        this.CATTIPODETENCIONID = CATTIPODETENCIONID;
    }

    public String GetCATAUTORIDADCARGODETENCIONID() {
        return CATAUTORIDADCARGODETENCIONID;
    }

    public void SetCATAUTORIDADCARGODETENCIONID(String CATAUTORIDADCARGODETENCIONID) {
        this.CATAUTORIDADCARGODETENCIONID = CATAUTORIDADCARGODETENCIONID;
    }

    public String GetIMPUTADOFUELIBERADO() {
        return IMPUTADOFUELIBERADO;
    }

    public void SetIMPUTADOFUELIBERADO(String IMPUTADOFUELIBERADO) {
        this.IMPUTADOFUELIBERADO = IMPUTADOFUELIBERADO;
    }

    public String GetFECHAAUDIENCIACONTROLDETENCION() {
        return FECHAAUDIENCIACONTROLDETENCION;
    }

    public void SetFECHAAUDIENCIACONTROLDETENCION(String FECHAAUDIENCIACONTROLDETENCION) {
        this.FECHAAUDIENCIACONTROLDETENCION = FECHAAUDIENCIACONTROLDETENCION;
    }

    public String GetCALIFICOLEGALDETENCION() {
        return CALIFICOLEGALDETENCION;
    }

    public void SetCALIFICOLEGALDETENCION(String CALIFICOLEGALDETENCION) {
        this.CALIFICOLEGALDETENCION = CALIFICOLEGALDETENCION;
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

    public String GetCATTIPOPERSONAIMPUTADAID() {
        return CATTIPOPERSONAIMPUTADAID;
    }

    public void SetCATTIPOPERSONAIMPUTADAID(String CATTIPOPERSONAIMPUTADAID) {
        this.CATTIPOPERSONAIMPUTADAID = CATTIPOPERSONAIMPUTADAID;
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
            GetIMPUTADOID(),
            GetIMPUTADOID_FISCALIA(),
            GetCATFISCALIAID(),
            GetCARPETAID(),
            GetNOMBREIMPUTADO(),
            GetALIASAPODO(),
            GetCATTIPOPERSONAMORALID(),
            GetCURP(),
            GetFECHANACIMIENTO(),
            GetEDADMOMENTOSUCEDIERONHECHOS(),
            GetCATSEXOID(),
            GetCATSITUACIONCONYUGALID(),
            GetMEDIAFILIACION(),
            GetCATNACIONALIDADID(),
            GetCATSITUACIONMIGRATORIAID(),
            GetCATPAISNACIMIENTOID(),
            GetCATENTIDADNACIMIENTOID(),
            GetCATMUNICIPIOID(),
            GetCATPAISRESIDENCIAHABITUALID(),
            GetUBICACIONID(),
            GetNUMEROTELEFONICO(),
            GetHABLAESPANIOL(),
            GetHABLALENGUAEXTRANJERA(),
            GetCATTIPOLENGUAEXTRANJERAID(),
            GetHABLALENGUAINDIGENA(),
            GetCATTIPOLENGUAINDIGENAID(),
            GetUTILIZOTRADUCTORINTERPRETE(),
            GetPRESENTADISCAPACIDAD(),
            GetCATTIPODISCAPACIDADID(),
            GetMEDIOTECDISCAPACIDAD(),
            GetPERTENECEPOBLACIONINDIGENA(),
            GetCATTIPOPOBLACIONINDIGENAID(),
            GetPERTENECEPOBLACIONLGBTTTI(),
            GetCATTIPOLGBTTTIID(),
            GetPERTENECEPOBLACIONSITUACIONCALLE(),
            GetSABELEERESCRIBIR(),
            GetCATNIVELESCOLARIDADID(),
            GetCATOCUPACIONID(),
            GetRANGOINGRESOMENSUALNETO(),
            GetIMPUTADOPERTENECEGRUPODELICTIVO(),
            GetGRUPODELICTIVO(),
            GetCATCOMISIONDELITOID(),
            GetANTECEDENTESPENALES(),
            GetCATESTADOPSICOFISICOID(),
            GetCONTODEFENSOR(),
            GetCATTIPODEFENSORID(),
            GetCATFORMAPROCESOID(),
            GetFECHADETENCION(),
            GetHORADETENCION(),
            GetCATTIPODETENCIONID(),
            GetCATAUTORIDADCARGODETENCIONID(),
            GetIMPUTADOFUELIBERADO(),
            GetFECHAAUDIENCIACONTROLDETENCION(),
            GetCALIFICOLEGALDETENCION(),
            GetBORRADO(),
            GetFECHAALTA(),
            GetUSUARIOALTA(),
            GetCARPETAID_FISCALIA(),
            GetDIRECCIONUBICACIONID(),
            GetFECHACORTE(),
            GetCATTIPOPERSONAIMPUTADAID(),
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
