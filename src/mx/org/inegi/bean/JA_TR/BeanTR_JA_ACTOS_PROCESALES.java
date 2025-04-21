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
public class BeanTR_JA_ACTOS_PROCESALES extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String CLAVE_ORGANO;
    private String PERIODO;
    private String TOTAL_AUTOS;
    private String AUTOS_EJECUCION;
    private String OTROS_AUTOS;
    private String TOTAL_DP;
    private String DP_NOTIFICACIONES;
    private String DP_INSPECCIONES;
    private String DP_CITACIONES;
    private String DP_OTRO;
    private String TOTAL_EMPLAZAMIENTOS;
    private String TOTAL_AUDIENCIAS;
    private String AUDIENCIAS_PRESENCIAL;
    private String AUDIENCIAS_REMOTO;
    private String TOTAL_RESOLUCIONES;
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

    public String GetTOTAL_AUTOS() {
        return TOTAL_AUTOS;
    }

    public void SetTOTAL_AUTOS(String TOTAL_AUTOS) {
        this.TOTAL_AUTOS = TOTAL_AUTOS;
    }

    public String GetAUTOS_EJECUCION() {
        return AUTOS_EJECUCION;
    }

    public void SetAUTOS_EJECUCION(String AUTOS_EJECUCION) {
        this.AUTOS_EJECUCION = AUTOS_EJECUCION;
    }

    public String GetOTROS_AUTOS() {
        return OTROS_AUTOS;
    }

    public void SetOTROS_AUTOS(String OTROS_AUTOS) {
        this.OTROS_AUTOS = OTROS_AUTOS;
    }

    public String GetTOTAL_DP() {
        return TOTAL_DP;
    }

    public void SetTOTAL_DP(String TOTAL_DP) {
        this.TOTAL_DP = TOTAL_DP;
    }

    public String GetDP_NOTIFICACIONES() {
        return DP_NOTIFICACIONES;
    }

    public void SetDP_NOTIFICACIONES(String DP_NOTIFICACIONES) {
        this.DP_NOTIFICACIONES = DP_NOTIFICACIONES;
    }

    public String GetDP_INSPECCIONES() {
        return DP_INSPECCIONES;
    }

    public void SetDP_INSPECCIONES(String DP_INSPECCIONES) {
        this.DP_INSPECCIONES = DP_INSPECCIONES;
    }

    public String GetDP_CITACIONES() {
        return DP_CITACIONES;
    }

    public void SetDP_CITACIONES(String DP_CITACIONES) {
        this.DP_CITACIONES = DP_CITACIONES;
    }

    public String GetDP_OTRO() {
        return DP_OTRO;
    }

    public void SetDP_OTRO(String DP_OTRO) {
        this.DP_OTRO = DP_OTRO;
    }

    public String GetTOTAL_EMPLAZAMIENTOS() {
        return TOTAL_EMPLAZAMIENTOS;
    }

    public void SetTOTAL_EMPLAZAMIENTOS(String TOTAL_EMPLAZAMIENTOS) {
        this.TOTAL_EMPLAZAMIENTOS = TOTAL_EMPLAZAMIENTOS;
    }

    public String GetTOTAL_AUDIENCIAS() {
        return TOTAL_AUDIENCIAS;
    }

    public void SetTOTAL_AUDIENCIAS(String TOTAL_AUDIENCIAS) {
        this.TOTAL_AUDIENCIAS = TOTAL_AUDIENCIAS;
    }

    public String GetAUDIENCIAS_PRESENCIAL() {
        return AUDIENCIAS_PRESENCIAL;
    }

    public void SetAUDIENCIAS_PRESENCIAL(String AUDIENCIAS_PRESENCIAL) {
        this.AUDIENCIAS_PRESENCIAL = AUDIENCIAS_PRESENCIAL;
    }

    public String GetAUDIENCIAS_REMOTO() {
        return AUDIENCIAS_REMOTO;
    }

    public void SetAUDIENCIAS_REMOTO(String AUDIENCIAS_REMOTO) {
        this.AUDIENCIAS_REMOTO = AUDIENCIAS_REMOTO;
    }

    public String GetTOTAL_RESOLUCIONES() {
        return TOTAL_RESOLUCIONES;
    }

    public void SetTOTAL_RESOLUCIONES(String TOTAL_RESOLUCIONES) {
        this.TOTAL_RESOLUCIONES = TOTAL_RESOLUCIONES;
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
            GetTOTAL_AUTOS(),
            GetAUTOS_EJECUCION(),
            GetOTROS_AUTOS(),
            GetTOTAL_DP(),
            GetDP_NOTIFICACIONES(),
            GetDP_INSPECCIONES(),
            GetDP_CITACIONES(),
            GetDP_OTRO(),
            GetTOTAL_EMPLAZAMIENTOS(),
            GetTOTAL_AUDIENCIAS(),
            GetAUDIENCIAS_PRESENCIAL(),
            GetAUDIENCIAS_REMOTO(),
            GetTOTAL_RESOLUCIONES(),
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
