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
public class QIniciativas_Urgente_obvia {
DaoConexion conexion = new DaoConexion();
String sql;
ArrayList<String[]> Array;
ResultSet resul;

public ArrayList ID_estructura(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="WITH ESTRUCTURA_ID AS (\n" +
"    SELECT C1_6_ID, TO_ROMAN(legislatura) AS LEGIS_ROMAN,legislatura, ENTIDAD, P1_6_1,\n" +
"        'IN_UO_' || TO_ROMAN(legislatura) || '_' || ENTIDAD || '_' || P1_6_2 AS ID_ESTRUCTURA_Correcta,P1_6_2 AS TURNO\n" +
"    FROM TR_PLE_MEDS1_6)\n" +
"SELECT  C1_6_ID AS ENVIO,legislatura, LEGIS_ROMAN,ENTIDAD,TURNO, ID_ESTRUCTURA_Correcta, P1_6_1 AS ID_actual\n" +
"FROM ESTRUCTURA_ID\n" +
"WHERE P1_6_1 <> ID_ESTRUCTURA_Correcta and (ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
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
//Debe ser igual o menor a la fecha registrada en la columna P1_1_9(fecha_termino_informacion_reportada) de la tabla datos_generales.
public ArrayList fecha_termino_informacion_reportada(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select  c.ID_ENTIDAD, c.ENTIDAD, \n" +
"c.C1_6_ID, c.P1_6_1, \n" +
"c.P1_6_4, u.p1_1_9\n" +
"from TR_PLE_MEDS1_6 c \n" +
"inner join TR_PLE_MEDS1_1 u on c.id_entidad=u.id_entidad and c.C1_6_ID=u.C1_1_ID\n" +
"where \n" +
" ( to_date(c.P1_6_4,'DD/MM/YYYY') <> '09/09/1899' AND  to_date(c.P1_6_4,'DD/MM/YYYY') <> '09/09/1799')\n" +
"and c.P1_6_4 not in ('-1','-2','-3')\n" +
"AND P1_6_4 NOT LIKE '%00%' and P1_6_72 NOT LIKE '%00%' AND REGEXP_LIKE(c.P1_6_4,\n" +
"'^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$'\n" +
")\n" +
"AND\n" +
"REGEXP_LIKE(u.p1_1_9,\n" +
"'^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$'\n" +
") and to_date(c.P1_6_4,'DD/MM/YYYY') >to_date(u.p1_1_9,'DD/MM/YYYY') and (c.ID_ENTIDAD="+ID_entidad+" AND c.Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  

//Debe ser igual o mayor a la fecha registrada en la columna P1_6_4-D(fecha_ingreso_iniciativa_urgente_obvia_oficialia_partes).
public ArrayList fecha_ingreso_iniciativa_urgente_obvia_oficialia_partes(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="SELECT ID_ENTIDAD, ENTIDAD, \n" +
"    C1_6_ID, P1_6_1,  \n" +
"    to_date(P1_6_6)P1_6_6,\n" +
"    to_date(P1_6_4)P1_6_4\n" +
"FROM TR_PLE_MEDS1_6\n" +
"WHERE \n" +
"    REGEXP_LIKE(P1_6_4, '^\\d{2}/\\d{2}/\\d{4}$')\n" +
"AND\n" +
"    REGEXP_LIKE(P1_6_6, '^\\d{2}/\\d{2}/\\d{4}$') \n" +
"    AND SUBSTR(P1_6_4, 1, 2) BETWEEN '01' AND '31' \n" +
"    AND SUBSTR(P1_6_4, 4, 2) BETWEEN '01' AND '12' \n" +
"    AND SUBSTR(P1_6_6, 1, 2) BETWEEN '01' AND '31' \n" +
"    AND SUBSTR(P1_6_6, 4, 2) BETWEEN '01' AND '12' \n" +
"    AND TO_DATE(P1_6_4, 'DD/MM/YYYY') IS NOT NULL \n" +
"    AND TO_DATE(P1_6_6, 'DD/MM/YYYY') IS NOT NULL\n" +
"    and ( to_date(P1_6_6,'DD/MM/YYYY') <> '09/09/1899' AND  to_date(P1_6_6,'DD/MM/YYYY') <> '09/09/1799')  AND  to_date(P1_6_6,'DD/MM/YYYY')<to_date(P1_6_4,'DD/MM/YYYY')  and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }
  
//Debe especificar el tipo de iniciativa en P1_6_8-H(otro_tipo_iniciativa_urgente_obvia_especifique) debido a P1_6_7-G(tipo_iniciativa_urgente_obvia) se selecciono la categoría "Otro tipo (especifique)" (3).
public ArrayList otro_tipo_iniciativa_urgente_obvia_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_7, P1_6_8 from tr_ple_meds1_6 where P1_6_7 = 3 and P1_6_8 is null  and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe especificar el tipo de iniciativa en P1_6_8-H(otro_tipo_iniciativa_urgente_obvia_especifique) debido a P1_6_7-G(tipo_iniciativa_urgente_obvia) se selecciono la categoría diferente a "Otro tipo (especifique)" (3).
public ArrayList DEotro_tipo_iniciativa_urgente_obvia_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_7, P1_6_8  from tr_ple_meds1_6 where P1_6_7 <> 3 and P1_6_8 is not null  and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar una categoria en P1_6_11-K(nombre_persona_legisladora_1) y P1_6_10-J(ID_persona_legisladora_1) debido a P1_6_9-I(tipo_promovente_iniciativa_urgente_obvia) se selecciono "Personas legisladoras" (3).
public ArrayList DCnombre_persona_legisladora_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_10, P1_6_11 from tr_ple_meds1_6  where P1_6_9 = 3 and (P1_6_10 is null and P1_6_11 is null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoria en P1_6_11-K(nombre_persona_legisladora_1) y P1_6_10-J(ID_persona_legisladora_1) debido a P1_6_9-I(tipo_promovente_iniciativa_urgente_obvia) se selecciono una categoria diferente a "Personas legisladoras" (3).
public ArrayList NDCnombre_persona_legisladora_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_10, P1_6_11 from tr_ple_meds1_6  where P1_6_9 <> 3  and (P1_6_10 is not null and P1_6_11 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe capturar información en P1_6_10-J(ID_persona_legisladora_1) o P1_6_11-K(nombre_persona_legisladora_1) debido a  se selecciono una categoría en cualquiera de las ya mencionadas.
public ArrayList DCID_persona_legisladora_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_10, P1_6_11 from tr_ple_meds1_6 where (P1_6_42 is null and P1_6_43 is not null) or (P1_6_42 is not null and P1_6_43 is null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe seleccionar una categoria en Campo2 ,P1_6_12,-L(ID_persona_legisladora_2) y Campo3 ,P1_6_13,-M(nombre_persona_legisladora_2) debido a Campo1 ,P1_6_11,-K(nombre_persona_legisladora_1) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_14,-N(ID_persona_legisladora_3) y ,P1_6_15,-O(nombre_persona_legisladora_3) debido a ,P1_6_13,-M(nombre_persona_legisladora_2) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_16,-P(ID_persona_legisladora_4) y ,P1_6_17,-Q(nombre_persona_legisladora_4) debido a ,P1_6_15,-O(nombre_persona_legisladora_3) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_18,-R(ID_persona_legisladora_5) y ,P1_6_19,-S(nombre_persona_legisladora_5) debido a ,P1_6_17,-Q(nombre_persona_legisladora_4) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_20,-T(ID_persona_legisladora_6) y ,P1_6_21,-U(nombre_persona_legisladora_6) debido a ,P1_6_19,-S(nombre_persona_legisladora_5) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_22,-V(ID_persona_legisladora_7) y ,P1_6_23,-W(nombre_persona_legisladora_7) debido a ,P1_6_21,-U(nombre_persona_legisladora_6) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_24,-X(ID_persona_legisladora_8) y ,P1_6_25,-Y(nombre_persona_legisladora_8) debido a ,P1_6_23,-W(nombre_persona_legisladora_7) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_26,-Z(ID_persona_legisladora_9) y ,P1_6_27,-AA(nombre_persona_legisladora_9) debido a ,P1_6_25,-Y(nombre_persona_legisladora_8) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_28,-AB(ID_persona_legisladora_10) y ,P1_6_29,-AC(nombre_persona_legisladora_10) debido a ,P1_6_27,-AA(nombre_persona_legisladora_9) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_30,-AD(ID_persona_legisladora_11) y ,P1_6_31,-AE(nombre_persona_legisladora_11) debido a ,P1_6_29,-AC(nombre_persona_legisladora_10) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_32,-AF(ID_persona_legisladora_12) y ,P1_6_33,-AG(nombre_persona_legisladora_12) debido a ,P1_6_31,-AE(nombre_persona_legisladora_11) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_34,-AH(ID_persona_legisladora_13) y ,P1_6_35,-AI(nombre_persona_legisladora_13) debido a ,P1_6_33,-AG(nombre_persona_legisladora_12) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_36,-AJ(ID_persona_legisladora_14) y ,P1_6_37,-AK(nombre_persona_legisladora_14) debido a ,P1_6_35,-AI(nombre_persona_legisladora_13) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_38,-AL(ID_persona_legisladora_15) y ,P1_6_39,-AM(nombre_persona_legisladora_15) debido a ,P1_6_37,-AK(nombre_persona_legisladora_14) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_40,-AN(ID_persona_legisladora_16) y ,P1_6_41,-AO(nombre_persona_legisladora_16) debido a ,P1_6_39,-AM(nombre_persona_legisladora_15) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_42,-AP(ID_persona_legisladora_17) y ,P1_6_43,-AQ(nombre_persona_legisladora_17) debido a ,P1_6_41,-AO(nombre_persona_legisladora_16) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_44,-AR(ID_persona_legisladora_18) y ,P1_6_45,-AS(nombre_persona_legisladora_18) debido a ,P1_6_43,-AQ(nombre_persona_legisladora_17) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_46,-AT(ID_persona_legisladora_19) y ,P1_6_47,-AU(nombre_persona_legisladora_19) debido a ,P1_6_45,-AS(nombre_persona_legisladora_18) no se selecciono una categoria.
//No debe seleccionar una categoria en ,P1_6_48,-AV(ID_persona_legisladora_20) y ,P1_6_49,-AW(nombre_persona_legisladora_20) debido a ,P1_6_47,-AU(nombre_persona_legisladora_19) no se selecciono una categoria.

public ArrayList NDCID_persona_legisladora_2(String ID_entidad,String Legislatura,String Envio,String Campo1,String Campo2,String Campo3){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, "+Campo1+", "+Campo2+", "+Campo3+" from tr_ple_meds1_6 where ("+Campo2+" is not null or "+Campo3+" is not null) and "+Campo1+" is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe capturar información en P1_6_12-L(ID_persona_legisladora_2) o P1_6_13-M(nombre_persona_legisladora_2) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_14-N(ID_persona_legisladora_3) o P1_6_15-O(nombre_persona_legisladora_3) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_16-P(ID_persona_legisladora_4) o P1_6_17-Q(nombre_persona_legisladora_4) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_18-R(ID_persona_legisladora_5) o P1_6_19-S(nombre_persona_legisladora_5) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_20-T(ID_persona_legisladora_6) o P1_6_21-U(nombre_persona_legisladora_6) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_22-V(ID_persona_legisladora_7) o P1_6_23-W(nombre_persona_legisladora_7) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_24-X(ID_persona_legisladora_8) o P1_6_25-Y(nombre_persona_legisladora_8) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_26-Z(ID_persona_legisladora_9) o P1_6_27-AA(nombre_persona_legisladora_9) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_28-AB(ID_persona_legisladora_10) o P1_6_29-AC(nombre_persona_legisladora_10) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_30-AD(ID_persona_legisladora_11) o P1_6_31-AE(nombre_persona_legisladora_11) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_32-AF(ID_persona_legisladora_12) o P1_6_33-AG(nombre_persona_legisladora_12) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_34-AH(ID_persona_legisladora_13) o P1_6_35-AI(nombre_persona_legisladora_13) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_36-AJ(ID_persona_legisladora_14) o P1_6_37-AK(nombre_persona_legisladora_14) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_38-AL(ID_persona_legisladora_15) o P1_6_39-AM(nombre_persona_legisladora_15) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_40-AN(ID_persona_legisladora_16) o P1_6_41-AO(nombre_persona_legisladora_16) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_42-AP(ID_persona_legisladora_17) o P1_6_43-AQ(nombre_persona_legisladora_17) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_44-AR(ID_persona_legisladora_18) o P1_6_45-AS(nombre_persona_legisladora_18) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_46-AT(ID_persona_legisladora_19) o P1_6_47-AU(nombre_persona_legisladora_19) debido a  se selecciono una categoría y viceversa.
//Debe capturar información en P1_6_48-AV(ID_persona_legisladora_20) o P1_6_49-AW(nombre_persona_legisladora_20)debido a  se selecciono una categoría y viceversa.

public ArrayList DCID_persona_legisladora_2(String ID_entidad,String Legislatura,String Envio,String Campo1,String Campo2,String Campo3){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, "+Campo1+", "+Campo2+", "+Campo3+" from tr_ple_meds1_6 where ("+Campo2+" is null or "+Campo3+" is null) and "+Campo1+" is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No puede repetir el identificador de la persona legisladora asignado en la columna ID_persona_legisladora.
public ArrayList DCID_persona_legisladora_2(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_10, P1_6_12, P1_6_14, P1_6_16, P1_6_18, P1_6_20, P1_6_22, P1_6_24,\n" +
"  P1_6_26, P1_6_28, P1_6_30,P1_6_32, P1_6_34, P1_6_36, P1_6_38, P1_6_40, P1_6_42, P1_6_44, P1_6_46, P1_6_48\n" +
"from tr_ple_meds1_6\n" +
"where\n" +
"  P1_6_10 = P1_6_12 and P1_6_10 = P1_6_14 and P1_6_10 = P1_6_16 and P1_6_10 = P1_6_18 and P1_6_10 = P1_6_20 and\n" +
"  P1_6_10 = P1_6_22 and P1_6_10 = P1_6_24 and P1_6_10 = P1_6_26 and P1_6_10 = P1_6_28 and P1_6_10 = P1_6_30 and\n" +
"  P1_6_10 = P1_6_32 and P1_6_10 = P1_6_34 and P1_6_10 = P1_6_36 and P1_6_10 = P1_6_38 and P1_6_10 = P1_6_40 and\n" +
"  P1_6_10 = P1_6_42 and P1_6_10 = P1_6_44 and P1_6_10 = P1_6_46 and P1_6_10 = P1_6_48\n" +
"or\n" +
"  P1_6_12 = P1_6_14 and P1_6_12 = P1_6_16 and P1_6_12 = P1_6_18 and P1_6_12 = P1_6_20 and P1_6_12 = P1_6_22 and\n" +
"  P1_6_12 = P1_6_24 and P1_6_12 = P1_6_26 and P1_6_12 = P1_6_28 and P1_6_12 = P1_6_30 and P1_6_12 = P1_6_32 and\n" +
"  P1_6_12 = P1_6_34 and P1_6_12 = P1_6_36 and P1_6_12 = P1_6_38 and P1_6_12 = P1_6_40 and P1_6_12 = P1_6_42 and\n" +
"  P1_6_12 = P1_6_44 and P1_6_12 = P1_6_46 and P1_6_12 = P1_6_48\n" +
"or\n" +
"  P1_6_14 = P1_6_16 and P1_6_14 = P1_6_18 and P1_6_14 = P1_6_20 and P1_6_14 = P1_6_22 and P1_6_14 = P1_6_24 and\n" +
"  P1_6_14 = P1_6_26 and P1_6_14 = P1_6_28 and P1_6_14 = P1_6_30 and P1_6_14 = P1_6_32 and P1_6_14 = P1_6_34 and\n" +
"  P1_6_14 = P1_6_36 and P1_6_14 = P1_6_38 and P1_6_14 = P1_6_40 and P1_6_14 = P1_6_42 and P1_6_14 = P1_6_44 and\n" +
"  P1_6_14 = P1_6_46 and P1_6_14 = P1_6_48\n" +
"or\n" +
"  P1_6_16 = P1_6_18 and P1_6_16 = P1_6_20 and P1_6_16 = P1_6_22 and P1_6_16 = P1_6_24 and P1_6_16 = P1_6_26 and\n" +
"  P1_6_16 = P1_6_28 and P1_6_16 = P1_6_30 and P1_6_16 = P1_6_32 and P1_6_16 = P1_6_34 and P1_6_16 = P1_6_36 and\n" +
"  P1_6_16 = P1_6_38 and P1_6_16 = P1_6_40 and P1_6_16 = P1_6_42 and P1_6_16 = P1_6_44 and P1_6_16 = P1_6_46 and\n" +
"  P1_6_16 = P1_6_48\n" +
"or\n" +
"  P1_6_18 = P1_6_20 and P1_6_18 = P1_6_22 and P1_6_18 = P1_6_24 and P1_6_18 = P1_6_26 and P1_6_18 = P1_6_28 and\n" +
"  P1_6_18 = P1_6_30 and P1_6_18 = P1_6_32 and P1_6_18 = P1_6_34 and P1_6_18 = P1_6_36 and P1_6_18 = P1_6_38 and\n" +
"  P1_6_18 = P1_6_40 and P1_6_18 = P1_6_42 and P1_6_18 = P1_6_44 and P1_6_18 = P1_6_46 and P1_6_18 = P1_6_48\n" +
"or\n" +
"  P1_6_20 = P1_6_22 and P1_6_20 = P1_6_24 and P1_6_20 = P1_6_26 and P1_6_20 = P1_6_28 and P1_6_20 = P1_6_30 and\n" +
"  P1_6_20 = P1_6_32 and P1_6_20 = P1_6_34 and P1_6_20 = P1_6_36 and P1_6_20 = P1_6_38 and P1_6_20 = P1_6_40 and\n" +
"  P1_6_20 = P1_6_42 and P1_6_20 = P1_6_44 and P1_6_20 = P1_6_46 and P1_6_20 = P1_6_48\n" +
"or\n" +
"  P1_6_22 = P1_6_24 and P1_6_22 = P1_6_26 and P1_6_22 = P1_6_28 and P1_6_22 = P1_6_30 and P1_6_22 = P1_6_32 and\n" +
"  P1_6_22 = P1_6_34 and P1_6_22 = P1_6_36 and P1_6_22 = P1_6_38 and P1_6_22 = P1_6_40 and P1_6_22 = P1_6_42 and\n" +
"  P1_6_22 = P1_6_44 and P1_6_22 = P1_6_46 and P1_6_22 = P1_6_48\n" +
"or\n" +
"  P1_6_24 = P1_6_26 and P1_6_24 = P1_6_28 and P1_6_24 = P1_6_30 and P1_6_24 = P1_6_32 and P1_6_24 = P1_6_34 and\n" +
"  P1_6_24 = P1_6_36 and P1_6_24 = P1_6_38 and P1_6_24 = P1_6_40 and P1_6_24 = P1_6_42 and P1_6_24 = P1_6_44 and\n" +
"  P1_6_24 = P1_6_46 and P1_6_24 = P1_6_48\n" +
"or\n" +
"  P1_6_26 = P1_6_28 and P1_6_26 = P1_6_30 and P1_6_26 = P1_6_32 and P1_6_26 = P1_6_34 and P1_6_26 = P1_6_36 and\n" +
"  P1_6_26 = P1_6_38 and P1_6_26 = P1_6_40 and P1_6_26 = P1_6_42 and P1_6_26 = P1_6_44 and P1_6_26 = P1_6_46 and\n" +
"  P1_6_26 = P1_6_48\n" +
"or\n" +
"  P1_6_28 = P1_6_30 and P1_6_28 = P1_6_32 and P1_6_28 = P1_6_34 and P1_6_28 = P1_6_36 and P1_6_28 = P1_6_38 and\n" +
"  P1_6_28 = P1_6_40 and P1_6_28 = P1_6_42 and P1_6_28 = P1_6_44 and P1_6_28 = P1_6_46 and P1_6_28 = P1_6_48\n" +
"or\n" +
"  P1_6_30 = P1_6_32 and P1_6_30 = P1_6_34 and P1_6_30 = P1_6_36 and P1_6_30 = P1_6_38 and P1_6_30 = P1_6_40 and\n" +
"  P1_6_30 = P1_6_42 and P1_6_30 = P1_6_44 and P1_6_30 = P1_6_46 and P1_6_30 = P1_6_48\n" +
"or\n" +
"  P1_6_32 = P1_6_34 and P1_6_32 = P1_6_36 and P1_6_32 = P1_6_38 and P1_6_32 = P1_6_40 and P1_6_32 = P1_6_42 and\n" +
"  P1_6_32 = P1_6_44 and P1_6_32 = P1_6_46 and P1_6_32 = P1_6_48\n" +
"or\n" +
"  P1_6_34 = P1_6_36 and P1_6_34 = P1_6_38 and P1_6_34 = P1_6_40 and P1_6_34 = P1_6_42 and P1_6_34 = P1_6_44 and\n" +
"  P1_6_34 = P1_6_46 and P1_6_34 = P1_6_48\n" +
"or\n" +
"  P1_6_36 = P1_6_38 and P1_6_36 = P1_6_40 and P1_6_36 = P1_6_42 and P1_6_36 = P1_6_44 and P1_6_36 = P1_6_46 and\n" +
"  P1_6_36 = P1_6_48\n" +
"or\n" +
"  P1_6_38 = P1_6_40 and P1_6_38 = P1_6_42 and P1_6_38 = P1_6_44 and P1_6_38 = P1_6_46 and P1_6_38 = P1_6_48\n" +
"or\n" +
"  P1_6_40 = P1_6_42 and P1_6_40 = P1_6_44 and P1_6_40 = P1_6_46 and P1_6_40 = P1_6_48\n" +
"or\n" +
"  P1_6_42 = P1_6_44 and P1_6_42 = P1_6_46 and P1_6_42 = P1_6_48\n" +
"or\n" +
"  P1_6_44 = P1_6_46 and P1_6_44 = P1_6_48\n" +
"or\n" +
"  P1_6_46 = P1_6_48 and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar una categoria en P1_6_50-AX(grupo_parlamentario) debido a P1_6_9-I(tipo_promovente_iniciativa_urgente_obvia) se selecciono "Grupo parlamentario" (4).
public ArrayList DCgrupo_parlamentario(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_50 from tr_ple_meds1_6 where P1_6_9 = 4 and P1_6_50 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoria en P1_6_50-AX(grupo_parlamentario) debido a P1_6_9-I(tipo_promovente_iniciativa_urgente_obvia) se selecciono una categoria diferente a "Grupo parlamentario" (4).
public ArrayList NDCgrupo_parlamentario(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_50 from tr_ple_meds1_6 where P1_6_9 <> 4 and P1_6_50 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe especificar  la categoria en P1_6_51-AY(varios_grupos_parlamentarios_especifique_1) debido a P1_6_50-AX(grupo_parlamentario) se selecciono "Varios" (88).
public ArrayList DCvarios_grupos_parlamentarios_especifique_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_50, P1_6_51, P1_6_52, P1_6_53\n" +
"from tr_ple_meds1_6\n" +
"where P1_6_50 = ID_ENTIDAD || 88 --se concatena para saber las entidades que tienen seleccionado la opcion de varios\n" +
"and  P1_6_51 is null\n" +
"and (P1_6_52 is null or P1_6_53 is null)  and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe especificar  la categoria en P1_6_51-AY(varios_grupos_parlamentarios_especifique_1) debido a P1_6_50-AX(grupo_parlamentario) se selecciono una categoria diferente a "Varios" (88). 
public ArrayList NDCvarios_grupos_parlamentarios_especifique_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_50, P1_6_51, P1_6_52, P1_6_53\n" +
"from tr_ple_meds1_6\n" +
"where P1_6_50 <> ID_ENTIDAD || 88 --se concatena para saber las entidades que tienen seleccionado la opcion de varios\n" +
"and  P1_6_51 is not null\n" +
"and (P1_6_52 is not null or P1_6_53 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se puede seleccionar la categoria  "Varios"  (88) en P1_6_51-AY(varios_grupos_parlamentarios_especifique_1), P1_6_52-AZ(varios_grupos_parlamentarios_especifique_2) y P1_6_53-BA(varios_grupos_parlamentarios_especifique_3).
public ArrayList DCvarios_grupos_parlamentarios_Varios(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_51, P1_6_52, P1_6_53 from tr_ple_meds1_6 where P1_6_51 = ID_ENTIDAD || 88 and P1_6_52 = ID_ENTIDAD || 88 and P1_6_53 = ID_ENTIDAD || 88 and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se puede repetir el grupo parlamentario seleccionado en las columnas P1_6_51-AY(varios_grupos_parlamentarios_especifique_1), P1_6_52-AZ(varios_grupos_parlamentarios_especifique_2) y P1_6_53-BA(varios_grupos_parlamentarios_especifique_3).
public ArrayList NDCvarios_grupos_parlamentarios_Varios(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_51, P1_6_52, P1_6_53 from tr_ple_meds1_6 where P1_6_51 = P1_6_52 and P1_6_51 = P1_6_53 or P1_6_52 = P1_6_53 and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar una categoria en P1_6_54-BB(ID_comision_legislativa_1) y P1_6_55-BC(nombre_comision_legislativa_1) debido a P1_6_9-I(tipo_promovente_iniciativa_urgente_obvia) se selecciono "Comisión legislativa" (5).
public ArrayList DCnombre_comision_legislativa_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_54, P1_6_55 from tr_ple_meds1_6 where P1_6_9 = 5 and (P1_6_64 is not null and P1_6_55 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No debe seleccionar una categoria en P1_6_54-BB(ID_comision_legislativa_1) y P1_6_55-BC(nombre_comision_legislativa_1) debido a P1_6_9-I(tipo_promovente_iniciativa_urgente_obvia) se selecciono una categoria diferente a "Comisión legislativa" (5).
public ArrayList NDCnombre_comision_legislativa_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_54, P1_6_55 from tr_ple_meds1_6 where P1_6_9 <> 5 and (P1_6_54 is not null and P1_6_65 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe capturar información en P1_6_54-BB(ID_comision_legislativa_1) o P1_6_55-BC(nombre_comision_legislativa_1) debido a que se selecciono una categoría en cualquiera de las ya mencionadas.
public ArrayList nombre_comision_legislativa_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_54, P1_6_55 from tr_ple_meds1_6 where (P1_6_54 is null and P1_6_55 is not null) or (P1_6_54 is not null and P1_6_55 is null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar una categoria en P1_6_56-BD(ID_comision_legislativa_2) y P1_6_57-BE(nombre_comision_legislativa_2) debido a P1_6_55-BC(nombre_comision_legislativa_1) se selecciono una categoria.
public ArrayList DCID_comision_legislativa_2(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_55, P1_6_56, P1_6_57 from tr_ple_meds1_6 where P1_6_55 is not null and (P1_6_56 is not null and P1_6_57 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoria en P1_6_56-BD(ID_comision_legislativa_2) y P1_6_57-BE(nombre_comision_legislativa_2) debido a P1_6_55-BC(nombre_comision_legislativa_1) no se selecciono una categoria.
public ArrayList NDCID_comision_legislativa_2(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_55, P1_6_56, P1_6_57 from tr_ple_meds1_6 where P1_6_55 is null and (P1_6_56 is not null and P1_6_57 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe capturar información en P1_6_56-BD(ID_comision_legislativa_2) o P1_6_57-BE(nombre_comision_legislativa_2) debido a que se selecciono una categoría en cualquiera de las ya mencionadas.
public ArrayList ID_comision_legislativa_2(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_55, P1_6_56, P1_6_57 from tr_ple_meds1_6  where (P1_6_56 is null and P1_6_57 is not null) or (P1_6_56 is not null and P1_6_57 is null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se puede repetir el identificar de las comisiones legislativas en P1_6_54-BB(ID_comision_legislativa_1), P1_6_56-BD(ID_comision_legislativa_2) y P1_6_58-BF(ID_comision_legislativa_3).
public ArrayList NCID_comision_legislativa_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_54, P1_6_56, P1_6_58 from tr_ple_meds1_6 where P1_6_54 = P1_6_56 or P1_6_54 = P1_6_58 or P1_6_56 = P1_6_58 and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//No se puede repetir la comisión legislativa en P1_6_55-BC(nombre_comision_legislativa_1), P1_6_57-BE(nombre_comision_legislativa_2) y P1_6_59-BG(nombre_comision_legislativa_3). 
public ArrayList REP_comision_legislativa_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_55, P1_6_57, P1_6_59 from tr_ple_meds1_6 where P1_6_55 = P1_6_57 or P1_6_55 = P1_6_59 or P1_6_57 = P1_6_59 and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No se puede repetir la comisión legislativa en P1_6_55-BC(nombre_comision_legislativa_1), P1_6_57-BE(nombre_comision_legislativa_2) y P1_6_59-BG(nombre_comision_legislativa_3). 
public ArrayList comision_legislativa_1(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_55, P1_6_57, P1_6_59 from tr_ple_meds1_6 where P1_6_55 = P1_6_57 or P1_6_55 = P1_6_59 or P1_6_57 = P1_6_59 and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe seleccionar una categoria en P1_6_58-BF(ID_comision_legislativa_3) y P1_6_59-BG(nombre_comision_legislativa_3) debido a P1_6_57-BE(nombre_comision_legislativa_2) se selecciono una categoria.
public ArrayList DCID_comision_legislativa_3(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_57, P1_6_58, P1_6_59 from tr_ple_meds1_6 where P1_6_57 is not null and (P1_6_58 is not null and P1_6_59 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoria en P1_6_58-BF(ID_comision_legislativa_3) y P1_6_59-BG(nombre_comision_legislativa_3) debido a P1_6_57-BE(nombre_comision_legislativa_2) no se selecciono una categoria.
public ArrayList NDCID_comision_legislativa_3(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_57, P1_6_58, P1_6_59 from tr_ple_meds1_6 where P1_6_57 is null and (P1_6_58 is not null and P1_6_59 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe capturar información en P1_6_58-BF(ID_comision_legislativa_3) o P1_6_59-BG(nombre_comision_legislativa_3) debido a que se selecciono una categoría en cualquiera de las ya mencionadas.
public ArrayList nombre_comision_legislativa_3(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_57, P1_6_58, P1_6_59 from tr_ple_meds1_6  where (P1_6_58 is null and P1_6_59 is not null) or (P1_6_58 is not null and P1_6_59 is null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe seleccionar una categoria en P1_6_61-BI(ayuntamiento) y P1_6_60-BH(AGEM) debido a P1_6_9-I(tipo_promovente_iniciativa_urgente_obvia) se selecciono "Ayuntamientos" (9).
public ArrayList DCayuntamiento(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_60, P1_6_61 from tr_ple_meds1_6 where P1_6_9 = 9 and (P1_6_61 is null and P1_6_60 is null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoria en P1_6_60-BH(AGEM) y P1_6_60-BH(AGEM) debido a P1_6_9-I(tipo_promovente_iniciativa_urgente_obvia) se selecciono una categoria diferente a "Ayuntamientos" (9).
public ArrayList NDCayuntamiento(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_60, P1_6_61 from tr_ple_meds1_6 where P1_6_9 <> 9 and (P1_6_60 is not null and P1_6_61 is not null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe capturar información en P1_6_60-BH(AGEM) o P1_6_60-BH(AGEM) debido a que se selecciono una categoría en cualquiera de las ya mencionadas.
public ArrayList AGEM(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_60, P1_6_61 from tr_ple_meds1_6 where (P1_6_60 is null and P1_6_61 is not null) or (P1_6_60 is not null and P1_6_61 is null) and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe seleccionar una categoria en P1_6_62-BJ(tipo_organo_constitucional_autonomo) debido a P1_6_9-I(tipo_promovente_iniciativa_urgente_obvia) se selecciono "Órgano constitucional autónomo" (10).
public ArrayList DCtipo_organo_constitucional_autonomo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_62 from tr_ple_meds1_6 where P1_6_9 = 10 and P1_6_62 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe seleccionar una categoria en P1_6_62-BJ(tipo_organo_constitucional_autonomo) debido a P1_6_9-I(tipo_promovente_iniciativa_urgente_obvia) se selecciono una categoria diferente a "Órgano constitucional autónomo" (10).
public ArrayList NDCtipo_organo_constitucional_autonomo(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_62 from tr_ple_meds1_6 where P1_6_9 <> 10 and P1_6_62 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//Debe espeficar el otro organo consitutucional en P1_6_63-BK(otro_tipo_organo_constitucional_autonomo_especifique) debido a P1_6_62-BJ(tipo_organo_constitucional_autonomo) se selecciono la categoria "Otro órgano constitucional autónomo (específique)" (7).
public ArrayList DCotro_tipo_organo_constitucional_autonomo_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_62, P1_6_63 from tr_ple_meds1_6 where P1_6_62 = 7 and P1_6_63 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe especificar el organo en P1_6_63-BK(otro_tipo_organo_constitucional_autonomo_especifique) debido a P1_6_62-BJ(tipo_organo_constitucional_autonomo) se selecciono una categoria diferente a  "Otro órgano constitucional autónomo (específique)" (7).
public ArrayList otro_tipo_organo_constitucional_autonomo_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_62, P1_6_63 from tr_ple_meds1_6 where P1_6_62 <> 7 and P1_6_63 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe espeficar el otro organo consitutucional en P1_6_64-BL(otro_tipo_promovente_iniciativa_urgente_obvia_especifique) debido a P1_6_9-I(tipo_promovente_iniciativa_urgente_obvia). se selecciono la categoria "Otro tipo de promovente (especifique)" (11).
public ArrayList otro_tipo_promovente_iniciativa_urgente_obvia_especifique(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_9, P1_6_9, P1_6_64 from tr_ple_meds1_6 where P1_6_9 = 11 and P1_6_64 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//La fecha registrada en P1_6_66-BN(fecha_resolucion_pleno_iniciativa_urgente_obvia) debe ser igual o mayor en a la fecha registrada en P1_6_6-F(fecha_sesion_presentacion_iniciativa_urgente_obvia).
public ArrayList fecha_resolucion_pleno_iniciativa_urgente_obvia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_6, P1_6_66\n" +
"from tr_ple_meds1_6\n" +
"where to_date (P1_6_66, 'dd/mm/yyyy') < to_date (P1_6_6, 'dd/mm/yyyy') and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//En la columna P1_6_67-BO(sentido_resolucion_pleno_iniciativa_urgente_obvia) unicamante puede seleccionar "Desechado"  (1) debido a P1_6_3-C(estatus_iniciativa_urgente_obvia) se selecciono "Desechada o improcedente" (2).
public ArrayList sentido_resolucion_pleno_iniciativa_urgente_obvia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_3, P1_6_67 from tr_ple_meds1_6 where P1_6_3 = 1 and P1_6_67 <> 1 and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//En la columna P1_6_67-BO(sentido_resolucion_pleno_iniciativa_urgente_obvia) unicamante puede seleccionar "Aprobado"  (2) debido a P1_6_3-C(estatus_iniciativa_urgente_obvia) se selecciono "Aprobada o procedente" (2).
public ArrayList NDCsentido_resolucion_pleno_iniciativa_urgente_obvia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_3, P1_6_67 from tr_ple_meds1_6 where P1_6_3 = 2 and P1_6_67 <> 2 and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//En la columna P1_6_68-BP(total_votaciones_pleno_iniciativa_urgente_obvia) debe ser igual o menor a la suma de las cantidades reportadas en las columnas "P1_1_5(distritos_uninominales)" y "P1_1_6(diputaciones_plurinominales)" de la tabla datos_generales.
public ArrayList total_votaciones_pleno_iniciativa_urgente_obvia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select iu.ID_ENTIDAD, iu.ENTIDAD, iu.C1_6_ID, iu.P1_6_1, iu.P1_6_68, dg.P1_1_5, dg.P1_1_6, dg.P1_1_5 + dg.P1_1_6 as total from tr_ple_meds1_6 iu inner join tr_ple_meds1_1 dg on iu.ID_ENTIDAD = dg.ID_ENTIDAD and iu.C1_6_ID = dg.C1_1_ID where iu.P1_6_68 > dg.P1_1_5 + dg.P1_1_6 and (iu.ID_ENTIDAD="+ID_entidad+" AND iu.Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//En la columna P1_6_68-BP(total_votaciones_pleno_iniciativa_urgente_obvia) debe ser igual a la suma de las cantidades reportadas en las columnas P1_6_69-BQ(votaciones_pleno_a_favor_iniciativa_urgente_obvia), P1_6_70-BR(votaciones_pleno_en_contra_iniciativa)_urgente_obvia) y P1_6_71-BS(votaciones_pleno_abstencion_iniciativa_urgente_obvia).
public ArrayList NItotal_votaciones_pleno_iniciativa_urgente_obvia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_69, P1_6_70, P1_6_71,P1_6_69 + P1_6_70 + P1_6_71 as total, P1_6_68 from tr_ple_meds1_6 where P1_6_68 <> P1_6_69 + P1_6_70 + P1_6_71 and P1_6_68 not in ('-1', '-2', '-3') and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }


//Debe introducir un dato en P1_6_74-BV(fecha_publicacion_gaceta_oficial_iniciativa_urgente_obvia) debido a P1_6_73-BU(sentido_resolucion_ejecutivo_iniciativa_urgente_obvia) se selecciono "Aprobada" (1).
public ArrayList fecha_publicacion_gaceta_oficial_iniciativa_urgente_obvia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_73, P1_6_74 from tr_ple_meds1_6 where P1_6_73 = 1 and P1_6_74 is null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//No debe introducir un dato en P1_6_74-BV(fecha_publicacion_gaceta_oficial_iniciativa_urgente_obvia) debido a P1_6_73-BU(sentido_resolucion_ejecutivo_iniciativa_urgente_obvia) se selecciono una categoria diferente a "Aprobada" (1).
public ArrayList NDCfecha_publicacion_gaceta_oficial_iniciativa_urgente_obvia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_73, P1_6_74 from tr_ple_meds1_6 where P1_6_73 <> 1 and P1_6_74 is not null and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

//La fecha registrada en P1_6_74-BV(fecha_publicacion_gaceta_oficial_iniciativa_urgente_obvia) debe ser igual o mayor en a la fecha registrada en P1_6_72-BT(fecha_remision_ejecutivo_iniciativa_urgente_obvia).
public ArrayList NDfecha_publicacion_gaceta_oficial_iniciativa_urgente_obvia(String ID_entidad,String Legislatura,String Envio){
     conexion.Conectar();
      Array = new ArrayList();
      sql="select ID_ENTIDAD, ENTIDAD, C1_6_ID, P1_6_1, P1_6_72, P1_6_74\n" +
"from tr_ple_meds1_6\n" +
"where to_date (P1_6_74, 'dd/mm/yyyy') < to_date (P1_6_74, 'dd/mm/yyyy') and (ID_ENTIDAD="+ID_entidad+" AND Legislatura="+Legislatura+" AND C1_6_ID='"+Envio+"')";
      System.out.println(sql);
      resul=conexion.consultar(sql);
      try {
          while (resul.next()) {
              Array.add(new String[]{
                  resul.getString("ID_ENTIDAD"),
                  resul.getString("P1_6_1")
                });
          }
      conexion.close();
     } catch (SQLException ex) {
            Logger.getLogger(QComparecencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    return Array;
 }

}
