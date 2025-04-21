/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.QuerysGeneral.PSF;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.PSF.DaoConexionPSF;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Querys {

    DaoConexionPSF conexion = new DaoConexionPSF();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    
    

    public String Total_Reg_TMP(String Tabla) {
        conexion.Conectar();
        String TotalReg = "";
        sql = "SELECT COUNT(*) Total_RegTMP FROM  " + Tabla + " ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            if (resul.next()) {
                TotalReg = resul.getString("Total_RegTMP");
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
            // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
        return TotalReg;
    }

    public String Total_Reg_NITMP(String Tabla) {
        conexion.Conectar();
        String TotalReg = "";
        sql = "SELECT COUNT(*) Total_RegNITMP FROM TR_PSF_OBSERVACIONES WHERE TABLA='" + Tabla + "' ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            if (resul.next()) {
                TotalReg = resul.getString("Total_RegNITMP");
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
            // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
        return TotalReg;
    }

    public ArrayList TotalErrores_insert_TMP() throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select TABLA, ID_TABLA,replace(DESCRIPCION,',','')DESCRIPCION FROM TR_PSF_OBSERVACIONES WHERE TABLA LIKE '%TMP_%' "
                + " AND TABLA LIKE '%GEN%'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TABLA"),
                    resul.getString("ID_TABLA"),
                    resul.getString("DESCRIPCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList TotalErrores_insert_TR() throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select TABLA, ID_TABLA,replace(DESCRIPCION,',','')DESCRIPCION FROM TR_PSF_OBSERVACIONES WHERE TABLA LIKE '%TR_%' ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("TABLA"),
                    resul.getString("ID_TABLA"),
                    resul.getString("DESCRIPCION")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public String Anio() throws SQLException {
        conexion.Conectar();
        String Anio = "";
        sql = "SELECT EXTRACT(YEAR FROM SYSDATE) AS año_actual FROM dual";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            if (resul.next()) {
                Anio = resul.getString("año_actual");
                System.out.println(Anio);

            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Anio;
    }

    public int ValCreaTablas(String Anio) throws SQLException {
        conexion.Conectar();
        int ValCreaTablas = 0;
        sql = "SELECT count(*) as conteos from (select table_name\n"
                + "FROM ALL_TABLES\n"
                + "WHERE TABLE_NAME like '%_"+Anio+"')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            if (resul.next()) {
                ValCreaTablas = resul.getInt("conteos");
                System.out.println(ValCreaTablas);
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ValCreaTablas;
    }
    
    public int ValTablasAnio() throws SQLException {
        conexion.Conectar();
        int ValTablasAnio = 0;
        sql = "SELECT ( \n"
                + "  (SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM TR_GF_POBLACION_ATEND_MPIO_GEN)\n"
                + "  +\n"
                + "  (SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM TR_GF_CONTRATACIONES_PUBLICAS_GEN)\n"
                + "  +\n"
                + "  (SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM TR_GF_PROG_SOCIALES_GEN)\n"
                + ") AS CONTEOT\n"
                + "from dual";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            if (resul.next()) {
                ValTablasAnio = resul.getInt("CONTEOT");
                System.out.println(ValTablasAnio);
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ValTablasAnio;
    }

}
