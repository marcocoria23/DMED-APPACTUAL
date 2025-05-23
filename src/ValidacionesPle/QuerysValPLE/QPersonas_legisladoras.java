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
public class QPersonas_legisladoras {
 DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul; 
//--------------------NOT NULL---------------------------------------
// Se debe capturar P1_3_1-B(ID_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1 FROM TR_PLE_MEDS1_3 WHERE P1_3_1 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Estructura de ID incorrecta, no coincide con la información registrada en los campos de datos personales del legislador
public ArrayList estructura_ID(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="WITH ESTRUCTURA_id AS (\n" +
"  SELECT ID_ENTIDAD,C1_3_ID AS envio,LEGISLATURA,P1_3_1 AS ID_Actual,REPLACE( TRIM(\n" +
"    (CASE WHEN LENGTH(P1_3_2) >= 2 AND P1_3_3 IS NULL THEN SUBSTR(P1_3_2, 1, 2)\n" +
"      WHEN P1_3_3 IS NOT NULL AND P1_3_4 IS NULL THEN SUBSTR(P1_3_2, 1, 1) || SUBSTR(P1_3_3, 1, 1)\n" +
"      WHEN P1_3_3 IS NOT NULL AND P1_3_4 IS NOT NULL THEN SUBSTR(P1_3_2, 1, 1) || SUBSTR(P1_3_3, 1, 1) ELSE '' END) ||\n" +
"    (CASE WHEN P1_3_6 IS NULL THEN SUBSTR(P1_3_5, 1, 2)\n" +
"       WHEN P1_3_6 IS NOT NULL AND P1_3_7 IS NULL THEN SUBSTR(P1_3_5, 1, 1) || SUBSTR(P1_3_6, 1, 1)\n" +
"       WHEN P1_3_6 IS NOT NULL AND P1_3_7 IS NOT NULL THEN SUBSTR(P1_3_5, 1, 1) || SUBSTR(P1_3_6, 1, 1) ELSE ''  END) || SUBSTR(P1_3_8, -4) ||\n" +
"    (CASE WHEN P1_3_9 = 1 THEN 'H' WHEN P1_3_9 = 2 THEN 'M' WHEN P1_3_9 = 3 THEN 'N' ELSE '' END)), ' ','' ) AS ID_CORRECTO  FROM TR_PLE_MEDS1_3 )\n" +
"SELECT ID_ENTIDAD, envio, LEGISLATURA, ID_Actual, ID_CORRECTO FROM ESTRUCTURA_id \n" +
"WHERE ID_Actual <> ID_CORRECTO\n" +
" AND (ID_ENTIDAD="+ID_entidad+" AND  Legislatura="+Legislatura+" AND  envio='"+Envio+"')";
              
     System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("ID_Actual")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_2-C(nombre_1_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_2(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_2 FROM TR_PLE_MEDS1_3 WHERE P1_3_2 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_5-F(apellido_1_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_5(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_5 FROM TR_PLE_MEDS1_3 WHERE P1_3_5 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_8-I(fecha_nacimiento_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_8(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_8 FROM TR_PLE_MEDS1_3 WHERE P1_3_8 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_9-J(sexo_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_9(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_9 FROM TR_PLE_MEDS1_3 WHERE P1_3_9 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_10-K(estatus_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_10(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_10 FROM TR_PLE_MEDS1_3 WHERE P1_3_10 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_14-O(caracter_cargo_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_14(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_14 FROM TR_PLE_MEDS1_3 WHERE P1_3_14 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_17-R(escolaridad_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_17(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_17 FROM TR_PLE_MEDS1_3 WHERE P1_3_17 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_18-S(estatus_escolaridad_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_18(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_18 FROM TR_PLE_MEDS1_3 WHERE P1_3_18 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_22-W(cond_lengua_ind_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_22(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_22 FROM TR_PLE_MEDS1_3 WHERE P1_3_22 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_26-AA(cond_pueblo_ind_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_26(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_26 FROM TR_PLE_MEDS1_3 WHERE P1_3_26 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_28-AC(cond_discapacidad_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_28(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_28 FROM TR_PLE_MEDS1_3 WHERE P1_3_28 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_32-AG(cond_pob_diversidad_sexual_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_32(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_32 FROM TR_PLE_MEDS1_3 WHERE P1_3_32 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_33-AH(cond_pob_afromexicana_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_33(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_33 FROM TR_PLE_MEDS1_3 WHERE P1_3_33 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_34-AI(forma_eleccion_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_34(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_34 FROM TR_PLE_MEDS1_3 WHERE P1_3_34 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_43-AR(tipo_adscripcion_inicial_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_43(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_43 FROM TR_PLE_MEDS1_3 WHERE P1_3_43 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_46-AU(tipo_adscripcion_final_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_46(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_46 FROM TR_PLE_MEDS1_3 WHERE P1_3_46 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_49-AX(empleo_anterior_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_49(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_49 FROM TR_PLE_MEDS1_3 WHERE P1_3_49 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_50-AY(antigüedad_servicio_publico_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_50(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_50 FROM TR_PLE_MEDS1_3 WHERE P1_3_50 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_51-AZ(antigüedad_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_51(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_51 FROM TR_PLE_MEDS1_3 WHERE P1_3_51 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_52-BA(cond_presentacion_declaracion_situacion_patrimonial) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_52(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_52 FROM TR_PLE_MEDS1_3 WHERE P1_3_52 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_54-BC(cond_presentacion_declaracion_intereses) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_54(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_54 FROM TR_PLE_MEDS1_3 WHERE P1_3_54 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_56-BE(cond_presentacion_declaracion_fiscal ) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_56(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_56 FROM TR_PLE_MEDS1_3 WHERE P1_3_56 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_58-BG(remuneracion_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_58(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_58 FROM TR_PLE_MEDS1_3 WHERE P1_3_58 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_59-BH(asistencia_legislativa_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_59(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_59 FROM TR_PLE_MEDS1_3 WHERE P1_3_59 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_60-BI(gestion_parlamentaria_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_60(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_60 FROM TR_PLE_MEDS1_3 WHERE P1_3_60 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_61-BJ(atencion_ciudadana_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_61(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_61 FROM TR_PLE_MEDS1_3 WHERE P1_3_61 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_62-BK(otro_concepto_gasto_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_62(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_62 FROM TR_PLE_MEDS1_3 WHERE P1_3_62 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_63-BL(cond_casa_atencion_ciudadana) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_63(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_63 FROM TR_PLE_MEDS1_3 WHERE P1_3_63 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_66-BO(cant_iniciativas_presentadas_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_66(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_66 FROM TR_PLE_MEDS1_3 WHERE P1_3_66 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_67-BP(asist_sesiones_plenarias_persona_legisladora) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_67(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_67 FROM TR_PLE_MEDS1_3 WHERE P1_3_67 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_69-BR(cond_integrante_comision_permanente) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_69(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_69 FROM TR_PLE_MEDS1_3 WHERE P1_3_69 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_74-BW(cond_integrante_jucopo) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_74(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_74 FROM TR_PLE_MEDS1_3 WHERE P1_3_74 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_77-BZ(cond_integrante_mesa_directiva) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_77(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_77 FROM TR_PLE_MEDS1_3 WHERE P1_3_77 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_80-CC(ID_comision_legislativa_1) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_80(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_80 FROM TR_PLE_MEDS1_3 WHERE P1_3_80 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_81-CD(nombre_comision_legislativa_1) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_81(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_81 FROM TR_PLE_MEDS1_3 WHERE P1_3_81 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_82-CE(cargo_comision_legislativa_1) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_82(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_82 FROM TR_PLE_MEDS1_3 WHERE P1_3_82 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

// Se debe capturar P1_3_83-CF(cant_reuniones_celebradas_comision_legislativa_1_asistidas) debido a que no puede venir vacío.
public ArrayList PL_NOTNULL_P1_3_83(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, C1_3_ID, LEGISLATURA, P1_3_1, P1_3_83 FROM TR_PLE_MEDS1_3 WHERE P1_3_83 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_3_ID ='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe capturar el campo P1_3_3-D(nombre_2_persona_legisladora) cuando P1_3_2-C(nombre_1_persona_legisladora) viene vacio
public ArrayList nombre_2_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_2,P1_3_3 from TR_PLE_MEDS1_3 where P1_3_1 is null and P1_3_2 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe capturar el campo P1_3_4-E(nombre_3_persona_legisladora) cuando P1_3_3-D(nombre_2_persona_legisladora)  viene vacio
public ArrayList nombre_3_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_4,P1_3_3 from TR_PLE_MEDS1_3 where P1_3_3 is null and P1_3_4 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe capturart el campo P1_3_6-G(apellido_2_persona_legisladora) cuando P1_3_5-F(apellido_1_persona_legisladora) viene vacio
public ArrayList apellido_2_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_4,P1_3_5 from TR_PLE_MEDS1_3 where P1_3_5 is null and P1_3_4 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe capturar el campo P1_3_7-H(apellido_3_persona_legisladora) cuando P1_3_6-G(apellido_2_persona_legisladora) viene vacio
public ArrayList apellido_3_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_6,P1_3_7 from TR_PLE_MEDS1_3 where P1_3_6 is null and P1_3_7 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe capturar P1_3_11-L(otro_estatus_persona_legisladora_especifique) ya que P1_3_10-K(estatus_persona_legisladora) se selecciono la categoría "Otro estatus (especifique)" '4'
public ArrayList DBotro_estatus_persona_legisladora_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_10,P1_3_11 from TR_PLE_MEDS1_3 where P1_3_10=4 and P1_3_11 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
}

//No se debe capturar el campo P1_3_11-L(otro_estatus_persona_legisladora_especifique) debido a que la categoria seleccionada en  la columna P1_3_10-K(estatus_persona_legisladora) es diferente a "Otro estatus (especifique)" '4' 
public ArrayList NDBotro_estatus_persona_legisladora_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_10,P1_3_11 from TR_PLE_MEDS1_3 where P1_3_10<>4 and P1_3_11 is  NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar P1_3_12-M(causa_fallecimiento_persona_legisladora) ya que en el campo P1_3_10-K(estatus_persona_legisladora)  se selecciono la categoria  "Fallecimiento" '2'
public ArrayList DCcausa_fallecimiento_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_10,P1_3_12 from TR_PLE_MEDS1_3 where P1_3_10=2 and P1_3_12 is  null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_3_12-M(causa_fallecimiento_persona_legisladora) debido a que el campo  P1_3_10-K(estatus_persona_legisladora) es diferente de  la categoría "Fallecimiento" '2' 
public ArrayList NDCcausa_fallecimiento_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_10,P1_3_12 from TR_PLE_MEDS1_3 where P1_3_10<>2 and P1_3_12 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar P1_3_13-N(tipo_licencia_persona_legisladora) debido a que P1_3_10-K(estatus_persona_legisladora) se selecciono  la categoría "Con licencia" '3'
public ArrayList DCtipo_licencia_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_10,P1_3_13 from TR_PLE_MEDS1_3 where P1_3_10=3 and P1_3_13 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar P1_3_13-N(tipo_licencia_persona_legisladora) debido a que P1_3_10-K(estatus_persona_legisladora) se selecciono  una categoría  diferente de "Con licencia" '3'
public ArrayList NDCtipo_licencia_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_10,P1_3_13 from TR_PLE_MEDS1_3 where P1_3_10<>3 and P1_3_13 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//Se debe de capturar el campo P1_3_15-P(ID_persona_legisladora_propietaria) o P1_3_16-Q(nombre_persona_legisladora_propietaria) debido a que se selecciono  la categoría "Suplente" '2' en la columna P1_3_14-O(caracter_cargo_persona_legisladora)
public ArrayList DCID_persona_legisladora_propietaria(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_14,P1_3_15,P1_3_16 from TR_PLE_MEDS1_3 where P1_3_14=2 and (P1_3_15 is null or P1_3_16 is null)"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_3_15-P(ID_persona_legisladora_propietaria) o P1_3_16-Q(nombre_persona_legisladora_propietaria)  debido a que se selecciono  una categoría diferente a "Suplente" '2' en la columna P1_3_14-O(caracter_cargo_persona_legisladora)
public ArrayList NDCID_persona_legisladora_propietaria(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_14,P1_3_15,P1_3_16 from TR_PLE_MEDS1_3 where P1_3_14<>2 and (P1_3_15 is NOT null or P1_3_16 is not null)"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//únicamente puede seleccionar la categoría "No aplica"'8' en la columna P1_3_18-S(estatus_escolaridad_persona_legisladora) ya que se selecciono la categoría "Ninguno"'1' en la columna P1_3_17-R(escolaridad_persona_legisladora)
public ArrayList estatus_escolaridad_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_17,P1_3_18 from TR_PLE_MEDS1_3 where P1_3_17=1 and P1_3_18 <>8"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


// únicamente puede seleccionar las categorías "Cursando"'1', "Inconcluso"'2', "Concluido"'3' o "No identificado"'9' en la columna P1_3_18-S(estatus_escolaridad_persona_legisladora) ya que se selecciono alguna de las siguientes  categorías  la categoría "Preescolar o primaria"'2', "Secundaria"'3' o "Preparatoria"'4' en la columna P1_3_17-R(escolaridad_persona_legisladora).
public ArrayList NDCestatus_escolaridad_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_17,P1_3_18 from TR_PLE_MEDS1_3 where P1_3_17 in (2,3,4) and P1_3_18 not in (1,2,3,9)"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//únicamente puede seleccionar la categoría "No identificado" en la columnaP1_3_18-S(estatus_escolaridad_persona_legisladora) debido a que en la columna P1_3_17-R(escolaridad_persona_legisladora) se selecciono la categoría "No identificado" 
public ArrayList NIestatus_escolaridad_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_17,P1_3_18 from TR_PLE_MEDS1_3 where P1_3_17 =99 and P1_3_18<>9"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe capturar el campo P1_3_19-T(carrera_licenciatura_persona_legisladora) debido a que selecciono alguna de las categorias de "Licenciatura"'6', "Maestría"'7' o "Doctorado"'8' en la columna P1_3_17-R(escolaridad_persona_legisladora) .
public ArrayList DCcarrera_licenciatura_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_17,P1_3_19 from TR_PLE_MEDS1_3 where P1_3_17 in (6,7,8) and P1_3_19 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe capturar el campo P1_3_19-T(carrera_licenciatura_persona_legisladora) debido a que no selecciono alguna de las categorias de "Licenciatura"'6', "Maestría"'7' o "Doctorado"'8' en la columna P1_3_17-R(escolaridad_persona_legisladora) .
public ArrayList NDCcarrera_licenciatura_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_17,P1_3_19 from TR_PLE_MEDS1_3 where P1_3_17 NOT in (6,7,8) and P1_3_19 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de capturar el campo P1_3_20-U(carrera_maestria_persona_legisladora) debido a que en la columna P1_3_17-R(escolaridad_persona_legisladora) se selecciono la categoría "Maestría"'7' o "Doctorado"'8'
public ArrayList DCcarrera_maestria_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_17,P1_3_20 from TR_PLE_MEDS1_3 where P1_3_17 in (7,8) and P1_3_20 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_20-U(carrera_maestria_persona_legisladora) debido a que en la columna P1_3_17-R(escolaridad_persona_legisladora) es diferente a las categorias de "Maestría"'7' o "Doctorado"'8'
public ArrayList NDCcarrera_maestria_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_17,P1_3_20 from TR_PLE_MEDS1_3 where P1_3_17 NOT IN (7,8) and P1_3_20 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar el campo P1_3_21-V(carrera_doctorado_persona_legisladora) debido a que selecciono la categoría "Doctorado"'8' en la columna P1_3_17-R(escolaridad_persona_legisladora)
public ArrayList DCcarrera_doctorado_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_17,P1_3_21 from TR_PLE_MEDS1_3 where P1_3_17 =8 and P1_3_21 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_21-V(carrera_doctorado_persona_legisladora) debido a que se selecciono una categoría  diferente de "Doctorado"'8' en la columna P1_3_17-R(escolaridad_persona_legisladora)
public ArrayList NDCcarrera_doctorado_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_17,P1_3_21 from TR_PLE_MEDS1_3 where P1_3_17 <>8 and P1_3_21 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de capturar el campo P1_3_23-X(lengua_ind_1_persona_legisladora) debido a que en la columna P1_3_22-W(cond_lengua_ind_persona_legisladora) se selecciono "Sí"'1'
public ArrayList DClengua_ind_1_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_22,P1_3_23 from TR_PLE_MEDS1_3 where P1_3_22=1 and P1_3_23 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_3_23-X(lengua_ind_1_persona_legisladora) debido a que en la columna P1_3_22-W(cond_lengua_ind_persona_legisladora) es diferente de"Sí"'1'
public ArrayList NDClengua_ind_1_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_22,P1_3_23 from TR_PLE_MEDS1_3 where P1_3_22<>1 and P1_3_23 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_24-Y(lengua_ind_2_persona_legisladora) debido a que el campo P1_3_23-X(lengua_ind_1_persona_legisladora) viene vacio
public ArrayList NDClengua_ind_2_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_23,P1_3_24 from TR_PLE_MEDS1_3 where P1_3_23 is null and P1_3_24 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No puede repetir la lengua indígena seleccionada en la columna P1_3_23-X(lengua_ind_1_persona_legisladora) o P1_3_24-Y(lengua_ind_2_persona_legisladora).
public ArrayList NrClengua_ind_2_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_23,P1_3_24,P1_3_25 from TR_PLE_MEDS1_3 where P1_3_23=P1_3_24  or  P1_3_23=P1_3_25 or P1_3_24=P1_3_25  "
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de capturar el campo P1_3_27-AB(pueblo_ind_persona_legisladora) debido a que en la columna P1_3_26-AA(cond_pueblo_ind_persona_legisladora)  se selecciono la categoría "Sí"
public ArrayList DCpueblo_ind_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_23,P1_3_26,P1_3_27 from TR_PLE_MEDS1_3 where P1_3_26=1  and P1_3_27 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No se debe de capturar el campo P1_3_27-AB(pueblo_ind_persona_legisladora) debido a que en la columna P1_3_26-AA(cond_pueblo_ind_persona_legisladora)  se selecciono una categoria diferente a "Sí"'1'
public ArrayList NDCpueblo_ind_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_23,P1_3_26,P1_3_27 from TR_PLE_MEDS1_3 where P1_3_26<>1  and P1_3_27 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//se debe de capturar P1_3_29-AD(tipo_discapacidad_1_persona_legisladora) debido a que en la columna P1_3_28-AC(cond_discapacidad_persona_legisladora) se selecciono SI '1'
public ArrayList DCcond_discapacidad_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_23,P1_3_28,P1_3_29 from TR_PLE_MEDS1_3 where P1_3_28=1  and P1_3_29 is  null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar P1_3_29-AD(tipo_discapacidad_1_persona_legisladora) debido a que la columna P1_3_28-AC(cond_discapacidad_persona_legisladora)es diferente de SI '1'
public ArrayList NDCcond_discapacidad_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_23,P1_3_28,P1_3_29 from TR_PLE_MEDS1_3 where P1_3_28<>1  and P1_3_29 is  NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No se debe de capturar el campo P1_3_30-AE(tipo_discapacidad_2_persona_legisladora) debido a que el campo P1_3_29-AD(tipo_discapacidad_1_persona_legisladora) viene vacio
public ArrayList NDCtipo_discapacidad_2_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_23,P1_3_29,P1_3_30 from TR_PLE_MEDS1_3 where P1_3_29 is  null  and P1_3_30 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No puede repetir el tipo de discapacidad seleccionado en la columna tipo_discapacidad_persona_legisladora
public ArrayList NRtipo_discapacidad_2_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_29,P1_3_30,P1_3_31 from TR_PLE_MEDS1_3 where P1_3_29=P1_3_30 or P1_3_29=P1_3_31 or P1_3_30=P1_3_31"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No se debe de capturar los campos P1_3_30-AE(tipo_discapacidad_2_persona_legisladora) o P1_3_31-AF(tipo_discapacidad_3_persona_legisladora) si el campo P1_3_29-AD(tipo_discapacidad_1_persona_legisladora) es 'No Identificado' '99'
public ArrayList NDtipo_discapacidad_2_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_29,P1_3_30,P1_3_31 from TR_PLE_MEDS1_3 where P1_3_30=99 and P1_3_31 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar los campos P1_3_31-AF(tipo_discapacidad_3_persona_legisladora) si el campo P1_3_30-AE(tipo_discapacidad_2_persona_legisladora) es 'No Identificado' '99'
public ArrayList tipo_discapacidad_3_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_29,P1_3_30,P1_3_31 from TR_PLE_MEDS1_3 where P1_3_29=99 and (P1_3_30 is not null or  P1_3_31 is not null)"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_30-AE(tipo_discapacidad_2_persona_legisladora) debido a que el campo P1_3_29-AD(tipo_discapacidad_1_persona_legisladora) viene vacio
public ArrayList tipo_discapacidad_2_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_23,P1_3_29,P1_3_30 from TR_PLE_MEDS1_3 where P1_3_29 is  null  and P1_3_30 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//únicamente puede seleccionar la categoría "Sí"'1' en la columna P1_3_32-AG(cond_pob_diversidad_sexual_persona_legisladora) debido a que en la columna P1_3_9-J(sexo_persona_legisladora) se selecciono "No binario"'3' 
public ArrayList cond_pob_diversidad_sexual_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_9,P1_3_32 from TR_PLE_MEDS1_3 where P1_3_9=3 AND P1_3_32<>1"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de captura el campo P1_3_35-AJ(distrito_electoral_mayoria_relativa) debido a que en la columna P1_3_34-AI(forma_eleccion_persona_legisladora) se selecciono "Mayoría relativa"'1'
public ArrayList DCdistrito_electoral_mayoria_relativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_34,P1_3_35 from TR_PLE_MEDS1_3 where P1_3_34=1 and P1_3_35 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_35-AJ(distrito_electoral_mayoria_relativa) debido a que en la columna P1_3_34-AI(forma_eleccion_persona_legisladora) se selecciono diferente a "Mayoría relativa"'1'
public ArrayList NDCdistrito_electoral_mayoria_relativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_34,P1_3_35 from TR_PLE_MEDS1_3 where P1_3_34<>1 and P1_3_35 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//Se debe de capturar el campo P1_3_36-AK(tipo_candidatura_persona_legisladora) debido a que el campo  P1_3_34-AI(forma_eleccion_persona_legisladora) se selecciono "Mayoría relativa"'1'
public ArrayList DCtipo_candidatura_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_34,P1_3_36 from TR_PLE_MEDS1_3 where P1_3_34=1 and P1_3_36 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe de capturar el campo P1_3_36-AK(tipo_candidatura_persona_legisladora) debido a que el campo  P1_3_34-AI(forma_eleccion_persona_legisladora) se selecciono "Mayoría relativa"'1'
public ArrayList NDCtipo_candidatura_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_34,P1_3_36 from TR_PLE_MEDS1_3 where P1_3_34=1 and P1_3_36 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar el campo P1_3_37-AL(partido_politico_candidatura_partido_unico) debido a que en la columna P1_3_36-AK(tipo_candidatura_persona_legisladora)  se selecciono la categoría "Candidatura por partido único"'2'
public ArrayList DCpartido_politico_candidatura_partido_unico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_36, P1_3_37 from TR_PLE_MEDS1_3 where P1_3_36=2 and  P1_3_37 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_37-AL(partido_politico_candidatura_partido_unico) debido a que en la columna P1_3_36-AK(tipo_candidatura_persona_legisladora)  se selecciono una categoria diferente a "Candidatura por partido único"'2'
public ArrayList NDCpartido_politico_candidatura_partido_unico(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_36, P1_3_37 from TR_PLE_MEDS1_3 where P1_3_36<>2 and  P1_3_37 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de capturar el campo P1_3_38-AM(partido_politico_1_candidatura_coalicion) debido a que se selecciono la categoría "Candidatura por coalición"'3' en la columna P1_3_36-AK(tipo_candidatura_persona_legisladora)
public ArrayList DCpartido_politico_1_candidatura_coalicion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_36, P1_3_38 from TR_PLE_MEDS1_3 where P1_3_36=3 and  P1_3_38 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_38-AM(partido_politico_1_candidatura_coalicion) debido a que se selecciono la categoría "Candidatura por coalición"'3' en la columna P1_3_36-AK(tipo_candidatura_persona_legisladora)
public ArrayList NDCpartido_politico_1_candidatura_coalicion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_36, P1_3_38 from TR_PLE_MEDS1_3 where P1_3_36<>3 and  P1_3_38 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_39-AN(partido_politico_2_candidatura_coalicion) debido a que el campo P1_3_38-AM(partido_politico_1_candidatura_coalicion) esta vacio
public ArrayList partido_politico_2_candidatura_coalicion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_38, P1_3_39 from TR_PLE_MEDS1_3 where P1_3_38 is null and  P1_3_39 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_3_40-AO(partido_politico_3_candidatura_coalicion) debido a que el campo P1_3_39-AN(partido_politico_2_candidatura_coalicion) esta vacio
public ArrayList partido_politico_3_candidatura_coalicion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_39, P1_3_40 from TR_PLE_MEDS1_3 where P1_3_39 is null and  P1_3_40 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_41-AP(partido_politico_4_candidatura_coalicion) debido a que el campo P1_3_40-AO(partido_politico_3_candidatura_coalicion) esta vacio
public ArrayList partido_politico_4_candidatura_coalicion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_40, P1_3_41 from TR_PLE_MEDS1_3 where P1_3_40 is null and  P1_3_41 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campoP1_3_42-AQ(partido_politico_5_candidatura_coalicion) debido a que el campo P1_3_41-AP(partido_politico_4_candidatura_coalicion) esta vacio
public ArrayList partido_politico_5_candidatura_coalicion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_41, P1_3_42 from TR_PLE_MEDS1_3 where P1_3_41 is null and  P1_3_42 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No puede repetir el partido político en algunas de las columnas partido_politico_candidatura_coalicion
public ArrayList REPpartido_politico_5_candidatura_coalicion(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="  SELECT id_entidad, entidad,c1_3_id, p1_3_1,p1_3_38, p1_3_39, p1_3_40, p1_3_41, p1_3_42 FROM     tr_ple_meds1_3 WHERE     p1_3_38 = p1_3_39     OR  p1_3_38 = p1_3_40     OR  p1_3_38 = p1_3_41     OR  p1_3_38 = p1_3_42     OR  p1_3_39 = p1_3_40     OR  p1_3_39 = p1_3_41     OR  p1_3_39 = p1_3_42     OR  p1_3_40 = p1_3_41     OR  p1_3_40 = p1_3_42     OR  p1_3_41 = p1_3_42"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//únicamente puede seleccionar la categoría "Grupo parlamentario"'1', "Legislador sin grupo parlamentario"'3' o "No identificado"'9'  si se a  seleccionado la categoría "Candidatura por partido único"'2' o "Candidatura por coalición"'3' en la columna P1_3_36-AK(tipo_candidatura_persona_legisladora)
public ArrayList parlamentario(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_36, P1_3_43 from TR_PLE_MEDS1_3 where P1_3_36 in (2,3) and  P1_3_43 not in (1,3,9)"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de capturar P1_3_44-AS(grupo_parlamentario_adscipcion_inicial_persona_legisladora) debido a que en la columna  P1_3_43-AR(tipo_adscripcion_inicial_persona_legisladora) se selecciono  "Grupo parlamentario"'1'.
public ArrayList DCgrupo_parlamentario_adscipcion_inicial_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_43, P1_3_44 from TR_PLE_MEDS1_3 where P1_3_43=1 and  P1_3_44 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar P1_3_44-AS(grupo_parlamentario_adscipcion_inicial_persona_legisladora) debido a que en la columna  P1_3_43-AR(tipo_adscripcion_inicial_persona_legisladora) se selecciono diferente a   "Grupo parlamentario"'1'.
public ArrayList NDCgrupo_parlamentario_adscipcion_inicial_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_43, P1_3_44 from TR_PLE_MEDS1_3 where P1_3_43<>1 and  P1_3_44 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de capturar P1_3_45-AT(otro_grupo_parlamentario_adscipcion_inicial_persona_legisladora_especifique) debido a que se selecciono la categoría "Otro grupo parlamentario (especifique)" en la columna P1_3_44-AS(grupo_parlamentario_adscipcion_inicial_persona_legisladora) . 
public ArrayList DCotro_grupo_parlamentario_adscipcion_inicial_persona_legisladora_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_44, P1_3_45 from TR_PLE_MEDS1_3 where P1_3_44 =ID_ENTIDAD||99 and  P1_3_45 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//únicamente puede seleccionar la categoría "Grupo parlamentario"'1', "Legislador sin grupo parlamentario"'3' o "No identificado"'9' En caso de que haya seleccionado la categoría "Candidatura por partido único"'2' o "Candidatura por coalición"'3' en la columna P1_3_36-AK(tipo_candidatura_persona_legisladora).
public ArrayList tipo_candidatura_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_36, P1_3_46 from TR_PLE_MEDS1_3 where P1_3_36 in(2,3) and  P1_3_46 not in (1,3,9)"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe capturar el campo P1_3_47-AV(grupo_parlamentario_adscipcion_final_persona_legisladora) debido a que en la columna P1_3_46-AU(tipo_adscripcion_final_persona_legisladora) se selecciono la categoría "Grupo parlamentario"'1'
public ArrayList grupo_parlamentario_adscipcion_final_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_46, P1_3_47 from TR_PLE_MEDS1_3 where P1_3_46=1 and  P1_3_47 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe capturar el campo P1_3_47-AV(grupo_parlamentario_adscipcion_final_persona_legisladora) debido a que en la columna P1_3_46-AU(tipo_adscripcion_final_persona_legisladora) se selecciono una categoría diferente a "Grupo parlamentario"'3'
public ArrayList NCgrupo_parlamentario_adscipcion_final_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_46, P1_3_47 from TR_PLE_MEDS1_3 where P1_3_46<>1 and  P1_3_47 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar el campo P1_3_48-AW(otro_grupo_parlamentario_adscipcion_final_persona_legisladora_especifique) debido a que en la columna  P1_3_47-AV(grupo_parlamentario_adscipcion_final_persona_legisladora)  se selecciono la categoría "Otro grupo parlamentario (especifique)"
public ArrayList otro_grupo_parlamentario_adscipcion_final_persona_legisladora_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_47, P1_3_48 from TR_PLE_MEDS1_3 where P1_3_47=ID_ENTIDAD||99 and  P1_3_48 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_3_48-AW(otro_grupo_parlamentario_adscipcion_final_persona_legisladora_especifique) debido a que en la columna  P1_3_47-AV(grupo_parlamentario_adscipcion_final_persona_legisladora)  se selecciono una categoría diferente a  "Otro grupo parlamentario (especifique)"
public ArrayList NCotro_grupo_parlamentario_adscipcion_final_persona_legisladora_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_47, P1_3_48 from TR_PLE_MEDS1_3 where P1_3_47<>ID_ENTIDAD||99 and  P1_3_48 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//no puede seleccionar la categoría "0" en la columna P1_3_50-AY(antigüedad_servicio_publico_persona_legisladora) cuando se haya seleccionado la categoría "Legislador federal"'1', "Legislador estatal (reelección)"'2', "Legislador estatal (de otra entidad federativa)"'3', "Gobierno federal"'4', "Gobierno estatal"'5', "Gobierno municipal"'6' o "Sindico(a) / regidor(a)"'7' en la columna P1_3_49-AX(empleo_anterior_persona_legisladora)
public ArrayList antigüedad_servicio_publico_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_49, P1_3_50 from TR_PLE_MEDS1_3 where P1_3_49 in (1,2,3,4,5,6,7) and  P1_3_50=1"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//P1_3_51-AZ(antigüedad_persona_legisladora) Debe ser igual o menor a la cantidad reportada en la columna P1_3_50-AY(antigüedad_servicio_publico_persona_legisladora).
public ArrayList antigüedad_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_50, P1_3_51 from TR_PLE_MEDS1_3 where P1_3_51>  P1_3_50"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe especificar el motivo por el cual no le es aplicable a la persona legisladora la presentación de la declaración de situación patrimonial ya que en la columna a P1_3_52-BA(cond_presentacion_declaracion_situacion_patrimonial) se selecciono la categoría "No aplica (especifique)"'3' 
public ArrayList cond_presentacion_declaracion_situacion_patrimonial(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_52, P1_3_53 from TR_PLE_MEDS1_3 where P1_3_52=3 and  P1_3_53 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_53-BB(no_aplica_presentacion_declaracion_situacion_patrimonial_especifique) debido a que la columna P1_3_52-BA(cond_presentacion_declaracion_situacion_patrimonial) se selecciono una categoría diferente a "No aplica (especifique)"'3' 
public ArrayList NCcond_presentacion_declaracion_situacion_patrimonial(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_52, P1_3_53 from TR_PLE_MEDS1_3 where P1_3_52<>3 and  P1_3_53 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe especificar P1_3_55-BD(no_aplica_presentacion_declaracion_intereses_especifique) el motivo por el cual no le es aplicable a la persona legisladora la presentación de la declaración de intereses. Debido a que en la columna  P1_3_54-BC(cond_presentacion_declaracion_intereses) selecciono  la categoría "No aplica (especifique)"'3' 
public ArrayList no_aplica_presentacion_declaracion_intereses_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_54, P1_3_55 from TR_PLE_MEDS1_3 where P1_3_54=3 and  P1_3_55 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_55-BD(no_aplica_presentacion_declaracion_intereses_especifique)  Debido a que en la columna  P1_3_54-BC(cond_presentacion_declaracion_intereses) no se selecciono  la categoría "No aplica (especifique)"'3'
public ArrayList NCno_aplica_presentacion_declaracion_intereses_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_54, P1_3_55 from TR_PLE_MEDS1_3 where P1_3_54<>3 and  P1_3_55 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe especificar P1_3_57-BF(no_aplica_presentacion_declaracion_fiscal_especifique)  el motivo por el cual no le es aplicable a la persona legisladora la presentación de la declaración fiscal debido a que se selecciono No aplica (especifique)"'3' en la columna P1_3_56-BE(cond_presentacion_declaracion_fiscal )
public ArrayList no_aplica_presentacion_declaracion_fiscal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_56, P1_3_57 from TR_PLE_MEDS1_3 where P1_3_56=3 and  P1_3_57 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe capturar P1_3_57-BF(no_aplica_presentacion_declaracion_fiscal_especifique)  el motivo por el cual no le es aplicable a la persona legisladora la presentación de la declaración fiscal debido a que no se selecciono No aplica (especifique)"'3' en la columna P1_3_56-BE(cond_presentacion_declaracion_fiscal )
public ArrayList NCno_aplica_presentacion_declaracion_fiscal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_56, P1_3_57 from TR_PLE_MEDS1_3 where P1_3_56<>3 and  P1_3_57 is  NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de capturar el campo P1_3_64-BM(latitud_casa_atencion_ciudadana) debido a que  en la columna P1_3_63-BL(cond_casa_atencion_ciudadana)  se selecciono la opcion "Sí"'1' 
public ArrayList latitud_casa_atencion_ciudadana(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_63, P1_3_64 from TR_PLE_MEDS1_3 where P1_3_63=1 and  P1_3_64 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_3_64-BM(latitud_casa_atencion_ciudadana) debido a que  en la columna P1_3_63-BL(cond_casa_atencion_ciudadana)  se selecciono una opcion diferente de "Sí"'1' 
public ArrayList NClatitud_casa_atencion_ciudadana(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_63, P1_3_64 from TR_PLE_MEDS1_3 where P1_3_63<>1 and  P1_3_64 is  not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//El campo P1_3_64-BM(latitud_casa_atencion_ciudadana) Debe contener nueve caracteres contando el punto.
public ArrayList Clatitud_casa_atencion_ciudadana(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_63, P1_3_64,LENGTH( P1_3_64) as legh,\n" +
"REGEXP_SUBSTR(\n" +
"P1_3_64,'[^.]+', 1, 1)AS primera_parte,        \n" +
"REGEXP_SUBSTR(P1_3_64,'[^.]+', 1, 2)AS segunda_parte\n" +
"FROM TR_PLE_MEDS1_3 where (LENGTH( P1_3_64)<9 or LENGTH( P1_3_64)>9)"
              + " AND (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




//Se debe de capturar el campo P1_3_65-BN(longitud_casa_atencion_ciudadana) debido a que  en la columna P1_3_63-BL(cond_casa_atencion_ciudadana)  se selecciono la opcion "Sí"'1' 
public ArrayList longitud_casa_atencion_ciudadana(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_63, P1_3_65 from TR_PLE_MEDS1_3 where P1_3_63=1 and  P1_3_65 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_65-BN(longitud_casa_atencion_ciudadana) debido a que  en la columna P1_3_63-BL(cond_casa_atencion_ciudadana)  no se selecciono la opcion "Sí"'1' 
public ArrayList NClongitud_calongitud_casa_atencion_ciudadanasa_atencion_ciudadana(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_63, P1_3_65 from TR_PLE_MEDS1_3 where P1_3_63<>1 and  P1_3_65 is not null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//El campo P1_3_65-BN(longitud_casa_atencion_ciudadana) Debe contener entre diez y once caracteres.
public ArrayList Clongitud_casa_atencion_ciudadana(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1, P1_3_63, P1_3_65, LEGH, PRIMERA_PARTE, SEGUNDA_PARTE, LENGTH(segunda_parte),Legislatura from (\n" +
"SELECT  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_63, P1_3_65,LENGTH( P1_3_65) as legh,\n" +
"REGEXP_SUBSTR(\n" +
"P1_3_65,'[^.]+', 1, 1)AS primera_parte,        \n" +
"REGEXP_SUBSTR(P1_3_65,'[^.]+', 1, 2)AS segunda_parte\n,Legislatura " +
"FROM TR_PLE_MEDS1_3 where LENGTH( P1_3_65)<10 or LENGTH( P1_3_65)>11 )  where  (LENGTH(segunda_parte)<7 or  LENGTH(segunda_parte)>7)"
              + " and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//La columna P1_3_67-BP(asist_sesiones_plenarias_persona_legisladora) Debe ser igual o menor a la suma de las cantidades registradas en la columna P1_1A_4(sesiones_celebradas_p) de los periodos ordinarios reportados y en la columna P1_1C_3(sesiones_celebradas _pe), ambas de la tabla datos_generales.
public ArrayList asist_sesiones_plenarias_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  t.ID_ENTIDAD, t.ENTIDAD, t.C1_3_ID, t.P1_3_1,t.P1_3_67,x.C1_1A_ID, x.T_GENERAL from TR_PLE_MEDS1_3 t \n" +
"left join (SELECT ID_ENTIDAD, ENTIDAD, C1_1A_ID, TOTAL_A, TOTAL_C,TOTAL_A+TOTAL_C as t_general FROM(\n" +
"select a.ID_ENTIDAD, a.ENTIDAD,a.C1_1A_ID, \n" +
"CASE WHEN sum (a.P1_1A_4) IS NULL THEN 0 ELSE sum (a.P1_1A_4) END as total_a, \n" +
"CASE WHEN sum(c.P1_1C_3) IS NULL THEN 0 ELSE sum(c.P1_1C_3) END as total_c\n" +
"from TR_PLE_MEDS1_1A a\n" +
"left join TR_PLE_MEDS1_1C c on c.ID_ENTIDAD=a.ID_ENTIDAD and a.C1_1A_ID=c.C1_1C_ID\n" +
"where a.entidad=4 and a.c1_1a_id=3 \n" +
"group by a.ID_ENTIDAD, a.ENTIDAD,a.C1_1A_ID)\n" +
") x on x.id_entidad=t.id_entidad and x.ENTIDAD=t.ENTIDAD and t.C1_3_ID=x.C1_1A_ID\n" +
"where t.ID_ENTIDAD=4 and t.C1_3_ID=3  and t.P1_3_67>x.T_GENERAL "
              + " and t.ID_ENTIDAD="+ID_entidad+" AND t.Legislatura="+Legislatura+" AND t.C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//Se debe de capturar la columna P1_3_68-BQ(cant_intervenciones_sesiones plenarias_persona_legisladora) debido a que se registro un número mayor a cero en la columna P1_3_67-BP(asist_sesiones_plenarias_persona_legisladora) .
public ArrayList DCcant_intervenciones_sesiones(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_67, P1_3_68 from TR_PLE_MEDS1_3 where P1_3_67>0 and  P1_3_68 is null "
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar la columna P1_3_68-BQ(cant_intervenciones_sesiones plenarias_persona_legisladora) debido a que no se registro un número mayor a cero en la columna P1_3_67-BP(asist_sesiones_plenarias_persona_legisladora) .
public ArrayList NCcant_intervenciones_sesiones(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_67, P1_3_68 from TR_PLE_MEDS1_3 where P1_3_67 IS NULL and  P1_3_68 is NOT null "
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de registrar una cantidad mayor a 0 en el campo P1_3_68-BQ(cant_intervenciones_sesiones plenarias_persona_legisladora)
public ArrayList cant_intervenciones_sesiones(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_67, P1_3_68 from TR_PLE_MEDS1_3 where P1_3_68=0"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de capturar el campo P1_3_70-BS(cargo_comision_permanente) debido a que  en la columna P1_3_69-BR(cond_integrante_comision_permanente) se selecciono la opcion 'SI''1'
public ArrayList cargo_comision_permanente(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_69, P1_3_70 from TR_PLE_MEDS1_3 where P1_3_69=1 and  P1_3_70 is null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_70-BS(cargo_comision_permanente) debido a que  en la columna P1_3_69-BR(cond_integrante_comision_permanente) se selecciono la opcion 'SI''1'
public ArrayList NDCcargo_comision_permanente(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_69, P1_3_70 from TR_PLE_MEDS1_3 where P1_3_69<>1 and  P1_3_70 is NOT null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe especificar el P1_3_71-BT(otro_cargo_comision_permanente_especifique) por la persona legisladora en la Comisión Permanente debido a que en la columna P1_3_70-BS(cargo_comision_permanente)  se selecciono  "Otro cargo (especifique)"'6' 
public ArrayList otro_cargo_comision_permanente_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_70, P1_3_71 from TR_PLE_MEDS1_3 where P1_3_70=6 and  P1_3_71 is null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe especificar el P1_3_71-BT(otro_cargo_comision_permanente_especifique) por la persona legisladora en la Comisión Permanente debido a que en la columna P1_3_70-BS(cargo_comision_permanente)  se selecciono una opcion diferente de  "Otro cargo (especifique)"'6'
public ArrayList NDCotro_cargo_comision_permanente_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_70, P1_3_71 from TR_PLE_MEDS1_3 where P1_3_70<>6 and  P1_3_71 is NOT null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar la columna P1_3_72-BU(asist_sesiones_comision_permanente_persona_legisladora) debido a que se seleccciono la "Sí"'1' en la columna P1_3_69-BR(cond_integrante_comision_permanente) .
public ArrayList asist_sesiones_comision_permanente_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_69, P1_3_72 from TR_PLE_MEDS1_3 where P1_3_69=1 and  P1_3_72 is null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar la columna P1_3_72-BU(asist_sesiones_comision_permanente_persona_legisladora) debido a que se seleccciono una opcion deiferente de "Sí"'1' en la columna P1_3_69-BR(cond_integrante_comision_permanente) .
public ArrayList NDCasist_sesiones_comision_permanente_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_69, P1_3_72 from TR_PLE_MEDS1_3 where P1_3_69<>1 and  P1_3_72 is NOT null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//P1_3_72-BU(asist_sesiones_comision_permanente_persona_legisladora) Debe ser igual o menor a la suma de las cantidades registradas en la columna P1_1A_4(sesiones_celebradas_p) de los periodos de receso reportados en la tabla datos_generales.
public ArrayList DCasist_sesiones_comision_permanente_persona_legisladora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  t.ID_ENTIDAD, t.ENTIDAD, t.C1_3_ID, t.P1_3_1, t.P1_3_72, g.total from TR_PLE_MEDS1_3 t\n" +
"left join (select ID_ENTIDAD, ENTIDAD, sum(P1_1A_4) as total,c1_1a_id as envio  from TR_PLE_MEDS1_1A \n" +
"where C1_1A in (2,4,6) and id_entidad=28 and c1_1a_id=1 \n" +
"group by ID_ENTIDAD, ENTIDAD,c1_1a_id) g on g.id_entidad=t.id_entidad and g.envio=t.C1_3_ID\n" +
"where t.id_entidad=28 and t.C1_3_ID=1 and P1_3_72>TOTAL "
              + " and t.ID_ENTIDAD="+ID_entidad+" AND t.Legislatura="+Legislatura+" AND t.C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar el campo P1_3_73-BV(cant_interv_sesiones_dip_permanente_persona_legisldora) debido a que la  P1_3_72-BU(asist_sesiones_comision_permanente_persona_legisladora)  se registro un número mayor a cero 
public ArrayList cant_interv_sesiones_dip_permanente_persona_legisldora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_72, P1_3_73 from TR_PLE_MEDS1_3 where P1_3_72>0 and  P1_3_73 is null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_3_73-BV(cant_interv_sesiones_dip_permanente_persona_legisldora) debido a que la  P1_3_72-BU(asist_sesiones_comision_permanente_persona_legisladora)  se registro un dato
public ArrayList NCcant_interv_sesiones_dip_permanente_persona_legisldora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_72, P1_3_73 from TR_PLE_MEDS1_3 where P1_3_72 IS NULL and  P1_3_73 is NOT  null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de capturar el campo P1_3_75-BX(cargo_jucopo) debido a que en la columna P1_3_74-BW(cond_integrante_jucopo) se selecciono SI'1'
public ArrayList cargo_jucopo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_74, P1_3_75 from TR_PLE_MEDS1_3 where P1_3_74=1 and  P1_3_75 is null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_3_75-BX(cargo_jucopo) debido a que en la columna P1_3_74-BW(cond_integrante_jucopo) no se selecciono SI'1'
public ArrayList NCcargo_jucopo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_74, P1_3_75 from TR_PLE_MEDS1_3 where P1_3_74<>1 and  P1_3_75 is NOT null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




//Debe especificar P1_3_76-BY(otro_cargo_jucopo_especifique) el otro cargo desempeñado por la persona legisladora en la Junta de Coordinación Política debido a que en la columna P1_3_75-BX(cargo_jucopo)  se selecciono "Otro cargo (especifique)"'6' .
public ArrayList otro_cargo_jucopo_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_75, P1_3_76 from TR_PLE_MEDS1_3 where P1_3_75=6 and  P1_3_76 is null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe especificar P1_3_76-BY(otro_cargo_jucopo_especifique) el otro cargo desempeñado por la persona legisladora en la Junta de Coordinación Política debido a que en la columna P1_3_75-BX(cargo_jucopo)  no se selecciono "Otro cargo (especifique)"'6' .
public ArrayList NCotro_cargo_jucopo_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_75, P1_3_76 from TR_PLE_MEDS1_3 where P1_3_75<>6 and  P1_3_76 is NOT null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar el campo P1_3_78-CA(cargo_mesa_directiva) debido a que en  la columna P1_3_77-BZ(cond_integrante_mesa_directiva)  se selecciono Sí"'1' 
public ArrayList cargo_mesa_directiva(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_77, P1_3_78 from TR_PLE_MEDS1_3 where P1_3_77=1 and  P1_3_78 is null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_3_78-CA(cargo_mesa_directiva) debido a que en  la columna P1_3_77-BZ(cond_integrante_mesa_directiva) no se selecciono Sí"'1' 
public ArrayList NCcargo_mesa_directiva(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_77, P1_3_78 from TR_PLE_MEDS1_3 where P1_3_77<>1 and  P1_3_78 is NOT null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe especificar P1_3_79-CB(otro_cargo_mesa_directiva_especifique) el otro cargo desempeñado por la persona legisladora en la Mesa Directiva debido a que se selecciono "Otro cargo (especifique)"'6' en la columna P1_3_78-CA(cargo_mesa_directiva) . 
public ArrayList otro_cargo_mesa_directiva_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_78, P1_3_79 from TR_PLE_MEDS1_3 where P1_3_78=6 and  P1_3_79 is null"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//El CAMPO P1_3_80 (ID_COMISION_LEGISLATIVA_1) (CC),P1_3_81 (NOMBRE_COMISION_LEGISLATIVA_1) (CD),P1_3_82 (CARGO_COMISION_LEGISLATIVA_1) (CE),P1_3_82 (CANT_REUNIONES_CELEBRADAS_COMISION_LEGISLATIVA_1_ASISTIDAS) (CF)
public ArrayList ID_COMISION_LEGISLATIVA_1NN(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_78, P1_3_79 from TR_PLE_MEDS1_3 where (P1_3_80 IS NULL OR P1_3_81 IS NULL OR P1_3_82 IS NULL)"
              + " and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//QUERY CON FOR 
//El nombre de la comision es diferente a lo capturado en la pestaña de comisiones. 
public ArrayList FNcomision(String ID_entidad,String Legislatura,String Envio,String CAMPO1, String CAMPO2){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  t.ID_ENTIDAD, t.ENTIDAD, t.C1_3_ID, t.P1_3_1,t.P1_3_80, t.P1_3_81, d.p1_2_1, d.p1_2_3 from TR_PLE_MEDS1_3 t\n" +
"left join TR_PLE_MEDS1_2 d on d.ID_ENTIDAD=t.ID_ENTIDAD and t.C1_3_ID=d.C1_2_ID and t."+CAMPO1+"=d.p1_2_1 \n" +
"where t."+CAMPO2+"<>d.p1_2_3"
              + " and t.ID_ENTIDAD="+ID_entidad+" AND t.Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//QUERY CON FOR 
//Los datos ingresados en ID_comision_legislativa :PARAMETRO1 y nombre_comision_legislativa :PARAMETRO2 no son correctos ya que no se encuentran en  en  TR_PLE_MEDS1_2(Tabla comisiones_legislativas).
public ArrayList ID_comision_legislativa(String ID_entidad,String Legislatura,String Envio,String CAMPO1, String CAMPO2){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  t.ID_ENTIDAD, t.ENTIDAD, t.C1_3_ID, t.P1_3_1,t."+CAMPO1+", t."+CAMPO2+", d.p1_2_1, d.p1_2_3 from TR_PLE_MEDS1_3 t\n" +
"left join TR_PLE_MEDS1_2 d on d.ID_ENTIDAD=t.ID_ENTIDAD and t.C1_3_ID=d.C1_2_ID and t."+CAMPO1+"=d.p1_2_1 and t."+CAMPO2+"=d.p1_2_3\n" +
"where t."+CAMPO1+" is not null and t."+CAMPO2+" is not null and t."+CAMPO1+"  not in ('-1','-2','-3') and  t."+CAMPO2+"  not in ('-1','-2','-3') and "
              + " d.p1_2_1 is null and d.p1_2_3 is null"
              + " and t.ID_ENTIDAD="+ID_entidad+" AND t.Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//QUERY CON FOR 
//cant_reuniones_celebradas_comision_legislativa_asistidas  Debe ser igual o menor a la cantidad registrada para dicha comisión legislativa en la columna P1_2_15-O(cant_reuniones_celebradas_comision_legislativa) de la TR_PLE_MEDS1_2(Tabla comisiones_legislativas).
public ArrayList cant_reuniones_celebradas_comision_legislativa_asistidas(String ID_entidad,String Legislatura,String Envio,String CAMPO1,String CAMPO5){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  t.ID_ENTIDAD, t.ENTIDAD, t.C1_3_ID, t.P1_3_1,t."+CAMPO1+", t."+CAMPO5+", d.p1_2_1, d.p1_2_3, d.p1_2_15"
              + "  from TR_PLE_MEDS1_3 t left join TR_PLE_MEDS1_2 d "
              + " on  d.ID_ENTIDAD=t.ID_ENTIDAD and t.C1_3_ID=d.C1_2_ID and t."+CAMPO1+"=d.p1_2_1 and t.P1_3_81=d.p1_2_3 where d.p1_2_1 is not null and d.p1_2_3 is not null and d.p1_2_15<t."+CAMPO5+""
              + " and t.ID_ENTIDAD="+ID_entidad+" AND t.Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//QUERY CON FOR 
//No se puede capturar informacion en alguno de los siguientes campos: :parametro2, :paramtero3:, :parametro4, parametro5 debido a que el campo :paramtero1 esta vacio.
public ArrayList NCAP_comisiones(String ID_entidad,String Legislatura,String Envio,String CAMPO2,String CAMPO2_1,String CAMPO2_2,String CAMPO2_3,String CAMPO2_4){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,"+CAMPO2+", "+CAMPO2_1+","+CAMPO2_2+","+CAMPO2_3+","+CAMPO2_4+" \n" +
" from TR_PLE_MEDS1_3 where "+CAMPO2+" is null and  ("+CAMPO2_1+" is not null or "+CAMPO2_2+" is not null or "+CAMPO2_3+" is not null or "+CAMPO2_4+" is not null)"
              + " and ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No puede repetir el identificador de la comisión legislativa asignado en la columna (ID_comision_legislativa).
public ArrayList Comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_3_ID, P1_3_1,P1_3_81, P1_3_84,P1_3_88,P1_3_92,P1_3_96,P1_3_100,P1_3_104, P1_3_108,P1_3_112,P1_3_116 from TR_PLE_MEDS1_3 where\n" +
"\n" +
"(P1_3_81= P1_3_84 or P1_3_81= P1_3_88 or P1_3_81= P1_3_92 or P1_3_81= P1_3_96 or P1_3_81= P1_3_100 or P1_3_81= P1_3_104 or P1_3_81= P1_3_108 or P1_3_81= P1_3_112 or P1_3_81= P1_3_116 or P1_3_84=P1_3_88\n" +
"or P1_3_84=P1_3_92 or P1_3_84=P1_3_96 or P1_3_84=P1_3_100 or P1_3_84=P1_3_104 or P1_3_84=P1_3_108 or P1_3_84=P1_3_112 or P1_3_84=P1_3_116 or P1_3_88=P1_3_92 or P1_3_88=P1_3_96 or P1_3_88=P1_3_100 \n" +
"or P1_3_88=P1_3_104 or P1_3_88=P1_3_108 or P1_3_88=P1_3_112 or P1_3_88=P1_3_116 or P1_3_92=P1_3_96 or P1_3_92=P1_3_100 or P1_3_92=P1_3_104 or P1_3_92=P1_3_108 or P1_3_92=P1_3_112 or P1_3_92=P1_3_116\n" +
"or P1_3_96=P1_3_100 or P1_3_96=P1_3_104 or P1_3_96=P1_3_108 or P1_3_96=P1_3_112 or P1_3_96=P1_3_116 or P1_3_100=P1_3_104 or P1_3_100=P1_3_108 or P1_3_100=P1_3_112 or P1_3_100=P1_3_116 or P1_3_104=P1_3_108\n" +
"or P1_3_104=P1_3_112 or P1_3_104=P1_3_116 or P1_3_108=P1_3_112 or P1_3_108=P1_3_116 or P1_3_112=P1_3_116)"
              + " and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_3_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_3_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//El total de personas legisladoras con estatus (K)='Activo'  de la pestaña Personas_Legisladoras no coincide con la suma de los campos distritos_uninominales y diputaciones_plurinominales de la pestaña datos_generales.
public ArrayList Legisladores_activos(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="WITH SumaTabla AS (\n" +
"    SELECT  TR1.ENTIDAD, TR1.LEGISLATURA, TR1.C1_1_ID AS ENVIO,SUM(TR1.P1_1_5 + TR1.P1_1_6) AS GENERAL_SUMA\n" +
"    FROM TR_PLE_MEDS1_1 TR1\n" +
"    where   TR1.ENTIDAD='"+ID_entidad+"'and TR1.LEGISLATURA="+Legislatura+" and TR1.C1_1_ID='"+Envio+"'\n" +
"    GROUP BY TR1.ENTIDAD,TR1.LEGISLATURA,TR1.C1_1_ID),\n" +
"ConteoTabla AS ( SELECT TR3.ENTIDAD,TR3.LEGISLATURA,TR3.C1_3_ID AS ENVIO,COUNT(*) AS NUMERO_LEGISLADORES_ACTIVO\n" +
"    FROM TR_PLE_MEDS1_3 TR3\n" +
"    WHERE TR3.P1_3_10 = '1'\n" +
"    and ( TR3.ENTIDAD='"+ID_entidad+"' and TR3.LEGISLATURA="+Legislatura+" and TR3.C1_3_ID='"+Envio+"')\n" +
"    GROUP BY TR3.ENTIDAD, TR3.LEGISLATURA, TR3.C1_3_ID)\n" +
"SELECT\n" +
"    COALESCE(S.ENTIDAD, C.ENTIDAD) AS ENTIDAD,\n" +
"    COALESCE(S.LEGISLATURA, C.LEGISLATURA) AS LEGISLATURA,\n" +
"    COALESCE(S.ENVIO, C.ENVIO) AS ENVIO,S.GENERAL_SUMA,C.NUMERO_LEGISLADORES_ACTIVO\n" +
"FROM SumaTabla S\n" +
"FULL OUTER JOIN ConteoTabla C ON S.ENTIDAD = C.ENTIDAD AND S.LEGISLATURA = C.LEGISLATURA AND S.ENVIO = C.ENVIO\n" +
"WHERE S.GENERAL_SUMA IS NULL OR C.NUMERO_LEGISLADORES_ACTIVO IS NULL OR S.GENERAL_SUMA <> C.NUMERO_LEGISLADORES_ACTIVO\n" +
"\n" +
"ORDER BY ENTIDAD,LEGISLATURA,ENVIO";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("GENERAL_SUMA"),
                        resul.getString("NUMERO_LEGISLADORES_ACTIVO")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//La Persona legisladora propietaria y el suplente se encuentran ambos con estatus activo  <estatus_persona_legisladora(K) k = Activo>.
public ArrayList suplente_propietario_activos(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT tr.ID_ENTIDAD,tr.C1_3_ID AS ENVIO, tr.LEGISLATURA,tr.P1_3_1 AS ID_LEGISLADOR_SUPLENTE,tce_PROPIETARIO.descripcion AS SUPLENTE_ESTATUS,\n" +
"TC_CARGO.DESCRIPCION,TR.P1_3_15 AS PROPIETARIO,tce_dueño_status.descripcion AS PROPIETARIO_STATUS \n" +
"FROM    TR_PLE_MEDS1_3  tr\n" +
"INNER JOIN TC_ESTATUS_PERSONA tce_PROPIETARIO ON tr.P1_3_10 = tce_PROPIETARIO.id\n" +
"INNER JOIN TC_CARACTER_CARGO TC_CARGO ON tr.P1_3_14 = TC_CARGO.id\n" +
"INNER JOIN TR_PLE_MEDS1_3 TR_3 ON TR_3.P1_3_1 = TR.P1_3_15 AND tr_3.ID_ENTIDAD = tr.id_entidad AND tr_3.LEGISLATURA = tr.LEGISLATURA AND tr_3.C1_3_ID = tr.C1_3_ID\n" +
"INNER JOIN TC_ESTATUS_PERSONA tce_dueño_status ON TR_3.P1_3_10 = tce_dueño_status.id\n" +
"WHERE tr.P1_3_10 = '1' AND TR_3.P1_3_10 = '1'"
               + " and (tr.ID_ENTIDAD="+ID_entidad+" AND tr.Legislatura="+Legislatura+" AND tr.C1_3_ID='"+Envio+"')";
     System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("ID_LEGISLADOR_SUPLENTE")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//--Existen personas legisladoras que iniciaron el periodo como grupo parlamentario (tipo_adscripcion_inicial_persona_legisladora <AR> = 'Grupo Parlamentario') y terminaron el periodo como legislador independiente (tipo_adscripcion_final_persona_legisladora <AU> = 'Legislador independiente'
public ArrayList grupo_parlamentario_independiente(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT tr.ENTIDAD, tr.P1_3_1 AS ID_LEGIS,tr.C1_3_ID AS ENVIO,  tc_adsini.descripcion AS ADSCRIP_INICIAL, tc_adsfin.descripcion AS ADSCRIP_FINAL\n" +
"FROM TR_PLE_MEDS1_3 tr\n" +
"inner join tc_tipo_adscripcion_ple  tc_adsfin on tr.P1_3_46= tc_adsfin.id \n" +
"inner join tc_tipo_adscripcion_ple  tc_adsini on  tr.P1_3_43= tc_adsini.id\n" +
"and  P1_3_43=1 AND  ( P1_3_46 <>1 AND P1_3_46 <>9 AND P1_3_46<>3)  "
               + " and (tr.ID_ENTIDAD="+ID_entidad+" AND tr.Legislatura="+Legislatura+" AND tr.C1_3_ID='"+Envio+"')";
     System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("ID_LEGIS")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
//La suma de las variables distritos_uninominales  y  diputaciones_plurinominales de la pestaña de datos generales no coincide con desglose en la pestaña personas_legisladoras. (la suma de personas_legisladoras con estatus activo en la variable estatus_persona_legisladora (K) = 'Activo' debe ser igual a la suma en la pestaña de datos generales)     
public ArrayList total_legisladores_desglose(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="WITH SumaTabla AS (\n" +
"    SELECT TR1.ENTIDAD, TR1.LEGISLATURA, TR1.C1_1_ID AS ENVIO, SUM(TR1.P1_1_5 + TR1.P1_1_6) AS GENERAL_SUMA\n" +
"    FROM TR_PLE_MEDS1_1 TR1\n" +
   " where (TR1.ID_ENTIDAD="+ID_entidad+" AND TR1.Legislatura="+Legislatura+" AND TR1.C1_1_ID='"+Envio+"')" +
"    GROUP BY TR1.ENTIDAD, TR1.LEGISLATURA, TR1.C1_1_ID ),\n" +
"ConteoTabla AS (\n" +
"    SELECT TR3.ENTIDAD, TR3.LEGISLATURA, TR3.C1_3_ID AS ENVIO, COUNT(*) AS NUMERO_LEGISLADORES_ACTIVO\n" +
"    FROM TR_PLE_MEDS1_3 TR3\n" +
"    WHERE TR3.P1_3_10 = '1'\n" +
                 " and (TR3.ID_ENTIDAD="+ID_entidad+" AND TR3.Legislatura="+Legislatura+" AND TR3.C1_3_ID='"+Envio+"')" +
"    GROUP BY TR3.ENTIDAD, TR3.LEGISLATURA, TR3.C1_3_ID )\n" +
"SELECT COALESCE(S.ENTIDAD, C.ENTIDAD) AS ENTIDAD, COALESCE(S.LEGISLATURA, C.LEGISLATURA) AS LEGISLATURA,\n" +
"    COALESCE(S.ENVIO, C.ENVIO) AS ENVIO, S.GENERAL_SUMA, C.NUMERO_LEGISLADORES_ACTIVO\n" +
"FROM SumaTabla S\n" +
"FULL OUTER JOIN ConteoTabla C ON S.ENTIDAD = C.ENTIDAD AND S.LEGISLATURA = C.LEGISLATURA AND S.ENVIO = C.ENVIO\n" +
"WHERE S.GENERAL_SUMA IS NULL OR C.NUMERO_LEGISLADORES_ACTIVO IS NULL OR S.GENERAL_SUMA <> C.NUMERO_LEGISLADORES_ACTIVO\n" +
"ORDER BY ENTIDAD, LEGISLATURA, ENVIO";
              
     System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ENTIDAD"),
                  resul.getString("GENERAL_SUMA")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



}
