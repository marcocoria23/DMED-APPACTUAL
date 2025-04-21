/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidacionesPSF;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.PSF.DaoConexionPSF;

/**
 *
 * @author ANTONIO.CORIA
 */
public class QProgramas_sociales {
    
    DaoConexionPSF conexion=new DaoConexionPSF(); 
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
    
    
    //Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a Sí
     public ArrayList URL_REGLAS_LINEAMIENTOS_OPERACIONDC(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL,COND_REGLAS_LINEAMIENTOS_OPERACION, URL_REGLAS_LINEAMIENTOS_OPERACION,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+"\n" +
"where COND_REGLAS_LINEAMIENTOS_OPERACION ='1'\n" +
"and URL_REGLAS_LINEAMIENTOS_OPERACION is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                  resul.getString("COMENTARIOS")
                  
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
     //No Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a No
     public ArrayList URL_REGLAS_LINEAMIENTOS_OPERACIONNDC(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL,COND_REGLAS_LINEAMIENTOS_OPERACION, URL_REGLAS_LINEAMIENTOS_OPERACION,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+"\n" +
"where COND_REGLAS_LINEAMIENTOS_OPERACION ='1'\n" +
"and URL_REGLAS_LINEAMIENTOS_OPERACION is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
     
      //No Debe de capturar valor en URL_REGLAS_LINEAMIENTOS_OPERACION  ya que COND_REGLAS_LINEAMIENTOS_OPERACION es igual a No
     public ArrayList derecho_social_atendido_2(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL,derecho_social_atendido_1,derecho_social_atendido_2,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+" \n" +
"where derecho_social_atendido_1 = derecho_social_atendido_2";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
     
      //No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1 o derecho_social_atendido_2.
     public ArrayList derecho_social_atendido_3(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL,derecho_social_atendido_1,derecho_social_atendido_2,derecho_social_atendido_3,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+" \n" +
"where derecho_social_atendido_1 = derecho_social_atendido_2 or\n" +
"derecho_social_atendido_1 = derecho_social_atendido_3 or \n" +
"derecho_social_atendido_2= derecho_social_atendido_3 ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
     
     
       //No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1, derecho_social_atendido_2 o derecho_social_atendido_3
     public ArrayList derecho_social_atendido_4(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL,derecho_social_atendido_1,derecho_social_atendido_2,derecho_social_atendido_3,derecho_social_atendido_4,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+" \n" +
"where derecho_social_atendido_1 = derecho_social_atendido_2 or\n" +
"derecho_social_atendido_1 = derecho_social_atendido_3 or \n" +
"derecho_social_atendido_1 = derecho_social_atendido_4 or \n" +
"derecho_social_atendido_2= derecho_social_atendido_3 or\n" +
"derecho_social_atendido_2= derecho_social_atendido_4 or\n" +
"derecho_social_atendido_3= derecho_social_atendido_4";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
       //No puede repetir el tipo de derecho social atendido seleccionado en el campo derecho_social_atendido_1, derecho_social_atendido_2, derecho_social_atendido_3 o derecho_social_atendido_4.
     public ArrayList derecho_social_atendido_5(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL,derecho_social_atendido_1,derecho_social_atendido_2,derecho_social_atendido_3,derecho_social_atendido_4,derecho_social_atendido_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+" \n" +
"where derecho_social_atendido_1 = derecho_social_atendido_2 or\n" +
"derecho_social_atendido_1 = derecho_social_atendido_3 or \n" +
"derecho_social_atendido_1 = derecho_social_atendido_4 or \n" +
"derecho_social_atendido_2= derecho_social_atendido_3 or\n" +
"derecho_social_atendido_2= derecho_social_atendido_4 or\n" +
"derecho_social_atendido_3= derecho_social_atendido_4 or\n" +
"derecho_social_atendido_3= derecho_social_atendido_5 or\n" +
"derecho_social_atendido_4= derecho_social_atendido_5";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
      //No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1.
     public ArrayList tipo_apoyo_entregado_2(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL, tipo_apoyo_entregado_1, tipo_apoyo_entregado_2,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+" \n" +
"where tipo_apoyo_entregado_1 = tipo_apoyo_entregado_2";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
      //No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1 o tipo_apoyo_entregado_2.
     public ArrayList tipo_apoyo_entregado_3(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL, tipo_apoyo_entregado_1, tipo_apoyo_entregado_2, tipo_apoyo_entregado_3,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+" \n" +
"where tipo_apoyo_entregado_1 = tipo_apoyo_entregado_2 or\n" +
"tipo_apoyo_entregado_1 = tipo_apoyo_entregado_3 or \n" +
"tipo_apoyo_entregado_2= tipo_apoyo_entregado_3";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
     //No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1, tipo_apoyo_entregado_2 o tipo_apoyo_entregado_3.
     public ArrayList tipo_apoyo_entregado_4(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL, tipo_apoyo_entregado_1, tipo_apoyo_entregado_2, tipo_apoyo_entregado_3, tipo_apoyo_entregado_4, REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+" \n" +
"where tipo_apoyo_entregado_1 = tipo_apoyo_entregado_2 or\n" +
"tipo_apoyo_entregado_1 = tipo_apoyo_entregado_3 or \n" +
"tipo_apoyo_entregado_1 = tipo_apoyo_entregado_4 or \n" +
"tipo_apoyo_entregado_2= tipo_apoyo_entregado_3 or\n" +
"tipo_apoyo_entregado_2= tipo_apoyo_entregado_4 or\n" +
"tipo_apoyo_entregado_3= tipo_apoyo_entregado_4";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
      //No puede repetir el tipo de derecho social atendido seleccionado en el campo tipo_apoyo_entregado_1, tipo_apoyo_entregado_2, tipo_apoyo_entregado_3 o tipo_apoyo_entregado_4.
     public ArrayList tipo_apoyo_entregado_5(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL, tipo_apoyo_entregado_1, tipo_apoyo_entregado_2, tipo_apoyo_entregado_3, tipo_apoyo_entregado_4, tipo_apoyo_entregado_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+" \n" +
"where tipo_apoyo_entregado_1 = tipo_apoyo_entregado_2 or\n" +
"tipo_apoyo_entregado_1 = tipo_apoyo_entregado_3 or \n" +
"tipo_apoyo_entregado_1 = tipo_apoyo_entregado_4 or \n" +
"tipo_apoyo_entregado_2= tipo_apoyo_entregado_3 or\n" +
"tipo_apoyo_entregado_2= tipo_apoyo_entregado_4 or\n" +
"tipo_apoyo_entregado_3= tipo_apoyo_entregado_4 or\n" +
"tipo_apoyo_entregado_3= tipo_apoyo_entregado_5 or\n" +
"tipo_apoyo_entregado_4= tipo_apoyo_entregado_5";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
     
      //Favor de especificar en OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE ya que al menos una variable de Tipo_apoyo_entregado ='Otro tipo de apoyo (especifique)'
     public ArrayList OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL,OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE,tipo_apoyo_entregado_1,tipo_apoyo_entregado_2,tipo_apoyo_entregado_3,tipo_apoyo_entregado_4,tipo_apoyo_entregado_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+"\n" +
"where (tipo_apoyo_entregado_1 ='13' or tipo_apoyo_entregado_2 ='13' or tipo_apoyo_entregado_3 ='13' or tipo_apoyo_entregado_4 ='13' or tipo_apoyo_entregado_5 ='13')\n" +
"and OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
           //No debe de especificar en OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE ya que las variable de Tipo_apoyo_entregado es diferente a'Otro tipo de apoyo (especifique)'
     public ArrayList OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUEND(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL,OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE,tipo_apoyo_entregado_1,tipo_apoyo_entregado_2,tipo_apoyo_entregado_3,tipo_apoyo_entregado_4,tipo_apoyo_entregado_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+"\n" +
"where (tipo_apoyo_entregado_1 <> '13' AND tipo_apoyo_entregado_2 <> '13' AND tipo_apoyo_entregado_3 <> '13' AND tipo_apoyo_entregado_4 <> '13' AND tipo_apoyo_entregado_5 ='13')\n" +
"and OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
         //poblacion_atendida_territorial_especifique no debe de capturar  ya que hay un dato numérico en el campo poblacion_atendida_territorial.
     public ArrayList poblacion_atendida_territorial_especifique(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_PROGRAMA_SOCIAL,POBLACION_ATENDIDA_TERRITORIAL,poblacion_atendida_territorial_especifique,REPLACE(COMENTARIOS,',','')COMENTARIOS\n" +
"from TR_GF_PROG_SOCIALES_"+Año+"\n" +
"where POBLACION_ATENDIDA_TERRITORIAL ='NA'\n" +
"and poblacion_atendida_territorial_especifique is NOT null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
      //debe de capturar en poblacion_atendida_territorial_especifique ya que hay un dato numérico en el campo poblacion_atendida_territorial.
     public ArrayList poblacion_atendida_territorial_especifiqueND(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_PROGRAMA_SOCIAL,POBLACION_ATENDIDA_TERRITORIAL,poblacion_atendida_territorial_especifique,REPLACE(COMENTARIOS,',','')COMENTARIOS\n" +
"from TR_GF_PROG_SOCIALES_"+Año+"\n" +
"where POBLACION_ATENDIDA_TERRITORIAL <>'NA'\n" +
"and poblacion_atendida_territorial_especifique is  null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
      //poblacion_atendida_otro_tipo_especifique no debe de capturar  ya que no hay un dato numérico en el campo poblacion_atendida_otro_tipo.
     public ArrayList poblacion_atendida_otro_tipo_especifique(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_PROGRAMA_SOCIAL, poblacion_atendida_otro_tipo,poblacion_atendida_otro_tipo_especifique,REPLACE(COMENTARIOS,',','')COMENTARIOS\n" +
"from TR_GF_PROG_SOCIALES_"+Año +"\n" +
"where  poblacion_atendida_otro_tipo ='NA'\n" +
"and poblacion_atendida_otro_tipo_especifique is NOT null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
      //Debe de capturar en poblacion_atendida_otro_tipo_especifique   ya que  hay un dato numérico en el campo poblacion_atendida_otro_tipo.
     public ArrayList poblacion_atendida_otro_tipo_especifiqueND(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_PROGRAMA_SOCIAL, poblacion_atendida_otro_tipo,poblacion_atendida_otro_tipo_especifique,REPLACE(COMENTARIOS,',','')COMENTARIOS\n" +
"from TR_GF_PROG_SOCIALES_"+Año+"\n" +
"where  poblacion_atendida_otro_tipo <>'NA'\n" +
"and poblacion_atendida_otro_tipo_especifique is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   

     
      //No puede repetir el tipo de grupo vulnerable atendido  seleccionado en el campo grupo_vulnerable_beneficiado
     public ArrayList grupo(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL,GRUPO_VULNERABLE_BENEFICIADO_1,GRUPO_VULNERABLE_BENEFICIADO_2,GRUPO_VULNERABLE_BENEFICIADO_3,GRUPO_VULNERABLE_BENEFICIADO_4,GRUPO_VULNERABLE_BENEFICIADO_5,GRUPO_VULNERABLE_BENEFICIADO_6, GRUPO_VULNERABLE_BENEFICIADO_7,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+" \n" +
"where GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_2 or\n" +
"GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_2 or GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_3 or \n" +
"GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_4 or \n" +
"GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_5 or \n" +
"GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_6 or \n" +
"GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_7 or GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_8 OR\n" +
"GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_3 or\n" +
"GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_4 or\n" +
"GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_5 or\n" +
"GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_6 or\n" +
"GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_7 or GRUPO_VULNERABLE_BENEFICIADO_2= GRUPO_VULNERABLE_BENEFICIADO_8 OR\n" +
"GRUPO_VULNERABLE_BENEFICIADO_3= GRUPO_VULNERABLE_BENEFICIADO_4 or\n" +
"GRUPO_VULNERABLE_BENEFICIADO_3= GRUPO_VULNERABLE_BENEFICIADO_5 or\n" +
"GRUPO_VULNERABLE_BENEFICIADO_3= GRUPO_VULNERABLE_BENEFICIADO_6 or\n" +
"GRUPO_VULNERABLE_BENEFICIADO_3= GRUPO_VULNERABLE_BENEFICIADO_7 or GRUPO_VULNERABLE_BENEFICIADO_3= GRUPO_VULNERABLE_BENEFICIADO_8 OR\n" +
"GRUPO_VULNERABLE_BENEFICIADO_4= GRUPO_VULNERABLE_BENEFICIADO_5 OR\n" +
"GRUPO_VULNERABLE_BENEFICIADO_4= GRUPO_VULNERABLE_BENEFICIADO_6 OR\n" +
"GRUPO_VULNERABLE_BENEFICIADO_4= GRUPO_VULNERABLE_BENEFICIADO_7 OR GRUPO_VULNERABLE_BENEFICIADO_4= GRUPO_VULNERABLE_BENEFICIADO_8 OR\n" +
"GRUPO_VULNERABLE_BENEFICIADO_5= GRUPO_VULNERABLE_BENEFICIADO_6 OR\n" +
"GRUPO_VULNERABLE_BENEFICIADO_5= GRUPO_VULNERABLE_BENEFICIADO_7 OR GRUPO_VULNERABLE_BENEFICIADO_5= GRUPO_VULNERABLE_BENEFICIADO_8 OR\n" +
"GRUPO_VULNERABLE_BENEFICIADO_6=GRUPO_VULNERABLE_BENEFICIADO_7 OR GRUPO_VULNERABLE_BENEFICIADO_6=GRUPO_VULNERABLE_BENEFICIADO_8";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
    
     
      //No Debe de capturar otro_grupo_vulnerable_beneficiado_especifique  ya que grupo_vulnerable_beneficiado es diferente a "Otro grupo vulnerable (especifique)"
     public ArrayList grupo_ESPECIFIQUE(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL,OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE,GRUPO_VULNERABLE_BENEFICIADO_1,GRUPO_VULNERABLE_BENEFICIADO_2,GRUPO_VULNERABLE_BENEFICIADO_3,GRUPO_VULNERABLE_BENEFICIADO_4,GRUPO_VULNERABLE_BENEFICIADO_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+"\n" +
"where (GRUPO_VULNERABLE_BENEFICIADO_1 <> '21' AND GRUPO_VULNERABLE_BENEFICIADO_2 <> '21' AND GRUPO_VULNERABLE_BENEFICIADO_3 <> '21' AND GRUPO_VULNERABLE_BENEFICIADO_4 <> '21' AND GRUPO_VULNERABLE_BENEFICIADO_5 ='21')\n" +
"and OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE is NOT null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     // Debe de capturar otro_grupo_vulnerable_beneficiado_especifique  ya que grupo_vulnerable_beneficiado es igual a "Otro grupo vulnerable (especifique)"
     public ArrayList grupo_ESPECIFIQUEND(String Año){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_PROGRAMA_SOCIAL,OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE,GRUPO_VULNERABLE_BENEFICIADO_1,GRUPO_VULNERABLE_BENEFICIADO_2,GRUPO_VULNERABLE_BENEFICIADO_3,GRUPO_VULNERABLE_BENEFICIADO_4,GRUPO_VULNERABLE_BENEFICIADO_5,REPLACE(COMENTARIOS,',','')COMENTARIOS from TR_GF_PROG_SOCIALES_"+Año+"\n" +
"where (GRUPO_VULNERABLE_BENEFICIADO_1 = '21' AND GRUPO_VULNERABLE_BENEFICIADO_2 = '21' AND GRUPO_VULNERABLE_BENEFICIADO_3 = '21' AND GRUPO_VULNERABLE_BENEFICIADO_4 = '21' AND GRUPO_VULNERABLE_BENEFICIADO_5 ='21')\n" +
"and OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_PROGRAMA_SOCIAL"),
                   resul.getString("COMENTARIOS")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QProgramas_sociales.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     
}
