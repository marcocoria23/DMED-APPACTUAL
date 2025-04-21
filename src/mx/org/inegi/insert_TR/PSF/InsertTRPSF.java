/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TR.PSF;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mx.org.inegi.conexion.PSF.OracleDAOFactoryPSF;

/**
 *
 * @author ANTONIO.CORIA
 */
public class InsertTRPSF {
    
    public void InsertTRPSF(String Año) throws SQLException{
    CallableStatement st;
        Connection con = null;
        con = OracleDAOFactoryPSF.creaConexion();
        
      try {
     
         st = con.prepareCall("{call PKG_CARGA_GOF_"+Año+".PM_INICIO}");
            // Registra el parámetro de salida
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
