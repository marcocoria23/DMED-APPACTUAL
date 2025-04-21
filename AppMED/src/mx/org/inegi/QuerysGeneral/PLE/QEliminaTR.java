/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.QuerysGeneral.PLE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.PLE.DaoConexion;

/**
 *
 * @author ANTONIO.CORIA
 */
public class QEliminaTR {
    
     DaoConexion conexion=new DaoConexion();
    ResultSet resul; 
    String sql="";
    
    
    
     public void Elimina1(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_1 WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_1_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
     
     public void Elimina1A(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_1A WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_1A_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
     
     public void Elimina1B(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_1B WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_1B_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
     
     
     public void Elimina1C(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_1C WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_1C_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
     
     public void Elimina1D(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_1D WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_1D_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
     
     public void Elimina2(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_2 WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_2_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
     
     public void Elimina3(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_3 WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_3_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
     
      public void Elimina3A(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_3A WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_3A_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
     
     
     public void Elimina4(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_4 WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_4_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
     
     public void Elimina5(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_5 WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_5_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
     
      public void Elimina6(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_6 WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_6_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
      
       public void Elimina7(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_7 WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_7_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
       
        public void Elimina8(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_8 WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_8_ID='"+Envio+"'" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
        
         public void Elimina9(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="DELETE FROM TR_PLE_MEDS1_9 WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_9_ID='"+Envio+"'" ;
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
