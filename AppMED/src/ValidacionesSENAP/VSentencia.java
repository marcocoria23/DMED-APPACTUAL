
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidacionesSENAP;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.SENAP.ConOracle;

/**
 *
 * @author ANTONIO.CORIA
 */
public class VSentencia {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";

    //ReglaNegocio 18.6. Si la tabla TR_SENAP_SENTENCIA es requisitada, las tablas TR_SENAP_MASC, TR_SENAP_SOBRESEIMIENTO y TR_SENAP_SUSPENSIONCONDICIONAL no deben ser requisitadas.
    public ArrayList ESTATUSCARPETA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM(select S.ENTIDADID, S.PERIODO, S.CARPETAID, S.PROCESOID,S.IMPUTADOID, S.TABLA_SENTENCIA, SC.TABLA_SUSPENSIONCONDICIONAL, MASC.TABLA_MASC, SB.TABLA_SOBRESEIMIENTO\n"
                + "from (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID,PROCESOID,IMPUTADOID,  \n"
                + "	count (PROCESOID) AS TABLA_SENTENCIA \n"
                + "	from TR_SENAP_SENTENCIA \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID,IMPUTADOID\n"
                + "	) S                                                                                                            \n"
                + "left join (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID,\n"
                + "	count (PROCESOID) AS TABLA_SUSPENSIONCONDICIONAL \n"
                + "	from TR_SENAP_SUSPENSIONCONDICIONAL \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID\n"
                + "	) SC\n"
                + "	on S.PERIODO = SC.PERIODO and S.ENTIDADID = SC.ENTIDADID and S.CARPETAID = SC.CARPETAID and S.PROCESOID = SC.PROCESOID\n"
                + "left join (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID,\n"
                + "	count (PROCESOID) AS TABLA_MASC \n"
                + "	from TR_SENAP_MASC \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID\n"
                + "	) MASC\n"
                + "	on SC.PERIODO = MASC.PERIODO and SC.ENTIDADID = MASC.ENTIDADID and SC.CARPETAID = MASC.CARPETAID and SC.PROCESOID = MASC.PROCESOID\n"
                + "left join (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID,\n"
                + "	count (PROCESOID) AS TABLA_SOBRESEIMIENTO \n"
                + "	from TR_SENAP_SOBRESEIMIENTO \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID\n"
                + "	) SB\n"
                + "	on MASC.PERIODO = SB.PERIODO and MASC.ENTIDADID = SB.ENTIDADID and MASC.CARPETAID = SB.CARPETAID and MASC.PROCESOID = SB.PROCESOID\n"
                + "where S.TABLA_SENTENCIA is not null\n"
                + "and (SC.TABLA_SUSPENSIONCONDICIONAL is not null\n"
                + "	or MASC.TABLA_MASC is not null\n"
                + "	or SB.TABLA_SOBRESEIMIENTO is not null) )WHERE (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 18.7. El campo Fecha en que se cumplimentó la suspensión condicional del proceso (columna H) es requisitada, la plantilla Sentencia debe ser requisitada.
    public ArrayList FECHACUMPLIMIENTO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select S.ENTIDADID, S.PERIODO, S.CARPETAID, S.IMPUTADOID, S.PROCESOID, S.TABLA_SENAP_SENTENCIA, SC.FECHACUMPSUSPENCONDIPROCESO\n"
                + "from (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID,\n"
                + "	count (PROCESOID) AS TABLA_SENAP_SENTENCIA \n"
                + "	from TR_SENAP_SENTENCIA \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID\n"
                + "	) S\n"
                + "left join (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO,\n"
                + "	count (PROCESOID) AS TABLA_SUSPENSIONCONDICIONAL \n"
                + "	from TR_SENAP_SUSPENSIONCONDICIONAL \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO\n"
                + "	) SC\n"
                + "		on S.PERIODO = SC.PERIODO and S.ENTIDADID = SC.ENTIDADID and S.CARPETAID = SC.CARPETAID and S.PROCESOID = SC.PROCESOID\n"
                + "where SC.FECHACUMPSUSPENCONDIPROCESO is not null \n"
                + "	and S.TABLA_SENAP_SENTENCIA is null AND (S.ENTIDADID='" + Entidad + "' AND S.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 18.7. El campo Fecha en que se cumplimentó la suspensión condicional del proceso (columna H) no es requisitada y el campo ¿Hubo reapertura del proceso? (columna H) sea requisitado con la opcion “SÍ” (1), entonces la plantilla Sentencia no debe ser requisitada.
    public ArrayList FECHACUMPLIMIENTONS(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select S.ENTIDADID, S.PERIODO, S.CARPETAID, S.IMPUTADOID, S.PROCESOID, S.TABLA_SENAP_SENTENCIA, SC.FECHACUMPSUSPENCONDIPROCESO\n"
                + "from (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID,\n"
                + "	count (PROCESOID) AS TABLA_SENAP_SENTENCIA \n"
                + "	from TR_SENAP_SENTENCIA \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID\n"
                + "	) S\n"
                + "left join (\n"
                + "	select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO,HUBOREAPERTURAPROCESO,\n"
                + "	count (PROCESOID) AS TABLA_SUSPENSIONCONDICIONAL \n"
                + "	from TR_SENAP_SUSPENSIONCONDICIONAL \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO,HUBOREAPERTURAPROCESO\n"
                + "	) SC\n"
                + "		on S.PERIODO = SC.PERIODO and S.ENTIDADID = SC.ENTIDADID and S.CARPETAID = SC.CARPETAID and S.PROCESOID = SC.PROCESOID\n"
                + "where SC.FECHACUMPSUSPENCONDIPROCESO is null \n"
                + "	and SC.HUBOREAPERTURAPROCESO = 1\n"
                + "	and S.TABLA_SENAP_SENTENCIA is not null AND (S.ENTIDADID='" + Entidad + "' AND S.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DETERMINACIONID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 18.8. La plantilla Sentencia es requisitada y el campo Etapa procesal en la que se encuentra el imputado (columna AG) se requisito con la opción “Etapa intermedia” (3), en el campo ¿Se dictó auto de apertura a juicio oral? (columna k) de la plantilla Etapa Intermedia debe ser requisitado la opción “No” (2) y el campo ¿La sentencia fue derivada de un procedimiento abreviado? (columna G) debe ser requisitada con la opción “SÍ” (1).
    public ArrayList SENTENCIA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select S.ENTIDADID, S.PERIODO, S.CARPETAID,S.IMPUTADOID, S.PROCESOID, S.TABLA_SENTENCIA, P.CATETAPAPROCESALID, EI.DICTAUTAPERJUICIO, S.SENTENCIADERPROCABREV\n"
                + "from (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID,PROCESOID, SENTENCIADERPROCABREV,IMPUTADOID,\n"
                + "	count (PROCESOID) AS TABLA_SENTENCIA \n"
                + "	from TR_SENAP_SENTENCIA \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, SENTENCIADERPROCABREV,IMPUTADOID\n"
                + "	) S \n"
                + "left join TR_SENAP_PROCESO P\n"
                + "	on S.PERIODO = P.PERIODO and S.ENTIDADID = P.ENTIDADID and S.CARPETAID = P.CARPETAID and S.PROCESOID = P.PROCESOID\n"
                + "left join TR_SENAP_ETAPAINTERMEDIA EI\n"
                + "	on P.PERIODO = EI.PERIODO and P.ENTIDADID = EI.ENTIDADID and P.CARPETAID = EI.CARPETAID and P.PROCESOID = EI.PROCESOID\n"
                + "where S.TABLA_SENTENCIA is not null \n"
                + "	and P.CATETAPAPROCESALID = 3\n"
                + "	and (EI.DICTAUTAPERJUICIO <> 2 \n"
                + "	or S.SENTENCIADERPROCABREV <> 1) AND (S.ENTIDADID='+Entidad+' AND S.PERIODO='+Periodo+')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SENTENCIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSentencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 18.8.1. El campo ¿Hubo reapertura del proceso? HUBOREAPERTURAPROCESO es requisitada con la opción “SÍ” (1) y el campo Fecha en que se cumplimentó la suspensión condicional del proceso FECHACUMPSUSPENCONDIPROCESO no debe ser requisitada, así como la tabla TR_SENAP_SENTENCIA debe ser requisitada. 
    public ArrayList HUBOREAPERTURA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select SC.ENTIDADID, SC.PERIODO, SC.CARPETAID, SC.IMPUTADOID, SC.PROCESOID, SC.SUSPENSIONCONDICIONALID, SC.HUBOREAPERTURAPROCESO, SC.FECHACUMPSUSPENCONDIPROCESO, S.TABLA_SENTENCIA\n"
                + "from TR_SENAP_SUSPENSIONCONDICIONAL SC                                                                  \n"
                + "left join (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n"
                + "	count (PROCESOID) AS TABLA_SENTENCIA \n"
                + "	from TR_SENAP_SENTENCIA \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID\n"
                + "	) S\n"
                + "	on SC.ENTIDADID = S.ENTIDADID and SC.PERIODO = S.PERIODO and SC.CARPETAID = S.CARPETAID and SC.PROCESOID = S.PROCESOID\n"
                + "where SC.HUBOREAPERTURAPROCESO = 1\n"
                + "and SC.FECHACUMPSUSPENCONDIPROCESO is not null\n"
                + "and S.TABLA_SENTENCIA is not null AND (SC.ENTIDADID='" + Entidad + "' AND SC.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SENTENCIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 18.9. La plantilla Sentencia es requisitada y el campo Etapa procesal en la que se encuentra el imputado (columna AG) se requisito con la opción “Etapa intermedia” (4), en el campo ¿Se dictó auto de apertura a juicio oral? (columna k) de la plantilla Etapa Intermedia debe ser requisitado la opción “Si” (1) y el campo ¿La sentencia fue derivada de un procedimiento abreviado? (columna G) debe ser requisitada con la opción “No” (2).
    public ArrayList ETAPAPROCESAL(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select S.ENTIDADID, S.PERIODO, S.CARPETAID, S.PROCESOID, S.TABLA_SENTENCIA, P.CATETAPAPROCESALID, EI.DICTAUTAPERJUICIO, S.SENTENCIADERPROCABREV\n"
                + "from (                                                                                             \n"
                + "	select ENTIDADID, PERIODO, CARPETAID,PROCESOID, SENTENCIADERPROCABREV,\n"
                + "	count (PROCESOID) AS TABLA_SENTENCIA \n"
                + "	from TR_SENAP_SENTENCIA \n"
                + "	group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, SENTENCIADERPROCABREV\n"
                + "	) S \n"
                + "left join TR_SENAP_PROCESO P\n"
                + "	on S.PERIODO = P.PERIODO and S.ENTIDADID = P.ENTIDADID and S.CARPETAID = P.CARPETAID and S.PROCESOID = P.PROCESOID\n"
                + "left join TR_SENAP_ETAPAINTERMEDIA EI\n"
                + "	on P.PERIODO = EI.PERIODO and P.ENTIDADID = EI.ENTIDADID and P.CARPETAID = EI.CARPETAID and P.PROCESOID = EI.PROCESOID\n"
                + "where S.TABLA_SENTENCIA is not null \n"
                + "	and P.CATETAPAPROCESALID = 4\n"
                + "	and (EI.DICTAUTAPERJUICIO <> 1 \n"
                + "	or S.SENTENCIADERPROCABREV <> 2) AND (S.ENTIDADID='" + Entidad + "' AND S.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SENTENCIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //La plantilla Sentencia es requisitada y el campo Etapa procesal en la que se encuentra el imputado (columna AG) se requisito con la opción “Etapa intermedia” (4), en el campo ¿Se dictó auto de apertura a juicio oral? (columna k) de la plantilla Etapa Intermedia debe ser requisitado la opción “Si” (1) y el campo ¿La sentencia fue derivada de un procedimiento abreviado? (columna G) debe ser requisitada con la opción “No” (2).
    public ArrayList CELEBRACION(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select S.ENTIDADID, S.PERIODO, S.SENTENCIAID, S.CARPETAID, S.IMPUTADOID, S.PROCESOID, S.FECHACELEBAUDIJUICIO, EI.FECHACELAUDINTER\n"
                + "from TR_SENAP_SENTENCIA S\n"
                + "left join TR_SENAP_ETAPAINTERMEDIA EI\n"
                + "	on S.ENTIDADID = EI.ENTIDADID and S.PERIODO = EI.PERIODO and S.CARPETAID = EI.CARPETAID and S.PROCESOID = EI.PROCESOID\n"
                + "where S.FECHACELEBAUDIJUICIO <= EI.FECHACELAUDINTER AND (S.FECHACELEBAUDIJUICIO<>'01/01/1900') and (EI.FECHACELAUDINTER<>'01/01/1900') AND (S.ENTIDADID='" + Entidad + "' AND S.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SENTENCIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //El campo ¿La Sentencia fue derivada de un procedimiento abreviado? (columna G) es requisitado con la opción “Si” (1), entonces el campo Fecha en que se dictó el procedimiento abreviado (columna H) debe ser requisitado. 
    public ArrayList PROCABREVIADO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SENTENCIAID, SENTENCIADERPROCABREV, FECHADICTPROCABREV\n"
                + "from TR_SENAP_SENTENCIA \n"
                + "where SENTENCIADERPROCABREV = 1\n"
                + "and FECHADICTPROCABREV is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SENTENCIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //El campo Fecha de la celebración de la audiencia de juicio (columna E) es requisitado, entonces el campo Fecha en que se dictó el procedimiento abreviado (columna H) no debe ser requisitado.
    public ArrayList AUDIENCIAJUICIO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SENTENCIAID, FECHADICTPROCABREV, FECHACELEBAUDIJUICIO\n"
                + "from TR_SENAP_SENTENCIA \n"
                + "where FECHACELEBAUDIJUICIO is not null\n"
                + "and FECHADICTPROCABREV is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SENTENCIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //El campo ¿Se dictó auto de apertura a juicio oral? (columna K) de la plantilla Etapa intermedia no debe ser requisitado con la opción Si" (1), entonces el campo Fecha en que se dictó el procedimiento abreviado (columna H) no debe ser requisitado.
    public ArrayList JUICIOORAL(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select S.ENTIDADID, S.PERIODO, S.CARPETAID, S.IMPUTADOID, S.PROCESOID, S.SENTENCIAID, S.FECHADICTPROCABREV, EI.DICTAUTAPERJUICIO\n"
                + "from TR_SENAP_SENTENCIA S\n"
                + "left join TR_SENAP_ETAPAINTERMEDIA EI\n"
                + "	on S.ENTIDADID = EI.ENTIDADID and S.PERIODO = EI.PERIODO and S.CARPETAID = EI.CARPETAID and S.PROCESOID = EI.PROCESOID\n"
                + "where EI.DICTAUTAPERJUICIO = 1\n"
                + "and S.FECHADICTPROCABREV is not null AND (S.ENTIDADID='" + Entidad + "' AND S.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SENTENCIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //El campo Fecha en que se dictó la sentencia (columna I) debe ser mayor o igual al campo Fecha de la celebración de la audiencia de juicio (columna E).
    public ArrayList FECHASENTENCIA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SENTENCIAID, FECHADICTOSENTENCIA, FECHACELEBAUDIJUICIO\n"
                + "from TR_SENAP_SENTENCIA\n"
                + "where FECHADICTOSENTENCIA < FECHACELEBAUDIJUICIO AND (FECHADICTOSENTENCIA<>'01/01/1900') and (FECHACELEBAUDIJUICIO<>'01/01/1900')  AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SENTENCIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSentencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //La FECHACELEBAUDIJUICIO (Hace referencia del día, mes y año de la celebración de la audiencia de juicio) No debe de ser mayor a la fecha actual.
    public ArrayList FECHACELEBAUDIJUICIOMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,SENTENCIAID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHACELEBAUDIJUICIO\n"
                + "FROM TR_SENAP_SENTENCIA\n"
                + "WHERE FECHACELEBAUDIJUICIO > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SENTENCIAID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //La FECHADICTOSENTENCIA (Hace referencia del día, mes y año en que se dictó la resolución del estudio de fondo del asunto, por parte del tribunal de enjuiciamiento) No debe de ser mayor a la fecha actual.
    public ArrayList FECHADICTOSENTENCIAMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,SENTENCIAID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHADICTOSENTENCIA\n"
                + "FROM TR_SENAP_SENTENCIA\n"
                + "WHERE FECHADICTOSENTENCIA > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SENTENCIAID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
