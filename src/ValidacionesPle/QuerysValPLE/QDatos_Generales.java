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
public class QDatos_Generales {
DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul;   
    
//P1_1_1(numero_legislatura) E14 No debe ser null o P1_1_2(nombre_legislatura)K14 o P1_1_3(inicio_funciones_legislatura)F19 o  P1_1_4(termino_funciones_legislatura)L19 o P1_1_5(distritos_uninominales)Y19 o P1_1_6(diputaciones_plurinominales)AD19 o P1_1_7(ejercicio_constitucional_informacion_reportada)M23 o P1_1_8(fecha_inicio_informacion_reportada)V23 o P1_1_9(fecha_termino_informacion_reportada)AC23 No deben ser Null
public ArrayList T1_NOT_NULL(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,P1_1_1 FROM TR_PLE_MEDS1_1 WHERE (P1_1_1 IS NULL OR P1_1_2 IS NULL OR P1_1_3 IS NULL OR P1_1_4 IS NULL\n" +
"OR P1_1_5 IS NULL OR P1_1_6 IS NULL OR P1_1_7 IS NULL OR P1_1_8 IS NULL OR P1_1_9 IS NULL)   AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_1_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
    
  //P1_1_4(termino_funciones_legislatura)L19 no debe ser menor a P1_1_3(inicio_funciones_legislatura)F19
public ArrayList termino_funciones_legislatura(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,P1_1_1 FROM TR_PLE_MEDS1_1 WHERE (to_date(P1_1_4)<to_date(P1_1_3))   AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_1_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  
  

//P1_1_8(fecha_inicio_informacion_reportada)V23 no esta entre P1_1_3(inicio_funciones_legislatura)F19 y P1_1_4(termino_funciones_legislatura)L19
public ArrayList fecha_inicio_informacion_reportada(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,P1_1_8,P1_1_3,P1_1_4 FROM TR_PLE_MEDS1_1 WHERE (to_date(P1_1_8) not between to_date(P1_1_3) and to_date(P1_1_4) )   AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_1_8")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//P1_1_9(fecha_termino_informacion_reportada)AC23 no esta entre P1_1_8(fecha_inicio_informacion_reportada)V23 y P1_1_4(termino_funciones_legislatura)L19
public ArrayList fecha_termino_informacion_reportada(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,P1_1_9,P1_1_3,P1_1_4 FROM TR_PLE_MEDS1_1 WHERE (to_date(P1_1_9) not between to_date(P1_1_8) and to_date(P1_1_4) )   AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_1_9")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  
// El año no corresponde al periodo reportado
public ArrayList anio_periodo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,  P1_1_3 AS INICIO_LEGISLATURA, P1_1_4 AS FIN_LEGISLATURA, P1_1_7 AS ANIO_REPORTADO, P1_1_8 AS INICIO_PERIODO, P1_1_9 AS FIN_PERIODO,\n" +
        "SUBSTR(P1_1_3, INSTR(P1_1_3, '/', -1) + 1) AS ANIO_INICIO_LEGIS, SUBSTR(P1_1_8, INSTR(P1_1_8, '/', -1) + 1) AS ANIO_INICIO_PERIODO\n" +
        "FROM  TR_PLE_MEDS1_1\n" +
        "WHERE (((SUBSTR(P1_1_3, INSTR(P1_1_3, '/', -1) + 1) + P1_1_7 )<> SUBSTR(P1_1_9, INSTR(P1_1_9, '/', -1) + 1))  \n" +
        "AND ((SUBSTR(P1_1_3, INSTR(P1_1_3, '/', -1) + 1) + (P1_1_7-1) )<> SUBSTR(P1_1_8, INSTR(P1_1_8, '/', -1) + 1)) )\n" +
        "AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("ANIO_REPORTADO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}


//Las fechas para este periodo legislativo ya fueron registradas en la base de datos en envío anterior.
public ArrayList fecha_periodo_repetida(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD,  P1_1_7 as año,P1_1_8 as inicio_periodo, P1_1_9 as fin_periodo,LEGISLATURA, C1_1_ID as envio \n" +
        "from  TR_PLE_MEDS1_1 WHERE (ID_ENTIDAD, P1_1_8, P1_1_9) IN (\n" +
        "SELECT ID_ENTIDAD,P1_1_8, P1_1_9 FROM TR_PLE_MEDS1_1 GROUP BY ID_ENTIDAD,  P1_1_8, P1_1_9 HAVING COUNT(*) > 1 )\n" +
          "AND ID_ENTIDAD="+ID_entidad+"  AND Legislatura="+Legislatura+"    ORDER BY  ID_ENTIDAD, P1_1_7, P1_1_8, P1_1_9";
System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("envio"),
                  resul.getString("envio"),
                  resul.getString("ID_ENTIDAD")
                  
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}

//Cuando P1_1A_1(condicion_reporte)=X debe de capturar P1_1A_2(fecha_inicio_p) , P1_1A_3(fecha_termino_p) y P1_1A_4(sesiones_celebradas_p)
public ArrayList condicion_reporteX(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,DECODE(C1_1A,'1','Primer periodo ordinario','2','Primer periodo de receso','3','Segundo periodo ordinario','4','Segundo periodo de receso','5','Tercer periodo ordinario','6','Tercer periodo de receso')C1_1A FROM TR_PLE_MEDS1_1A\n" +
"WHERE  P1_1A_1=1 AND (P1_1A_2 IS NULL OR P1_1A_3 IS NULL OR P1_1A_4 IS NULL)   AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1A_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("C1_1A")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Cuando P1_1A_1(condicion_reporte) es difernte a X debe no debe de capturar P1_1A_2(fecha_inicio_p) , P1_1A_3(fecha_termino_p) y P1_1A_4(sesiones_celebradas_p)
public ArrayList condicion_reporteNI(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,DECODE(C1_1A,'1','Primer periodo ordinario','2','Primer periodo de receso','3','Segundo periodo ordinario','4','Segundo periodo de receso','5','Tercer periodo ordinario','6','Tercer periodo de receso')C1_1A FROM TR_PLE_MEDS1_1A\n" +
"WHERE  P1_1A_1<>1 AND (P1_1A_2 IS NOT NULL OR P1_1A_3 IS NOT NULL OR P1_1A_4 IS NOT NULL)   AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1A_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("C1_1A")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//P1_1A_2(fecha_inicio_p) no esta entre P1_1_8(fecha_inicio_informacion_reportada)V23 y P1_1_9(fecha_termino_informacion_reportada)AC23
public ArrayList fecha_inicio_p(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT S.ID_ENTIDAD,DECODE(S.C1_1A,'1','Primer periodo ordinario','2','Primer periodo de receso','3','Segundo periodo ordinario','4','Segundo periodo de receso','5','Tercer periodo ordinario','6','Tercer periodo de receso')C1_1A FROM TR_PLE_MEDS1_1A S, TR_PLE_MEDS1_1 P\n" +
"WHERE S.C1_1A_ID=P.C1_1_ID AND S.ID_ENTIDAD=P.ID_ENTIDAD AND S.LEGISLATURA=P.LEGISLATURA AND\n" +
" (to_date(P1_1A_2) not between to_date(P1_1_8) and to_date(P1_1_9))   AND S.ID_ENTIDAD="+ID_entidad+" AND S.Legislatura="+Legislatura+" AND S.C1_1A_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("C1_1A")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//P1_1A_3(fecha_termino_p) no esta entre P1_1_8(fecha_inicio_informacion_reportada)V23 y P1_1_9(fecha_termino_informacion_reportada)AC23
public ArrayList fecha_termino_p(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT S.ID_ENTIDAD,DECODE(S.C1_1A,'1','Primer periodo ordinario','2','Primer periodo de receso','3','Segundo periodo ordinario','4','Segundo periodo de receso','5','Tercer periodo ordinario','6','Tercer periodo de receso')C1_1A FROM TR_PLE_MEDS1_1A S, TR_PLE_MEDS1_1 P\n" +
"WHERE S.C1_1A_ID=P.C1_1_ID AND S.ID_ENTIDAD=P.ID_ENTIDAD AND S.LEGISLATURA=P.LEGISLATURA AND\n" +
" (to_date(P1_1A_3) not between to_date(P1_1_8) and to_date(P1_1_9))  AND S.ID_ENTIDAD="+ID_entidad+" AND S.Legislatura="+Legislatura+" AND S.C1_1A_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("C1_1A")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//P1_1B_1(cond_celebracion_periodos_extraordinarios)M33 No debe ser Null
public ArrayList cond_celebracion_periodos_extraordinarios(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,P1_1B_1 FROM TR_PLE_MEDS1_1B\n" +
"WHERE P1_1B_1 IS NULL  AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1B_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_1B_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//P1_1B_2(periodos_extraordinarios_celebrados)AB33 no debe ser null ya que P1_1B_1(cond_celebracion_periodos_extraordinarios)M33=Sí(1)
public ArrayList periodos_extraordinarios_celebrados(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,P1_1B_1 FROM TR_PLE_MEDS1_1B\n" +
"WHERE P1_1B_1 =1 and P1_1B_2 is null  AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1B_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_1B_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No debe de capturar P1_1B_2(periodos_extraordinarios_celebrados)AB33 ya que P1_1B_1(cond_celebracion_periodos_extraordinarios)M33 es diferente a Sí(1)
public ArrayList NCperiodos_extraordinarios_celebrados(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,P1_1B_1 FROM TR_PLE_MEDS1_1B\n" +
"WHERE P1_1B_1 <>1 and P1_1B_2 is not null  AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1B_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_1B_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//La cantidad P1_1B_2(periodos_extraordinarios_celebrados)AB33 no coincide con su desglose periodo_extraordinario_reportado
public ArrayList NDperiodos_extraordinarios_celebrados(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="Select ID_ENTIDAD,P1_1B_2 from(\n" +
"SELECT C.ID_ENTIDAD,C.C1_1C_ID,B.P1_1B_2,COUNT(C.ID_ENTIDAD)Desglose FROM TR_PLE_MEDS1_1B B, TR_PLE_MEDS1_1C C\n" +
"WHERE B.ID_ENTIDAD=C.ID_ENTIDAD AND B.LEGISLATURA=C.LEGISLATURA AND B.C1_1B_ID=C.C1_1C_ID AND ( B.ID_ENTIDAD="+ID_entidad+" AND B.Legislatura="+Legislatura+" AND C1_1C_ID='"+Envio+"')\n" +
"GROUP BY C.ID_ENTIDAD,C.C1_1C_ID,B.P1_1B_2) WHERE P1_1B_2<>Desglose   ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_1B_2")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//P1_1C_1(fecha_inicio_pe),P1_1C_2(fecha_termino_pe) o P1_1C_3(sesiones_celebradas_pe) en periodo_extraordinario_reportado no deben ser NULL
public ArrayList BNotnull(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,DECODE(C1_1C,'1','Primer periodo ordinario','2','Primer periodo de receso','3','Segundo periodo ordinario','4','Segundo periodo de receso','5','Tercer periodo ordinario','6','Tercer periodo de receso')C1_1C\n" +
"FROM TR_PLE_MEDS1_1C\n" +
"WHERE   (P1_1C_1 IS NULL OR P1_1C_2 IS NULL OR P1_1C_3 IS NULL)  AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1C_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("C1_1C")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//P1_1C_1(fecha_inicio_pe) almenos 1 vez debe de estar entre P1_1A_2(fecha_inicio_p) y P1_1A_3(fecha_termino_p)
public ArrayList fecha_inicio_pe(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, P1_1C_1, P1_1A_2, P1_1A_3, C1_1C, C1_1C_ID, NE FROM(\n" +
"SELECT C.ID_ENTIDAD,P1_1C_1,P1_1A_2,P1_1A_3,c.C1_1C,C1_1C_ID,'No se encuentra'NE,C.LEGISLATURA FROM TR_PLE_MEDS1_1C C, TR_PLE_MEDS1_1A A\n" +
"WHERE C.C1_1C_ID=A.C1_1A_ID AND C.LEGISLATURA=A.LEGISLATURA AND C.ID_ENTIDAD=A.ID_ENTIDAD\n" +
"AND (TO_DATE(P1_1C_1) NOT BETWEEN TO_DATE(P1_1A_2) AND TO_DATE(P1_1A_3)) AND (C1_1A IN (2,4,6))\n" +
"union \n" +
"SELECT C.ID_ENTIDAD,P1_1C_1,P1_1A_2,P1_1A_3,c.C1_1C,C1_1A_ID,'Si se encuentra'NE,C.LEGISLATURA FROM TR_PLE_MEDS1_1C C, TR_PLE_MEDS1_1A A\n" +
"WHERE C.C1_1C_ID=A.C1_1A_ID AND C.LEGISLATURA=A.LEGISLATURA AND C.ID_ENTIDAD=A.ID_ENTIDAD\n" +
"AND (TO_DATE(P1_1C_1)  BETWEEN TO_DATE(P1_1A_2) AND TO_DATE(P1_1A_3)) AND (C1_1A IN (2,4,6)))\n" +
"WHERE ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1C_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_1C_1"),
                  resul.getString("P1_1A_2"),
                  resul.getString("P1_1A_3"),
                  resul.getString("C1_1C"),
                  resul.getString("C1_1C_ID"),
                  resul.getString("NE")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//P1_1C_1(fecha_inicio_pe) almenos 1 vez debe de estar entre P1_1A_2(fecha_inicio_p) y P1_1A_3(fecha_termino_p)
public ArrayList fecha_inicio_peTMP(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD_TMP, P1_1C_1, P1_1A_2, P1_1A_3, C1_1C, C1_1C_ID_TMP, NE FROM(\n" +
"SELECT C.ID_ENTIDAD_TMP,P1_1C_1,P1_1A_2,P1_1A_3,c.C1_1C,C1_1C_ID_TMP,'No se encuentra'NE,C.LEGISLATURA_TMP FROM TMP_PLE_MEDS1_1C C, TMP_PLE_MEDS1_1A A\n" +
"WHERE C.C1_1C_ID_TMP=A.C1_1A_ID_TMP AND C.LEGISLATURA_TMP=A.LEGISLATURA_TMP AND C.ID_ENTIDAD_TMP=A.ID_ENTIDAD_TMP\n" +
"AND (TO_DATE(P1_1C_1) NOT BETWEEN TO_DATE(P1_1A_2) AND TO_DATE(P1_1A_3)) AND (C1_1A IN (2,4,6))\n" +
"union \n" +
"SELECT C.ID_ENTIDAD_TMP,P1_1C_1,P1_1A_2,P1_1A_3,c.C1_1C,C1_1A_ID_TMP,'Si se encuentra'NE,C.LEGISLATURA_TMP FROM TMP_PLE_MEDS1_1C C, TMP_PLE_MEDS1_1A A\n" +
"WHERE C.C1_1C_ID_TMP=A.C1_1A_ID_TMP AND C.LEGISLATURA_TMP=A.LEGISLATURA_TMP AND C.ID_ENTIDAD_TMP=A.ID_ENTIDAD_TMP\n" +
"AND (TO_DATE(P1_1C_1)  BETWEEN TO_DATE(P1_1A_2) AND TO_DATE(P1_1A_3)) AND (C1_1A IN (2,4,6)))\n" +
"WHERE ID_ENTIDAD_TMP="+ID_entidad+" AND LEGISLATURA_TMP="+Legislatura+" AND C1_1C_ID_TMP='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD_TMP"),
                  resul.getString("P1_1C_1"),
                  resul.getString("P1_1A_2"),
                  resul.getString("P1_1A_3"),
                  resul.getString("C1_1C"),
                  resul.getString("C1_1C_ID_TMP"),
                  resul.getString("NE")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//P1_1C_2(fecha_termino_pe) al menos 1 vez debe de estar entre P1_1A_2(fecha_inicio_p) y P1_1A_3(fecha_termino_p)
public ArrayList fecha_termino_pe(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT C.ID_ENTIDAD,P1_1C_2,P1_1A_2,P1_1A_3,c.C1_1C,C1_1C_ID,'No se encuentra'NE,C.LEGISLATURA FROM TR_PLE_MEDS1_1C C, TR_PLE_MEDS1_1A A\n" +
"WHERE C.C1_1C_ID=A.C1_1A_ID AND C.LEGISLATURA=A.LEGISLATURA AND C.ID_ENTIDAD=A.ID_ENTIDAD\n" +
"AND (TO_DATE(P1_1C_2) NOT BETWEEN TO_DATE(P1_1A_2) AND TO_DATE(P1_1A_3)) AND (C1_1A IN (2,4,6))\n" +
"union \n" +
"SELECT C.ID_ENTIDAD,P1_1C_2,P1_1A_2,P1_1A_3,c.C1_1C,C1_1A_ID,'Si se encuentra'NE,C.LEGISLATURA FROM TR_PLE_MEDS1_1C C, TR_PLE_MEDS1_1A A\n" +
"WHERE C.C1_1C_ID=A.C1_1A_ID AND C.LEGISLATURA=A.LEGISLATURA AND C.ID_ENTIDAD=A.ID_ENTIDAD\n" +
"AND (TO_DATE(P1_1C_2)  BETWEEN TO_DATE(P1_1A_2) AND TO_DATE(P1_1A_3)) AND (C1_1A IN (2,4,6)))\n" +
"WHERE ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1C_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_1C_2"),
                  resul.getString("P1_1A_2"),
                  resul.getString("P1_1A_3"),
                  resul.getString("C1_1C"),
                  resul.getString("C1_1C_ID"),
                  resul.getString("NE")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//Favor de seleccionar respuesta Si o No, ya que no puede estar vacio
public ArrayList IDNOTNULL(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,DECODE(C1_1D,'1','cond_reconocimiento_iniciativa_preferente','2','cond_reconocimiento_iniciativa_urgente_obvia','3','cond_existencia_juicio_politico','4','cond_existencia_declaracion_procedencia','5','cond_existencia_comparecencia')C1_1D\n" +
",P1_1D_1 \n" +
"FROM TR_PLE_MEDS1_1D\n" +
"WHERE P1_1D_1 IS NULL \n" +
"AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_1D_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("C1_1D")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Cuando  P1_1D_1 (cond_reconocimiento_iniciativa_urgente_obvia)=Sí debe de haber desglose en pestaña iniciativas_urgente_obvia
public ArrayList cond_reconocimiento_iniciativa_urgente_obvia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,C1_1D FROM(\n" +
"SELECT A.ID_ENTIDAD,C1_1D,A.C1_1D_ID\n" +
",P1_1D_1,COUNT(B.ID_ENTIDAD)DESGLOSE\n" +
"FROM TR_PLE_MEDS1_1D A LEFT JOIN TR_PLE_MEDS1_6 B\n" +
"ON A.ID_ENTIDAD=B.ID_ENTIDAD AND A.LEGISLATURA=B.LEGISLATURA AND A.C1_1D_ID=B.C1_6_ID\n" +
"WHERE C1_1D =2 and P1_1D_1=1 and A.ID_ENTIDAD="+ID_entidad+" AND A.Legislatura="+Legislatura+" AND C1_1D_ID='"+Envio+"'\n" +
"GROUP BY A.ID_ENTIDAD,C1_1D,C1_1D_ID,P1_1D_1)WHERE DESGLOSE=0  ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("C1_1D")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//Cuando  P1_1D_1 (cond_existencia_juicio_politico)=Sí debe de haber desglose en pestaña juicios_politicos
public ArrayList cond_existencia_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,C1_1D FROM(\n" +
"SELECT A.ID_ENTIDAD,C1_1D,A.C1_1D_ID\n" +
",P1_1D_1,COUNT(B.ID_ENTIDAD)DESGLOSE\n" +
"FROM TR_PLE_MEDS1_1D A LEFT JOIN TR_PLE_MEDS1_7 B\n" +
"ON A.ID_ENTIDAD=B.ID_ENTIDAD AND A.LEGISLATURA=B.LEGISLATURA AND A.C1_1D_ID=B.C1_7_ID\n" +
"WHERE C1_1D =3 and P1_1D_1=1 and A.ID_ENTIDAD="+ID_entidad+" AND A.Legislatura="+Legislatura+" AND C1_1D_ID='"+Envio+"'\n" +
"GROUP BY A.ID_ENTIDAD,C1_1D,C1_1D_ID,P1_1D_1)WHERE DESGLOSE=0  ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("C1_1D")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Cuando P1_1D_1 (cond_existencia_declaracion_procedencia)=Sí debe de haber desglose en pestaña declaraciones_procedencia
public ArrayList cond_existencia_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT * FROM(\n" +
"SELECT A.ID_ENTIDAD,C1_1D,A.C1_1D_ID\n" +
",P1_1D_1,COUNT(B.ID_ENTIDAD)DESGLOSE\n" +
"FROM TR_PLE_MEDS1_1D A LEFT JOIN TR_PLE_MEDS1_8 B\n" +
"ON A.ID_ENTIDAD=B.ID_ENTIDAD AND A.LEGISLATURA=B.LEGISLATURA AND A.C1_1D_ID=B.C1_8_ID\n" +
"WHERE C1_1D =4 and P1_1D_1=1 and A.ID_ENTIDAD="+ID_entidad+" AND A.Legislatura="+Legislatura+" AND C1_1D_ID='"+Envio+"'\n" +
"GROUP BY A.ID_ENTIDAD,C1_1D,C1_1D_ID,P1_1D_1)WHERE DESGLOSE=0  ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("C1_1D")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Cuando P1_1D_1 (cond_existencia_comparecencia)=Sí debe de haber desglose en pestaña comparecencias
public ArrayList cond_existencia_comparecencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,C1_1D FROM(\n" +
"SELECT A.ID_ENTIDAD,C1_1D,A.C1_1D_ID\n" +
",P1_1D_1,COUNT(B.ID_ENTIDAD)DESGLOSE\n" +
"FROM TR_PLE_MEDS1_1D A LEFT JOIN TR_PLE_MEDS1_9 B\n" +
"ON A.ID_ENTIDAD=B.ID_ENTIDAD AND A.LEGISLATURA=B.LEGISLATURA AND A.C1_1D_ID=B.C1_9_ID\n" +
"WHERE C1_1D =5 and P1_1D_1=1 and A.ID_ENTIDAD="+ID_entidad+" AND A.Legislatura="+Legislatura+" AND C1_1D_ID='"+Envio+"'\n" +
"GROUP BY A.ID_ENTIDAD,C1_1D,C1_1D_ID,P1_1D_1)WHERE DESGLOSE=0  ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("C1_1D")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



}
