/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionesPle.QuerysValPLE;

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
public class QGEN {
    
    DaoConexion conexion = new DaoConexion();
String sql,NMunicipio;
ArrayList<String[]> Array;
String Legis;
ResultSet resul;   


public ArrayList Legislatura(String ID_entidad){
     conexion.Conectar();
      Array = new ArrayList();
      sql="Select unique(P1_1_1)P1_1_1 from TR_PLE_MEDS1_1 WHERE ID_ENTIDAD='"+ID_entidad+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
             
               Array.add(new String[]{
                  resul.getString("P1_1_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QIniciativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

public ArrayList Envios(String ID_entidad,String Legislatura){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT UNIQUE(C1_1_ID) ENVIOS FROM TR_PLE_MEDS1_1 WHERE ID_ENTIDAD='"+ID_entidad+"' AND LEGISLATURA='"+Legislatura+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ENVIOS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QIniciativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
}
