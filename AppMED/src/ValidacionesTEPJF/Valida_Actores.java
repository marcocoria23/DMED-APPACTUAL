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
public class Valida_Actores {
    DaoConexionTEPJF conexion=new DaoConexionTEPJF();
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
    
    
    
    
    //Id_actor se encuentra duplicado
     public ArrayList ID_ACTOR_DUP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(ID_ACTORES_EXTRACTED) ID_unico,ID_TEPJF_EXPEDIENTE FROM (\n" +
"SELECT \n" +
"    ID_TEPJF_EXPEDIENTE,\n" +
"    SUBSTR(\n" +
"        ID_TEPJF_ACTORES,\n" +
"        INSTR(ID_TEPJF_ACTORES, 'TEMP-') + 5,\n" +
"        INSTR(ID_TEPJF_ACTORES, '-', -1) - (INSTR(ID_TEPJF_ACTORES, 'TEMP-') + 5)\n" +
"    ) AS ID_ACTORES_EXTRACTED\n" +
"FROM \n" +
"    TR_TEPJF_ACTORES\n" +
"WHERE \n" +
"    ID_TEPJF_ACTORES LIKE '%TEMP%')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_unico")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    //EL ID_EXPEDIENTE NO SE ENCUENTRA EN TABLA EXPEDIENTES
     public ArrayList ID_EXPE_REL(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" select  ac.ID_TEPJF_EXPEDIENTE,ac.ID_TEPJF_actores,ac.OBSERVACIONES from tr_tepjf_expediente expe \n" +
"        left join tr_tepjf_actores ac on ac.ID_TEPJF_EXPEDIENTE=expe.ID_TEPJF_EXPEDIENTE\n" +
"        where expe.ID_TEPJF_EXPEDIENTE is null   ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
     
      //CAMPO CLASE_ACTOR ES OBLIGATORIO
     public ArrayList CLASE_ACTOR(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT\n" +
"                ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES \n" +
"            FROM\n" +
"              tr_tepjf_actores where CLASE_ACTOR is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
     
       //Favor de capturar OTRO_CLASE_ACTOR_CAP ya que CLASE_ACTOR es igual a 'Otro actor'
     public ArrayList OTRO_CLASE_ACTOR_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT\n" +
"                ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES\n" +
"            FROM\n" +
"              tr_tepjf_actores where CLASE_ACTOR=17 and OTRO_CLASE_ACTOR is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
       //No debe  de capturar OTRO_CLASE_ACTOR_CAP ya que CLASE_ACTOR es diferente a 'Otro actor'
     public ArrayList OTRO_CLASE_ACTOR(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT\n" +
"                ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES\n" +
"            FROM\n" +
"              tr_tepjf_actores where CLASE_ACTOR<>17 and OTRO_CLASE_ACTOR is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
     
     
     
       //Favor de capturar SEXO ya que CLASE_ACTOR es igual a  "Ciudadano" o "Candidato"
     public ArrayList OTRO_CLASE_SEXO_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" select ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES from tr_tepjf_actores where clase_actor in (1,3) and SEXO is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  
     
      //No debe de capturar SEXO ya que CLASE_ACTOR es difernete a  "Ciudadano" o "Candidato"
     public ArrayList OTRO_CLASE_SEXO(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES from tr_tepjf_actores where clase_actor not in (1,3) and SEXO is not  null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
      //Campo cond_representacion_legal es Obligatorio
     public ArrayList COND_REPRESENTACION_LEGAL(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" select ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES from tr_tepjf_actores where cond_repres_actor is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
     
      //Favor de capturar PART_POLITICO_NAC_ACTOR ya que CLASE_ACTOR es igual a  "Partido político nacional"
     public ArrayList PART_POLITICO_NAC_ACTOR_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" select ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES from tr_tepjf_actores where clase_actor=7 and part_politico_nac_actor is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
     //No debe de capturar PART_POLITICO_NAC_ACTOR ya que CLASE_ACTOR es diferente a  "Partido político nacional"
     public ArrayList PART_POLITICO_NAC_ACTOR(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" select ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES from tr_tepjf_actores where clase_actor<>7 and part_politico_nac_actor is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
      //Favor de capturar part_politico_local_actor ya que CLASE_ACTOR es igual a  "Partido político local"
     public ArrayList PART_POLITICO_LOCAL_ACTOR_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES from tr_tepjf_actores where clase_actor=8 and part_politico_local_actor is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
      //No debe de capturar part_politico_local_actor ya que CLASE_ACTOR es diferente a  "Partido político local"
     public ArrayList PART_POLITICO_LOCAL_ACTOR(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES from tr_tepjf_actores where clase_actor<>8 and part_politico_local_actor is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
     //Favor de capturar sala_actor ya que CLASE_ACTOR es igual a "Sala del Tribunal Electoral del Poder Judicial de la Federación".
     public ArrayList SALA_ACTOR_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES from tr_tepjf_actores where clase_actor=12 and sala_actor is null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     //No debe de capturar sala_actor ya que CLASE_ACTOR es diferente a "Sala del Tribunal Electoral del Poder Judicial de la Federación".
     public ArrayList SALA_ACTOR(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_TEPJF_EXPEDIENTE, ID_TEPJF_ACTORES,OBSERVACIONES from tr_tepjf_actores where clase_actor<>12 and sala_actor is not null";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_ACTORES"),
                   resul.getString("OBSERVACIONES")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
}
