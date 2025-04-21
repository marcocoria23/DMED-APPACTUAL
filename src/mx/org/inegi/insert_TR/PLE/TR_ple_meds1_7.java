/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.insert_TR.PLE;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mx.org.inegi.conexion.PLE.OracleDAOFactory;

/**
 *
 * @author ANTONIO.CORIA
 */
public class TR_ple_meds1_7 {
  
  public void TR_ple_meds1_7(String Entidad,String Legislatura,String Envio) throws SQLException{
       
        CallableStatement st;
        Connection con = null;
        con = OracleDAOFactory.creaConexion();
        
      try {
     
         st = con.prepareCall("{call PKG_CARGA_PLE2.PM_PLE_MEDS1_7(?, ?, ?)}");
            // Registra el parámetro de salida
            st.setString(1, Entidad);
            st.setString(2, Legislatura);
            st.setString(3, Envio);
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
