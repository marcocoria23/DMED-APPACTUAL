/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TMP.PSF;

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
    
public void InsertTR_PROGRAMAS_SOCIALES() throws SQLException {
    CallableStatement st = null;
    Connection con = null;

    try {
        con = OracleDAOFactoryPSF.creaConexion();

        st = con.prepareCall("{? = call PKG_INTEGRADORXLSM_TR.TR_GF_PROGRAMAS_SOCIALES()}");
        st.registerOutParameter(1, java.sql.Types.INTEGER);
        st.execute();

        int resultado = st.getInt(1);
        System.out.println("TR programas sociales insertados: " + resultado);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e + " Favor de contactar al administrador");
    } finally {
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
    }
}
      
 public void TR_GF_POBLACION_ATEND_MPIO() throws SQLException {
    CallableStatement st = null;
    Connection con = null;

    try {
        con = OracleDAOFactoryPSF.creaConexion();

        st = con.prepareCall("{? = call PKG_INTEGRADORXLSM_TR.TR_GF_POBLACION_ATEND_MPIO()}");
        st.registerOutParameter(1, java.sql.Types.INTEGER);
        st.execute();

        int resultado = st.getInt(1);
        System.out.println("TR población municipio insertados: " + resultado);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e + " Favor de contactar al administrador");
    } finally {
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
    }
}
 
 public void TR_GF_CONTRATACIONES_PUBLICAS() throws SQLException {
    CallableStatement st = null;
    Connection con = null;

    try {
        con = OracleDAOFactoryPSF.creaConexion();

        st = con.prepareCall("{? = call PKG_INTEGRADORXLSM_TR.TR_GF_CONTRATACIONES_PUBLICAS()}");
        st.registerOutParameter(1, java.sql.Types.INTEGER);
        st.execute();

        int resultado = st.getInt(1);
        System.out.println("TR contrataciones públicas insertados: " + resultado);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e + " Favor de contactar al administrador");
    } finally {
        if (st != null) {
            st.close();
        }
        if (con != null) {
            con.close();
        }
    }
}
      
}
