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
public class BeanTR_JA_CONTROL extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String CLAVE_ORGANO;
    private String DISTRITO;
    private String SEDE;
    private String CLAVE_AGEE;
    private String ENTIDAD;
    private String CLAVE_AGEM;
    private String MUNICIPIO;
    private String PERIODO;
    private String TOTAL_ASUNTOS_INGRES;
    private String EXPEDIENTES_RECIBIDOS;
    private String DEMANDAS_INGRESADAS;
    private String TOTAL_ASUNTOS_TRAMITE;
    private String TOTAL_RESOLUCIONES;
    private String TOTAL_ASUNTOS_REACTIVADOS;

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

    public String GetDISTRITO() {
        return DISTRITO;
    }

    public void SetDISTRITO(String DISTRITO) {
        this.DISTRITO = DISTRITO;
    }

    public String GetSEDE() {
        return SEDE;
    }

    public void SetSEDE(String SEDE) {
        this.SEDE = SEDE;
    }

    public String GetCLAVE_AGEE() {
        return CLAVE_AGEE;
    }

    public void SetCLAVE_AGEE(String CLAVE_AGEE) {
        this.CLAVE_AGEE = CLAVE_AGEE;
    }

    public String GetENTIDAD() {
        return ENTIDAD;
    }

    public void SetENTIDAD(String ENTIDAD) {
        this.ENTIDAD = ENTIDAD;
    }

    public String GetCLAVE_AGEM() {
        return CLAVE_AGEM;
    }

    public void SetCLAVE_AGEM(String CLAVE_AGEM) {
        this.CLAVE_AGEM = CLAVE_AGEM;
    }

    public String GetMUNICIPIO() {
        return MUNICIPIO;
    }

    public void SetMUNICIPIO(String MUNICIPIO) {
        this.MUNICIPIO = MUNICIPIO;
    }

    public String GetPERIODO() {
        return PERIODO;
    }

    public void SetPERIODO(String PERIODO) {
        this.PERIODO = PERIODO;
    }

    public String GetTOTAL_ASUNTOS_INGRES() {
        return TOTAL_ASUNTOS_INGRES;
    }

    public void SetTOTAL_ASUNTOS_INGRES(String TOTAL_ASUNTOS_INGRES) {
        this.TOTAL_ASUNTOS_INGRES = TOTAL_ASUNTOS_INGRES;
    }

    public String GetEXPEDIENTES_RECIBIDOS() {
        return EXPEDIENTES_RECIBIDOS;
    }

    public void SetEXPEDIENTES_RECIBIDOS(String EXPEDIENTES_RECIBIDOS) {
        this.EXPEDIENTES_RECIBIDOS = EXPEDIENTES_RECIBIDOS;
    }

    public String GetDEMANDAS_INGRESADAS() {
        return DEMANDAS_INGRESADAS;
    }

    public void SetDEMANDAS_INGRESADAS(String DEMANDAS_INGRESADAS) {
        this.DEMANDAS_INGRESADAS = DEMANDAS_INGRESADAS;
    }

    public String GetTOTAL_ASUNTOS_TRAMITE() {
        return TOTAL_ASUNTOS_TRAMITE;
    }

    public void SetTOTAL_ASUNTOS_TRAMITE(String TOTAL_ASUNTOS_TRAMITE) {
        this.TOTAL_ASUNTOS_TRAMITE = TOTAL_ASUNTOS_TRAMITE;
    }

    public String GetTOTAL_RESOLUCIONES() {
        return TOTAL_RESOLUCIONES;
    }

    public void SetTOTAL_RESOLUCIONES(String TOTAL_RESOLUCIONES) {
        this.TOTAL_RESOLUCIONES = TOTAL_RESOLUCIONES;
    }

    public String GetTOTAL_ASUNTOS_REACTIVADOS() {
        return TOTAL_ASUNTOS_REACTIVADOS;
    }

    public void SetTOTAL_ASUNTOS_REACTIVADOS(String TOTAL_ASUNTOS_REACTIVADOS) {
        this.TOTAL_ASUNTOS_REACTIVADOS = TOTAL_ASUNTOS_REACTIVADOS;
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
            GetDISTRITO(),
            GetSEDE(),
            GetCLAVE_AGEE(),
            GetENTIDAD(),
            GetCLAVE_AGEM(),
            GetMUNICIPIO(),
            GetPERIODO(),
            GetTOTAL_ASUNTOS_INGRES(),
            GetEXPEDIENTES_RECIBIDOS(),
            GetDEMANDAS_INGRESADAS(),
            GetTOTAL_ASUNTOS_TRAMITE(),
            GetTOTAL_RESOLUCIONES(),
            GetTOTAL_ASUNTOS_REACTIVADOS()
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
