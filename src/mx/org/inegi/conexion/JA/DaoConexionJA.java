/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.conexion.JA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class DaoConexionJA {

    private Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public DaoConexionJA Conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@cegopro_bd.inegi.gob.mx:1521/cegopro.inegi.gob.mx";
            conexion = DriverManager.getConnection(BaseDeDatos, "raf_2022", "raf_2022");

            if (conexion != null) {
                System.out.println("Conexion exitosa!");
            } else {
                System.out.println("Conexion fallida!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
        return this;
    }
    
    public boolean escribir(String sql) { 
        try {
            
            Statement sentencia; 
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql); 
            //getConexion().commit(); 
            sentencia.close();
             
        } catch (SQLException e) { 
            System.out.print("ERROR SQL"+e); 
            return false; 
        }         
        return true; 
    }
          
    public ResultSet consultar(String sql) {
        ResultSet rst = null;
        try {
            Statement sentencia; 
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rst = sentencia.executeQuery(sql);
        } catch (SQLException e) { 
            System.out.println("error sql "+e);
            return null; 
        }
        return rst; 
    }
     
    public void close() throws SQLException{
        System.out.println("Conexion Cerrada");
        conexion.close();
    }

}
