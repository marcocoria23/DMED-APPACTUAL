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
public class BeanTR_SENAP_ATENCIONES extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String ATENCIONID;
    private String CATTIPOATENCIONID;
    private String NUMEROATENCION;
    private String FECHAINICIOATENCION;
    private String FECHCONCLUATE;
    private String CATSENTCONCLUATEID;
    private String NOTICIACRIMINALID;
    private String NOTICIACRIMINALID_FISCALIA;
    private String BORRADO;
    private String FECHAALTA;
    private String USUARIOALTA;
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

    public String GetATENCIONID() {
        return ATENCIONID;
    }

    public void SetATENCIONID(String ATENCIONID) {
        this.ATENCIONID = ATENCIONID;
    }

    public String GetCATTIPOATENCIONID() {
        return CATTIPOATENCIONID;
    }

    public void SetCATTIPOATENCIONID(String CATTIPOATENCIONID) {
        this.CATTIPOATENCIONID = CATTIPOATENCIONID;
    }

    public String GetNUMEROATENCION() {
        return NUMEROATENCION;
    }

    public void SetNUMEROATENCION(String NUMEROATENCION) {
        this.NUMEROATENCION = NUMEROATENCION;
    }

    public String GetFECHAINICIOATENCION() {
        return FECHAINICIOATENCION;
    }

    public void SetFECHAINICIOATENCION(String FECHAINICIOATENCION) {
        this.FECHAINICIOATENCION = FECHAINICIOATENCION;
    }

    public String GetFECHCONCLUATE() {
        return FECHCONCLUATE;
    }

    public void SetFECHCONCLUATE(String FECHCONCLUATE) {
        this.FECHCONCLUATE = FECHCONCLUATE;
    }

    public String GetCATSENTCONCLUATEID() {
        return CATSENTCONCLUATEID;
    }

    public void SetCATSENTCONCLUATEID(String CATSENTCONCLUATEID) {
        this.CATSENTCONCLUATEID = CATSENTCONCLUATEID;
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
            GetATENCIONID(),
            GetCATTIPOATENCIONID(),
            GetNUMEROATENCION(),
            GetFECHAINICIOATENCION(),
            GetFECHCONCLUATE(),
            GetCATSENTCONCLUATEID(),
            GetNOTICIACRIMINALID(),
            GetNOTICIACRIMINALID_FISCALIA(),
            GetBORRADO(),
            GetFECHAALTA(),
            GetUSUARIOALTA(),
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
