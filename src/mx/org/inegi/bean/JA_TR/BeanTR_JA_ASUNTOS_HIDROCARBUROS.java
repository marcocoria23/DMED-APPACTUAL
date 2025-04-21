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
public class BeanTR_JA_ASUNTOS_HIDROCARBUROS extends Bean implements SQLData{

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String CLAVE_ORGANO;
    private String PERIODO;
    private String TOTAL_ASUNTOS;
    private String VALIDACION_CONTRATOS;
    private String SOLICITUD_DECLARACION;
    private String NULIDAD_CONTRATOS;
    private String OTRAS_CONTROV;
    private String TOTAL_ASUNTOS_CONCLUIDOS;
    private String RESOLUCION_VALIDA;
    private String RESOLUCION_NOVALIDA;
    private String ACUERDO_CADUCIDAD;
    private String OTRA_FORMA_CONCL;
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

    public String GetTOTAL_ASUNTOS() {
        return TOTAL_ASUNTOS;
    }

    public void SetTOTAL_ASUNTOS(String TOTAL_ASUNTOS) {
        this.TOTAL_ASUNTOS = TOTAL_ASUNTOS;
    }

    public String GetVALIDACION_CONTRATOS() {
        return VALIDACION_CONTRATOS;
    }

    public void SetVALIDACION_CONTRATOS(String VALIDACION_CONTRATOS) {
        this.VALIDACION_CONTRATOS = VALIDACION_CONTRATOS;
    }

    public String GetSOLICITUD_DECLARACION() {
        return SOLICITUD_DECLARACION;
    }

    public void SetSOLICITUD_DECLARACION(String SOLICITUD_DECLARACION) {
        this.SOLICITUD_DECLARACION = SOLICITUD_DECLARACION;
    }

    public String GetNULIDAD_CONTRATOS() {
        return NULIDAD_CONTRATOS;
    }

    public void SetNULIDAD_CONTRATOS(String NULIDAD_CONTRATOS) {
        this.NULIDAD_CONTRATOS = NULIDAD_CONTRATOS;
    }

    public String GetOTRAS_CONTROV() {
        return OTRAS_CONTROV;
    }

    public void SetOTRAS_CONTROV(String OTRAS_CONTROV) {
        this.OTRAS_CONTROV = OTRAS_CONTROV;
    }

    public String GetTOTAL_ASUNTOS_CONCLUIDOS() {
        return TOTAL_ASUNTOS_CONCLUIDOS;
    }

    public void SetTOTAL_ASUNTOS_CONCLUIDOS(String TOTAL_ASUNTOS_CONCLUIDOS) {
        this.TOTAL_ASUNTOS_CONCLUIDOS = TOTAL_ASUNTOS_CONCLUIDOS;
    }

    public String GetRESOLUCION_VALIDA() {
        return RESOLUCION_VALIDA;
    }

    public void SetRESOLUCION_VALIDA(String RESOLUCION_VALIDA) {
        this.RESOLUCION_VALIDA = RESOLUCION_VALIDA;
    }

    public String GetRESOLUCION_NOVALIDA() {
        return RESOLUCION_NOVALIDA;
    }

    public void SetRESOLUCION_NOVALIDA(String RESOLUCION_NOVALIDA) {
        this.RESOLUCION_NOVALIDA = RESOLUCION_NOVALIDA;
    }

    public String GetACUERDO_CADUCIDAD() {
        return ACUERDO_CADUCIDAD;
    }

    public void SetACUERDO_CADUCIDAD(String ACUERDO_CADUCIDAD) {
        this.ACUERDO_CADUCIDAD = ACUERDO_CADUCIDAD;
    }

    public String GetOTRA_FORMA_CONCL() {
        return OTRA_FORMA_CONCL;
    }

    public void SetOTRA_FORMA_CONCL(String OTRA_FORMA_CONCL) {
        this.OTRA_FORMA_CONCL = OTRA_FORMA_CONCL;
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
            GetTOTAL_ASUNTOS(),
            GetVALIDACION_CONTRATOS(),
            GetSOLICITUD_DECLARACION(),
            GetNULIDAD_CONTRATOS(),
            GetOTRAS_CONTROV(),
            GetTOTAL_ASUNTOS_CONCLUIDOS(),
            GetRESOLUCION_VALIDA(),
            GetRESOLUCION_NOVALIDA(),
            GetACUERDO_CADUCIDAD(),
            GetOTRA_FORMA_CONCL(),
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
