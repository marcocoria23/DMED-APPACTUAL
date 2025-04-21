/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.Procedure.PSF;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mx.org.inegi.conexion.PSF.OracleDAOFactoryPSF;

/**
 *
 * @author ANTONIO.CORIA
 */
public class EliminaBDPSFTMP {
     
    
  public void EliminaBD(String Año) throws SQLException{
    CallableStatement st;
        Connection con = null;
        con = OracleDAOFactoryPSF.creaConexion();
        
      try {
     
         st = con.prepareCall("{call CLEANPROGRAMASBDTMP(?)}");
            // Registra el parámetro de salida
            st.setString(1, Año);
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

