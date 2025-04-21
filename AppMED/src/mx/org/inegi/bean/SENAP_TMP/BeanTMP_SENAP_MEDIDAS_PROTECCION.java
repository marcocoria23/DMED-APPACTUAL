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
public class BeanTMP_SENAP_MEDIDAS_PROTECCION extends Bean implements SQLData {

    private String SQLTypeName;
    private String ENTIDADID;
    private String MEDIDASPROTECCIONID;
    private String VICTIMAID;
    private String CATMEDIDAPROTECCION;
    private String PERIODO;

    public String GetENTIDADID() {
        return ENTIDADID;
    }

    public void SetENTIDADID(String ENTIDADID) {
        this.ENTIDADID = ENTIDADID;
    }

    public String GetMEDIDASPROTECCIONID() {
        return MEDIDASPROTECCIONID;
    }

    public void SetMEDIDASPROTECCIONID(String MEDIDASPROTECCIONID) {
        this.MEDIDASPROTECCIONID = MEDIDASPROTECCIONID;
    }

    public String GetVICTIMAID() {
        return VICTIMAID;
    }

    public void SetVICTIMAID(String VICTIMAID) {
        this.VICTIMAID = VICTIMAID;
    }

    public String GetCATMEDIDAPROTECCION() {
        return CATMEDIDAPROTECCION;
    }

    public void SetCATMEDIDAPROTECCION(String CATMEDIDAPROTECCION) {
        this.CATMEDIDAPROTECCION = CATMEDIDAPROTECCION;
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
            GetMEDIDASPROTECCIONID(),
            GetVICTIMAID(),
            GetCATMEDIDAPROTECCION(),
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
