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
public class BeanTR_SENAP_SOBRESEIMIENTO extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String SOBRESEIMIENTOID;
    private String SOBRESEIMIENTOID_FISCALIA;
    private String CARPETAID;
    private String CARPETAID_FISCALIA;
    private String IMPUTADOID;
    private String IMPUTADOID_FISCALIA;
    private String CATFISCALIAID;
    private String PROCESOID;
    private String PROCESOID_FISCALIA;
    private String CATETAPASOBRESEIMIENTOID;
    private String CATCAUSASSOBRESEIMIENTOID;
    private String FECHADICTOSOBRESEIMIENTO;
    private String CATTIPOSOBRESEIMIENTOID;
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

    public String GetSOBRESEIMIENTOID() {
        return SOBRESEIMIENTOID;
    }

    public void SetSOBRESEIMIENTOID(String SOBRESEIMIENTOID) {
        this.SOBRESEIMIENTOID = SOBRESEIMIENTOID;
    }

    public String GetSOBRESEIMIENTOID_FISCALIA() {
        return SOBRESEIMIENTOID_FISCALIA;
    }

    public void SetSOBRESEIMIENTOID_FISCALIA(String SOBRESEIMIENTOID_FISCALIA) {
        this.SOBRESEIMIENTOID_FISCALIA = SOBRESEIMIENTOID_FISCALIA;
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

    public String GetCATETAPASOBRESEIMIENTOID() {
        return CATETAPASOBRESEIMIENTOID;
    }

    public void SetCATETAPASOBRESEIMIENTOID(String CATETAPASOBRESEIMIENTOID) {
        this.CATETAPASOBRESEIMIENTOID = CATETAPASOBRESEIMIENTOID;
    }

    public String GetCATCAUSASSOBRESEIMIENTOID() {
        return CATCAUSASSOBRESEIMIENTOID;
    }

    public void SetCATCAUSASSOBRESEIMIENTOID(String CATCAUSASSOBRESEIMIENTOID) {
        this.CATCAUSASSOBRESEIMIENTOID = CATCAUSASSOBRESEIMIENTOID;
    }

    public String GetFECHADICTOSOBRESEIMIENTO() {
        return FECHADICTOSOBRESEIMIENTO;
    }

    public void SetFECHADICTOSOBRESEIMIENTO(String FECHADICTOSOBRESEIMIENTO) {
        this.FECHADICTOSOBRESEIMIENTO = FECHADICTOSOBRESEIMIENTO;
    }

    public String GetCATTIPOSOBRESEIMIENTOID() {
        return CATTIPOSOBRESEIMIENTOID;
    }

    public void SetCATTIPOSOBRESEIMIENTOID(String CATTIPOSOBRESEIMIENTOID) {
        this.CATTIPOSOBRESEIMIENTOID = CATTIPOSOBRESEIMIENTOID;
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
            GetSOBRESEIMIENTOID(),
            GetSOBRESEIMIENTOID_FISCALIA(),
            GetCARPETAID(),
            GetCARPETAID_FISCALIA(),
            GetIMPUTADOID(),
            GetIMPUTADOID_FISCALIA(),
            GetCATFISCALIAID(),
            GetPROCESOID(),
            GetPROCESOID_FISCALIA(),
            GetCATETAPASOBRESEIMIENTOID(),
            GetCATCAUSASSOBRESEIMIENTOID(),
            GetFECHADICTOSOBRESEIMIENTO(),
            GetCATTIPOSOBRESEIMIENTOID(),
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
