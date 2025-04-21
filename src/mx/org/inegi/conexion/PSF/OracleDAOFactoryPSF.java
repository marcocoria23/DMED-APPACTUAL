/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.conexion.PSF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANTONIO.CORIA
 */
public class OracleDAOFactoryPSF {
    
    public static Connection creaConexion(){
        Connection conn = null;
                
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OracleDAOFactoryPSF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@cegopro_bd.inegi.gob.mx:1521/cegopro.inegi.gob.mx","cngfed_est_2024","cngfed_est_2024");
            //conn = DriverManager.getConnection("jdbc:oracle:thin:@cengob_bd.inegi.gob.mx:1521/cengob.inegi.gob.mx","raf_2022","raf_2022");
        } catch (SQLException ex) {
            Logger.getLogger(OracleDAOFactoryPSF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;        
    }
}
