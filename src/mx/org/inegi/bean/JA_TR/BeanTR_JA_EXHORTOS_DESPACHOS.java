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
public class BeanTR_JA_EXHORTOS_DESPACHOS extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String CLAVE_ORGANO;
    private String PERIODO;
    private String EXH_RECIBIDOS;
    private String EXH_DILIGENCIADOS;
    private String EXH_FORMULADOS;
    private String EXH_DILIG_RECIBIDOS;
    private String DESPACH_RECIB_NOTI;
    private String DESPACH_RECIB_EJEC;
    private String DESPACH_RECIB_OTRAS;
    private String DESPACH_DILIG_NOTI;
    private String DESPACH_DILIG_EJEC;
    private String DESPACH_DILIG_OTRAS;
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

    public String GetEXH_RECIBIDOS() {
        return EXH_RECIBIDOS;
    }

    public void SetEXH_RECIBIDOS(String EXH_RECIBIDOS) {
        this.EXH_RECIBIDOS = EXH_RECIBIDOS;
    }

    public String GetEXH_DILIGENCIADOS() {
        return EXH_DILIGENCIADOS;
    }

    public void SetEXH_DILIGENCIADOS(String EXH_DILIGENCIADOS) {
        this.EXH_DILIGENCIADOS = EXH_DILIGENCIADOS;
    }

    public String GetEXH_FORMULADOS() {
        return EXH_FORMULADOS;
    }

    public void SetEXH_FORMULADOS(String EXH_FORMULADOS) {
        this.EXH_FORMULADOS = EXH_FORMULADOS;
    }

    public String GetEXH_DILIG_RECIBIDOS() {
        return EXH_DILIG_RECIBIDOS;
    }

    public void SetEXH_DILIG_RECIBIDOS(String EXH_DILIG_RECIBIDOS) {
        this.EXH_DILIG_RECIBIDOS = EXH_DILIG_RECIBIDOS;
    }

    public String GetDESPACH_RECIB_NOTI() {
        return DESPACH_RECIB_NOTI;
    }

    public void SetDESPACH_RECIB_NOTI(String DESPACH_RECIB_NOTI) {
        this.DESPACH_RECIB_NOTI = DESPACH_RECIB_NOTI;
    }

    public String GetDESPACH_RECIB_EJEC() {
        return DESPACH_RECIB_EJEC;
    }

    public void SetDESPACH_RECIB_EJEC(String DESPACH_RECIB_EJEC) {
        this.DESPACH_RECIB_EJEC = DESPACH_RECIB_EJEC;
    }

    public String GetDESPACH_RECIB_OTRAS() {
        return DESPACH_RECIB_OTRAS;
    }

    public void SetDESPACH_RECIB_OTRAS(String DESPACH_RECIB_OTRAS) {
        this.DESPACH_RECIB_OTRAS = DESPACH_RECIB_OTRAS;
    }

    public String GetDESPACH_DILIG_NOTI() {
        return DESPACH_DILIG_NOTI;
    }

    public void SetDESPACH_DILIG_NOTI(String DESPACH_DILIG_NOTI) {
        this.DESPACH_DILIG_NOTI = DESPACH_DILIG_NOTI;
    }

    public String GetDESPACH_DILIG_EJEC() {
        return DESPACH_DILIG_EJEC;
    }

    public void SetDESPACH_DILIG_EJEC(String DESPACH_DILIG_EJEC) {
        this.DESPACH_DILIG_EJEC = DESPACH_DILIG_EJEC;
    }

    public String GetDESPACH_DILIG_OTRAS() {
        return DESPACH_DILIG_OTRAS;
    }

    public void SetDESPACH_DILIG_OTRAS(String DESPACH_DILIG_OTRAS) {
        this.DESPACH_DILIG_OTRAS = DESPACH_DILIG_OTRAS;
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
            GetEXH_RECIBIDOS(),
            GetEXH_DILIGENCIADOS(),
            GetEXH_FORMULADOS(),
            GetEXH_DILIG_RECIBIDOS(),
            GetDESPACH_RECIB_NOTI(),
            GetDESPACH_RECIB_EJEC(),
            GetDESPACH_RECIB_OTRAS(),
            GetDESPACH_DILIG_NOTI(),
            GetDESPACH_DILIG_EJEC(),
            GetDESPACH_DILIG_OTRAS(),
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
