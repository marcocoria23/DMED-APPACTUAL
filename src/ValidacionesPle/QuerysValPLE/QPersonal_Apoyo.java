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
public class QPersonal_Apoyo {
    DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul;

//No se debe capturar el campo P1_4_3-C((nombre_2_personal_apoyo) cuando P1_4_2-B(nombre_1_personal_apoyo) viene vacio
public ArrayList nombre_2_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1, P1_4_2,P1_4_4 from TR_PLE_MEDS1_4 where P1_4_1 is null and P1_4_2 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
  //No se debe capturar el campo P1_4_4-D(nombre_3_personal_apoyo) cuando P1_4_3-C(nombre_2_personal_apoyo) viene vacio
public ArrayList nombre_3_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1, P1_4_4,P1_4_4 from TR_PLE_MEDS1_4 where P1_4_4 is null and P1_4_4 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  


//No se debe capturart el campo P1_4_6-F(apellido_2_personal_apoyo) cuando P1_4_5-E(apellido_1_personal_apoyo) viene vacio
public ArrayList apellido_2_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1, P1_4_4,P1_4_5 from TR_PLE_MEDS1_4 where P1_4_5 is null and P1_4_4 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  

//No se debe capturar el campo P1_4_7-G(apellido_3_personal_apoyo) cuando P1_4_6-F(apellido_2_personal_apoyo) viene vacio
public ArrayList apellido_3_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1, P1_4_6,P1_4_7 from TR_PLE_MEDS1_4 where P1_4_6 is null and P1_4_7 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  


//Se debe capturar P1_4_11-K(otro_regimen_contratacion_personal_apoyo_especifique) ya que P1_4_10-J(regimen_contratacion_personal_apoyo) se selecciono la categoría "Otro régimen de contratación (especifique)" 5
public ArrayList QComisiones_Legislativas(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1, P1_4_10,P1_4_11 from TR_PLE_MEDS1_4 where P1_4_10=5 and P1_4_11 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  

//No se debe capturar el campo P1_4_11-K(otro_regimen_contratacion_personal_apoyo_especifique) debido a que la categoria seleccionada en  la columna P1_4_10-J(regimen_contratacion_personal_apoyo)  es diferente a "Otro régimen de contratación (especifique)" 5
public ArrayList otro_regimen_contratacion_personal_apoyo_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1, P1_4_10,P1_4_11 from TR_PLE_MEDS1_4 where P1_4_10<>5 and P1_4_11 is  NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  


//únicamente puede seleccionar la categoría "No aplica"'8' en la columna P1_4_15-O(estatus_escolaridad_personal_apoyo) ya que se selecciono la categoría "Ninguno"'1' en la columna P1_4_14-N(escolaridad_personal_apoyo),
public ArrayList estatus_escolaridad_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_14,P1_4_15 from TR_PLE_MEDS1_4 where P1_4_14=1 and P1_4_15 <>8"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  


//únicamente puede seleccionar la categoría únicamente puede seleccionar las categorías "Cursando"'1', "Inconcluso"'2', "Concluido"'3' o "No identificado"'9' en la columna P1_4_15-O(estatus_escolaridad_personal_apoyo) ya que se selecciono alguna de las siguientes  categorías  la categoría "Preescolar o primaria"'2', "Secundaria"'3' o "Preparatoria"'4' en la columna P1_4_14-N(escolaridad_personal_apoyo)
public ArrayList Cursando(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_14,P1_4_15 from TR_PLE_MEDS1_4 where P1_4_14 in (2,3,4) and P1_4_15 not in (1,2,3,9)"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  


//únicamente puede seleccionar la categoría únicamente puede seleccionar las categorías "Cursando"'1', "Inconcluso"'2', "Concluido"'3'  "Titulado"4 o "No identificado"'9' en la columna P1_4_15-O(estatus_escolaridad_personal_apoyo) ya que se selecciono alguna de las siguientes  categorías  la categoría "Licenciatura" 6, "Maestría"7 o "Doctorado"8  en la columna P1_4_14-N(escolaridad_personal_apoyo)
public ArrayList Inconcluso(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_14,P1_4_15 from TR_PLE_MEDS1_4 where P1_4_14 in (6,7,8) and P1_4_15 not in (1,2,3,4,9)"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  


//únicamente puede seleccionar la categoría "No identificado" en la columna P1_4_15-O(estatus_escolaridad_personal_apoyo) debido a que en la columna P1_4_14-N(escolaridad_personal_apoyo) se selecciono la categoría "No identificado" 
public ArrayList NDestatus_escolaridad_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_14,P1_4_15 from TR_PLE_MEDS1_4 where P1_4_14 =99 and P1_4_15<>9"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  

//Se debe capturar el campo P1_4_16-P(carrera_licenciatura_personal_apoyo)  debido a que selecciono alguna de las categorias de "Licenciatura"'6', "Maestría"'7' o "Doctorado"'8' en la columnaP1_4_14-N(escolaridad_personal_apoyo)
public ArrayList DCcarrera_licenciatura_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_14,P1_4_16 from TR_PLE_MEDS1_4 where P1_4_14 in (6,7,8) and P1_4_16 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  

//No se debe capturar el campo P1_4_16-P(carrera_licenciatura_personal_apoyo) debido a que no selecciono alguna de las categorias de "Licenciatura"'6', "Maestría"'7' o "Doctorado"'8' en la columna P1_4_14-N(escolaridad_personal_apoyo).
public ArrayList NDCcarrera_licenciatura_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_14,P1_4_16 from TR_PLE_MEDS1_4 where P1_4_14 NOT in (6,7,8) and P1_4_16 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  


//Se debe de capturar el campo P1_4_17-Q(carrera_maestria_personal_apoyo) debido a que en la columna P1_4_14-N(escolaridad_personal_apoyo) se selecciono la categoría "Maestría"'7' o "Doctorado"'8'
public ArrayList DCcarrera_maestria_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_14,P1_4_17 from TR_PLE_MEDS1_4 where P1_4_14 in (7,8) and P1_4_17 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  

//No se debe de capturar el campo P1_4_17-Q(carrera_maestria_personal_apoyo) debido a que en la columna P1_4_14-N(escolaridad_personal_apoyo) es diferente a las categorias de "Maestría"'7' o "Doctorado"'8'
public ArrayList NDCcarrera_maestria_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_14,P1_4_17 from TR_PLE_MEDS1_4 where P1_4_14 NOT IN (7,8) and P1_4_17 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 } 


//Se debe de capturar el campo  P1_4_18-R(carrera_doctorado_personal_apoyo)  debido a que selecciono la categoría "Doctorado"'8' en la columna  P1_4_14-N(escolaridad_personal_apoyo)
public ArrayList DCcarrera_doctorado_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_14,P1_4_18 from TR_PLE_MEDS1_4 where P1_4_14 =8 and P1_4_18 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 } 

//No se debe de capturar el campo  P1_4_18-R(carrera_doctorado_personal_apoyo)  debido a que se selecciono una categoría  diferente de "Doctorado"'8' en la columna  P1_4_14-N(escolaridad_personal_apoyo)
public ArrayList NDCcarrera_doctorado_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_14,P1_4_18 from TR_PLE_MEDS1_4 where P1_4_14 <>8 and P1_4_18 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de capturar el campo P1_4_20-T(lengua_ind_1_personal_apoyo) debido a que en la columna P1_4_19-S(cond_lengua_ind_personal_apoyo) se selecciono "Sí"'1'
public ArrayList DClengua_ind_1_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_19,P1_4_20 from TR_PLE_MEDS1_4 where P1_4_19=1 and P1_4_20 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_4_20-T(lengua_ind_1_personal_apoyo) debido a que en la columna P1_4_19-S(cond_lengua_ind_personal_apoyo) es diferente de"Sí"'1'
public ArrayList NDClengua_ind_1_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_19,P1_4_20 from TR_PLE_MEDS1_4 where P1_4_19<>1 and P1_4_20 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_4_21-U(lengua_ind_2_personal_apoyo) debido a que el campo PP1_4_20-T(lengua_ind_1_personal_apoyo). viene vacio
public ArrayList DClengua_ind_2_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_20,P1_4_21 from TR_PLE_MEDS1_4 where P1_4_20 is null and P1_4_21 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
    
  //No puede repetir la lengua indígena seleccionada en la columna P1_4_20-T(lengua_ind_1_personal_apoyo).
public ArrayList lengua_ind_1_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD,ENTIDAD,C1_4_ID,P1_4_1,P1_4_20,P1_4_21,P1_4_22 from TR_PLE_MEDS1_4 where P1_4_20=P1_4_21 or P1_4_20=P1_4_22 or P1_4_21=P1_4_22"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  

//No se debe de capturar el campo P1_4_22-V(lengua_ind_3_personal_apoyo) debido a que el campo P1_4_21-U(lengua_ind_2_personal_apoyo). viene vacio
public ArrayList lengua_ind_3_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_21,P1_4_22 from TR_PLE_MEDS1_4 where P1_4_21 is null and P1_4_22 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  

//Se debe de capturar el campo P1_4_24-X(pueblo_ind_pertenencia_personal_apoyo) debido a que en la columna P1_4_23-W(cond_pueblo_ind_personal_apoyo).  se selecciono la categoría "Sí" 1
public ArrayList pueblo_ind_pertenencia_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_23,P1_4_24 from TR_PLE_MEDS1_4 where P1_4_23=1  and P1_4_24 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  

//No se debe de capturar el campo P1_4_24-X(pueblo_ind_pertenencia_personal_apoyo) debido a que en la columna P1_4_23-W(cond_pueblo_ind_personal_apoyo)  se selecciono una categoria diferente a "Sí"'1'
public ArrayList NDCpueblo_ind_pertenencia_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_23,P1_4_24 from TR_PLE_MEDS1_4 where P1_4_23<>1  and P1_4_24 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  


//se debe de capturar P1_4_26-Z(tipo_discapacidad_1_personal_apoyo) debido a que en la columna P1_4_25-Y(cond_discapacidad_personal_apoyo). se selecciono SI '1'
public ArrayList DCtipo_discapacidad_1_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_20,P1_4_26,P1_4_25 from TR_PLE_MEDS1_4 where P1_4_26=1  and P1_4_25 is  null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }  

//No se debe de capturar P1_4_28-AB(tipo_discapacidad_3_personal_apoyo) debido a que la columna P1_4_25-Y(cond_discapacidad_personal_apoyo) es diferente de SI '1'
public ArrayList NDCtipo_discapacidad_1_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_20,P1_4_26,P1_4_25 from TR_PLE_MEDS1_4 where P1_4_26<>1  and P1_4_25 is  NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_4_27-AA(tipo_discapacidad_2_personal_apoyo) debido a que el campo P1_4_26-Z(tipo_discapacidad_1_personal_apoyo) viene vacio
public ArrayList NDCtipo_discapacidad_2_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_20,P1_4_26,P1_4_27 from TR_PLE_MEDS1_4 where P1_4_26 is  null  and P1_4_27 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  
//No puede repetir el tipo de discapacidad seleccionado en la columna tipo_discapacidad_personal_apoyo
public ArrayList discapacidad(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD,ENTIDAD,C1_4_ID,P1_4_1,P1_4_26,P1_4_27,P1_4_28 from TR_PLE_MEDS1_4 where P1_4_26=P1_4_27 or P1_4_26=P1_4_28 or P1_4_27=P1_4_28"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar los campos P1_4_27-AA(tipo_discapacidad_2_personal_apoyo) o P1_4_28-AB(tipo_discapacidad_3_personal_apoyo) si el campo P1_4_26-Z(tipo_discapacidad_1_personal_apoyo) es 'No Identificado' '99'
public ArrayList tipo_discapacidad_2_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD,ENTIDAD,C1_4_ID, P1_4_1,P1_4_26,P1_4_27,P1_4_28 from TR_PLE_MEDS1_4 where P1_4_27=99 and P1_4_28 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar los campos P1_4_28-AB(tipo_discapacidad_3_personal_apoyo) si el campo P1_4_27-AA(tipo_discapacidad_2_personal_apoyo) es 'No Identificado' '99'
public ArrayList tipo_discapacidad_3_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD,ENTIDAD,C1_4_ID, P1_4_1,P1_4_26,P1_4_27,P1_4_28 from TR_PLE_MEDS1_4 where P1_4_26=99 and (P1_4_27 is not null or  P1_4_28 is not null)"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo P1_4_28-AB(tipo_discapacidad_3_personal_apoyo) debido a que la columna P1_4_27-AA(tipo_discapacidad_2_personal_apoyo). viene vacio
public ArrayList NDCtipo_discapacidad_3_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_20,P1_4_27,P1_4_28 from TR_PLE_MEDS1_4 where P1_4_27 is null  and P1_4_28 is NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar P1_4_30-AD(ID_persona_legisladora_personal_apoyo) debido a que en la columna  P1_4_29-AC(tipo_adscripcion_personal_apoyo). se selecciono la categoría "Persona legisladora" 2
public ArrayList ID_persona_legisladora_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_29, P1_4_30 from TR_PLE_MEDS1_4 where P1_4_29=2 and  P1_4_30 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar P1_4_30-AD(ID_persona_legisladora_personal_apoyo) debido a que en la columna  P1_4_29-AC(tipo_adscripcion_personal_apoyo). se selecciono diferente a  la categoría "Persona legisladora" 2
public ArrayList NDCID_persona_legisladora_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_29, P1_4_30 from TR_PLE_MEDS1_4 where P1_4_29<>2 and  P1_4_30 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar P1_4_31-AE(nombre_persona_legisladora_personal_apoyo) debido a que en la columna  P1_4_29-AC(tipo_adscripcion_personal_apoyo). se selecciono la categoría "Persona legisladora" 2
public ArrayList DCnombre_persona_legisladora_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_29, P1_4_31 from TR_PLE_MEDS1_4 where P1_4_29=2 and  P1_4_31 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar P1_4_31-AE(nombre_persona_legisladora_personal_apoyo) debido a que en la columna  P1_4_29-AC(tipo_adscripcion_personal_apoyo). se selecciono diferente a  la categoría "Persona legisladora" 2
public ArrayList nombre_persona_legisladora_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_29, P1_4_31 from TR_PLE_MEDS1_4 where P1_4_29<>2 and  P1_4_31 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar P1_4_32-AF(grupo_parlamentario_personal_apoyo) debido a que en la columna  P1_4_29-AC(tipo_adscripcion_personal_apoyo). se selecciono la categoría "Grupo parlamentario" 3
public ArrayList DCgrupo_parlamentario_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_29, P1_4_32 from TR_PLE_MEDS1_4 where P1_4_29=3 and  P1_4_32 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar P1_4_32-AF(grupo_parlamentario_personal_apoyo) debido a que en la columna  P1_4_29-AC(tipo_adscripcion_personal_apoyo). se selecciono diferente a  la categoría "Grupo parlamentario" 3
public ArrayList NDCgrupo_parlamentario_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_29, P1_4_32 from TR_PLE_MEDS1_4 where P1_4_29<>3 and  P1_4_32 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar P1_4_33-AG(otro_tipo_adscripcion_personal_apoyo_especifique) debido a que en la columna  P1_4_29-AC(tipo_adscripcion_personal_apoyo). se selecciono la categoría  "Otro tipo de adscripción (especifique)"4
public ArrayList DCotro_tipo_adscripcion_personal_apoyo_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_29, P1_4_33 from TR_PLE_MEDS1_4 where P1_4_29=4 and  P1_4_33 is null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar  P1_4_33-AG(otro_tipo_adscripcion_personal_apoyo_especifique) debido a que en la columna  P1_4_29-AC(tipo_adscripcion_personal_apoyo). se selecciono diferente a  la categoría "Otro tipo de adscripción (especifique)"4
public ArrayList NDCotro_tipo_adscripcion_personal_apoyo_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_29, P1_4_33 from TR_PLE_MEDS1_4 where P1_4_29<>4 and  P1_4_33 is not null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar P1_4_35-AI(ID_comision_legislativa_personal_apoyo) debido a que en la columna  P1_4_34-AH(cond_secretario_tecnico_comision_legislativa_personal_apoyo). se selecciono la categoría "Sí" 1
public ArrayList DCID_comision_legislativa_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_34,P1_4_35 from TR_PLE_MEDS1_4 where P1_4_34=1  and P1_4_35 is  null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar  P1_4_35-AI(ID_comision_legislativa_personal_apoyo)  debido a que en la columna   P1_4_34-AH(cond_secretario_tecnico_comision_legislativa_personal_apoyo). se selecciono diferente a  la categoría "Sí" 1
public ArrayList NDCID_comision_legislativa_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_34,P1_4_35 from TR_PLE_MEDS1_4 where P1_4_34<>1  and P1_4_35 is  NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe de capturar P1_4_36-AJ(nombre_comision_legislativa_personal_apoyo) debido a que en la columna P1_4_34-AH(cond_secretario_tecnico_comision_legislativa_personal_apoyo) se selecciono la categoría  "Sí"1
public ArrayList DCnombre_comision_legislativa_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_34,P1_4_36 from TR_PLE_MEDS1_4 where P1_4_34=1  and P1_4_36 is  null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar  P1_4_33-AG(otro_tipo_adscripcion_personal_apoyo_especifique) debido a que en la columna  P1_4_34-AH(cond_secretario_tecnico_comision_legislativa_personal_apoyo) se selecciono diferente a  la categoría "Sí"1
public ArrayList NDCnombre_comision_legislativa_personal_apoyo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_4_ID, P1_4_1,P1_4_34,P1_4_36 from TR_PLE_MEDS1_4 where P1_4_34<>1  and P1_4_36 is  NOT null"
              + " AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_4_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_4_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

}
