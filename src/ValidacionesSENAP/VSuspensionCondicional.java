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
public class VSuspensionCondicional {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";

    //ReglaNegocio 17.6. La plantilla Suspensión condicional es requisitada, el campo Fecha en que se cumplimentó la suspensión condicional del proceso (columna J) debe ser requisitado y las plantillas MASC y Sentencia no deben ser requisitadas.
    public ArrayList TABLA_SUSPENSIONCONDICIONAL(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select SC.ENTIDADID, SC.PERIODO, SC.CARPETAID, SC.IMPUTADOID, SC.PROCESOID, SC.SUSPENSIONCONDICIONALID, SC.TABLA_SUSPENSIONCONDICIONAL, SC.FECHACUMPSUSPENCONDIPROCESO, MASC.TABLA_MASC, S.TABLA_SENTENCIA\n"
                + "from (\n"
                + " select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO,\n"
                + " count (PROCESOID) AS TABLA_SUSPENSIONCONDICIONAL \n"
                + " from TR_SENAP_SUSPENSIONCONDICIONAL \n"
                + " group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO\n"
                + " ) SC\n"
                + "left join (\n"
                + " select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID,\n"
                + " count (PROCESOID) AS TABLA_MASC \n"
                + " from TR_SENAP_MASC \n"
                + " group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID\n"
                + " ) MASC\n"
                + " on SC.PERIODO = MASC.PERIODO and SC.ENTIDADID = MASC.ENTIDADID and SC.CARPETAID = MASC.CARPETAID and SC.PROCESOID = MASC.PROCESOID\n"
                + "left join (\n"
                + " select ENTIDADID, PERIODO, CARPETAID,PROCESOID,  \n"
                + " count (PROCESOID) AS TABLA_SENTENCIA \n"
                + " from TR_SENAP_SENTENCIA \n"
                + " group by ENTIDADID, PERIODO, CARPETAID, PROCESOID\n"
                + " ) S\n"
                + " on MASC.PERIODO = S.PERIODO and MASC.ENTIDADID = S.ENTIDADID and MASC.CARPETAID = S.CARPETAID and MASC.PROCESOID = S.PROCESOID\n"
                + "where SC.TABLA_SUSPENSIONCONDICIONAL is not null\n"
                + "and SC.FECHACUMPSUSPENCONDIPROCESO is null\n"
                + "and (MASC.TABLA_MASC is not null \n"
                + " or S.TABLA_SENTENCIA is not null) AND (SC.ENTIDADID='" + Entidad + "' AND SC.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSuspensionCondicional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 17.6.1. El campo Fecha en que dictó el sobreseimiento (columna G) de la plantilla Sobreseimiento debe ser mayor al campo Fecha en que se cumplimentó la suspensión condicional del proceso (columna J).
    public ArrayList FECHACUMPSUSPENCONDIPROCESO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select SC.ENTIDADID, SC.PERIODO, SC.CARPETAID, SC.IMPUTADOID, SC.PROCESOID, SC.SUSPENSIONCONDICIONALID, SB.FECHADICTOSOBRESEIMIENTO, SC.FECHACUMPSUSPENCONDIPROCESO\n"
                + "from TR_SENAP_SUSPENSIONCONDICIONAL SC\n"
                + "left join TR_SENAP_SOBRESEIMIENTO SB\n"
                + " on SC.PERIODO = SB.PERIODO and SC.ENTIDADID = SB.ENTIDADID and SC.CARPETAID = SB.CARPETAID and SC.PROCESOID = SB.PROCESOID\n"
                + "where SB.FECHADICTOSOBRESEIMIENTO <= SC.FECHACUMPSUSPENCONDIPROCESO  AND (SB.FECHADICTOSOBRESEIMIENTO<>'01/01/1900') and (SC.FECHACUMPSUSPENCONDIPROCESO<>'01/01/1900') AND (SC.ENTIDADID='" + Entidad + "' AND SC.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSuspensionCondicional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 17.7. El campo Etapa en la que se dictó  la suspensión condicional del proceso es requisitado con la opción "Etapa intermedia" (1) entonces el campo Etapa procesal en la que se encuentra el imputado debe ser igual a "Etapa intermedia" (3) y el campo ¿Se dictó auto de apertura a juicio oral? (columna K) debe ser requisitado con la opción "No" (2).
    public ArrayList CATSUSCONID(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select SC.ENTIDADID, SC.PERIODO, SC.CARPETAID, SC.IMPUTADOID, SC.PROCESOID, SC.SUSPENSIONCONDICIONALID, SC.CATSUSCONID, P.CATETAPAPROCESALID, EI.DICTAUTAPERJUICIO\n"
                + "from TR_SENAP_SUSPENSIONCONDICIONAL SC\n"
                + "left join TR_SENAP_PROCESO P\n"
                + " on SC.PERIODO = P.PERIODO and SC.ENTIDADID = P.ENTIDADID and SC.CARPETAID = P.CARPETAID and SC.PROCESOID = P.PROCESOID\n"
                + "left join TR_SENAP_ETAPAINTERMEDIA EI\n"
                + " on P.PERIODO = EI.PERIODO and P.ENTIDADID = EI.ENTIDADID and P.CARPETAID = EI.CARPETAID and P.PROCESOID = EI.PROCESOID\n"
                + "where SC.CATSUSCONID = 1\n"
                + "and P.CATETAPAPROCESALID <> 3\n"
                + "and EI.DICTAUTAPERJUICIO <> 2 AND (SC.ENTIDADID='" + Entidad + "' AND SC.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSuspensionCondicional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocioAdicional 20.1.5. En la plantilla Suspensión condicional existen registros, no debe haber registros en las plantillas MASC y Sobreseimiento
    public ArrayList TABLA_MASC(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select SC.ENTIDADID, SC.PERIODO, SC.CARPETAID, SC.IMPUTADOID, SC.PROCESOID, SC.SUSPENSIONCONDICIONALID, MASC.TABLA_MASC, SB.TABLA_SOBRESEIMIENTO\n"
                + "from TR_SENAP_SUSPENSIONCONDICIONAL SC\n"
                + "left join (\n"
                + " select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID,\n"
                + " count (PROCESOID) AS TABLA_MASC \n"
                + " from TR_SENAP_MASC \n"
                + " group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MASCID\n"
                + " ) MASC\n"
                + " on SC.PERIODO = MASC.PERIODO and SC.ENTIDADID = MASC.ENTIDADID and SC.CARPETAID = MASC.CARPETAID and SC.PROCESOID = MASC.PROCESOID\n"
                + "left join (\n"
                + " select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID,\n"
                + " count (PROCESOID) AS TABLA_SOBRESEIMIENTO \n"
                + " from TR_SENAP_SOBRESEIMIENTO \n"
                + " group by ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SOBRESEIMIENTOID\n"
                + " ) SB\n"
                + " on MASC.PERIODO = SB.PERIODO and MASC.ENTIDADID = SB.ENTIDADID and MASC.CARPETAID = SB.CARPETAID and MASC.PROCESOID = SB.PROCESOID\n"
                + "where MASC.TABLA_MASC is not null\n"
                + "and SB.TABLA_SOBRESEIMIENTO is not null AND (SC.ENTIDADID='" + Entidad + "' AND SC.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSuspensionCondicional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 17.1. El campo Fecha en que se dictó la suspensión condicional del proceso (columna E) es requisitado, debe ser mayor o igual al campo Fecha en que se dictó el auto de vinculación a proceso (columna G) de la plantilla Investigación complementaria.
    public ArrayList FECHADICSUSCONPRO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select SC.ENTIDADID, SC.PERIODO, SC.CARPETAID, SC.IMPUTADOID, SC.PROCESOID, SC.SUSPENSIONCONDICIONALID, SC.FECHADICSUSCONPRO, IC.FECHAVINCPROS\n"
                + "from TR_SENAP_SUSPENSIONCONDICIONAL SC\n"
                + "inner join TR_SENAP_INVESTIGACIONCOMPLEMENTARIA IC\n"
                + " on SC.PERIODO = IC.PERIODO and SC.ENTIDADID = IC.ENTIDADID and SC.CARPETAID = IC.CARPETAID and SC.PROCESOID = IC.PROCESOID\n"
                + "where SC.FECHADICSUSCONPRO < IC.FECHAVINCPROS AND (SC.FECHADICSUSCONPRO<>'01/01/1900') and (IC.FECHAVINCPROS<>'01/01/1900') AND (SC.ENTIDADID='" + Entidad + "' AND SC.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSuspensionCondicional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 17.2. El campo Fecha en que se dictó la suspensión condicional del proceso (columna E) es requisitado, debe ser mayor o igual al campo Fecha de la reapertura del proceso (columna G) de la plantilla Investigación complementaria.
    public ArrayList FECHAREAPERTURAPROCESO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHAREAPERTURAPROCESO, FECHADICSUSCONPRO\n"
                + "from TR_SENAP_SUSPENSIONCONDICIONAL\n"
                + "where FECHAREAPERTURAPROCESO is null\n"
                + "and FECHAREAPERTURAPROCESO <= FECHADICSUSCONPRO AND (FECHAREAPERTURAPROCESO<>'01/01/1900') and (FECHADICSUSCONPRO<>'01/01/1900') AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSuspensionCondicional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 17.3. El campo ¿Hubo reapertura del proceso? (columna H) es requisitado con la opción “Si” (1) entonces el campo Fecha de reapertura del proceso (columna I) debe ser requisitado.
    public ArrayList HUBOREAPERTURAPROCESO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, HUBOREAPERTURAPROCESO, FECHAREAPERTURAPROCESO\n"
                + "from TR_SENAP_SUSPENSIONCONDICIONAL\n"
                + "where HUBOREAPERTURAPROCESO = 1\n"
                + "and FECHAREAPERTURAPROCESO is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSuspensionCondicional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 17.3.1.  El campo ¿Hubo reapertura del proceso? (columna H) es diferente a la opción “Si” (1) entonces el campo Fecha de reapertura del proceso (columna I) no debe ser requisitado.
    public ArrayList HUBOREAPERTURAPROCESO1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, HUBOREAPERTURAPROCESO, FECHAREAPERTURAPROCESO\n"
                + "from TR_SENAP_SUSPENSIONCONDICIONAL\n"
                + "where HUBOREAPERTURAPROCESO <> 1\n"
                + "and FECHAREAPERTURAPROCESO is not null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSuspensionCondicional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 17.4. El campo Fecha en que se cumplimentó la suspensión condicional del proceso (columna J) debe ser mayor o igual al campo Fecha en que se dictó la suspensión condicional del proceso (columna E).
    public ArrayList FECHACUMPSUSPENCONDIPROCESO1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, FECHACUMPSUSPENCONDIPROCESO, FECHADICSUSCONPRO\n"
                + "from TR_SENAP_SUSPENSIONCONDICIONAL\n"
                + "where FECHACUMPSUSPENCONDIPROCESO < FECHADICSUSCONPRO AND (FECHACUMPSUSPENCONDIPROCESO<>'01/01/1900') and (FECHADICSUSCONPRO<>'01/01/1900') AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSuspensionCondicional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 17.5. El campo ¿Hubo reapertura del proceso? (columna H) es requisitado con la opción “Si” (1), entonces el campo Fecha en que se cumplimentó la suspensión condicional del proceso (columna J) no debe ser requerido y el campo Fecha de reapertura del proceso (columna I) debe ser requisitado.
    public ArrayList HUBOREAPERTURAPROCESO2(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, SUSPENSIONCONDICIONALID, HUBOREAPERTURAPROCESO, FECHAREAPERTURAPROCESO, FECHACUMPSUSPENCONDIPROCESO\n"
                + "from TR_SENAP_SUSPENSIONCONDICIONAL\n"
                + "where HUBOREAPERTURAPROCESO = 1\n"
                + "and (FECHACUMPSUSPENCONDIPROCESO is not null\n"
                + " or FECHAREAPERTURAPROCESO is null)  AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VSuspensionCondicional.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. La FECHADICSUSCONPRO (Indica la etapa del proceso penal en la que se decretó la suspensión condicional del proceso. ) No debe de ser mayor a la fecha actual.
    public ArrayList FECHADICSUSCONPROMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,SUSPENSIONCONDICIONALID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHADICSUSCONPRO\n"
                + "FROM TR_SENAP_SUSPENSIONCONDICIONAL\n"
                + "WHERE FECHADICSUSCONPRO > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    //ReglaDMED. La FECHAREAPERTURAPROCESO () No debe de ser mayor a la fecha actual.
    public ArrayList FECHAREAPERTURAPROCESOMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,SUSPENSIONCONDICIONALID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHAREAPERTURAPROCESO\n"
                + "FROM TR_SENAP_SUSPENSIONCONDICIONAL\n"
                + "WHERE FECHAREAPERTURAPROCESO > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. La FECHACUMPSUSPENCONDIPROCESO () No debe de ser mayor a la fecha actual.
    public ArrayList FECHACUMPSUSPENCONDIPROCESOMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,SUSPENSIONCONDICIONALID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHACUMPSUSPENCONDIPROCESO\n"
                + "FROM TR_SENAP_SUSPENSIONCONDICIONAL\n"
                + "WHERE FECHACUMPSUSPENCONDIPROCESO > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("SUSPENSIONCONDICIONALID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
