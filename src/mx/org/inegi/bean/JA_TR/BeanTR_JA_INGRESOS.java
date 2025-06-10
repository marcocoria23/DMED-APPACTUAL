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
public class BeanTR_JA_INGRESOS extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String CLAVE_ORGANO;
    private String PERIODO;
    private String TOTAL_INGRESOS;
    private String SUBTOTAL_EXPED_RECIBIDOS;
    private String EXPED_COMISION_MIXTA;
    private String EXPED_TRIBUNAL_SUPERIOR_AG;
    private String EXPED_OTRAS;
    private String SUBTOTAL_DEMANDAS;
    private String DEMANDAS_ESCRITO;
    private String DEMANDAS_COMPARECENCIA;
    private String TOTAL_ASUNTOS_ADMIT_MAT;
    private String SUBTOTAL_ASUNTOS_TERRENOS;
    private String CONTROVER_TERR_NUCLEOS;
    private String CONTROVER_TERR_PROPIETARIOS;
    private String CONTROVER_TERR_SOCIEDAD;
    private String CONTROVER_TERR_POB_EJIDAL;
    private String SUBTOTAL_ASUNTOS_RESTIT;
    private String RESTIT_ACTOS_AUTORIDAD;
    private String RESTIT_ACTOS_PARTICULAR;
    private String RECON_REG_COMUNAL;
    private String NULIDADES_CONTRA_RESOL;
    private String CONFLICTOS_TENENCIA;
    private String SUBTOTAL_ASUNTOS_MA;
    private String CONTROVER_MA_ENTRE_SI;
    private String CONTROVER_MA_ORGANOS;
    private String SUCESION_DERECHOS;
    private String SUBTOTAL_ASUNTOS_JN;
    private String JN_PROMOVIDOS;
    private String JN_CONTRAVIE;
    private String OMISIONES_PROCUR_PERJUICIO;
    private String ASUNTOS_JV;
    private String CONTROVERSIAS_APROVECHA;
    private String REVERSION;
    private String SUBTOTAL_ASUNTOS_EJECUCION;
    private String EJECUCION_CONVENIOS;
    private String EJECUCION_LAUDOS;
    private String RRT_INGRE;
    private String PRIVACION;
    private String INCONFORM;
    private String ASUNTOS_LEGIS;
    private String OTROS_ASUNTOS;
    private String TOTAL_DEMANDAS_NO_INTER;
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

    public String GetTOTAL_INGRESOS() {
        return TOTAL_INGRESOS;
    }

    public void SetTOTAL_INGRESOS(String TOTAL_INGRESOS) {
        this.TOTAL_INGRESOS = TOTAL_INGRESOS;
    }

    public String GetSUBTOTAL_EXPED_RECIBIDOS() {
        return SUBTOTAL_EXPED_RECIBIDOS;
    }

    public void SetSUBTOTAL_EXPED_RECIBIDOS(String SUBTOTAL_EXPED_RECIBIDOS) {
        this.SUBTOTAL_EXPED_RECIBIDOS = SUBTOTAL_EXPED_RECIBIDOS;
    }

    public String GetEXPED_COMISION_MIXTA() {
        return EXPED_COMISION_MIXTA;
    }

    public void SetEXPED_COMISION_MIXTA(String EXPED_COMISION_MIXTA) {
        this.EXPED_COMISION_MIXTA = EXPED_COMISION_MIXTA;
    }

    public String GetEXPED_TRIBUNAL_SUPERIOR_AG() {
        return EXPED_TRIBUNAL_SUPERIOR_AG;
    }

    public void SetEXPED_TRIBUNAL_SUPERIOR_AG(String EXPED_TRIBUNAL_SUPERIOR_AG) {
        this.EXPED_TRIBUNAL_SUPERIOR_AG = EXPED_TRIBUNAL_SUPERIOR_AG;
    }

    public String GetEXPED_OTRAS() {
        return EXPED_OTRAS;
    }

    public void SetEXPED_OTRAS(String EXPED_OTRAS) {
        this.EXPED_OTRAS = EXPED_OTRAS;
    }

    public String GetSUBTOTAL_DEMANDAS() {
        return SUBTOTAL_DEMANDAS;
    }

    public void SetSUBTOTAL_DEMANDAS(String SUBTOTAL_DEMANDAS) {
        this.SUBTOTAL_DEMANDAS = SUBTOTAL_DEMANDAS;
    }

    public String GetDEMANDAS_ESCRITO() {
        return DEMANDAS_ESCRITO;
    }

    public void SetDEMANDAS_ESCRITO(String DEMANDAS_ESCRITO) {
        this.DEMANDAS_ESCRITO = DEMANDAS_ESCRITO;
    }

    public String GetDEMANDAS_COMPARECENCIA() {
        return DEMANDAS_COMPARECENCIA;
    }

    public void SetDEMANDAS_COMPARECENCIA(String DEMANDAS_COMPARECENCIA) {
        this.DEMANDAS_COMPARECENCIA = DEMANDAS_COMPARECENCIA;
    }

    public String GetTOTAL_ASUNTOS_ADMIT_MAT() {
        return TOTAL_ASUNTOS_ADMIT_MAT;
    }

    public void SetTOTAL_ASUNTOS_ADMIT_MAT(String TOTAL_ASUNTOS_ADMIT_MAT) {
        this.TOTAL_ASUNTOS_ADMIT_MAT = TOTAL_ASUNTOS_ADMIT_MAT;
    }

    public String GetSUBTOTAL_ASUNTOS_TERRENOS() {
        return SUBTOTAL_ASUNTOS_TERRENOS;
    }

    public void SetSUBTOTAL_ASUNTOS_TERRENOS(String SUBTOTAL_ASUNTOS_TERRENOS) {
        this.SUBTOTAL_ASUNTOS_TERRENOS = SUBTOTAL_ASUNTOS_TERRENOS;
    }

    public String GetCONTROVER_TERR_NUCLEOS() {
        return CONTROVER_TERR_NUCLEOS;
    }

    public void SetCONTROVER_TERR_NUCLEOS(String CONTROVER_TERR_NUCLEOS) {
        this.CONTROVER_TERR_NUCLEOS = CONTROVER_TERR_NUCLEOS;
    }

    public String GetCONTROVER_TERR_PROPIETARIOS() {
        return CONTROVER_TERR_PROPIETARIOS;
    }

    public void SetCONTROVER_TERR_PROPIETARIOS(String CONTROVER_TERR_PROPIETARIOS) {
        this.CONTROVER_TERR_PROPIETARIOS = CONTROVER_TERR_PROPIETARIOS;
    }

    public String GetCONTROVER_TERR_SOCIEDAD() {
        return CONTROVER_TERR_SOCIEDAD;
    }

    public void SetCONTROVER_TERR_SOCIEDAD(String CONTROVER_TERR_SOCIEDAD) {
        this.CONTROVER_TERR_SOCIEDAD = CONTROVER_TERR_SOCIEDAD;
    }

    public String GetCONTROVER_TERR_POB_EJIDAL() {
        return CONTROVER_TERR_POB_EJIDAL;
    }

    public void SetCONTROVER_TERR_POB_EJIDAL(String CONTROVER_TERR_POB_EJIDAL) {
        this.CONTROVER_TERR_POB_EJIDAL = CONTROVER_TERR_POB_EJIDAL;
    }

    public String GetSUBTOTAL_ASUNTOS_RESTIT() {
        return SUBTOTAL_ASUNTOS_RESTIT;
    }

    public void SetSUBTOTAL_ASUNTOS_RESTIT(String SUBTOTAL_ASUNTOS_RESTIT) {
        this.SUBTOTAL_ASUNTOS_RESTIT = SUBTOTAL_ASUNTOS_RESTIT;
    }

    public String GetRESTIT_ACTOS_AUTORIDAD() {
        return RESTIT_ACTOS_AUTORIDAD;
    }

    public void SetRESTIT_ACTOS_AUTORIDAD(String RESTIT_ACTOS_AUTORIDAD) {
        this.RESTIT_ACTOS_AUTORIDAD = RESTIT_ACTOS_AUTORIDAD;
    }

    public String GetRESTIT_ACTOS_PARTICULAR() {
        return RESTIT_ACTOS_PARTICULAR;
    }

    public void SetRESTIT_ACTOS_PARTICULAR(String RESTIT_ACTOS_PARTICULAR) {
        this.RESTIT_ACTOS_PARTICULAR = RESTIT_ACTOS_PARTICULAR;
    }

    public String GetRECON_REG_COMUNAL() {
        return RECON_REG_COMUNAL;
    }

    public void SetRECON_REG_COMUNAL(String RECON_REG_COMUNAL) {
        this.RECON_REG_COMUNAL = RECON_REG_COMUNAL;
    }

    public String GetNULIDADES_CONTRA_RESOL() {
        return NULIDADES_CONTRA_RESOL;
    }

    public void SetNULIDADES_CONTRA_RESOL(String NULIDADES_CONTRA_RESOL) {
        this.NULIDADES_CONTRA_RESOL = NULIDADES_CONTRA_RESOL;
    }

    public String GetCONFLICTOS_TENENCIA() {
        return CONFLICTOS_TENENCIA;
    }

    public void SetCONFLICTOS_TENENCIA(String CONFLICTOS_TENENCIA) {
        this.CONFLICTOS_TENENCIA = CONFLICTOS_TENENCIA;
    }

    public String GetSUBTOTAL_ASUNTOS_MA() {
        return SUBTOTAL_ASUNTOS_MA;
    }

    public void SetSUBTOTAL_ASUNTOS_MA(String SUBTOTAL_ASUNTOS_MA) {
        this.SUBTOTAL_ASUNTOS_MA = SUBTOTAL_ASUNTOS_MA;
    }

    public String GetCONTROVER_MA_ENTRE_SI() {
        return CONTROVER_MA_ENTRE_SI;
    }

    public void SetCONTROVER_MA_ENTRE_SI(String CONTROVER_MA_ENTRE_SI) {
        this.CONTROVER_MA_ENTRE_SI = CONTROVER_MA_ENTRE_SI;
    }

    public String GetCONTROVER_MA_ORGANOS() {
        return CONTROVER_MA_ORGANOS;
    }

    public void SetCONTROVER_MA_ORGANOS(String CONTROVER_MA_ORGANOS) {
        this.CONTROVER_MA_ORGANOS = CONTROVER_MA_ORGANOS;
    }

    public String GetSUCESION_DERECHOS() {
        return SUCESION_DERECHOS;
    }

    public void SetSUCESION_DERECHOS(String SUCESION_DERECHOS) {
        this.SUCESION_DERECHOS = SUCESION_DERECHOS;
    }

    public String GetSUBTOTAL_ASUNTOS_JN() {
        return SUBTOTAL_ASUNTOS_JN;
    }

    public void SetSUBTOTAL_ASUNTOS_JN(String SUBTOTAL_ASUNTOS_JN) {
        this.SUBTOTAL_ASUNTOS_JN = SUBTOTAL_ASUNTOS_JN;
    }

    public String GetJN_PROMOVIDOS() {
        return JN_PROMOVIDOS;
    }

    public void SetJN_PROMOVIDOS(String JN_PROMOVIDOS) {
        this.JN_PROMOVIDOS = JN_PROMOVIDOS;
    }

    public String GetJN_CONTRAVIE() {
        return JN_CONTRAVIE;
    }

    public void SetJN_CONTRAVIE(String JN_CONTRAVIE) {
        this.JN_CONTRAVIE = JN_CONTRAVIE;
    }

    public String GetOMISIONES_PROCUR_PERJUICIO() {
        return OMISIONES_PROCUR_PERJUICIO;
    }

    public void SetOMISIONES_PROCUR_PERJUICIO(String OMISIONES_PROCUR_PERJUICIO) {
        this.OMISIONES_PROCUR_PERJUICIO = OMISIONES_PROCUR_PERJUICIO;
    }

    public String GetASUNTOS_JV() {
        return ASUNTOS_JV;
    }

    public void SetASUNTOS_JV(String ASUNTOS_JV) {
        this.ASUNTOS_JV = ASUNTOS_JV;
    }

    public String GetCONTROVERSIAS_APROVECHA() {
        return CONTROVERSIAS_APROVECHA;
    }

    public void SetCONTROVERSIAS_APROVECHA(String CONTROVERSIAS_APROVECHA) {
        this.CONTROVERSIAS_APROVECHA = CONTROVERSIAS_APROVECHA;
    }

    public String GetREVERSION() {
        return REVERSION;
    }

    public void SetREVERSION(String REVERSION) {
        this.REVERSION = REVERSION;
    }

    public String GetSUBTOTAL_ASUNTOS_EJECUCION() {
        return SUBTOTAL_ASUNTOS_EJECUCION;
    }

    public void SetSUBTOTAL_ASUNTOS_EJECUCION(String SUBTOTAL_ASUNTOS_EJECUCION) {
        this.SUBTOTAL_ASUNTOS_EJECUCION = SUBTOTAL_ASUNTOS_EJECUCION;
    }

    public String GetEJECUCION_CONVENIOS() {
        return EJECUCION_CONVENIOS;
    }

    public void SetEJECUCION_CONVENIOS(String EJECUCION_CONVENIOS) {
        this.EJECUCION_CONVENIOS = EJECUCION_CONVENIOS;
    }

    public String GetEJECUCION_LAUDOS() {
        return EJECUCION_LAUDOS;
    }

    public void SetEJECUCION_LAUDOS(String EJECUCION_LAUDOS) {
        this.EJECUCION_LAUDOS = EJECUCION_LAUDOS;
    }

    public String GetRRT_INGRE() {
        return RRT_INGRE;
    }

    public void SetRRT_INGRE(String RRT_INGRE) {
        this.RRT_INGRE = RRT_INGRE;
    }

    public String GetPRIVACION() {
        return PRIVACION;
    }

    public void SetPRIVACION(String PRIVACION) {
        this.PRIVACION = PRIVACION;
    }

    public String GetINCONFORM() {
        return INCONFORM;
    }

    public void SetINCONFORM(String INCONFORM) {
        this.INCONFORM = INCONFORM;
    }

    public String GetASUNTOS_LEGIS() {
        return ASUNTOS_LEGIS;
    }

    public void SetASUNTOS_LEGIS(String ASUNTOS_LEGIS) {
        this.ASUNTOS_LEGIS = ASUNTOS_LEGIS;
    }

    public String GetOTROS_ASUNTOS() {
        return OTROS_ASUNTOS;
    }

    public void SetOTROS_ASUNTOS(String OTROS_ASUNTOS) {
        this.OTROS_ASUNTOS = OTROS_ASUNTOS;
    }

    public String GetTOTAL_DEMANDAS_NO_INTER() {
        return TOTAL_DEMANDAS_NO_INTER;
    }

    public void SetTOTAL_DEMANDAS_NO_INTER(String TOTAL_DEMANDAS_NO_INTER) {
        this.TOTAL_DEMANDAS_NO_INTER = TOTAL_DEMANDAS_NO_INTER;
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
            GetTOTAL_INGRESOS(),
            GetSUBTOTAL_EXPED_RECIBIDOS(),
            GetEXPED_COMISION_MIXTA(),
            GetEXPED_TRIBUNAL_SUPERIOR_AG(),
            GetEXPED_OTRAS(),
            GetSUBTOTAL_DEMANDAS(),
            GetDEMANDAS_ESCRITO(),
            GetDEMANDAS_COMPARECENCIA(),
            GetTOTAL_ASUNTOS_ADMIT_MAT(),
            GetSUBTOTAL_ASUNTOS_TERRENOS(),
            GetCONTROVER_TERR_NUCLEOS(),
            GetCONTROVER_TERR_PROPIETARIOS(),
            GetCONTROVER_TERR_SOCIEDAD(),
            GetCONTROVER_TERR_POB_EJIDAL(),
            GetSUBTOTAL_ASUNTOS_RESTIT(),
            GetRESTIT_ACTOS_AUTORIDAD(),
            GetRESTIT_ACTOS_PARTICULAR(),
            GetRECON_REG_COMUNAL(),
            GetNULIDADES_CONTRA_RESOL(),
            GetCONFLICTOS_TENENCIA(),
            GetSUBTOTAL_ASUNTOS_MA(),
            GetCONTROVER_MA_ENTRE_SI(),
            GetCONTROVER_MA_ORGANOS(),
            GetSUCESION_DERECHOS(),
            GetSUBTOTAL_ASUNTOS_JN(),
            GetJN_PROMOVIDOS(),
            GetJN_CONTRAVIE(),
            GetOMISIONES_PROCUR_PERJUICIO(),
            GetASUNTOS_JV(),
            GetCONTROVERSIAS_APROVECHA(),
            GetREVERSION(),
            GetSUBTOTAL_ASUNTOS_EJECUCION(),
            GetEJECUCION_CONVENIOS(),
            GetEJECUCION_LAUDOS(),
            GetRRT_INGRE(),
            GetPRIVACION(),
            GetINCONFORM(),
            GetASUNTOS_LEGIS(),
            GetOTROS_ASUNTOS(),
            GetTOTAL_DEMANDAS_NO_INTER(),
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
