/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.conexion.JA;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleConnection;
/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class OracleDAOFactoryJA {
    
    public static Connection creaConexion() throws SQLException, IOException{
        Connection conn = null;
        System.out.println("Crear conexión a base de datos");
        try {
    java.net.Socket s = new java.net.Socket();
    s.connect(new java.net.InetSocketAddress("cegopro_bd.inegi.gob.mx", 1521), 5000);
    s.close();
    System.out.println("Puerto 1521 accesible");
} catch (IOException e) {
    JOptionPane.showMessageDialog(null, "No se puede alcanzar el servidor Oracle.\nVerifica VPN o red.\n" + e.getMessage());
    
}
        
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex){
            Logger.getLogger(OracleDAOFactoryJA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
             Properties props = new Properties();
            props.setProperty("user", "raf_2022");
            props.setProperty("password", "raf_2022");

            // Timeout para establecer la conexión: 15 segundos
            props.setProperty(OracleConnection.CONNECTION_PROPERTY_THIN_NET_CONNECT_TIMEOUT, "15000");

            // Timeout para leer respuesta del servidor: 30 segundos
            props.setProperty(OracleConnection.CONNECTION_PROPERTY_THIN_READ_TIMEOUT, "30000");

            // Timeout global de login como respaldo
            DriverManager.setLoginTimeout(15);
           // conn = DriverManager.getConnection("jdbc:oracle:thin:@cegopro_bd.inegi.gob.mx:1521/cegopro.inegi.gob.mx","raf_2022","raf_2022"); 
           conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@cegopro_bd.inegi.gob.mx:1521/cegopro.inegi.gob.mx",
                props
            );

            System.out.println("Conexión establecida correctamente");

        } catch (SQLException ex) {
            Logger.getLogger(OracleDAOFactoryJA.class.getName()).log(Level.SEVERE, null, ex);
            throw ex; // Re-lanza para que el llamador sepa que falló
        }

        return conn;
    }
}
