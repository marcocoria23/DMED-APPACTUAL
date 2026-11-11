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
public class QIniciativas_ExtensionB {
    DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul;

//El valor de ID_iniciativa_extension, registrado en la pestaña Iniciativas_extension B (TR_PLE_MEDS1_5B, campo P1_5B_3), no se encuentra registrado en el campo ID_INICIATIVA (P1_5_1) de la pestaña Iniciativas (TR_PLE_MEDS1_5).
public ArrayList ID_INICIATIVA(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql=" SELECT P1_5B_3 ,P1_5_1,C1_5B_ID AS ENVIO,ID_ENTIDAD FROM(\n" +
"select P.P1_5B_3, S.P1_5_1,P.C1_5B_ID,P.ID_ENTIDAD from TR_PLE_MEDS1_5B P LEFT JOIN\n" +
"TR_PLE_MEDS1_5 S \n" +
"ON P.ID_ENTIDAD= S.ID_ENTIDAD\n" +
"AND P.C1_5B_ID=  S.C1_5_ID \n" +
"AND P.P1_5B_3=S.P1_5_1\n" +
")WHERE P1_5_1 IS NULL"
              + " AND (ID_ENTIDAD="+ID_entidad+"  AND C1_5B_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_5B_3"),
                  resul.getString("P1_5_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

///El valor de ID_comision_legislativa_primer_o_segundo_estudio, registrado en la pestaña Iniciativas_extension B (TR_PLE_MEDS1_5B, campo E- P1_5B_4), no se encuentra registrado en el campo ID_COMISION_LEGISLATIVA (A-P1_2_1) de la pestaña Comisiones_Legislativas (TR_PLE_MEDS1_2).
public ArrayList ID_COMISION(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT  P1_5B_4 ,P1_2_1,C1_5B_ID AS ENVIO,ID_ENTIDAD FROM(\n" +
"select  P.P1_5B_4 ,S.P1_2_1,P.C1_5B_ID, P.ID_ENTIDAD from TR_PLE_MEDS1_5B P LEFT JOIN\n" +
"TR_PLE_MEDS1_2 S \n" +
"ON P.ID_ENTIDAD= S.ID_ENTIDAD\n" +
"AND P.C1_5B_ID=  S.C1_2_ID\n" +
"AND P.P1_5B_4=S.P1_2_1\n" +
")WHERE P1_2_1 IS NULL"
              + " AND (ID_ENTIDAD="+ID_entidad+"  AND C1_5B_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_5B_4"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


///El valor de ID_comision_legislativa_primer_o_segundo_estudio (E) NO COINCIDE con el nombre (F) reporatdo registrado en la pestaña pestaña Comisiones_Legislativas (TR_PLE_MEDS1_2).
public ArrayList NOMBRE_COMISION(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT\n" +
"    P.P1_5B_4 AS ID_COMISION_TABLA_1, P.P1_5B_1 as EXT_ID, P.P1_5B_3 AS INICIATIVA,\n" +
"    S.P1_2_1 AS ID_COMISION_TABLA_2,\n" +
"    P.P1_5B_5 AS DESCRIPCION_TABLA_1,\n" +
"    S.P1_2_3 AS DESCRIPCION_TABLA_2,\n" +
"    P.C1_5B_ID AS ENVIO,\n" +
"    P.ID_ENTIDAD\n" +
"FROM TR_PLE_MEDS1_5B P\n" +
"LEFT JOIN TR_PLE_MEDS1_2 S\n" +
"    ON S.ID_ENTIDAD = P.ID_ENTIDAD\n" +
"   AND S.C1_2_ID = P.C1_5B_ID\n" +
"   AND S.P1_2_3 = P.P1_5B_5\n" +
"WHERE \n" +
"DECODE(S.P1_2_1, P.P1_5B_4, 0, 1) = 1"
              + " AND (P.ID_ENTIDAD="+ID_entidad+"  AND P.C1_5B_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("EXT_ID"),
                  resul.getString("INICIATIVA")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//En el campo Primer_o_segundo_Estudio_comision (C) de la tabla Extensión Iniciativas B, se reporta un estudio que no coincide con el registrado en el campo etapa_procesal_iniciativa (J) de la tabla Iniciativas (TR_PLE_MEDS1_5) para el mismo envío e iniciativa.
public ArrayList Estudio_comision(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT\n" +
"  EXT.P1_5B_1 AS ID_EXT,\n" +
"  EXT.P1_5B_3 AS ID_INICIATIVA_EXT,\n" +
"    EXT.P1_5B_2 AS ESTUDIO_EXT,\n" +
"    TR.P1_5_10 AS ESTUDIO_TR,\n" +
"    EXT.C1_5B_ID AS ENVIO,\n" +
"    EXT.ID_ENTIDAD\n" +
"FROM TR_PLE_MEDS1_5B EXT\n" +
"LEFT JOIN TR_PLE_MEDS1_5 TR\n" +
"    ON TR.C1_5_ID = EXT.C1_5B_ID\n" +
"   AND TR.C1_5_ID = EXT.C1_5B_ID\n" +
"   AND TR.P1_5_1 = EXT.P1_5B_3\n" +
"WHERE \n" +
"(   EXT.P1_5B_2=2 and(TR.P1_5_10<> 2) --Segundo estudio\n" +
"or (EXT.P1_5B_2=1 and TR.P1_5_10<> 1)) --Primer estudio\n" +
"AND (EXT.ID_ENTIDAD = "+ID_entidad+"  AND EXT.C1_5B_ID = "+Envio+") ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                 resul.getString("ID_EXT"),
                  resul.getString("ID_INICIATIVA_EXT"),
                  resul.getString("ID_ENTIDAD")});
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//La comisión registrada en el campo ID_comision_legislativa_primer_o_segundo_estudio (E) en la pestaña de Extnsiones iniciativas B ya está registrada en la tabla iniciativas en la sección estudio
public ArrayList consecutivo_ext(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="WITH SECUENCIA AS (\n" +
"    SELECT\n" +
"        P.ID_ENTIDAD,\n" +
"        P.C1_5B_ID,\n" +
"        P.P1_5B_3 AS ID_INICIATIVA,\n" +
"        P.P1_5B_2 AS TIPO_ESTUDIO,\n" +
"        P.P1_5B_1 AS CONSECUTIVO_REPORTADO,\n" +
"        P.P1_5B_4 AS ID_COMISION,\n" +
"        P.P1_5B_5 AS NOMBRE_COMISION,\n" +
"\n" +
"        ROW_NUMBER() OVER (\n" +
"            PARTITION BY\n" +
"                P.ID_ENTIDAD,\n" +
"                P.C1_5B_ID,\n" +
"                P.P1_5B_3,\n" +
"                P.P1_5B_2\n" +
"            ORDER BY\n" +
"                P.P1_5B_1,\n" +
"                P.P1_5B_4\n" +
"        ) + 5 AS CONSECUTIVO_ESPERADO\n" +
"\n" +
"    FROM TR_PLE_MEDS1_5B P\n" +
"    WHERE P.ID_ENTIDAD = "+Envio+"\n" +
"      AND P.C1_5B_ID = "+ID_entidad+"\n" +
")\n" +
"SELECT\n" +
"    ID_ENTIDAD,\n" +
"    C1_5B_ID AS ENVIO,\n" +
"    ID_INICIATIVA,\n" +
"    TIPO_ESTUDIO,\n" +
"    CONSECUTIVO_REPORTADO,\n" +
"    CONSECUTIVO_ESPERADO,\n" +
"    ID_COMISION,\n" +
"    NOMBRE_COMISION\n" +
"FROM SECUENCIA\n" +
"WHERE CONSECUTIVO_REPORTADO IS NULL\n" +
"   OR CONSECUTIVO_REPORTADO <> CONSECUTIVO_ESPERADO\n" +
"ORDER BY\n" +
"    ID_INICIATIVA,\n" +
"    TIPO_ESTUDIO,\n" +
"    CONSECUTIVO_ESPERADO\n" ;
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                 resul.getString("ID_ENTIDAD"),
                  resul.getString("CONSECUTIVO_ESPERADO"),
                  resul.getString("ID_INICIATIVA")});
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//La comisión registrada en el campo ID_comision_legislativa_primer_o_segundo_estudio (E) en la pestaña de Extnsiones iniciativas B ya está registrada en la tabla iniciativas en la sección estudio
public ArrayList comision_repetida(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="WITH TR_COMISIONES AS (\n" +
"    SELECT\n" +
"        ID_ENTIDAD,\n" +
"        C1_5_ID,\n" +
"        P1_5_1,\n" +
"        CAMPO,\n" +
"        ID_COMISION,\n" +
"        CASE\n" +
"            WHEN CAMPO IN (\n" +
"                'P1_5_74', 'P1_5_76', 'P1_5_78',\n" +
"                'P1_5_80', 'P1_5_82'\n" +
"            ) THEN 1\n" +
"            ELSE 2\n" +
"        END AS ESTUDIO\n" +
"    FROM TR_PLE_MEDS1_5\n" +
"    UNPIVOT (\n" +
"        ID_COMISION FOR CAMPO IN (\n" +
"            P1_5_74 AS 'P1_5_74',\n" +
"            P1_5_76 AS 'P1_5_76',\n" +
"            P1_5_78 AS 'P1_5_78',\n" +
"            P1_5_80 AS 'P1_5_80',\n" +
"            P1_5_82 AS 'P1_5_82',\n" +
"            P1_5_84 AS 'P1_5_84',\n" +
"            P1_5_86 AS 'P1_5_86',\n" +
"            P1_5_88 AS 'P1_5_88',\n" +
"            P1_5_90 AS 'P1_5_90',\n" +
"            P1_5_92 AS 'P1_5_92'\n" +
"        )\n" +
"    )\n" +
")\n" +
"SELECT\n" +
"    EXT.P1_5B_1 AS ID_EXT,\n" +
"    EXT.P1_5B_3 AS ID_INICIATIVA_EXT,\n" +
"    EXT.P1_5B_2 AS ESTUDIO_EXT,\n" +
"    EXT.P1_5B_4 AS ID_COMISION_EXTENSION,\n" +
"    TR.ID_COMISION AS ID_COMISION_INICIATIVA,\n" +
"    TR.CAMPO AS CAMPO_DONDE_SE_ENCONTRO,\n" +
"    TR.ESTUDIO AS ESTUDIO_TR,\n" +
"    EXT.C1_5B_ID AS ENVIO,\n" +
"    EXT.ID_ENTIDAD\n" +
"FROM TR_PLE_MEDS1_5B EXT\n" +
"INNER JOIN TR_COMISIONES TR\n" +
"    ON TR.ID_ENTIDAD = EXT.ID_ENTIDAD\n" +
"   AND TR.C1_5_ID = EXT.C1_5B_ID\n" +
"   AND TR.P1_5_1 = EXT.P1_5B_3\n" +
"   AND TR.ID_COMISION = EXT.P1_5B_4\n" +
"   AND TR.ESTUDIO = EXT.P1_5B_2\n" +
"WHERE EXT.ID_ENTIDAD = "+ID_entidad+"\n" +
"  AND EXT.C1_5B_ID = "+Envio+"";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                 resul.getString("ID_ENTIDAD"),
                  resul.getString("ID_COMISION_INICIATIVA"),
                  resul.getString("ID_INICIATIVA_EXT")});
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

////Aún hay espacio en la tabla iniciativas para anotar comisiones de estudio. Favor de eliminar los registros de la tabla de extensión y completar los espacios vacíos de comisiones de estudio para el ID de iniciativa que se indica";
public ArrayList ESPACIO_DISPONIBLE(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="WITH TR_COMISIONES AS (\n" +
"    SELECT\n" +
"        ID_ENTIDAD,\n" +
"        C1_5_ID,\n" +
"        P1_5_1,\n" +
"        CAMPO,\n" +
"        VALOR,\n" +
"        CASE\n" +
"            WHEN CAMPO IN (\n" +
"                'P1_5_74', 'P1_5_76', 'P1_5_78',\n" +
"                'P1_5_80', 'P1_5_82'\n" +
"            ) THEN 1\n" +
"            ELSE 2\n" +
"        END AS ESTUDIO\n" +
"    FROM TR_PLE_MEDS1_5\n" +
"    UNPIVOT INCLUDE NULLS (\n" +
"        VALOR FOR CAMPO IN (\n" +
"            P1_5_74 AS 'P1_5_74',\n" +
"            P1_5_76 AS 'P1_5_76',\n" +
"            P1_5_78 AS 'P1_5_78',\n" +
"            P1_5_80 AS 'P1_5_80',\n" +
"            P1_5_82 AS 'P1_5_82',\n" +
"            P1_5_84 AS 'P1_5_84',\n" +
"            P1_5_86 AS 'P1_5_86',\n" +
"            P1_5_88 AS 'P1_5_88',\n" +
"            P1_5_90 AS 'P1_5_90',\n" +
"            P1_5_92 AS 'P1_5_92'\n" +
"        )\n" +
"    )\n" +
")\n" +
"SELECT\n" +
"    EXT.P1_5B_1 AS ID_EXT,\n" +
"    EXT.P1_5B_3 AS ID_INICIATIVA_EXT,\n" +
"    EXT.P1_5B_2 AS ESTUDIO_EXTENSION,\n" +
"    TR.CAMPO AS CAMPO_SIN_CAPTURA,\n" +
"    TR.VALOR,\n" +
"    EXT.C1_5B_ID AS ENVIO,\n" +
"    EXT.ID_ENTIDAD\n" +
"FROM TR_PLE_MEDS1_5B EXT\n" +
"INNER JOIN TR_COMISIONES TR\n" +
"    ON TR.ID_ENTIDAD = EXT.ID_ENTIDAD\n" +
"   AND TR.C1_5_ID = EXT.C1_5B_ID\n" +
"   AND TR.P1_5_1 = EXT.P1_5B_3\n" +
"   AND TR.ESTUDIO = EXT.P1_5B_2\n" +
"WHERE TRIM(TR.VALOR) IS NULL\n" +
"  AND EXT.P1_5B_2 IN (1, 2)\n" +
"  AND EXT.ID_ENTIDAD = "+ID_entidad+"\n" +
"  AND EXT.C1_5B_ID = '"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("ID_EXT"),
                  resul.getString("ID_INICIATIVA_EXT")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


}