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
public class Valida_Responsables {
    DaoConexionTEPJF conexion=new DaoConexionTEPJF();
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
    
    
    
     //Id_Responsable se encuentra duplicado
     public ArrayList ID_RESPONSABLE_DUP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(ID_RESPONSABLES_EXTRACTED)ID_unico,ID_TEPJF_EXPEDIENTE FROM (\n" +
"SELECT \n" +
"    ID_TEPJF_EXPEDIENTE,\n" +
"    SUBSTR(\n" +
"        ID_TEPJF_RESPONSABLES,\n" +
"        INSTR(ID_TEPJF_RESPONSABLES, 'TEMP-') + 5,\n" +
"        INSTR(ID_TEPJF_RESPONSABLES, '-', -1) - (INSTR(ID_TEPJF_RESPONSABLES, 'TEMP-') + 5)\n" +
"    ) AS ID_RESPONSABLES_EXTRACTED\n" +
"FROM \n" +
"    TR_TEPJF_RESPONSABLES\n" +
"WHERE \n" +
"    ID_TEPJF_RESPONSABLES LIKE '%TEMP%')";
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
      sql=" select  ac.ID_TEPJF_EXPEDIENTE,ac.ID_TEPJF_RESPONSABLES,ac.OBSERVACIONES from tr_tepjf_expediente expe \n" +
"        left join tr_tepjf_RESPONSABLES ac on ac.ID_TEPJF_EXPEDIENTE=expe.ID_TEPJF_EXPEDIENTE\n" +
"        where expe.ID_TEPJF_EXPEDIENTE is null   ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_RESPONSABLES"),
                   resul.getString("OBSERVACIONES")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
     
      //El Campo CLASE_RESPONSABLE es obligatorio
     public ArrayList CLASE_RESPONSABLE(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESPONSABLES, OBSERVACIONES\n" +
"FROM TR_TEPJF_RESPONSABLES\n" +
"WHERE CLASE_RESPONSABLE IS NULL   ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_RESPONSABLES"),
                   resul.getString("OBSERVACIONES")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
      //Favor de capturar campo OTRO_CLASE_RESPONSABLE ya que CLASE_RESPONSABLE='Otro responsable (especifique)'
     public ArrayList OTRO_CLASE_RESPONSABLE_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESPONSABLES, OBSERVACIONES\n" +
"FROM TR_TEPJF_RESPONSABLES\n" +
"WHERE CLASE_RESPONSABLE = 16 AND OTRO_CLASE_RESPONSABLE IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_RESPONSABLES"),
                   resul.getString("OBSERVACIONES")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
      //No debe de capturar campo OTRO_CLASE_RESPONSABLE ya que CLASE_RESPONSABLE no es igual a 'Otro responsable (especifique)'
     public ArrayList OTRO_CLASE_RESPONSABLE(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESPONSABLES, OBSERVACIONES\n" +
"FROM TR_TEPJF_RESPONSABLES\n" +
"WHERE CLASE_RESPONSABLE NOT IN  (16) AND OTRO_CLASE_RESPONSABLE IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_RESPONSABLES"),
                   resul.getString("OBSERVACIONES")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     //Favor de capturar campo PART_POLITICO_NAC_RESPONS ya que CLASE_RESPONSABLE='Partido político nacional'
     public ArrayList PART_POLITICO_NAC_RESPONS_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESPONSABLES, OBSERVACIONES\n" +
"FROM TR_TEPJF_RESPONSABLES\n" +
"WHERE CLASE_RESPONSABLE = 2 AND PART_POLITICO_NAC_RESPONS IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_RESPONSABLES"),
                   resul.getString("OBSERVACIONES")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
     
 //No debe de capturar campo PART_POLITICO_NAC_RESPONS ya que CLASE_RESPONSABLE es diferente a 'Partido político nacional'
     public ArrayList PART_POLITICO_NAC_RESPONS(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESPONSABLES, OBSERVACIONES\n" +
"FROM TR_TEPJF_RESPONSABLES\n" +
"WHERE CLASE_RESPONSABLE NOT IN (2) AND PART_POLITICO_NAC_RESPONS IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_RESPONSABLES"),
                   resul.getString("OBSERVACIONES")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }    
     
     
      //Favor de capturar campo PART_POLITICO_LOCAL_RESPONS ya que CLASE_RESPONSABLE='Partido político local'
     public ArrayList PART_POLITICO_LOCAL_RESPONS_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESPONSABLES, OBSERVACIONES\n" +
"FROM TR_TEPJF_RESPONSABLES\n" +
"WHERE CLASE_RESPONSABLE = 3 AND PART_POLITICO_LOCAL_RESPONS IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_RESPONSABLES"),
                   resul.getString("OBSERVACIONES")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     
      //No debe de capturar campo PART_POLITICO_LOCAL_RESPONS ya que CLASE_RESPONSABLE es diferente a 'Partido político local'
     public ArrayList PART_POLITICO_LOCAL_RESPONS(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESPONSABLES, OBSERVACIONES\n" +
"FROM TR_TEPJF_RESPONSABLES\n" +
"WHERE CLASE_RESPONSABLE NOT IN  3 AND PART_POLITICO_LOCAL_RESPONS IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_RESPONSABLES"),
                   resul.getString("OBSERVACIONES")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
       //Favor de capturar campo SALA_RESPONSABLE ya que CLASE_RESPONSABLE='Sala del Tribunal Electoral del Poder Judicial de la Federación'
     public ArrayList SALA_RESPONSABLE_CAP(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESPONSABLES, OBSERVACIONES\n" +
"FROM TR_TEPJF_RESPONSABLES\n" +
"WHERE CLASE_RESPONSABLE = 10 AND SALA_RESPONSABLE IS NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_RESPONSABLES"),
                   resul.getString("OBSERVACIONES")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Valida_Expedientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
     
     //No debe de capturar campo SALA_RESPONSABLE ya que CLASE_RESPONSABLE es diferente a 'Sala del Tribunal Electoral del Poder Judicial de la Federación'
     public ArrayList SALA_RESPONSABLE(){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT ID_TEPJF_EXPEDIENTE, ID_TEPJF_RESPONSABLES, OBSERVACIONES\n" +
"FROM TR_TEPJF_RESPONSABLES\n" +
"WHERE CLASE_RESPONSABLE NOT IN  (10) AND SALA_RESPONSABLE IS NOT NULL";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_TEPJF_EXPEDIENTE"),
                   resul.getString("ID_TEPJF_RESPONSABLES"),
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
