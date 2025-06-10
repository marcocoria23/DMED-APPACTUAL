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
public class BeanTR_JA_CONCLUSIONES extends Bean implements SQLData {

    private String SQLTypeName;
   private String NOMBRE_ORGANO_JURIS;
private String CLAVE_ORGANO;
private String PERIODO;
private String TOTAL_RESOLUCIONES;
private String SENTENCIAS_DEF;
private String SENTENCIAS_CUMPL_EJEC;
private String SENTENCIAS_CUMP_RR;
private String LAUDOS;
private String CONVENIOS;
private String DESISTIMIENTOS;
private String CADUCIDADES;
private String JURISDICCION_VOLUNTARIA;
private String OTRO_RESOL;
private String SD_TOTAL_SENTENCIAS;
private String SD_SUB_CONTROV_TERR;
private String SD_CONTROV_TERR_NUC;
private String SD_CONTROV_TERR_PROPIE;
private String SD_CONTROV_TERR_SOCI;
private String SD_CONTROV_TERR_POB_EJIDAL;
private String SD_SUBTOTAL_ASUNTOS_RESTIT;
private String SD_RESTIT_AUTORID;
private String SD_RESTIT_PARTIC;
private String SD_RECON;
private String SD_NULIDADES;
private String SD_TENENCIA;
private String SD_SUB_ASUNTOS_CON_MA;
private String SD_CONTROV_MA_EJID;
private String SD_CONTROV_MA_NUCLEO;
private String SD_SUCESION_DA;
private String SD_SUBTOTAL_JN;
private String SD_JN_PROMOVIDOS;
private String SD_JN_ACTOS;
private String SD_OMISIONES;
private String SD_CONTROV_TERR;
private String SD_REVERSION;
private String SD_SUBTOTAL_EJECUCION;
private String SD_EJECUCION_CONVENIOS;
private String SD_EJECUCION_LAUDOS;
private String SD_RRT;
private String SD_PRIVACION;
private String SD_INCONFORMIDADES;
private String SD_ASUNTOS_LEGIS;
private String SD_OTROS_ASUNTOS;
private String SCE_TOTAL_SENTENCIAS;
private String SCE_SUBTOTAL_CON_TERR;
private String SCE_CONTROV_TERR_NUCLEO;
private String SCE_CONTROV_TERR_PROPIE;
private String SCE_CONTROV_TERR_SOCIEDADE;
private String SCE_CONTROV_TERR_POB_EJIDAL;
private String SCE_SUBTOTAL_ASUNTOS_RESTIT;
private String SCE_RESTIT_AUTORID;
private String SCE_RESTIT_PARTIC;
private String SCE_RECON;
private String SCE_NULIDADES;
private String SCE_TENENCIA;
private String SCE_SUB_ASUNTOS_CONT_MA;
private String SCE_CONTROV_MA_EJID;
private String SCE_CONTROV_MA_NUCLEO;
private String SCE_SUCESION_DA;
private String SCE_SUBTOTAL_JN;
private String SCE_JN_PROMOVIDOS;
private String SCE_JN_ACTOS;
private String SCE_OMISIONES;
private String SCE_ASUNTOS_JV;
private String SCE_CONTROV_TERR;
private String SCE_REVERSION;
private String SCE_SUBTOTAL_EJECUCION;
private String SCE_EJECUCION_CONVENIOS;
private String SCE_EJECUCION_LAUDOS;
private String SCE_RRT;
private String SCE_PRIVACION;
private String SCE_INCONFORMIDADES;
private String SCE_ASUNTOS_LEGIS;
private String SCE_OTROS_ASUNTOS;
private String SCR_TOTAL_SENTENCIAS;
private String SCR_SUBTOTAL_CONTROV_TERR;
private String SCR_CONTROV_TERR_NUCLEO;
private String SCR_CONTROV_TERR_PROPIE;
private String SCR_CONTROV_TERR_SOCIEDADE;
private String SCR_CONTROV_TERR_POB_EJIDAL;
private String SCR_SUBTOTAL_ASUNTOS_RESTIT;
private String SCR_RESTIT_AUTORID;
private String SCR_RESTIT_PARTIC;
private String SCR_RECON;
private String SCR_NULIDADES;
private String SCR_TENENCIA;
private String SCR_SUB_ASUNTOS_CONT_MA;
private String SCR_CONTROV_MA_EJID;
private String SCR_CONTROV_MA_NUCLEO;
private String SCR_SUCESION_DA;
private String SCR_SUBTOTAL_JN;
private String SCR_JN_PROMOVIDOS;
private String SCR_JN_ACTOS;
private String SCR_OMISIONES;
private String SCR_ASUNTOS_JV;
private String SCR_CONTROV_TERR;
private String SCR_REVERSION;
private String SCR_SUBTOTAL_EJECUCION;
private String SCR_EJECUCION_CONVENIOS;
private String SCR_EJECUCION_LAUDOS;
private String SCR_RRT;
private String SCR_PRIVACION;
private String SCR_INCONFORMIDADES;
private String SCR_ASUNTOS_LEGIS;
private String SCR_OTROS_ASUNTOS;
private String LH_TOTAL_LAUDOS;
private String LH_SUBTOTAL_CONTROV_TERR;
private String LH_CONTROV_TERR_NUCLEO;
private String LH_CONTROV_TERR_PROPIE;
private String LH_CONTROV_TERR_SOCIEDADE;
private String LH_CONTROV_TERR_POB_EJIDAL;
private String LH_SUBTOTAL_ASUNTOS_RESTIT;
private String LH_RESTIT_AUTORID;
private String LH_RESTIT_PARTIC;
private String LH_RECON;
private String LH_NULIDADES;
private String LH_TENENCIA;
private String LH_SUB_ASUNTOS_CONT_MA;
private String LH_CONTROV_MA_EJID;
private String LH_CONTROV_MA_NUCLEO;
private String LH_SUCESION_DA;
private String LH_SUBTOTAL_JN;
private String LH_JN_PROMOVIDOS;
private String LH_JN_ACTOS;
private String LH_OMISIONES;
private String LH_CONTROV_TERR;
private String LH_REVERSION;
private String LH_SUBTOTAL_EJECUCION;
private String LH_EJECUCION_CONVENIOS;
private String LH_EJECUCION_LAUDOS;
private String LH_RRT;
private String LH_PRIVACION;
private String LH_INCONFORMIDADES;
private String LH_ASUNTOS_LEGIS;
private String LH_OTROS_ASUNTOS;
private String CSS_TOTAL_CONVENIOS;
private String CSS_SUBTOTAL_CONTROV_TERR;
private String CSS_CONTROV_TERR_NUCLEO;
private String CSS_CONTROV_TERR_PROPIE;
private String CSS_CONTROV_TERR_SOCIEDADE;
private String CSS_CONTROV_TERR_POB_EJIDAL;
private String CSS_SUBTOTAL_ASUNTOS_RESTIT;
private String CSS_RESTIT_AUTORID;
private String CSS_RESTIT_PARTIC;
private String CSS_RECON;
private String CSS_NULIDADES;
private String CSS_TENENCIA;
private String CSS_SUB_ASUNTOS_CONT_MA;
private String CSS_CONTROV_MA_EJID;
private String CSS_CONTROV_MA_NUCLEO;
private String CSS_SUCESION_DA;
private String CSS_SUBTOTAL_JN_;
private String CSS_JN_PROMOVIDOS;
private String CSS_JN_ACTOS;
private String CSS_OMISIONES;
private String CSS_ASUNTOS_JV;
private String CSS_CONTROV_TERR;
private String CSS_REVERSION;
private String CSS_SUBTOTAL_EJECUCION;
private String CSS_EJECUCION_CONVENIOS;
private String CSS_EJECUCION_LAUDOS;
private String CSS_RRT;
private String CSS_PRIVACION;
private String CSS_INCONFORMIDADES;
private String CSS_ASUNTOS_LEGIS;
private String CSS_OTROS_ASUNTOS;
private String DES_TOTAL_DESMENTIMIENTOS;
private String DES_SUBTOTAL_CONTROV_TERR;
private String DES_CONTROV_TERR_NUCLEO;
private String DES_CONTROV_TERR_PROPIE;
private String DES_CONTROV_TERR_SOCIEDADE;
private String DES_CONTROV_TERR_POB_EJIDAL;
private String DES_SUBTOTAL_ASUNTOS_RESTIT;
private String DES_RESTIT_AUTORID;
private String DES_RESTIT_PARTIC;
private String DES_RECON;
private String DES_NULIDADES;
private String DES_TENENCIA;
private String DES_SUB_ASUNTOS_CONT_MA;
private String DES_CONTROV_MA_EJID;
private String DES_CONTROV_MA_NUCLEO;
private String DES_SUCESION_DA;
private String DES_SUBTOTAL_JN;
private String DES_JN_PROMOVIDOS;
private String DES_JN_ACTOS;
private String DES_OMISIONES;
private String DES_ASUNTOS_JV;
private String DES_CONTROV_TERR;
private String DES_REVERSION;
private String DES_SUBTOTAL_EJECUCION;
private String DES_EJECUCION_CONVENIOS;
private String DES_EJECUCION_LAUDOS;
private String DES_RRT;
private String DES_PRIVACION;
private String DES_INCONFORMIDADES;
private String DES_ASUNTOS_LEGIS;
private String DES_OTROS_ASUNTOS;
private String CAD_TOTAL_CADUCIDADES;
private String CAD_SUBTOTAL_CONTROV_TERR;
private String CAD_CONTROV_TERR_NUCLEO;
private String CAD_CONTROV_TERR_PROPIE;
private String CAD_CONTROV_TERR_SOCIEDADE;
private String CAD_CONTROV_TERR_POB_EJIDAL;
private String CAD_SUBTOTAL_ASUNTOS_RESTIT;
private String CAD_RESTIT_AUTORID;
private String CAD_RESTIT_PARTIC;
private String CAD_RECON;
private String CAD_NULIDADES;
private String CAD_TENENCIA;
private String CAD_SUB_ASUNTOS_CONT_MA;
private String CAD_CONTROV_MA_EJID;
private String CAD_CONTROV_MA_NUCLEO;
private String CAD_SUCESION_DA;
private String CAD_SUBTOTAL_JN;
private String CAD_JN_PROMOVIDOS;
private String CAD_JN_ACTOS;
private String CAD_OMISIONES;
private String CAD_ASUNTOS_JV;
private String CAD_CONTROV_TERR;
private String CAD_REVERSION;
private String CAD_SUBTOTAL_EJECUCION;
private String CAD_EJECUCION_CONVENIOS;
private String CAD_EJECUCION_LAUDOS;
private String CAD_RRT;
private String CAD_PRIVACION;
private String CAD_INCONFORMIDADES;
private String CAD_ASUNTOS_LEGIS;
private String CAD_OTROS_ASUNTOS;
private String OTRO_TOTAL_OTRO_TIPO;
private String OTRO_SUBTOTAL_CONTROV_TERR;
private String OTRO_CONTROV_TERR_NUCLEO;
private String OTRO_CONTROV_TERR_PROPIE;
private String OTRO_CONTROV_TERR_SOCIEDADE;
private String OTRO_CONTROV_POB_EJIDAL;
private String OTRO_SUBTOTAL_ASUNTOS_RESTIT;
private String OTRO_RESTIT_AUTORID;
private String OTRO_RESTIT_PARTIC;
private String OTRO_RECON;
private String OTRO_NULIDADES;
private String OTRO_TENENCIA;
private String OTRO_SUB_ASUNTOS_CONT_MA;
private String OTRO_CONTROV_MA_EJID;
private String OTRO_CONTROV_MA_NUCLEO;
private String OTRO_SUCESION_DA;
private String OTRO_SUBTOTAL_JN;
private String OTRO_JN_PROMOVIDOS;
private String OTRO_JN_ACTOS;
private String OTRO_OMISIONES;
private String OTRO_ASUNTOS_JV;
private String OTRO_CONTROV_TERR;
private String OTRO_REVERSION;
private String OTRO_SUBTOTAL_EJECUCION;
private String OTRO_EJECUCION_CONVENIOS;
private String OTRO_EJECUCION_LAUDOS;
private String OTRO_RRT;
private String OTRO_PRIVACION;
private String OTRO_INCONFORMIDADES;
private String OTRO_ASUNTOS_LEGIS;
private String OTRO_OTROS_ASUNTOS;
private String SD_TOTAL_ESTAT;
private String SD_ESTAT_NOTIFICAR;
private String SD_ESTAT_TRANSCURSO;
private String SD_ESTAT_IMPUGN_RR;
private String SD_ESTAT_IMPUGN_JA;
private String SD_ESTAT_EJECUCION;
private String SDE_TOTAL_TIPO;
private String SDE_EJECUCION;
private String SDE_CONVENIOS;
private String TOTAL_ASUNTOS_CONCL;
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
public String GetTOTAL_RESOLUCIONES() {
        return TOTAL_RESOLUCIONES;
    }

    public void SetTOTAL_RESOLUCIONES(String TOTAL_RESOLUCIONES) {
        this.TOTAL_RESOLUCIONES = TOTAL_RESOLUCIONES;
    }
public String GetSENTENCIAS_DEF() {
        return SENTENCIAS_DEF;
    }

    public void SetSENTENCIAS_DEF(String SENTENCIAS_DEF) {
        this.SENTENCIAS_DEF = SENTENCIAS_DEF;
    }
public String GetSENTENCIAS_CUMPL_EJEC() {
        return SENTENCIAS_CUMPL_EJEC;
    }

