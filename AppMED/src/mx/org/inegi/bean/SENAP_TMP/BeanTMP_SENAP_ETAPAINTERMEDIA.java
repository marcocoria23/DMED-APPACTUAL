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
public class BeanTMP_SENAP_ETAPAINTERMEDIA extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String ETAPAINTERMEDIAID;
    private String ETAPAINTERMEDIAID_FISCALIA;
    private String CATFISCALIAID;
    private String PROCESOID;
    private String PROCESOID_FISCALIA;
    private String FECHAESCRITOACUSACION;
    private String HUBOCELAUDINTER;
    private String FECHACELAUDINTER;
    private String PRESMEDPRUEBA;
    private String MEDIOSPRUEBA;
    private String CONTACUPROB;
    private String DICTAUTAPERJUICIO;
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

    public String GetETAPAINTERMEDIAID() {
        return ETAPAINTERMEDIAID;
    }

    public void SetETAPAINTERMEDIAID(String ETAPAINTERMEDIAID) {
        this.ETAPAINTERMEDIAID = ETAPAINTERMEDIAID;
    }

    public String GetETAPAINTERMEDIAID_FISCALIA() {
        return ETAPAINTERMEDIAID_FISCALIA;
    }

    public void SetETAPAINTERMEDIAID_FISCALIA(String ETAPAINTERMEDIAID_FISCALIA) {
        this.ETAPAINTERMEDIAID_FISCALIA = ETAPAINTERMEDIAID_FISCALIA;
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

    public String GetFECHAESCRITOACUSACION() {
        return FECHAESCRITOACUSACION;
    }

    public void SetFECHAESCRITOACUSACION(String FECHAESCRITOACUSACION) {
        this.FECHAESCRITOACUSACION = FECHAESCRITOACUSACION;
    }

    public String GetHUBOCELAUDINTER() {
        return HUBOCELAUDINTER;
    }

    public void SetHUBOCELAUDINTER(String HUBOCELAUDINTER) {
        this.HUBOCELAUDINTER = HUBOCELAUDINTER;
    }

    public String GetFECHACELAUDINTER() {
        return FECHACELAUDINTER;
    }

    public void SetFECHACELAUDINTER(String FECHACELAUDINTER) {
        this.FECHACELAUDINTER = FECHACELAUDINTER;
    }

    public String GetPRESMEDPRUEBA() {
        return PRESMEDPRUEBA;
    }

    public void SetPRESMEDPRUEBA(String PRESMEDPRUEBA) {
        this.PRESMEDPRUEBA = PRESMEDPRUEBA;
    }

    public String GetMEDIOSPRUEBA() {
        return MEDIOSPRUEBA;
    }

    public void SetMEDIOSPRUEBA(String MEDIOSPRUEBA) {
        this.MEDIOSPRUEBA = MEDIOSPRUEBA;
    }

    public String GetCONTACUPROB() {
        return CONTACUPROB;
    }

    public void SetCONTACUPROB(String CONTACUPROB) {
        this.CONTACUPROB = CONTACUPROB;
    }

    public String GetDICTAUTAPERJUICIO() {
        return DICTAUTAPERJUICIO;
    }

    public void SetDICTAUTAPERJUICIO(String DICTAUTAPERJUICIO) {
        this.DICTAUTAPERJUICIO = DICTAUTAPERJUICIO;
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
            GetETAPAINTERMEDIAID(),
            GetETAPAINTERMEDIAID_FISCALIA(),
            GetCATFISCALIAID(),
            GetPROCESOID(),
            GetPROCESOID_FISCALIA(),
            GetFECHAESCRITOACUSACION(),
            GetHUBOCELAUDINTER(),
            GetFECHACELAUDINTER(),
            GetPRESMEDPRUEBA(),
            GetMEDIOSPRUEBA(),
            GetCONTACUPROB(),
            GetDICTAUTAPERJUICIO(),
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
