/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.bean.JA_TR;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class BeanTR_JA_CUMPLIM_EJECUTORIAS extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String CLAVE_ORGANO;
    private String PERIODO;
    private String TOTAL_ASUNTOS_CUMPL;
    private String ASUNTOS_CUMPL_AMPARO;
    private String ASUNTOS_CUMPL_RECURSO;
    private String COMENTARIOS;

    public String GetNOMBRE_ORGANO_JURIS() {
        return NOMBRE_ORGANO_JURIS;
    }

    public void SetNOMBRE_ORGANO_JURIS(String NOMBRE_ORGANO_JURIS) {
        this.NOMBRE_ORGANO_JURIS = NOMBRE_ORGANO_JURIS;
    }

    public String GetCLAVE_ORGANO() {
        return CLAVE_ORGANO;
    }

    public void SetCLAVE_ORGANO(String CLAVE_ORGANO) {
        this.CLAVE_ORGANO = CLAVE_ORGANO;
    }

    public String GetPERIODO() {
        return PERIODO;
    }

    public void SetPERIODO(String PERIODO) {
        this.PERIODO = PERIODO;
    }

    public String GetTOTAL_ASUNTOS_CUMPL() {
        return TOTAL_ASUNTOS_CUMPL;
    }

    public void SetTOTAL_ASUNTOS_CUMPL(String TOTAL_ASUNTOS_CUMPL) {
        this.TOTAL_ASUNTOS_CUMPL = TOTAL_ASUNTOS_CUMPL;
    }

    public String GetASUNTOS_CUMPL_AMPARO() {
        return ASUNTOS_CUMPL_AMPARO;
    }

    public void SetASUNTOS_CUMPL_AMPARO(String ASUNTOS_CUMPL_AMPARO) {
        this.ASUNTOS_CUMPL_AMPARO = ASUNTOS_CUMPL_AMPARO;
    }

    public String GetASUNTOS_CUMPL_RECURSO() {
        return ASUNTOS_CUMPL_RECURSO;
    }

    public void SetASUNTOS_CUMPL_RECURSO(String ASUNTOS_CUMPL_RECURSO) {
        this.ASUNTOS_CUMPL_RECURSO = ASUNTOS_CUMPL_RECURSO;
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
            GetNOMBRE_ORGANO_JURIS(),
            GetCLAVE_ORGANO(),
            GetPERIODO(),
            GetTOTAL_ASUNTOS_CUMPL(),
            GetASUNTOS_CUMPL_AMPARO(),
            GetASUNTOS_CUMPL_RECURSO(),
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
