package mx.org.inegi.bean.JA_TR;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * @author ANDREA.HERNANDEZL
 * Modificado para mantener consistencia con el mapeo de 84 campos (0-83)
 */
public class BeanTR_JA_TRAMITE extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURIS;
    private String CLAVE_ORGANO;
    private String PERIODO;
    private String TOTAL_ASUNTOS_PEND;
    private String ASUNTOS_PEND_PREV;
    private String ASUNTOS_PEND_TERM;
    private String ASUNTOS_PEND_ADMI;
    private String TOTAL_ASUNTOS_INSTRUC;
    private String ASUNTOS_JA;
    private String ASUNTOS_JV;
    private String TOTAL_ASUNTOS_MATERIA;
    private String SUBTOTAL_ASUNTOS_CONTROV;
    private String CONTROV_NUCLEOS_MENOS20;
    private String CONTROV_PROPIE_MENOS20;
    private String CONTROV_SOC_MENOS20;
    private String CONTROV_AGRICOLA_MENOS20;
    private String CONTROV_NUCLEOS_MAS20;
    private String CONTROV_PROPIE_MAS20;
    private String CONTROV_SOC_MAS20;
    private String CONTROV_COL_MAS20;
    private String SUBTOTAL_ASUNTOS_RESTIT;
    private String RESTIT_AUTORID_MENOS20;
    private String RESTIT_PARTIC_MENOS20;
    private String RESTIT_AUTORID_MAS20;
    private String RESTIT_PARTIC_MAS20;
    private String SUBTOTAL_RECON;
    private String RECON_MENOS20;
    private String RECON_MAS20;
    private String SUBTOTAL_NULIDADES;
    private String NULIDADES_MENOS20;
    private String NULIDADES_MAS20;
    private String SUBTOTAL_TENENCIA;
    private String TENENCIA_MENOS20;
    private String TENENCIA_MAS20;
    private String SUBTOTAL_ASUNTOS_CONT_MA;
    private String CONTROV_MA_EJID_MENOS20;
    private String CONTROV_MA_NUCLEO_MENOS20;
    private String CONTROV_MA_EJID_MAS20;
    private String CONTROV_MA_NUCLEO_MAS20;
    private String SUBTOTAL_ASUNTOS_DERECHOS;
    private String DERECHOS_MENOS20;
    private String DERECHOS_MAS20;
    private String SUBTOTAL_JN;
    private String JN_PROMOVIDOS_MENOS20;
    private String JN_ACTOS_MENOS20;
    private String JN_PROMOVIDOS_MAS20;
    private String JN_ACTOS_MAS20;
    private String SUBTOTAL_OMISIONES;
    private String OMISIONES_MENOS20;
    private String OMISIONES_MAS20;
    private String SUBTOTAL_ASUNTOS_JV;
    private String JV_MENOS20;
    private String JV_MAS20;
    private String SUBTOTAL_CONTROV_TERR;
    private String CONTROV_TERR_MENOS20;
    private String CONTROV_TERR_MAS20;
    private String SUBTOTAL_REVERSION;
    private String REVERSION_MENOS20;
    private String REVERSION_MAS20;
    private String SUBTOTAL_EJECUCION;
    private String EJECUCION_CONV_MENOS20;
    private String EJECUCION_LAUDOS_MENOS20;
    private String EJECUCION_CONVENIOS_MAS20;
    private String EJECUCION_LAUDOS_MAS20;
    private String SUBTOTAL_ASUNTOS_RRT;
    private String RRT_MENOS20;
    private String RRT_MAS20;
    private String SUBTOTAL_ASUNTOS_DA;
    private String DA_MENOS20;
    private String DA_MAS20;
    private String SUBTOTAL_ASUNTOS_INCONFOR;
    private String INCONFOR_MENOS20;
    private String INCONFOR_MAS20;
    private String SUBTOTAL_ASUNTOS_LA;
    private String LA_MENOS20;
    private String LA_MAS20;
    private String SUBTOTAL_OTROS_ASUNTOS;
    private String OTROS_ASUNTOS_MENOS20;
    private String OTROS_ASUNTOS_MAS20;
    private String TOTAL_ASUNTOS_PROYECTO;
    private String JUICIO_AGRARIO;
    private String JURIS_VOLUNTARIA;
    private String TOTAL_ASUNTOS_TRAMITE;
    private String COMENTARIOS;

    // --- GETTERS Y SETTERS CORREGIDOS ---

    public String GetNOMBRE_ORGANO_JURIS() { return NOMBRE_ORGANO_JURIS; }
    public void SetNOMBRE_ORGANO_JURIS(String val) { this.NOMBRE_ORGANO_JURIS = val; }

    public String GetCLAVE_ORGANO() { return CLAVE_ORGANO; }
    public void SetCLAVE_ORGANO(String val) { this.CLAVE_ORGANO = val; }

    public String GetPERIODO() { return PERIODO; }
    public void SetPERIODO(String val) { this.PERIODO = val; }

    public String GetTOTAL_ASUNTOS_PEND() { return TOTAL_ASUNTOS_PEND; }
    public void SetTOTAL_ASUNTOS_PEND(String val) { this.TOTAL_ASUNTOS_PEND = val; }

    public String GetASUNTOS_PEND_PREV() { return ASUNTOS_PEND_PREV; }
    public void SetASUNTOS_PEND_PREV(String val) { this.ASUNTOS_PEND_PREV = val; }

    public String GetASUNTOS_PEND_TERM() { return ASUNTOS_PEND_TERM; }
    public void SetASUNTOS_PEND_TERM(String val) { this.ASUNTOS_PEND_TERM = val; }

    public String GetASUNTOS_PEND_ADMI() { return ASUNTOS_PEND_ADMI; }
    public void SetASUNTOS_PEND_ADMI(String val) { this.ASUNTOS_PEND_ADMI = val; }

    public String GetTOTAL_ASUNTOS_INSTRUC() { return TOTAL_ASUNTOS_INSTRUC; }
    public void SetTOTAL_ASUNTOS_INSTRUC(String val) { this.TOTAL_ASUNTOS_INSTRUC = val; }

    public String GetASUNTOS_JA() { return ASUNTOS_JA; }
    public void SetASUNTOS_JA(String val) { this.ASUNTOS_JA = val; }

    public String GetASUNTOS_JV() { return ASUNTOS_JV; }
    public void SetASUNTOS_JV(String val) { this.ASUNTOS_JV = val; }

    public String GetTOTAL_ASUNTOS_MATERIA() { return TOTAL_ASUNTOS_MATERIA; }
    public void SetTOTAL_ASUNTOS_MATERIA(String val) { this.TOTAL_ASUNTOS_MATERIA = val; }

    public String GetSUBTOTAL_ASUNTOS_CONTROV() { return SUBTOTAL_ASUNTOS_CONTROV; }
    public void SetSUBTOTAL_ASUNTOS_CONTROV(String val) { this.SUBTOTAL_ASUNTOS_CONTROV = val; }

    public String GetCONTROV_NUCLEOS_MENOS20() { return CONTROV_NUCLEOS_MENOS20; }
    public void SetCONTROV_NUCLEOS_MENOS20(String val) { this.CONTROV_NUCLEOS_MENOS20 = val; }

    public String GetCONTROV_PROPIE_MENOS20() { return CONTROV_PROPIE_MENOS20; }
    public void SetCONTROV_PROPIE_MENOS20(String val) { this.CONTROV_PROPIE_MENOS20 = val; }

    public String GetCONTROV_SOC_MENOS20() { return CONTROV_SOC_MENOS20; }
    public void SetCONTROV_SOC_MENOS20(String val) { this.CONTROV_SOC_MENOS20 = val; }

    public String GetCONTROV_AGRICOLA_MENOS20() { return CONTROV_AGRICOLA_MENOS20; }
    public void SetCONTROV_AGRICOLA_MENOS20(String val) { this.CONTROV_AGRICOLA_MENOS20 = val; }

    public String GetCONTROV_NUCLEOS_MAS20() { return CONTROV_NUCLEOS_MAS20; }
    public void SetCONTROV_NUCLEOS_MAS20(String val) { this.CONTROV_NUCLEOS_MAS20 = val; }

    public String GetCONTROV_PROPIE_MAS20() { return CONTROV_PROPIE_MAS20; }
    public void SetCONTROV_PROPIE_MAS20(String val) { this.CONTROV_PROPIE_MAS20 = val; }

    public String GetCONTROV_SOC_MAS20() { return CONTROV_SOC_MAS20; }
    public void SetCONTROV_SOC_MAS20(String val) { this.CONTROV_SOC_MAS20 = val; }

    public String GetCONTROV_COL_MAS20() { return CONTROV_COL_MAS20; }
    public void SetCONTROV_COL_MAS20(String val) { this.CONTROV_COL_MAS20 = val; }

    public String GetSUBTOTAL_ASUNTOS_RESTIT() { return SUBTOTAL_ASUNTOS_RESTIT; }
    public void SetSUBTOTAL_ASUNTOS_RESTIT(String val) { this.SUBTOTAL_ASUNTOS_RESTIT = val; }

    public String GetRESTIT_AUTORID_MENOS20() { return RESTIT_AUTORID_MENOS20; }
    public void SetRESTIT_AUTORID_MENOS20(String val) { this.RESTIT_AUTORID_MENOS20 = val; }

    public String GetRESTIT_PARTIC_MENOS20() { return RESTIT_PARTIC_MENOS20; }
    public void SetRESTIT_PARTIC_MENOS20(String val) { this.RESTIT_PARTIC_MENOS20 = val; }

    public String GetRESTIT_AUTORID_MAS20() { return RESTIT_AUTORID_MAS20; }
    public void SetRESTIT_AUTORID_MAS20(String val) { this.RESTIT_AUTORID_MAS20 = val; }

    public String GetRESTIT_PARTIC_MAS20() { return RESTIT_PARTIC_MAS20; }
    public void SetRESTIT_PARTIC_MAS20(String val) { this.RESTIT_PARTIC_MAS20 = val; }

    public String GetSUBTOTAL_RECON() { return SUBTOTAL_RECON; }
    public void SetSUBTOTAL_RECON(String val) { this.SUBTOTAL_RECON = val; }

    public String GetRECON_MENOS20() { return RECON_MENOS20; }
    public void SetRECON_MENOS20(String val) { this.RECON_MENOS20 = val; }

    public String GetRECON_MAS20() { return RECON_MAS20; }
    public void SetRECON_MAS20(String val) { this.RECON_MAS20 = val; }

    public String GetSUBTOTAL_NULIDADES() { return SUBTOTAL_NULIDADES; }
    public void SetSUBTOTAL_NULIDADES(String val) { this.SUBTOTAL_NULIDADES = val; }

    public String GetNULIDADES_MENOS20() { return NULIDADES_MENOS20; }
    public void SetNULIDADES_MENOS20(String val) { this.NULIDADES_MENOS20 = val; }

    public String GetNULIDADES_MAS20() { return NULIDADES_MAS20; }
    public void SetNULIDADES_MAS20(String val) { this.NULIDADES_MAS20 = val; }

    public String GetSUBTOTAL_TENENCIA() { return SUBTOTAL_TENENCIA; }
    public void SetSUBTOTAL_TENENCIA(String val) { this.SUBTOTAL_TENENCIA = val; }

    public String GetTENENCIA_MENOS20() { return TENENCIA_MENOS20; }
    public void SetTENENCIA_MENOS20(String val) { this.TENENCIA_MENOS20 = val; }

    public String GetTENENCIA_MAS20() { return TENENCIA_MAS20; }
    public void SetTENENCIA_MAS20(String val) { this.TENENCIA_MAS20 = val; }

    public String GetSUBTOTAL_ASUNTOS_CONT_MA() { return SUBTOTAL_ASUNTOS_CONT_MA; }
    public void SetSUBTOTAL_ASUNTOS_CONT_MA(String val) { this.SUBTOTAL_ASUNTOS_CONT_MA = val; }

    public String GetCONTROV_MA_EJID_MENOS20() { return CONTROV_MA_EJID_MENOS20; }
    public void SetCONTROV_MA_EJID_MENOS20(String val) { this.CONTROV_MA_EJID_MENOS20 = val; }

    public String GetCONTROV_MA_NUCLEO_MENOS20() { return CONTROV_MA_NUCLEO_MENOS20; }
    public void SetCONTROV_MA_NUCLEO_MENOS20(String val) { this.CONTROV_MA_NUCLEO_MENOS20 = val; }

    public String GetCONTROV_MA_EJID_MAS20() { return CONTROV_MA_EJID_MAS20; }
    public void SetCONTROV_MA_EJID_MAS20(String val) { this.CONTROV_MA_EJID_MAS20 = val; }

    public String GetCONTROV_MA_NUCLEO_MAS20() { return CONTROV_MA_NUCLEO_MAS20; }
    public void SetCONTROV_MA_NUCLEO_MAS20(String val) { this.CONTROV_MA_NUCLEO_MAS20 = val; }

    public String GetSUBTOTAL_ASUNTOS_DERECHOS() { return SUBTOTAL_ASUNTOS_DERECHOS; }
    public void SetSUBTOTAL_ASUNTOS_DERECHOS(String val) { this.SUBTOTAL_ASUNTOS_DERECHOS = val; }

    public String GetDERECHOS_MENOS20() { return DERECHOS_MENOS20; }
    public void SetDERECHOS_MENOS20(String val) { this.DERECHOS_MENOS20 = val; }

    public String GetDERECHOS_MAS20() { return DERECHOS_MAS20; }
    public void SetDERECHOS_MAS20(String val) { this.DERECHOS_MAS20 = val; }

    public String GetSUBTOTAL_JN() { return SUBTOTAL_JN; }
    public void SetSUBTOTAL_JN(String val) { this.SUBTOTAL_JN = val; }

    public String GetJN_PROMOVIDOS_MENOS20() { return JN_PROMOVIDOS_MENOS20; }
    public void SetJN_PROMOVIDOS_MENOS20(String val) { this.JN_PROMOVIDOS_MENOS20 = val; }

    public String GetJN_ACTOS_MENOS20() { return JN_ACTOS_MENOS20; }
    public void SetJN_ACTOS_MENOS20(String val) { this.JN_ACTOS_MENOS20 = val; }

    public String GetJN_PROMOVIDOS_MAS20() { return JN_PROMOVIDOS_MAS20; }
    public void SetJN_PROMOVIDOS_MAS20(String val) { this.JN_PROMOVIDOS_MAS20 = val; }

    public String GetJN_ACTOS_MAS20() { return JN_ACTOS_MAS20; }
    public void SetJN_ACTOS_MAS20(String val) { this.JN_ACTOS_MAS20 = val; }

    public String GetSUBTOTAL_OMISIONES() { return SUBTOTAL_OMISIONES; }
    public void SetSUBTOTAL_OMISIONES(String val) { this.SUBTOTAL_OMISIONES = val; }

    public String GetOMISIONES_MENOS20() { return OMISIONES_MENOS20; }
    public void SetOMISIONES_MENOS20(String val) { this.OMISIONES_MENOS20 = val; }

    public String GetOMISIONES_MAS20() { return OMISIONES_MAS20; }
    public void SetOMISIONES_MAS20(String val) { this.OMISIONES_MAS20 = val; }

    public String GetSUBTOTAL_ASUNTOS_JV() { return SUBTOTAL_ASUNTOS_JV; }
    public void SetSUBTOTAL_ASUNTOS_JV(String val) { this.SUBTOTAL_ASUNTOS_JV = val; }

    public String GetJV_MENOS20() { return JV_MENOS20; }
    public void SetJV_MENOS20(String val) { this.JV_MENOS20 = val; }

    public String GetJV_MAS20() { return JV_MAS20; }
    public void SetJV_MAS20(String val) { this.JV_MAS20 = val; }

    public String GetSUBTOTAL_CONTROV_TERR() { return SUBTOTAL_CONTROV_TERR; }
    public void SetSUBTOTAL_CONTROV_TERR(String val) { this.SUBTOTAL_CONTROV_TERR = val; }

    public String GetCONTROV_TERR_MENOS20() { return CONTROV_TERR_MENOS20; }
    public void SetCONTROV_TERR_MENOS20(String val) { this.CONTROV_TERR_MENOS20 = val; }

    public String GetCONTROV_TERR_MAS20() { return CONTROV_TERR_MAS20; }
    public void SetCONTROV_TERR_MAS20(String val) { this.CONTROV_TERR_MAS20 = val; }

    public String GetSUBTOTAL_REVERSION() { return SUBTOTAL_REVERSION; }
    public void SetSUBTOTAL_REVERSION(String val) { this.SUBTOTAL_REVERSION = val; }

    public String GetREVERSION_MENOS20() { return REVERSION_MENOS20; }
    public void SetREVERSION_MENOS20(String val) { this.REVERSION_MENOS20 = val; }

    public String GetREVERSION_MAS20() { return REVERSION_MAS20; }
    public void SetREVERSION_MAS20(String val) { this.REVERSION_MAS20 = val; }

    public String GetSUBTOTAL_EJECUCION() { return SUBTOTAL_EJECUCION; }
    public void SetSUBTOTAL_EJECUCION(String val) { this.SUBTOTAL_EJECUCION = val; }

    public String GetEJECUCION_CONV_MENOS20() { return EJECUCION_CONV_MENOS20; }
    public void SetEJECUCION_CONV_MENOS20(String val) { this.EJECUCION_CONV_MENOS20 = val; }

    public String GetEJECUCION_LAUDOS_MENOS20() { return EJECUCION_LAUDOS_MENOS20; }
    public void SetEJECUCION_LAUDOS_MENOS20(String val) { this.EJECUCION_LAUDOS_MENOS20 = val; }

    public String GetEJECUCION_CONVENIOS_MAS20() { return EJECUCION_CONVENIOS_MAS20; }
    public void SetEJECUCION_CONVENIOS_MAS20(String val) { this.EJECUCION_CONVENIOS_MAS20 = val; }

    public String GetEJECUCION_LAUDOS_MAS20() { return EJECUCION_LAUDOS_MAS20; }
    public void SetEJECUCION_LAUDOS_MAS20(String val) { this.EJECUCION_LAUDOS_MAS20 = val; }

    public String GetSUBTOTAL_ASUNTOS_RRT() { return SUBTOTAL_ASUNTOS_RRT; }
    public void SetSUBTOTAL_ASUNTOS_RRT(String val) { this.SUBTOTAL_ASUNTOS_RRT = val; }

    public String GetRRT_MENOS20() { return RRT_MENOS20; }
    public void SetRRT_MENOS20(String val) { this.RRT_MENOS20 = val; }

    public String GetRRT_MAS20() { return RRT_MAS20; }
    public void SetRRT_MAS20(String val) { this.RRT_MAS20 = val; }

    public String GetSUBTOTAL_ASUNTOS_DA() { return SUBTOTAL_ASUNTOS_DA; }
    public void SetSUBTOTAL_ASUNTOS_DA(String val) { this.SUBTOTAL_ASUNTOS_DA = val; }

    public String GetDA_MENOS20() { return DA_MENOS20; }
    public void SetDA_MENOS20(String val) { this.DA_MENOS20 = val; }

    public String GetDA_MAS20() { return DA_MAS20; }
    public void SetDA_MAS20(String val) { this.DA_MAS20 = val; }

    public String GetSUBTOTAL_ASUNTOS_INCONFOR() { return SUBTOTAL_ASUNTOS_INCONFOR; }
    public void SetSUBTOTAL_ASUNTOS_INCONFOR(String val) { this.SUBTOTAL_ASUNTOS_INCONFOR = val; }

    public String GetINCONFOR_MENOS20() { return INCONFOR_MENOS20; }
    public void SetINCONFOR_MENOS20(String val) { this.INCONFOR_MENOS20 = val; }

    public String GetINCONFOR_MAS20() { return INCONFOR_MAS20; }
    public void SetINCONFOR_MAS20(String val) { this.INCONFOR_MAS20 = val; }

    public String GetSUBTOTAL_ASUNTOS_LA() { return SUBTOTAL_ASUNTOS_LA; }
    public void SetSUBTOTAL_ASUNTOS_LA(String val) { this.SUBTOTAL_ASUNTOS_LA = val; }

    public String GetLA_MENOS20() { return LA_MENOS20; }
    public void SetLA_MENOS20(String val) { this.LA_MENOS20 = val; }

    public String GetLA_MAS20() { return LA_MAS20; }
    public void SetLA_MAS20(String val) { this.LA_MAS20 = val; }

    public String GetSUBTOTAL_OTROS_ASUNTOS() { return SUBTOTAL_OTROS_ASUNTOS; }
    public void SetSUBTOTAL_OTROS_ASUNTOS(String val) { this.SUBTOTAL_OTROS_ASUNTOS = val; }

    public String GetOTROS_ASUNTOS_MENOS20() { return OTROS_ASUNTOS_MENOS20; }
    public void SetOTROS_ASUNTOS_MENOS20(String val) { this.OTROS_ASUNTOS_MENOS20 = val; }

    public String GetOTROS_ASUNTOS_MAS20() { return OTROS_ASUNTOS_MAS20; }
    public void SetOTROS_ASUNTOS_MAS20(String val) { this.OTROS_ASUNTOS_MAS20 = val; }

    public String GetTOTAL_ASUNTOS_PROYECTO() { return TOTAL_ASUNTOS_PROYECTO; }
    public void SetTOTAL_ASUNTOS_PROYECTO(String val) { this.TOTAL_ASUNTOS_PROYECTO = val; }

    public String GetJUICIO_AGRARIO() { return JUICIO_AGRARIO; }
    public void SetJUICIO_AGRARIO(String val) { this.JUICIO_AGRARIO = val; }

    public String GetJURIS_VOLUNTARIA() { return JURIS_VOLUNTARIA; }
    public void SetJURIS_VOLUNTARIA(String val) { this.JURIS_VOLUNTARIA = val; }

    public String GetTOTAL_ASUNTOS_TRAMITE() { return TOTAL_ASUNTOS_TRAMITE; }
    public void SetTOTAL_ASUNTOS_TRAMITE(String val) { this.TOTAL_ASUNTOS_TRAMITE = val; }

    public String GetCOMENTARIOS() { return COMENTARIOS; }
    public void SetCOMENTARIOS(String val) { this.COMENTARIOS = val; }


    // --- IMPLEMENTACIÓN SQLDATA ---

    @Override
    public String getSQLTypeName() throws SQLException {
        return SQLTypeName;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        this.SQLTypeName = typeName;
        this.NOMBRE_ORGANO_JURIS = stream.readString();
        this.CLAVE_ORGANO = stream.readString();
        this.PERIODO = stream.readString();
        this.TOTAL_ASUNTOS_PEND = stream.readString();
        this.ASUNTOS_PEND_PREV = stream.readString();
        this.ASUNTOS_PEND_TERM = stream.readString();
        this.ASUNTOS_PEND_ADMI = stream.readString();
        this.TOTAL_ASUNTOS_INSTRUC = stream.readString();
        this.ASUNTOS_JA = stream.readString();
        this.ASUNTOS_JV = stream.readString();
        this.TOTAL_ASUNTOS_MATERIA = stream.readString();
        this.SUBTOTAL_ASUNTOS_CONTROV = stream.readString();
        this.CONTROV_NUCLEOS_MENOS20 = stream.readString();
        this.CONTROV_PROPIE_MENOS20 = stream.readString();
        this.CONTROV_SOC_MENOS20 = stream.readString();
        this.CONTROV_AGRICOLA_MENOS20 = stream.readString();
        this.CONTROV_NUCLEOS_MAS20 = stream.readString();
        this.CONTROV_PROPIE_MAS20 = stream.readString();
        this.CONTROV_SOC_MAS20 = stream.readString();
        this.CONTROV_COL_MAS20 = stream.readString();
        this.SUBTOTAL_ASUNTOS_RESTIT = stream.readString();
        this.RESTIT_AUTORID_MENOS20 = stream.readString();
        this.RESTIT_PARTIC_MENOS20 = stream.readString();
        this.RESTIT_AUTORID_MAS20 = stream.readString();
        this.RESTIT_PARTIC_MAS20 = stream.readString();
        this.SUBTOTAL_RECON = stream.readString();
        this.RECON_MENOS20 = stream.readString();
        this.RECON_MAS20 = stream.readString();
        this.SUBTOTAL_NULIDADES = stream.readString();
        this.NULIDADES_MENOS20 = stream.readString();
        this.NULIDADES_MAS20 = stream.readString();
        this.SUBTOTAL_TENENCIA = stream.readString();
        this.TENENCIA_MENOS20 = stream.readString();
        this.TENENCIA_MAS20 = stream.readString();
        this.SUBTOTAL_ASUNTOS_CONT_MA = stream.readString();
        this.CONTROV_MA_EJID_MENOS20 = stream.readString();
        this.CONTROV_MA_NUCLEO_MENOS20 = stream.readString();
        this.CONTROV_MA_EJID_MAS20 = stream.readString();
        this.CONTROV_MA_NUCLEO_MAS20 = stream.readString();
        this.SUBTOTAL_ASUNTOS_DERECHOS = stream.readString();
        this.DERECHOS_MENOS20 = stream.readString();
        this.DERECHOS_MAS20 = stream.readString();
        this.SUBTOTAL_JN = stream.readString();
        this.JN_PROMOVIDOS_MENOS20 = stream.readString();
        this.JN_ACTOS_MENOS20 = stream.readString();
        this.JN_PROMOVIDOS_MAS20 = stream.readString();
        this.JN_ACTOS_MAS20 = stream.readString();
        this.SUBTOTAL_OMISIONES = stream.readString();
        this.OMISIONES_MENOS20 = stream.readString();
        this.OMISIONES_MAS20 = stream.readString();
        this.SUBTOTAL_ASUNTOS_JV = stream.readString();
        this.JV_MENOS20 = stream.readString();
        this.JV_MAS20 = stream.readString();
        this.SUBTOTAL_CONTROV_TERR = stream.readString();
        this.CONTROV_TERR_MENOS20 = stream.readString();
        this.CONTROV_TERR_MAS20 = stream.readString();
        this.SUBTOTAL_REVERSION = stream.readString();
        this.REVERSION_MENOS20 = stream.readString();
        this.REVERSION_MAS20 = stream.readString();
        this.SUBTOTAL_EJECUCION = stream.readString();
        this.EJECUCION_CONV_MENOS20 = stream.readString();
        this.EJECUCION_LAUDOS_MENOS20 = stream.readString();
        this.EJECUCION_CONVENIOS_MAS20 = stream.readString();
        this.EJECUCION_LAUDOS_MAS20 = stream.readString();
        this.SUBTOTAL_ASUNTOS_RRT = stream.readString();
        this.RRT_MENOS20 = stream.readString();
        this.RRT_MAS20 = stream.readString();
        this.SUBTOTAL_ASUNTOS_DA = stream.readString();
        this.DA_MENOS20 = stream.readString();
        this.DA_MAS20 = stream.readString();
        this.SUBTOTAL_ASUNTOS_INCONFOR = stream.readString();
        this.INCONFOR_MENOS20 = stream.readString();
        this.INCONFOR_MAS20 = stream.readString();
        this.SUBTOTAL_ASUNTOS_LA = stream.readString();
        this.LA_MENOS20 = stream.readString();
        this.LA_MAS20 = stream.readString();
        this.SUBTOTAL_OTROS_ASUNTOS = stream.readString();
        this.OTROS_ASUNTOS_MENOS20 = stream.readString();
        this.OTROS_ASUNTOS_MAS20 = stream.readString();
        this.TOTAL_ASUNTOS_PROYECTO = stream.readString();
        this.JUICIO_AGRARIO = stream.readString();
        this.JURIS_VOLUNTARIA = stream.readString();
        this.TOTAL_ASUNTOS_TRAMITE = stream.readString();
        this.COMENTARIOS = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        for (Object item : toArray()) {
            stream.writeString((String) item);
        }
    }

    @Override
    public Object[] getLlave() {
        return new Object[]{ GetCLAVE_ORGANO(), GetPERIODO() };
    }

    @Override
    public Object[] toArray() {
        return new Object[]{
            GetNOMBRE_ORGANO_JURIS(), GetCLAVE_ORGANO(), GetPERIODO(), GetTOTAL_ASUNTOS_PEND(),
            GetASUNTOS_PEND_PREV(), GetASUNTOS_PEND_TERM(), GetASUNTOS_PEND_ADMI(), GetTOTAL_ASUNTOS_INSTRUC(),
            GetASUNTOS_JA(), GetASUNTOS_JV(), GetTOTAL_ASUNTOS_MATERIA(), GetSUBTOTAL_ASUNTOS_CONTROV(),
            GetCONTROV_NUCLEOS_MENOS20(), GetCONTROV_PROPIE_MENOS20(), GetCONTROV_SOC_MENOS20(), GetCONTROV_AGRICOLA_MENOS20(),
            GetCONTROV_NUCLEOS_MAS20(), GetCONTROV_PROPIE_MAS20(), GetCONTROV_SOC_MAS20(), GetCONTROV_COL_MAS20(),
            GetSUBTOTAL_ASUNTOS_RESTIT(), GetRESTIT_AUTORID_MENOS20(), GetRESTIT_PARTIC_MENOS20(), GetRESTIT_AUTORID_MAS20(),
            GetRESTIT_PARTIC_MAS20(), GetSUBTOTAL_RECON(), GetRECON_MENOS20(), GetRECON_MAS20(),
            GetSUBTOTAL_NULIDADES(), GetNULIDADES_MENOS20(), GetNULIDADES_MAS20(), GetSUBTOTAL_TENENCIA(),
            GetTENENCIA_MENOS20(), GetTENENCIA_MAS20(), GetSUBTOTAL_ASUNTOS_CONT_MA(), GetCONTROV_MA_EJID_MENOS20(),
            GetCONTROV_MA_NUCLEO_MENOS20(), GetCONTROV_MA_EJID_MAS20(), GetCONTROV_MA_NUCLEO_MAS20(), GetSUBTOTAL_ASUNTOS_DERECHOS(),
            GetDERECHOS_MENOS20(), GetDERECHOS_MAS20(), GetSUBTOTAL_JN(), GetJN_PROMOVIDOS_MENOS20(),
            GetJN_ACTOS_MENOS20(), GetJN_PROMOVIDOS_MAS20(), GetJN_ACTOS_MAS20(), GetSUBTOTAL_OMISIONES(),
            GetOMISIONES_MENOS20(), GetOMISIONES_MAS20(), GetSUBTOTAL_ASUNTOS_JV(), GetJV_MENOS20(),
            GetJV_MAS20(), GetSUBTOTAL_CONTROV_TERR(), GetCONTROV_TERR_MENOS20(), GetCONTROV_TERR_MAS20(),
            GetSUBTOTAL_REVERSION(), GetREVERSION_MENOS20(), GetREVERSION_MAS20(), GetSUBTOTAL_EJECUCION(),
            GetEJECUCION_CONV_MENOS20(), GetEJECUCION_LAUDOS_MENOS20(), GetEJECUCION_CONVENIOS_MAS20(), GetEJECUCION_LAUDOS_MAS20(),
            GetSUBTOTAL_ASUNTOS_RRT(), GetRRT_MENOS20(), GetRRT_MAS20(), GetSUBTOTAL_ASUNTOS_DA(),
            GetDA_MENOS20(), GetDA_MAS20(), GetSUBTOTAL_ASUNTOS_INCONFOR(), GetINCONFOR_MENOS20(),
            GetINCONFOR_MAS20(), GetSUBTOTAL_ASUNTOS_LA(), GetLA_MENOS20(), GetLA_MAS20(),
            GetSUBTOTAL_OTROS_ASUNTOS(), GetOTROS_ASUNTOS_MENOS20(), GetOTROS_ASUNTOS_MAS20(), GetTOTAL_ASUNTOS_PROYECTO(),
            GetJUICIO_AGRARIO(), GetJURIS_VOLUNTARIA(), GetTOTAL_ASUNTOS_TRAMITE(), GetCOMENTARIOS()
        };
    }

    @Override
    public void setAtributos(Object[] obj) {
        if (obj != null && obj.length >= 84) {
            SetNOMBRE_ORGANO_JURIS(ots(obj[0]));
            SetCLAVE_ORGANO(ots(obj[1]));
            SetPERIODO(ots(obj[2]));
            SetTOTAL_ASUNTOS_PEND(ots(obj[3]));
            SetASUNTOS_PEND_PREV(ots(obj[4]));
            SetASUNTOS_PEND_TERM(ots(obj[5]));
            SetASUNTOS_PEND_ADMI(ots(obj[6]));
            SetTOTAL_ASUNTOS_INSTRUC(ots(obj[7]));
            SetASUNTOS_JA(ots(obj[8]));
            SetASUNTOS_JV(ots(obj[9]));
            SetTOTAL_ASUNTOS_MATERIA(ots(obj[10]));
            SetSUBTOTAL_ASUNTOS_CONTROV(ots(obj[11]));
            SetCONTROV_NUCLEOS_MENOS20(ots(obj[12]));
            SetCONTROV_PROPIE_MENOS20(ots(obj[13]));
            SetCONTROV_SOC_MENOS20(ots(obj[14]));
            SetCONTROV_AGRICOLA_MENOS20(ots(obj[15]));
            SetCONTROV_NUCLEOS_MAS20(ots(obj[16]));
            SetCONTROV_PROPIE_MAS20(ots(obj[17]));
            SetCONTROV_SOC_MAS20(ots(obj[18]));
            SetCONTROV_COL_MAS20(ots(obj[19]));
            SetSUBTOTAL_ASUNTOS_RESTIT(ots(obj[20]));
            SetRESTIT_AUTORID_MENOS20(ots(obj[21]));
            SetRESTIT_PARTIC_MENOS20(ots(obj[22]));
            SetRESTIT_AUTORID_MAS20(ots(obj[23]));
            SetRESTIT_PARTIC_MAS20(ots(obj[24]));
            SetSUBTOTAL_RECON(ots(obj[25]));
            SetRECON_MENOS20(ots(obj[26]));
            SetRECON_MAS20(ots(obj[27]));
            SetSUBTOTAL_NULIDADES(ots(obj[28]));
            SetNULIDADES_MENOS20(ots(obj[29]));
            SetNULIDADES_MAS20(ots(obj[30]));
            SetSUBTOTAL_TENENCIA(ots(obj[31]));
            SetTENENCIA_MENOS20(ots(obj[32]));
            SetTENENCIA_MAS20(ots(obj[33]));
            SetSUBTOTAL_ASUNTOS_CONT_MA(ots(obj[34]));
            SetCONTROV_MA_EJID_MENOS20(ots(obj[35]));
            SetCONTROV_MA_NUCLEO_MENOS20(ots(obj[36]));
            SetCONTROV_MA_EJID_MAS20(ots(obj[37]));
            SetCONTROV_MA_NUCLEO_MAS20(ots(obj[38]));
            SetSUBTOTAL_ASUNTOS_DERECHOS(ots(obj[39]));
            SetDERECHOS_MENOS20(ots(obj[40]));
            SetDERECHOS_MAS20(ots(obj[41]));
            SetSUBTOTAL_JN(ots(obj[42]));
            SetJN_PROMOVIDOS_MENOS20(ots(obj[43]));
            SetJN_ACTOS_MENOS20(ots(obj[44]));
            SetJN_PROMOVIDOS_MAS20(ots(obj[45]));
            SetJN_ACTOS_MAS20(ots(obj[46]));
            SetSUBTOTAL_OMISIONES(ots(obj[47]));
            SetOMISIONES_MENOS20(ots(obj[48]));
            SetOMISIONES_MAS20(ots(obj[49]));
            SetSUBTOTAL_ASUNTOS_JV(ots(obj[50]));
            SetJV_MENOS20(ots(obj[51]));
            SetJV_MAS20(ots(obj[52]));
            SetSUBTOTAL_CONTROV_TERR(ots(obj[53]));
            SetCONTROV_TERR_MENOS20(ots(obj[54]));
            SetCONTROV_TERR_MAS20(ots(obj[55]));
            SetSUBTOTAL_REVERSION(ots(obj[56]));
            SetREVERSION_MENOS20(ots(obj[57]));
            SetREVERSION_MAS20(ots(obj[58]));
            SetSUBTOTAL_EJECUCION(ots(obj[59]));
            SetEJECUCION_CONV_MENOS20(ots(obj[60]));
            SetEJECUCION_LAUDOS_MENOS20(ots(obj[61]));
            SetEJECUCION_CONVENIOS_MAS20(ots(obj[62]));
            SetEJECUCION_LAUDOS_MAS20(ots(obj[63]));
            SetSUBTOTAL_ASUNTOS_RRT(ots(obj[64]));
            SetRRT_MENOS20(ots(obj[65]));
            SetRRT_MAS20(ots(obj[66]));
            SetSUBTOTAL_ASUNTOS_DA(ots(obj[67]));
            SetDA_MENOS20(ots(obj[68]));
            SetDA_MAS20(ots(obj[69]));
            SetSUBTOTAL_ASUNTOS_INCONFOR(ots(obj[70]));
            SetINCONFOR_MENOS20(ots(obj[71]));
            SetINCONFOR_MAS20(ots(obj[72]));
            SetSUBTOTAL_ASUNTOS_LA(ots(obj[73]));
            SetLA_MENOS20(ots(obj[74]));
            SetLA_MAS20(ots(obj[75]));
            SetSUBTOTAL_OTROS_ASUNTOS(ots(obj[76]));
            SetOTROS_ASUNTOS_MENOS20(ots(obj[77]));
            SetOTROS_ASUNTOS_MAS20(ots(obj[78]));
            SetTOTAL_ASUNTOS_PROYECTO(ots(obj[79]));
            SetJUICIO_AGRARIO(ots(obj[80]));
            SetJURIS_VOLUNTARIA(ots(obj[81]));
            SetTOTAL_ASUNTOS_TRAMITE(ots(obj[82]));
            SetCOMENTARIOS(ots(obj[83]));
        }
    }

    @Override
    public void actualizaDesc(Connection conn) throws SQLException {
        // Implementar si es necesario
    }

    private String ots(Object obj) {
        return (obj != null) ? obj.toString() : null;
    }
}