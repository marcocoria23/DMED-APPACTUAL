/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionesTEPJF;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.TEPJF.DaoConexionTEPJF;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Valida_Expedientes {  
    DaoConexionTEPJF conexion=new DaoConexionTEPJF();
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
//campo CANT_ACTORES debe ser obligatorio 
     public ArrayList Cant_actores(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE CANT_ACTORES IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     //campo CANT_RESPONSABLES debe ser obligatorio 
     public ArrayList Cant_responsables(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE CANT_RESPONSABLES IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 } 
   //campo CANT_TERCEROS_INTERESADOS debe ser obligatorio 
     public ArrayList Cant_terceros_interesados(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE CANT_TERCEROS_INTERESADOS IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 } 
//campo Periodo debe ser obligatorio 
     public ArrayList Periodo(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE PERIODO IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     //campo DES_SALA debe ser obligatorio 
     public ArrayList DES_SALA(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_SALA IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
      //campo NOMBRE_MAGISTRADO debe ser obligatorio 
     public ArrayList NOMBRE_MAGISTRADO(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE NOMBRE_MAGISTRADO IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     //campo FECHA_INGRESO debe ser obligatorio 
     public ArrayList FECHA_INGRESO(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE FECHA_INGRESO IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     //campo ID_ESTATUS_EXP debe ser obligatorio 
     public ArrayList ID_ESTATUS_EXP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE ID_ESTATUS_EXP IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
      //No debe de capturar FECHA_ING_ARCHIVO ya que ID_ESTATUS_EXP='En instrucción o trámite'
     public ArrayList FECHA_ING_ARCHIVO(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE FECHA_ING_ARCHIVO IS NOT NULL AND ID_ESTATUS_EXP=1";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     //Favor de capturar FECHA_ING_ARCHIVO ya que ID_ESTATUS_EXP='Concluido'
     public ArrayList FECHA_ING_ARCHIVO_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE FECHA_ING_ARCHIVO IS NULL AND ID_ESTATUS_EXP=2";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
      //La FECHA_ING_ARCHIVO no debe ser menor a la FECHA_INGRESO
     public ArrayList FECHA_ING_ARCHIVO_FECHA_INGRESO(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,FECHA_ING_ARCHIVO,FECHA_INGRESO,observaciones\n" +
"from TR_TEPJF_EXPEDIENTE \n" +
"WHERE TO_DATE(FECHA_ING_ARCHIVO) < TO_DATE(FECHA_INGRESO) and\n" +
"(FECHA_ING_ARCHIVO <> '09/09/1899' and  FECHA_INGRESO <> '09/09/1899')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     
     //ID_AMBITO_ASUNTO debe ser obligatorio
     public ArrayList ID_AMBITO_ASUNTO(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE ID_AMBITO_ASUNTO IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
       //DES_AGEE debe ser obligatorio
     public ArrayList DES_AGEE(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
        //No debe de capturar ID_AGEE_FUERA_CIRC ya que DES_AGEE= es diferente a 'Fuera de circunscripción'
     public ArrayList ID_AGEE_FUERA_CIRC(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE Not in ('Fuera de circunscripción') AND ID_AGEE_FUERA_CIRC is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
        //Favor  de capturar ID_AGEE_FUERA_CIRC ya que DES_AGEE= 'Fuera de circunscripción'
     public ArrayList ID_AGEE_FUERA_CIRC_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE Not in ('Fuera de circunscripción') AND ID_AGEE_FUERA_CIRC is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     
     
      //No debe de capturar DES_AGEE_FUERA_CIRC ya que DES_AGEE= es diferente a 'Fuera de circunscripción'
     public ArrayList DES_AGEE_FUERA_CIRC(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE Not in ('Fuera de circunscripción') AND DES_AGEE_FUERA_CIRC is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
        //Favor  de capturar DES_AGEE_FUERA_CIRC ya que DES_AGEE= 'Fuera de circunscripción'
     public ArrayList DES_AGEE_FUERA_CIRC_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE Not in ('Fuera de circunscripción') AND DES_AGEE_FUERA_CIRC is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     
     
      //No debe de capturar ID_AGEE_FEDERAL ya que DES_AGEE= es diferente a 'Federal'
     public ArrayList ID_AGEE_FEDERAL(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE Not in ('Federal') AND ID_AGEE_FEDERAL is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
       //Favor de capturar ID_AGEE_FEDERAL ya que DES_AGEE= es igaul a 'Federal'
     public ArrayList ID_AGEE_FEDERAL_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE  in ('Federal') AND ID_AGEE_FEDERAL is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
   
     
     
     
        //No debe de capturar DES_AGEE_FEDERAL ya que DES_AGEE= es diferente a 'Federal'
     public ArrayList DES_AGEE_FEDERAL(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE Not in ('Federal') AND DES_AGEE_FEDERAL is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
       //Favor de capturar DES_AGEE_FEDERAL ya que DES_AGEE= es igual a 'Federal'
     public ArrayList DES_AGEE_FEDERAL_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE  in ('Federal') AND DES_AGEE_FEDERAL is  null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     

        //No debe de capturar ID_AGEM ya que DES_AGEE es igual ('Fuera de circunscripción' o 'Federal')
     public ArrayList ID_AGEM(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE  in ('Fuera de circunscripción','Federal') AND ID_AGEM is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
      //Favor de capturar ID_AGEM ya que DES_AGEE= es diferente a ('Fuera de circunscripción' o 'Federal')
     public ArrayList ID_AGEM_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE Not in ('Fuera de circunscripción','Federal') AND ID_AGEM is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
        //No debe de capturar ID_AGEM_FUERA_CIRC ya que DES_AGEE= es diferente a ('Fuera de circunscripción')
     public ArrayList ID_AGEM_FUERA_CIRC(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE Not in ('Fuera de circunscripción') AND ID_AGEM_FUERA_CIRC is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
        //Favor debe de capturar ID_AGEM_FUERA_CIRC ya que DES_AGEE= es igual a ('Fuera de circunscripción')
     public ArrayList ID_AGEM_FUERA_CIRC_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE  in ('Fuera de circunscripción') AND ID_AGEM_FUERA_CIRC is  null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
   
     
     
       //No debe de capturar DES_AGEM_FUERA_CIRC ya que DES_AGEE= es diferente a ('Fuera de circunscripción')
     public ArrayList DES_AGEM_FUERA_CIRC(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE Not in ('Fuera de circunscripción') AND DES_AGEM_FUERA_CIRC is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
       //Favor de capturar DES_AGEM_FUERA_CIRC ya que DES_AGEE= es igual a ('Fuera de circunscripción')
     public ArrayList DES_AGEM_FUERA_CIRC_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE  in ('Fuera de circunscripción') AND DES_AGEM_FUERA_CIRC is  null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     //No debe de capturar ID_AGEM_FEDERAL ya que DES_AGEE= es diferente a ('Federal')
     public ArrayList ID_AGEM_FEDERAL(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE Not in ('Federal') AND ID_AGEM_FEDERAL is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     //Favor  de capturar ID_AGEM_FEDERAL ya que DES_AGEE= es igual a ('Federal')
     public ArrayList ID_AGEM_FEDERAL_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE  in ('Federal') AND ID_AGEM_FEDERAL is  null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     
     //No debe de capturar DES_AGEM_FEDERAL ya que DES_AGEE= es diferente a ('Federal')
     public ArrayList DES_AGEM_FEDERAL(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE Not in ('Federal') AND DES_AGEM_FEDERAL is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     //Favor de capturar DES_AGEM_FEDERAL ya que DES_AGEE= es igual a ('Federal')
     public ArrayList DES_AGEM_FEDERAL_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_AGEE  in ('Federal') AND DES_AGEM_FEDERAL is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     
      //El campo DES_MEDIO_IMPUGNACION debe ser obligatorio
     public ArrayList DES_MEDIO_IMPUGNACION(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE DES_MEDIO_IMPUGNACION IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
    
     
       //El campo ID_MATERIA debe ser obligatorio
     public ArrayList ID_MATERIA(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE ID_MATERIA IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
       //No debe de capturar ID_VINCULACION_PROCESO ya que ID_MATERIA= es diferente a ('Electoral')
     public ArrayList ID_VINCULACION_PROCESO(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE ID_MATERIA Not in (1) AND ID_VINCULACION_PROCESO is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     
      //Favor de capturar ID_VINCULACION_PROCESO ya que ID_MATERIA= es igual a ('Electoral')
     public ArrayList ID_VINCULACION_PROCESO_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE ID_MATERIA IN (1) AND ID_VINCULACION_PROCESO is  null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     //ID_MATERIA (Materia) debe ser Laboral ya que TEMA1_IMPUGNACION_N1(tm_impug_1_nivel_1) =26 "Controversias laborales"
     public ArrayList TEMA1_IMPUGNACION_N1(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA1_IMPUGNACION_N1=26 AND ID_MATERIA=1 ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
     //Favor de capturar TEMA1_IMPUGNACION_N1 ya que ID_MATERIA= es igual a ('Laboral')
     public ArrayList TEMA1_IMPUGNACION_N1_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE ID_MATERIA  in (2) AND TEMA1_IMPUGNACION_N1 is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
  //No debe de capturar TEMA1_IMPUGNACION_N2 ya que TEMA1_IMPUGNACION_N1 es igual a null
     public ArrayList TEMA1_IMPUGNACION_N2(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA1_IMPUGNACION_N1 IS NULL AND TEMA1_IMPUGNACION_N2 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     //aqui me quede
      //No debe de capturar TEMA1_IMPUGNACION_N3 ya que TEMA1_IMPUGNACION_N2 es igual a null
     public ArrayList TEMA1_IMPUGNACION_N3(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA1_IMPUGNACION_N2 IS NULL AND TEMA1_IMPUGNACION_N3 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
      //No debe de capturar TEMA1_IMPUGNACION_N4 ya que TEMA1_IMPUGNACION_N3 es igual a null
     public ArrayList TEMA1_IMPUGNACION_N4(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA1_IMPUGNACION_N3 IS NULL AND TEMA1_IMPUGNACION_N4 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     
      //No debe de capturar TEMA2_IMPUGNACION_N1 ya que TEMA1_IMPUGNACION_N1 es igual a null
     public ArrayList TEMA2_IMPUGNACION_N1(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA1_IMPUGNACION_N1 IS NULL AND TEMA2_IMPUGNACION_N1 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     //No debe de capturar TEMA2_IMPUGNACION_N2 ya que TEMA2_IMPUGNACION_N1 es igual a null
     public ArrayList TEMA2_IMPUGNACION_N2(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA2_IMPUGNACION_N1 IS NULL AND TEMA2_IMPUGNACION_N2 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     //No debe de capturar TEMA2_IMPUGNACION_N3 ya que TEMA2_IMPUGNACION_N2 es igual a null
     public ArrayList TEMA2_IMPUGNACION_N3(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA2_IMPUGNACION_N2 IS NULL AND TEMA2_IMPUGNACION_N3 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     
      //No debe de capturar TEMA2_IMPUGNACION_N4 ya que TEMA2_IMPUGNACION_N3 es igual a null
     public ArrayList TEMA2_IMPUGNACION_N4(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA2_IMPUGNACION_N3 IS NULL AND TEMA2_IMPUGNACION_N4 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     
      //No debe de capturar TEMA3_IMPUGNACION_N1 ya que TEMA2_IMPUGNACION_N1 es igual a null
     public ArrayList TEMA3_IMPUGNACION_N1(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA2_IMPUGNACION_N1 IS NULL AND TEMA3_IMPUGNACION_N1 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     
      //No debe de capturar TEMA3_IMPUGNACION_N2 ya que TEMA3_IMPUGNACION_N1 es igual a null
     public ArrayList TEMA3_IMPUGNACION_N2(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA3_IMPUGNACION_N1 IS NULL AND TEMA3_IMPUGNACION_N2 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     
      //No debe de capturar TEMA3_IMPUGNACION_N3 ya que TEMA3_IMPUGNACION_N2 es igual a null
     public ArrayList TEMA3_IMPUGNACION_N3(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA3_IMPUGNACION_N2 IS NULL AND TEMA3_IMPUGNACION_N3 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     //No debe de capturar TEMA3_IMPUGNACION_N4 ya que TEMA3_IMPUGNACION_N3 es igual a null
     public ArrayList TEMA3_IMPUGNACION_N4(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA3_IMPUGNACION_N3 IS NULL AND TEMA3_IMPUGNACION_N4 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     //No debe de capturar TEMA4_IMPUGNACION_N1 ya que TEMA3_IMPUGNACION_N1 es igual a null
     public ArrayList TEMA4_IMPUGNACION_N1(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA3_IMPUGNACION_N1 IS NULL AND TEMA4_IMPUGNACION_N1 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   

      //No debe de capturar TEMA4_IMPUGNACION_N2 ya que TEMA4_IMPUGNACION_N1 es igual a null
     public ArrayList TEMA4_IMPUGNACION_N2(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA4_IMPUGNACION_N1 IS NULL AND TEMA4_IMPUGNACION_N2 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
      //No debe de capturar TEMA4_IMPUGNACION_N3 ya que TEMA4_IMPUGNACION_N2 es igual a null
     public ArrayList TEMA4_IMPUGNACION_N3(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA4_IMPUGNACION_N2 IS NULL AND TEMA4_IMPUGNACION_N3 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
    
     
     
       //No debe de capturar TEMA4_IMPUGNACION_N4 ya que TEMA4_IMPUGNACION_N3 es igual a null
     public ArrayList TEMA4_IMPUGNACION_N4(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA4_IMPUGNACION_N3 IS NULL AND TEMA4_IMPUGNACION_N4 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 } 
     
     
     
     //No debe de capturar TEMA5_IMPUGNACION_N1 ya que TEMA4_IMPUGNACION_N1 es igual a null
     public ArrayList TEMA5_IMPUGNACION_N1(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA4_IMPUGNACION_N1 IS NULL AND TEMA5_IMPUGNACION_N1 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   

      //No debe de capturar TEMA5_IMPUGNACION_N2 ya que TEMA5_IMPUGNACION_N1 es igual a null
     public ArrayList TEMA5_IMPUGNACION_N2(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA5_IMPUGNACION_N1 IS NULL AND TEMA5_IMPUGNACION_N2 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
    //No debe de capturar TEMA5_IMPUGNACION_N2 ya que TEMA5_IMPUGNACION_N1 es igual a null
     public ArrayList TEMA5_IMPUGNACION_N3(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA5_IMPUGNACION_N2 IS NULL AND TEMA5_IMPUGNACION_N3 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }    
     
     
      //No debe de capturar TEMA5_IMPUGNACION_N4 ya que TEMA5_IMPUGNACION_N2 es igual a null
     public ArrayList TEMA5_IMPUGNACION_N4(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA5_IMPUGNACION_N2 IS NULL AND TEMA5_IMPUGNACION_N4 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
        
      
      //No debe de capturar Otro_Tema1 ya que TEMA1_IMPUGNACION_N1 es diferente a 'Otro tema (especifique)'
     public ArrayList Otro_Tema1(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA1_IMPUGNACION_N1 NOT IN  (53) AND Otro_Tema1 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     //Debe de capturar Otro_Tema1 ya que TEMA1_IMPUGNACION_N1 es igual a 'Otro tema (especifique)'
     public ArrayList Otro_Tema1_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA1_IMPUGNACION_N1  IN  (53) AND Otro_Tema1 IS  NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     
     
     //No debe de capturar Otro_Tema2 ya que TEMA2_IMPUGNACION_N1 es diferente a 'Otro tema (especifique)'
     public ArrayList Otro_Tema2(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA2_IMPUGNACION_N1 NOT IN  (53) AND Otro_Tema2 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     //Debe de capturar Otro_Tema2 ya que TEMA2_IMPUGNACION_N1 es igual a 'Otro tema (especifique)'
     public ArrayList Otro_Tema2_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA2_IMPUGNACION_N1  IN  (53) AND Otro_Tema2 IS  NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     //No debe de capturar Otro_Tema3 ya que TEMA3_IMPUGNACION_N1 es diferente a 'Otro tema (especifique)'
     public ArrayList Otro_Tema3(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA3_IMPUGNACION_N1 NOT IN  (53) AND Otro_Tema3 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     //Debe de capturar Otro_Tema3 ya que TEMA3_IMPUGNACION_N1 es igual a 'Otro tema (especifique)'
     public ArrayList Otro_Tema3_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA3_IMPUGNACION_N1  IN  (53) AND Otro_Tema3 IS  NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
    
     
      //No debe de capturar Otro_Tema4 ya que TEMA4_IMPUGNACION_N1 es diferente a 'Otro tema (especifique)'
     public ArrayList Otro_Tema4(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA4_IMPUGNACION_N1 NOT IN  (53) AND Otro_Tema4 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     //Debe de capturar Otro_Tema4 ya que TEMA4_IMPUGNACION_N1 es igual a 'Otro tema (especifique)'
     public ArrayList Otro_Tema4_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA4_IMPUGNACION_N1  IN  (53) AND Otro_Tema4 IS  NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),
                  resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
      //No debe de capturar Otro_Tema5 ya que TEMA5_IMPUGNACION_N1 es diferente a 'Otro tema (especifique)'
     public ArrayList Otro_Tema5(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA5_IMPUGNACION_N1 NOT IN  (53) AND Otro_Tema5 IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),
                  resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     //Debe de capturar Otro_Tema5 ya que TEMA5_IMPUGNACION_N1 es igual a 'Otro tema (especifique)'
     public ArrayList Otro_Tema5_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE,OBSERVACIONES from TR_TEPJF_EXPEDIENTE WHERE TEMA5_IMPUGNACION_N1  IN  (53) AND Otro_Tema5 IS  NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     
     //La cantidad capturada en EXPEDIENTE no coincide con su desglose en Actor'
     public ArrayList CANT_DESGLOSE_ACTORES(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_TEPJF_EXPEDIENTE,CANT_ACTORES_EXPEDIENTE,CANTIDAD_ACTORES_DESGLOSE FROM(\n" +
"SELECT P.ID_TEPJF_EXPEDIENTE,S.CANT_ACTORES AS CANT_ACTORES_EXPEDIENTE,P.CANTIDAD_ACTORES_DESGLOSE  FROM(\n" +
"SELECT ID_TEPJF_EXPEDIENTE,COUNT(*) CANTIDAD_ACTORES_DESGLOSE\n" +
"FROM  TR_TEPJF_ACTORES  \n" +
"GROUP BY ID_TEPJF_EXPEDIENTE)P LEFT JOIN TR_TEPJF_EXPEDIENTE S\n" +
"ON P.ID_TEPJF_EXPEDIENTE=S.ID_TEPJF_EXPEDIENTE) WHERE CANTIDAD_ACTORES_DESGLOSE<>CANT_ACTORES_EXPEDIENTE";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),
                  resul.getString("CANT_ACTORES_EXPEDIENTE"),
                  resul.getString("CANTIDAD_ACTORES_DESGLOSE")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     
     
      //La cantidad capturada en EXPEDIENTE no coincide con su desglose en Responsables'
     public ArrayList CANT_DESGLOSE_RESPONSABLES(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_TEPJF_EXPEDIENTE,CANT_RESPONSABLES_EXPEDIENTE,CANTIDAD_RESPONSABLES_DESGLOSE FROM(\n" +
"SELECT P.ID_TEPJF_EXPEDIENTE,S.CANT_RESPONSABLES AS CANT_RESPONSABLES_EXPEDIENTE,P.CANTIDAD_RESPONSABLES_DESGLOSE  FROM(\n" +
"SELECT ID_TEPJF_EXPEDIENTE,COUNT(*) CANTIDAD_RESPONSABLES_DESGLOSE\n" +
"FROM  TR_TEPJF_RESPONSABLES  \n" +
"GROUP BY ID_TEPJF_EXPEDIENTE)P LEFT JOIN TR_TEPJF_EXPEDIENTE S\n" +
"ON P.ID_TEPJF_EXPEDIENTE=S.ID_TEPJF_EXPEDIENTE) WHERE CANTIDAD_RESPONSABLES_DESGLOSE<>CANT_RESPONSABLES_EXPEDIENTE";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_TEPJF_EXPEDIENTE"),
                  resul.getString("CANT_RESPONSABLES_EXPEDIENTE"),
                  resul.getString("CANTIDAD_RESPONSABLES_DESGLOSE")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
}

