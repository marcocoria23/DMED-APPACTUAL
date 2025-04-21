/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.QuerysGeneral.TEPJF;

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
public class Querys {
    DaoConexionTEPJF conexion=new DaoConexionTEPJF();
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
    
    
    
     public ArrayList TotalErrores_insert_tepjftmp(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select TABLA, ID_REGISTRO,TIPO_ERROR,replace(DES_ERROR,',','')DES_ERROR FROM ERRORESTMP_TEPJF ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("TABLA"),
                  resul.getString("ID_REGISTRO"),
                  resul.getString("TIPO_ERROR"),
                  resul.getString("DES_ERROR")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
     
     
     public ArrayList TotalErrores_insert_tepjftr(){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select TABLA, ID_REGISTRO,TIPO_ERROR,replace(DES_ERROR,',','')DES_ERROR FROM ERRORESTR_TEPJF";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("TABLA"),
                  resul.getString("ID_REGISTRO"),
                  resul.getString("TIPO_ERROR"),
                  resul.getString("DES_ERROR")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
    
     public String Total_Reg_NI(String Tabla){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_RegTMP FROM  ERRORESTMP_TEPJF WHERE TABLA LIKE '%"+Tabla+"%' ";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_RegTMP");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
      return TotalReg;   
}   
     
     public String Total_Reg_NITR(String Tabla){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_RegTMP FROM  ERRORESTR_TEPJF WHERE TABLA LIKE '%"+Tabla+"%' AND TIPO_ERROR='-808'";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_RegTMP");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
      return TotalReg;   
}   
     
     public String Total_Reg_TMP(String Tabla){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_RegTMP FROM  "+Tabla+" ";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_RegTMP");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
      return TotalReg;   
} 
     
     
      public String Total_Reg_TR(String Tabla){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_RegTR FROM  "+Tabla+" ";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_RegTR");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
      return TotalReg;   
} 
      
      
      
 public void Update_IdActores(){
 conexion.Conectar();
      sql=" UPDATE TEMP_TR_TEPJF_ACTORES set ID_TEMP_TEPJF_ACTORES='TEMP-'||ID_TEMP_TEPJF_ACTORES||'-'||SEQUENCEID_ACTOR.Nextval  \n" +
"WHERE ID_TEMP_TEPJF_ACTORES in (SELECT ID_TEMP_TEPJF_ACTORES FROM(\n" +
" SELECT ID_TEMP_TEPJF_ACTORES, COUNT(ID_TEMP_TEPJF_ACTORES)\n" +
"FROM TEMP_TR_TEPJF_ACTORES\n" +
"GROUP BY ID_TEMP_TEPJF_ACTORES\n" +
"HAVING COUNT(ID_TEMP_TEPJF_ACTORES) > 1)) ";
      System.out.println(sql);
      try {
      conexion.escribir(sql);
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
  
}
 
 public void Update_IdResponsables(){
 conexion.Conectar();
      sql=" UPDATE TEMP_TR_TEPJF_RESPONSABLES set ID_TEMP_TEPJF_RESPONSABLES='TEMP-'||ID_TEMP_TEPJF_RESPONSABLES||'-'||SEQUENCEID_ACTOR.Nextval  \n" +
"WHERE ID_TEMP_TEPJF_RESPONSABLES in (SELECT ID_TEMP_TEPJF_RESPONSABLES FROM(\n" +
" SELECT ID_TEMP_TEPJF_RESPONSABLES, COUNT(ID_TEMP_TEPJF_RESPONSABLES)\n" +
"FROM TEMP_TR_TEPJF_RESPONSABLES\n" +
"GROUP BY ID_TEMP_TEPJF_RESPONSABLES\n" +
"HAVING COUNT(ID_TEMP_TEPJF_RESPONSABLES) > 1))";
      System.out.println(sql);
      try {
      conexion.escribir(sql);
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        } 
}
    
 public void Update_IdResoluciones(){
 conexion.Conectar();
      sql="UPDATE TEMP_TR_TEPJF_RESOLUCIONES set ID_TEMP_TEPJF_RESOLUCIONES='TEMP-'||ID_TEMP_TEPJF_RESOLUCIONES||'-'||SEQUENCEID_ACTOR.Nextval  \n" +
"WHERE ID_TEMP_TEPJF_RESOLUCIONES in (SELECT ID_TEMP_TEPJF_RESOLUCIONES FROM(\n" +
" SELECT ID_TEMP_TEPJF_RESOLUCIONES, COUNT(ID_TEMP_TEPJF_RESOLUCIONES)\n" +
"FROM TEMP_TR_TEPJF_RESOLUCIONES\n" +
"GROUP BY ID_TEMP_TEPJF_RESOLUCIONES\n" +
"HAVING COUNT(ID_TEMP_TEPJF_RESOLUCIONES) > 1))";
      System.out.println(sql);
      try {
      conexion.escribir(sql);
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        } 
}
 
 
}
