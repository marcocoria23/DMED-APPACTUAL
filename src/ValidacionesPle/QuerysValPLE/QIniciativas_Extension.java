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
public class QIniciativas_Extension {
    DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul;

//ID_INICIATIVA en Iniciativas_extension (TR_PLE_MEDS1_5A) P1_5A_2 B No existe en ID_INICIATIVA P1_5_1 (A) de la tabla TR_PLE_MEDS1_5 pestaña iniciativas
public ArrayList ID_INICIATIVA(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT P1_5A_1,P1_5A_2 ,P1_5_1,C1_5A_ID,Legislatura,ID_ENTIDAD FROM(\n" +
"select P.P1_5A_1,P.P1_5A_2 ,S.P1_5_1,P.C1_5A_ID,P.Legislatura,P.ID_ENTIDAD from TR_PLE_MEDS1_5A P LEFT JOIN\n" +
"TR_PLE_MEDS1_5 S \n" +
"ON P.ID_ENTIDAD= S.ID_ENTIDAD\n" +
"AND P.C1_5A_ID=  S.C1_5_ID\n" +
"AND P.LEGISLATURA=S.LEGISLATURA\n" +
"AND P.P1_5A_2=S.P1_5_1\n" +
")WHERE P1_5_1 IS NULL"
              + " AND (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_5A_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_5A_1"),
                  resul.getString("P1_5A_2")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//ID_PERSONA_LEGISLADORA en Iniciativas_extension (TR_PLE_MEDS1_5A) P1_5A_3 C No existe en ID_PERSONA_LEGISLADORA P1_3_1 (A) de la tabla TR_PLE_MEDS1_3 pestaña personas_legisladoras
public ArrayList ID_PERSONA_LEGISLADORA(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT P1_5A_1,P1_5A_3 ,P1_3_1,C1_5A_ID,Legislatura,ID_ENTIDAD FROM(\n" +
"select P.P1_5A_1,P.P1_5A_3 ,S.P1_3_1,P.C1_5A_ID,P.Legislatura,P.ID_ENTIDAD from TR_PLE_MEDS1_5A P LEFT JOIN\n" +
"TR_PLE_MEDS1_3 S \n" +
"ON P.ID_ENTIDAD= S.ID_ENTIDAD\n" +
"AND P.C1_5A_ID=  S.C1_3_ID\n" +
"AND P.LEGISLATURA=S.LEGISLATURA\n" +
"AND P.P1_5A_3=S.P1_3_1\n" +
")WHERE P1_3_1 IS NULL"
              + " AND (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_5A_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_5A_1"),
                  resul.getString("P1_5A_3")
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
      sql="SELECT INI_EXT.P1_5A_1 AS Numero_iniciativa_extension , INI_EXT.P1_5A_2 AS ID_Iniciativa_extension, \n" +
"INI.P1_5_19  AS PER_1, INI.P1_5_21 AS PER_2, INI.P1_5_23 AS PER_3, INI.P1_5_25 AS PER_4, INI.P1_5_27 AS PER_5, \n" +
" INI.P1_5_29 AS PER_6, INI.P1_5_31 AS PER_7, INI.P1_5_33 AS PER_8, INI.P1_5_35 AS PER_9, INI.P1_5_37 AS PER_10,\n" +
" INI.P1_5_39 AS PER_11,INI.P1_5_41 AS PER_12,INI.P1_5_43 AS PER_13,INI.P1_5_45 AS PER_14,INI.P1_5_47 AS PER_15,\n" +
" INI.P1_5_49 AS PER_16,INI.P1_5_51 AS PER_17,INI.P1_5_53 AS PER_18,INI.P1_5_55 AS PER_19,\n" +
"INI_EXT.C1_5A_ID AS ENVIO, INI_EXT.Legislatura,INI_EXT.ID_ENTIDAD \n" +
"from TR_PLE_MEDS1_5A INI_EXT\n" +
"LEFT JOIN TR_PLE_MEDS1_5 INI \n" +
"ON INI_EXT.ID_ENTIDAD= INI.ID_ENTIDAD\n" +
"AND INI_EXT.C1_5A_ID=  INI.C1_5_ID\n" +
"AND INI_EXT.LEGISLATURA=INI.LEGISLATURA\n" +
"AND INI_EXT.P1_5A_2=INI.P1_5_1\n" +
"--comparar que no haya repetidos\n" +
"WHERE INI.P1_5_19=P1_5A_2 OR INI.P1_5_21=P1_5A_2 OR INI.P1_5_23=P1_5A_2 OR INI.P1_5_25=P1_5A_2\n" +
" OR INI.P1_5_27=P1_5A_2 OR INI.P1_5_29=P1_5A_2 OR INI.P1_5_31=P1_5A_2 OR INI.P1_5_33=P1_5A_2 OR \n" +
" INI.P1_5_35=P1_5A_2 OR INI.P1_5_37=P1_5A_2 OR INI.P1_5_39=P1_5A_2 OR INI.P1_5_41=P1_5A_2 \n" +
" OR INI.P1_5_43=P1_5A_2 OR INI.P1_5_45=P1_5A_2 OR INI.P1_5_47=P1_5A_2 OR INI.P1_5_49=P1_5A_2 OR \n" +
" INI.P1_5_51=P1_5A_2 OR INI.P1_5_53=P1_5A_2 OR INI.P1_5_55=P1_5A_2 AND (INI_EXT.ID_ENTIDAD="+ID_entidad+" AND INI_EXT..Legislatura="+Legislatura+" AND INI_EXT..C1_3A_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                 resul.getString("Numero_iniciativa_extension"),
                 resul.getString("ID_Iniciativa_extension")
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
      sql="SELECT INI_EXT.P1_5A_1 AS Numero_iniciativa_extension , INI_EXT.P1_5A_2 AS ID_Iniciativa_extension, \n" +
"INI.P1_5_19  AS PER_1, INI.P1_5_21 AS PER_2, INI.P1_5_23 AS PER_3, INI.P1_5_25 AS PER_4, INI.P1_5_27 AS PER_5, \n" +
" INI.P1_5_29 AS PER_6, INI.P1_5_31 AS PER_7, INI.P1_5_33 AS PER_8, INI.P1_5_35 AS PER_9, INI.P1_5_37 AS PER_10,\n" +
" INI.P1_5_39 AS PER_11,INI.P1_5_41 AS PER_12,INI.P1_5_43 AS PER_13,INI.P1_5_45 AS PER_14,INI.P1_5_47 AS PER_15,\n" +
" INI.P1_5_49 AS PER_16,INI.P1_5_51 AS PER_17,INI.P1_5_53 AS PER_18,INI.P1_5_55 AS PER_19,\n" +
"INI_EXT.C1_5A_ID AS ENVIO, INI_EXT.Legislatura,INI_EXT.ID_ENTIDAD \n" +
"from TR_PLE_MEDS1_5A INI_EXT\n" +
"LEFT JOIN TR_PLE_MEDS1_5 INI \n" +
"ON INI_EXT.ID_ENTIDAD= INI.ID_ENTIDAD\n" +
"AND INI_EXT.C1_5A_ID=  INI.C1_5_ID\n" +
"AND INI_EXT.LEGISLATURA=INI.LEGISLATURA\n" +
"AND INI_EXT.P1_5A_2=INI.P1_5_1\n" +
"--comparar que no haya repetidos\n" +
"WHERE INI.P1_5_19  is null OR INI.P1_5_21  is null OR INI.P1_5_23  is null OR INI.P1_5_25  is null\n" +
" OR INI.P1_5_27  is null OR INI.P1_5_29  is null OR INI.P1_5_31  is null OR INI.P1_5_33  is null OR \n" +
" INI.P1_5_35  is null OR INI.P1_5_37  is null OR INI.P1_5_39  is null OR INI.P1_5_41  is null \n" +
" OR INI.P1_5_43  is null OR INI.P1_5_45  is null OR INI.P1_5_47  is null OR INI.P1_5_49  is null OR \n" +
" INI.P1_5_51  is null OR INI.P1_5_53  is null OR INI.P1_5_55  is null"
 +" AND (COMP_EXT.ID_ENTIDAD="+ID_entidad+" AND INI_EXT.Legislatura="+Legislatura+" AND INI_EXT.C1_9A_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("Numero_iniciativa_extension"),
                  resul.getString("ID_Iniciativa_extension")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


}