    public void SetSENTENCIAS_CUMPL_EJEC(String SENTENCIAS_CUMPL_EJEC) {
        this.SENTENCIAS_CUMPL_EJEC = SENTENCIAS_CUMPL_EJEC;
    }
public String GetSENTENCIAS_CUMP_RR() {
        return SENTENCIAS_CUMP_RR;
    }

    public void SetSENTENCIAS_CUMP_RR(String SENTENCIAS_CUMP_RR) {
        this.SENTENCIAS_CUMP_RR = SENTENCIAS_CUMP_RR;
    }
public String GetLAUDOS() {
        return LAUDOS;
    }

    public void SetLAUDOS(String LAUDOS) {
        this.LAUDOS = LAUDOS;
    }
public String GetCONVENIOS() {
        return CONVENIOS;
    }

    public void SetCONVENIOS(String CONVENIOS) {
        this.CONVENIOS = CONVENIOS;
    }
public String GetDESISTIMIENTOS() {
        return DESISTIMIENTOS;
    }

    public void SetDESISTIMIENTOS(String DESISTIMIENTOS) {
        this.DESISTIMIENTOS = DESISTIMIENTOS;
    }
public String GetCADUCIDADES() {
        return CADUCIDADES;
    }

    public void SetCADUCIDADES(String CADUCIDADES) {
        this.CADUCIDADES = CADUCIDADES;
    }
public String GetJURISDICCION_VOLUNTARIA() {
        return JURISDICCION_VOLUNTARIA;
    }

    public void SetJURISDICCION_VOLUNTARIA(String JURISDICCION_VOLUNTARIA) {
        this.JURISDICCION_VOLUNTARIA = JURISDICCION_VOLUNTARIA;
    }
public String GetOTRO_RESOL() {
        return OTRO_RESOL;
    }

    public void SetOTRO_RESOL(String OTRO_RESOL) {
        this.OTRO_RESOL = OTRO_RESOL;
    }
public String GetSD_TOTAL_SENTENCIAS() {
        return SD_TOTAL_SENTENCIAS;
    }

    public void SetSD_TOTAL_SENTENCIAS(String SD_TOTAL_SENTENCIAS) {
        this.SD_TOTAL_SENTENCIAS = SD_TOTAL_SENTENCIAS;
    }
public String GetSD_SUB_CONTROV_TERR() {
        return SD_SUB_CONTROV_TERR;
    }

    public void SetSD_SUB_CONTROV_TERR(String SD_SUB_CONTROV_TERR) {
        this.SD_SUB_CONTROV_TERR = SD_SUB_CONTROV_TERR;
    }
public String GetSD_CONTROV_TERR_NUC() {
        return SD_CONTROV_TERR_NUC;
    }

    public void SetSD_CONTROV_TERR_NUC(String SD_CONTROV_TERR_NUC) {
        this.SD_CONTROV_TERR_NUC = SD_CONTROV_TERR_NUC;
    }
public String GetSD_CONTROV_TERR_PROPIE() {
        return SD_CONTROV_TERR_PROPIE;
    }

    public void SetSD_CONTROV_TERR_PROPIE(String SD_CONTROV_TERR_PROPIE) {
        this.SD_CONTROV_TERR_PROPIE = SD_CONTROV_TERR_PROPIE;
    }
public String GetSD_CONTROV_TERR_SOCI() {
        return SD_CONTROV_TERR_SOCI;
    }

    public void SetSD_CONTROV_TERR_SOCI(String SD_CONTROV_TERR_SOCI) {
        this.SD_CONTROV_TERR_SOCI = SD_CONTROV_TERR_SOCI;
    }
public String GetSD_CONTROV_TERR_POB_EJIDAL() {
        return SD_CONTROV_TERR_POB_EJIDAL;
    }

    public void SetSD_CONTROV_TERR_POB_EJIDAL(String SD_CONTROV_TERR_POB_EJIDAL) {
        this.SD_CONTROV_TERR_POB_EJIDAL = SD_CONTROV_TERR_POB_EJIDAL;
    }
public String GetSD_SUBTOTAL_ASUNTOS_RESTIT() {
        return SD_SUBTOTAL_ASUNTOS_RESTIT;
    }

    public void SetSD_SUBTOTAL_ASUNTOS_RESTIT(String SD_SUBTOTAL_ASUNTOS_RESTIT) {
        this.SD_SUBTOTAL_ASUNTOS_RESTIT = SD_SUBTOTAL_ASUNTOS_RESTIT;
    }
public String GetSD_RESTIT_AUTORID() {
        return SD_RESTIT_AUTORID;
    }

    public void SetSD_RESTIT_AUTORID(String SD_RESTIT_AUTORID) {
        this.SD_RESTIT_AUTORID = SD_RESTIT_AUTORID;
    }
public String GetSD_RESTIT_PARTIC() {
        return SD_RESTIT_PARTIC;
    }

    public void SetSD_RESTIT_PARTIC(String SD_RESTIT_PARTIC) {
        this.SD_RESTIT_PARTIC = SD_RESTIT_PARTIC;
    }
public String GetSD_RECON() {
        return SD_RECON;
    }

    public void SetSD_RECON(String SD_RECON) {
        this.SD_RECON = SD_RECON;
    }
public String GetSD_NULIDADES() {
        return SD_NULIDADES;
    }

    public void SetSD_NULIDADES(String SD_NULIDADES) {
        this.SD_NULIDADES = SD_NULIDADES;
    }
public String GetSD_TENENCIA() {
        return SD_TENENCIA;
    }

    public void SetSD_TENENCIA(String SD_TENENCIA) {
        this.SD_TENENCIA = SD_TENENCIA;
    }
public String GetSD_SUB_ASUNTOS_CON_MA() {
        return SD_SUB_ASUNTOS_CON_MA;
    }

    public void SetSD_SUB_ASUNTOS_CON_MA(String SD_SUB_ASUNTOS_CON_MA) {
        this.SD_SUB_ASUNTOS_CON_MA = SD_SUB_ASUNTOS_CON_MA;
    }
public String GetSD_CONTROV_MA_EJID() {
        return SD_CONTROV_MA_EJID;
    }

    public void SetSD_CONTROV_MA_EJID(String SD_CONTROV_MA_EJID) {
        this.SD_CONTROV_MA_EJID = SD_CONTROV_MA_EJID;
    }
public String GetSD_CONTROV_MA_NUCLEO() {
        return SD_CONTROV_MA_NUCLEO;
    }

    public void SetSD_CONTROV_MA_NUCLEO(String SD_CONTROV_MA_NUCLEO) {
        this.SD_CONTROV_MA_NUCLEO = SD_CONTROV_MA_NUCLEO;
    }
public String GetSD_SUCESION_DA() {
        return SD_SUCESION_DA;
    }

    public void SetSD_SUCESION_DA(String SD_SUCESION_DA) {
        this.SD_SUCESION_DA = SD_SUCESION_DA;
    }
public String GetSD_SUBTOTAL_JN() {
        return SD_SUBTOTAL_JN;
    }

    public void SetSD_SUBTOTAL_JN(String SD_SUBTOTAL_JN) {
        this.SD_SUBTOTAL_JN = SD_SUBTOTAL_JN;
    }
public String GetSD_JN_PROMOVIDOS() {
        return SD_JN_PROMOVIDOS;
    }

    public void SetSD_JN_PROMOVIDOS(String SD_JN_PROMOVIDOS) {
        this.SD_JN_PROMOVIDOS = SD_JN_PROMOVIDOS;
    }
public String GetSD_JN_ACTOS() {
        return SD_JN_ACTOS;
    }

    public void SetSD_JN_ACTOS(String SD_JN_ACTOS) {
        this.SD_JN_ACTOS = SD_JN_ACTOS;
    }
public String GetSD_OMISIONES() {
        return SD_OMISIONES;
    }

    public void SetSD_OMISIONES(String SD_OMISIONES) {
        this.SD_OMISIONES = SD_OMISIONES;
    }
public String GetSD_CONTROV_TERR() {
        return SD_CONTROV_TERR;
    }

    public void SetSD_CONTROV_TERR(String SD_CONTROV_TERR) {
        this.SD_CONTROV_TERR = SD_CONTROV_TERR;
    }
public String GetSD_REVERSION() {
        return SD_REVERSION;
    }

    public void SetSD_REVERSION(String SD_REVERSION) {
        this.SD_REVERSION = SD_REVERSION;
    }
public String GetSD_SUBTOTAL_EJECUCION() {
        return SD_SUBTOTAL_EJECUCION;
    }

    public void SetSD_SUBTOTAL_EJECUCION(String SD_SUBTOTAL_EJECUCION) {
        this.SD_SUBTOTAL_EJECUCION = SD_SUBTOTAL_EJECUCION;
    }
public String GetSD_EJECUCION_CONVENIOS() {
        return SD_EJECUCION_CONVENIOS;
    }

    public void SetSD_EJECUCION_CONVENIOS(String SD_EJECUCION_CONVENIOS) {
        this.SD_EJECUCION_CONVENIOS = SD_EJECUCION_CONVENIOS;
    }
public String GetSD_EJECUCION_LAUDOS() {
        return SD_EJECUCION_LAUDOS;
    }

    public void SetSD_EJECUCION_LAUDOS(String SD_EJECUCION_LAUDOS) {
        this.SD_EJECUCION_LAUDOS = SD_EJECUCION_LAUDOS;
    }
public String GetSD_RRT() {
        return SD_RRT;
    }

    public void SetSD_RRT(String SD_RRT) {
        this.SD_RRT = SD_RRT;
    }
public String GetSD_PRIVACION() {
        return SD_PRIVACION;
    }

    public void SetSD_PRIVACION(String SD_PRIVACION) {
        this.SD_PRIVACION = SD_PRIVACION;
    }
public String GetSD_INCONFORMIDADES() {
        return SD_INCONFORMIDADES;
    }

    public void SetSD_INCONFORMIDADES(String SD_INCONFORMIDADES) {
        this.SD_INCONFORMIDADES = SD_INCONFORMIDADES;
    }
public String GetSD_ASUNTOS_LEGIS() {
        return SD_ASUNTOS_LEGIS;
    }

    public void SetSD_ASUNTOS_LEGIS(String SD_ASUNTOS_LEGIS) {
        this.SD_ASUNTOS_LEGIS = SD_ASUNTOS_LEGIS;
    }
public String GetSD_OTROS_ASUNTOS() {
        return SD_OTROS_ASUNTOS;
    }

    public void SetSD_OTROS_ASUNTOS(String SD_OTROS_ASUNTOS) {
        this.SD_OTROS_ASUNTOS = SD_OTROS_ASUNTOS;
    }
public String GetSCE_TOTAL_SENTENCIAS() {
        return SCE_TOTAL_SENTENCIAS;
    }

    public void SetSCE_TOTAL_SENTENCIAS(String SCE_TOTAL_SENTENCIAS) {
        this.SCE_TOTAL_SENTENCIAS = SCE_TOTAL_SENTENCIAS;
    }
public String GetSCE_SUBTOTAL_CON_TERR() {
        return SCE_SUBTOTAL_CON_TERR;
    }

    public void SetSCE_SUBTOTAL_CON_TERR(String SCE_SUBTOTAL_CON_TERR) {
        this.SCE_SUBTOTAL_CON_TERR = SCE_SUBTOTAL_CON_TERR;
    }
public String GetSCE_CONTROV_TERR_NUCLEO() {
        return SCE_CONTROV_TERR_NUCLEO;
    }

    public void SetSCE_CONTROV_TERR_NUCLEO(String SCE_CONTROV_TERR_NUCLEO) {
        this.SCE_CONTROV_TERR_NUCLEO = SCE_CONTROV_TERR_NUCLEO;
    }
public String GetSCE_CONTROV_TERR_PROPIE() {
        return SCE_CONTROV_TERR_PROPIE;
    }

    public void SetSCE_CONTROV_TERR_PROPIE(String SCE_CONTROV_TERR_PROPIE) {
        this.SCE_CONTROV_TERR_PROPIE = SCE_CONTROV_TERR_PROPIE;
    }
public String GetSCE_CONTROV_TERR_SOCIEDADE() {
        return SCE_CONTROV_TERR_SOCIEDADE;
    }

    public void SetSCE_CONTROV_TERR_SOCIEDADE(String SCE_CONTROV_TERR_SOCIEDADE) {
        this.SCE_CONTROV_TERR_SOCIEDADE = SCE_CONTROV_TERR_SOCIEDADE;
    }
public String GetSCE_CONTROV_TERR_POB_EJIDAL() {
        return SCE_CONTROV_TERR_POB_EJIDAL;
    }

    public void SetSCE_CONTROV_TERR_POB_EJIDAL(String SCE_CONTROV_TERR_POB_EJIDAL) {
        this.SCE_CONTROV_TERR_POB_EJIDAL = SCE_CONTROV_TERR_POB_EJIDAL;
    }
public String GetSCE_SUBTOTAL_ASUNTOS_RESTIT() {
        return SCE_SUBTOTAL_ASUNTOS_RESTIT;
    }

