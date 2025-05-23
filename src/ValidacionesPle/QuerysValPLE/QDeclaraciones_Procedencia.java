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
public class QDeclaraciones_Procedencia {
DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul;

//Estructura de ID incorrecta, no coincide con la información registrada en los campos de la tabla. Favor de revisar estructura correcta: DP_LEGISLATURA_ENTIDAD_TURNO"
public ArrayList ID_Estructura(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="WITH ESTRUCTURA_ID AS (\n" +
"    SELECT C1_8_ID, TO_ROMAN(legislatura) AS LEGIS_ROMAN,legislatura, ENTIDAD, P1_8_1,\n" +
"        'DP_' || TO_ROMAN(legislatura) || '_' || ENTIDAD || '_' || P1_8_5 AS ID_ESTRUCTURA_Correcta,P1_8_5 AS TURNO\n" +
"    FROM TR_PLE_MEDS1_8)\n" +
"SELECT  C1_8_ID AS ENVIO,legislatura, LEGIS_ROMAN,ENTIDAD,TURNO, ID_ESTRUCTURA_Correcta, P1_8_1 AS ID_actual\n" +
"FROM ESTRUCTURA_ID WHERE P1_8_1 <> ID_ESTRUCTURA_Correcta and (ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("ID_actual")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe seleccionar una categoria en P1_8_3-C(cond_presentacion_denuncia_declaracion_procedencia_periodo) debido a que en P1_8_2-B(cond_presentacion_denuncia_declaracion_procedencia_legislatura_actual) se selecciono "No" (2)
public ArrayList NScond_presentacion_denuncia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_2, P1_8_3 from tr_ple_meds1_8 where P1_8_2 = 2 and P1_8_3 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe seleccionar una categoria en P1_8_3-C(cond_presentacion_denuncia_declaracion_procedencia_periodo) debido a P1_8_2-B(cond_presentacion_denuncia_declaracion_procedencia_legislatura_actual) se selecciono una categoria diferente de "No" (2)
public ArrayList DScond_presentacion_denuncia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_2, P1_8_3 from tr_ple_meds1_8 where P1_8_2 <> 2 and P1_8_3 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar una categoria en P1_8_4-D(numero_legislatura_presentacion_denuncia_declaracion_procedencia) debido a P1_8_2-B(cond_presentacion_denuncia_declaracion_procedencia_legislatura_actual) se selecciono la categoria "No" (2)
public ArrayList DSnumero_legislatura_presentacion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_2, P1_8_4 from tr_ple_meds1_8 where P1_8_2 = 2 and P1_8_4 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No debe seleccionar una categoria en P1_8_4-D(numero_legislatura_presentacion_denuncia_declaracion_procedencia) debido a P1_8_2-B(cond_presentacion_denuncia_declaracion_procedencia_legislatura_actual) se selecciono una categoria diferente de "No" (2)
public ArrayList NSnumero_legislatura_presentacion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_2, P1_8_4 from tr_ple_meds1_8 where P1_8_2 <> 2 and P1_8_4 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe seleccionar una categoria en P1_8_6-F(cond_actualizacion_estatus_denuncia_declaracion_procedencia_periodo) debido a P1_8_2-B(cond_presentacion_denuncia_declaracion_procedencia_legislatura_actual) o P1_8_3-C(cond_presentacion_denuncia_declaracion_procedencia_periodo) se selecciono la categoria "No" (2)
public ArrayList DScond_presentacion_denuncia_declaracion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_2, P1_8_3, P1_8_6 from tr_ple_meds1_8 where (P1_8_2 = 2 or P1_8_3 = 2) and P1_8_6 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// No debe seleccionar una categoria en P1_8_6-F(cond_actualizacion_estatus_denuncia_declaracion_procedencia_periodo) debido a P1_8_2-B(cond_presentacion_denuncia_declaracion_procedencia_legislatura_actual) o P1_8_3-C(cond_presentacion_denuncia_declaracion_procedencia_periodo) se selecciono la categoria diferente a "No" (2)
public ArrayList NDScond_presentacion_denuncia_declaracion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_2, P1_8_3, P1_8_6 from tr_ple_meds1_8 where (P1_8_2 <> 2 or P1_8_3 <> 2) and P1_8_6 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// No debe seleccionar una categoria en P1_8_7-G(estatus_denuncia_declaracion_procedencia) debido a P1_8_6-F(cond_actualizacion_estatus_denuncia_declaracion_procedencia_periodo) se selecciono la categoria "No" (2)
public ArrayList NSestatus_denuncia_declaracion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_6, P1_8_7 from tr_ple_meds1_8 where P1_8_6 = 2 and P1_8_7 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe seleccionar una categoria en P1_8_7-G(estatus_denuncia_declaracion_procedencia) debido a P1_8_6-F(cond_actualizacion_estatus_denuncia_declaracion_procedencia_periodo) se selecciono la categoria diferente de "No" (2)
public ArrayList DSestatus_denuncia_declaracion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_6, P1_8_7 from tr_ple_meds1_8 where P1_8_6 <> 2 and P1_8_7 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe seleccionar en P1_8_7-G(estatus_denuncia_declaracion_procedencia) la categoria de "En trámite en instancia substanciadora" (3) o "Concluida" (6) debido a P1_8_6-F(cond_actualizacion_estatus_denuncia_declaracion_procedencia_periodo) se selecciono "Sí" (1)
public ArrayList cond_actualizacion_estatus_denuncia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_6, P1_8_7 from tr_ple_meds1_8 where P1_8_6 = 1 and P1_8_7 not in (3, 6) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Debe especificar el dato en P1_8_8-H(improcedente_estatus_denuncia_declaracion_procedencia_especifique) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono la categoria "Improcedente (especifique)" (4)
public ArrayList DSimprocedente_estatus_denuncia_declaracion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_8 from tr_ple_meds1_8 where P1_8_7 = 4 and P1_8_8 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// No debe especificar el dato en P1_8_8-H(improcedente_estatus_denuncia_declaracion_procedencia_especifique) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono una categoria diferente de "Improcedente (especifique)" (4)
public ArrayList NSimprocedente_estatus_denuncia_declaracion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_8 from tr_ple_meds1_8 where P1_8_7 <> 4 and P1_8_8 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe especificar la categoria en P1_8_9-I(otro_estatus_denuncia_declaracion_procedencia_especifique) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono "Otro estatus (especifique)" (7)
public ArrayList DSotro_estatus_denuncia_declaracion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_9 from tr_ple_meds1_8 where P1_8_7 = 7 and P1_8_9 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// No debe especificar la categoria en P1_8_9-I(otro_estatus_denuncia_declaracion_procedencia_especifique) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono una categoria diferente de "Otro estatus (especifique)" (7)
public ArrayList NSotro_estatus_denuncia_declaracion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_9 from tr_ple_meds1_8 where P1_8_7 <> 7 and P1_8_9 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// No dede introducir un dato en P1_8_10-J(fecha_ingreso_denuncia_declaracion_procedencia_oficialia_partes) debido a P1_8_2-B(cond_presentacion_denuncia_declaracion_procedencia_legislatura_actual) o P1_8_3-C(cond_presentacion_denuncia_declaracion_procedencia_periodo) se selecciono "No" (2)
public ArrayList NSfecha_ingreso_denuncia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_2, P1_8_3, P1_8_10 from tr_ple_meds1_8 where (P1_8_2 = 2 and P1_8_3 = 2) and P1_8_10 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe introducir un dato en P1_8_10-J(fecha_ingreso_denuncia_declaracion_procedencia_oficialia_partes) debido a P1_8_2-B(cond_presentacion_denuncia_declaracion_procedencia_legislatura_actual) o P1_8_3-C(cond_presentacion_denuncia_declaracion_procedencia_periodo) se selecciono una categoria diferente de "No" (2)
public ArrayList DSfecha_ingreso_denuncia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_2, P1_8_3, P1_8_10 from tr_ple_meds1_8 where (P1_8_2 <> 2 and P1_8_3 <> 2) and P1_8_10 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// La fecha registrada en P1_8_10-J(fecha_ingreso_denuncia_declaracion_procedencia_oficialia_partes) Debe ser igual o menor a la fecha registrada en P1_1_9(fecha_termino_informacion_reportada) de la tabla datos_generales
public ArrayList fecha_ingreso_denuncia_declaracion_procedencia_oficialia_partes(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select a.ID_ENTIDAD, a.ENTIDAD, a.C1_8_ID,a.P1_8_1, a.P1_8_10, b.C1_1_ID, b.P1_1_9\n" +
"from tr_ple_meds1_8 a\n" +
"inner join tr_ple_meds1_1 b\n" +
"on a.ID_ENTIDAD = b.ID_ENTIDAD\n" +
"and a.C1_8_ID = b.C1_1_ID\n" +
"where to_date (a.P1_8_10, 'dd/mm/yyyy') > to_date (b.P1_1_9, 'dd/mm/yyyy')  and (a.ID_ENTIDAD="+ID_entidad+" AND a.Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Debe introducir un dato en P1_8_11-K(fecha_procedencia_denuncia_declaracion_procedencia) debido a P1_8_3-C(cond_presentacion_denuncia_declaracion_procedencia_periodo) se selecciono la categoria "Sí" (1) y P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono la categoria "En trámite en instancia substanciadora" (5) o "Concluida" (6)
public ArrayList DSfecha_procedencia_denuncia_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_3, P1_8_7, P1_8_11 from tr_ple_meds1_8 where P1_8_3 = 1  and (P1_8_7 = 5 or P1_8_7 = 6) and P1_8_11 is null  and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// No debe introducir un dato en P1_8_11-K(fecha_procedencia_denuncia_declaracion_procedencia) debido a P1_8_3-C(cond_presentacion_denuncia_declaracion_procedencia_periodo) se selecciono una categoria diferente a "Sí" (1) y P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono una categoria diferente a "En trámite en instancia substanciadora" (5) o "Concluida" (6)
public ArrayList NSfecha_procedencia_denuncia_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_3, P1_8_7, P1_8_11 from tr_ple_meds1_8 where P1_8_3 <> 1 and (P1_8_7 <> 5 or P1_8_7 <> 6) and P1_8_11 is not null  and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// La fecha registrada en P1_8_11-K(fecha_procedencia_denuncia_declaracion_procedencia) debe ser igual o mayor a la fecha registrada en P1_8_10-J(fecha_ingreso_denuncia_declaracion_procedencia_oficialia_partes)
public ArrayList fecha_procedencia_denuncia_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_11, P1_8_10 from tr_ple_meds1_8 where to_date (P1_8_11, 'dd/mm/yyyy') < to_date (P1_8_10, 'dd/mm/yyyy') and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe introducir un dato en P1_8_12-L(fecha_resolucion_pleno_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono la categoria "Concluida" (6)
public ArrayList DSfecha_resolucion_pleno(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_12 from tr_ple_meds1_8 where P1_8_7 = 6 and P1_8_12 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// No debe introducir un dato en P1_8_12-L(fecha_resolucion_pleno_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono una categoria diferente a "Concluida" (6)
public ArrayList NSfecha_resolucion_pleno(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_12 from tr_ple_meds1_8 where P1_8_7 <> 6 and P1_8_12 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// La fecha registrada en P1_8_12-L(fecha_resolucion_pleno_declaracion_procedencia) debe ser igual o mayor a la fecha registrada en P1_8_11-K(fecha_procedencia_denuncia_declaracion_procedencia)
public ArrayList fecha_resolucion_pleno_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_12, P1_8_11 from tr_ple_meds1_8 where to_date (P1_8_12, 'dd/mm/yyyy') < to_date (P1_8_11, 'dd/mm/yyyy') and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Debe seleccionar una categoria en P1_8_13-M(sentido_resolucion_pleno_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono la categoria "Concluida" (6)
public ArrayList DSsentido_resolucion_pleno_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_13 from tr_ple_meds1_8 where P1_8_7 = 6 and P1_8_13 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// No debe seleccionar una categoria en P1_8_13-M(sentido_resolucion_pleno_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono una categoria diferente a "Concluida" (6)
public ArrayList NSsentido_resolucion_pleno_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_13 from tr_ple_meds1_8 where P1_8_7 <> 6 and P1_8_13 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Debe introducir un dato en P1_8_14-N(total_votaciones_pleno_declaracion_procedencia), P1_8_15-O(votaciones_pleno_a_favor_declaracion_procedencia), P1_8_16-P(votaciones_pleno_en_contra_declaracion_procedencia) y P1_8_17-Q(votaciones_pleno_abstencion_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono la categoria "Concluida" (6)
public ArrayList DStotal_votaciones_pleno_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_14, P1_8_15, P1_8_16, P1_8_17 from tr_ple_meds1_8 where P1_8_7 = 6 and (P1_8_14 is null and P1_8_15 is null and P1_8_16 is null and P1_8_17 is null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// No debe introducir un dato en P1_8_14-N(total_votaciones_pleno_declaracion_procedencia), P1_8_15-O(votaciones_pleno_a_favor_declaracion_procedencia), P1_8_16-P(votaciones_pleno_en_contra_declaracion_procedencia) y P1_8_17-Q(votaciones_pleno_abstencion_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono una categoria diferente a "Concluida" (6)
public ArrayList NStotal_votaciones_pleno_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_14, P1_8_15, P1_8_16, P1_8_17 from tr_ple_meds1_8 where P1_8_7 <> 6 and (P1_8_14 is not null and P1_8_15 is not null and P1_8_16 is not null and P1_8_17 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe introducir un dato en P1_8_18-R(nombre_1_persona_servidora_publica_declaracion_procedencia), P1_8_19-S(nombre_2_persona_servidora_publica_declaracion_procedencia) y P1_8_20-T(nombre_3_persona_servidora_publica_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono la categoria de "Concluida" (6)
public ArrayList DSnombre_1_persona_servidora_(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_18, P1_8_19, P1_8_20 from tr_ple_meds1_8 where P1_8_7 = 6 and (P1_8_18 is null and P1_8_19 is null and P1_8_20 is null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// No debe introducir un dato en P1_8_18-R(nombre_1_persona_servidora_publica_declaracion_procedencia), P1_8_19-S(nombre_2_persona_servidora_publica_declaracion_procedencia) y P1_8_20-T(nombre_3_persona_servidora_publica_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono una categoria diferente a "Concluida" (6)
public ArrayList NSnombre_1_persona_servidora_(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_18, P1_8_19, P1_8_20 from tr_ple_meds1_8 where P1_8_7 <> 6 and (P1_8_18 is not null and P1_8_19 is not null and P1_8_20 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe introducir un dato en P1_8_21-U(apellido_1_persona_servidora_publica_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono la categoria "Concluida" (6)
public ArrayList BIapellido_1_persona_servidora_publica_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_18, P1_8_19, P1_8_20 from tr_ple_meds1_8 where P1_8_7 <> 6 and (P1_8_18 is not null and P1_8_19 is not null and P1_8_20 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



// No debe introducir un dato en P1_8_21-U(apellido_1_persona_servidora_publica_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono una categoria diferente de "Concluida" (6).
public ArrayList NSapellido_1_persona_servidora_publica_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_18, P1_8_19, P1_8_20 from tr_ple_meds1_8 where P1_8_7 <> 6 and (P1_8_18 is not null and P1_8_19 is not null and P1_8_20 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe introducir un dato en P1_8_22-V(apellido_2_persona_servidora_publica_declaracion_procedencia) debido a P1_8_21-U(apellido_1_persona_servidora_publica_declaracion_procedencia) se introducio un dato
public ArrayList DSapellido_2_persona_servidora_publica_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_21, P1_8_22 from tr_ple_meds1_8 where P1_8_21 is not null and P1_8_22 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// No debe introducir un dato en P1_8_22-V(apellido_2_persona_servidora_publica_declaracion_procedencia) debido a P1_8_21-U(apellido_1_persona_servidora_publica_declaracion_procedencia) no se introducio un dato.
public ArrayList NSapellido_2_persona_servidora_publica_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_21, P1_8_22 from tr_ple_meds1_8 where P1_8_21 is null and P1_8_22 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe introducir un dato en P1_8_23-W(apellido_3_persona_servidora_publica_declaracion_procedencia) debido a P1_8_22-V(apellido_2_persona_servidora_publica_declaracion_procedencia) se introducio un dato
public ArrayList CSapellido_3_persona_servidora_publica_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_22, P1_8_23 from tr_ple_meds1_8 where P1_8_22 is not null and P1_8_23 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// No debe introducir un dato en P1_8_23-W(apellido_3_persona_servidora_publica_declaracion_procedencia) debido a P1_8_22-V(apellido_2_persona_servidora_publica_declaracion_procedencia) no se introducio un dato
public ArrayList NSapellido_3_persona_servidora_publica_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_22, P1_8_23 from tr_ple_meds1_8 where P1_8_22 is null and P1_8_23 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe seleccionar una categoria en P1_8_24-X(sexo_persona_servidora_publica_declaracion_procedencia) y en P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono  "Concluida" (6)
public ArrayList DSsexo_persona_servidora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_24, P1_8_25 from tr_ple_meds1_8 where P1_8_7 = 6 and (P1_8_24 is null and P1_8_25 is null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// No debe seleccionar una categoria en P1_8_24-X(sexo_persona_servidora_publica_declaracion_procedencia) y en P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) debido a P1_8_7-G(estatus_denuncia_declaracion_procedencia) se selecciono una categoria diferente a "Concluida" (6)
public ArrayList NSsexo_persona_servidora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_7, P1_8_24, P1_8_25 from tr_ple_meds1_8 where P1_8_7 <> 6 and (P1_8_24 is not null and P1_8_25 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Debe seleccionar una categoria en P1_8_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_declaracion_procedencia) debido a P1_8_2-B(cond_presentacion_denuncia_declaracion_procedencia_legislatura_actual) se selecciono la categoria "Sí" (1) y P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono "Legislador(a) del Congreso de la entidad federativa" (3)
public ArrayList DScond_pertenencia_legislatura_actual_persona_legisladora_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_2, P1_8_25, P1_8_26 from tr_ple_meds1_8 where (P1_8_2 = 1 and P1_8_25 = 3) and P1_8_26 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// No debe seleccionar una categoria en P1_8_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_declaracion_procedencia) debido a P1_8_2-B(cond_presentacion_denuncia_declaracion_procedencia_legislatura_actual) se selecciono una categoria diferente a "Sí" (1) y P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono diferente a "Legislador(a) del Congreso de la entidad federativa" (3)
public ArrayList NScond_pertenencia_legislatura_actual_persona_legisladora_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_2, P1_8_25, P1_8_26 from tr_ple_meds1_8 where (P1_8_2 <> 1 and P1_8_25 <> 3) and P1_8_26 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe seleccionar un dato en P1_8_27-AA(ID_persona_legisladora_declaracion_procedencia) debido a P1_8_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_declaracion_procedencia) se selecciono la categoria "Sí" (1)
public ArrayList DSID_persona_legisladora_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_26, P1_8_27 from tr_ple_meds1_8 where P1_8_26 = 1 and P1_8_27 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// No debe seleccionar un dato en P1_8_27-AA(ID_persona_legisladora_declaracion_procedencia) debido a P1_8_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_declaracion_procedencia) se selecciono una categoria diferente a "Sí" (1)
public ArrayList NSID_persona_legisladora_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_26, P1_8_27 from tr_ple_meds1_8 where P1_8_26 <> 1 and P1_8_27 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe introducir un dato en P1_8_28-AB(nombre_persona_legisladora_declaracion_procedencia) debido a P1_8_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_declaracion_procedencia) se selecciono la categoria "Sí" (1)
public ArrayList DSnombre_persona_legisladora_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_26, P1_8_28 from tr_ple_meds1_8 where P1_8_26 = 1 and P1_8_28 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// No debe introducir un dato en P1_8_28-AB(nombre_persona_legisladora_declaracion_procedencia) debido a P1_8_26-Z(cond_pertenencia_legislatura_actual_persona_legisladora_declaracion_procedencia) se selecciono una categoria diferente a "Sí" (1)
public ArrayList NSnombre_persona_legisladora_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_26, P1_8_28 from tr_ple_meds1_8 where P1_8_26 <> 1 and P1_8_28 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Debe introducir un dato en P1_8_29-AC(nombre_institucion_persona_servidora_publica_declaracion_procedencia) debido a P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono una categoria "Titular de alguna institución  o unidad administrativa de la Administración Pública Estatal (excluyendo, de ser el caso, a la Procuraduría General de Justicia)" (2), "Titular de algún otro órgano constitucional autónomo de la entidad federativa (excluyendo al organismo público local electoral, al organismo garante de acceso a la información y protección de datos personales, al organismo público de derechos humanos de la entidad federativa, y, de ser el caso, a la Fiscalía General de la entidad federativa)" (10) o "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14)
public ArrayList nombre_institucion_persona_servidora_publica_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_25, P1_8_29 from tr_ple_meds1_8 where P1_8_25 in (2, 10, 14) and P1_8_29 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// No debe introducir un dato en P1_8_29-AC(nombre_institucion_persona_servidora_publica_declaracion_procedencia) debido a P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono una categoria diferente a "Titular de alguna institución  o unidad administrativa de la Administración Pública Estatal (excluyendo, de ser el caso, a la Procuraduría General de Justicia)" (2), "Titular de algún otro órgano constitucional autónomo de la entidad federativa (excluyendo al organismo público local electoral, al organismo garante de acceso a la información y protección de datos personales, al organismo público de derechos humanos de la entidad federativa, y, de ser el caso, a la Fiscalía General de la entidad federativa)" (10) o "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14)
public ArrayList NDnombre_institucion_persona_servidora_publica_declaracion_procedencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_25, P1_8_29 from tr_ple_meds1_8 where P1_8_25 not in (2, 10, 14) and P1_8_29 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Debe seleccionar un dato en P1_8_30-AD(AGEM_persona_servidora_publica_declaracion_procedencia) debido a P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono  "Presidente(a) municipal" (11), "Regidor(a)" (12), "Síndico(a)" (13), "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14) u "Otro cargo del ámbito municipal (especifique)" (16)
public ArrayList DSAGEM_persona_servidora_publica(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_25, P1_8_30 from tr_ple_meds1_8 where P1_8_25 in (11, 12, 13, 14, 16) and P1_8_30 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// No debe seleccionar un  dato en P1_8_30-AD(AGEM_persona_servidora_publica_declaracion_procedencia) debido a P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono una categoria diferente a "Presidente(a) municipal" (11), "Regidor(a)" (12), "Síndico(a)" (13), "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14) u "Otro cargo del ámbito municipal (especifique)" (16)
public ArrayList NSAGEM_persona_servidora_publica(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_25, P1_8_30 from tr_ple_meds1_8 where P1_8_25 not in (11, 12, 13, 14, 16) and P1_8_30 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe introducir un dato en P1_8_31-AE(municipio_persona_servidora_publica_declaracion_procedencia) debido a P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono  "Presidente(a) municipal" (11), "Regidor(a)" (12), "Síndico(a)" (13), "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14) u "Otro cargo del ámbito municipal (especifique)" (16)
public ArrayList NSmunicipio_persona_servidora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_25, P1_8_31 from tr_ple_meds1_8 where P1_8_25 in (11, 12, 13, 14, 16) and P1_8_31 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// No debe introducir un  dato en P1_8_31-AE(municipio_persona_servidora_publica_declaracion_procedencia) debido a P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono una categoria diferente a "Presidente(a) municipal" (11), "Regidor(a)" (12), "Síndico(a)" (13), "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (14) u "Otro cargo del ámbito municipal (especifique)" (16)
public ArrayList NDmunicipio_persona_servidora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_25, P1_8_31 from tr_ple_meds1_8 where P1_8_25 not in (11, 12, 13, 14, 16) and P1_8_31 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe introducir un dato en P1_8_32-AF(otro_cargo_persona_servidora_publica_declaracion_procedencia_ambito_estatal_especifique) debido a P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono la categoria "Otro cargo del ámbito estatal (especifique)" (15)
public ArrayList NDotro_cargo_persona_servidora_publica_declaracion_procedencia_ambito_estatal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_25, P1_8_32 from tr_ple_meds1_8 where P1_8_25 = 15 and P1_8_32 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// No debe introducir un dato en P1_8_32-AF(otro_cargo_persona_servidora_publica_declaracion_procedencia_ambito_estatal_especifique) debido a P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono una categoria diferente a "Otro cargo del ámbito estatal (especifique)" (15)
public ArrayList NCotro_cargo_persona_servidora_publica_declaracion_procedencia_ambito_estatal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_25, P1_8_32 from tr_ple_meds1_8 where P1_8_25 <> 15 and P1_8_32 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// Debe introducir un dato en P1_8_33-AG(otro_cargo_persona_servidora_publica_declaracion_procedencia_ambito_municipal_especifique) debido a P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono la categoria  "Otro cargo del ámbito municipal (especifique)" (16)
public ArrayList NSotro_cargo_persona_servidora_publica_declaracion_procedencia_ambito_municipal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_25, P1_8_33 from tr_ple_meds1_8 where P1_8_25 = 16 and P1_8_33 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// No debe introducir un dato en P1_8_33-AG(otro_cargo_persona_servidora_publica_declaracion_procedencia_ambito_municipal_especifique) debido a P1_8_25-Y(cargo_persona_servidora_publica_declaracion_procedencia) se selecciono una categoria diferente a  "Otro cargo del ámbito municipal (especifique)" (16)
public ArrayList DBotro_cargo_persona_servidora_publica_declaracion_procedencia_ambito_municipal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_8_ID, P1_8_1, P1_8_25, P1_8_33 from tr_ple_meds1_8 where P1_8_25 <> 16 and P1_8_33 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_8_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_8_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

}

