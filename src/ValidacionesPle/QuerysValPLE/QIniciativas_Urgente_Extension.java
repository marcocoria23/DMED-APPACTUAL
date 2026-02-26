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
public class QIniciativas_Urgente_Extension {
    DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul;

public ArrayList ID_INICIATIVA(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT P1_6A_1,P1_6A_2 ,P1_6_1,C1_6A_ID,Legislatura,ID_ENTIDAD FROM(\n" +
"select P.P1_6A_1,P.P1_6A_2 ,S.P1_6_1,P.C1_6A_ID,P.Legislatura,P.ID_ENTIDAD from TR_PLE_MEDS1_6A P LEFT JOIN\n" +
"TR_PLE_MEDS1_6 S \n" +
"ON P.ID_ENTIDAD= S.ID_ENTIDAD\n" +
"AND P.C1_6A_ID=  S.C1_6_ID\n" +
"AND P.LEGISLATURA=S.LEGISLATURA\n" +
"AND P.P1_6A_2=S.P1_6_1\n" +
")WHERE P1_6_1 IS NULL"
              + " AND (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6A_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6A_1"),
                  resul.getString("P1_6A_2")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

public ArrayList ID_PERSONA_LEGISLADORA(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT P1_6A_1,P1_6A_3 ,P1_3_1,C1_6A_ID,Legislatura,ID_ENTIDAD FROM(\n" +
"select P.P1_6A_1,P.P1_6A_3 ,S.P1_3_1,P.C1_6A_ID,P.Legislatura,P.ID_ENTIDAD from TR_PLE_MEDS1_6A P LEFT JOIN\n" +
"TR_PLE_MEDS1_3 S \n" +
"ON P.ID_ENTIDAD= S.ID_ENTIDAD\n" +
"AND P.C1_6A_ID=  S.C1_3_ID\n" +
"AND P.LEGISLATURA=S.LEGISLATURA\n" +
"AND P.P1_6A_3=S.P1_3_1\n" +
")WHERE P1_3_1 IS NULL"
              + " AND (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6A_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6A_1"),
                  resul.getString("P1_6A_3")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

////El ID_PERSONA_LEGISLADORA (P1_5A_3) de la tabla iniciativas_extension YA EXISTE en la tabla iniciativas. Favor de revisar la duplicidad para los ID que se indican
public ArrayList PERSONA_REPETIDA(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT INI_EXT.P1_6A_1 AS Numero_iniciativa_extension , INI_EXT.P1_6A_2 AS ID_Iniciativa_extension, ini_ext.P1_6A_3 as PERSONA_EXT, \n" +
"INI.P1_6_10  AS PER_1, INI.P1_6_12 AS PER_2, INI.P1_6_14 AS PER_3, INI.P1_6_16 AS PER_4, INI.P1_6_18 AS PER_5, \n" +
" INI.P1_6_20 AS PER_6, INI.P1_6_22 AS PER_7, INI.P1_6_24 AS PER_8, INI.P1_6_26 AS PER_9, INI.P1_6_28 AS PER_10,\n" +
" INI.P1_6_30 AS PER_11,INI.P1_6_32 AS PER_12,INI.P1_6_34 AS PER_13,INI.P1_6_36 AS PER_14,INI.P1_6_38 AS PER_15,\n" +
" INI.P1_6_40 AS PER_16,INI.P1_6_42 AS PER_17,INI.P1_6_44 AS PER_18,INI.P1_6_46 AS PER_19,INI.P1_6_48 AS PER_20,\n" +
"INI_EXT.C1_6A_ID AS ENVIO, INI_EXT.Legislatura,INI_EXT.ID_ENTIDAD \n" +
"from TR_PLE_MEDS1_6A INI_EXT\n" +
"LEFT JOIN TR_PLE_MEDS1_6 INI \n" +
"ON INI_EXT.ID_ENTIDAD= INI.ID_ENTIDAD\n" +
"AND INI_EXT.C1_6A_ID=  INI.C1_6_ID\n" +
"AND INI_EXT.LEGISLATURA=INI.LEGISLATURA\n" +
"AND INI_EXT.P1_6A_2=INI.P1_6_1\n" +
"--comparar que no haya repetidos\n" +
"WHERE INI_EXT.P1_6A_3 IN (\n" +
"    INI.P1_6_10, INI.P1_6_12, INI.P1_6_14, INI.P1_6_16,\n" +
"    INI.P1_6_18, INI.P1_6_20, INI.P1_6_22, INI.P1_6_24,\n" +
"    INI.P1_6_26, INI.P1_6_28,INI.P1_6_30,INI.P1_6_32,\n" +
"    INI.P1_6_34, INI.P1_6_38,INI.P1_6_40,INI.P1_6_42,\n" +
"    INI.P1_6_44, INI.P1_6_46,INI.P1_6_48)"
              + "and (INI_EXT.ID_ENTIDAD="+ID_entidad+" AND INI_EXT.Legislatura="+Legislatura+" AND INI_EXT.C1_6A_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                 resul.getString("Numero_iniciativa_extension"),
                 resul.getString("ID_Iniciativa_extension"),
                  resul.getString("ID_ENTIDAD")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

////Aún hay espacio en la tabla personas_legisladoras para anotar personas_legisladoras_promoventes_iniciativa. Favor de eliminar los registros de la tabla de extensión y completar los espacios vacíos de personas_legisladoras para el ID de iniciativa que se indica";
public ArrayList PERSONA_ESPACIO_DISPONIBLE(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT INI_EXT.P1_6A_1 AS Numero_iniciativa_extension , INI_EXT.P1_6A_2 AS ID_Iniciativa_extension, \n" +
"INI.P1_6_10  AS PER_1, INI.P1_6_12 AS PER_2, INI.P1_6_14 AS PER_3, INI.P1_6_16 AS PER_4, INI.P1_6_18 AS PER_5, \n" +
" INI.P1_6_20 AS PER_6, INI.P1_6_22 AS PER_7, INI.P1_6_24 AS PER_8, INI.P1_6_26 AS PER_9, INI.P1_6_28 AS PER_10,\n" +
" INI.P1_6_30 AS PER_11,INI.P1_6_32 AS PER_12,INI.P1_6_34 AS PER_13,INI.P1_6_36 AS PER_14,INI.P1_6_38 AS PER_15,\n" +
" INI.P1_6_40 AS PER_16,INI.P1_6_42 AS PER_17,INI.P1_6_44 AS PER_18,INI.P1_6_46 AS PER_19,INI.P1_6_48 AS PER_20,\n" +
"INI_EXT.C1_6A_ID AS ENVIO, INI_EXT.Legislatura,INI_EXT.ID_ENTIDAD \n" +
"from TR_PLE_MEDS1_6A INI_EXT\n" +
"inner JOIN TR_PLE_MEDS1_6 INI \n" +
"ON INI_EXT.ID_ENTIDAD= INI.ID_ENTIDAD\n" +
"AND INI_EXT.C1_6A_ID=  INI.C1_6_ID\n" +
"AND INI_EXT.LEGISLATURA=INI.LEGISLATURA\n" +
"AND INI_EXT.P1_6A_2=INI.P1_6_1\n" +
"--verificar que no haya espacios vacios\n" +
"WHERE \n" +
"    INI.P1_6_10 is null or INI.P1_6_12 is null or INI.P1_6_14 is null or INI.P1_6_16 is null or\n" +
"    INI.P1_6_18 is null or INI.P1_6_20 is null or INI.P1_6_22 is null or INI.P1_6_24 is null or\n" +
"    INI.P1_6_26 is null or INI.P1_6_28 is null or INI.P1_6_30 is null or INI.P1_6_32 is null or\n" +
"    INI.P1_6_34 is null or INI.P1_6_38 is null or INI.P1_6_40 is null or INI.P1_6_42 is null or\n" +
"    INI.P1_6_44 is null or INI.P1_6_46 is null or INI.P1_6_48 is null"
 +" AND (INI_EXT.ID_ENTIDAD="+ID_entidad+" AND INI_EXT.Legislatura="+Legislatura+" AND INI_EXT.C1_6A_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("Numero_iniciativa_extension"),
                  resul.getString("ID_Iniciativa_extension"),
                  resul.getString("ID_ENTIDAD")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


}