    public void SetSCE_SUBTOTAL_ASUNTOS_RESTIT(String SCE_SUBTOTAL_ASUNTOS_RESTIT) {
        this.SCE_SUBTOTAL_ASUNTOS_RESTIT = SCE_SUBTOTAL_ASUNTOS_RESTIT;
    }
public String GetSCE_RESTIT_AUTORID() {
        return SCE_RESTIT_AUTORID;
    }

    public void SetSCE_RESTIT_AUTORID(String SCE_RESTIT_AUTORID) {
        this.SCE_RESTIT_AUTORID = SCE_RESTIT_AUTORID;
    }
public String GetSCE_RESTIT_PARTIC() {
        return SCE_RESTIT_PARTIC;
    }

    public void SetSCE_RESTIT_PARTIC(String SCE_RESTIT_PARTIC) {
        this.SCE_RESTIT_PARTIC = SCE_RESTIT_PARTIC;
    }
public String GetSCE_RECON() {
        return SCE_RECON;
    }

    public void SetSCE_RECON(String SCE_RECON) {
        this.SCE_RECON = SCE_RECON;
    }
public String GetSCE_NULIDADES() {
        return SCE_NULIDADES;
    }

    public void SetSCE_NULIDADES(String SCE_NULIDADES) {
        this.SCE_NULIDADES = SCE_NULIDADES;
    }
public String GetSCE_TENENCIA() {
        return SCE_TENENCIA;
    }

    public void SetSCE_TENENCIA(String SCE_TENENCIA) {
        this.SCE_TENENCIA = SCE_TENENCIA;
    }
public String GetSCE_SUB_ASUNTOS_CONT_MA() {
        return SCE_SUB_ASUNTOS_CONT_MA;
    }

    public void SetSCE_SUB_ASUNTOS_CONT_MA(String SCE_SUB_ASUNTOS_CONT_MA) {
        this.SCE_SUB_ASUNTOS_CONT_MA = SCE_SUB_ASUNTOS_CONT_MA;
    }
public String GetSCE_CONTROV_MA_EJID() {
        return SCE_CONTROV_MA_EJID;
    }

    public void SetSCE_CONTROV_MA_EJID(String SCE_CONTROV_MA_EJID) {
        this.SCE_CONTROV_MA_EJID = SCE_CONTROV_MA_EJID;
    }
public String GetSCE_CONTROV_MA_NUCLEO() {
        return SCE_CONTROV_MA_NUCLEO;
    }

    public void SetSCE_CONTROV_MA_NUCLEO(String SCE_CONTROV_MA_NUCLEO) {
        this.SCE_CONTROV_MA_NUCLEO = SCE_CONTROV_MA_NUCLEO;
    }
public String GetSCE_SUCESION_DA() {
        return SCE_SUCESION_DA;
    }

    public void SetSCE_SUCESION_DA(String SCE_SUCESION_DA) {
        this.SCE_SUCESION_DA = SCE_SUCESION_DA;
    }
public String GetSCE_SUBTOTAL_JN() {
        return SCE_SUBTOTAL_JN;
    }

    public void SetSCE_SUBTOTAL_JN(String SCE_SUBTOTAL_JN) {
        this.SCE_SUBTOTAL_JN = SCE_SUBTOTAL_JN;
    }
public String GetSCE_JN_PROMOVIDOS() {
        return SCE_JN_PROMOVIDOS;
    }

    public void SetSCE_JN_PROMOVIDOS(String SCE_JN_PROMOVIDOS) {
        this.SCE_JN_PROMOVIDOS = SCE_JN_PROMOVIDOS;
    }
public String GetSCE_JN_ACTOS() {
        return SCE_JN_ACTOS;
    }

    public void SetSCE_JN_ACTOS(String SCE_JN_ACTOS) {
        this.SCE_JN_ACTOS = SCE_JN_ACTOS;
    }
public String GetSCE_OMISIONES() {
        return SCE_OMISIONES;
    }

    public void SetSCE_OMISIONES(String SCE_OMISIONES) {
        this.SCE_OMISIONES = SCE_OMISIONES;
    }
public String GetSCE_ASUNTOS_JV() {
        return SCE_ASUNTOS_JV;
    }

    public void SetSCE_ASUNTOS_JV(String SCE_ASUNTOS_JV) {
        this.SCE_ASUNTOS_JV = SCE_ASUNTOS_JV;
    }
public String GetSCE_CONTROV_TERR() {
        return SCE_CONTROV_TERR;
    }

    public void SetSCE_CONTROV_TERR(String SCE_CONTROV_TERR) {
        this.SCE_CONTROV_TERR = SCE_CONTROV_TERR;
    }
public String GetSCE_REVERSION() {
        return SCE_REVERSION;
    }

    public void SetSCE_REVERSION(String SCE_REVERSION) {
        this.SCE_REVERSION = SCE_REVERSION;
    }
public String GetSCE_SUBTOTAL_EJECUCION() {
        return SCE_SUBTOTAL_EJECUCION;
    }

    public void SetSCE_SUBTOTAL_EJECUCION(String SCE_SUBTOTAL_EJECUCION) {
        this.SCE_SUBTOTAL_EJECUCION = SCE_SUBTOTAL_EJECUCION;
    }
public String GetSCE_EJECUCION_CONVENIOS() {
        return SCE_EJECUCION_CONVENIOS;
    }

    public void SetSCE_EJECUCION_CONVENIOS(String SCE_EJECUCION_CONVENIOS) {
        this.SCE_EJECUCION_CONVENIOS = SCE_EJECUCION_CONVENIOS;
    }
public String GetSCE_EJECUCION_LAUDOS() {
        return SCE_EJECUCION_LAUDOS;
    }

    public void SetSCE_EJECUCION_LAUDOS(String SCE_EJECUCION_LAUDOS) {
        this.SCE_EJECUCION_LAUDOS = SCE_EJECUCION_LAUDOS;
    }
public String GetSCE_RRT() {
        return SCE_RRT;
    }

    public void SetSCE_RRT(String SCE_RRT) {
        this.SCE_RRT = SCE_RRT;
    }
public String GetSCE_PRIVACION() {
        return SCE_PRIVACION;
    }

    public void SetSCE_PRIVACION(String SCE_PRIVACION) {
        this.SCE_PRIVACION = SCE_PRIVACION;
    }
public String GetSCE_INCONFORMIDADES() {
        return SCE_INCONFORMIDADES;
    }

    public void SetSCE_INCONFORMIDADES(String SCE_INCONFORMIDADES) {
        this.SCE_INCONFORMIDADES = SCE_INCONFORMIDADES;
    }
public String GetSCE_ASUNTOS_LEGIS() {
        return SCE_ASUNTOS_LEGIS;
    }

    public void SetSCE_ASUNTOS_LEGIS(String SCE_ASUNTOS_LEGIS) {
        this.SCE_ASUNTOS_LEGIS = SCE_ASUNTOS_LEGIS;
    }
public String GetSCE_OTROS_ASUNTOS() {
        return SCE_OTROS_ASUNTOS;
    }

    public void SetSCE_OTROS_ASUNTOS(String SCE_OTROS_ASUNTOS) {
        this.SCE_OTROS_ASUNTOS = SCE_OTROS_ASUNTOS;
    }
public String GetSCR_TOTAL_SENTENCIAS() {
        return SCR_TOTAL_SENTENCIAS;
    }

    public void SetSCR_TOTAL_SENTENCIAS(String SCR_TOTAL_SENTENCIAS) {
        this.SCR_TOTAL_SENTENCIAS = SCR_TOTAL_SENTENCIAS;
    }
public String GetSCR_SUBTOTAL_CONTROV_TERR() {
        return SCR_SUBTOTAL_CONTROV_TERR;
    }

    public void SetSCR_SUBTOTAL_CONTROV_TERR(String SCR_SUBTOTAL_CONTROV_TERR) {
        this.SCR_SUBTOTAL_CONTROV_TERR = SCR_SUBTOTAL_CONTROV_TERR;
    }
public String GetSCR_CONTROV_TERR_NUCLEO() {
        return SCR_CONTROV_TERR_NUCLEO;
    }

    public void SetSCR_CONTROV_TERR_NUCLEO(String SCR_CONTROV_TERR_NUCLEO) {
        this.SCR_CONTROV_TERR_NUCLEO = SCR_CONTROV_TERR_NUCLEO;
    }
public String GetSCR_CONTROV_TERR_PROPIE() {
        return SCR_CONTROV_TERR_PROPIE;
    }

    public void SetSCR_CONTROV_TERR_PROPIE(String SCR_CONTROV_TERR_PROPIE) {
        this.SCR_CONTROV_TERR_PROPIE = SCR_CONTROV_TERR_PROPIE;
    }
public String GetSCR_CONTROV_TERR_SOCIEDADE() {
        return SCR_CONTROV_TERR_SOCIEDADE;
    }

    public void SetSCR_CONTROV_TERR_SOCIEDADE(String SCR_CONTROV_TERR_SOCIEDADE) {
        this.SCR_CONTROV_TERR_SOCIEDADE = SCR_CONTROV_TERR_SOCIEDADE;
    }
public String GetSCR_CONTROV_TERR_POB_EJIDAL() {
        return SCR_CONTROV_TERR_POB_EJIDAL;
    }

    public void SetSCR_CONTROV_TERR_POB_EJIDAL(String SCR_CONTROV_TERR_POB_EJIDAL) {
        this.SCR_CONTROV_TERR_POB_EJIDAL = SCR_CONTROV_TERR_POB_EJIDAL;
    }
public String GetSCR_SUBTOTAL_ASUNTOS_RESTIT() {
        return SCR_SUBTOTAL_ASUNTOS_RESTIT;
    }

    public void SetSCR_SUBTOTAL_ASUNTOS_RESTIT(String SCR_SUBTOTAL_ASUNTOS_RESTIT) {
        this.SCR_SUBTOTAL_ASUNTOS_RESTIT = SCR_SUBTOTAL_ASUNTOS_RESTIT;
    }
public String GetSCR_RESTIT_AUTORID() {
        return SCR_RESTIT_AUTORID;
    }

    public void SetSCR_RESTIT_AUTORID(String SCR_RESTIT_AUTORID) {
        this.SCR_RESTIT_AUTORID = SCR_RESTIT_AUTORID;
    }
public String GetSCR_RESTIT_PARTIC() {
        return SCR_RESTIT_PARTIC;
    }

    public void SetSCR_RESTIT_PARTIC(String SCR_RESTIT_PARTIC) {
        this.SCR_RESTIT_PARTIC = SCR_RESTIT_PARTIC;
    }
public String GetSCR_RECON() {
        return SCR_RECON;
    }

    public void SetSCR_RECON(String SCR_RECON) {
        this.SCR_RECON = SCR_RECON;
    }
public String GetSCR_NULIDADES() {
        return SCR_NULIDADES;
    }

    public void SetSCR_NULIDADES(String SCR_NULIDADES) {
        this.SCR_NULIDADES = SCR_NULIDADES;
    }
public String GetSCR_TENENCIA() {
        return SCR_TENENCIA;
    }

    public void SetSCR_TENENCIA(String SCR_TENENCIA) {
        this.SCR_TENENCIA = SCR_TENENCIA;
    }
public String GetSCR_SUB_ASUNTOS_CONT_MA() {
        return SCR_SUB_ASUNTOS_CONT_MA;
    }

    public void SetSCR_SUB_ASUNTOS_CONT_MA(String SCR_SUB_ASUNTOS_CONT_MA) {
        this.SCR_SUB_ASUNTOS_CONT_MA = SCR_SUB_ASUNTOS_CONT_MA;
    }
public String GetSCR_CONTROV_MA_EJID() {
        return SCR_CONTROV_MA_EJID;
    }

    public void SetSCR_CONTROV_MA_EJID(String SCR_CONTROV_MA_EJID) {
        this.SCR_CONTROV_MA_EJID = SCR_CONTROV_MA_EJID;
    }
public String GetSCR_CONTROV_MA_NUCLEO() {
        return SCR_CONTROV_MA_NUCLEO;
    }

    public void SetSCR_CONTROV_MA_NUCLEO(String SCR_CONTROV_MA_NUCLEO) {
        this.SCR_CONTROV_MA_NUCLEO = SCR_CONTROV_MA_NUCLEO;
    }
public String GetSCR_SUCESION_DA() {
        return SCR_SUCESION_DA;
    }

    public void SetSCR_SUCESION_DA(String SCR_SUCESION_DA) {
        this.SCR_SUCESION_DA = SCR_SUCESION_DA;
    }
public String GetSCR_SUBTOTAL_JN() {
        return SCR_SUBTOTAL_JN;
    }

    public void SetSCR_SUBTOTAL_JN(String SCR_SUBTOTAL_JN) {
        this.SCR_SUBTOTAL_JN = SCR_SUBTOTAL_JN;
    }
public String GetSCR_JN_PROMOVIDOS() {
        return SCR_JN_PROMOVIDOS;
    }

    public void SetSCR_JN_PROMOVIDOS(String SCR_JN_PROMOVIDOS) {
        this.SCR_JN_PROMOVIDOS = SCR_JN_PROMOVIDOS;
    }
public String GetSCR_JN_ACTOS() {
        return SCR_JN_ACTOS;
    }

    public void SetSCR_JN_ACTOS(String SCR_JN_ACTOS) {
        this.SCR_JN_ACTOS = SCR_JN_ACTOS;
    }
public String GetSCR_OMISIONES() {
        return SCR_OMISIONES;
    }

