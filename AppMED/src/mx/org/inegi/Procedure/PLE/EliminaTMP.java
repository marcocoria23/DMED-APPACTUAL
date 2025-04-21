/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.Procedure.PLE;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mx.org.inegi.conexion.PLE.OracleDAOFactory;


/**
 *
 * @author ANTONIO.CORIA
 */
public class EliminaTMP {
    
    
 public void EliminaTMP(String Entidad,String Envio,String Legislatura) throws SQLException{
       
        CallableStatement st;
        Connection con = null;
        con = OracleDAOFactory.creaConexion();
        
      try {
     
         st = con.prepareCall("{call ELIMINA_TMPOBS(?, ?, ?)}");
            // Registra el parámetro de salida
            st.setString(1, Entidad);
            st.setString(2, Envio);
            st.setString(3, Legislatura);
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
