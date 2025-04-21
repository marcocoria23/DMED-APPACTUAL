/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.QuerysGeneral.PSF;

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
public class Querys {
  
     DaoConexionPSF conexion=new DaoConexionPSF();
    ResultSet resul; 
    String sql="",sql2="";
    ArrayList<String[]> Array;
    
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
    
    
    
  public String Total_Reg_NITMP(String Tabla){
 conexion.Conectar();
 String TotalReg="";
      sql="SELECT COUNT(*) Total_RegNITMP FROM TR_PSF_OBSERVACIONES WHERE TABLA='"+Tabla+"' ";
      System.out.println(sql);
     resul=conexion.consultar(sql);
      try {
       if (resul.next()) {
              TotalReg=resul.getString("Total_RegNITMP");
       }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showInputDialog(null, "Se han eliminado los registros de tabla:V3_ERRORES_INSERT_RALAB");
        }
      return TotalReg;   
}   
    
 public ArrayList TotalErrores_insert_TMP(String Año) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select TABLA, ID_TABLA,replace(DESCRIPCION,',','')DESCRIPCION FROM TR_PSF_OBSERVACIONES WHERE TABLA LIKE '%TMP_%' "
              + " AND TABLA LIKE '%GEN%'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("TABLA"),
                  resul.getString("ID_TABLA"),
                  resul.getString("DESCRIPCION")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 } 
  
 
 public ArrayList TotalErrores_insert_TR(String Año) throws SQLException{
     conexion.Conectar();
      Array = new ArrayList();
      sql="select TABLA, ID_TABLA,replace(DESCRIPCION,',','')DESCRIPCION FROM TR_PSF_OBSERVACIONES WHERE TABLA LIKE '%TR_%' "
              + " AND TABLA LIKE '%"+Año+"%'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("TABLA"),
                  resul.getString("ID_TABLA"),
                  resul.getString("DESCRIPCION")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(Querys.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
}
