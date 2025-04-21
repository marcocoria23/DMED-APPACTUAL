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
public class BeanTR_SENAP_DIRECCIONUBICACION extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String UBICACIONID;
    private String CATTIPOVIALIDADID;
    private String CALLEVIALIDAD;
    private String CATCOLONIAID;
    private String NUMEROEXTERIOR;
    private String NUMEROINTERIOR;
    private String CODIGOPOSTAL;
    private String LOCALIDAD;
    private String CATDEMARCACIONID;
    private String CATENTFEDID;
    private String LATITUD;
    private String LONGITUD;
    private String CATSUBPROREFID;
    private String BORRADO;
    private String FECHAALTA;
    private String USUARIOALTA;
    private String COLONIA;
    private String UBICACION;
    private String CATFISCALIAID;
    private String FECHACORTE;
    private String FECHAACTUALIZACION;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
    }

    public String GetUBICACIONID() {
        return UBICACIONID;
    }

    public void SetUBICACIONID(String UBICACIONID) {
        this.UBICACIONID = UBICACIONID;
    }

    public String GetCATTIPOVIALIDADID() {
        return CATTIPOVIALIDADID;
    }

    public void SetCATTIPOVIALIDADID(String CATTIPOVIALIDADID) {
        this.CATTIPOVIALIDADID = CATTIPOVIALIDADID;
    }

    public String GetCALLEVIALIDAD() {
        return CALLEVIALIDAD;
    }

    public void SetCALLEVIALIDAD(String CALLEVIALIDAD) {
        this.CALLEVIALIDAD = CALLEVIALIDAD;
    }

    public String GetCATCOLONIAID() {
        return CATCOLONIAID;
    }

    public void SetCATCOLONIAID(String CATCOLONIAID) {
        this.CATCOLONIAID = CATCOLONIAID;
    }

    public String GetNUMEROEXTERIOR() {
        return NUMEROEXTERIOR;
    }

    public void SetNUMEROEXTERIOR(String NUMEROEXTERIOR) {
        this.NUMEROEXTERIOR = NUMEROEXTERIOR;
    }

    public String GetNUMEROINTERIOR() {
        return NUMEROINTERIOR;
    }

    public void SetNUMEROINTERIOR(String NUMEROINTERIOR) {
        this.NUMEROINTERIOR = NUMEROINTERIOR;
    }

    public String GetCODIGOPOSTAL() {
        return CODIGOPOSTAL;
    }

    public void SetCODIGOPOSTAL(String CODIGOPOSTAL) {
        this.CODIGOPOSTAL = CODIGOPOSTAL;
    }

    public String GetLOCALIDAD() {
        return LOCALIDAD;
    }

    public void SetLOCALIDAD(String LOCALIDAD) {
        this.LOCALIDAD = LOCALIDAD;
    }

    public String GetCATDEMARCACIONID() {
        return CATDEMARCACIONID;
    }

    public void SetCATDEMARCACIONID(String CATDEMARCACIONID) {
        this.CATDEMARCACIONID = CATDEMARCACIONID;
    }

    public String GetCATENTFEDID() {
        return CATENTFEDID;
    }

    public void SetCATENTFEDID(String CATENTFEDID) {
        this.CATENTFEDID = CATENTFEDID;
    }

    public String GetLATITUD() {
        return LATITUD;
    }

    public void SetLATITUD(String LATITUD) {
        this.LATITUD = LATITUD;
    }

    public String GetLONGITUD() {
        return LONGITUD;
    }

    public void SetLONGITUD(String LONGITUD) {
        this.LONGITUD = LONGITUD;
    }

    public String GetCATSUBPROREFID() {
        return CATSUBPROREFID;
    }

    public void SetCATSUBPROREFID(String CATSUBPROREFID) {
        this.CATSUBPROREFID = CATSUBPROREFID;
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

    public String GetCOLONIA() {
        return COLONIA;
    }

    public void SetCOLONIA(String COLONIA) {
        this.COLONIA = COLONIA;
    }

    public String GetUBICACION() {
        return UBICACION;
    }

    public void SetUBICACION(String UBICACION) {
        this.UBICACION = UBICACION;
    }

    public String GetCATFISCALIAID() {
        return CATFISCALIAID;
    }

    public void SetCATFISCALIAID(String CATFISCALIAID) {
        this.CATFISCALIAID = CATFISCALIAID;
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
            GetUBICACIONID(),
            GetCATTIPOVIALIDADID(),
            GetCALLEVIALIDAD(),
            GetCATCOLONIAID(),
            GetNUMEROEXTERIOR(),
            GetNUMEROINTERIOR(),
            GetCODIGOPOSTAL(),
            GetLOCALIDAD(),
            GetCATDEMARCACIONID(),
            GetCATENTFEDID(),
            GetLATITUD(),
            GetLONGITUD(),
            GetCATSUBPROREFID(),
            GetBORRADO(),
            GetFECHAALTA(),
            GetUSUARIOALTA(),
            GetCOLONIA(),
            GetUBICACION(),
            GetCATFISCALIAID(),
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
