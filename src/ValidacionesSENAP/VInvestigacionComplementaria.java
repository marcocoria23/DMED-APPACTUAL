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
//VALIDACIONES DE LA TALA INVESTIGACIÓN COMPLEMENTARIA
public class VInvestigacionComplementaria {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";

    //-----campo:    FormulacionImputacion ----------------***
    //ReglaNegocio 12.2. El campo ¿Hubo formulación de la imputación? (columna E) es requisitado con la opción “Sí” (1), entonces el campo Fecha de formulación de la imputación (columna F) debe ser requisitada.
    public ArrayList FormulacionImputacion(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, FORMULACIONIMPUTACION, FECHAFORMIMP\n"
                + "from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "where FORMULACIONIMPUTACION = 1 and FECHAFORMIMP is null"
                + " AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 12.2.1. El campo ¿Hubo formulación de la imputación? (columna E) no es requisitado con la opción “Si” (1), entonces el campo Fecha de formulación de la imputación (columna F) no deberá ser requisitada.
    public ArrayList NoFormulacionImputacion(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, FORMULACIONIMPUTACION, FECHAFORMIMP\n"
                + "from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "where FORMULACIONIMPUTACION <> 1\n"
                + "and FECHAFORMIMP is not null"
                + " AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //-----campo:    FechaFormulacionImputacion ----------------***
    //ReglaNegocio 12.1. El campo Fecha formulación de la imputación (columna F) debe ser mayor o igual a la Fecha de audiencia inicial (columna I) de la plantilla Proceso.
    public ArrayList FechaFormulacionImputacion(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select IC.ENTIDADID, IC.PERIODO, IC.CARPETAID, IC.IMPUTADOID, IC.PROCESOID, IC.INVESTIGACIONCOMPLEMENTARIAID, IC.FECHAFORMIMP, P.FECHAAUDIENCIAINICIAL\n"
                + "from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA IC\n"
                + "left join TR_SENAP_PROCESO P\n"
                + "on IC.CARPETAID = P.CARPETAID and IC.PROCESOID = P.PROCESOID and IC.ENTIDADID = P.ENTIDADID and IC.PERIODO = P.PERIODO\n"
                + "where IC.FECHAFORMIMP < P.FECHAAUDIENCIAINICIAL AND (IC.FECHAFORMIMP <>'01/01/1900') and (P.FECHAAUDIENCIAINICIAL<>'01/01/1900')"
                + " AND (IC.ENTIDADID='" + Entidad + "' AND IC.PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // NO SE QUE ONDA CON ESTO
    //-----campo:    CatVinculacionProcesoID ----------------***
    //El campo Fecha formulación de la imputación (columna F) debe ser mayor o igual a la Fecha de audiencia inicial (columna I) de la plantilla Proceso.
    public ArrayList VinculacionProceso(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, CATVINCPROSID, FECHAVINCPROS\n"
                + "from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "where CATVINCPROSID <> 1\n"
                + "and FECHAVINCPROS is not null"
                + " AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 12.3. El campo Resolución del auto de vinculación a proceso (columna G) es requisitado con la opción "Vinculación a proceso" (1) debe registrarse la Fecha en que se dictó el auto de vinculación (columna H).
    public ArrayList NoVinculacionProceso(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, CATVINCPROSID, FECHAVINCPROS\n"
                + "from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "where CATVINCPROSID = 1\n"
                + "and FECHAVINCPROS is null"
                + " AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //-----campo:    FechaVinculacionProceso ----------------***
    //ReglaNegocio 12.4. El campo Fecha en que se dictó el auto de vinculación (columna H) debe ser mayor o igual a la Fecha de formulación de la imputación (columna F).
    public ArrayList FechaVinculacionProceso(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, FECHAVINCPROS, FECHAFORMIMP\n"
                + "from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "where FECHAVINCPROS < FECHAFORMIMP"
                + " AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //------------------REVISAR DESCRIPCIONES-----------------------------------------******************************************************************************************************************************************
    //-----campo:    MedidaCautelar ----------------***
    //ReglaNegocio 12.5. El campo ¿Se impuso medida cautelar? (columna G) no podrá ser diferente a la opción “Si”, si existen registros pertenecientes la plantilla Medidas cautelares.
    public ArrayList MedidaCautelar(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT IC.ENTIDADID, IC.PERIODO, IC.CARPETAID, IC.IMPUTADOID, IC.PROCESOID, IC.INVESTIGACIONCOMPLEMENTARIAID, IC.MEDIDACAUTELAR , MC.TABLA_MEDIDASCAUTELARES\n"
                + "FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA  IC\n"
                + "LEFT JOIN (\n"
                + " SELECT ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, MEDIDACAUTELARID,\n"
                + " COUNT (IMPUTADOID) AS TABLA_MEDIDASCAUTELARES \n"
                + " FROM TR_SENAP_MEDIDASCAUTELARES \n"
                + " GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, MEDIDACAUTELARID, IMPUTADOID\n"
                + " ) MC \n"
                + "on IC.ENTIDADID = MC.ENTIDADID and IC.PERIODO = MC.PERIODO and IC.CARPETAID = MC.CARPETAID and IC.PROCESOID = MC.PROCESOID \n"
                + "WHERE IC.MEDIDACAUTELAR = 1 \n"
                + "AND TABLA_MEDIDASCAUTELARES IS NULL AND (IC.ENTIDADID='" + Entidad + "' AND IC.PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 20.1.1. El campo ¿Se impuso medida cautelar? (columna I) es requisitado con la opción "NO" (1), NO deberá ser requisitada la plantilla Medidas cautelares.
    public ArrayList MedidaCautelar1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT IC.ENTIDADID, IC.PERIODO, IC.CARPETAID, IC.IMPUTADOID, IC.PROCESOID, IC.INVESTIGACIONCOMPLEMENTARIAID, IC.MEDIDACAUTELAR, MC.NUM_REG\n"
                + "FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA  IC\n"
                + "LEFT JOIN (\n"
                + " SELECT ENTIDADID, PERIODO, CARPETAID, PROCESOID, MEDIDACAUTELARID, IMPUTADOID,\n"
                + " COUNT (PROCESOID) AS NUM_REG \n"
                + " FROM TR_SENAP_MEDIDASCAUTELARES \n"
                + " GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, MEDIDACAUTELARID, IMPUTADOID\n"
                + " ) MC \n"
                + "on IC.ENTIDADID = MC.ENTIDADID\n"
                + "and IC.PERIODO = MC.PERIODO\n"
                + "and IC.CARPETAID = MC.CARPETAID\n"
                + "and IC.PROCESOID = MC.PROCESOID\n"
                + "WHERE IC.MEDIDACAUTELAR = 2 \n"
                + "AND NUM_REG is  not null"
                + " AND (IC.ENTIDADID='" + Entidad + "' AND IC.PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //-----campo:    FechaCierreInvestigacion ----------------***
    //ReglaNegocio 12.6. El campo Fecha de cierre de la investigación (columna J) debe ser mayor o igual al campo Fecha en que se dictó auto de vinculación (columna H).
    public ArrayList FechaCierreInvestigacion(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, FECHACIERREINV, FECHAVINCPROS\n"
                + "from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "where (FECHACIERREINV < FECHAVINCPROS) \n"
                + "AND FECHACIERREINV <> '01/01/1900' "
                + " AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //-----campo:    Acusacion ----------------***
    //ReglaNegocio 20.1.2. El campo ¿Se formuló acusación? (columna K) es requisitado con la opcion "Si" (1) debera ser requisitada la plantilla Etapa intermedia. 
    public ArrayList Acusacion(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT IC.ENTIDADID, IC.PERIODO, IC.CARPETAID, IC.IMPUTADOID, IC.PROCESOID, IC.INVESTIGACIONCOMPLEMENTARIAID, IC.ACUSACION, EI.NUM_REG\n"
                + "FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA  IC\n"
                + "LEFT JOIN (\n"
                + " SELECT ENTIDADID, PERIODO, CARPETAID, PROCESOID, IMPUTADOID, ETAPAINTERMEDIAID,\n"
                + " COUNT (IMPUTADOID) AS NUM_REG \n"
                + " FROM TR_SENAP_ETAPAINTERMEDIA \n"
                + " GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, ETAPAINTERMEDIAID, IMPUTADOID\n"
                + " ) EI \n"
                + "on IC.ENTIDADID = EI.ENTIDADID and IC.PERIODO = EI.PERIODO and IC.CARPETAID = EI.CARPETAID and IC.PROCESOID = EI.PROCESOID \n"
                + "WHERE IC.ACUSACION = 1 \n"
                + "AND NUM_REG IS NULL"
                + " AND (IC.ENTIDADID='" + Entidad + "' AND IC.PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 20.1.3. El campo ¿Se formuló acusación? (columna K) es es requisitado con la opción “No” (2) deberá ser requisitada la plantilla Sobreseimiento.
    public ArrayList NoAcusacion(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT IC.ENTIDADID, IC.PERIODO, IC.CARPETAID, IC.IMPUTADOID, IC.PROCESOID, IC.INVESTIGACIONCOMPLEMENTARIAID, IC.ACUSACION, S.SOBRESEIMIENTO\n"
                + "FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA  IC\n"
                + "LEFT JOIN (\n"
                + " SELECT ENTIDADID, PERIODO, CARPETAID,PROCESOID, IMPUTADOID,\n"
                + " COUNT (IMPUTADOID) AS SOBRESEIMIENTO \n"
                + " FROM TR_SENAP_SOBRESEIMIENTO \n"
                + " GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, SOBRESEIMIENTOID, IMPUTADOID\n"
                + " ) S \n"
                + "on IC.ENTIDADID = S.ENTIDADID and IC.PERIODO = S.PERIODO and IC.CARPETAID = S.CARPETAID and IC.PROCESOID = S.PROCESOID \n"
                + "WHERE IC.ACUSACION = 2\n"
                + "AND SOBRESEIMIENTO IS NULL"
                + " AND (IC.ENTIDADID='" + Entidad + "' AND IC.PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 20.1.3.1. El campo ¿Se formuló acusación? (columna K) es es requisitado con la opción “No” (2) debe ser requisitada la plantilla MASC.
    public ArrayList NoAcusacion1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT IC.ENTIDADID, IC.PERIODO, IC.CARPETAID, IC.IMPUTADOID, IC.PROCESOID, IC.INVESTIGACIONCOMPLEMENTARIAID, IC.ACUSACION, MASC.TABLA_MASC\n"
                + "FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA  IC\n"
                + "LEFT JOIN (\n"
                + " SELECT ENTIDADID, PERIODO, CARPETAID,PROCESOID, IMPUTADOID,\n"
                + " COUNT (IMPUTADOID) AS TABLA_MASC \n"
                + " FROM TR_SENAP_MASC \n"
                + " GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, MASCID, IMPUTADOID\n"
                + " ) MASC \n"
                + "on IC.ENTIDADID = MASC.ENTIDADID\n"
                + "and IC.PERIODO = MASC.PERIODO\n"
                + "and IC.CARPETAID = MASC.CARPETAID\n"
                + "and IC.PROCESOID = MASC.PROCESOID\n"
                + "WHERE IC.ACUSACION = 2\n"
                + "AND TABLA_MASC IS NULL"
                + " AND (IC.ENTIDADID='" + Entidad + "' AND IC.PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaAdicional 20.1.3.2. El campo ¿Se formuló acusación? (columna K) es es requisitado con la opción “No” (2) deberá ser requisitada la plantilla Suspensión condicional.
    public ArrayList NoAcusacion2(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT IC.ENTIDADID, IC.PERIODO, IC.CARPETAID, IC.IMPUTADOID, IC.PROCESOID, IC.INVESTIGACIONCOMPLEMENTARIAID, IC.ACUSACION, SC.TABLA_SUSPPENCIONCONDICIONAL\n"
                + "FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA  IC\n"
                + "LEFT JOIN (\n"
                + " SELECT ENTIDADID, PERIODO, CARPETAID,PROCESOID, IMPUTADOID,\n"
                + " COUNT (IMPUTADOID) AS TABLA_SUSPPENCIONCONDICIONAL \n"
                + " FROM TR_SENAP_SUSPENSIONCONDICIONAL \n"
                + " GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, SUSPENSIONCONDICIONALID, IMPUTADOID\n"
                + " ) SC \n"
                + "on IC.ENTIDADID = SC.ENTIDADID and IC.PERIODO = SC.PERIODO and IC.CARPETAID = SC.CARPETAID and IC.PROCESOID = SC.PROCESOID \n"
                + "WHERE IC.ACUSACION = 2\n"
                + "AND TABLA_SUSPPENCIONCONDICIONAL IS NULL"
                + " AND (IC.ENTIDADID='" + Entidad + "' AND IC.PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. La FECHACIERREINV (Fecha  del cierre de la investigación ) No debe de ser mayor a la fecha actual.
    public ArrayList FECHACIERREINVMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,INVESTIGACIONCOMPLEMENTARIAID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHACIERREINV\n"
                + "FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "WHERE FECHACIERREINV > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. La FECHAFORMIMP (Fecha de formulación de la imputación ) No debe de ser mayor a la fecha actual.
    public ArrayList FECHAFORMIMPMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,INVESTIGACIONCOMPLEMENTARIAID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHAFORMIMP\n"
                + "FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "WHERE FECHAFORMIMP > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. La FECHAVINCPROS (Fecha en que se dictó el auto de vinculación a proceso (aplica si se vinculó a proceso) ) No debe de ser mayor a la fecha actual.
    public ArrayList FECHAVINCPROSMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,INVESTIGACIONCOMPLEMENTARIAID,CARPETAID,IMPUTADOID,PROCESOID,PERIODO,FECHAVINCPROS\n"
                + "FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "WHERE FECHAVINCPROS > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. Favor de verififcar el campo ¿Hubo formulación de la imputación? FORMULACIONIMPUTACION debido a que no puede seleccionar una opción diferente a "Si" (1), "No" (2) y "No identificado" (3).
    public ArrayList FORMULACIONIMPUTACIONNOTNULL(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, FORMULACIONIMPUTACION\n"
                + "from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "where FORMULACIONIMPUTACION not in (1,2,9) or FORMULACIONIMPUTACION is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. Favor de verififcar el campo ¿Se formuló acusación?  ACUSACION debido a que no puede seleccionar una opción diferente a "Si" (1), "No" (2) y "No identificado" (3).
    public ArrayList FORMULACIONIMPUTACION122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, MEDIDACAUTELAR\n"
                + "from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "where MEDIDACAUTELAR not in (1,2,9) or MEDIDACAUTELAR is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. Favor de verififcar el campo ¿Se impuso medida cautelar? MEDIDACAUTELAR debido a que no puede seleccionar una opción diferente a "Si" (1), "No" (2) y "No identificado" (9).
    public ArrayList MEDIDACAUTELAR122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, ACUSACION\n"
                + "from TR_SENAP_INVESTIGACIONCOMPLEMENTARIA\n"
                + "where ACUSACION not in (1,2,9) or ACUSACION is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // ReglaNegocioAdicional 12.7.  El campo Resolución del auto de vinculación a proceso (columna G) es requisitado con la opción "No vinculación a proceso" (1) o "No identificado" (9), debe ser requisitada la plantilla Sobreseimiento.
    public ArrayList RESOLUCIONAUTOVINCAPROCESO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT IC.ENTIDADID, IC.PERIODO, IC.CARPETAID, IC.IMPUTADOID, IC.PROCESOID, IC.INVESTIGACIONCOMPLEMENTARIAID, IC.CATVINCPROSID, S.TABLA_SOBRESEIMIENTO\n"
                + "FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA  IC\n"
                + "LEFT JOIN (\n"
                + " SELECT ENTIDADID, PERIODO, CARPETAID,PROCESOID, IMPUTADOID,\n"
                + " COUNT (IMPUTADOID) AS TABLA_SOBRESEIMIENTO \n"
                + " FROM TR_SENAP_SOBRESEIMIENTO \n"
                + " GROUP BY ENTIDADID, PERIODO, CARPETAID, PROCESOID, SOBRESEIMIENTOID, IMPUTADOID\n"
                + " ) S\n"
                + "on IC.ENTIDADID = S.ENTIDADID and IC.PERIODO = S.PERIODO and IC.CARPETAID = S.CARPETAID and IC.PROCESOID = S.PROCESOID and IC.IMPUTADOID = S.IMPUTADOID\n"
                + "WHERE IC.CATVINCPROSID in (2,9)\n"
                + "AND TABLA_SOBRESEIMIENTO IS NULL"
                + "and  (IC.ENTIDADID='" + Entidad + "' AND IC.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    // ReglaNegocioAdicional 12.7.1. El campo Resolución del auto de vinculación a proceso (columna G) es requisitado con la opción "No vinculación a proceso" (1) o "No identificado" (9), no debe tener registros los campos Fecha en que se dictó el auto de vinculación a proceso, ¿Se impuso medida cautelar? (columna G), Fecha del cierre de la investigación y ¿Se formuló acusación? (columna I) .
    public ArrayList RESOLUCIONAUTOVINCAPROCESONO(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, INVESTIGACIONCOMPLEMENTARIAID, CATVINCPROSID, FECHAVINCPROS, MEDIDACAUTELAR, FECHACIERREINV, ACUSACION\n"
                + "FROM TR_SENAP_INVESTIGACIONCOMPLEMENTARIA  \n"
                + "WHERE CATVINCPROSID in (2,9)\n"
                + "AND (FECHAVINCPROS IS NOT NULL\n"
                + " OR MEDIDACAUTELAR IS NOT NULL\n"
                + " OR FECHACIERREINV IS NOT NULL\n"
                + " OR ACUSACION IS NOT NULL)"
                + "and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("INVESTIGACIONCOMPLEMENTARIAID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
}
