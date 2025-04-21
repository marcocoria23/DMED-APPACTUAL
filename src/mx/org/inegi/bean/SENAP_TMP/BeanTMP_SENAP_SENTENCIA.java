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
public class BeanTMP_SENAP_SENTENCIA extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String SENTENCIAID;
    private String SENTENCIAID_FISCALIA;
    private String CATFISCALIAID;
    private String PROCESOID;
    private String PROCESOID_FISCALIA;
    private String FECHACELEBAUDIJUICIO;
    private String CATPRUEBADESAHOGAID;
    private String SENTENCIADERPROCABREV;
    private String FECHADICTPROCABREV;
    private String FECHADICTOSENTENCIA;
    private String CATTIPOSENTENCIAID;
    private String TIEMPOPRISION;
    private String MONTOREPARACIONDANIOIMPUESTA;
    private String SENTENCIAENCUENTRAFIRME;
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

    public String GetSENTENCIAID() {
        return SENTENCIAID;
    }

    public void SetSENTENCIAID(String SENTENCIAID) {
        this.SENTENCIAID = SENTENCIAID;
    }

    public String GetSENTENCIAID_FISCALIA() {
        return SENTENCIAID_FISCALIA;
    }

    public void SetSENTENCIAID_FISCALIA(String SENTENCIAID_FISCALIA) {
        this.SENTENCIAID_FISCALIA = SENTENCIAID_FISCALIA;
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

    public String GetFECHACELEBAUDIJUICIO() {
        return FECHACELEBAUDIJUICIO;
    }

    public void SetFECHACELEBAUDIJUICIO(String FECHACELEBAUDIJUICIO) {
        this.FECHACELEBAUDIJUICIO = FECHACELEBAUDIJUICIO;
    }

    public String GetCATPRUEBADESAHOGAID() {
        return CATPRUEBADESAHOGAID;
    }

    public void SetCATPRUEBADESAHOGAID(String CATPRUEBADESAHOGAID) {
        this.CATPRUEBADESAHOGAID = CATPRUEBADESAHOGAID;
    }

    public String GetSENTENCIADERPROCABREV() {
        return SENTENCIADERPROCABREV;
    }

    public void SetSENTENCIADERPROCABREV(String SENTENCIADERPROCABREV) {
        this.SENTENCIADERPROCABREV = SENTENCIADERPROCABREV;
    }

    public String GetFECHADICTPROCABREV() {
        return FECHADICTPROCABREV;
    }

    public void SetFECHADICTPROCABREV(String FECHADICTPROCABREV) {
        this.FECHADICTPROCABREV = FECHADICTPROCABREV;
    }

    public String GetFECHADICTOSENTENCIA() {
        return FECHADICTOSENTENCIA;
    }

    public void SetFECHADICTOSENTENCIA(String FECHADICTOSENTENCIA) {
        this.FECHADICTOSENTENCIA = FECHADICTOSENTENCIA;
    }

    public String GetCATTIPOSENTENCIAID() {
        return CATTIPOSENTENCIAID;
    }

    public void SetCATTIPOSENTENCIAID(String CATTIPOSENTENCIAID) {
        this.CATTIPOSENTENCIAID = CATTIPOSENTENCIAID;
    }

    public String GetTIEMPOPRISION() {
        return TIEMPOPRISION;
    }

    public void SetTIEMPOPRISION(String TIEMPOPRISION) {
        this.TIEMPOPRISION = TIEMPOPRISION;
    }

    public String GetMONTOREPARACIONDANIOIMPUESTA() {
        return MONTOREPARACIONDANIOIMPUESTA;
    }

    public void SetMONTOREPARACIONDANIOIMPUESTA(String MONTOREPARACIONDANIOIMPUESTA) {
        this.MONTOREPARACIONDANIOIMPUESTA = MONTOREPARACIONDANIOIMPUESTA;
    }

    public String GetSENTENCIAENCUENTRAFIRME() {
        return SENTENCIAENCUENTRAFIRME;
    }

    public void SetSENTENCIAENCUENTRAFIRME(String SENTENCIAENCUENTRAFIRME) {
        this.SENTENCIAENCUENTRAFIRME = SENTENCIAENCUENTRAFIRME;
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
            GetSENTENCIAID(),
            GetSENTENCIAID_FISCALIA(),
            GetCATFISCALIAID(),
            GetPROCESOID(),
            GetPROCESOID_FISCALIA(),
            GetFECHACELEBAUDIJUICIO(),
            GetCATPRUEBADESAHOGAID(),
            GetSENTENCIADERPROCABREV(),
            GetFECHADICTPROCABREV(),
            GetFECHADICTOSENTENCIA(),
            GetCATTIPOSENTENCIAID(),
            GetTIEMPOPRISION(),
            GetMONTOREPARACIONDANIOIMPUESTA(),
            GetSENTENCIAENCUENTRAFIRME(),
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
