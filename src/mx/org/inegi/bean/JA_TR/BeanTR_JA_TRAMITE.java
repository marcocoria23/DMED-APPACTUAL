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
public class BeanTR_JA_TRAMITE extends Bean implements SQLData {

    private String SQLTypeName;
    private String NOMBRE_ORGANO_JURI;
    private String CLAVE_ORGANO;
    private String PERIODO;
    private String TOTAL_ASUNTOS_PEND;
    private String ASUNTOS_PEND_PREV;
    private String ASUNTOS_PEND_TERM;
    private String ASUNTOS_PEND_ADMI;
    private String TOTAL_ASUNTOS_INSTRUCCION;
    private String ASUNTOS_JA;
    private String ASUNTOS_JV;
    private String TOTAL_ASUNTOS_MATERIA;
    private String SUBTOTAL_ASUNTOS_CONTROV;
    private String CONTROV_NUCLEOS_MENOS20;
    private String CONTROV_PROPIE_MENOS20;
    private String CONTROV_SOCIEDADES_MENOS20;
    private String CONTROV_NUCLEOS_MAS20;
    private String CONTROV_PROPIE_MAS20;
    private String CONTROV_SOCIEDADES_MAS20;
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
    private String SUBTOTAL_ASUNTOS_CONTROV_MA;
    private String CONTROV_MA_EJID_MENOS20;
    private String CONTROV_MA_NUCLEO_MENOS20;
    private String CONTROV_MA_EJID_MASS20;
    private String CONTROV_MA_NUCLEO_MASS20;
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
    private String EJECUCION_CONVENIOS_MENOS20;
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
    private String TOTAL_ASUNTOS;
    private String COMENTARIOS;

    public String GetNOMBRE_ORGANO_JURI() {
        return NOMBRE_ORGANO_JURI;
    }

