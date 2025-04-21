/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author LAURA.MEDINAJ
 */
public class VSobreseimiento {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";

    //-----campo:    CATETAPASOBRESEIMIENTOID ----------------***
    //ReglaNegocio 16.2. Si en el campo En caso de sobreseimiento, etapa en la que se dictó el sobreseimiento se requisito la opción "Investigación complementaria", entonces el campo Etapa en la que se dictó el sobreseimiento (columna AG) debera corresponder con la opción Etapa de investigación complementaria de la plantilla Proceso
    public ArrayList SobreseimientoETAPA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select \n"
                + "s.ENTIDADID, s.SOBRESEIMIENTOID,\n"
                + "s.CARPETAID,s.IMPUTADOID,\n"
                + "s.PROCESOID,s.PERIODO,\n"
                + "s.CATETAPASOBRESEIMIENTOID,\n"
                + "p.CATETAPAPROCESALID from TR_SENAP_SOBRESEIMIENTO s  \n"
                + "left join tr_senap_proceso p on p.ENTIDADID=s.ENTIDADID and p.PROCESOID=s.PROCESOID and p.CARPETAID=s.CARPETAID and p.PERIODO=s.PERIODO\n"
                + "where s.CATETAPASOBRESEIMIENTOID=1 and p.CATETAPAPROCESALID<>2 AND (s.ENTIDADID='" + Entidad + "' AND s.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SOBRESEIMIENTOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 16.2. Si en el campo En caso de sobreseimiento, etapa en la que se dictó el sobreseimiento se requisito la opción "Investigación complementaria", entonces se deberá verificar que el campo Etapa en la que se dictó el sobreseimiento (columna AG) corresponda con la opción Etapa de investigación complementaria de la plantilla Proceso; además, que el campo ¿Se formuló acusación? (columna K) de la plantilla Investigación debe de traer la opción “No”
    public ArrayList SobreseimientoETAPA1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select \n"
                + "s.ENTIDADID, s.SOBRESEIMIENTOID,\n"
                + "s.CARPETAID,s.IMPUTADOID,\n"
                + "s.PROCESOID,s.PERIODO,\n"
                + "s.CATETAPASOBRESEIMIENTOID,\n"
                + "p.CATETAPAPROCESALID ,\n"
                + "ic.acusacion\n"
                + "from tr_senap_sobreseimiento s  \n"
                + "left join tr_senap_proceso p on p.ENTIDADID=s.ENTIDADID and p.PROCESOID=s.PROCESOID and p.CARPETAID=s.CARPETAID and p.PERIODO=s.PERIODO\n"
                + "left join tr_senap_investigacioncomplementaria ic on ic.ENTIDADID=s.ENTIDADID and ic.PROCESOID=s.PROCESOID and ic.CARPETAID=s.CARPETAID and ic.PERIODO=s.PERIODO\n"
                + "where s.CATETAPASOBRESEIMIENTOID=1 and p.CATETAPAPROCESALID=2 and  ic.acusacion<>2 AND (s.ENTIDADID='" + Entidad + "' AND s.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SOBRESEIMIENTOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 16.2. Si en el campo En caso de sobreseimiento, etapa en la que se dictó el sobreseimiento se requisito la opción "Investigación complementaria", entonces se deberá verificar que el campo Etapa en la que se dictó el sobreseimiento (columna AG) corresponda con la opción Etapa de investigación complementaria de la plantilla Proceso; además, que el campo ¿Se formuló acusación? (columna K) de la plantilla Investigación complementaria se haya requisitado la opción “No”. Y también las plantillas Etapa intermedia, MASC y Sentencia no deberán ser requisitadas.
    public ArrayList SobreseimientoMasc(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  s.ENTIDADID, s.SOBRESEIMIENTOID, s.CARPETAID,s.IMPUTADOID, s.PROCESOID,s.PERIODO, s.CATETAPASOBRESEIMIENTOID, p.CATETAPAPROCESALID , ic.acusacion, masc.num_reg as num_reg_masc,sen.num_reg as num_reg_sen,EI.num_reg as num_reg_EI,masc.num_reg+sen.num_reg+EI.num_reg AS SUMA\n"
                + "from tr_senap_sobreseimiento s  \n"
                + "left join tr_senap_proceso p on p.ENTIDADID=s.ENTIDADID and p.PROCESOID=s.PROCESOID and p.CARPETAID=s.CARPETAID and p.PERIODO=s.PERIODO\n"
                + "left join tr_senap_investigacioncomplementaria ic on ic.ENTIDADID=s.ENTIDADID and ic.PROCESOID=s.PROCESOID and ic.CARPETAID=s.CARPETAID and ic.PERIODO=s.PERIODO\n"
                + "left join(select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODo,count (PERIODO) as num_reg\n"
                + "from tr_senap_masc group by ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO) masc \n"
                + "on masc.ENTIDADID=s.ENTIDADID and masc.CARPETAID=s.CARPETAID and masc.PROCESOID=s.PROCESOID and masc.periodo=s.PERIODO\n"
                + "left join (select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODo,count (PERIODO) as num_reg\n"
                + "from tr_senap_sentencia group by ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO) sen \n"
                + "on sen.ENTIDADID=s.ENTIDADID and sen.CARPETAID=s.CARPETAID and sen.PROCESOID=s.PROCESOID and sen.periodo=s.PERIODO\n"
                + "left join (select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODo,count (PERIODO) as num_reg\n"
                + "from tr_senap_etapaintermedia group by ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO) ei\n"
                + "on EI.ENTIDADID=s.ENTIDADID and EI.CARPETAID=s.CARPETAID and EI.PROCESOID=s.PROCESOID and EI.periodo=s.PERIODO\n"
                + "where s.CATETAPASOBRESEIMIENTOID=1 and p.CATETAPAPROCESALID=2 and  ic.acusacion=2\n"
                + "AND masc.num_reg+sen.num_reg+EI.num_reg>0 AND (s.ENTIDADID='" + Entidad + "' AND s.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SOBRESEIMIENTOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 16.3. La pestaña de sobreseimiento no debe contener información debido a que no se ha cumplimentado la suspensión condicional
    public ArrayList SobreseimientoSuspension(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT S.ENTIDADID,S.CARPETAID,\n"
                + "S.IMPUTADOID,S.PROCESOID,\n"
                + "S.PERIODO,S.FECHADICTOSOBRESEIMIENTO,\n"
                + "SP.FECHACUMPSUSPENCONDIPROCESO\n"
                + "FROM TR_SENAP_SOBRESEIMIENTO S\n"
                + "LEFT JOIN (\n"
                + "select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHACUMPSUSPENCONDIPROCESO,\n"
                + " count (PROCESOID) AS NUM_REG \n"
                + " from TR_SENAP_SUSPENSIONCONDICIONAL \n"
                + " group by ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,\n"
                + "FECHACUMPSUSPENCONDIPROCESO) SP ON\n"
                + "S.ENTIDADID=SP.ENTIDADID AND S.CARPETAID=SP.CARPETAID AND \n"
                + "S.PROCESOID=SP.PROCESOID AND S.PERIODO=SP.PERIODO\n"
                + "WHERE SP.FECHACUMPSUSPENCONDIPROCESO IS NULL AND (s.ENTIDADID='" + Entidad + "' AND s.PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SOBRESEIMIENTOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 16.3. El campo Fecha en que se cumplimentó la suspensión condicional del proceso (columna J) debe ser menor al campo Fecha en que se dictó el sobreseimiento (columna G) de la plantilla Sobreseimiento.
    public ArrayList FechaSobreseimiento(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT S.ENTIDADID,S.CARPETAID,\n"
                + "S.IMPUTADOID,S.PROCESOID,\n"
                + "S.PERIODO,S.FECHADICTOSOBRESEIMIENTO,s.FECHADICTOSOBRESEIMIENTO,\n"
                + "SP.FECHACUMPSUSPENCONDIPROCESO\n"
                + "FROM TR_SENAP_SOBRESEIMIENTO S\n"
                + "LEFT JOIN (\n"
                + "select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHACUMPSUSPENCONDIPROCESO,\n"
                + " count (PROCESOID) AS NUM_REG \n"
                + " from TR_SENAP_SUSPENSIONCONDICIONAL \n"
                + " group by ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,\n"
                + "FECHACUMPSUSPENCONDIPROCESO) SP ON\n"
                + "S.ENTIDADID=SP.ENTIDADID AND S.CARPETAID=SP.CARPETAID AND \n"
                + "S.PROCESOID=SP.PROCESOID AND S.PERIODO=SP.PERIODO\n"
                + "WHERE SP.FECHACUMPSUSPENCONDIPROCESO IS NOT NULL AND FECHACUMPSUSPENCONDIPROCESO>FECHADICTOSOBRESEIMIENTO AND (FECHACUMPSUSPENCONDIPROCESO<>'01/01/1900') and (FECHADICTOSOBRESEIMIENTO<>'01/01/1900') \n"
                + " AND (s.ENTIDADID='" + Entidad + "' AND s.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SOBRESEIMIENTOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 16.4. En caso de sobreseimiento, etapa en la que se dictó el sobreseimiento se requisito la opción "Etapa intermedia", entonces el campo Etapa procesal en la que se encuentra el imputado corresponda con la opción Etapa intermedia de la plantilla Proceso
    public ArrayList SobreseimientoEtpInter(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select S.ENTIDADID,S.CARPETAID,S.IMPUTADOID,S.PROCESOID,S.PERIODO,S.CATETAPASOBRESEIMIENTOID\n"
                + "from tr_senap_sobreseimiento s\n"
                + "left join tr_senap_proceso p on p.ENTIDADID=s.ENTIDADID and p.PROCESOID=s.PROCESOID and s.CARPETAID=p.CARPETAID and \n"
                + " s.PERIODO=p.PERIODO\n"
                + "where CATETAPASOBRESEIMIENTOID=2 and p.CATETAPAPROCESALID<>3"
                + " AND (S.ENTIDADID='" + Entidad + "' AND S.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SOBRESEIMIENTOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 16.4. El campo ¿Se dictó auto de apertura a juicio oral?  (columna K) de la plantilla Etapa intermedia debe de ser la opción “No”
    public ArrayList Sobresei_jucioOral(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select S.ENTIDADID,S.CARPETAID,S.IMPUTADOID,S.PROCESOID,S.PERIODO,S.CATETAPASOBRESEIMIENTOID,\n"
                + "ei.DICTAUTAPERJUICIO\n"
                + "\n"
                + "from tr_senap_sobreseimiento s\n"
                + "left join tr_senap_proceso p on p.ENTIDADID=s.ENTIDADID and p.PROCESOID=s.PROCESOID and s.CARPETAID=p.CARPETAID and \n"
                + " s.PERIODO=p.PERIODO\n"
                + "left join tr_senap_etapaintermedia ei on ei.ENTIDADID=s.ENTIDADID and ei.PROCESOID=s.PROCESOID and s.CARPETAID=ei.CARPETAID and \n"
                + "s.PERIODO=ei.PERIODO\n"
                + "where CATETAPASOBRESEIMIENTOID=2 and p.CATETAPAPROCESALID=3 and DICTAUTAPERJUICIO<>2"
                + " AND (s.ENTIDADID='" + Entidad + "' AND s.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SOBRESEIMIENTOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocioAdicional 20.1.6. Si se encuentran registros en la plantilla Sobreseimiento, no deberá existir información relacionada en las plantillas MASC, Suspensión condicional y Sentencia.
    public ArrayList Sobreseimiento(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO, \n"
                + "num_reg_masc,num_reg_sp,num_reg_sen,\n"
                + "num_reg_masc+num_reg_sp+num_reg_sen as suma \n"
                + "from (\n"
                + "    select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO, \n"
                + "    case when num_reg_masc is null then 0 else num_reg_masc end num_reg_masc,\n"
                + "    case when num_reg_sp is null then 0 else num_reg_sp end num_reg_sp,\n"
                + "    case when num_reg_sen is null then 0 else num_reg_sen end num_reg_sen\n"
                + "    from (\n"
                + "        SELECT S.ENTIDADID,S.CARPETAID,S.IMPUTADOID,S.PROCESOID,S.PERIODO,\n"
                + "        masc.num_reg as num_reg_masc, sc.num_reg as num_reg_sp,\n"
                + "        sen.num_reg as num_reg_sen\n"
                + "        FROM TR_SENAP_SOBRESEIMIENTO S\n"
                + "        LEFT JOIN (\n"
                + "            select ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,\n"
                + "            count (PROCESOID) AS NUM_REG \n"
                + "            from TR_SENAP_SUSPENSIONCONDICIONAL \n"
                + "            group by ENTIDADID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO) Sc ON\n"
                + "            S.ENTIDADID=Sc.ENTIDADID AND S.CARPETAID=Sc.CARPETAID AND \n"
                + "            S.PROCESOID=Sc.PROCESOID AND S.PERIODO=Sc.PERIODO\n"
                + "        left join (\n"
                + "            select ENTIDADID,CARPETAID,\n"
                + "            IMPUTADOID,PROCESOID,\n"
                + "            PERIODo,count (PERIODO) as num_reg\n"
                + "            from tr_senap_masc group by ENTIDADID,\n"
                + "            CARPETAID,IMPUTADOID,\n"
                + "            PROCESOID,PERIODO)masc ON\n"
                + "        S.ENTIDADID=masc.ENTIDADID AND S.CARPETAID=masc.CARPETAID AND \n"
                + "        S.PROCESOID=masc.PROCESOID AND S.PERIODO=masc.PERIODO\n"
                + "            left join (\n"
                + "                select ENTIDADID,CARPETAID,\n"
                + "                IMPUTADOID,PROCESOID,\n"
                + "                PERIODo,count (PERIODO) as num_reg\n"
                + "                from tr_senap_sentencia group by ENTIDADID,\n"
                + "                CARPETAID,IMPUTADOID,\n"
                + "                PROCESOID,PERIODO)sen ON\n"
                + "            S.ENTIDADID=sen.ENTIDADID AND S.CARPETAID=sen.CARPETAID AND  \n"
                + "            S.PROCESOID=sen.PROCESOID AND S.PERIODO=sen.PERIODO))\n"
                + "     where num_reg_masc+num_reg_sp+num_reg_sen>0 "
                + " AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SOBRESEIMIENTOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 16.1. El campo Fecha en la que se dictó el sobreseimiento (columna G) debe ser mayor al campo Fecha de ingreso de la causa penal (columna K) de la plantilla Proceso. 
    public ArrayList Fecha_sobreseimiento(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select SB.ENTIDADID, SB.PERIODO, SB.CARPETAID, SB.IMPUTADOID, SB.PROCESOID, SB.SOBRESEIMIENTOID, SB.FECHADICTOSOBRESEIMIENTO, P.FECHAINICIO\n"
                + "from TR_SENAP_SOBRESEIMIENTO SB\n"
                + "inner join TR_SENAP_PROCESO P\n"
                + " on SB.ENTIDADID = P.ENTIDADID and SB.PERIODO = P.PERIODO and SB.CARPETAID = P.CARPETAID and SB.PROCESOID = P.PROCESOID\n"
                + "where SB.FECHADICTOSOBRESEIMIENTO <= P.FECHAINICIO  AND (SB.FECHADICTOSOBRESEIMIENTO<>'01/01/1900') and (P.FECHAINICIO<>'01/01/1900')"
                + " AND (SB.ENTIDADID='" + Entidad + "' AND SB.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SOBRESEIMIENTOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. La FECHADICTOSOBRESEIMIENTO (Fecha de la celebración de la audiencia intermedia ) No debe de ser mayor a la fecha actual.
    public ArrayList FECHADICTOSOBRESEIMIENTOMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,SOBRESEIMIENTOID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHADICTOSOBRESEIMIENTO\n"
                + "FROM TR_SENAP_SOBRESEIMIENTO\n"
                + "WHERE FECHADICTOSOBRESEIMIENTO > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SOBRESEIMIENTOID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
