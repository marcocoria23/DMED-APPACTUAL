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
public class BeanTMP_SENAP_DELITORELACION extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String DELITORELACIONID;
    private String CATDELITOID;
    private String CATTIPOESPECIFICOID;
    private String CATDELITONORMATECNICAID;
    private String NOMBRETIPOSPECIFICO;
    private String BORRADO;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
    }

    public String GetDELITORELACIONID() {
        return DELITORELACIONID;
    }

    public void SetDELITORELACIONID(String DELITORELACIONID) {
        this.DELITORELACIONID = DELITORELACIONID;
    }

    public String GetCATDELITOID() {
        return CATDELITOID;
    }

    public void SetCATDELITOID(String CATDELITOID) {
        this.CATDELITOID = CATDELITOID;
    }

    public String GetCATTIPOESPECIFICOID() {
        return CATTIPOESPECIFICOID;
    }

    public void SetCATTIPOESPECIFICOID(String CATTIPOESPECIFICOID) {
        this.CATTIPOESPECIFICOID = CATTIPOESPECIFICOID;
    }

    public String GetCATDELITONORMATECNICAID() {
        return CATDELITONORMATECNICAID;
    }

    public void SetCATDELITONORMATECNICAID(String CATDELITONORMATECNICAID) {
        this.CATDELITONORMATECNICAID = CATDELITONORMATECNICAID;
    }

    public String GetNOMBRETIPOSPECIFICO() {
        return NOMBRETIPOSPECIFICO;
    }

    public void SetNOMBRETIPOSPECIFICO(String NOMBRETIPOSPECIFICO) {
        this.NOMBRETIPOSPECIFICO = NOMBRETIPOSPECIFICO;
    }

    public String GetBORRADO() {
        return BORRADO;
    }

    public void SetBORRADO(String BORRADO) {
        this.BORRADO = BORRADO;
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
            GetDELITORELACIONID(),
            GetCATDELITOID(),
            GetCATTIPOESPECIFICOID(),
            GetCATDELITONORMATECNICAID(),
            GetNOMBRETIPOSPECIFICO(),
            GetBORRADO(),
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
