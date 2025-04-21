/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.conexion.TEPJF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANTONIO.CORIA
 */
public class OracleDAOFactoryTEPJF {

    
    public static Connection creaConexion(){
        Connection conn = null;
                
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OracleDAOFactoryTEPJF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@cegopro_bd.inegi.gob.mx:1521/cegopro.inegi.gob.mx","raf_2022","raf_2022");
        } catch (SQLException ex) {
            Logger.getLogger(OracleDAOFactoryTEPJF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;        
    }
}