    public void SetSCR_OMISIONES(String SCR_OMISIONES) {
        this.SCR_OMISIONES = SCR_OMISIONES;
    }
public String GetSCR_ASUNTOS_JV() {
        return SCR_ASUNTOS_JV;
    }

    public void SetSCR_ASUNTOS_JV(String SCR_ASUNTOS_JV) {
        this.SCR_ASUNTOS_JV = SCR_ASUNTOS_JV;
    }
public String GetSCR_CONTROV_TERR() {
        return SCR_CONTROV_TERR;
    }

    public void SetSCR_CONTROV_TERR(String SCR_CONTROV_TERR) {
        this.SCR_CONTROV_TERR = SCR_CONTROV_TERR;
    }
public String GetSCR_REVERSION() {
        return SCR_REVERSION;
    }

    public void SetSCR_REVERSION(String SCR_REVERSION) {
        this.SCR_REVERSION = SCR_REVERSION;
    }
public String GetSCR_SUBTOTAL_EJECUCION() {
        return SCR_SUBTOTAL_EJECUCION;
    }

    public void SetSCR_SUBTOTAL_EJECUCION(String SCR_SUBTOTAL_EJECUCION) {
        this.SCR_SUBTOTAL_EJECUCION = SCR_SUBTOTAL_EJECUCION;
    }
public String GetSCR_EJECUCION_CONVENIOS() {
        return SCR_EJECUCION_CONVENIOS;
    }

    public void SetSCR_EJECUCION_CONVENIOS(String SCR_EJECUCION_CONVENIOS) {
        this.SCR_EJECUCION_CONVENIOS = SCR_EJECUCION_CONVENIOS;
    }
public String GetSCR_EJECUCION_LAUDOS() {
        return SCR_EJECUCION_LAUDOS;
    }

    public void SetSCR_EJECUCION_LAUDOS(String SCR_EJECUCION_LAUDOS) {
        this.SCR_EJECUCION_LAUDOS = SCR_EJECUCION_LAUDOS;
    }
public String GetSCR_RRT() {
        return SCR_RRT;
    }

    public void SetSCR_RRT(String SCR_RRT) {
        this.SCR_RRT = SCR_RRT;
    }
public String GetSCR_PRIVACION() {
        return SCR_PRIVACION;
    }

    public void SetSCR_PRIVACION(String SCR_PRIVACION) {
        this.SCR_PRIVACION = SCR_PRIVACION;
    }
public String GetSCR_INCONFORMIDADES() {
        return SCR_INCONFORMIDADES;
    }

    public void SetSCR_INCONFORMIDADES(String SCR_INCONFORMIDADES) {
        this.SCR_INCONFORMIDADES = SCR_INCONFORMIDADES;
    }
public String GetSCR_ASUNTOS_LEGIS() {
        return SCR_ASUNTOS_LEGIS;
    }

    public void SetSCR_ASUNTOS_LEGIS(String SCR_ASUNTOS_LEGIS) {
        this.SCR_ASUNTOS_LEGIS = SCR_ASUNTOS_LEGIS;
    }
public String GetSCR_OTROS_ASUNTOS() {
        return SCR_OTROS_ASUNTOS;
    }

    public void SetSCR_OTROS_ASUNTOS(String SCR_OTROS_ASUNTOS) {
        this.SCR_OTROS_ASUNTOS = SCR_OTROS_ASUNTOS;
    }
public String GetLH_TOTAL_LAUDOS() {
        return LH_TOTAL_LAUDOS;
    }

    public void SetLH_TOTAL_LAUDOS(String LH_TOTAL_LAUDOS) {
        this.LH_TOTAL_LAUDOS = LH_TOTAL_LAUDOS;
    }
public String GetLH_SUBTOTAL_CONTROV_TERR() {
        return LH_SUBTOTAL_CONTROV_TERR;
    }

    public void SetLH_SUBTOTAL_CONTROV_TERR(String LH_SUBTOTAL_CONTROV_TERR) {
        this.LH_SUBTOTAL_CONTROV_TERR = LH_SUBTOTAL_CONTROV_TERR;
    }
public String GetLH_CONTROV_TERR_NUCLEO() {
        return LH_CONTROV_TERR_NUCLEO;
    }

    public void SetLH_CONTROV_TERR_NUCLEO(String LH_CONTROV_TERR_NUCLEO) {
        this.LH_CONTROV_TERR_NUCLEO = LH_CONTROV_TERR_NUCLEO;
    }
public String GetLH_CONTROV_TERR_PROPIE() {
        return LH_CONTROV_TERR_PROPIE;
    }

    public void SetLH_CONTROV_TERR_PROPIE(String LH_CONTROV_TERR_PROPIE) {
        this.LH_CONTROV_TERR_PROPIE = LH_CONTROV_TERR_PROPIE;
    }
public String GetLH_CONTROV_TERR_SOCIEDADE() {
        return LH_CONTROV_TERR_SOCIEDADE;
    }

    public void SetLH_CONTROV_TERR_SOCIEDADE(String LH_CONTROV_TERR_SOCIEDADE) {
        this.LH_CONTROV_TERR_SOCIEDADE = LH_CONTROV_TERR_SOCIEDADE;
    }
public String GetLH_CONTROV_TERR_POB_EJIDAL() {
        return LH_CONTROV_TERR_POB_EJIDAL;
    }

    public void SetLH_CONTROV_TERR_POB_EJIDAL(String LH_CONTROV_TERR_POB_EJIDAL) {
        this.LH_CONTROV_TERR_POB_EJIDAL = LH_CONTROV_TERR_POB_EJIDAL;
    }
public String GetLH_SUBTOTAL_ASUNTOS_RESTIT() {
        return LH_SUBTOTAL_ASUNTOS_RESTIT;
    }

    public void SetLH_SUBTOTAL_ASUNTOS_RESTIT(String LH_SUBTOTAL_ASUNTOS_RESTIT) {
        this.LH_SUBTOTAL_ASUNTOS_RESTIT = LH_SUBTOTAL_ASUNTOS_RESTIT;
    }
public String GetLH_RESTIT_AUTORID() {
        return LH_RESTIT_AUTORID;
    }

    public void SetLH_RESTIT_AUTORID(String LH_RESTIT_AUTORID) {
        this.LH_RESTIT_AUTORID = LH_RESTIT_AUTORID;
    }
public String GetLH_RESTIT_PARTIC() {
        return LH_RESTIT_PARTIC;
    }

    public void SetLH_RESTIT_PARTIC(String LH_RESTIT_PARTIC) {
        this.LH_RESTIT_PARTIC = LH_RESTIT_PARTIC;
    }
public String GetLH_RECON() {
        return LH_RECON;
    }

    public void SetLH_RECON(String LH_RECON) {
        this.LH_RECON = LH_RECON;
    }
public String GetLH_NULIDADES() {
        return LH_NULIDADES;
    }

    public void SetLH_NULIDADES(String LH_NULIDADES) {
        this.LH_NULIDADES = LH_NULIDADES;
    }
public String GetLH_TENENCIA() {
        return LH_TENENCIA;
    }

    public void SetLH_TENENCIA(String LH_TENENCIA) {
        this.LH_TENENCIA = LH_TENENCIA;
    }
public String GetLH_SUB_ASUNTOS_CONT_MA() {
        return LH_SUB_ASUNTOS_CONT_MA;
    }

    public void SetLH_SUB_ASUNTOS_CONT_MA(String LH_SUB_ASUNTOS_CONT_MA) {
        this.LH_SUB_ASUNTOS_CONT_MA = LH_SUB_ASUNTOS_CONT_MA;
    }
public String GetLH_CONTROV_MA_EJID() {
        return LH_CONTROV_MA_EJID;
    }

    public void SetLH_CONTROV_MA_EJID(String LH_CONTROV_MA_EJID) {
        this.LH_CONTROV_MA_EJID = LH_CONTROV_MA_EJID;
    }
public String GetLH_CONTROV_MA_NUCLEO() {
        return LH_CONTROV_MA_NUCLEO;
    }

    public void SetLH_CONTROV_MA_NUCLEO(String LH_CONTROV_MA_NUCLEO) {
        this.LH_CONTROV_MA_NUCLEO = LH_CONTROV_MA_NUCLEO;
    }
public String GetLH_SUCESION_DA() {
        return LH_SUCESION_DA;
    }

    public void SetLH_SUCESION_DA(String LH_SUCESION_DA) {
        this.LH_SUCESION_DA = LH_SUCESION_DA;
    }
public String GetLH_SUBTOTAL_JN() {
        return LH_SUBTOTAL_JN;
    }

    public void SetLH_SUBTOTAL_JN(String LH_SUBTOTAL_JN) {
        this.LH_SUBTOTAL_JN = LH_SUBTOTAL_JN;
    }
public String GetLH_JN_PROMOVIDOS() {
        return LH_JN_PROMOVIDOS;
    }

    public void SetLH_JN_PROMOVIDOS(String LH_JN_PROMOVIDOS) {
        this.LH_JN_PROMOVIDOS = LH_JN_PROMOVIDOS;
    }
public String GetLH_JN_ACTOS() {
        return LH_JN_ACTOS;
    }

    public void SetLH_JN_ACTOS(String LH_JN_ACTOS) {
        this.LH_JN_ACTOS = LH_JN_ACTOS;
    }
public String GetLH_OMISIONES() {
        return LH_OMISIONES;
    }

    public void SetLH_OMISIONES(String LH_OMISIONES) {
        this.LH_OMISIONES = LH_OMISIONES;
    }
public String GetLH_CONTROV_TERR() {
        return LH_CONTROV_TERR;
    }

    public void SetLH_CONTROV_TERR(String LH_CONTROV_TERR) {
        this.LH_CONTROV_TERR = LH_CONTROV_TERR;
    }
public String GetLH_REVERSION() {
        return LH_REVERSION;
    }

    public void SetLH_REVERSION(String LH_REVERSION) {
        this.LH_REVERSION = LH_REVERSION;
    }
public String GetLH_SUBTOTAL_EJECUCION() {
        return LH_SUBTOTAL_EJECUCION;
    }

    public void SetLH_SUBTOTAL_EJECUCION(String LH_SUBTOTAL_EJECUCION) {
        this.LH_SUBTOTAL_EJECUCION = LH_SUBTOTAL_EJECUCION;
    }
public String GetLH_EJECUCION_CONVENIOS() {
        return LH_EJECUCION_CONVENIOS;
    }

    public void SetLH_EJECUCION_CONVENIOS(String LH_EJECUCION_CONVENIOS) {
        this.LH_EJECUCION_CONVENIOS = LH_EJECUCION_CONVENIOS;
    }
public String GetLH_EJECUCION_LAUDOS() {
        return LH_EJECUCION_LAUDOS;
    }

    public void SetLH_EJECUCION_LAUDOS(String LH_EJECUCION_LAUDOS) {
        this.LH_EJECUCION_LAUDOS = LH_EJECUCION_LAUDOS;
    }
public String GetLH_RRT() {
        return LH_RRT;
    }

    public void SetLH_RRT(String LH_RRT) {
        this.LH_RRT = LH_RRT;
    }
public String GetLH_PRIVACION() {
        return LH_PRIVACION;
    }

    public void SetLH_PRIVACION(String LH_PRIVACION) {
        this.LH_PRIVACION = LH_PRIVACION;
    }
public String GetLH_INCONFORMIDADES() {
        return LH_INCONFORMIDADES;
    }

    public void SetLH_INCONFORMIDADES(String LH_INCONFORMIDADES) {
        this.LH_INCONFORMIDADES = LH_INCONFORMIDADES;
    }
public String GetLH_ASUNTOS_LEGIS() {
        return LH_ASUNTOS_LEGIS;
    }

    public void SetLH_ASUNTOS_LEGIS(String LH_ASUNTOS_LEGIS) {
        this.LH_ASUNTOS_LEGIS = LH_ASUNTOS_LEGIS;
    }
public String GetLH_OTROS_ASUNTOS() {
        return LH_OTROS_ASUNTOS;
    }

    public void SetLH_OTROS_ASUNTOS(String LH_OTROS_ASUNTOS) {
        this.LH_OTROS_ASUNTOS = LH_OTROS_ASUNTOS;
    }
public String GetCSS_TOTAL_CONVENIOS() {
        return CSS_TOTAL_CONVENIOS;
    }

    public void SetCSS_TOTAL_CONVENIOS(String CSS_TOTAL_CONVENIOS) {
        this.CSS_TOTAL_CONVENIOS = CSS_TOTAL_CONVENIOS;
    }
public String GetCSS_SUBTOTAL_CONTROV_TERR() {
        return CSS_SUBTOTAL_CONTROV_TERR;
    }

    public void SetCSS_SUBTOTAL_CONTROV_TERR(String CSS_SUBTOTAL_CONTROV_TERR) {
        this.CSS_SUBTOTAL_CONTROV_TERR = CSS_SUBTOTAL_CONTROV_TERR;
    }
public String GetCSS_CONTROV_TERR_NUCLEO() {
        return CSS_CONTROV_TERR_NUCLEO;
    }

    public void SetCSS_CONTROV_TERR_NUCLEO(String CSS_CONTROV_TERR_NUCLEO) {
        this.CSS_CONTROV_TERR_NUCLEO = CSS_CONTROV_TERR_NUCLEO;
    }
public String GetCSS_CONTROV_TERR_PROPIE() {
        return CSS_CONTROV_TERR_PROPIE;
    }

