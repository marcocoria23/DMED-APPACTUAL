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
 * @author LAURA.MEDINA
 */
public class QPersonas_comparecencias_extension {
       DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul;

//El ID_COMISION_LEGISLATIVA (P1_9A_3) de la tabla Comparecencias_extension NO existe en la tabla Comisiones_Legislativas
public ArrayList ID_COMISION_LEGISLATIVA(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT P1_9A_1 as Numero_comparecencia_extension ,P1_9A_2 as ID_comparecencia_extension, P1_9A_3 as ID_comision_extension,C1_9A_ID as envio,Legislatura,ID_ENTIDAD \n" +
"FROM( SELECT COMP_EXT.P1_9A_1 , COMP_EXT.P1_9A_2, COMP_EXT.P1_9A_3,COM.P1_2_1,COMP_EXT.C1_9A_ID,COMP_EXT.Legislatura,COMP_EXT.ID_ENTIDAD \n" +
"from TR_PLE_MEDS1_9A COMP_EXT\n" +
"LEFT JOIN TR_PLE_MEDS1_2 COM \n" +
"ON COMP_EXT.ID_ENTIDAD= COM.ID_ENTIDAD\n" +
"AND COMP_EXT.C1_9A_ID=  COM.C1_2_ID\n" +
"AND COMP_EXT.LEGISLATURA=COM.LEGISLATURA\n" +
"AND COMP_EXT.P1_9A_3=COM.P1_2_1\n" +
")\n" +
"WHERE P1_2_1 IS NULL"
              + " AND (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9A_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{                
                  resul.getString("ID_comparecencia_extension"),
                    resul.getString("ID_comision_extension")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

////El ID_COMISION_LEGISLATIVA (P1_9A_3) de la tabla Comparecencias_extension YA EXISTE en la tabla Comparecencias. Favor de revisar la duplicidad para los ID que se indican
public ArrayList COMISION_REPETIDA(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT COMP_EXT.P1_9A_1 AS Numero_comparecencia_extension , COMP_EXT.P1_9A_2 AS ID_comparecencia_extension, P1_9_1 as ID_COMPARECENCIA_ORIGEN,\n" +
"COMP.P1_9_8 as COM_1,COMP.P1_9_10 AS COM_2,COMP.P1_9_12 AS COM_3,COMP_EXT.P1_9A_3 AS COM_EXT,\n" +
"COMP_EXT.C1_9A_ID AS ENVIO, COMP_EXT.Legislatura,COMP_EXT.ID_ENTIDAD \n" +
"from TR_PLE_MEDS1_9A COMP_EXT\n" +
"LEFT JOIN TR_PLE_MEDS1_9 COMP \n" +
"ON COMP_EXT.ID_ENTIDAD= COMP.ID_ENTIDAD\n" +
"AND COMP_EXT.C1_9A_ID=  COMP.C1_9_ID\n" +
"AND COMP_EXT.LEGISLATURA=COMP.LEGISLATURA\n" +
"AND COMP_EXT.P1_9A_2=COMP.P1_9_1\n" +
"--comparar que no haya repetidos\n" +
"WHERE  COMP.P1_9_8=COMP_EXT.P1_9A_3 OR  COMP.P1_9_10=COMP_EXT.P1_9A_3 OR COMP.P1_9_12= COMP_EXT.P1_9A_3"
              + " AND (COMP_EXT.ID_ENTIDAD="+ID_entidad+" AND COMP_EXT.Legislatura="+Legislatura+" AND COMP_EXT.C1_9A_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                 resul.getString("ID_comparecencia_extension"),
                  resul.getString("COM_EXT")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

////Aún hay espacio en la tabla Comparecencias para anotar Comisiones legislativas. Favor de eliminar los registros de la tabla de extensión y completar los espacios vacíos de comisiones para el ID de Comparecencia que se indica
public ArrayList COMISION_ESPACIO_DISPONIBLE(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT COMP_EXT.P1_9A_1 AS Numero_comparecencia_extension , COMP_EXT.P1_9A_2 AS ID_comparecencia_extension, P1_9_1 as ID_COMPARECENCIA_ORIGEN,\n" +
"COMP.P1_9_8 as COM_1,COMP.P1_9_10 AS COM_2,COMP.P1_9_12 AS COM_3,COMP_EXT.P1_9A_3 AS COM_EXT,\n" +
"COMP_EXT.C1_9A_ID AS ENVIO, COMP_EXT.Legislatura,COMP_EXT.ID_ENTIDAD \n" +
"from TR_PLE_MEDS1_9A COMP_EXT\n" +
"LEFT JOIN TR_PLE_MEDS1_9 COMP \n" +
"ON COMP_EXT.ID_ENTIDAD= COMP.ID_ENTIDAD\n" +
"AND COMP_EXT.C1_9A_ID=  COMP.C1_9_ID\n" +
"AND COMP_EXT.LEGISLATURA=COMP.LEGISLATURA\n" +
"AND COMP_EXT.P1_9A_2=COMP.P1_9_1\n" +
"-- Revisar si hay disponibilidad de espacio en tabla 9\n" +
"WHERE COMP.P1_9_8 IS NULL OR COMP.P1_9_10 IS NULL OR COMP.P1_9_12 IS NULL "
              + " AND (COMP_EXT.ID_ENTIDAD="+ID_entidad+" AND COMP_EXT.Legislatura="+Legislatura+" AND COMP_EXT.C1_9A_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                   resul.getString("ID_comparecencia_extension"),
                   resul.getString("COM_EXT"),
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

}
