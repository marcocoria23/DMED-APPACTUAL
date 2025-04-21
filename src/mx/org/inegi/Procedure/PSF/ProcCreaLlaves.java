/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.Procedure.PSF;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mx.org.inegi.conexion.PSF.OracleDAOFactoryPSF;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class ProcCreaLlaves {
    
    public void CreaLlaves(int Anio) throws SQLException{
        CallableStatement st;
        Connection con = null;
        con = OracleDAOFactoryPSF.creaConexion();

        try {
            

            st = con.prepareCall("{call LLAVES(?)}"); //LLAVES
            // Registra el parámetro de salida
            st.setInt(1, Anio);
            st.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
        } finally {
            try {
                if (con != null) {
                    System.out.println("cierraaa");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
        }
    }

}
