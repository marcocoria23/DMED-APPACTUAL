/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.Procedure.TEPJF;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static Pantallas_TEPJF.Crea_estructura.YearTEPJF;
import mx.org.inegi.conexion.TEPJF.OracleDAOFactoryTEPJF;
/**
 *
 * @author LAURA.MEDINAJ
 */
public class CreaEstructura {



    public void CreaEstructura() throws SQLException {
        
     Connection conn = OracleDAOFactoryTEPJF.creaConexion();

        try {        
            CallableStatement st = conn.prepareCall("{call CREA_TEPJF_TABLAS(" + Integer.valueOf(YearTEPJF)  + ")}");         
            st.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e + "Favor de contactar al administrador");
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
    }

 
}