    public void SetNOMBRE_ORGANO_JURI(String NOMBRE_ORGANO_JURI) {
        this.NOMBRE_ORGANO_JURI = NOMBRE_ORGANO_JURI;
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

    public String GetTOTAL_ASUNTOS_PEND() {
        return TOTAL_ASUNTOS_PEND;
    }

    public void SetTOTAL_ASUNTOS_PEND(String TOTAL_ASUNTOS_PEND) {
        this.TOTAL_ASUNTOS_PEND = TOTAL_ASUNTOS_PEND;
    }

    public String GetASUNTOS_PEND_PREV() {
        return ASUNTOS_PEND_PREV;
    }

    public void SetASUNTOS_PEND_PREV(String ASUNTOS_PEND_PREV) {
        this.ASUNTOS_PEND_PREV = ASUNTOS_PEND_PREV;
    }

    public String GetASUNTOS_PEND_TERM() {
        return ASUNTOS_PEND_TERM;
    }

    public void SetASUNTOS_PEND_TERM(String ASUNTOS_PEND_TERM) {
        this.ASUNTOS_PEND_TERM = ASUNTOS_PEND_TERM;
    }

    public String GetASUNTOS_PEND_ADMI() {
        return ASUNTOS_PEND_ADMI;
    }

    public void SetASUNTOS_PEND_ADMI(String ASUNTOS_PEND_ADMI) {
        this.ASUNTOS_PEND_ADMI = ASUNTOS_PEND_ADMI;
    }

    public String GetTOTAL_ASUNTOS_INSTRUCCION() {
        return TOTAL_ASUNTOS_INSTRUCCION;
    }

    public void SetTOTAL_ASUNTOS_INSTRUCCION(String TOTAL_ASUNTOS_INSTRUCCION) {
        this.TOTAL_ASUNTOS_INSTRUCCION = TOTAL_ASUNTOS_INSTRUCCION;
    }

    public String GetASUNTOS_JA() {
        return ASUNTOS_JA;
    }

    public void SetASUNTOS_JA(String ASUNTOS_JA) {
        this.ASUNTOS_JA = ASUNTOS_JA;
    }

    public String GetASUNTOS_JV() {
        return ASUNTOS_JV;
    }

    public void SetASUNTOS_JV(String ASUNTOS_JV) {
        this.ASUNTOS_JV = ASUNTOS_JV;
    }

    public String GetTOTAL_ASUNTOS_MATERIA() {
        return TOTAL_ASUNTOS_MATERIA;
    }

    public void SetTOTAL_ASUNTOS_MATERIA(String TOTAL_ASUNTOS_MATERIA) {
        this.TOTAL_ASUNTOS_MATERIA = TOTAL_ASUNTOS_MATERIA;
    }

    public String GetSUBTOTAL_ASUNTOS_CONTROV() {
        return SUBTOTAL_ASUNTOS_CONTROV;
    }

    public void SetSUBTOTAL_ASUNTOS_CONTROV(String SUBTOTAL_ASUNTOS_CONTROV) {
        this.SUBTOTAL_ASUNTOS_CONTROV = SUBTOTAL_ASUNTOS_CONTROV;
    }

    public String GetCONTROV_NUCLEOS_MENOS20() {
        return CONTROV_NUCLEOS_MENOS20;
    }

    public void SetCONTROV_NUCLEOS_MENOS20(String CONTROV_NUCLEOS_MENOS20) {
        this.CONTROV_NUCLEOS_MENOS20 = CONTROV_NUCLEOS_MENOS20;
    }

    public String GetCONTROV_PROPIE_MENOS20() {
        return CONTROV_PROPIE_MENOS20;
    }

    public void SetCONTROV_PROPIE_MENOS20(String CONTROV_PROPIE_MENOS20) {
        this.CONTROV_PROPIE_MENOS20 = CONTROV_PROPIE_MENOS20;
    }

    public String GetCONTROV_SOCIEDADES_MENOS20() {
        return CONTROV_SOCIEDADES_MENOS20;
    }

    public void SetCONTROV_SOCIEDADES_MENOS20(String CONTROV_SOCIEDADES_MENOS20) {
        this.CONTROV_SOCIEDADES_MENOS20 = CONTROV_SOCIEDADES_MENOS20;
    }

    public String GetCONTROV_NUCLEOS_MAS20() {
        return CONTROV_NUCLEOS_MAS20;
    }

    public void SetCONTROV_NUCLEOS_MAS20(String CONTROV_NUCLEOS_MAS20) {
        this.CONTROV_NUCLEOS_MAS20 = CONTROV_NUCLEOS_MAS20;
    }

    public String GetCONTROV_PROPIE_MAS20() {
        return CONTROV_PROPIE_MAS20;
    }

    public void SetCONTROV_PROPIE_MAS20(String CONTROV_PROPIE_MAS20) {
        this.CONTROV_PROPIE_MAS20 = CONTROV_PROPIE_MAS20;
    }

    public String GetCONTROV_SOCIEDADES_MAS20() {
        return CONTROV_SOCIEDADES_MAS20;
    }

    public void SetCONTROV_SOCIEDADES_MAS20(String CONTROV_SOCIEDADES_MAS20) {
        this.CONTROV_SOCIEDADES_MAS20 = CONTROV_SOCIEDADES_MAS20;
    }

    public String GetSUBTOTAL_ASUNTOS_RESTIT() {
        return SUBTOTAL_ASUNTOS_RESTIT;
    }

    public void SetSUBTOTAL_ASUNTOS_RESTIT(String SUBTOTAL_ASUNTOS_RESTIT) {
        this.SUBTOTAL_ASUNTOS_RESTIT = SUBTOTAL_ASUNTOS_RESTIT;
    }

    public String GetRESTIT_AUTORID_MENOS20() {
        return RESTIT_AUTORID_MENOS20;
    }

    public void SetRESTIT_AUTORID_MENOS20(String RESTIT_AUTORID_MENOS20) {
        this.RESTIT_AUTORID_MENOS20 = RESTIT_AUTORID_MENOS20;
    }

    public String GetRESTIT_PARTIC_MENOS20() {
        return RESTIT_PARTIC_MENOS20;
    }

    public void SetRESTIT_PARTIC_MENOS20(String RESTIT_PARTIC_MENOS20) {
        this.RESTIT_PARTIC_MENOS20 = RESTIT_PARTIC_MENOS20;
    }

    public String GetRESTIT_AUTORID_MAS20() {
        return RESTIT_AUTORID_MAS20;
    }

    public void SetRESTIT_AUTORID_MAS20(String RESTIT_AUTORID_MAS20) {
        this.RESTIT_AUTORID_MAS20 = RESTIT_AUTORID_MAS20;
    }

    public String GetRESTIT_PARTIC_MAS20() {
        return RESTIT_PARTIC_MAS20;
    }

    public void SetRESTIT_PARTIC_MAS20(String RESTIT_PARTIC_MAS20) {
        this.RESTIT_PARTIC_MAS20 = RESTIT_PARTIC_MAS20;
    }

    public String GetSUBTOTAL_RECON() {
        return SUBTOTAL_RECON;
    }

    public void SetSUBTOTAL_RECON(String SUBTOTAL_RECON) {
        this.SUBTOTAL_RECON = SUBTOTAL_RECON;
    }

    public String GetRECON_MENOS20() {
        return RECON_MENOS20;
    }

    public void SetRECON_MENOS20(String RECON_MENOS20) {
        this.RECON_MENOS20 = RECON_MENOS20;
    }

    public String GetRECON_MAS20() {
        return RECON_MAS20;
    }

    public void SetRECON_MAS20(String RECON_MAS20) {
        this.RECON_MAS20 = RECON_MAS20;
    }

    public String GetSUBTOTAL_NULIDADES() {
        return SUBTOTAL_NULIDADES;
    }

    public void SetSUBTOTAL_NULIDADES(String SUBTOTAL_NULIDADES) {
        this.SUBTOTAL_NULIDADES = SUBTOTAL_NULIDADES;
    }

    public String GetNULIDADES_MENOS20() {
        return NULIDADES_MENOS20;
    }

    public void SetNULIDADES_MENOS20(String NULIDADES_MENOS20) {
        this.NULIDADES_MENOS20 = NULIDADES_MENOS20;
    }

    public String GetNULIDADES_MAS20() {
        return NULIDADES_MAS20;
    }

    public void SetNULIDADES_MAS20(String NULIDADES_MAS20) {
        this.NULIDADES_MAS20 = NULIDADES_MAS20;
    }

    public String GetSUBTOTAL_TENENCIA() {
        return SUBTOTAL_TENENCIA;
    }

    public void SetSUBTOTAL_TENENCIA(String SUBTOTAL_TENENCIA) {
        this.SUBTOTAL_TENENCIA = SUBTOTAL_TENENCIA;
    }

    public String GetTENENCIA_MENOS20() {
        return TENENCIA_MENOS20;
    }

    public void SetTENENCIA_MENOS20(String TENENCIA_MENOS20) {
        this.TENENCIA_MENOS20 = TENENCIA_MENOS20;
    }

    public String GetTENENCIA_MAS20() {
        return TENENCIA_MAS20;
    }

    public void SetTENENCIA_MAS20(String TENENCIA_MAS20) {
        this.TENENCIA_MAS20 = TENENCIA_MAS20;
    }

    public String GetSUBTOTAL_ASUNTOS_CONTROV_MA() {
        return SUBTOTAL_ASUNTOS_CONTROV_MA;
    }

    public void SetSUBTOTAL_ASUNTOS_CONTROV_MA(String SUBTOTAL_ASUNTOS_CONTROV_MA) {
        this.SUBTOTAL_ASUNTOS_CONTROV_MA = SUBTOTAL_ASUNTOS_CONTROV_MA;
    }

    public String GetCONTROV_MA_EJID_MENOS20() {
        return CONTROV_MA_EJID_MENOS20;
    }

    public void SetCONTROV_MA_EJID_MENOS20(String CONTROV_MA_EJID_MENOS20) {
        this.CONTROV_MA_EJID_MENOS20 = CONTROV_MA_EJID_MENOS20;
    }

    public String GetCONTROV_MA_NUCLEO_MENOS20() {
        return CONTROV_MA_NUCLEO_MENOS20;
    }

    public void SetCONTROV_MA_NUCLEO_MENOS20(String CONTROV_MA_NUCLEO_MENOS20) {
        this.CONTROV_MA_NUCLEO_MENOS20 = CONTROV_MA_NUCLEO_MENOS20;
    }

    public String GetCONTROV_MA_EJID_MASS20() {
        return CONTROV_MA_EJID_MASS20;
    }

    public void SetCONTROV_MA_EJID_MASS20(String CONTROV_MA_EJID_MASS20) {
        this.CONTROV_MA_EJID_MASS20 = CONTROV_MA_EJID_MASS20;
    }

    public String GetCONTROV_MA_NUCLEO_MASS20() {
        return CONTROV_MA_NUCLEO_MASS20;
    }

    public void SetCONTROV_MA_NUCLEO_MASS20(String CONTROV_MA_NUCLEO_MASS20) {
        this.CONTROV_MA_NUCLEO_MASS20 = CONTROV_MA_NUCLEO_MASS20;
    }

    public String GetSUBTOTAL_ASUNTOS_DERECHOS() {
        return SUBTOTAL_ASUNTOS_DERECHOS;
    }

    public void SetSUBTOTAL_ASUNTOS_DERECHOS(String SUBTOTAL_ASUNTOS_DERECHOS) {
        this.SUBTOTAL_ASUNTOS_DERECHOS = SUBTOTAL_ASUNTOS_DERECHOS;
    }

    public String GetDERECHOS_MENOS20() {
        return DERECHOS_MENOS20;
    }

    public void SetDERECHOS_MENOS20(String DERECHOS_MENOS20) {
        this.DERECHOS_MENOS20 = DERECHOS_MENOS20;
    }

    public String GetDERECHOS_MAS20() {
        return DERECHOS_MAS20;
    }

    public void SetDERECHOS_MAS20(String DERECHOS_MAS20) {
        this.DERECHOS_MAS20 = DERECHOS_MAS20;
    }

    public String GetSUBTOTAL_JN() {
        return SUBTOTAL_JN;
    }

    public void SetSUBTOTAL_JN(String SUBTOTAL_JN) {
        this.SUBTOTAL_JN = SUBTOTAL_JN;
    }

    public String GetJN_PROMOVIDOS_MENOS20() {
        return JN_PROMOVIDOS_MENOS20;
    }

    public void SetJN_PROMOVIDOS_MENOS20(String JN_PROMOVIDOS_MENOS20) {
        this.JN_PROMOVIDOS_MENOS20 = JN_PROMOVIDOS_MENOS20;
    }

    public String GetJN_ACTOS_MENOS20() {
        return JN_ACTOS_MENOS20;
    }

    public void SetJN_ACTOS_MENOS20(String JN_ACTOS_MENOS20) {
        this.JN_ACTOS_MENOS20 = JN_ACTOS_MENOS20;
    }

    public String GetJN_PROMOVIDOS_MAS20() {
        return JN_PROMOVIDOS_MAS20;
    }

    public void SetJN_PROMOVIDOS_MAS20(String JN_PROMOVIDOS_MAS20) {
        this.JN_PROMOVIDOS_MAS20 = JN_PROMOVIDOS_MAS20;
    }

    public String GetJN_ACTOS_MAS20() {
        return JN_ACTOS_MAS20;
    }

    public void SetJN_ACTOS_MAS20(String JN_ACTOS_MAS20) {
        this.JN_ACTOS_MAS20 = JN_ACTOS_MAS20;
    }

    public String GetSUBTOTAL_OMISIONES() {
        return SUBTOTAL_OMISIONES;
    }

    public void SetSUBTOTAL_OMISIONES(String SUBTOTAL_OMISIONES) {
        this.SUBTOTAL_OMISIONES = SUBTOTAL_OMISIONES;
    }

    public String GetOMISIONES_MENOS20() {
        return OMISIONES_MENOS20;
    }

    public void SetOMISIONES_MENOS20(String OMISIONES_MENOS20) {
        this.OMISIONES_MENOS20 = OMISIONES_MENOS20;
    }

    public String GetOMISIONES_MAS20() {
        return OMISIONES_MAS20;
    }

    public void SetOMISIONES_MAS20(String OMISIONES_MAS20) {
        this.OMISIONES_MAS20 = OMISIONES_MAS20;
    }

    public String GetSUBTOTAL_ASUNTOS_JV() {
        return SUBTOTAL_ASUNTOS_JV;
    }

    public void SetSUBTOTAL_ASUNTOS_JV(String SUBTOTAL_ASUNTOS_JV) {
        this.SUBTOTAL_ASUNTOS_JV = SUBTOTAL_ASUNTOS_JV;
    }

    public String GetJV_MENOS20() {
        return JV_MENOS20;
    }

    public void SetJV_MENOS20(String JV_MENOS20) {
        this.JV_MENOS20 = JV_MENOS20;
    }

    public String GetJV_MAS20() {
        return JV_MAS20;
    }

    public void SetJV_MAS20(String JV_MAS20) {
        this.JV_MAS20 = JV_MAS20;
    }

    public String GetSUBTOTAL_CONTROV_TERR() {
        return SUBTOTAL_CONTROV_TERR;
    }

    public void SetSUBTOTAL_CONTROV_TERR(String SUBTOTAL_CONTROV_TERR) {
        this.SUBTOTAL_CONTROV_TERR = SUBTOTAL_CONTROV_TERR;
    }

    public String GetCONTROV_TERR_MENOS20() {
        return CONTROV_TERR_MENOS20;
    }

    public void SetCONTROV_TERR_MENOS20(String CONTROV_TERR_MENOS20) {
        this.CONTROV_TERR_MENOS20 = CONTROV_TERR_MENOS20;
    }

    public String GetCONTROV_TERR_MAS20() {
        return CONTROV_TERR_MAS20;
    }

    public void SetCONTROV_TERR_MAS20(String CONTROV_TERR_MAS20) {
        this.CONTROV_TERR_MAS20 = CONTROV_TERR_MAS20;
    }

    public String GetSUBTOTAL_REVERSION() {
        return SUBTOTAL_REVERSION;
    }

    public void SetSUBTOTAL_REVERSION(String SUBTOTAL_REVERSION) {
        this.SUBTOTAL_REVERSION = SUBTOTAL_REVERSION;
    }

    public String GetREVERSION_MENOS20() {
        return REVERSION_MENOS20;
    }

    public void SetREVERSION_MENOS20(String REVERSION_MENOS20) {
        this.REVERSION_MENOS20 = REVERSION_MENOS20;
    }

    public String GetREVERSION_MAS20() {
        return REVERSION_MAS20;
    }

    public void SetREVERSION_MAS20(String REVERSION_MAS20) {
        this.REVERSION_MAS20 = REVERSION_MAS20;
    }

    public String GetSUBTOTAL_EJECUCION() {
        return SUBTOTAL_EJECUCION;
    }

    public void SetSUBTOTAL_EJECUCION(String SUBTOTAL_EJECUCION) {
        this.SUBTOTAL_EJECUCION = SUBTOTAL_EJECUCION;
    }

    public String GetEJECUCION_CONVENIOS_MENOS20() {
        return EJECUCION_CONVENIOS_MENOS20;
    }

    public void SetEJECUCION_CONVENIOS_MENOS20(String EJECUCION_CONVENIOS_MENOS20) {
        this.EJECUCION_CONVENIOS_MENOS20 = EJECUCION_CONVENIOS_MENOS20;
    }

    public String GetEJECUCION_LAUDOS_MENOS20() {
        return EJECUCION_LAUDOS_MENOS20;
    }

    public void SetEJECUCION_LAUDOS_MENOS20(String EJECUCION_LAUDOS_MENOS20) {
        this.EJECUCION_LAUDOS_MENOS20 = EJECUCION_LAUDOS_MENOS20;
    }

    public String GetEJECUCION_CONVENIOS_MAS20() {
        return EJECUCION_CONVENIOS_MAS20;
    }

    public void SetEJECUCION_CONVENIOS_MAS20(String EJECUCION_CONVENIOS_MAS20) {
        this.EJECUCION_CONVENIOS_MAS20 = EJECUCION_CONVENIOS_MAS20;
    }

    public String GetEJECUCION_LAUDOS_MAS20() {
        return EJECUCION_LAUDOS_MAS20;
    }

    public void SetEJECUCION_LAUDOS_MAS20(String EJECUCION_LAUDOS_MAS20) {
        this.EJECUCION_LAUDOS_MAS20 = EJECUCION_LAUDOS_MAS20;
    }

    public String GetSUBTOTAL_ASUNTOS_RRT() {
        return SUBTOTAL_ASUNTOS_RRT;
    }

    public void SetSUBTOTAL_ASUNTOS_RRT(String SUBTOTAL_ASUNTOS_RRT) {
        this.SUBTOTAL_ASUNTOS_RRT = SUBTOTAL_ASUNTOS_RRT;
    }

    public String GetRRT_MENOS20() {
        return RRT_MENOS20;
    }

    public void SetRRT_MENOS20(String RRT_MENOS20) {
        this.RRT_MENOS20 = RRT_MENOS20;
    }

    public String GetRRT_MAS20() {
        return RRT_MAS20;
    }

    public void SetRRT_MAS20(String RRT_MAS20) {
        this.RRT_MAS20 = RRT_MAS20;
    }

    public String GetSUBTOTAL_ASUNTOS_DA() {
        return SUBTOTAL_ASUNTOS_DA;
    }

    public void SetSUBTOTAL_ASUNTOS_DA(String SUBTOTAL_ASUNTOS_DA) {
        this.SUBTOTAL_ASUNTOS_DA = SUBTOTAL_ASUNTOS_DA;
    }

    public String GetDA_MENOS20() {
        return DA_MENOS20;
    }

    public void SetDA_MENOS20(String DA_MENOS20) {
        this.DA_MENOS20 = DA_MENOS20;
    }

    public String GetDA_MAS20() {
        return DA_MAS20;
    }

    public void SetDA_MAS20(String DA_MAS20) {
        this.DA_MAS20 = DA_MAS20;
    }

    public String GetSUBTOTAL_ASUNTOS_INCONFOR() {
        return SUBTOTAL_ASUNTOS_INCONFOR;
    }

    public void SetSUBTOTAL_ASUNTOS_INCONFOR(String SUBTOTAL_ASUNTOS_INCONFOR) {
        this.SUBTOTAL_ASUNTOS_INCONFOR = SUBTOTAL_ASUNTOS_INCONFOR;
    }

    public String GetINCONFOR_MENOS20() {
        return INCONFOR_MENOS20;
    }

    public void SetINCONFOR_MENOS20(String INCONFOR_MENOS20) {
        this.INCONFOR_MENOS20 = INCONFOR_MENOS20;
    }

    public String GetINCONFOR_MAS20() {
        return INCONFOR_MAS20;
    }

    public void SetINCONFOR_MAS20(String INCONFOR_MAS20) {
        this.INCONFOR_MAS20 = INCONFOR_MAS20;
    }

    public String GetSUBTOTAL_ASUNTOS_LA() {
        return SUBTOTAL_ASUNTOS_LA;
    }

    public void SetSUBTOTAL_ASUNTOS_LA(String SUBTOTAL_ASUNTOS_LA) {
        this.SUBTOTAL_ASUNTOS_LA = SUBTOTAL_ASUNTOS_LA;
    }

    public String GetLA_MENOS20() {
        return LA_MENOS20;
    }

    public void SetLA_MENOS20(String LA_MENOS20) {
        this.LA_MENOS20 = LA_MENOS20;
    }

    public String GetLA_MAS20() {
        return LA_MAS20;
    }

    public void SetLA_MAS20(String LA_MAS20) {
        this.LA_MAS20 = LA_MAS20;
    }

    public String GetSUBTOTAL_OTROS_ASUNTOS() {
        return SUBTOTAL_OTROS_ASUNTOS;
    }

    public void SetSUBTOTAL_OTROS_ASUNTOS(String SUBTOTAL_OTROS_ASUNTOS) {
        this.SUBTOTAL_OTROS_ASUNTOS = SUBTOTAL_OTROS_ASUNTOS;
    }

    public String GetOTROS_ASUNTOS_MENOS20() {
        return OTROS_ASUNTOS_MENOS20;
    }

    public void SetOTROS_ASUNTOS_MENOS20(String OTROS_ASUNTOS_MENOS20) {
        this.OTROS_ASUNTOS_MENOS20 = OTROS_ASUNTOS_MENOS20;
    }

    public String GetOTROS_ASUNTOS_MAS20() {
        return OTROS_ASUNTOS_MAS20;
    }

    public void SetOTROS_ASUNTOS_MAS20(String OTROS_ASUNTOS_MAS20) {
        this.OTROS_ASUNTOS_MAS20 = OTROS_ASUNTOS_MAS20;
    }

    public String GetTOTAL_ASUNTOS() {
        return TOTAL_ASUNTOS;
    }

    public void SetTOTAL_ASUNTOS(String TOTAL_ASUNTOS) {
        this.TOTAL_ASUNTOS = TOTAL_ASUNTOS;
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
            GetNOMBRE_ORGANO_JURI(),
            GetCLAVE_ORGANO(),
            GetPERIODO(),
            GetTOTAL_ASUNTOS_PEND(),
            GetASUNTOS_PEND_PREV(),
            GetASUNTOS_PEND_TERM(),
            GetASUNTOS_PEND_ADMI(),
            GetTOTAL_ASUNTOS_INSTRUCCION(),
            GetASUNTOS_JA(),
            GetASUNTOS_JV(),
            GetTOTAL_ASUNTOS_MATERIA(),
            GetSUBTOTAL_ASUNTOS_CONTROV(),
            GetCONTROV_NUCLEOS_MENOS20(),
            GetCONTROV_PROPIE_MENOS20(),
            GetCONTROV_SOCIEDADES_MENOS20(),
            GetCONTROV_NUCLEOS_MAS20(),
            GetCONTROV_PROPIE_MAS20(),
            GetCONTROV_SOCIEDADES_MAS20(),
            GetSUBTOTAL_ASUNTOS_RESTIT(),
            GetRESTIT_AUTORID_MENOS20(),
            GetRESTIT_PARTIC_MENOS20(),
            GetRESTIT_AUTORID_MAS20(),
            GetRESTIT_PARTIC_MAS20(),
            GetSUBTOTAL_RECON(),
            GetRECON_MENOS20(),
            GetRECON_MAS20(),
            GetSUBTOTAL_NULIDADES(),
            GetNULIDADES_MENOS20(),
            GetNULIDADES_MAS20(),
            GetSUBTOTAL_TENENCIA(),
            GetTENENCIA_MENOS20(),
            GetTENENCIA_MAS20(),
            GetSUBTOTAL_ASUNTOS_CONTROV_MA(),
            GetCONTROV_MA_EJID_MENOS20(),
            GetCONTROV_MA_NUCLEO_MENOS20(),
            GetCONTROV_MA_EJID_MASS20(),
            GetCONTROV_MA_NUCLEO_MASS20(),
            GetSUBTOTAL_ASUNTOS_DERECHOS(),
            GetDERECHOS_MENOS20(),
            GetDERECHOS_MAS20(),
            GetSUBTOTAL_JN(),
            GetJN_PROMOVIDOS_MENOS20(),
            GetJN_ACTOS_MENOS20(),
            GetJN_PROMOVIDOS_MAS20(),
            GetJN_ACTOS_MAS20(),
            GetSUBTOTAL_OMISIONES(),
            GetOMISIONES_MENOS20(),
            GetOMISIONES_MAS20(),
            GetSUBTOTAL_ASUNTOS_JV(),
            GetJV_MENOS20(),
            GetJV_MAS20(),
            GetSUBTOTAL_CONTROV_TERR(),
            GetCONTROV_TERR_MENOS20(),
            GetCONTROV_TERR_MAS20(),
            GetSUBTOTAL_REVERSION(),
            GetREVERSION_MENOS20(),
            GetREVERSION_MAS20(),
            GetSUBTOTAL_EJECUCION(),
            GetEJECUCION_CONVENIOS_MENOS20(),
            GetEJECUCION_LAUDOS_MENOS20(),
            GetEJECUCION_CONVENIOS_MAS20(),
            GetEJECUCION_LAUDOS_MAS20(),
            GetSUBTOTAL_ASUNTOS_RRT(),
            GetRRT_MENOS20(),
            GetRRT_MAS20(),
            GetSUBTOTAL_ASUNTOS_DA(),
            GetDA_MENOS20(),
            GetDA_MAS20(),
            GetSUBTOTAL_ASUNTOS_INCONFOR(),
            GetINCONFOR_MENOS20(),
            GetINCONFOR_MAS20(),
            GetSUBTOTAL_ASUNTOS_LA(),
            GetLA_MENOS20(),
            GetLA_MAS20(),
            GetSUBTOTAL_OTROS_ASUNTOS(),
            GetOTROS_ASUNTOS_MENOS20(),
            GetOTROS_ASUNTOS_MAS20(),
            GetTOTAL_ASUNTOS(),
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
