/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones_JA;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.JA.DaoConexionJA;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Valida_Control {
    
      DaoConexionJA conexion=new DaoConexionJA();
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
    
    
    
    public ArrayList Control_Ingreso(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO)CLAVE_ORGANO,COMENTARIOS FROM TR_JA_INGRESOS_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
     public ArrayList Control_Tramite(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO)CLAVE_ORGANO,COMENTARIOS FROM TR_JA_TRAMITE_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")             
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
      public ArrayList Control_Conclusiones(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO)CLAVE_ORGANO,COMENTARIOS FROM TR_JA_CONCLUSIONES_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")               
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
      
      
      public ArrayList Control_Actos_Procesales(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO),COMENTARIOS FROM TR_JA_ACTOS_PROCESALES_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")              
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
      public ArrayList Control_Cumplim_Ejecutorias(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO),COMENTARIOS FROM TR_JA_CUMPLIM_EJECUTORIAS_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")               
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
      
        public ArrayList Control_Exhorto(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO),COMENTARIOS FROM TR_JA_EXHORTOS_DESPACHOS_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")               
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
        
        
          public ArrayList Control_Asuntos_Hidrocarburos(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(CLAVE_ORGANO),COMENTARIOS FROM TR_JA_ASUNTOS_HIDROCARBUROS_GEN\n" +
"WHERE CLAVE_ORGANO NOT IN (SELECT CLAVE_ORGANO FROM TR_JA_CONTROL_GEN)";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("CLAVE_ORGANO"),
                  resul.getString("COMENTARIOS")               
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
      
}
