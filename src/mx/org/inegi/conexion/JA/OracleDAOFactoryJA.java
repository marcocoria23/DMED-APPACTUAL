/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.conexion.JA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class OracleDAOFactoryJA {
    
    public static Connection creaConexion(){
        Connection conn = null;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            Logger.getLogger(OracleDAOFactoryJA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@cegopro_bd.inegi.gob.mx:1521/cegopro.inegi.gob.mx","raf_2022","raf_2022");
        } catch (SQLException ex){
            Logger.getLogger(OracleDAOFactoryJA.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return conn;
    }
}
