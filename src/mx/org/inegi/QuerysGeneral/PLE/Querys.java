/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.QuerysGeneral.PLE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.PLE.DaoConexion;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Querys {
    
    DaoConexion conexion=new DaoConexion();
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
    
    public String Total_Reg_TMP(String Tabla,String entidad,String CampoEnvio,String envio,String Legislatura){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_RegTMP FROM  "+Tabla+" where  ID_ENTIDAD_TMP='"+entidad+"' AND LEGISLATURA_TMP='"+Legislatura+"' and "+CampoEnvio+"='"+envio+"' ";
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
    
    public String Total_Reg_TR(String Tabla,String entidad,String CampoEnvio,String envio,String Legislatura){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_RegTR FROM  "+Tabla+" where  ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"' and "+CampoEnvio+"='"+envio+"' ";
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
    
    
    public String Total_Reg_NI(String Tabla,String entidad,String Campo,String envio,String Legislatura){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_RegTMP FROM  TR_PLE_OBSERVACIONES where ID_ENVIO='"+envio+"' AND ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"' AND TABLA LIKE '%"+Tabla+"%' and CAMPO='-808' ";
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
    
    
    
    
    
     public String Total_Reg_Valid(String entidad,String envio,String Legislatura){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_RegTMP FROM  TR_PLE_OBSERVACIONES where ID_ENVIO='"+envio+"' AND ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  and CAMPO NOT IN '-808' ";
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
  
    
     
     public ArrayList TotalErrores_insert_pletmp(String entidad,String envio, String legislatura){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select TABLA, ID_TABLA,CAMPO,replace(DESCRIPCION,',','')DESCRIPCION FROM TR_PLE_OBSERVACIONES "
              + " WHERE ENTIDAD='"+entidad+"' and ID_ENVIO='"+envio+"' and LEGISLATURA='"+legislatura+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("TABLA"),
                  resul.getString("ID_TABLA"),
                  resul.getString("CAMPO"),
                  resul.getString("DESCRIPCION")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }   
     
     
     public void EliminaRegERRORES_INSERT_RALAB(String Tabla,String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_OBSERVACIONES WHERE ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND ID_ENVIO='"+Envio+"' AND CAMPO='-808' " ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
       
}
     
          public void EliminaRegERRORES_TEMPORAL(String Tabla,String entidad,String Envio,String Legislatura,String Campo){
 conexion.Conectar();    
      sql="DELETE FROM "+Tabla+" WHERE ID_ENTIDAD_TMP='"+entidad+"' AND LEGISLATURA_TMP='"+Legislatura+"' AND "+Campo+"='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
       
}
          

             public void EliminaRegERRORES_TR(String Tabla,String entidad,String Envio,String Legislatura,String Campo){
 conexion.Conectar();    
      sql="DELETE FROM "+Tabla+" WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"' AND "+Campo+"='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
       
}
     
     public ArrayList TablaErroresInsert(String entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList(); 
      sql="SELECT UNIQUE(TABLA) FROM TR_PLE_OBSERVACIONES WHERE ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"' AND ID_ENVIO='"+Envio+"' AND CAMPO='-808'" ;
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("TABLA")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
     }
     
     
      public String Estatus(String entidad,String Legislatura,String Envio){
     conexion.Conectar();
      String Est="";
      sql="SELECT ESTATUS FROM TR_PLE_MEDS1_1 WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"' AND C1_1_ID='"+Envio+"'" ;
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          if (resul.next()) {   
                Est=resul.getString("ESTATUS");
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Est;
     }
    
      
      
        public void Cambio_Estatus(String entidad,String Legislatura,String Envio,String Estatus){
     conexion.Conectar();
      sql="UPDATE TR_PLE_MEDS1_1 SET ESTATUS='"+Estatus+"'  WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"' AND C1_1_ID='"+Envio+"'" ;
      sql2="UPDATE TMP_PLE_MEDS1_1 SET ESTATUS='"+Estatus+"'  WHERE ID_ENTIDAD_TMP='"+entidad+"' AND LEGISLATURA_TMP='"+Legislatura+"' AND C1_1_ID_TMP='"+Envio+"'" ;
      System.out.println(sql);
      System.out.println(sql2);
      try {
      conexion.escribir(sql);
      conexion.escribir(sql2);
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
   
     }
    
    
}
