/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.Procedure.JA;

import java.sql.CallableStatement;
import mx.org.inegi.conexion.JA.OracleDAOFactoryJA;
import static Pantallas_JA.CreaEBD_JA.JAYear;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author LAURA.MEDINAJ
 */
public class CreaTRDinamica_JA {

    Connection conn = OracleDAOFactoryJA.creaConexion();
    CallableStatement callst;
    ResultSet rslset;

    public boolean CreaTablas() throws SQLException {
        try {
            CallableStatement st = conn.prepareCall("{call CREARTABLASDINAMICAS_JA(" + Integer.valueOf(JAYear) + ")}");
            System.out.println("{call CREARTABLASDINAMICAS_JA(" + Integer.valueOf(JAYear) + ")}");
            st.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
            return false;
        } finally {
            try {
                //Cierra conexión
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException ex) {
                throw new SQLException(ex.getLocalizedMessage());
            }
        }
        return true;

    }

    public int ValExistenTablas() throws SQLException {

        String ExisteTabla = "";
        String sql = "SELECT count(*) as CONTEOS from (select table_name FROM ALL_TABLES\n"
                + "WHERE  TABLE_NAME like 'TR_JA%' AND TABLE_NAME like '%_" + Integer.valueOf(JAYear) + "')";

        Statement sentencia = conn.createStatement();
        rslset = sentencia.executeQuery(sql);

        // Procesa el resultado de la consulta
        if (rslset.next()) {
            ExisteTabla = rslset.getString("CONTEOS");// Reemplaza "columna" con el nombre de tu columna
            System.out.println("Tablas dinámicas JA" + JAYear + " en base de datos: " + ExisteTabla);
        }

        return Integer.valueOf(ExisteTabla);
    }
}
