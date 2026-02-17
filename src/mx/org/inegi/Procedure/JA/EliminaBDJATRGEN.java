/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.Procedure.JA;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mx.org.inegi.conexion.JA.OracleDAOFactoryJA;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class EliminaBDJATRGEN {
    
    public void EliminaBD() throws SQLException {
        CallableStatement st;
        Connection con = null;
        con = OracleDAOFactoryJA.creaConexion();
        
        try {
            st = con.prepareCall("{call TRUNCAR_INFO_JA()}");
            st.execute();
              System.out.println("Se ejecutó paquete para eliminar información de tablas GEN");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
        } finally {
            try {
                if (con != null){
                    System.out.println("Cierra conexión de BD para procedure TRUNCAR_INFO_JA");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex){
                throw new SQLException("[ERROR]: " + ex.getLocalizedMessage());
            }
        }
    }
    
}
