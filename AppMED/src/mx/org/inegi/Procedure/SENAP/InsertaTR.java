/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.Procedure.SENAP;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mx.org.inegi.conexion.SENAP.ConORACLEFactory;

/**
 *
 * @author ANTONIO.CORIA
 */
public class InsertaTR {
    
       public void InsertaTRSENAP(String Entidad,String Periodo) throws SQLException{
    CallableStatement st;
        Connection con = null;
        con = ConORACLEFactory.creaConexion();
        
      try {
     
         st = con.prepareCall("{call PKG_CARGA_SENAP.PM_INICIO(?, ?)}");
            // Registra el parámetro de salida
            st.setString(1, Entidad);
            st.setString(2, Periodo);
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
