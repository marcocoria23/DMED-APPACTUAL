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
public class VMandamientosJudiciales {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";

    //ReglaNegocio 11.1. El campo Fecha de solicitud del mandamiento judicial (columna E) debe ser mayor o igual al campo Fecha de apertura de la carpeta de investigación (columna X) de la plantilla Carpeta de investigación.
    public ArrayList FECHASOLMANDJUD(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select MJ.ENTIDADID, MJ.PERIODO, MJ.CARPETAID, MJ.IMPUTADOID, MJ.PROCESOID, MJ.MANDAMIENTOJUDICIALID, MJ.FECHASOLMANDJUD, CI.FECHACARINVE\n"
                + "from TR_SENAP_MANDAMIENTOSJUDICIALES MJ\n"
                + "left join TR_SENAP_CARPETAINVESTIGACION CI\n"
                + " on MJ.CARPETAID = CI.CARPETAID and MJ.ENTIDADID = CI.ENTIDADID and MJ.PERIODO = CI.PERIODO\n"
                + "where MJ.FECHASOLMANDJUD < CI.FECHACARINVE AND (MJ.FECHASOLMANDJUD<>'01/01/1900') and (CI.FECHACARINVE<>'01/01/1900') AND (MJ.ENTIDADID='" + Entidad + "' AND MJ.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("MANDAMIENTOJUDICIALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VMandamientosJudiciales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 11.2. El campo Fecha de libramiento del mandamiento (columna G) debe ser mayor o igual al campo Fecha de ingreso de la causa penal (columna F) de la plantilla Proceso.
    public ArrayList FECHALIBMAND(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select MJ.ENTIDADID, MJ.PERIODO, MJ.CARPETAID, MJ.IMPUTADOID, MJ.PROCESOID, MJ.MANDAMIENTOJUDICIALID, MJ.FECHALIBMAND, P.FECHAINICIO\n"
                + "from TR_SENAP_MANDAMIENTOSJUDICIALES MJ\n"
                + "left join TR_SENAP_PROCESO P\n"
                + " on MJ.ENTIDADID = P.ENTIDADID and MJ.PERIODO = P.PERIODO and MJ.CARPETAID = P.CARPETAID and MJ.PROCESOID = P.PROCESOID\n"
                + "where MJ.FECHALIBMAND < P.FECHAINICIO AND (MJ.FECHALIBMAND<>'01/01/1900') and (P.FECHAINICIO<>'01/01/1900') \n"
                + "AND (MJ.ENTIDADID='" + Entidad + "' AND MJ.PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("MANDAMIENTOJUDICIALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VMandamientosJudiciales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 11.5. El campo Estatus del mandamiento judicial (columna H) es requisitado con la opcion “Cumplimentado” (1) debe ser requisitado el campo Fecha de cumplimento del mandamiento judicial (columna I).
    public ArrayList ULTESTMAND(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MANDAMIENTOJUDICIALID, ULTESTMAND, FECHAULTESTMAND\n"
                + "from TR_SENAP_MANDAMIENTOSJUDICIALES\n"
                + "where ULTESTMAND = 1\n"
                + "and FECHAULTESTMAND is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("MANDAMIENTOJUDICIALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VMandamientosJudiciales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 11.3. El campo Fecha de cumplimento del mandamiento (columna I) debe ser mayor o igual al campo Fecha de libramiento del mandamiento (columna G).
    public ArrayList FECHAULTESTMAND(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MANDAMIENTOJUDICIALID, FECHAULTESTMAND, FECHALIBMAND\n"
                + "from TR_SENAP_MANDAMIENTOSJUDICIALES\n"
                + "where FECHAULTESTMAND < FECHALIBMAND AND (FECHAULTESTMAND<>'01/01/1900') and (FECHALIBMAND<>'01/01/1900') AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("MANDAMIENTOJUDICIALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VMandamientosJudiciales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaNegocio 11.4. El campo Estatus del mandamiento judicial (columna H) es requisitado con la opción “Cumplimentado” (1) debe ser requisitado el campo Fecha de cumplimento del mandamiento judicial (columna I).
    public ArrayList ULTESTMAND1(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, IMPUTADOID, PROCESOID, MANDAMIENTOJUDICIALID, ULTESTMAND, FECHAULTESTMAND\n"
                + "from TR_SENAP_MANDAMIENTOSJUDICIALES\n"
                + "where ULTESTMAND = 1\n"
                + "and FECHAULTESTMAND is null AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("MANDAMIENTOJUDICIALID"),
                    resul.getString("IMPUTADOID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VMandamientosJudiciales.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. La FECHASOLMANDJUD (Fecha de solicitud del mandamiento judicial ) No debe de ser mayor a la fecha actual.
    public ArrayList FECHASOLMANDJUDMayorA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,MANDAMIENTOJUDICIALID,CARPETAID,IMPUTADOID,PROCESOID,FECHASOLMANDJUD,PERIODO,FECHASOLMANDJUD\n"
                + "FROM TR_SENAP_MANDAMIENTOSJUDICIALES\n"
                + "WHERE FECHASOLMANDJUD > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("MANDAMIENTOJUDICIALID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. La FECHALIBMAND (Fecha de libramiento del mandamiento) No debe de ser mayor a la fecha actual.
    public ArrayList FECHALIBMANDMayorA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,MANDAMIENTOJUDICIALID,CARPETAID,IMPUTADOID,PROCESOID,FECHALIBMAND,PERIODO,FECHALIBMAND\n"
                + "FROM TR_SENAP_MANDAMIENTOSJUDICIALES\n"
                + "WHERE FECHALIBMAND > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("MANDAMIENTOJUDICIALID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //ReglaDMED. La FECHAULTESTMAND (Fecha de libramiento del mandamiento) No debe de ser mayor a la fecha actual.
    public ArrayList FECHAULTESTMANDMayorA(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,MANDAMIENTOJUDICIALID,CARPETAID,IMPUTADOID,PROCESOID,FECHAULTESTMAND,PERIODO,FECHAULTESTMAND\n"
                + "FROM TR_SENAP_MANDAMIENTOSJUDICIALES\n"
                + "WHERE FECHAULTESTMAND > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("MANDAMIENTOJUDICIALID")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