    public void SetCSS_CONTROV_TERR_PROPIE(String CSS_CONTROV_TERR_PROPIE) {
        this.CSS_CONTROV_TERR_PROPIE = CSS_CONTROV_TERR_PROPIE;
    }
public String GetCSS_CONTROV_TERR_SOCIEDADE() {
        return CSS_CONTROV_TERR_SOCIEDADE;
    }

    public void SetCSS_CONTROV_TERR_SOCIEDADE(String CSS_CONTROV_TERR_SOCIEDADE) {
        this.CSS_CONTROV_TERR_SOCIEDADE = CSS_CONTROV_TERR_SOCIEDADE;
    }
public String GetCSS_CONTROV_TERR_POB_EJIDAL() {
        return CSS_CONTROV_TERR_POB_EJIDAL;
    }

    public void SetCSS_CONTROV_TERR_POB_EJIDAL(String CSS_CONTROV_TERR_POB_EJIDAL) {
        this.CSS_CONTROV_TERR_POB_EJIDAL = CSS_CONTROV_TERR_POB_EJIDAL;
    }
public String GetCSS_SUBTOTAL_ASUNTOS_RESTIT() {
        return CSS_SUBTOTAL_ASUNTOS_RESTIT;
    }

    public void SetCSS_SUBTOTAL_ASUNTOS_RESTIT(String CSS_SUBTOTAL_ASUNTOS_RESTIT) {
        this.CSS_SUBTOTAL_ASUNTOS_RESTIT = CSS_SUBTOTAL_ASUNTOS_RESTIT;
    }
public String GetCSS_RESTIT_AUTORID() {
        return CSS_RESTIT_AUTORID;
    }

    public void SetCSS_RESTIT_AUTORID(String CSS_RESTIT_AUTORID) {
        this.CSS_RESTIT_AUTORID = CSS_RESTIT_AUTORID;
    }
public String GetCSS_RESTIT_PARTIC() {
        return CSS_RESTIT_PARTIC;
    }

    public void SetCSS_RESTIT_PARTIC(String CSS_RESTIT_PARTIC) {
        this.CSS_RESTIT_PARTIC = CSS_RESTIT_PARTIC;
    }
public String GetCSS_RECON() {
        return CSS_RECON;
    }

    public void SetCSS_RECON(String CSS_RECON) {
        this.CSS_RECON = CSS_RECON;
    }
public String GetCSS_NULIDADES() {
        return CSS_NULIDADES;
    }

    public void SetCSS_NULIDADES(String CSS_NULIDADES) {
        this.CSS_NULIDADES = CSS_NULIDADES;
    }
public String GetCSS_TENENCIA() {
        return CSS_TENENCIA;
    }

    public void SetCSS_TENENCIA(String CSS_TENENCIA) {
        this.CSS_TENENCIA = CSS_TENENCIA;
    }
public String GetCSS_SUB_ASUNTOS_CONT_MA() {
        return CSS_SUB_ASUNTOS_CONT_MA;
    }

    public void SetCSS_SUB_ASUNTOS_CONT_MA(String CSS_SUB_ASUNTOS_CONT_MA) {
        this.CSS_SUB_ASUNTOS_CONT_MA = CSS_SUB_ASUNTOS_CONT_MA;
    }
public String GetCSS_CONTROV_MA_EJID() {
        return CSS_CONTROV_MA_EJID;
    }

    public void SetCSS_CONTROV_MA_EJID(String CSS_CONTROV_MA_EJID) {
        this.CSS_CONTROV_MA_EJID = CSS_CONTROV_MA_EJID;
    }
public String GetCSS_CONTROV_MA_NUCLEO() {
        return CSS_CONTROV_MA_NUCLEO;
    }

    public void SetCSS_CONTROV_MA_NUCLEO(String CSS_CONTROV_MA_NUCLEO) {
        this.CSS_CONTROV_MA_NUCLEO = CSS_CONTROV_MA_NUCLEO;
    }
public String GetCSS_SUCESION_DA() {
        return CSS_SUCESION_DA;
    }

    public void SetCSS_SUCESION_DA(String CSS_SUCESION_DA) {
        this.CSS_SUCESION_DA = CSS_SUCESION_DA;
    }
public String GetCSS_SUBTOTAL_JN_() {
        return CSS_SUBTOTAL_JN_;
    }

    public void SetCSS_SUBTOTAL_JN_(String CSS_SUBTOTAL_JN_) {
        this.CSS_SUBTOTAL_JN_ = CSS_SUBTOTAL_JN_;
    }
public String GetCSS_JN_PROMOVIDOS() {
        return CSS_JN_PROMOVIDOS;
    }

    public void SetCSS_JN_PROMOVIDOS(String CSS_JN_PROMOVIDOS) {
        this.CSS_JN_PROMOVIDOS = CSS_JN_PROMOVIDOS;
    }
public String GetCSS_JN_ACTOS() {
        return CSS_JN_ACTOS;
    }

    public void SetCSS_JN_ACTOS(String CSS_JN_ACTOS) {
        this.CSS_JN_ACTOS = CSS_JN_ACTOS;
    }
public String GetCSS_OMISIONES() {
        return CSS_OMISIONES;
    }

    public void SetCSS_OMISIONES(String CSS_OMISIONES) {
        this.CSS_OMISIONES = CSS_OMISIONES;
    }
public String GetCSS_ASUNTOS_JV() {
        return CSS_ASUNTOS_JV;
    }

    public void SetCSS_ASUNTOS_JV(String CSS_ASUNTOS_JV) {
        this.CSS_ASUNTOS_JV = CSS_ASUNTOS_JV;
    }
public String GetCSS_CONTROV_TERR() {
        return CSS_CONTROV_TERR;
    }

    public void SetCSS_CONTROV_TERR(String CSS_CONTROV_TERR) {
        this.CSS_CONTROV_TERR = CSS_CONTROV_TERR;
    }
public String GetCSS_REVERSION() {
        return CSS_REVERSION;
    }

    public void SetCSS_REVERSION(String CSS_REVERSION) {
        this.CSS_REVERSION = CSS_REVERSION;
    }
public String GetCSS_SUBTOTAL_EJECUCION() {
        return CSS_SUBTOTAL_EJECUCION;
    }

    public void SetCSS_SUBTOTAL_EJECUCION(String CSS_SUBTOTAL_EJECUCION) {
        this.CSS_SUBTOTAL_EJECUCION = CSS_SUBTOTAL_EJECUCION;
    }
public String GetCSS_EJECUCION_CONVENIOS() {
        return CSS_EJECUCION_CONVENIOS;
    }

    public void SetCSS_EJECUCION_CONVENIOS(String CSS_EJECUCION_CONVENIOS) {
        this.CSS_EJECUCION_CONVENIOS = CSS_EJECUCION_CONVENIOS;
    }
public String GetCSS_EJECUCION_LAUDOS() {
        return CSS_EJECUCION_LAUDOS;
    }

    public void SetCSS_EJECUCION_LAUDOS(String CSS_EJECUCION_LAUDOS) {
        this.CSS_EJECUCION_LAUDOS = CSS_EJECUCION_LAUDOS;
    }
public String GetCSS_RRT() {
        return CSS_RRT;
    }

    public void SetCSS_RRT(String CSS_RRT) {
        this.CSS_RRT = CSS_RRT;
    }
public String GetCSS_PRIVACION() {
        return CSS_PRIVACION;
    }

    public void SetCSS_PRIVACION(String CSS_PRIVACION) {
        this.CSS_PRIVACION = CSS_PRIVACION;
    }
public String GetCSS_INCONFORMIDADES() {
        return CSS_INCONFORMIDADES;
    }

    public void SetCSS_INCONFORMIDADES(String CSS_INCONFORMIDADES) {
        this.CSS_INCONFORMIDADES = CSS_INCONFORMIDADES;
    }
public String GetCSS_ASUNTOS_LEGIS() {
        return CSS_ASUNTOS_LEGIS;
    }

    public void SetCSS_ASUNTOS_LEGIS(String CSS_ASUNTOS_LEGIS) {
        this.CSS_ASUNTOS_LEGIS = CSS_ASUNTOS_LEGIS;
    }
public String GetCSS_OTROS_ASUNTOS() {
        return CSS_OTROS_ASUNTOS;
    }

    public void SetCSS_OTROS_ASUNTOS(String CSS_OTROS_ASUNTOS) {
        this.CSS_OTROS_ASUNTOS = CSS_OTROS_ASUNTOS;
    }
public String GetDES_TOTAL_DESMENTIMIENTOS() {
        return DES_TOTAL_DESMENTIMIENTOS;
    }

    public void SetDES_TOTAL_DESMENTIMIENTOS(String DES_TOTAL_DESMENTIMIENTOS) {
        this.DES_TOTAL_DESMENTIMIENTOS = DES_TOTAL_DESMENTIMIENTOS;
    }
public String GetDES_SUBTOTAL_CONTROV_TERR() {
        return DES_SUBTOTAL_CONTROV_TERR;
    }

    public void SetDES_SUBTOTAL_CONTROV_TERR(String DES_SUBTOTAL_CONTROV_TERR) {
        this.DES_SUBTOTAL_CONTROV_TERR = DES_SUBTOTAL_CONTROV_TERR;
    }
public String GetDES_CONTROV_TERR_NUCLEO() {
        return DES_CONTROV_TERR_NUCLEO;
    }

    public void SetDES_CONTROV_TERR_NUCLEO(String DES_CONTROV_TERR_NUCLEO) {
        this.DES_CONTROV_TERR_NUCLEO = DES_CONTROV_TERR_NUCLEO;
    }
public String GetDES_CONTROV_TERR_PROPIE() {
        return DES_CONTROV_TERR_PROPIE;
    }

    public void SetDES_CONTROV_TERR_PROPIE(String DES_CONTROV_TERR_PROPIE) {
        this.DES_CONTROV_TERR_PROPIE = DES_CONTROV_TERR_PROPIE;
    }
public String GetDES_CONTROV_TERR_SOCIEDADE() {
        return DES_CONTROV_TERR_SOCIEDADE;
    }

    public void SetDES_CONTROV_TERR_SOCIEDADE(String DES_CONTROV_TERR_SOCIEDADE) {
        this.DES_CONTROV_TERR_SOCIEDADE = DES_CONTROV_TERR_SOCIEDADE;
    }
public String GetDES_CONTROV_TERR_POB_EJIDAL() {
        return DES_CONTROV_TERR_POB_EJIDAL;
    }

    public void SetDES_CONTROV_TERR_POB_EJIDAL(String DES_CONTROV_TERR_POB_EJIDAL) {
        this.DES_CONTROV_TERR_POB_EJIDAL = DES_CONTROV_TERR_POB_EJIDAL;
    }
public String GetDES_SUBTOTAL_ASUNTOS_RESTIT() {
        return DES_SUBTOTAL_ASUNTOS_RESTIT;
    }

    public void SetDES_SUBTOTAL_ASUNTOS_RESTIT(String DES_SUBTOTAL_ASUNTOS_RESTIT) {
        this.DES_SUBTOTAL_ASUNTOS_RESTIT = DES_SUBTOTAL_ASUNTOS_RESTIT;
    }
public String GetDES_RESTIT_AUTORID() {
        return DES_RESTIT_AUTORID;
    }

    public void SetDES_RESTIT_AUTORID(String DES_RESTIT_AUTORID) {
        this.DES_RESTIT_AUTORID = DES_RESTIT_AUTORID;
    }
public String GetDES_RESTIT_PARTIC() {
        return DES_RESTIT_PARTIC;
    }

    public void SetDES_RESTIT_PARTIC(String DES_RESTIT_PARTIC) {
        this.DES_RESTIT_PARTIC = DES_RESTIT_PARTIC;
    }
public String GetDES_RECON() {
        return DES_RECON;
    }

    public void SetDES_RECON(String DES_RECON) {
        this.DES_RECON = DES_RECON;
    }
public String GetDES_NULIDADES() {
        return DES_NULIDADES;
    }

    public void SetDES_NULIDADES(String DES_NULIDADES) {
        this.DES_NULIDADES = DES_NULIDADES;
    }
public String GetDES_TENENCIA() {
        return DES_TENENCIA;
    }

    public void SetDES_TENENCIA(String DES_TENENCIA) {
        this.DES_TENENCIA = DES_TENENCIA;
    }
public String GetDES_SUB_ASUNTOS_CONT_MA() {
        return DES_SUB_ASUNTOS_CONT_MA;
    }

    public void SetDES_SUB_ASUNTOS_CONT_MA(String DES_SUB_ASUNTOS_CONT_MA) {
        this.DES_SUB_ASUNTOS_CONT_MA = DES_SUB_ASUNTOS_CONT_MA;
    }
public String GetDES_CONTROV_MA_EJID() {
        return DES_CONTROV_MA_EJID;
    }

    public void SetDES_CONTROV_MA_EJID(String DES_CONTROV_MA_EJID) {
        this.DES_CONTROV_MA_EJID = DES_CONTROV_MA_EJID;
    }
public String GetDES_CONTROV_MA_NUCLEO() {
        return DES_CONTROV_MA_NUCLEO;
    }

    public void SetDES_CONTROV_MA_NUCLEO(String DES_CONTROV_MA_NUCLEO) {
        this.DES_CONTROV_MA_NUCLEO = DES_CONTROV_MA_NUCLEO;
    }
public String GetDES_SUCESION_DA() {
        return DES_SUCESION_DA;
    }

