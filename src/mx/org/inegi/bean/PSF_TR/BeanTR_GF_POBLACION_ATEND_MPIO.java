/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.bean.PSF_TR;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANTONIO.CORIA
 */
public class BeanTR_GF_POBLACION_ATEND_MPIO extends Bean implements SQLData{
   
    private String SQLTypeName;
    private String ID_PROGRAMA_SOCIAL;
    private String ID_MUNICIPIO;
    private String NOMBRE_MUNICIPIO;
    private String TOTAL_POBLACION;
    private String COMENTARIOS;
    
    public BeanTR_GF_POBLACION_ATEND_MPIO(){
    }
    
    public String GetID_PROGRAMA_SOCIAL() {
        return ID_PROGRAMA_SOCIAL;
    }

    public void SetID_PROGRAMA_SOCIAL(String ID_PROGRAMA_SOCIAL) {
        this.ID_PROGRAMA_SOCIAL = ID_PROGRAMA_SOCIAL;
    }
    
    public String GetID_MUNICIPIO() {
        return ID_MUNICIPIO;
    }

    public void SetID_MUNICIPIO(String ID_MUNICIPIO) {
        this.ID_MUNICIPIO = ID_MUNICIPIO;
    }
    
    public String GetNOMBRE_MUNICIPIO() {
        return NOMBRE_MUNICIPIO;
    }

    public void SetNOMBRE_MUNICIPIO(String NOMBRE_MUNICIPIO) {
        this.NOMBRE_MUNICIPIO = NOMBRE_MUNICIPIO;
    }
    
    public String GetTOTAL_POBLACION() {
        return TOTAL_POBLACION;
    }

    public void SetTOTAL_POBLACION(String TOTAL_POBLACION) {
        this.TOTAL_POBLACION = TOTAL_POBLACION;
    }
    
    
    
    public String GetCOMENTARIOS() {
        return COMENTARIOS;
    }

    public void SetCOMENTARIOS(String COMENTARIOS) {
        this.COMENTARIOS = COMENTARIOS;
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
         GetID_PROGRAMA_SOCIAL(),
         GetID_MUNICIPIO(),
         GetNOMBRE_MUNICIPIO(),
         GetTOTAL_POBLACION(),
         GetCOMENTARIOS()
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
