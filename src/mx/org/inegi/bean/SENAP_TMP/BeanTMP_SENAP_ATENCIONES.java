/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.bean.SENAP_TMP;

/**
 *
 * @author ANTONIO.CORIA
 */
import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANTONIO.CORIA
 */
public class BeanTMP_SENAP_ATENCIONES extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String ATENCIONID;
    private String CATTIPOATENCIONID;
    private String NUMEROATENCION;
    private String FECHAINICIOATENCION;
    private String FECHACONCLUSIONATENCION;
    private String CATSENTIDOCONCLUSIONATENCIONID;
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

    public String GetFECHACONCLUSIONATENCION() {
        return FECHACONCLUSIONATENCION;
    }

    public void SetFECHACONCLUSIONATENCION(String FECHACONCLUSIONATENCION) {
        this.FECHACONCLUSIONATENCION = FECHACONCLUSIONATENCION;
    }

    public String GetCATSENTIDOCONCLUSIONATENCIONID() {
        return CATSENTIDOCONCLUSIONATENCIONID;
    }

    public void SetCATSENTIDOCONCLUSIONATENCIONID(String CATSENTIDOCONCLUSIONATENCIONID) {
        this.CATSENTIDOCONCLUSIONATENCIONID = CATSENTIDOCONCLUSIONATENCIONID;
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
            GetFECHACONCLUSIONATENCION(),
            GetCATSENTIDOCONCLUSIONATENCIONID(),
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
