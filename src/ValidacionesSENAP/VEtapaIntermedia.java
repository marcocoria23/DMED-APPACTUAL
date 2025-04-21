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
 * @author ANDREA.HERNANDEZL
 */
public class VEtapaIntermedia {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";

    //ReglaNegocio 14.1 El campo Fecha de escrito de la acusación (columna E) debera ser mayor o igual al campo Fecha de cierre de la investigación (columna J) de la plantilla Investigación complementaria.
    public ArrayList FECHAESCRITOACUSACION(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select EI.ENTIDADID, EI.PERIODO, EI.CARPETAID, EI.IMPUTADOID, EI.PROCESOID, EI.ETAPAINTERMEDIAID, EI.FECHAESCRITOACUSACION, IC.FECHACIERREINV\n"
                + "from TR_SENAP_ETAPAINTERMEDIA EI\n"
                + "left join TR_SENAP_INVESTIGACIONCOMPLEMENTARIA IC\n"
                + " on EI.ENTIDADID = IC.ENTIDADID and EI.PERIODO = IC.PERIODO and EI.CARPETAID = IC.CARPETAID and EI.PROCESOID = IC.PROCESOID\n"
                + "where EI.FECHAESCRITOACUSACION < IC.FECHACIERREINV AND (EI.FECHAESCRITOACUSACION<>'01/01/1900') and (IC.FECHACIERREINV<>'01/01/1900') \n"
                + "AND (EI.ENTIDADID='" + Entidad + "' AND EI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 14.4. El campo ¿Hubo celebración de audiencia intermedia? (columna F) es requisitado con la opcion "Si" (1) entonces el campo Fecha de la celebración de la audiencia intermedia (columna G) debe ser requisitado. 
    public ArrayList HUBOCELAUDINTER(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, ETAPAINTERMEDIAID, HUBOCELAUDINTER, FECHACELAUDINTER\n"
                + "from TR_SENAP_ETAPAINTERMEDIA\n"
                + "where HUBOCELAUDINTER = 1\n"
                + "and FECHACELAUDINTER is null \n"
                + "AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 14.3. El campo Fecha de la celebración de la audiencia intermedia (columna G) debera ser mayor al campo Fecha de audiencia inicial (columna I) de la plantilla Proceso.
    public ArrayList FECHACELAUDINTER(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select EI.ENTIDADID, EI.PERIODO, EI.CARPETAID, EI.IMPUTADOID, EI.PROCESOID, EI.ETAPAINTERMEDIAID, EI.FECHACELAUDINTER, P.FECHAAUDIENCIAINICIAL\n"
                + "from TR_SENAP_ETAPAINTERMEDIA EI\n"
                + "left join TR_SENAP_PROCESO P\n"
                + " on EI.CARPETAID = P.CARPETAID and EI.PROCESOID = P.PROCESOID and EI.ENTIDADID = P.ENTIDADID and EI.PERIODO = P.PERIODO\n"
                + "where EI.FECHACELAUDINTER <= P.FECHAAUDIENCIAINICIAL AND (EI.FECHACELAUDINTER<>'01/01/1900') and (P.FECHAAUDIENCIAINICIAL<>'01/01/1900') \n"
                + "AND (EI.ENTIDADID='" + Entidad + "' AND EI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 14.5.1 El campo ¿Hubo celebración de audiencia intermedia? (columna F) es requisitado con la opción “Si” (1), entonces los campos Fecha de la celebración de la audiencia intermedia (columna E), ¿Hubo presentación de medios de prueba? (columna F), Medios de prueba (presentados /excluidos) (columna G), ¿Contó con acuerdos probatorios? (columna H) y ¿Se dictó auto de apertura a juicio oral? (columna I) deben ser requisitados. 
    public ArrayList HUBOPRESMEDPRU(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, ETAPAINTERMEDIAID, HUBOCELAUDINTER, FECHACELAUDINTER, HUBOPRESMEDPRU, MEDIOSPRUEBA, CONTACUPROB, DICTAUTAPERJUICIO\n"
                + "FROM TR_SENAP_ETAPAINTERMEDIA  \n"
                + "WHERE HUBOCELAUDINTER = 1\n"
                + "    AND (FECHACELAUDINTER is null or  CONTACUPROB is null or DICTAUTAPERJUICIO is null\n"
                + "    OR (HUBOPRESMEDPRU is null and MEDIOSPRUEBA is null ) ) AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 14.5.2 El campo ¿Hubo celebración de audiencia intermedia? (columna F) es requisitado con la opción “No” (2) o "No identificado" (9), entonces los campos Fecha de la celebración de la audiencia intermedia (columna E), ¿Hubo presentación de medios de prueba? (columna F), Medios de prueba (presentados /excluidos) (columna G), ¿Contó con acuerdos probatorios? (columna H) y ¿Se dictó auto de apertura a juicio oral? (columna I) no deben ser requisitados. 
    public ArrayList MEDIOSPRUEBA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, ETAPAINTERMEDIAID, HUBOCELAUDINTER \n"
                + "from TR_SENAP_ETAPAINTERMEDIA  \n"
                + "where HUBOCELAUDINTER in (2,9)\n"
                + "and (FECHACELAUDINTER is not null\n"
                + " or HUBOPRESMEDPRU is not null\n"
                + " or MEDIOSPRUEBA is not null\n"
                + " or CONTACUPROB is not null\n"
                + " or DICTAUTAPERJUICIO is not null) AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 14.5.3 El campo El campo ¿Hubo celebración de audiencia intermedia? (columna F) es requisitado con la opción “No” (2) o "No identificado" (9), entonces la plantilla Sobreseimiento debe ser requisitada.
    public ArrayList HUBOCELAUDINTER1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select EI.ENTIDADID, EI.PERIODO, EI.CARPETAID, EI.IMPUTADOID, EI.PROCESOID, EI.ETAPAINTERMEDIAID, EI.HUBOCELAUDINTER, SB.TABLA_SOBRESEIMIENTO\n"
                + "from TR_SENAP_ETAPAINTERMEDIA EI\n"
                + "LEFT JOIN (\n"
                + " SELECT ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID,\n"
                + " COUNT (PROCESOID) AS TABLA_SOBRESEIMIENTO \n"
                + " FROM TR_SENAP_SOBRESEIMIENTO \n"
                + " GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID\n"
                + " ) SB \n"
                + " on EI.ENTIDADID = SB.ENTIDADID and EI.PERIODO = SB.PERIODO and EI.CARPETAID = SB.CARPETAID and EI.PROCESOID = SB.PROCESOID \n"
                + "where EI.HUBOCELAUDINTER in (2,9)\n"
                + "and SB.TABLA_SOBRESEIMIENTO is not null AND (EI.ENTIDADID='" + Entidad + "' AND EI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 14.6. El campo ¿Hubo presentación de medios de prueba? (columna H) es requisitado con la opción “Si” (1), entonces el campo Medios de prueba (columna I) debe ser requisitado. 
    public ArrayList HUBOPRESMEDPRU1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, ETAPAINTERMEDIAID, HUBOPRESMEDPRU, MEDIOSPRUEBA\n"
                + "from TR_SENAP_ETAPAINTERMEDIA\n"
                + "where HUBOPRESMEDPRU = 1\n"
                + "and MEDIOSPRUEBA is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 14.6.1 El campo ¿Hubo presentación de medios de prueba? (columna H) es diferente a la opción “Si” (1), entonces el campo Medios de prueba (columna I) no debe ser requisitado.
    public ArrayList HUBOPRESMEDPRU2(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, ETAPAINTERMEDIAID, HUBOPRESMEDPRU, MEDIOSPRUEBA\n"
                + "from TR_SENAP_ETAPAINTERMEDIA\n"
                + "where HUBOPRESMEDPRU <> 1\n"
                + "and MEDIOSPRUEBA is not null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 14.7. El campo ¿Hubo celebración de audiencia intermedia? (columna F) es requisitado con la opcion "Si" (1), entonces el campo ¿Contó con acuerdos probatorios? (columna J) debe ser requisitado con la opcion "Si" (1). 
    public ArrayList CONTACUPROB(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, ETAPAINTERMEDIAID, HUBOCELAUDINTER, CONTACUPROB\n"
                + "from TR_SENAP_ETAPAINTERMEDIA\n"
                + "where HUBOCELAUDINTER = 1\n"
                + "and CONTACUPROB <> 1 AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Regla Negocio 14.8. El campo ¿Hubo celebración de audiencia intermedia? (columna D) es requisitado con la opción "Sí" (1), entonces el campo ¿Se dictó auto de apertura a juicio oral? (columna K) debe ser requisitado con la opción "Si" (1).
    public ArrayList DICTAUTAPERJUICIO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, ETAPAINTERMEDIAID, HUBOCELAUDINTER, DICTAUTAPERJUICIO\n"
                + "from TR_SENAP_ETAPAINTERMEDIA\n"
                + "where HUBOCELAUDINTER = 1\n"
                + "and DICTAUTAPERJUICIO <> 1 AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 14.9. El campo ¿Se dictó auto de apertura a juicio oral? (columna K) es requisitado con la opción "Si" (1), entonces el campo ¿La sentencia fue derivada de un procedimiento abreviado? (columna G) de la plantilla Sentencia debe ser requisitado con la opción "Si" (1) y el campo Fecha en que se dictó el procedimiento abreviado (columna H) debe ser requisitado.
    public ArrayList SENTENCIADERPROCABREV(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select EI.ENTIDADID, EI.PERIODO, EI.CARPETAID, EI.IMPUTADOID, EI.PROCESOID, EI.ETAPAINTERMEDIAID, EI.DICTAUTAPERJUICIO, S.SENTENCIADERPROCABREV, S.FECHADICTPROCABREV\n"
                + "from TR_SENAP_ETAPAINTERMEDIA EI\n"
                + "left join TR_SENAP_SENTENCIA S\n"
                + " on EI.CARPETAID = S.CARPETAID and EI.PROCESOID = S.PROCESOID and EI.ENTIDADID = S.ENTIDADID and EI.PERIODO = S.PERIODO\n"
                + "where EI.DICTAUTAPERJUICIO = 1\n"
                + "and (S.SENTENCIADERPROCABREV <> 1 or S.FECHADICTPROCABREV is null) AND (EI.ENTIDADID='" + Entidad + "' AND EI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 14.10 El campo ¿Se dictó auto de apertura a juicio oral? (columna K) se requisito con la opción "Sí" (1) debe ser requisitada la plantilla Sentencia.
    public ArrayList DICTAUTAPERJUICI1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select EI.ENTIDADID, EI.PERIODO, EI.CARPETAID, EI.IMPUTADOID, EI.PROCESOID, EI.ETAPAINTERMEDIAID, EI.DICTAUTAPERJUICIO, S.TABLA_SENTENCIA\n"
                + "from TR_SENAP_ETAPAINTERMEDIA EI\n"
                + "left join (\n"
                + " select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID,\n"
                + " count (PROCESOID) AS TABLA_SENTENCIA \n"
                + " from TR_SENAP_SENTENCIA \n"
                + " group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID\n"
                + " ) S\n"
                + "  on EI.PERIODO = S.PERIODO and EI.ENTIDADID = S.ENTIDADID and EI.CARPETAID = S.CARPETAID and EI.PROCESOID = S.PROCESOID and EI.IMPUTADOID = S.IMPUTADOID\n"
                + "where EI.DICTAUTAPERJUICIO <> 1\n"
                + "and S.TABLA_SENTENCIA is not null"
                + " AND (EI.ENTIDADID='" + Entidad + "' AND EI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 14.10.1 El campo ¿Se dictó auto de apertura a juicio oral? (columna K) es diferente de la opción "Sí" (1) no debe ser requisitada la plantilla Sentencia.
    public ArrayList NODICTAUTAPERJUICI1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select EI.ENTIDADID, EI.PERIODO, EI.CARPETAID, EI.IMPUTADOID, EI.PROCESOID, EI.ETAPAINTERMEDIAID, EI.DICTAUTAPERJUICIO, S.TABLA_SENTENCIA\n"
                + "from TR_SENAP_ETAPAINTERMEDIA EI\n"
                + "left join (\n"
                + " select ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID,\n"
                + " count (PROCESOID) AS TABLA_SENTENCIA \n"
                + " from TR_SENAP_SENTENCIA \n"
                + " group by ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID\n"
                + " ) S\n"
                + "  on EI.PERIODO = S.PERIODO and EI.ENTIDADID = S.ENTIDADID and EI.CARPETAID = S.CARPETAID and EI.PROCESOID = S.PROCESOID and EI.IMPUTADOID = S.IMPUTADOID\n"
                + "where EI.DICTAUTAPERJUICIO <> 1\n"
                + "and S.TABLA_SENTENCIA is not null\n"
                + "AND (EI.ENTIDADID='" + Entidad + "' AND EI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // ReglaNegocio 14.2. La plantilla Etapa Intermedia es requisitada, entonces el campo ¿Se formuló acusación? (columna K) de la plantilla Investigación complementaria deberá ser requisitado con la opción “Si” (1). 
    public ArrayList ACUSACION(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select EI.ENTIDADID, EI.PERIODO, EI.CARPETAID, EI.IMPUTADOID, EI.PROCESOID, EI.ETAPAINTERMEDIAID, IC.ACUSACION, EI.TABLA_ETAPAINTERMEDIA\n"
                + "from (\n"
                + "  SELECT ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, ETAPAINTERMEDIAID,\n"
                + " COUNT (IMPUTADOID) AS TABLA_ETAPAINTERMEDIA \n"
                + " FROM TR_SENAP_ETAPAINTERMEDIA  \n"
                + " GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, ETAPAINTERMEDIAID\n"
                + " ) EI\n"
                + "left join TR_SENAP_INVESTIGACIONCOMPLEMENTARIA IC\n"
                + "  on EI.ENTIDADID = IC.ENTIDADID and EI.PERIODO = IC.PERIODO and EI.CARPETAID = IC.CARPETAID and EI.PROCESOID = IC.PROCESOID\n"
                + "where TABLA_ETAPAINTERMEDIA is not null\n"
                + "and IC.ACUSACION <> 1 AND (EI.ENTIDADID='" + Entidad + "' AND EI.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VEtapaIntermedia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED La FECHACELAUDINTER (Fecha de la celebración de la audiencia intermedia ) No debe de ser mayor a la fecha actual.
    public ArrayList FECHACELAUDINTERMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,ETAPAINTERMEDIAID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHACELAUDINTER\n"
                + "FROM TR_SENAP_ETAPAINTERMEDIA\n"
                + "WHERE FECHACELAUDINTER > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ETAPAINTERMEDIAID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED Favor de verificar el campo ¿Se dictó auto de apertura a juicio oral? DICTAUTAPERJUICIO debido a que no se puede seleccionar una opcion diferente a "Si" (1), "No" (2), "No identificado" (9).
    public ArrayList APERTURAJO122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, ETAPAINTERMEDIAID, PROCESOID, DICTAUTAPERJUICIO\n"
                + "FROM TR_SENAP_ETAPAINTERMEDIA\n"
                + "WHERE DICTAUTAPERJUICIO not in (1,2,9)\n"
                + "or DICTAUTAPERJUICIO is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("DELITOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