    public void SetDES_SUCESION_DA(String DES_SUCESION_DA) {
        this.DES_SUCESION_DA = DES_SUCESION_DA;
    }
public String GetDES_SUBTOTAL_JN() {
        return DES_SUBTOTAL_JN;
    }

    public void SetDES_SUBTOTAL_JN(String DES_SUBTOTAL_JN) {
        this.DES_SUBTOTAL_JN = DES_SUBTOTAL_JN;
    }
public String GetDES_JN_PROMOVIDOS() {
        return DES_JN_PROMOVIDOS;
    }

    public void SetDES_JN_PROMOVIDOS(String DES_JN_PROMOVIDOS) {
        this.DES_JN_PROMOVIDOS = DES_JN_PROMOVIDOS;
    }
public String GetDES_JN_ACTOS() {
        return DES_JN_ACTOS;
    }

    public void SetDES_JN_ACTOS(String DES_JN_ACTOS) {
        this.DES_JN_ACTOS = DES_JN_ACTOS;
    }
public String GetDES_OMISIONES() {
        return DES_OMISIONES;
    }

    public void SetDES_OMISIONES(String DES_OMISIONES) {
        this.DES_OMISIONES = DES_OMISIONES;
    }
public String GetDES_ASUNTOS_JV() {
        return DES_ASUNTOS_JV;
    }

    public void SetDES_ASUNTOS_JV(String DES_ASUNTOS_JV) {
        this.DES_ASUNTOS_JV = DES_ASUNTOS_JV;
    }
public String GetDES_CONTROV_TERR() {
        return DES_CONTROV_TERR;
    }

    public void SetDES_CONTROV_TERR(String DES_CONTROV_TERR) {
        this.DES_CONTROV_TERR = DES_CONTROV_TERR;
    }
public String GetDES_REVERSION() {
        return DES_REVERSION;
    }

    public void SetDES_REVERSION(String DES_REVERSION) {
        this.DES_REVERSION = DES_REVERSION;
    }
public String GetDES_SUBTOTAL_EJECUCION() {
        return DES_SUBTOTAL_EJECUCION;
    }

    public void SetDES_SUBTOTAL_EJECUCION(String DES_SUBTOTAL_EJECUCION) {
        this.DES_SUBTOTAL_EJECUCION = DES_SUBTOTAL_EJECUCION;
    }
public String GetDES_EJECUCION_CONVENIOS() {
        return DES_EJECUCION_CONVENIOS;
    }

    public void SetDES_EJECUCION_CONVENIOS(String DES_EJECUCION_CONVENIOS) {
        this.DES_EJECUCION_CONVENIOS = DES_EJECUCION_CONVENIOS;
    }
public String GetDES_EJECUCION_LAUDOS() {
        return DES_EJECUCION_LAUDOS;
    }

    public void SetDES_EJECUCION_LAUDOS(String DES_EJECUCION_LAUDOS) {
        this.DES_EJECUCION_LAUDOS = DES_EJECUCION_LAUDOS;
    }
public String GetDES_RRT() {
        return DES_RRT;
    }

    public void SetDES_RRT(String DES_RRT) {
        this.DES_RRT = DES_RRT;
    }
public String GetDES_PRIVACION() {
        return DES_PRIVACION;
    }

    public void SetDES_PRIVACION(String DES_PRIVACION) {
        this.DES_PRIVACION = DES_PRIVACION;
    }
public String GetDES_INCONFORMIDADES() {
        return DES_INCONFORMIDADES;
    }

    public void SetDES_INCONFORMIDADES(String DES_INCONFORMIDADES) {
        this.DES_INCONFORMIDADES = DES_INCONFORMIDADES;
    }
public String GetDES_ASUNTOS_LEGIS() {
        return DES_ASUNTOS_LEGIS;
    }

    public void SetDES_ASUNTOS_LEGIS(String DES_ASUNTOS_LEGIS) {
        this.DES_ASUNTOS_LEGIS = DES_ASUNTOS_LEGIS;
    }
public String GetDES_OTROS_ASUNTOS() {
        return DES_OTROS_ASUNTOS;
    }

    public void SetDES_OTROS_ASUNTOS(String DES_OTROS_ASUNTOS) {
        this.DES_OTROS_ASUNTOS = DES_OTROS_ASUNTOS;
    }
public String GetCAD_TOTAL_CADUCIDADES() {
        return CAD_TOTAL_CADUCIDADES;
    }

    public void SetCAD_TOTAL_CADUCIDADES(String CAD_TOTAL_CADUCIDADES) {
        this.CAD_TOTAL_CADUCIDADES = CAD_TOTAL_CADUCIDADES;
    }
public String GetCAD_SUBTOTAL_CONTROV_TERR() {
        return CAD_SUBTOTAL_CONTROV_TERR;
    }

    public void SetCAD_SUBTOTAL_CONTROV_TERR(String CAD_SUBTOTAL_CONTROV_TERR) {
        this.CAD_SUBTOTAL_CONTROV_TERR = CAD_SUBTOTAL_CONTROV_TERR;
    }
public String GetCAD_CONTROV_TERR_NUCLEO() {
        return CAD_CONTROV_TERR_NUCLEO;
    }

    public void SetCAD_CONTROV_TERR_NUCLEO(String CAD_CONTROV_TERR_NUCLEO) {
        this.CAD_CONTROV_TERR_NUCLEO = CAD_CONTROV_TERR_NUCLEO;
    }
public String GetCAD_CONTROV_TERR_PROPIE() {
        return CAD_CONTROV_TERR_PROPIE;
    }

    public void SetCAD_CONTROV_TERR_PROPIE(String CAD_CONTROV_TERR_PROPIE) {
        this.CAD_CONTROV_TERR_PROPIE = CAD_CONTROV_TERR_PROPIE;
    }
public String GetCAD_CONTROV_TERR_SOCIEDADE() {
        return CAD_CONTROV_TERR_SOCIEDADE;
    }

    public void SetCAD_CONTROV_TERR_SOCIEDADE(String CAD_CONTROV_TERR_SOCIEDADE) {
        this.CAD_CONTROV_TERR_SOCIEDADE = CAD_CONTROV_TERR_SOCIEDADE;
    }
public String GetCAD_CONTROV_TERR_POB_EJIDAL() {
        return CAD_CONTROV_TERR_POB_EJIDAL;
    }

    public void SetCAD_CONTROV_TERR_POB_EJIDAL(String CAD_CONTROV_TERR_POB_EJIDAL) {
        this.CAD_CONTROV_TERR_POB_EJIDAL = CAD_CONTROV_TERR_POB_EJIDAL;
    }
public String GetCAD_SUBTOTAL_ASUNTOS_RESTIT() {
        return CAD_SUBTOTAL_ASUNTOS_RESTIT;
    }

    public void SetCAD_SUBTOTAL_ASUNTOS_RESTIT(String CAD_SUBTOTAL_ASUNTOS_RESTIT) {
        this.CAD_SUBTOTAL_ASUNTOS_RESTIT = CAD_SUBTOTAL_ASUNTOS_RESTIT;
    }
public String GetCAD_RESTIT_AUTORID() {
        return CAD_RESTIT_AUTORID;
    }

    public void SetCAD_RESTIT_AUTORID(String CAD_RESTIT_AUTORID) {
        this.CAD_RESTIT_AUTORID = CAD_RESTIT_AUTORID;
    }
public String GetCAD_RESTIT_PARTIC() {
        return CAD_RESTIT_PARTIC;
    }

    public void SetCAD_RESTIT_PARTIC(String CAD_RESTIT_PARTIC) {
        this.CAD_RESTIT_PARTIC = CAD_RESTIT_PARTIC;
    }
public String GetCAD_RECON() {
        return CAD_RECON;
    }

    public void SetCAD_RECON(String CAD_RECON) {
        this.CAD_RECON = CAD_RECON;
    }
public String GetCAD_NULIDADES() {
        return CAD_NULIDADES;
    }

    public void SetCAD_NULIDADES(String CAD_NULIDADES) {
        this.CAD_NULIDADES = CAD_NULIDADES;
    }
public String GetCAD_TENENCIA() {
        return CAD_TENENCIA;
    }

    public void SetCAD_TENENCIA(String CAD_TENENCIA) {
        this.CAD_TENENCIA = CAD_TENENCIA;
    }
public String GetCAD_SUB_ASUNTOS_CONT_MA() {
        return CAD_SUB_ASUNTOS_CONT_MA;
    }

    public void SetCAD_SUB_ASUNTOS_CONT_MA(String CAD_SUB_ASUNTOS_CONT_MA) {
        this.CAD_SUB_ASUNTOS_CONT_MA = CAD_SUB_ASUNTOS_CONT_MA;
    }
public String GetCAD_CONTROV_MA_EJID() {
        return CAD_CONTROV_MA_EJID;
    }

    public void SetCAD_CONTROV_MA_EJID(String CAD_CONTROV_MA_EJID) {
        this.CAD_CONTROV_MA_EJID = CAD_CONTROV_MA_EJID;
    }
public String GetCAD_CONTROV_MA_NUCLEO() {
        return CAD_CONTROV_MA_NUCLEO;
    }

    public void SetCAD_CONTROV_MA_NUCLEO(String CAD_CONTROV_MA_NUCLEO) {
        this.CAD_CONTROV_MA_NUCLEO = CAD_CONTROV_MA_NUCLEO;
    }
public String GetCAD_SUCESION_DA() {
        return CAD_SUCESION_DA;
    }

    public void SetCAD_SUCESION_DA(String CAD_SUCESION_DA) {
        this.CAD_SUCESION_DA = CAD_SUCESION_DA;
    }
public String GetCAD_SUBTOTAL_JN() {
        return CAD_SUBTOTAL_JN;
    }

    public void SetCAD_SUBTOTAL_JN(String CAD_SUBTOTAL_JN) {
        this.CAD_SUBTOTAL_JN = CAD_SUBTOTAL_JN;
    }
public String GetCAD_JN_PROMOVIDOS() {
        return CAD_JN_PROMOVIDOS;
    }

    public void SetCAD_JN_PROMOVIDOS(String CAD_JN_PROMOVIDOS) {
        this.CAD_JN_PROMOVIDOS = CAD_JN_PROMOVIDOS;
    }
public String GetCAD_JN_ACTOS() {
        return CAD_JN_ACTOS;
    }

    public void SetCAD_JN_ACTOS(String CAD_JN_ACTOS) {
        this.CAD_JN_ACTOS = CAD_JN_ACTOS;
    }
public String GetCAD_OMISIONES() {
        return CAD_OMISIONES;
    }

    public void SetCAD_OMISIONES(String CAD_OMISIONES) {
        this.CAD_OMISIONES = CAD_OMISIONES;
    }
public String GetCAD_ASUNTOS_JV() {
        return CAD_ASUNTOS_JV;
    }

    public void SetCAD_ASUNTOS_JV(String CAD_ASUNTOS_JV) {
        this.CAD_ASUNTOS_JV = CAD_ASUNTOS_JV;
    }
public String GetCAD_CONTROV_TERR() {
        return CAD_CONTROV_TERR;
    }

    public void SetCAD_CONTROV_TERR(String CAD_CONTROV_TERR) {
        this.CAD_CONTROV_TERR = CAD_CONTROV_TERR;
    }
public String GetCAD_REVERSION() {
        return CAD_REVERSION;
    }

    public void SetCAD_REVERSION(String CAD_REVERSION) {
        this.CAD_REVERSION = CAD_REVERSION;
    }
public String GetCAD_SUBTOTAL_EJECUCION() {
        return CAD_SUBTOTAL_EJECUCION;
    }

    public void SetCAD_SUBTOTAL_EJECUCION(String CAD_SUBTOTAL_EJECUCION) {
        this.CAD_SUBTOTAL_EJECUCION = CAD_SUBTOTAL_EJECUCION;
    }
public String GetCAD_EJECUCION_CONVENIOS() {
        return CAD_EJECUCION_CONVENIOS;
    }

    public void SetCAD_EJECUCION_CONVENIOS(String CAD_EJECUCION_CONVENIOS) {
        this.CAD_EJECUCION_CONVENIOS = CAD_EJECUCION_CONVENIOS;
    }
public String GetCAD_EJECUCION_LAUDOS() {
        return CAD_EJECUCION_LAUDOS;
    }

    public void SetCAD_EJECUCION_LAUDOS(String CAD_EJECUCION_LAUDOS) {
        this.CAD_EJECUCION_LAUDOS = CAD_EJECUCION_LAUDOS;
    }
public String GetCAD_RRT() {
        return CAD_RRT;
    }

    public void SetCAD_RRT(String CAD_RRT) {
        this.CAD_RRT = CAD_RRT;
    }
public String GetCAD_PRIVACION() {
        return CAD_PRIVACION;
    }

    public void SetCAD_PRIVACION(String CAD_PRIVACION) {
        this.CAD_PRIVACION = CAD_PRIVACION;
    }
public String GetCAD_INCONFORMIDADES() {
        return CAD_INCONFORMIDADES;
    }

    public void SetCAD_INCONFORMIDADES(String CAD_INCONFORMIDADES) {
        this.CAD_INCONFORMIDADES = CAD_INCONFORMIDADES;
    }
public String GetCAD_ASUNTOS_LEGIS() {
        return CAD_ASUNTOS_LEGIS;
    }

