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
public class QJuicios_Politicos {
 DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul;

//"Estructura de ID incorrecta, no coincide con la información registrada en los campos de la tabla. Favor de revisar estructura correcta: JP_LEGISLATURA_ENTIDAD_TURNO"
public ArrayList ID_Estructura(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="WITH ESTRUCTURA_ID AS (\n" +
"    SELECT C1_7_ID, TO_ROMAN(legislatura) AS LEGIS_ROMAN,legislatura, ENTIDAD, P1_7_1,\n" +
"        'JP_' || TO_ROMAN(legislatura) || '_' || ENTIDAD || '_' || P1_7_5 AS ID_ESTRUCTURA_Correcta,P1_7_5 AS TURNO\n" +
"    FROM TR_PLE_MEDS1_7)\n" +
"SELECT  C1_7_ID AS ENVIO,legislatura, LEGIS_ROMAN,ENTIDAD,TURNO, ID_ESTRUCTURA_Correcta, P1_7_1 AS ID_actual\n" +
"FROM ESTRUCTURA_ID\n" +
"WHERE P1_7_1 <> ID_ESTRUCTURA_Correcta "
              + "and (ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ENTIDAD"),
                  resul.getString("ID_actual")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoría en P1_7_3-C(cond_presentacion_denuncia_juicio_politico_periodo) debido a P1_7_2-B(cond_presentacion_denuncia_juicio_politico_legislatura_actual) se selecciono "No" (2).
public ArrayList NScond_presentacion_denuncia_juicio_politico_periodo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_2, P1_7_3 from tr_ple_meds1_7 where P1_7_2 = 2 and P1_7_3 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  
//Debe seleccionar una categoría en P1_7_3-C(cond_presentacion_denuncia_juicio_politico_periodo) debido a P1_7_2-B(cond_presentacion_denuncia_juicio_politico_legislatura_actual) se selecciono una categoría diferente de "No" (2)
public ArrayList DScond_presentacion_denuncia_juicio_politico_periodo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_2, P1_7_3 from tr_ple_meds1_7 where P1_7_2 <> 2 and P1_7_3 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    

//Debe seleccionar una categoría en P1_7_4-D(numero_legislatura_presentacion_denuncia_juicio_politico) debido a P1_7_2-B(cond_presentacion_denuncia_juicio_politico_legislatura_actual) se selecciono "No" (2)
public ArrayList DSnumero_legislatura_presentacion_denuncia_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_2, P1_7_4 from tr_ple_meds1_7 where P1_7_2 = 2 and P1_7_4 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe seleccionar una categoría en P1_7_4-D(numero_legislatura_presentacion_denuncia_juicio_politico) debido a P1_7_2-B(cond_presentacion_denuncia_juicio_politico_legislatura_actual) se selecciono una categoría diferente de "No" (2)
public ArrayList NSnumero_legislatura_presentacion_denuncia_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_2, P1_7_4 from tr_ple_meds1_7 where P1_7_2 <> 2 and P1_7_4 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  
//Debe seleccionar una categoría en P1_7_6-F(cond_actualizacion_estatus_denuncia_juicio_politico_periodo) debido a P1_7_2-B(cond_presentacion_denuncia_juicio_politico_legislatura_actual) se selecciono "No" (2) o P1_7_3-C(cond_presentacion_denuncia_juicio_politico_periodo) se selecciono "No" (2)
public ArrayList DScond_actualizacion_estatus_denuncia_juicio_politico_periodo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_2, P1_7_3, P1_7_6 from tr_ple_meds1_7 where (P1_7_2 = 2 or P1_7_3 = 2) and P1_7_6 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoría en P1_7_6-F(cond_actualizacion_estatus_denuncia_juicio_politico_periodo) debido a P1_7_2-B(cond_presentacion_denuncia_juicio_politico_legislatura_actual) o P1_7_3-C(cond_presentacion_denuncia_juicio_politico_periodo) se selecciono una categoría diferente de "No" (2)
public ArrayList NScond_actualizacion_estatus_denuncia_juicio_politico_periodo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_2, P1_7_3, P1_7_6 from tr_ple_meds1_7 where (P1_7_2 <> 2 and P1_7_3 <> 2) and P1_7_6 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoría en P1_7_7-G(estatus_denuncia_juicio_politico) debido a P1_7_6-F(cond_actualizacion_estatus_denuncia_juicio_politico_periodo) se selecciono "No" (2)
public ArrayList NSestatus_denuncia_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_6, P1_7_7 from tr_ple_meds1_7 where P1_7_6 = 2 and P1_7_7 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar únicamente en P1_7_7-G(estatus_denuncia_juicio_politico) las categorías de "En trámite en instancia substanciadora" (3) o "Concluida" (6) debido a P1_7_6-F(cond_actualizacion_estatus_denuncia_juicio_politico_periodo) se selecciono "Sí" (1)
public ArrayList cond_actualizacion_estatus_denuncia_juicio_politico_periodo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_6, P1_7_7\n" +
"from tr_ple_meds1_7\n" +
"where P1_7_6 = 2\n" +
"and (P1_7_7 <> 3 and P1_7_7 <> 6) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe especificar el dato en P1_7_8-H(improcedente_estatus_denuncia_juicio_politico_especifique) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Improcedente (especifique)" (4)
public ArrayList DEimprocedente_estatus_denuncia_juicio_politico_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_8 from tr_ple_meds1_7 where P1_7_7 = 4 and P1_7_8 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe especificar el dato en P1_7_8-H(improcedente_estatus_denuncia_juicio_politico_especifique) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "Improcedente (especifique)" (4)
public ArrayList NDEimprocedente_estatus_denuncia_juicio_politico_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_8 from tr_ple_meds1_7 where P1_7_7 <> 4 and P1_7_8 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe especificar el dato en P1_7_9-I(otro_estatus_denuncia_juicio_politico_especifique) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Otro estatus (especifique)" (7)
public ArrayList DEotro_estatus_denuncia_juicio_politico_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_9 from tr_ple_meds1_7 where P1_7_7 = 7 and P1_7_9 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe especificar el dato en P1_7_9-I(otro_estatus_denuncia_juicio_politico_especifique) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "Otro estatus (especifique)" (7)
public ArrayList NDEotro_estatus_denuncia_juicio_politico_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_9 from tr_ple_meds1_7 where P1_7_7 <> 7 and P1_7_9 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe introducir un dato en P1_7_10-J(fecha_ingreso_denuncia_juicio_politico_oficialia_partes) debido a P1_7_2-B(cond_presentacion_denuncia_juicio_politico_legislatura_actual) se selecciono "No" (2) o P1_7_3-C(cond_presentacion_denuncia_juicio_politico_periodo) se selecciono "No" (2)
public ArrayList NIfecha_ingreso_denuncia_juicio_politico_oficialia_partes(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_2, P1_7_3, P1_7_10 from tr_ple_meds1_7 where (P1_7_2 = 2 or P1_7_3 = 2) and P1_7_10 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe introducir un dato en P1_7_10-J(fecha_ingreso_denuncia_juicio_politico_oficialia_partes) debido a P1_7_2-B(cond_presentacion_denuncia_juicio_politico_legislatura_actual) o P1_7_3-C(cond_presentacion_denuncia_juicio_politico_periodo) se selecciono una categoría diferente de "No" (2)
public ArrayList DIfecha_ingreso_denuncia_juicio_politico_oficialia_partes(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_2, P1_7_3, P1_7_10 from tr_ple_meds1_7 where (P1_7_2 = 1 and P1_7_3 = 1) and P1_7_10 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//La fecha registrada en P1_7_10-J(fecha_ingreso_denuncia_juicio_politico_oficialia_partes) debe ser igual o menor a La fecha registrada en  P1_1_9(fecha_termino_informacion_reportada) de La tabla datos_generales
public ArrayList fecha_ingreso_denuncia_juicio_politico_oficialia_partes(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select jp.ID_ENTIDAD, jp.ENTIDAD,jp.ID_ENTIDAD,jp.LEGISLATURA, jp.C1_7_ID,jp.P1_7_1, jp.P1_7_10, dg.C1_1_ID, dg.P1_1_9\n" +
"from tr_ple_meds1_7 jp\n" +
"inner join tr_ple_meds1_1 dg\n" +
"on jp.ID_ENTIDAD = dg.ID_ENTIDAD\n" +
"and jp.C1_7_ID = dg.C1_1_ID\n" +
"where to_date (jp.P1_7_10, 'dd/mm/yyyy') > to_date (dg.P1_1_9, 'dd/mm/yyyy') and (jp.ID_ENTIDAD="+ID_entidad+" AND jp.Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe introducir un dato en P1_7_11-K(fecha_procedencia_denuncia_juicio_politico) debido a P1_7_3-C(cond_presentacion_denuncia_juicio_politico_periodo) se selecciono "Sí" (1) y en P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono la categoría de "En trámite en instancia substanciadora" (5) o "Concluida" (6)
public ArrayList DIfecha_procedencia_denuncia_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_3, P1_7_7, P1_7_11 from tr_ple_meds1_7 where (P1_7_3 = 2 and P1_7_7 in (5, 6)) and P1_7_11 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe introducir un dato en P1_7_11-K(fecha_procedencia_denuncia_juicio_politico) debido a P1_7_3-C(cond_presentacion_denuncia_juicio_politico_periodo) se selecciono una categoría diferente de "Sí" (1) y en P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "En trámite en instancia substanciadora" (5) o "Concluida" (6)
public ArrayList NIfecha_procedencia_denuncia_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_3, P1_7_7, P1_7_11 from tr_ple_meds1_7 where (P1_7_3 <> 2 and P1_7_7 not in (5, 6)) and P1_7_11 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//La fecha registrada en P1_7_11-K(fecha_procedencia_denuncia_juicio_politico) debe ser igual o mayor a la fecha registrada en P1_7_10-J(fecha_ingreso_denuncia_juicio_politico_oficialia_partes)
public ArrayList fecha_procedencia_denuncia_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_10, P1_7_11\n" +
"from tr_ple_meds1_7\n" +
"where to_date (P1_7_11, 'dd/mm/yyyy') < to_date (P1_7_10, 'dd/mm/yyyy') and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe introducir un dato en P1_7_12-L(fecha_resolucion_pleno_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Concluida" (6)
public ArrayList DIfecha_resolucion_pleno_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_12 from tr_ple_meds1_7 where P1_7_7 = 6 and P1_7_12 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe introducir un dato en P1_7_12-L(fecha_resolucion_pleno_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "Concluida" (6)
public ArrayList NIfecha_resolucion_pleno_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_12 from tr_ple_meds1_7 where P1_7_7 <> 6 and P1_7_12 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//La fecha registrada en P1_7_12-L(fecha_resolucion_pleno_juicio_politico) debe ser igual o mayor a la fecha registrada en  P1_7_11-K(fecha_procedencia_denuncia_juicio_politico)
public ArrayList fecha_resolucion_pleno_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_11, P1_7_12\n" +
"from tr_ple_meds1_7\n" +
"where to_date (P1_7_12, 'dd/mm/yyyy') < to_date (P1_7_11, 'dd/mm/yyyy') and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar un dato en P1_7_13-M(sentido_resolucion_pleno_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Concluida" (6)
public ArrayList DSsentido_resolucion_pleno_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_13 from tr_ple_meds1_7 where P1_7_7 = 6 and P1_7_13 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe seleccionar un dato en P1_7_13-M(sentido_resolucion_pleno_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "Concluida" (6)
public ArrayList NSsentido_resolucion_pleno_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_13 from tr_ple_meds1_7 where P1_7_7 <> 6 and P1_7_13 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe introducir un dato en P1_7_14-N(total_votaciones_pleno_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Concluida" (6)
public ArrayList DItotal_votaciones_pleno_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_14 from tr_ple_meds1_7 where P1_7_7 = 6 and P1_7_14 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe introducir un dato en P1_7_14-N(total_votaciones_pleno_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "Concluida" (6)
public ArrayList NItotal_votaciones_pleno_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_14 from tr_ple_meds1_7 where P1_7_7 <> 6 and P1_7_14 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//El total de P1_7_14-N(total_votaciones_pleno_juicio_politico) debe ser igual o menor a la suma de las cantidades reportadas en "P1_1_5(distritos_uninominales)" y "P1_1_6(diputaciones_plurinominales)" de la tabla datos_generales
public ArrayList total_votaciones_pleno_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select jp.ID_ENTIDAD, jp.ENTIDAD, jp.C1_7_ID, jp.P1_7_1, jp.P1_7_14, dg.P1_1_5, dg.P1_1_6, dg.P1_1_5 + dg.P1_1_6 as total  from tr_ple_meds1_7 jp  inner join tr_ple_meds1_1 dg on jp.ID_ENTIDAD = dg.ID_ENTIDAD and jp.C1_7_ID = dg.C1_1_ID where jp.P1_7_14 > (dg.P1_1_5 + dg.P1_1_6) and (jp.ID_ENTIDAD="+ID_entidad+" AND jp.Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//El total de P1_7_14-N(total_votaciones_pleno_juicio_politico) debe ser igual a la suma de las cantidades reportadas en  P1_7_15-O(votaciones_pleno_a_favor_juicio_politico), P1_7_16-P(votaciones_pleno_en_contra_juicio_politico) y P1_7_17-Q(votaciones_pleno_abstencion_juicio_politico)
public ArrayList votaciones_pleno_a_favor_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_14, P1_7_15, P1_7_16, P1_7_17, P1_7_15 + P1_7_16 + P1_7_17 as total from tr_ple_meds1_7 where P1_7_14 <> (P1_7_15 + P1_7_16 + P1_7_17) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe introducir un dato en P1_7_15-O(votaciones_pleno_a_favor_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Concluida" (6)
public ArrayList DIvotaciones_pleno_a_favor_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_15 from tr_ple_meds1_7 where P1_7_7 = 6 and P1_7_15 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe introducir un dato en P1_7_15-O(votaciones_pleno_a_favor_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "Concluida" (6)
public ArrayList NDIvotaciones_pleno_a_favor_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_15 from tr_ple_meds1_7 where P1_7_7 <> 6 and P1_7_15 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe introducir un dato en P1_7_16-P(votaciones_pleno_en_contra_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Concluida" (6)
public ArrayList DIvotaciones_pleno_en_contra_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_16 from tr_ple_meds1_7 where P1_7_7 = 6 and P1_7_16 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe introducir un dato en P1_7_16-P(votaciones_pleno_en_contra_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "Concluida" (6)
public ArrayList NDIvotaciones_pleno_en_contra_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_16 from tr_ple_meds1_7 where P1_7_7 <> 6 and P1_7_16 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe introducir un dato en P1_7_17-Q(votaciones_pleno_abstencion_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Concluida" (6)
public ArrayList IDvotaciones_pleno_abstencion_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_17 from tr_ple_meds1_7 where P1_7_7 = 6 and P1_7_17 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe introducir un dato en P1_7_18-R(nombre_1_persona_servidora_publica_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Concluida" (6)
public ArrayList IDnombre_1_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_17 from tr_ple_meds1_7 where P1_7_7 = 6 and P1_7_17 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


////No debe introducir un dato en P1_7_18-R(nombre_1_persona_servidora_publica_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "Concluida" (6)
public ArrayList NIDnombre_1_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_18 from tr_ple_meds1_7 where P1_7_7 <> 6 and P1_7_18 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No debe introducir un dato en P1_7_19-S(nombre_2_persona_servidora_publica_juicio_politico) debido a P1_7_18-R(nombre_1_persona_servidora_publica_juicio_politico) no se introdujo un dato
public ArrayList NIDnombre_2_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_18, P1_7_19 from tr_ple_meds1_7 where P1_7_18 is null and P1_7_19 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No debe introducir un dato en P1_7_20-T(nombre_3_persona_servidora_publica_juicio_politico) debido a  P1_7_19-S(nombre_2_persona_servidora_publica_juicio_politico) no se introdujo un dato
public ArrayList NDInombre_3_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_19, P1_7_20 from tr_ple_meds1_7 where P1_7_19 is null and P1_7_20 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe introducir un dato en P1_7_21-U(apellido_1_persona_servidora_publica_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Concluida" (6)
public ArrayList DIapellido_1_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_21 from tr_ple_meds1_7 where P1_7_7 = 6 and P1_7_21 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe introducir un dato en P1_7_21-U(apellido_1_persona_servidora_publica_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "Concluida" (6)
public ArrayList NIapellido_1_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_21 from tr_ple_meds1_7 where P1_7_7 <> 6 and P1_7_21 is NOT null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No debe introducir un dato en P1_7_22-V(apellido_2_persona_servidora_publica_juicio_politico) debido a P1_7_21-U(apellido_1_persona_servidora_publica_juicio_politico) no se introdujo un dato
public ArrayList NDIapellido_2_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_21, P1_7_22 from tr_ple_meds1_7 where P1_7_21 is null and P1_7_22 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No debe introducir un dato en P1_7_23-W(apellido_3_persona_servidora_publica_juicio_politico) debido a P1_7_22-V(apellido_2_persona_servidora_publica_juicio_politico) no se introdujo un dato.
public ArrayList NDIapellido_3_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_22, P1_7_23 from tr_ple_meds1_7 where P1_7_22 is null and P1_7_23 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar una categoría en P1_7_24-X(sexo_persona_servidora_publica_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Concluida" (6)
public ArrayList DIsexo_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_24 from tr_ple_meds1_7 where P1_7_7 = 6 and P1_7_24 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe seleccionar una categoría en P1_7_24-X(sexo_persona_servidora_publica_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "Concluida" (6)
public ArrayList NDIsexo_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_24 from tr_ple_meds1_7 where P1_7_7 <> 6 and P1_7_24 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe seleccionar una categoría en P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Concluida" (6)
public ArrayList DIcargo_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_25 from tr_ple_meds1_7 where P1_7_7= 6 and P1_7_25 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe seleccionar una categoría en P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente de "Concluida" (6)
public ArrayList NDIcargo_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_25 from tr_ple_meds1_7 where P1_7_7 <> 6 and P1_7_25 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar una categoría en P1_7_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_juicio_politico) debido a P1_7_2-B(cond_presentacion_denuncia_juicio_politico_legislatura_actual) se selecciono  "Sí" y en  P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono "Legislador(a) del Congreso de la entidad federativa" (3)
public ArrayList DIcond_pertenencia_legislatura_actual_persona_legisladora_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_25 from tr_ple_meds1_7 where P1_7_7 <> 6 and P1_7_25 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoría en P1_7_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_juicio_politico) debido a P1_7_2-B(cond_presentacion_denuncia_juicio_politico_legislatura_actual) se selecciono una categoría diferente de "Sí" y en  P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono una categoría diferente de "Legislador(a) del Congreso de la entidad federativa" (3)
public ArrayList NDIcond_pertenencia_legislatura_actual_persona_legisladora_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_2, P1_7_25, P1_7_26 from tr_ple_meds1_7 where (P1_7_2 <> 1 and P1_7_25 <> 3) and P1_7_26 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
         
         
//Debe seleccionar una categoría en P1_7_27-AA(ID_persona_legisladora_juicio_politico) debido a P1_7_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_juicio_politico) se selecciono "Sí" (1)
public ArrayList DIID_persona_legisladora_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_26, P1_7_27 from tr_ple_meds1_7 where P1_7_26 = 1 and P1_7_27 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoría en P1_7_27-AA(ID_persona_legisladora_juicio_politico) debido a P1_7_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_juicio_politico) se selecciono una categoría diferente a "Sí" (1)
public ArrayList NDIID_persona_legisladora_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_26, P1_7_27 from tr_ple_meds1_7 where P1_7_26 <> 1 and P1_7_27 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe introducir un dato en P1_7_28-AB(nombre_persona_legisladora_juicio_politico) debido a P1_7_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_juicio_politico) se selecciono "Sí" (1)
public ArrayList DInombre_persona_legisladora_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_26, P1_7_28 from tr_ple_meds1_7 where P1_7_26 = 1 and P1_7_28 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe introducir un dato en P1_7_28-AB(nombre_persona_legisladora_juicio_politico) debido a P1_7_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_juicio_politico) se selecciono una categoría diferente a "Sí" (1)
public ArrayList NDInombre_persona_legisladora_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_26, P1_7_28 from tr_ple_meds1_7 where P1_7_26 <> 1 and P1_7_28 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe introducir un dato en P1_7_29-AC(nombre_institucion_persona_servidora_publica_juicio_politico) debido a  P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono "Titular de alguna institución o unidad administrativa de la Administración Pública Estatal (excluyendo, de ser el caso, a la Procuraduría General de Justicia)" (2), "Titular de algún otro órgano constitucional autónomo de la entidad federativa (excluyendo al organismo público local electoral, al organismo garante de acceso a la información y protección de datos personales, al organismo público de derechos humanos de la entidad federativa, y, de ser el caso, a la Fiscalía General de la entidad federativa)" (10) o "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14)
public ArrayList DInombre_institucion_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_25, P1_7_29 from tr_ple_meds1_7 where P1_7_25 in (2,10,14) and P1_7_29 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe introducir un dato en P1_7_29-AC(nombre_institucion_persona_servidora_publica_juicio_politico) debido a  P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono una categoría diferente a "Titular de alguna institución o unidad administrativa de la Administración Pública Estatal (excluyendo, de ser el caso, a la Procuraduría General de Justicia)" (2), "Titular de algún otro órgano constitucional autónomo de la entidad federativa (excluyendo al organismo público local electoral, al organismo garante de acceso a la información y protección de datos personales, al organismo público de derechos humanos de la entidad federativa, y, de ser el caso, a la Fiscalía General de la entidad federativa)" (10) o "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14)
public ArrayList NDInombre_institucion_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_25, P1_7_29 from tr_ple_meds1_7 where P1_7_25 not in (2,10,14) and P1_7_29 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar una categoría en P1_7_30-AD(AGEM_persona_servidora_publica_juicio_politico) debido a P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono "Presidente(a) municipal" (11), "Regidor(a)" (12), "Síndico(a)" (13), "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14) u "Otro cargo del ámbito municipal (especifique)" (16)
public ArrayList DIAGEM_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_25, P1_7_30 from tr_ple_meds1_7 where P1_7_25 in (11,12,13,14,16) and P1_7_30 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoría en P1_7_30-AD(AGEM_persona_servidora_publica_juicio_politico) debido a P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono una categoría diferente a "Presidente(a) municipal" (11), "Regidor(a)" (12), "Síndico(a)" (13), "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14) u "Otro cargo del ámbito municipal (especifique)" (16)
public ArrayList NDIAGEM_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_25, P1_7_30 from tr_ple_meds1_7 where P1_7_25 not in (11,12,13,14,16) and P1_7_30 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe introducir un dato en P1_7_31-AE(municipio_persona_servidora_publica_juicio_politico) debido a P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono "Presidente(a) municipal" (11), "Regidor(a)" (12), "Síndico(a)" (13), "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14) u "Otro cargo del ámbito municipal (especifique)" (16)
public ArrayList DImunicipio_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_25, P1_7_31 from tr_ple_meds1_7 where P1_7_25 in (11,12,13,14,16) and P1_7_31 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe introducir un dato en P1_7_31-AE(municipio_persona_servidora_publica_juicio_politico) debido a P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono una categoría diferente a "Presidente(a) municipal" (11), "Regidor(a)" (12), "Síndico(a)" (13), "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14) u "Otro cargo del ámbito municipal (especifique)" (16)
public ArrayList NDImunicipio_persona_servidora_publica_juicio_politico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_25, P1_7_31 from tr_ple_meds1_7 where P1_7_25 not in (11,12,13,14,16) and P1_7_31 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe especificar el dato en P1_7_32-AF(otro_cargo_persona_servidora_publica_juicio_politico_ambito_estatal_especifique) debido a  P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono "Otro cargo del ámbito estatal (especifique)" (15).
public ArrayList DIotro_cargo_persona_servidora_publica_juicio_politico_ambito_estatal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_25, P1_7_32 from tr_ple_meds1_7 where P1_7_25 = 15 and P1_7_32 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe especificar el dato en P1_7_32-AF(otro_cargo_persona_servidora_publica_juicio_politico_ambito_estatal_especifique) debido a P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono una categoría diferente a "Otro cargo del ámbito estatal (especifique)" (15)
public ArrayList NDIotro_cargo_persona_servidora_publica_juicio_politico_ambito_estatal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_25, P1_7_32 from tr_ple_meds1_7 where P1_7_25 <> 15 and P1_7_32 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe especificar el dato en P1_7_33-AG(otro_cargo_persona_servidora_publica_juicio_politico_ambito_municipal_especifique) debido a  P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono "Otro cargo del ámbito municipal (especifique)" (15)
public ArrayList DIotro_cargo_persona_servidora_publica_juicio_politico_ambito_municipal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_25, P1_7_33 from tr_ple_meds1_7 where P1_7_25 = 16 and P1_7_33 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe especificar el dato en P1_7_33-AG(otro_cargo_persona_servidora_publica_juicio_politico_ambito_municipal_especifique) debido a P1_7_25-Y(cargo_persona_servidora_publica_juicio_politico) se selecciono una categoría diferente a "Otro cargo del ámbito municipal (especifique)" (15)
public ArrayList otro_cargo_persona_servidora_publica_juicio_politico_ambito_municipal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_25, P1_7_33 from tr_ple_meds1_7 where P1_7_25 <> 16 and P1_7_33 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar una categoría en P1_7_34-AH(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_1) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono "Concluida" (6)
public ArrayList DIperjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_34 from tr_ple_meds1_7 where P1_7_7 = 6 and P1_7_34 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoría en P1_7_34-AH(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_1) debido a P1_7_7-G(estatus_denuncia_juicio_politico) se selecciono una categoría diferente a "Concluida" (6)
public ArrayList NDIperjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_7, P1_7_34 from tr_ple_meds1_7 where P1_7_7 <> 6 and P1_7_34 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No debe seleccionar una categoría en P1_7_35-AI(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_2) debido a P1_7_34-AH(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_1) no se selecciona alguna categoría
public ArrayList NDIperjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_2(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_34, P1_7_35 from tr_ple_meds1_7 where P1_7_34 is null and P1_7_35 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No debe seleccionar una categoría en P1_7_36-AJ(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_3) debido a P1_7_35-AI(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_2) no se selecciona alguna categoría
public ArrayList NDIperjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_3(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_35, P1_7_36 from tr_ple_meds1_7 where P1_7_35 is null and P1_7_36 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe introducir un dato en P1_7_37-AK(otro_perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_especifique) debido a P1_7_34-AH(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_1), P1_7_35-AI(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_2) o P1_7_36-AJ(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_3) se selecciono "Otro perjuicio a los intereses públicos fundamentales y de su buen despacho (especifique)" (9)
public ArrayList DIotro_perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_34, P1_7_35, P1_7_36, P1_7_37 from tr_ple_meds1_7 where (P1_7_34 = 9 or P1_7_35 = 9 or P1_7_36 = 9) and P1_7_37 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe introducir un dato en P1_7_37-AK(otro_perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_especifique) debido a P1_7_34-AH(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_1), P1_7_35-AI(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_2) o P1_7_36-AJ(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_3) se selecciono una categoría diferente de "Otro perjuicio a los intereses públicos fundamentales y de su buen despacho (especifique)" (9)
public ArrayList NDIotro_perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_34, P1_7_35, P1_7_36, P1_7_37 from tr_ple_meds1_7 where (P1_7_34 <> 9 or P1_7_35 <> 9 or P1_7_36 <>9) and P1_7_37 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Lo seleccionado en 34-AH(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_1) no puede repetirlo con P1_7_35-AI(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_2) y P1_7_36-AJ(perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_3)
public ArrayList perjuicio_a_los_intereses_publicos_fundamentales_y_de_su_buen_despacho_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_7_ID, P1_7_1, P1_7_34, P1_7_35, P1_7_36\n" +
"from tr_ple_meds1_7\n" +
"where P1_7_34 = P1_7_35 OR P1_7_34 = P1_7_36 or P1_7_35 = P1_7_36 and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_7_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_7_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


}
