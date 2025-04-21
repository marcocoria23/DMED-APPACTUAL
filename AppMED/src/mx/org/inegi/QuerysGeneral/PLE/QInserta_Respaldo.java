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
public class QInserta_Respaldo {
    
     DaoConexion conexion=new DaoConexion();
    ResultSet resul; 
    String sql="";
    
    
    
     public void IR1(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_1 (SELECT * FROM TR_PLE_MEDS1_1  WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_1_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
    
      public void IR1A(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_1A (SELECT * FROM TR_PLE_MEDS1_1A  WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_1A_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
      
       public void IR1B(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_1B (SELECT * FROM TR_PLE_MEDS1_1B  WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_1B_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
       
        public void IR1C(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_1C (SELECT * FROM TR_PLE_MEDS1_1C  WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_1C_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
        
         public void IR1D(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_1D (SELECT * FROM TR_PLE_MEDS1_1D  WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_1D_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
         
          public void IR2(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_2 (SELECT * FROM TR_PLE_MEDS1_2 WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_2_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
          
          
            public void IR3(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_3 (SELECT * FROM TR_PLE_MEDS1_3 WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_3_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
            
              public void IR4(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_4 (SELECT * FROM TR_PLE_MEDS1_4 WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_4_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
              
                public void IR5(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_5 (SELECT * FROM TR_PLE_MEDS1_5 WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_5_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
                
                  public void IR6(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_6 (SELECT * FROM TR_PLE_MEDS1_6 WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_6_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
                  
                    public void IR7(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_7 (SELECT * FROM TR_PLE_MEDS1_7 WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_7_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
                    
                      public void IR8(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_8 (SELECT * FROM TR_PLE_MEDS1_8 WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_8_ID='"+Envio+"')" ;
      System.out.println(sql);
      try {
      conexion.escribir(sql);   
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }    
}
                      
                        public void IR9(String entidad,String Envio,String Legislatura){
 conexion.Conectar();    
      sql="INSERT INTO  LIB_PLE_MEDS1_9 (SELECT * FROM TR_PLE_MEDS1_9 WHERE WHERE ID_ENTIDAD='"+entidad+"' AND LEGISLATURA='"+Legislatura+"'  AND C1_9_ID='"+Envio+"')" ;
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