    public void SetCAD_ASUNTOS_LEGIS(String CAD_ASUNTOS_LEGIS) {
        this.CAD_ASUNTOS_LEGIS = CAD_ASUNTOS_LEGIS;
    }
public String GetCAD_OTROS_ASUNTOS() {
        return CAD_OTROS_ASUNTOS;
    }

    public void SetCAD_OTROS_ASUNTOS(String CAD_OTROS_ASUNTOS) {
        this.CAD_OTROS_ASUNTOS = CAD_OTROS_ASUNTOS;
    }
public String GetOTRO_TOTAL_OTRO_TIPO() {
        return OTRO_TOTAL_OTRO_TIPO;
    }

    public void SetOTRO_TOTAL_OTRO_TIPO(String OTRO_TOTAL_OTRO_TIPO) {
        this.OTRO_TOTAL_OTRO_TIPO = OTRO_TOTAL_OTRO_TIPO;
    }
public String GetOTRO_SUBTOTAL_CONTROV_TERR() {
        return OTRO_SUBTOTAL_CONTROV_TERR;
    }

    public void SetOTRO_SUBTOTAL_CONTROV_TERR(String OTRO_SUBTOTAL_CONTROV_TERR) {
        this.OTRO_SUBTOTAL_CONTROV_TERR = OTRO_SUBTOTAL_CONTROV_TERR;
    }
public String GetOTRO_CONTROV_TERR_NUCLEO() {
        return OTRO_CONTROV_TERR_NUCLEO;
    }

    public void SetOTRO_CONTROV_TERR_NUCLEO(String OTRO_CONTROV_TERR_NUCLEO) {
        this.OTRO_CONTROV_TERR_NUCLEO = OTRO_CONTROV_TERR_NUCLEO;
    }
public String GetOTRO_CONTROV_TERR_PROPIE() {
        return OTRO_CONTROV_TERR_PROPIE;
    }

    public void SetOTRO_CONTROV_TERR_PROPIE(String OTRO_CONTROV_TERR_PROPIE) {
        this.OTRO_CONTROV_TERR_PROPIE = OTRO_CONTROV_TERR_PROPIE;
    }
public String GetOTRO_CONTROV_TERR_SOCIEDADE() {
        return OTRO_CONTROV_TERR_SOCIEDADE;
    }

    public void SetOTRO_CONTROV_TERR_SOCIEDADE(String OTRO_CONTROV_TERR_SOCIEDADE) {
        this.OTRO_CONTROV_TERR_SOCIEDADE = OTRO_CONTROV_TERR_SOCIEDADE;
    }
public String GetOTRO_CONTROV_POB_EJIDAL() {
        return OTRO_CONTROV_POB_EJIDAL;
    }

    public void SetOTRO_CONTROV_POB_EJIDAL(String OTRO_CONTROV_POB_EJIDAL) {
        this.OTRO_CONTROV_POB_EJIDAL = OTRO_CONTROV_POB_EJIDAL;
    }
public String GetOTRO_SUBTOTAL_ASUNTOS_RESTIT() {
        return OTRO_SUBTOTAL_ASUNTOS_RESTIT;
    }

    public void SetOTRO_SUBTOTAL_ASUNTOS_RESTIT(String OTRO_SUBTOTAL_ASUNTOS_RESTIT) {
        this.OTRO_SUBTOTAL_ASUNTOS_RESTIT = OTRO_SUBTOTAL_ASUNTOS_RESTIT;
    }
public String GetOTRO_RESTIT_AUTORID() {
        return OTRO_RESTIT_AUTORID;
    }

    public void SetOTRO_RESTIT_AUTORID(String OTRO_RESTIT_AUTORID) {
        this.OTRO_RESTIT_AUTORID = OTRO_RESTIT_AUTORID;
    }
public String GetOTRO_RESTIT_PARTIC() {
        return OTRO_RESTIT_PARTIC;
    }

    public void SetOTRO_RESTIT_PARTIC(String OTRO_RESTIT_PARTIC) {
        this.OTRO_RESTIT_PARTIC = OTRO_RESTIT_PARTIC;
    }
public String GetOTRO_RECON() {
        return OTRO_RECON;
    }

    public void SetOTRO_RECON(String OTRO_RECON) {
        this.OTRO_RECON = OTRO_RECON;
    }
public String GetOTRO_NULIDADES() {
        return OTRO_NULIDADES;
    }

    public void SetOTRO_NULIDADES(String OTRO_NULIDADES) {
        this.OTRO_NULIDADES = OTRO_NULIDADES;
    }
public String GetOTRO_TENENCIA() {
        return OTRO_TENENCIA;
    }

    public void SetOTRO_TENENCIA(String OTRO_TENENCIA) {
        this.OTRO_TENENCIA = OTRO_TENENCIA;
    }
public String GetOTRO_SUB_ASUNTOS_CONT_MA() {
        return OTRO_SUB_ASUNTOS_CONT_MA;
    }

    public void SetOTRO_SUB_ASUNTOS_CONT_MA(String OTRO_SUB_ASUNTOS_CONT_MA) {
        this.OTRO_SUB_ASUNTOS_CONT_MA = OTRO_SUB_ASUNTOS_CONT_MA;
    }
public String GetOTRO_CONTROV_MA_EJID() {
        return OTRO_CONTROV_MA_EJID;
    }

    public void SetOTRO_CONTROV_MA_EJID(String OTRO_CONTROV_MA_EJID) {
        this.OTRO_CONTROV_MA_EJID = OTRO_CONTROV_MA_EJID;
    }
public String GetOTRO_CONTROV_MA_NUCLEO() {
        return OTRO_CONTROV_MA_NUCLEO;
    }

    public void SetOTRO_CONTROV_MA_NUCLEO(String OTRO_CONTROV_MA_NUCLEO) {
        this.OTRO_CONTROV_MA_NUCLEO = OTRO_CONTROV_MA_NUCLEO;
    }
public String GetOTRO_SUCESION_DA() {
        return OTRO_SUCESION_DA;
    }

    public void SetOTRO_SUCESION_DA(String OTRO_SUCESION_DA) {
        this.OTRO_SUCESION_DA = OTRO_SUCESION_DA;
    }
public String GetOTRO_SUBTOTAL_JN() {
        return OTRO_SUBTOTAL_JN;
    }

    public void SetOTRO_SUBTOTAL_JN(String OTRO_SUBTOTAL_JN) {
        this.OTRO_SUBTOTAL_JN = OTRO_SUBTOTAL_JN;
    }
public String GetOTRO_JN_PROMOVIDOS() {
        return OTRO_JN_PROMOVIDOS;
    }

    public void SetOTRO_JN_PROMOVIDOS(String OTRO_JN_PROMOVIDOS) {
        this.OTRO_JN_PROMOVIDOS = OTRO_JN_PROMOVIDOS;
    }
public String GetOTRO_JN_ACTOS() {
        return OTRO_JN_ACTOS;
    }

    public void SetOTRO_JN_ACTOS(String OTRO_JN_ACTOS) {
        this.OTRO_JN_ACTOS = OTRO_JN_ACTOS;
    }
public String GetOTRO_OMISIONES() {
        return OTRO_OMISIONES;
    }

    public void SetOTRO_OMISIONES(String OTRO_OMISIONES) {
        this.OTRO_OMISIONES = OTRO_OMISIONES;
    }
public String GetOTRO_ASUNTOS_JV() {
        return OTRO_ASUNTOS_JV;
    }

    public void SetOTRO_ASUNTOS_JV(String OTRO_ASUNTOS_JV) {
        this.OTRO_ASUNTOS_JV = OTRO_ASUNTOS_JV;
    }
public String GetOTRO_CONTROV_TERR() {
        return OTRO_CONTROV_TERR;
    }

    public void SetOTRO_CONTROV_TERR(String OTRO_CONTROV_TERR) {
        this.OTRO_CONTROV_TERR = OTRO_CONTROV_TERR;
    }
public String GetOTRO_REVERSION() {
        return OTRO_REVERSION;
    }

    public void SetOTRO_REVERSION(String OTRO_REVERSION) {
        this.OTRO_REVERSION = OTRO_REVERSION;
    }
public String GetOTRO_SUBTOTAL_EJECUCION() {
        return OTRO_SUBTOTAL_EJECUCION;
    }

    public void SetOTRO_SUBTOTAL_EJECUCION(String OTRO_SUBTOTAL_EJECUCION) {
        this.OTRO_SUBTOTAL_EJECUCION = OTRO_SUBTOTAL_EJECUCION;
    }
public String GetOTRO_EJECUCION_CONVENIOS() {
        return OTRO_EJECUCION_CONVENIOS;
    }

    public void SetOTRO_EJECUCION_CONVENIOS(String OTRO_EJECUCION_CONVENIOS) {
        this.OTRO_EJECUCION_CONVENIOS = OTRO_EJECUCION_CONVENIOS;
    }
public String GetOTRO_EJECUCION_LAUDOS() {
        return OTRO_EJECUCION_LAUDOS;
    }

    public void SetOTRO_EJECUCION_LAUDOS(String OTRO_EJECUCION_LAUDOS) {
        this.OTRO_EJECUCION_LAUDOS = OTRO_EJECUCION_LAUDOS;
    }
public String GetOTRO_RRT() {
        return OTRO_RRT;
    }

    public void SetOTRO_RRT(String OTRO_RRT) {
        this.OTRO_RRT = OTRO_RRT;
    }
public String GetOTRO_PRIVACION() {
        return OTRO_PRIVACION;
    }

    public void SetOTRO_PRIVACION(String OTRO_PRIVACION) {
        this.OTRO_PRIVACION = OTRO_PRIVACION;
    }
public String GetOTRO_INCONFORMIDADES() {
        return OTRO_INCONFORMIDADES;
    }

    public void SetOTRO_INCONFORMIDADES(String OTRO_INCONFORMIDADES) {
        this.OTRO_INCONFORMIDADES = OTRO_INCONFORMIDADES;
    }
public String GetOTRO_ASUNTOS_LEGIS() {
        return OTRO_ASUNTOS_LEGIS;
    }

    public void SetOTRO_ASUNTOS_LEGIS(String OTRO_ASUNTOS_LEGIS) {
        this.OTRO_ASUNTOS_LEGIS = OTRO_ASUNTOS_LEGIS;
    }
public String GetOTRO_OTROS_ASUNTOS() {
        return OTRO_OTROS_ASUNTOS;
    }

    public void SetOTRO_OTROS_ASUNTOS(String OTRO_OTROS_ASUNTOS) {
        this.OTRO_OTROS_ASUNTOS = OTRO_OTROS_ASUNTOS;
    }
public String GetSD_TOTAL_ESTAT() {
        return SD_TOTAL_ESTAT;
    }

    public void SetSD_TOTAL_ESTAT(String SD_TOTAL_ESTAT) {
        this.SD_TOTAL_ESTAT = SD_TOTAL_ESTAT;
    }
public String GetSD_ESTAT_NOTIFICAR() {
        return SD_ESTAT_NOTIFICAR;
    }

    public void SetSD_ESTAT_NOTIFICAR(String SD_ESTAT_NOTIFICAR) {
        this.SD_ESTAT_NOTIFICAR = SD_ESTAT_NOTIFICAR;
    }
public String GetSD_ESTAT_TRANSCURSO() {
        return SD_ESTAT_TRANSCURSO;
    }

    public void SetSD_ESTAT_TRANSCURSO(String SD_ESTAT_TRANSCURSO) {
        this.SD_ESTAT_TRANSCURSO = SD_ESTAT_TRANSCURSO;
    }
public String GetSD_ESTAT_IMPUGN_RR() {
        return SD_ESTAT_IMPUGN_RR;
    }

    public void SetSD_ESTAT_IMPUGN_RR(String SD_ESTAT_IMPUGN_RR) {
        this.SD_ESTAT_IMPUGN_RR = SD_ESTAT_IMPUGN_RR;
    }
public String GetSD_ESTAT_IMPUGN_JA() {
        return SD_ESTAT_IMPUGN_JA;
    }

    public void SetSD_ESTAT_IMPUGN_JA(String SD_ESTAT_IMPUGN_JA) {
        this.SD_ESTAT_IMPUGN_JA = SD_ESTAT_IMPUGN_JA;
    }
public String GetSD_ESTAT_EJECUCION() {
        return SD_ESTAT_EJECUCION;
    }

    public void SetSD_ESTAT_EJECUCION(String SD_ESTAT_EJECUCION) {
        this.SD_ESTAT_EJECUCION = SD_ESTAT_EJECUCION;
    }
public String GetSDE_TOTAL_TIPO() {
        return SDE_TOTAL_TIPO;
    }

    public void SetSDE_TOTAL_TIPO(String SDE_TOTAL_TIPO) {
        this.SDE_TOTAL_TIPO = SDE_TOTAL_TIPO;
    }
public String GetSDE_EJECUCION() {
        return SDE_EJECUCION;
    }

    public void SetSDE_EJECUCION(String SDE_EJECUCION) {
        this.SDE_EJECUCION = SDE_EJECUCION;
    }
public String GetSDE_CONVENIOS() {
        return SDE_CONVENIOS;
    }

    public void SetSDE_CONVENIOS(String SDE_CONVENIOS) {
        this.SDE_CONVENIOS = SDE_CONVENIOS;
    }
public String GetTOTAL_ASUNTOS_CONCL() {
        return TOTAL_ASUNTOS_CONCL;
    }

