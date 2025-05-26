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
public class QComparecencias {
DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul; 


//Estructura de ID incorrecta, no coincide con la información registrada en los campos de la tabla. Favor de revisar estructura correcta: CMP_LEGISLATURA_ENTIDAD_TURNO"
public ArrayList ID_Estructura(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="WITH ESTRUCTURA_ID AS (\n" +
"    SELECT C1_9_ID, TO_ROMAN(legislatura) AS LEGIS_ROMAN,legislatura, ENTIDAD, P1_9_1,\n" +
"        'CMP_' || TO_ROMAN(legislatura) || '_' || ENTIDAD || '_' || P1_9_2 AS ID_ESTRUCTURA_Correcta,P1_9_2 AS TURNO\n" +
"    FROM TR_PLE_MEDS1_9)\n" +
"SELECT  C1_9_ID AS ENVIO,legislatura, LEGIS_ROMAN,ENTIDAD,TURNO, ID_ESTRUCTURA_Correcta, P1_9_1 AS ID_actual\n" +
"FROM ESTRUCTURA_ID\n" +
"WHERE P1_9_1 <> ID_ESTRUCTURA_Correcta and ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se puede repetir el P1_9_1-A(ID_comparecencia)
public ArrayList ID_comparecencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD,P1_9_1,C1_9_ID,LEGISLATURA FROM(\n" +
"SELECT ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1,LEGISLATURA, COUNT(P1_9_1)\n" +
"FROM tr_ple_meds1_9\n" +
"GROUP BY ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1,LEGISLATURA\n" +
"HAVING COUNT(P1_9_1) > 1)WHERE ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"'";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//P1_9_3-C(fecha_comparecencia) debe encontrarse entre las fechas registradas en las columnas P1_1_8(fecha_inicio_informacion_reportada) y P1_1_9(fecha_termino_informacion_reportada) de la tabla datos_generales
public ArrayList fecha_comparecencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select a.ID_ENTIDAD, a.ENTIDAD, a.C1_9_ID, a.P1_9_1, a.P1_9_3, b.C1_1_ID, b.P1_1_8, B.P1_1_9,a.Legislatura \n" +
"from tr_ple_meds1_9 a inner join tr_ple_meds1_1 b\n" +
"on a.ID_ENTIDAD = b.ID_ENTIDAD and a.C1_9_ID = b.C1_1_ID \n" +
"where to_date (a.P1_9_3, 'dd/mm/yyyy') NOT BETWEEN to_date (b.P1_1_8, 'dd/mm/yyyy') \n" +
"AND to_date (b.P1_1_9, 'dd/mm/yyyy') AND ( a.ID_ENTIDAD="+ID_entidad+" AND a.Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe especificar la informacion P1_9_5-E(otro_motivo_comparecencia_especifique) ya que el campo P1_9_4-D(motivo_comparecencia) se selecciono Otro motivo (especifique) (2)
public ArrayList CAP_otro_motivo_comparecencia_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_4, P1_9_5 from tr_ple_meds1_9 where P1_9_4 = 2 and P1_9_5 is null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe capturar la informacion P1_9_5-E(otro_motivo_comparecencia_especifique) ya que P1_9_4-D(motivo_comparecencia) es diferente a Otro motivo (especifique) (2)
public ArrayList NCAP_otro_motivo_comparecencia_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_4, P1_9_5 from tr_ple_meds1_9 where P1_9_4 <> 2 and P1_9_5 is not null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe especificar la informacion P1_9_6-F(modalidad_comparecencia) ya que el campo P1_9_7 G(otra_modalidad_comparecencia_especifique) se selecciono "Otra modalidad (especifique)" (4)
public ArrayList CAP_otra_modalidad_comparecencia_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_6, P1_9_7 from tr_ple_meds1_9 where P1_9_6 = 4 and P1_9_7 is null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe capturar la informacionP1_9_7-G(otra_modalidad_comparecencia_especifique) ya que P1_9_6-F(modalidad_comparecencia) es diferente a "Otra modalidad (especifique)" (4)
public ArrayList NCAP_otra_modalidad_comparecencia_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_6, P1_9_7  from tr_ple_meds1_9 where P1_9_6 <> 4 and P1_9_7 is not null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe capturar informacion enP1_9_8-H(ID_comision_legislativa_1_comparecencia) y P1_9_9-I(nombre_comision_legislativa_1_comparecencia) ya que el campo P1_9_6-F(modalidad_comparecencia) se selecciono "Ante Comisiones Legislativas" (2) o "Ante Pleno y Comisiones Legislativas" (3)
public ArrayList CAPcomision_legislativa_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_6, P1_9_8 from tr_ple_meds1_9 where P1_9_6 IN (2,3) and (P1_9_8 is null or P1_9_9 is null) AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No debe capturar P1_9_8-H(ID_comision_legislativa_1_comparecencia) y P1_9_9-I(nombre_comision_legislativa_1_comparecencia) ya que en el campo  P1_9_6-F(modalidad_comparecencia) es diferente de "Ante Comisiones Legislativas" (2) o "Ante Pleno y Comisiones Legislativas" (3)
public ArrayList NCAPcomision_legislativa_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_6, P1_9_7 from tr_ple_meds1_9 where P1_9_6 NOT IN (2,3) and (P1_9_8 is not null or P1_9_9 is not null) AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe capturar informacion en P1_9_10-J(ID_comision_legislativa_2_comparecencia) y P1_9_11-K(nombre_comision_legislativa_2_comparecencia) ya que  P1_9_8-H(ID_comision_legislativa_1_comparecencia) y P1_9_9-I(nombre_comision_legislativa_1_comparecencia) no se selecciono una categoria
public ArrayList NCAPcomision_legislativa_2(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_9, P1_9_10, P1_9_11 from tr_ple_meds1_9  where (P1_9_8 is null and P1_9_9 is null) and (P1_9_10 is not null and P1_9_11 is not null) AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }






//No debe repetir el ID_comision_legislativa_comparecencia
public ArrayList NRcomision_legislativa_2(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_8, P1_9_10, P1_9_12 from tr_ple_meds1_9  where P1_9_8 = P1_9_10 OR P1_9_8 = P1_9_12 OR P1_9_10 = P1_9_12 AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No puede repetir el identificador de la comisión legislativa asignado en la columna P1_9_8-H(ID_comision_legislativa_1_comparecencia)
public ArrayList Rep_Comision(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_8, P1_9_10, P1_9_12 from tr_ple_meds1_9 where P1_9_8 = P1_9_10 AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe de capturar informacion en P1_9_12-L(ID_comision_legislativa_3_comparecencia) y P1_9_13-M(nombre_comision_legislativa_3_comparecencia) ya que P1_9_11-K(nombre_comision_legislativa_2_comparecencia) no se selecciono una categoria
public ArrayList NCAPcomision_legislativa_3(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_10, P1_9_11, P1_9_12, P1_9_13 from tr_ple_meds1_9 where (P1_9_10 is null and P1_9_11 is null) and (P1_9_12 is not null and P1_9_13 is not null) AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }




//No se debe repetir el ID_comision_legislativa_comparecencia
public ArrayList REPcomision_legislativa_3(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_8, P1_9_10, P1_9_12 from tr_ple_meds1_9  where P1_9_8 = P1_9_10 OR P1_9_8 = P1_9_12 OR P1_9_10 = P1_9_12 AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }





//No debe de capturar la informacion P1_9_15-O(nombre_2_persona_servidora_publica_comparecencia) ya que P1_9_14-N(nombre_1_persona_servidora_publica_comparecencia) no se escribio en el campo   
public ArrayList NCAP_nombre_1_persona_servidora_publica_comparecencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_14, P1_9_15 from tr_ple_meds1_9 where P1_9_14 is null and P1_9_15 is not null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe de capturar la infromacion P1_9_16-P(nombre_3_persona_servidora_publica_comparecencia) ya que P1_9_15-O(nombre_2_persona_servidora_publica_comparecencia) no se escribio en el campo   
public ArrayList CAP_nombre_1_persona_servidora_publica_comparecencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_15, P1_9_16 from tr_ple_meds1_9 where P1_9_15 is null and P1_9_16 is not null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe de capturar la infromacion P1_9_16-P(nombre_3_persona_servidora_publica_comparecencia) ya que P1_9_15-O(nombre_2_persona_servidora_publica_comparecencia) no se escribio en el campo   
public ArrayList NCAPapellido_2_persona_servidora_publica_comparecencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_17, P1_9_18 from tr_ple_meds1_9 where P1_9_17 is null and P1_9_18 is not null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe de capturar la informacion P1_9_19-S(apellido_3_persona_servidora_publica_comparecencia) ya que P1_9_18-R(apellido_2_persona_servidora_publica_comparecencia) no se escribio en el campo   
public ArrayList NCAPapellido_3_persona_servidora_publica_comparecencia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_18, P1_9_19 from tr_ple_meds1_9 where P1_9_18 is null and P1_9_19 is not null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se debe especificar la infomacion P1_9_22-V(nombre_institucion_persona_servidora_publica_comparecencia) ya que en P1_9_21-U(cargo_persona_servidora_publica_comparecencia) se selecciono uno diferente de (2), (9) y (13)  
public ArrayList NCAPnombre_institucion_persona_servidora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_21, P1_9_22 from tr_ple_meds1_9 where P1_9_21 not in (2,9,13) and (P1_9_22 is not null) AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe de especificar la informacion P1_9_22-V(nombre_institucion_persona_servidora_publica_comparecencia) ya que en P1_9_21-U(cargo_persona_servidora_publica_comparecencia) se selecciono "Titular de alguna institución  o unidad administrativa de la Administración Pública Estatal (excluyendo, de ser el caso, a la Procuraduría General de Justicia)" (2), "Titular de algún otro órgano constitucional autónomo de la entidad federativa (excluyendo al organismo público local electoral, al organismo garante de acceso a la información y protección de datos personales, al organismo público de derechos humanos de la entidad federativa, y, de ser el caso, a la Fiscalía General de la entidad federativa)" (9) o "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (13)  
public ArrayList CAPnombre_institucion_persona_servidora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_21, P1_9_22 from tr_ple_meds1_9 where P1_9_21 IN (2,9,13) and P1_9_22 is null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe de especificar la informacion P1_9_22-V(nombre_institucion_persona_servidora_publica_comparecencia) ya que en P1_9_21-U(cargo_persona_servidora_publica_comparecencia) se selecciono alguna de "Presidente(a) municipal" (10), "Regidor(a)" (11), "Síndico(a)" (12), "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (13) u "Otro cargo del ámbito municipal (especifique)" (15)  
public ArrayList CAPnombre_institucion_persona_servidora_publica(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_21, P1_9_23, P1_9_24 from tr_ple_meds1_9  where P1_9_21 IN (10,11,12,13,15)  and (P1_9_23 is null and P1_9_24 is null) AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe especificar la informacion P1_9_22-V(nombre_institucion_persona_servidora_publica_comparecencia) ya que en P1_9_21-U(cargo_persona_servidora_publica_comparecencia) se selecciono uno diferente de "Presidente(a) municipal" (10), "Regidor(a)" (11), "Síndico(a)" (12), "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (13) u "Otro cargo del ámbito municipal (especifique)" (15)  
public ArrayList NCAPnombre_institucion_persona_servidora_publica(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_21, P1_9_23, P1_9_24 from tr_ple_meds1_9  where P1_9_21 not in (10,11,12,13,15) and (P1_9_23 is not null and P1_9_24 is not null) AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe especificar la informacion P1_9_22-V(nombre_institucion_persona_servidora_publica_comparecencia) ya que en P1_9_21-U(cargo_persona_servidora_publica_comparecencia) se selecciono uno diferente de "Presidente(a) municipal" (10), "Regidor(a)" (11), "Síndico(a)" (12), "Titular de alguna institución o unidad administrativa de la Administración Pública del municipio o demarcación territorial" (13) u "Otro cargo del ámbito municipal (especifique)" (15)  
public ArrayList CAPotro_cargo_persona_servidora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_21, P1_9_23, P1_9_24  from tr_ple_meds1_9 where P1_9_21 = 14 and P1_9_25 is null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No debe especificar la informacion P1_9_25-Y(otro_cargo_persona_servidora_publica_comparecencia_ambito_estatal_especifique) ya que P1_9_21-U(cargo_persona_servidora_publica_comparecencia) se selecciono uno diferente de "Otro cargo del ámbito estatal (especifique)" (14) 
public ArrayList NCAPotro_cargo_persona_servidora(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_21, P1_9_23, P1_9_24 from tr_ple_meds1_9 where P1_9_21 <> 14 and P1_9_25 is not null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Se debe capturar la informacion en P1_9_26-Z(otro_cargo_persona_servidora_publica_comparecencia_ambito_municipal_especifique) debido a que P1_9_21-U(cargo_persona_servidora_publica_comparecencia) se selecciono  "Otro cargo del ámbito municipal (especifique)" (15) 
public ArrayList CAPotro_cargo_persona_servidora_publica_comparecencia_ambito_municipal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_21, P1_9_26 from tr_ple_meds1_9 where P1_9_21 = 15 and P1_9_26 is null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }



//No debe especificar la informacion P1_9_26-Z(otro_cargo_persona_servidora_publica_comparecencia_ambito_municipal_especifique) ya que P1_9_21-U(cargo_persona_servidora_publica_comparecencia) no se selecciono "Otro cargo del ámbito municipal (especifique)" (15) 
public ArrayList NCAPotro_cargo_persona_servidora_publica_comparecencia_ambito_municipal_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_9_ID, P1_9_1, P1_9_21, P1_9_26 from tr_ple_meds1_9 where P1_9_21 <> 15 and P1_9_26 is not null AND ( ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_9_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_9_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


}
