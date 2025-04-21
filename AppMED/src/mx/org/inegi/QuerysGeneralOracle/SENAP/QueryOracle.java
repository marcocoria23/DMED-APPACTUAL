/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.QuerysGeneralOracle.SENAP;

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
public class QueryOracle {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;

    public String Total_Reg_TMP_Oracle(String Tabla, String entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        String TotalReg = "";
        sql = "SELECT COUNT(*) Total_RegTMP FROM  " + Tabla + " where  ENTIDADID='" + entidad + "' AND PERIODO='" + Periodo + "' ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            if (resul.next()) {
                TotalReg = resul.getString("Total_RegTMP");
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryOracle.class.getName()).log(Level.SEVERE, null, ex);
            // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
        return TotalReg;
    }

    public String Total_Reg_TR_Oracle(String Tabla, String entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        String TotalReg = "";
        sql = "SELECT COUNT(*) Total_RegTMP FROM  " + Tabla + " where  ENTIDADID='" + entidad + "' AND PERIODO='" + Periodo + "' ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            if (resul.next()) {
                TotalReg = resul.getString("Total_RegTMP");
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryOracle.class.getName()).log(Level.SEVERE, null, ex);
            // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
        return TotalReg;
    }

    public ArrayList TotalErrores_insert_SENAP_TMP(String entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select TABLA, ID_TABLA,CAMPO,replace(DESCRIPCION,',','')DESCRIPCION FROM SENAP_OBSERVACIONES "
                + " WHERE ENTIDADID='" + entidad + "' and PERIODO='" + Periodo + "' AND CAMPO LIKE '%TMP%'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TABLA"),
                    resul.getString("ID_TABLA"),
                    resul.getString("CAMPO"),
                    resul.getString("DESCRIPCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList TotalErrores_insert_SENAP_TR(String entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select TABLA, ID_TABLA,CAMPO,replace(DESCRIPCION,',','')DESCRIPCION FROM SENAP_OBSERVACIONES "
                + " WHERE ENTIDADID='" + entidad + "' and PERIODO='" + Periodo + "' AND CAMPO LIKE '%TR%'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TABLA"),
                    resul.getString("ID_TABLA"),
                    resul.getString("CAMPO"),
                    resul.getString("DESCRIPCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Periodo(String entidad) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select UNIQUE(PERIODO)PERIODO FROM TMP_SENAP_CARPETAINVESTIGACION "
                + " WHERE ENTIDADID='" + entidad + "' ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("Periodo")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList PeriodoTR(String entidad) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select UNIQUE(PERIODO)PERIODO FROM TR_SENAP_CARPETAINVESTIGACION "
                + " WHERE ENTIDADID='" + entidad + "' ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("Periodo")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public void Inserta_tr_senap_Control(String entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        sql = "INSERT INTO TR_SENAP_CONTROL (ENTIDADID,TOTAL_CARPETA_INVESTIGACION,TOTAL_VICTIMAS,TOTAL_IMPUTADOS,TOTAL_DELITOS,TOTAL_DETERMINACIONES,PERIODO,ESTATUS) VALUES ('" + entidad + "',(SELECT COUNT(*) FROM TMP_SENAP_CARPETAINVESTIGACION WHERE ENTIDADID='" + entidad + "' AND PERIODO='" + Periodo + "'),"
                + "(SELECT COUNT(*) FROM TMP_SENAP_VICTIMAS WHERE ENTIDADID='" + entidad + "' AND PERIODO='" + Periodo + "'),"
                + "(SELECT COUNT(*) FROM TMP_SENAP_IMPUTADO WHERE ENTIDADID='" + entidad + "' AND PERIODO='" + Periodo + "'),  "
                + "(SELECT COUNT(*) FROM TMP_SENAP_DELITOS WHERE ENTIDADID='" + entidad + "' AND PERIODO='" + Periodo + "'),"
                + "(SELECT COUNT(*) FROM TMP_SENAP_DETERMINACION WHERE ENTIDADID='" + entidad + "' AND PERIODO='" + Periodo + "'), "
                + "'" + Periodo + "','En Revision de Integracion TR')";
        System.out.println(sql);
        conexion.escribir(sql);
        conexion.close();
    }

    public void Limpia_tr_senap_Control(String entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        sql = "DELETE FROM TR_SENAP_CONTROL  WHERE ENTIDADID='" + entidad + "' AND PERIODO='" + Periodo + "'";
        System.out.println(sql);
        conexion.escribir(sql);
        conexion.close();
    }

    public void Actualiza_Estatus_tr_senap_Control(String entidad, String Periodo, String Estatus) throws SQLException {
        conexion.Conectar();
        sql = "UPDATE  TR_SENAP_CONTROL SET ESTATUS='" + Estatus + "' WHERE ENTIDADID='" + entidad + "' AND PERIODO='" + Periodo + "'";
        System.out.println(sql);
        conexion.escribir(sql);
        conexion.close();
    }

    public void Actualiza_Estatus_Validacion(String entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        sql = "UPDATE TR_SENAP_CONTROL SET ESTATUS='En Validacion' WHERE ENTIDADID='" + entidad + "' AND PERIODO='" + Periodo + "'";
        System.out.println(sql);
        conexion.escribir(sql);
        conexion.close();
    }

    public String Estatus_Control(String entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        String Est = "";
        sql = "Select ESTATUS FROM  TR_SENAP_CONTROL  WHERE ENTIDADID='" + entidad + "' AND PERIODO='" + Periodo + "'";
        resul = conexion.consultar(sql);
        System.out.println(sql);
        try {
            if (resul.next()) {
                Est = resul.getString("ESTATUS");
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QueryOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Est;
    }

}