    public void SetTOTAL_ASUNTOS_CONCL(String TOTAL_ASUNTOS_CONCL) {
        this.TOTAL_ASUNTOS_CONCL = TOTAL_ASUNTOS_CONCL;
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
GetTOTAL_RESOLUCIONES(),
GetSENTENCIAS_DEF(),
GetSENTENCIAS_CUMPL_EJEC(),
GetSENTENCIAS_CUMP_RR(),
GetLAUDOS(),
GetCONVENIOS(),
GetDESISTIMIENTOS(),
GetCADUCIDADES(),
GetJURISDICCION_VOLUNTARIA(),
GetOTRO_RESOL(),
GetSD_TOTAL_SENTENCIAS(),
GetSD_SUB_CONTROV_TERR(),
GetSD_CONTROV_TERR_NUC(),
GetSD_CONTROV_TERR_PROPIE(),
GetSD_CONTROV_TERR_SOCI(),
GetSD_CONTROV_TERR_POB_EJIDAL(),
GetSD_SUBTOTAL_ASUNTOS_RESTIT(),
GetSD_RESTIT_AUTORID(),
GetSD_RESTIT_PARTIC(),
GetSD_RECON(),
GetSD_NULIDADES(),
GetSD_TENENCIA(),
GetSD_SUB_ASUNTOS_CON_MA(),
GetSD_CONTROV_MA_EJID(),
GetSD_CONTROV_MA_NUCLEO(),
GetSD_SUCESION_DA(),
GetSD_SUBTOTAL_JN(),
GetSD_JN_PROMOVIDOS(),
GetSD_JN_ACTOS(),
GetSD_OMISIONES(),
GetSD_CONTROV_TERR(),
GetSD_REVERSION(),
GetSD_SUBTOTAL_EJECUCION(),
GetSD_EJECUCION_CONVENIOS(),
GetSD_EJECUCION_LAUDOS(),
GetSD_RRT(),
GetSD_PRIVACION(),
GetSD_INCONFORMIDADES(),
GetSD_ASUNTOS_LEGIS(),
GetSD_OTROS_ASUNTOS(),
GetSCE_TOTAL_SENTENCIAS(),
GetSCE_SUBTOTAL_CON_TERR(),
GetSCE_CONTROV_TERR_NUCLEO(),
GetSCE_CONTROV_TERR_PROPIE(),
GetSCE_CONTROV_TERR_SOCIEDADE(),
GetSCE_CONTROV_TERR_POB_EJIDAL(),
GetSCE_SUBTOTAL_ASUNTOS_RESTIT(),
GetSCE_RESTIT_AUTORID(),
GetSCE_RESTIT_PARTIC(),
GetSCE_RECON(),
GetSCE_NULIDADES(),
GetSCE_TENENCIA(),
GetSCE_SUB_ASUNTOS_CONT_MA(),
GetSCE_CONTROV_MA_EJID(),
GetSCE_CONTROV_MA_NUCLEO(),
GetSCE_SUCESION_DA(),
GetSCE_SUBTOTAL_JN(),
GetSCE_JN_PROMOVIDOS(),
GetSCE_JN_ACTOS(),
GetSCE_OMISIONES(),
GetSCE_ASUNTOS_JV(),
GetSCE_CONTROV_TERR(),
GetSCE_REVERSION(),
GetSCE_SUBTOTAL_EJECUCION(),
GetSCE_EJECUCION_CONVENIOS(),
GetSCE_EJECUCION_LAUDOS(),
GetSCE_RRT(),
GetSCE_PRIVACION(),
GetSCE_INCONFORMIDADES(),
GetSCE_ASUNTOS_LEGIS(),
GetSCE_OTROS_ASUNTOS(),
GetSCR_TOTAL_SENTENCIAS(),
GetSCR_SUBTOTAL_CONTROV_TERR(),
GetSCR_CONTROV_TERR_NUCLEO(),
GetSCR_CONTROV_TERR_PROPIE(),
GetSCR_CONTROV_TERR_SOCIEDADE(),
GetSCR_CONTROV_TERR_POB_EJIDAL(),
GetSCR_SUBTOTAL_ASUNTOS_RESTIT(),
GetSCR_RESTIT_AUTORID(),
GetSCR_RESTIT_PARTIC(),
GetSCR_RECON(),
GetSCR_NULIDADES(),
GetSCR_TENENCIA(),
GetSCR_SUB_ASUNTOS_CONT_MA(),
GetSCR_CONTROV_MA_EJID(),
GetSCR_CONTROV_MA_NUCLEO(),
GetSCR_SUCESION_DA(),
GetSCR_SUBTOTAL_JN(),
GetSCR_JN_PROMOVIDOS(),
GetSCR_JN_ACTOS(),
GetSCR_OMISIONES(),
GetSCR_ASUNTOS_JV(),
GetSCR_CONTROV_TERR(),
GetSCR_REVERSION(),
GetSCR_SUBTOTAL_EJECUCION(),
GetSCR_EJECUCION_CONVENIOS(),
GetSCR_EJECUCION_LAUDOS(),
GetSCR_RRT(),
GetSCR_PRIVACION(),
GetSCR_INCONFORMIDADES(),
GetSCR_ASUNTOS_LEGIS(),
GetSCR_OTROS_ASUNTOS(),
GetLH_TOTAL_LAUDOS(),
GetLH_SUBTOTAL_CONTROV_TERR(),
GetLH_CONTROV_TERR_NUCLEO(),
GetLH_CONTROV_TERR_PROPIE(),
GetLH_CONTROV_TERR_SOCIEDADE(),
GetLH_CONTROV_TERR_POB_EJIDAL(),
GetLH_SUBTOTAL_ASUNTOS_RESTIT(),
GetLH_RESTIT_AUTORID(),
GetLH_RESTIT_PARTIC(),
GetLH_RECON(),
GetLH_NULIDADES(),
GetLH_TENENCIA(),
GetLH_SUB_ASUNTOS_CONT_MA(),
GetLH_CONTROV_MA_EJID(),
GetLH_CONTROV_MA_NUCLEO(),
GetLH_SUCESION_DA(),
GetLH_SUBTOTAL_JN(),
GetLH_JN_PROMOVIDOS(),
GetLH_JN_ACTOS(),
GetLH_OMISIONES(),
GetLH_CONTROV_TERR(),
GetLH_REVERSION(),
GetLH_SUBTOTAL_EJECUCION(),
GetLH_EJECUCION_CONVENIOS(),
GetLH_EJECUCION_LAUDOS(),
GetLH_RRT(),
GetLH_PRIVACION(),
GetLH_INCONFORMIDADES(),
GetLH_ASUNTOS_LEGIS(),
GetLH_OTROS_ASUNTOS(),
GetCSS_TOTAL_CONVENIOS(),
GetCSS_SUBTOTAL_CONTROV_TERR(),
GetCSS_CONTROV_TERR_NUCLEO(),
GetCSS_CONTROV_TERR_PROPIE(),
GetCSS_CONTROV_TERR_SOCIEDADE(),
GetCSS_CONTROV_TERR_POB_EJIDAL(),
GetCSS_SUBTOTAL_ASUNTOS_RESTIT(),
GetCSS_RESTIT_AUTORID(),
GetCSS_RESTIT_PARTIC(),
GetCSS_RECON(),
GetCSS_NULIDADES(),
GetCSS_TENENCIA(),
GetCSS_SUB_ASUNTOS_CONT_MA(),
GetCSS_CONTROV_MA_EJID(),
GetCSS_CONTROV_MA_NUCLEO(),
GetCSS_SUCESION_DA(),
GetCSS_SUBTOTAL_JN_(),
GetCSS_JN_PROMOVIDOS(),
GetCSS_JN_ACTOS(),
GetCSS_OMISIONES(),
GetCSS_ASUNTOS_JV(),
GetCSS_CONTROV_TERR(),
GetCSS_REVERSION(),
GetCSS_SUBTOTAL_EJECUCION(),
GetCSS_EJECUCION_CONVENIOS(),
GetCSS_EJECUCION_LAUDOS(),
GetCSS_RRT(),
GetCSS_PRIVACION(),
GetCSS_INCONFORMIDADES(),
GetCSS_ASUNTOS_LEGIS(),
GetCSS_OTROS_ASUNTOS(),
GetDES_TOTAL_DESMENTIMIENTOS(),
GetDES_SUBTOTAL_CONTROV_TERR(),
GetDES_CONTROV_TERR_NUCLEO(),
GetDES_CONTROV_TERR_PROPIE(),
GetDES_CONTROV_TERR_SOCIEDADE(),
GetDES_CONTROV_TERR_POB_EJIDAL(),
GetDES_SUBTOTAL_ASUNTOS_RESTIT(),
GetDES_RESTIT_AUTORID(),
GetDES_RESTIT_PARTIC(),
GetDES_RECON(),
GetDES_NULIDADES(),
GetDES_TENENCIA(),
GetDES_SUB_ASUNTOS_CONT_MA(),
GetDES_CONTROV_MA_EJID(),
GetDES_CONTROV_MA_NUCLEO(),
GetDES_SUCESION_DA(),
GetDES_SUBTOTAL_JN(),
GetDES_JN_PROMOVIDOS(),
GetDES_JN_ACTOS(),
GetDES_OMISIONES(),
GetDES_ASUNTOS_JV(),
GetDES_CONTROV_TERR(),
GetDES_REVERSION(),
GetDES_SUBTOTAL_EJECUCION(),
GetDES_EJECUCION_CONVENIOS(),
GetDES_EJECUCION_LAUDOS(),
GetDES_RRT(),
GetDES_PRIVACION(),
GetDES_INCONFORMIDADES(),
GetDES_ASUNTOS_LEGIS(),
GetDES_OTROS_ASUNTOS(),
GetCAD_TOTAL_CADUCIDADES(),
GetCAD_SUBTOTAL_CONTROV_TERR(),
GetCAD_CONTROV_TERR_NUCLEO(),
GetCAD_CONTROV_TERR_PROPIE(),
GetCAD_CONTROV_TERR_SOCIEDADE(),
GetCAD_CONTROV_TERR_POB_EJIDAL(),
GetCAD_SUBTOTAL_ASUNTOS_RESTIT(),
GetCAD_RESTIT_AUTORID(),
GetCAD_RESTIT_PARTIC(),
GetCAD_RECON(),
GetCAD_NULIDADES(),
GetCAD_TENENCIA(),
GetCAD_SUB_ASUNTOS_CONT_MA(),
GetCAD_CONTROV_MA_EJID(),
GetCAD_CONTROV_MA_NUCLEO(),
GetCAD_SUCESION_DA(),
GetCAD_SUBTOTAL_JN(),
GetCAD_JN_PROMOVIDOS(),
GetCAD_JN_ACTOS(),
GetCAD_OMISIONES(),
GetCAD_ASUNTOS_JV(),
GetCAD_CONTROV_TERR(),
GetCAD_REVERSION(),
GetCAD_SUBTOTAL_EJECUCION(),
GetCAD_EJECUCION_CONVENIOS(),
GetCAD_EJECUCION_LAUDOS(),
GetCAD_RRT(),
GetCAD_PRIVACION(),
GetCAD_INCONFORMIDADES(),
GetCAD_ASUNTOS_LEGIS(),
GetCAD_OTROS_ASUNTOS(),
GetOTRO_TOTAL_OTRO_TIPO(),
GetOTRO_SUBTOTAL_CONTROV_TERR(),
GetOTRO_CONTROV_TERR_NUCLEO(),
GetOTRO_CONTROV_TERR_PROPIE(),
GetOTRO_CONTROV_TERR_SOCIEDADE(),
GetOTRO_CONTROV_POB_EJIDAL(),
GetOTRO_SUBTOTAL_ASUNTOS_RESTIT(),
GetOTRO_RESTIT_AUTORID(),
GetOTRO_RESTIT_PARTIC(),
GetOTRO_RECON(),
GetOTRO_NULIDADES(),
GetOTRO_TENENCIA(),
GetOTRO_SUB_ASUNTOS_CONT_MA(),
GetOTRO_CONTROV_MA_EJID(),
GetOTRO_CONTROV_MA_NUCLEO(),
GetOTRO_SUCESION_DA(),
GetOTRO_SUBTOTAL_JN(),
GetOTRO_JN_PROMOVIDOS(),
GetOTRO_JN_ACTOS(),
GetOTRO_OMISIONES(),
GetOTRO_ASUNTOS_JV(),
GetOTRO_CONTROV_TERR(),
GetOTRO_REVERSION(),
GetOTRO_SUBTOTAL_EJECUCION(),
GetOTRO_EJECUCION_CONVENIOS(),
GetOTRO_EJECUCION_LAUDOS(),
GetOTRO_RRT(),
GetOTRO_PRIVACION(),
GetOTRO_INCONFORMIDADES(),
GetOTRO_ASUNTOS_LEGIS(),
GetOTRO_OTROS_ASUNTOS(),
GetSD_TOTAL_ESTAT(),
GetSD_ESTAT_NOTIFICAR(),
GetSD_ESTAT_TRANSCURSO(),
GetSD_ESTAT_IMPUGN_RR(),
GetSD_ESTAT_IMPUGN_JA(),
GetSD_ESTAT_EJECUCION(),
GetSDE_TOTAL_TIPO(),
GetSDE_EJECUCION(),
GetSDE_CONVENIOS(),
GetTOTAL_ASUNTOS_CONCL(),
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
