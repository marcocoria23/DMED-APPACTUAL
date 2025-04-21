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
public class QComisiones_Legislativas {
DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul;   



//No se puede repetir el P1_2_1-A(ID_comision_legislativa)
public ArrayList ID_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1, COUNT(P1_2_1)\n" +
"FROM TR_PLE_MEDS1_2 WHERE ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"'\n" +
"GROUP BY  ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1\n" +
"HAVING COUNT(P1_2_1) > 1  ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Variables P1_2_1-A(ID_comision_legislativa) o P1_2_2-B(consecutivo_comision_legislativa) o P1_2_3-C(nombre_comision_legislativa) o P1_2_4-D(tipo_comision_legislativa) o P1_2_6-F(tema_1_comision_legislativa) o P1_2_12-L(cant_integrantes_comision_legislativa) o P1_2_13-M(cond_celebracion_reuniones_comision_legislativa) o P1_2_18-R(cant_iniciativas_turnadas_a_comision_legislativa) o P1_2_19-S(cant_dictamenes_emitidos_por_comision_legislativa) No deben ser NULL
public ArrayList CAP_General(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1 from TR_PLE_MEDS1_2 where (P1_2_1 IS  NULL OR P1_2_2 IS  NULL OR P1_2_3 IS  NULL OR P1_2_4 IS  NULL OR P1_2_6 IS  NULL OR P1_2_12 IS  NULL OR P1_2_13 IS NULL OR P1_2_18 IS NULL OR P1_2_19 IS NULL)   AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe capturar P1_2_5-E(otro_tipo_comision_legislativa_especifique) debido a que en el campo P1_2_4-D(tipo_comision_legislativa) se seleccióno  "Otro tipo (especifique)"- '4' 
public ArrayList CAP_otro_tipo_comision_legislativa_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1, P1_2_4,P1_2_5 from TR_PLE_MEDS1_2 where P1_2_4=4 and P1_2_5 is null AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar el campo  P1_2_5-E(otro_tipo_comision_legislativa_especifique) debido a que en el campo P1_2_4-D(tipo_comision_legislativa) es diferente de  "Otro tipo (especifique)"- '4' 
public ArrayList NCAP_otro_tipo_comision_legislativa_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1, P1_2_4,P1_2_5 from TR_PLE_MEDS1_2 where P1_2_4<>4 and P1_2_5 is not null AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No puede repetir el tema seleccionado en mas de una columna de tema_comision_legislativa
public ArrayList REP_tema_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_6, P1_2_7, P1_2_8, P1_2_9\n" +
"from TR_PLE_MEDS1_2 where P1_2_6=P1_2_7 OR P1_2_6=P1_2_8 OR P1_2_6=P1_2_9 OR P1_2_7=P1_2_8 OR P1_2_7=P1_2_9 OR P1_2_8=P1_2_9 AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se debe de capturar informacion en P1_2_7-G(tema_2_comision_legislativa) ya que no se selecciono ningun tema en P1_2_6-F(tema_1_comision_legislativa)
public ArrayList tema_2_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_6,P1_2_7 from TR_PLE_MEDS1_2 where P1_2_6 is null and P1_2_7 is not null AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar informacion en P1_2_8-H(tema_3_comision_legislativa) ya que no se selecciono ningun tema en P1_2_7-G(tema_2_comision_legislativa)
public ArrayList tema_3_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_7,P1_2_8 from TR_PLE_MEDS1_2 where P1_2_7 is null and P1_2_8 is not null AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar informacion en P1_2_9-I(tema_4_comision_legislativa) ya que no se selecciono ningun tema en P1_2_8-H(tema_3_comision_legislativa)  
public ArrayList tema_4_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_8,P1_2_9 from TR_PLE_MEDS1_2 where P1_2_8 is null and P1_2_9 is not null AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar informacion en P1_2_10-J(tema_5_comision_legislativa) ya que no se selecciono ningun tema en P1_2_9-I(tema_4_comision_legislativa)  
public ArrayList tema_5_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_9,P1_2_10 from TR_PLE_MEDS1_2 where P1_2_9 is null and P1_2_10 is not null AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe capturar  P1_2_11-K(otro_tema_comision_legislativa_especifique) ya que tema_comision_legislativa  es diferente a  "Otro tema o asunto (especifique)"(44)  
public ArrayList NCAP_otro_tema_comision_legislativa_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_6, P1_2_7, P1_2_8, P1_2_9, P1_2_10,P1_2_11 \n" +
"from TR_PLE_MEDS1_2 where (P1_2_6<>44 AND P1_2_7<>44 AND P1_2_8<>44 AND P1_2_9<>44 AND P1_2_10<>44) AND  P1_2_11 IS NOT NULL AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe capturar P1_2_11-K(otro_tema_comision_legislativa_especifique) ya que tema_comision_legislativa tiene "Otro tema o asunto (especifique)"(44) 
public ArrayList CAP_otro_tema_comision_legislativa_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_6, P1_2_7, P1_2_8, P1_2_9, P1_2_10,P1_2_11\n" +
"from TR_PLE_MEDS1_2 where (P1_2_6=44 OR P1_2_7=44 OR P1_2_8=44 OR P1_2_9=44 OR P1_2_10=44) AND  P1_2_11 IS NULL AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Se debe capturar el campo P1_2_14-N(no_cond_celebracion_reuniones_comision_legislativa_especifique) debido a que  en la columna P1_2_13-M(cond_celebracion_reuniones_comision_legislativa)  se selecciono "No (especifique)" 
public ArrayList CAP_no_cond_celebracion_reuniones_comision_legislativa_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_13, P1_2_14\n" +
"from TR_PLE_MEDS1_2 where P1_2_13=2 AND P1_2_14 IS NULL AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar P1_2_14-N(no_cond_celebracion_reuniones_comision_legislativa_especifique) debido a que P1_2_13-M(cond_celebracion_reuniones_comision_legislativa) es diferente de "No (especifique)" 
public ArrayList NCAP_no_cond_celebracion_reuniones_comision_legislativa_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_13, P1_2_14\n" +
"from TR_PLE_MEDS1_2 where P1_2_13<>2 AND P1_2_14 IS  NOT NULL AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe de capturar cantidad mayor a 0 en P1_2_15 (cant_reuniones_celebradas_comision_legislativa) (O)ya que P1_2_13(cond_celebracion_reuniones_comision_legislativa)(M)=Si (1) 
public ArrayList CAP_cond_celebracion_reuniones_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_13, P1_2_15\n" +
"from TR_PLE_MEDS1_2 where P1_2_13=1 AND ( P1_2_15 IS  NULL OR P1_2_15=0) AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe de capturar en P1_2_15(cant_reuniones_celebradas_comision_legislativa)(O) ya que P1_2_13(cond_celebracion_reuniones_comision_legislativa)(M) es diferente a Si (1)
public ArrayList NCAP_cond_celebracion_reuniones_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_13, P1_2_15\n" +
"from TR_PLE_MEDS1_2 where P1_2_13<>1 AND P1_2_15 IS  NOT NULL AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//Se debe de capturar el campo P1_2_16-P(cond_transmision_reuniones_celebradas_comision_legislativa ya que P1_2_13-M(cond_celebracion_reuniones_comision_legislativa) tiene el valor de SI (1)
public ArrayList CAPcond_transmision_reuniones_celebradas_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_13, P1_2_16\n" +
"from TR_PLE_MEDS1_2 where P1_2_13=1 AND P1_2_16 IS NULL AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_2_16-P(cond_transmision_reuniones_celebradas_comision_legislativa)	ya que P1_2_13-M(cond_celebracion_reuniones_comision_legislativa) tiene el valor diferente de SI (1) 
public ArrayList NCAPcond_transmision_reuniones_celebradas_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_13, P1_2_16\n" +
"from TR_PLE_MEDS1_2 where P1_2_13<>1 AND P1_2_16 IS  NOT NULL AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de capturar el campo P1_2_17-Q(cant_reuniones_celebradas_transmitidas_comision_legislativa) debido a que P1_2_16-P(cond_transmision_reuniones_celebradas_comision_legislativa) tiene el valor de SI (1) 
public ArrayList CAPcant_reuniones_celebradas_transmitidas_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_16, P1_2_17\n" +
"from TR_PLE_MEDS1_2 where P1_2_16=1 AND P1_2_17 IS NULL AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe de capturar el campo P1_2_17-Q(cant_reuniones_celebradas_transmitidas_comision_legislativa) debido a que  P1_2_16-P(cond_transmision_reuniones_celebradas_comision_legislativa) tiene un valor diferente de SI (1)  
public ArrayList NCAPcant_reuniones_celebradas_transmitidas_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_16, P1_2_17\n" +
"from TR_PLE_MEDS1_2 where P1_2_16<>1 AND P1_2_17 IS NOT NULL AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//AQUI
//Debe de capturar cantidad mayor a 0 en P1_2_17-Q(cant_reuniones_celebradas_transmitidas_comision_legislativa) (R)ya que P1_2_16-P(cond_transmision_reuniones_celebradas_comision_legislativa)=Si 
public ArrayList cant_reuniones_celebradas_transmitidas_comision_legislativa(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_13, P1_2_15\n" +
"from TR_PLE_MEDS1_2 where P1_2_16=1 AND ( P1_2_17 IS  NULL OR P1_2_17=0) AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//P1_2_17-Q(cant_reuniones_celebradas_transmitidas_comision_legislativa) Debe ser igual o menor a la cantidad reportada en la columna P1_2_15-O(cant_reuniones_celebradas_comision_legislativa).
public ArrayList cant_reuniones_celebradas_transmitidas_comision_legislativa_MENOR(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_2_ID, P1_2_1,P1_2_15,P1_2_17 from TR_PLE_MEDS1_2  where P1_2_17> P1_2_15 AND ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_2_ID='"+Envio+"' ";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_2_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



}
