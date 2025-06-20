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
public class QIniciativas {
 
    DaoConexion conexion = new DaoConexion();
    String sql, NMunicipio;
    ArrayList<String[]> Array;
    ResultSet resul;

    public ArrayList Estructura_ID(String ID_entidad, String Legislatura, String envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "WITH ESTRUCTURA_ID AS (\n" +
" SELECT tr.C1_5_ID, TO_ROMAN(tr.legislatura) AS LEGIS_ROMAN, tr.legislatura,\n" +
" tr.ENTIDAD, tr.P1_5_1, tr_1.estatus AS estatus,\n" +
" 'IN_' || TO_ROMAN(tr.legislatura) || '_' || tr.ENTIDAD || '_' || tr.P1_5_5 AS ID_ESTRUCTURA_Correcta,\n" +
" tr.P1_5_5 AS TURNO_LEGISLATURA\n" +
" FROM TR_PLE_MEDS1_5 tr FULL JOIN TR_PLE_MEDS1_1_ tr_1 ON tr_1.ID_ENTIDAD = tr.id_entidad AND tr_1.LEGISLATURA = tr.LEGISLATURA AND tr_1.C1_1_ID = tr.C1_5_ID)\n" +
"SELECT C1_5_ID AS ENVIO, legislatura, LEGIS_ROMAN, ENTIDAD, TURNO_LEGISLATURA, ID_ESTRUCTURA_Correcta, P1_5_1 AS ID_actual, estatus\n" +
"FROM ESTRUCTURA_ID\n" +
"WHERE ( SUBSTR(P1_5_1, INSTR(P1_5_1, '_', 1, 2) + 1)  <> SUBSTR(ID_ESTRUCTURA_Correcta, INSTR(ID_ESTRUCTURA_Correcta, '_', 1, 2) + 1)     )"+
                " AND (ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + envio + "')";;
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ENTIDAD"),
                    resul.getString("ID_ACTUAL")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QIniciativas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Array;
    }
    //La estructura del ID no coincide con el numero_legislatura_presentacion_iniciativa (D), ya que se indica en cond_presentacion_iniciativa_legislatura_actual(B) que se presentó la iniciativa en una legislatura anterior

     public ArrayList Estructura_ID_legislatura_anterior(String ID_entidad, String Legislatura, String envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT C1_5_ID, legislatura, ENTIDAD, TO_ROMAN(p1_5_4) AS LEGIS_presentacion, P1_5_1 AS ID_actual,\n" +
"    'IN_' || TO_ROMAN(p1_5_4) || '_' || ENTIDAD || '_' || P1_5_5 AS ID_ESTRUCTURA_Correcta, p1_5_2 AS presento_en_legislatura_actual\n" +
"FROM TR_PLE_MEDS1_5 \n" +
"WHERE  (p1_5_2 = 2 AND ('IN_' || TO_ROMAN(p1_5_4) || '_' || ENTIDAD || '_' || P1_5_5) <> P1_5_1) "+
                " AND (ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + envio + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ENTIDAD"),
                    resul.getString("ID_ACTUAL")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QIniciativas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Array;
    }
    
    public ArrayList Iniciativas_EstatusAprobado(String ID_entidad, String Legislatura, String envio, String envio_anterior) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "";
        //IF ENVIO ACTUAL ES MAYOR A ENVIO ANTERIOR
        
       if (Double.valueOf(envio) > Double.valueOf(envio_anterior)) {
            sql = "SELECT * FROM(\n"
                    + "SELECT COUNT(P1_5_1) AS CONTEO,P1_5_1 as ID_ACTUAL,ID_ENTIDAD FROM( \n"
                    + "SELECT ID_ENTIDAD,C1_5_ID,P1_5_1,P1_5_8 FROM TR_PLE_MEDS1_5\n"
                    + "WHERE ID_ENTIDAD='" + ID_entidad + "' AND C1_5_ID='" + envio_anterior + "' AND P1_5_8=7---PARAMETRO COMBO ENVIO ANTERIOR C1_5_ID\n"
                    + "UNION ALL\n"
                    + "SELECT ID_ENTIDAD,C1_5_ID,P1_5_1,P1_5_8 FROM TR_PLE_MEDS1_5\n"
                    + "WHERE ID_ENTIDAD='" + ID_entidad + "' AND C1_5_ID='" + envio + "' AND P1_5_8<>7)---PARAMETRO COMBO ENVIO ACTUAL C1_5_ID\n"
                    + "GROUP BY ID_ENTIDAD,P1_5_1) WHERE CONTEO>1";
        }

        if (Double.valueOf(envio) < Double.valueOf(envio_anterior)) {
            sql = "SELECT * FROM(\n"
                    + "SELECT COUNT(P1_5_1) AS CONTEO,ID_ENTIDAD,P1_5_1 as ID_ACTUAL FROM( \n"
                    + "SELECT ID_ENTIDAD,C1_5_ID,P1_5_1,P1_5_8 FROM TR_PLE_MEDS1_5\n"
                    + "WHERE ID_ENTIDAD='" + ID_entidad + "' AND C1_5_ID='" + envio + "' AND P1_5_8=7 ---PARAMETRO COMBO ENVIO ACTUAL C1_5_ID\n"
                    + "UNION ALL\n"
                    + "SELECT ID_ENTIDAD,C1_5_ID,P1_5_1,P1_5_8 FROM TR_PLE_MEDS1_5\n"
                    + "WHERE ID_ENTIDAD='" + ID_entidad + "' AND C1_5_ID='" + envio_anterior + "' AND P1_5_8<>7) ---PARAMETRO COMBO ENVIO ANTERIOR C1_5_ID\n"
                    + "GROUP BY ID_ENTIDAD,P1_5_1) WHERE CONTEO>1";
        }

        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("ID_ACTUAL")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QIniciativas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Array;
    }

    public ArrayList Iniciativas_Acumuladas(String ID_entidad, String Legislatura) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT * FROM(\n"
                + "SELECT * FROM (\n"
                + "select t.ID_ENTIDAD, C1_5_ID envio,trP.P1_1_7 AÑO_LEGISLATURA, P1_5_1 ID_iniciativa , s.DESCRIPCION as cond_presentacion_iniciativa_legislatura_actual, \n"
                + "p.DESCRIPCION as  cond_presentacion_iniciativa_periodo, P1_5_4 numero_legislatura_presentacion_iniciativa, P1_5_5 turno_iniciativa\n"
                + ", P1_5_6 cond_actualizacion_estatus_iniciativa_periodo, P1_5_7 cond_modificacion_informacion_ingreso_periodo, es.DESCRIPCION as estatus_iniciativa,\n"
                + "P1_5_9 otro_estatus_iniciativa_especifique, ini.descripcion as etapa_procesal_iniciativaLlegisla,t.legislatura  from (\n"
                + "SELECT ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_2, P1_5_3, P1_5_4, P1_5_5, P1_5_6, P1_5_7, P1_5_8, \n"
                + "P1_5_9, P1_5_10,legislatura FROM TR_PLE_MEDS1_5 WHERE P1_5_1 IN (\n"
                + "SELECT  P1_5_1\n"
                + "FROM TR_PLE_MEDS1_5\n"
                + "WHERE ID_ENTIDAD='" + ID_entidad + "'\n"
                + "and Legislatura='" + Legislatura + "'\n"
                + "GROUP BY P1_5_1\n"
                + "HAVING COUNT(P1_5_1) > 1)\n"
                + "ORDER BY ID_ENTIDAD,P1_5_1,C1_5_ID) t inner join TC_ESTATUS_INICIATIVA es on es.id=t.P1_5_8\n"
                + "inner join TC_PREG_SALTO s on s.id=t.P1_5_2\n"
                + "inner join TC_PREG_SALTO p on p.id=t.P1_5_3\n"
                + "left join TC_ETAPA_PROCESAL_INICIATIVA ini on ini.ID= t.P1_5_10\n"
                + "left join TR_PLE_MEDS1_1 trP on trP.id_entidad=t.id_entidad and trP.C1_1_ID=t.C1_5_ID) \n"
                + "ORDER BY ID_INICIATIVA,AÑO_LEGISLATURa)";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("ID_INICIATIVA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QIniciativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    public ArrayList Iniciativas_Duplicadas(String ID_entidad, String Legislatura, String envio, String envio_anterior) {
        conexion.Conectar();
        Array = new ArrayList();
        if (!envio_anterior.equals(envio)) {
        sql = "select * from(  \n" +
"select count(ID_ACTUAL) as conteo, ID_ACTUAL,presenta_periodo, ESTATUS_ACTUAL, ID_ENTIDAD from( \n" +
"select ID_ENTIDAD AS ID_ENTIDAD, C1_5_ID AS C1_5_ID1, p1_5_1 AS ID_ACTUAL, PRESENTO_INICIATIVA_PERIODO.descripcion as presenta_periodo,TC_ESTATUS.descripcion AS ESTATUS_ACTUAL\n" +
"FROM TR_PLE_MEDS1_5 TR\n" +
"INNER JOIN TC_PREG_SALTO PRESENTO_INICIATIVA_PERIODO ON TR.P1_5_3 = PRESENTO_INICIATIVA_PERIODO.id\n" +
"FULL JOIN TC_ESTATUS_INICIATIVA TC_ESTATUS ON TR.P1_5_8 = TC_ESTATUS.id\n" +
"WHERE ID_ENTIDAD=" + ID_entidad + " AND C1_5_ID='" + envio + "'--parametro actual\n" +
"UNION ALL\n" +
"select ID_ENTIDAD AS ID_ENTIDAD, C1_5_ID AS C1_5_ID1, p1_5_1 AS ID_ACTUAL, PRESENTO_INICIATIVA_PERIODO.descripcion as presenta_periodo,TC_ESTATUS.descripcion AS ESTATUS_ACTUAL\n" +
"FROM TR_PLE_MEDS1_5 TR\n" +
"INNER JOIN TC_PREG_SALTO PRESENTO_INICIATIVA_PERIODO ON TR.P1_5_3 = PRESENTO_INICIATIVA_PERIODO.id\n" +
"FULL JOIN TC_ESTATUS_INICIATIVA TC_ESTATUS ON TR.P1_5_8 = TC_ESTATUS.id\n" +
"WHERE ID_ENTIDAD=" + ID_entidad + " AND C1_5_ID='" + envio_anterior + "') --parametro anterior\n" +
"group by ID_ENTIDAD, ID_ACTUAL,presenta_periodo, ESTATUS_ACTUAL) where conteo>1 ";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("ID_ACTUAL")
                });
            } 
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QIniciativas.class.getName()).log(Level.SEVERE, null, ex);
        }
}
        return Array;
    }

    

//El campo P1_5_3-C(cond_presentacion_iniciativa_periodo) no se debe de capturar debido a que en la columna cond_presentacion_iniciativa_legislatura_actual (P1_5_2) se selecciono la opcion "NO" '2'
    public ArrayList cond_presentacion_iniciativa_periodo(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_2, P1_5_3 from TR_PLE_MEDS1_5 where P1_5_2=2 and  P1_5_3 IS NOT NULL"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Se debe de capturar los campos P1_5_4-D(numero_legislatura_presentacion_iniciativa), P1_5_6-F(cond_actualizacion_estatus_iniciativa_periodo),  P1_5_7-G(cond_modificacion_informacion_ingreso_periodo) debido a que se selecciono "No" en la columna cond_presentacion_iniciativa_legislatura_actual (P1_5_2).
    public ArrayList DCnumero_legislatura_presentacion_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_2, P1_5_4, P1_5_6, P1_5_7 from TR_PLE_MEDS1_5 where P1_5_2=2 and  (P1_5_4 is null or P1_5_6 is null or P1_5_7 is null)"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }


    
//No Se deben de capturar los campos P1_5_4-D(numero_legislatura_presentacion_iniciativa), P1_5_6-F(cond_actualizacion_estatus_iniciativa_periodo),  P1_5_7-G(cond_modificacion_informacion_ingreso_periodo) debido a que se selecciono una opcion diferente a "No" en la columna cond_presentacion_iniciativa_legislatura_actual (P1_5_2).
    public ArrayList NDCnumero_legislatura_presentacion_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_2, P1_5_4, P1_5_6, P1_5_7 from TR_PLE_MEDS1_5 where P1_5_3<>2 and  (P1_5_4 is NOT null or P1_5_6 is NOT null or P1_5_7 is NOT null)"
                + " AND (ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    
    //Las iniciativas no tienen en ningún envío la condición de haber sido presentadas en el periodo reportado (C) cond_presentacion_iniciativa_periodo='Sí'
    public ArrayList cond_presentacion_iniciativa_periodo_si(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT DISTINCT ID_ENTIDAD, P1_5_1, legislatura FROM TR_PLE_MEDS1_5_\n" +
"WHERE (P1_5_1 NOT IN (SELECT P1_5_1 FROM TR_PLE_MEDS1_5_ WHERE ID_ENTIDAD= "+ ID_entidad + " AND P1_5_3=1) )\n" +
"and  ID_ENTIDAD=" + ID_entidad+ " AND Legislatura=" + Legislatura ;
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
//No se debe de capturar el campo P1_5_8-H(estatus_iniciativa) debido a que se capturo "No" en la columna cond_actualizacion_estatus_iniciativa_periodo (P1_5_6).
    public ArrayList NDCestatus_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_6, P1_5_8 from TR_PLE_MEDS1_5 where P1_5_6=2 and  P1_5_8 is not null"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
// se debe de capturar el campo P1_5_8-H(estatus_iniciativa) 
    public ArrayList estatus_iniciativa_NN(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_6, P1_5_8 from TR_PLE_MEDS1_5 where ( (P1_5_6<>2  OR P1_5_6 IS NULL) and  P1_5_8 is null )"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
//Se debe de capturar el campo  P1_5_8-H(estatus_iniciativa) debido a que se capturo diferente de "No" en la columna cond_actualizacion_estatus_iniciativa_periodo (P1_5_6).
    public ArrayList DCestatus_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_6, P1_5_8 from TR_PLE_MEDS1_5 where P1_5_6<>2 and  P1_5_8 is null"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//P1_5_9-I(otro_estatus_iniciativa_especifique) Debe especificar el otro estatus de la iniciativa debido a que P1_5_8-H(estatus_iniciativa) se selecciono "Otro estatus (especifique)"'8' 
    public ArrayList DCotro_estatus_iniciativa_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_8, P1_5_9 from TR_PLE_MEDS1_5 where P1_5_8=8 and  P1_5_9 is null"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//P1_5_9-I(otro_estatus_iniciativa_especifique) No se debe especificar el otro estatus de la iniciativa debido a que P1_5_8-H(estatus_iniciativa) no se selecciono "Otro estatus (especifique)"'8' 
    public ArrayList NDCotro_estatus_iniciativa_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_8, P1_5_9 from TR_PLE_MEDS1_5 where P1_5_8<>8 and  P1_5_9 is NOT null"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Se debe de capturar el campo P1_5_10-J(etapa_procesal_iniciativa) debido a que se selecciono  "Estudio"'2' o "Dictamen"'5' en la columna estatus_iniciativa  (P1_5_8).
    public ArrayList DCetapa_procesal_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_8, P1_5_10 from TR_PLE_MEDS1_5 where P1_5_8 in (2,5) and  P1_5_10 is null"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No se debe de capturar el campo P1_5_10-J(etapa_procesal_iniciativa) debido a que no se selecciono  "Estudio"'2' o "Dictamen"'5' en la columna estatus_iniciativa  (P1_5_8).
    public ArrayList NDCetapa_procesal_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_8, P1_5_10 from TR_PLE_MEDS1_5 where P1_5_8 NOT in (2,5) and  P1_5_10 is NOT null"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//En caso de que haya seleccionado la categoría "Estudio" en la columna P1_5_8-H(estatus_iniciativa), únicamente puede seleccionar la categoría "Primer estudio" o "Segundo estudio" en la columna P1_5_10-J(etapa_procesal_iniciativa)
    public ArrayList Estudio(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_8, P1_5_10 from TR_PLE_MEDS1_5 where P1_5_8=2 and  P1_5_10 not in (1,2)"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//En caso de que haya seleccionado la categoría "Dictamen" en la columna P1_5_8-H(estatus_iniciativa), únicamente puede seleccionar las categorías "Primer dictamen" y "Segundo dictamen" en la columna P1_5_10-J(etapa_procesal_iniciativa)
    public ArrayList Dictamen(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_8, P1_5_10 from TR_PLE_MEDS1_5 where P1_5_8=5 and  P1_5_10 NOT in(3,4)"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//En caso de que haya seleccionado la categoría "Dictamen" en la columna P1_5_8-H(estatus_iniciativa), únicamente puede seleccionar las categorías "Primer dictamen" y "Segundo dictamen" en la columna P1_5_10-J(etapa_procesal_iniciativa)
    public ArrayList DCDictamen(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_8, P1_5_10 from TR_PLE_MEDS1_5 where P1_5_8=5 and  P1_5_10 NOT in(3,4)"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
//El nombre de la iniciativa (L) no coincide con el nombre reportado en envíos anteriores
    public ArrayList Nombre_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT t1.p1_5_1 AS ID_Legislatura, MIN(t1.C1_5_ID) AS C1_5_ID, MIN(t1.legislatura) AS legislatura,\n" +
        " MIN(t1.ENTIDAD) AS ENTIDAD, MIN(TRIM(UPPER(t1.p1_5_12))) AS nombre_INICIATIVA, COUNT(*) AS total_envios\n" +
        "  FROM TR_PLE_MEDS1_5 t1\n" +
        "  WHERE EXISTS ( SELECT 1 FROM TR_PLE_MEDS1_5 t2 WHERE t1.p1_5_1 = t2.p1_5_1 AND NLSSORT(TRIM(UPPER(t1.p1_5_12)), 'NLS_SORT=BINARY_AI') <> NLSSORT(TRIM(UPPER(t2.p1_5_12)), 'NLS_SORT=BINARY_AI'))\n" +
        "    AND t1.ENTIDAD =" + ID_entidad + " AND t1.p1_5_1 IN ( SELECT DISTINCT p1_5_1 FROM TR_PLE_MEDS1_5 WHERE C1_5_ID ='" + Envio + "' AND ENTIDAD =" + ID_entidad + " )\n" +
        "    GROUP BY t1.p1_5_1" ;
      
                
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ENTIDAD"),
                    resul.getString("ID_Legislatura")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
//no se pueden capturar los campos P1_5_11-K(fecha_ingreso_iniciativa_oficialia_partes),P1_5_12-L(nombre_iniciativa),P1_5_13-M(fecha_sesion_presentacion_iniciativa),P1_5_14-N(tipo_iniciativa),P1_5_16-P(tipo_promovente_iniciativa),P1_5_73-BU(cond_adhesion_iniciativa)  debido a que en la columna cond_modificacion_informacion_ingreso_periodo (P1_5_7) se capturo NO '2'
    public ArrayList fecha_ingreso_iniciativa_oficialia_partes(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, \n"
                + "C1_5_ID, P1_5_1,P1_5_7, \n"
                + "P1_5_11,P1_5_12,P1_5_13,P1_5_14,P1_5_16,P1_5_73 \n"
                + "from TR_PLE_MEDS1_5 where P1_5_7=2 and  (P1_5_11 is not null or P1_5_12 is not null or P1_5_13 is not null or P1_5_14 is not null or P1_5_16 is not null or P1_5_73 is not null)"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Se deben de capturar los campos P1_5_11-K(fecha_ingreso_iniciativa_oficialia_partes),P1_5_12-L(nombre_iniciativa),P1_5_13-M(fecha_sesion_presentacion_iniciativa),P1_5_14-N(tipo_iniciativa),P1_5_16-P(tipo_promovente_iniciativa),P1_5_73-BU(cond_adhesion_iniciativa)  debido a que en la columna cond_modificacion_informacion_ingreso_periodo (P1_5_7) NO se capturo NO '2'
    public ArrayList NDCfecha_ingreso_iniciativa_oficialia_partes(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, \n"
                + "C1_5_ID, P1_5_1,P1_5_7, \n"
                + "P1_5_11,P1_5_12,P1_5_13,P1_5_14,P1_5_16,P1_5_73 \n"
                + "from TR_PLE_MEDS1_5 where P1_5_7<>2 and  (P1_5_11 is null or P1_5_12 is null or P1_5_13 is null or P1_5_14 is null or P1_5_16 is null or P1_5_73 is null)"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//P1_5_11-K(fecha_ingreso_iniciativa_oficialia_partes)Debe ser igual o menor a la fecha registrada en la columna P1_1_9(fecha_termino_informacion_reportada) de la tabla datos_generales.
    public ArrayList NNfecha_ingreso_iniciativa_oficialia_partes(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = " select  c.ID_ENTIDAD, c.ENTIDAD, \n"
                + "c.C1_5_ID, c.P1_5_1, \n"
                + "c.P1_5_11, u.p1_1_9\n"
                + "from TR_PLE_MEDS1_5 c \n"
                + "inner join TR_PLE_MEDS1_1 u on c.id_entidad=u.id_entidad and c.C1_5_ID=u.C1_1_ID\n"
                + "where \n"
                + " ( c.P1_5_11 <> '09/09/1899' AND c.P1_5_11 <> '09/09/1799')\n"
                + " AND  ( u.p1_1_9 <> '09/09/1899' AND u.p1_1_9 <> '09/09/1799')\n"
                + " AND REGEXP_LIKE(c.P1_5_11, '^\\\\d{2}/\\\\d{2}/\\\\d{4}$')\n"
                + " AND REGEXP_LIKE(u.p1_1_9, '^\\\\d{2}/\\\\d{2}/\\\\d{4}$')\n"
                + "and c.P1_5_11 not in ('-1','-2','-3')\n"
                + "and u.p1_1_9 not in ('-1','-2','-3')\n"
                + "AND P1_5_11 NOT LIKE '%00%' \n"
                + "AND u.p1_1_9 NOT LIKE '%00%' \n"
                + "AND to_date(c.P1_5_11,'DD/MM/YYYY') >to_date(u.p1_1_9,'DD/MM/YYYY') "
                + " AND c.ID_ENTIDAD=" + ID_entidad + " AND c.Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//P1_5_13-M(fecha_sesion_presentacion_iniciativa) Debe ser igual o mayor a la fecha registrada en la columna P1_5_11-K(fecha_ingreso_iniciativa_oficialia_partes).
    public ArrayList fecha_sesion_presentacion_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ENTIDAD, ENTIDAD, \n"
                + "C1_5_ID, P1_5_1,  to_date(P1_5_13)P1_5_13,\n"
                + " to_date(P1_5_11)P1_5_11\n"
                + "FROM TR_PLE_MEDS1_5\n"
                + "WHERE \n"
                + "    REGEXP_LIKE(P1_5_11, '^\\d{2}/\\d{2}/\\d{4}$') AND\n"
                + "    REGEXP_LIKE(P1_5_13, '^\\d{2}/\\d{2}/\\d{4}$') AND\n"
                + "    SUBSTR(P1_5_11, 1, 2) BETWEEN '01' AND '31' AND\n"
                + "    SUBSTR(P1_5_11, 4, 2) BETWEEN '01' AND '12' AND\n"
                + "    SUBSTR(P1_5_13, 1, 2) BETWEEN '01' AND '31' AND\n"
                + "    SUBSTR(P1_5_13, 4, 2) BETWEEN '01' AND '12' AND\n"
                + "    TO_DATE(P1_5_11, 'DD/MM/YYYY') IS NOT NULL AND\n"
                + "    TO_DATE(P1_5_13, 'DD/MM/YYYY') IS NOT NULL\n"
                + "    AND  to_date(p1_5_13,'DD/MM/YYYY')<to_date(P1_5_11,'DD/MM/YYYY')\n"
                + "    and ( to_date(P1_5_13,'DD/MM/YYYY') <> '09/09/1899' AND  to_date(P1_5_13,'DD/MM/YYYY') <> '09/09/1799') "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe especificar el dato en P1_5_15-O(otro_tipo_iniciativa_especifique) debido a P1_5_14 (tipo_iniciativa) se selecciono la categoria "Otro tipo (especifique)" (3).
    public ArrayList otro_tipo_iniciativa_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_14, P1_5_15 from tr_ple_meds1_5 where P1_5_14 = 3 and P1_5_15 is null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar el dato en P1_5_15-O(otro_tipo_iniciativa_especifique) debido a P1_5_14 (tipo_iniciativa) se selecciono una categoria diferente a "Otro tipo (especifique)" (3).
    public ArrayList NDCotro_tipo_iniciativa_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_14, P1_5_15 from tr_ple_meds1_5 where P1_5_14 <> 3 and P1_5_15 is not null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar el dato en P1_5_18-R(nombre_persona_legisladora_1) y P1_5_17-Q(ID_persona_legisladora_1) debido a P1_5_16 (tipo_promovente_iniciativa) se selecciono una categoria diferente a "Personas legisladoras" (3).
    public ArrayList nombre_persona_legisladora_1(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_16, P1_5_17, P1_5_18 from tr_ple_meds1_5 where P1_5_16 <> 3 and (P1_5_17 is not null and P1_5_18 is not null) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe capturar informacion en P1_5_18-R(nombre_persona_legisladora_1) y P1_5_17-Q(ID_persona_legisladora_1) debido a P1_5_16 (tipo_promovente_iniciativa) se selecciono la categoria "Personas legisladoras" (3).
    public ArrayList DCnombre_persona_legisladora_1(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_16, P1_5_17, P1_5_18 from tr_ple_meds1_5 where P1_5_16 = 3 and (P1_5_17 is null and P1_5_18 is not null) or (P1_5_17 is not null and P1_5_18 is null) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//QUERY CON FOR 
//No se deben de capturar los campos :PARAMETRO2, :PARAMETRO3 debido a que el campo :PARAMETRO1 viene vacio
    public ArrayList FNcomision(String ID_entidad, String Legislatura, String Envio, String CAMPO1, String CAMPO2, String CAMPO3) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1," + CAMPO1 + ", " + CAMPO2 + "," + CAMPO3 + " from TR_PLE_MEDS1_5 where " + CAMPO1 + " is null and ( " + CAMPO2 + " is not null or " + CAMPO3 + " is not null) "
                + " and ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//QUERY CON FOR 
//El id de la persona legisladora :PARAMETRO1 no existe en la tabla de personas legisladoras 
    public ArrayList legisladora(String ID_entidad, String Legislatura, String Envio, String CAMPO1) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  c.ID_ENTIDAD, c.ENTIDAD, c.C1_5_ID, c.P1_5_1,c." + CAMPO1 + ", t.P1_3_1 from TR_PLE_MEDS1_5 c \n"
                + "left join TR_PLE_MEDS1_3 t on c." + CAMPO1 + "= P1_3_1 and c.C1_5_ID=t.C1_3_ID and t.id_entidad=c.id_entidad\n"
                + "where c." + CAMPO1 + " is not null  and t.P1_3_1 is null\n"
                + "and " + CAMPO1 + " not in ('-1','-2','-3')  "
                + " and c.ID_ENTIDAD=" + ID_entidad + " AND c.Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No puede repetir la persona legisladora seleccionada en la columna ID_PERSONA_LEGISLADORA
    public ArrayList ID_PERSONA_LEGISLADORA(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_17, P1_5_19, P1_5_21, P1_5_23, P1_5_25, P1_5_27, P1_5_29, \n"
                + "P1_5_31, P1_5_33, P1_5_35, P1_5_37, P1_5_39, P1_5_41, P1_5_43, P1_5_45, P1_5_47, P1_5_49, P1_5_51, P1_5_53, P1_5_55\n"
                + "from TR_PLE_MEDS1_5 \n"
                + "WHERE \n"
                + "(P1_5_17=P1_5_19 OR P1_5_17=P1_5_21 OR P1_5_17=P1_5_23 OR P1_5_17=P1_5_25 OR P1_5_17=P1_5_27 OR P1_5_17=P1_5_29 OR P1_5_17=P1_5_31 OR P1_5_17=P1_5_33 OR\n"
                + "P1_5_17=P1_5_35 OR P1_5_17=P1_5_37 OR P1_5_17=P1_5_39 OR P1_5_17=P1_5_41 OR P1_5_17=P1_5_43 OR P1_5_17=P1_5_45 OR P1_5_17=P1_5_47 OR P1_5_17=P1_5_49 OR \n"
                + "P1_5_17=P1_5_51 OR P1_5_17=P1_5_53 OR P1_5_17=P1_5_55 OR P1_5_19=P1_5_21 OR P1_5_19=P1_5_23 OR P1_5_19=P1_5_25 OR P1_5_19=P1_5_27 OR P1_5_19=P1_5_29 OR \n"
                + "P1_5_19=P1_5_31 OR P1_5_19=P1_5_33 OR P1_5_19=P1_5_35 OR P1_5_19=P1_5_37 OR P1_5_19=P1_5_39 OR P1_5_19=P1_5_41 OR P1_5_19=P1_5_43 OR P1_5_19=P1_5_45 OR \n"
                + "P1_5_19=P1_5_47 OR P1_5_19=P1_5_49 OR P1_5_19=P1_5_51 OR P1_5_19=P1_5_53 OR P1_5_19=P1_5_55 OR \n"
                + "P1_5_21=P1_5_23 OR P1_5_21=P1_5_25 OR P1_5_21=P1_5_27 OR P1_5_21=P1_5_29 OR P1_5_21=P1_5_31 OR P1_5_21=P1_5_33 OR P1_5_21=P1_5_35 OR P1_5_21=P1_5_37 OR \n"
                + "P1_5_21=P1_5_39 OR P1_5_21=P1_5_41 OR P1_5_21=P1_5_43 OR P1_5_21=P1_5_45 OR P1_5_21=P1_5_47 OR P1_5_21=P1_5_49 OR P1_5_21=P1_5_51 OR P1_5_21=P1_5_53 OR \n"
                + "P1_5_21=P1_5_55 OR\n"
                + "P1_5_23=P1_5_25 OR P1_5_23=P1_5_27 OR P1_5_23=P1_5_29 OR P1_5_23=P1_5_31 OR P1_5_23=P1_5_33 OR P1_5_23=P1_5_35 OR P1_5_23=P1_5_37 OR P1_5_23=P1_5_39 OR \n"
                + "P1_5_23=P1_5_41 OR P1_5_23=P1_5_43 OR P1_5_23=P1_5_45 OR P1_5_23=P1_5_47 OR P1_5_23=P1_5_49 OR P1_5_23=P1_5_51 OR P1_5_23=P1_5_53 OR P1_5_23=P1_5_55 OR\n"
                + "P1_5_27=P1_5_29 OR P1_5_27=P1_5_31 OR P1_5_27=P1_5_33 OR P1_5_27=P1_5_35 OR P1_5_27=P1_5_37 OR P1_5_27=P1_5_39 OR P1_5_27=P1_5_41 OR \n"
                + "P1_5_27=P1_5_43 OR P1_5_27=P1_5_45 OR P1_5_27=P1_5_47 OR P1_5_27=P1_5_49 OR P1_5_27=P1_5_51 OR P1_5_27=P1_5_53 OR P1_5_27=P1_5_55 OR\n"
                + "P1_5_29=P1_5_31 OR P1_5_29=P1_5_33 OR P1_5_29=P1_5_35 OR P1_5_29=P1_5_37 OR P1_5_29=P1_5_39 OR P1_5_29=P1_5_41 OR P1_5_29=P1_5_43 OR P1_5_29=P1_5_45 OR \n"
                + "P1_5_29=P1_5_47 OR P1_5_29=P1_5_49 OR P1_5_29=P1_5_51 OR P1_5_29=P1_5_53 OR P1_5_29=P1_5_55 OR\n"
                + "P1_5_31=P1_5_33 OR P1_5_31=P1_5_35 OR P1_5_31=P1_5_37 OR P1_5_31=P1_5_39 OR P1_5_31=P1_5_41 OR P1_5_31=P1_5_43 OR P1_5_31=P1_5_45 OR P1_5_31=P1_5_47 OR \n"
                + "P1_5_31=P1_5_49 OR P1_5_31=P1_5_51 OR P1_5_31=P1_5_53 OR P1_5_31=P1_5_55 OR\n"
                + "P1_5_33=P1_5_35 OR P1_5_33=P1_5_37 OR P1_5_33=P1_5_39 OR P1_5_33=P1_5_41 OR P1_5_33=P1_5_43 OR P1_5_33=P1_5_45 OR P1_5_33=P1_5_47 OR P1_5_33=P1_5_49 OR \n"
                + "P1_5_33=P1_5_51 OR P1_5_33=P1_5_53 OR P1_5_33=P1_5_55 OR\n"
                + "P1_5_35=P1_5_37 OR P1_5_35=P1_5_39 OR P1_5_35=P1_5_41 OR P1_5_35=P1_5_43 OR P1_5_35=P1_5_45 OR P1_5_35=P1_5_47 OR P1_5_35=P1_5_49 OR P1_5_35=P1_5_51 OR \n"
                + "P1_5_35=P1_5_53 OR P1_5_35=P1_5_55 OR\n"
                + "P1_5_37=P1_5_39 OR P1_5_37=P1_5_41 OR P1_5_37=P1_5_43 OR P1_5_37=P1_5_45 OR P1_5_37=P1_5_47 OR P1_5_37=P1_5_49 OR P1_5_37=P1_5_51 OR P1_5_37=P1_5_53 OR \n"
                + "P1_5_37=P1_5_55 OR\n"
                + "P1_5_39=P1_5_41 OR P1_5_39=P1_5_43 OR P1_5_39=P1_5_45 OR P1_5_39=P1_5_47 OR P1_5_39=P1_5_49 OR P1_5_39=P1_5_51 OR P1_5_39=P1_5_53 OR P1_5_39=P1_5_55 OR\n"
                + "P1_5_41=P1_5_43 OR P1_5_41=P1_5_45 OR P1_5_41=P1_5_47 OR P1_5_41=P1_5_49 OR P1_5_41=P1_5_51 OR P1_5_41=P1_5_53 OR P1_5_41=P1_5_55 OR\n"
                + "P1_5_43=P1_5_45 OR P1_5_43=P1_5_47 OR P1_5_43=P1_5_49 OR P1_5_43=P1_5_51 OR P1_5_43=P1_5_53 OR P1_5_43=P1_5_55 OR\n"
                + "P1_5_45=P1_5_47 OR P1_5_45=P1_5_49 OR P1_5_45=P1_5_51 OR P1_5_45=P1_5_53 OR P1_5_45=P1_5_55 OR\n"
                + "P1_5_47=P1_5_49 OR P1_5_47=P1_5_51 OR P1_5_47=P1_5_53 OR P1_5_47=P1_5_55 OR\n"
                + "P1_5_49=P1_5_51 OR P1_5_49=P1_5_53 OR P1_5_49=P1_5_55 OR\n"
                + "P1_5_51=P1_5_53 OR P1_5_51=P1_5_55 OR P1_5_53=P1_5_55)  "
                + " AND (ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe seleccionar una categoria en P1_5_57-BE(grupo_parlamentario) debido a P1_5_16 (tipo_promovente_iniciativa) se selecciono la categoria "Grupo parlamentario" (4).
    public ArrayList DCgrupo_parlamentario(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_16, P1_5_57 from tr_ple_meds1_5 where P1_5_16 = 4 and P1_5_57 is null  "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe seleccionar una categoria en P1_5_57-BE(grupo_parlamentario) debido a P1_5_16 (tipo_promovente_iniciativa) se selecciono una categoria diferente a "Grupo parlamentario" (4).
    public ArrayList NDCgrupo_parlamentario(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_16, P1_5_57 from tr_ple_meds1_5 where P1_5_16 <> 4 and P1_5_57 is not null  "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar en P1_5_58-BF(varios_grupos_parlamentarios_especifique_1) debido a P1_5_57 (grupo_parlamentario) se selecciono una categoría diferente a "Varios" (88).
    public ArrayList varios_grupos_parlamentarios_especifique_1(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_57, P1_5_58\n"
                + "from tr_ple_meds1_5\n"
                + "where P1_5_57 <> " + ID_entidad + " || 88\n"
                + "and  P1_5_58 is not null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //Debe especificar al menos dos grupos parlamentarios  P1_5_59-BF(varios_grupos_parlamentarios_especifique_2) debido a que en P1_5_57 (grupo_parlamentario) se seleccionó "Varios" (88).
    public ArrayList varios_grupos_sin_especifique_2(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD,P1_5_1 as ID_INICIATIVA , P1_5_57 as grupo_parlamentario,P1_5_58 as grupo_esp1,P1_5_59 as grupo_esp2 ,P1_5_60 as grupo_esp3, LEGISLATURA,C1_5_ID AS ENVIO\n" +
        "from TR_PLE_MEDS1_5 where (P1_5_57 = " + ID_entidad + " || 88 AND P1_5_59 IS NULL )"
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("ID_INICIATIVA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
//No puede seleccionar la categoría "Varios" en las columnas P1_5_58-BF(varios_grupos_parlamentarios_especifique_1) , P1_5_59-BG(varios_grupos_parlamentarios_especifique_2),P1_5_60-BH(varios_grupos_parlamentarios_especifique_3)
    public ArrayList NDCvarios_grupos_parlamentarios_especifique_1(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_57,P1_5_58,P1_5_59,P1_5_60 from TR_PLE_MEDS1_5 where \n"
                + "P1_5_58= ID_ENTIDAD||'88' or\n"
                + "P1_5_59= ID_ENTIDAD||'88' or\n"
                + "P1_5_60= ID_ENTIDAD||'88'  "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No se debe de capturar el campo P1_5_59-BG(varios_grupos_parlamentarios_especifique_2) debido a que varios_grupos_parlamentarios_especifique_1 (P1_5_58) viene vacio
    public ArrayList NDCvarios_grupos_parlamentarios_especifique_2(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_58, P1_5_59 from TR_PLE_MEDS1_5 where P1_5_58 IS NULL and  P1_5_59 IS NOT NULL  "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No se puede repetir el grupo parlamentario en las columnas P1_5_58-BF(varios_grupos_parlamentarios_especifique_1), P1_5_59-BG(varios_grupos_parlamentarios_especifique_2),P1_5_60-BH(varios_grupos_parlamentarios_especifique_3)
    public ArrayList NDRvarios_grupos_parlamentarios_especifique_1(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_57,P1_5_58,P1_5_59,P1_5_60 from TR_PLE_MEDS1_5 where \n"
                + "P1_5_58= P1_5_59 or\n"
                + "P1_5_58= P1_5_60 or\n"
                + "P1_5_59= P1_5_60  "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No se debe de capturar el campo P1_5_60-BH(varios_grupos_parlamentarios_especifique_3) debido a que P1_5_59-BG(varios_grupos_parlamentarios_especifique_2)
    public ArrayList NDCvarios_grupos_parlamentarios_especifique_3(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_59, P1_5_60 from TR_PLE_MEDS1_5 where P1_5_59 IS NULL and  P1_5_60 IS NOT NULL "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Se deben de capturar las columnas P1_5_61-BI(ID_comision_legislativa_1) y P1_5_62-BJ(nombre_comision_legislativa_1) debido a que tipo_promovente_iniciativa (P1_5_16) se  selecciono "Comisión legislativa"'5' 
    public ArrayList NDCID_comision_legislativa_1(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_16,P1_5_61,P1_5_62 from TR_PLE_MEDS1_5 where P1_5_16=5 and (P1_5_61 is null or P1_5_62 is null) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No se deben de capturar las columnas P1_5_61-BI(ID_comision_legislativa_1) y P1_5_62-BJ(nombre_comision_legislativa_1) debido a que tipo_promovente_iniciativa (P1_5_16) no se  selecciono "Comisión legislativa"'5
    public ArrayList DCID_comision_legislativa_1(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_16,P1_5_61,P1_5_62 from TR_PLE_MEDS1_5 where P1_5_16<>5 and (P1_5_61 is not null or P1_5_62 is not null) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//QUERY CON FOR 
//El campo :PARAMETRO1 no se encuentra capturado en la tabla de comisiones legislativas registradas en la TR_PLE_MEDS1_2(Tabla comisiones_legislativas).
    public ArrayList TR_PLE_MEDS1_2(String ID_entidad, String Legislatura, String Envio, String CAMPO1) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  c.ID_ENTIDAD, c.ENTIDAD, c.C1_5_ID, c.P1_5_1,\n"
                + "c." + CAMPO1 + ", d.P1_2_1 from TR_PLE_MEDS1_5 c left join TR_PLE_MEDS1_2 d on d.C1_2_ID=c.C1_5_ID and c." + CAMPO1 + "=P1_2_1 and c.id_entidad=d.id_entidad\n"
                + "where c." + CAMPO1 + " is not null and d.P1_2_1 is null  "
                + " and c.ID_ENTIDAD=" + ID_entidad + " AND c.Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No se debe de capturar dato en las columnas P1_5_63-BK(ID_comision_legislativa_2) y P1_5_64-BL(nombre_comision_legislativa_2) debido a que la columna P1_5_62-BJ(nombre_comision_legislativa_1) viene vacia
    public ArrayList ID_comision_legislativa_2(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,P1_5_62,P1_5_63,P1_5_64 from TR_PLE_MEDS1_5 where (P1_5_63 is not null or P1_5_64 is not null) and P1_5_62 is null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No puede repetir el identificador de la comisión legislativa asignado en la columna ID_comision_legislativa en las columnas P1_5_61-BI(ID_comision_legislativa_1)	Identificador primer comisión legislativa, P1_5_63-BK(ID_comision_legislativa_2)	Identificador segunda comisión legislativa, P1_5_65-BM(ID_comision_legislativa_3) Identificador tercer comisión legislativa
    public ArrayList ID_comision_legislativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,\n"
                + "P1_5_61,P1_5_63,P1_5_65\n"
                + "from TR_PLE_MEDS1_5 where P1_5_61=P1_5_63 or P1_5_61=P1_5_65 or P1_5_63=P1_5_65 "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No se debe de capturar dato en las columnas P1_5_65-BM(ID_comision_legislativa_3) yP1_5_66-BN(nombre_comision_legislativa_3) debido a que la columna P1_5_64-BL(nombre_comision_legislativa_2) viene vacia
    public ArrayList ID_comision_legislativa_3(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,\n"
                + "P1_5_64,P1_5_65,P1_5_66 from TR_PLE_MEDS1_5 where (P1_5_65 is not null or P1_5_66 is not null) and P1_5_64 is null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Se deben de capturar los campos P1_5_67-BO(AGEM), P1_5_68-BP(ayuntamiento) debido a que en la columna tipo_promovente_iniciativa (P1_5_16) se selecciono  "Ayuntamientos" '9'
    public ArrayList ayuntamiento(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,\n"
                + "P1_5_16,P1_5_67,P1_5_68\n"
                + "from TR_PLE_MEDS1_5 where P1_5_16=9 and (P1_5_67 is null OR P1_5_68 IS NULL) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No se deben de capturar los campos P1_5_67-BO(AGEM), P1_5_68-BP(ayuntamiento) debido a que en la columna tipo_promovente_iniciativa (P1_5_16) es diferente a  "Ayuntamientos" '9'
    public ArrayList NDCayuntamiento(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,\n"
                + "P1_5_16,P1_5_67,P1_5_68\n"
                + "from TR_PLE_MEDS1_5 where P1_5_16<>9 and (P1_5_67 is NOT null OR P1_5_68 IS NOT NULL) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe seleccionar una categoria en P1_5_69-BQ(tipo_organo_constitucional_autonomo) debido a P1_5_16 (tipo_promovente_iniciativa) se selecciono la categoria "Órgano constitucional autónomo" (10).
    public ArrayList DCtipo_organo_constitucional_autonomo(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_16, P1_5_69 from tr_ple_meds1_5 where P1_5_16 = 10 and P1_5_69 is null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe seleccionar una categoria en P1_5_69-BQ(tipo_organo_constitucional_autonomo) debido a P1_5_16 (tipo_promovente_iniciativa) se selecciono una categoria diferente a "Órgano constitucional autónomo" (10).
    public ArrayList NDCtipo_organo_constitucional_autonomo(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_16, P1_5_69 from tr_ple_meds1_5 where P1_5_16 <> 10 and P1_5_69 is not null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe especificar el dato en P1_5_70-BR(otro_tipo_organo_constitucional_autonomo_especifique) debido a P1_5_69 (tipo_organo_constitucional_autonomo) se selecciono la categoria "Otro órgano constitucional autónomo (específique)"  (7).
    public ArrayList DCotro_tipo_organo_constitucional_autonomo_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_69, P1_5_70 from tr_ple_meds1_5 where P1_5_69 = 7 and P1_5_70 is null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar el dato en P1_5_70-BR(otro_tipo_organo_constitucional_autonomo_especifique) debido a P1_5_69 (tipo_organo_constitucional_autonomo) se selecciono una categoria diferente a "Otro órgano constitucional autónomo (específique)"  (7).
    public ArrayList NDCotro_tipo_organo_constitucional_autonomo_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_69, P1_5_70 from tr_ple_meds1_5 where P1_5_69 <> 7 and P1_5_70 is not null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe especificar el dato en P1_5_71-BS(otro_tipo_promovente_iniciativa_especifique) debido a P1_5_16 (tipo_promovente_iniciativa) se selecciono la categoria "Otro tipo de promovente (especifique)" (12).
    public ArrayList DCotro_tipo_promovente_iniciativa_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_16, P1_5_71 from tr_ple_meds1_5 where P1_5_16 = 12 and P1_5_71 is null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar el dato en P1_5_71-BS(otro_tipo_promovente_iniciativa_especifique) debido a P1_5_16 (tipo_promovente_iniciativa) se selecciono una categoria diferente a "Otro tipo de promovente (especifique)" (12).
    public ArrayList NDCotro_tipo_promovente_iniciativa_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_16, P1_5_71 from tr_ple_meds1_5 where P1_5_16 <> 12 and P1_5_71 is not null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe capturar (Condición de iniciativa preferente)-BT En caso de seleccionar la categoría "Sí" (1) en la columna C1_1D=1 and P1_1D_1 (cond_reconocimiento_iniciativa_preferente) de la tabla datos_generales y las categoría "Sí" en la columna cond_presentacion_iniciativa_periodo (P1_5_3) y "Persona titular del Poder Ejecutivo" en la columna tipo_promovente_iniciativa (P1_5_16).
    public ArrayList DCcond_reconocimiento_iniciativa_preferente(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  c.ID_ENTIDAD, c.ENTIDAD, c.C1_5_ID, c.P1_5_1, c.P1_5_3, c.P1_5_16, c.P1_5_72, ud.C1_1D, ud.P1_1D_1\n"
                + "from TR_PLE_MEDS1_5 c left join TR_PLE_MEDS1_1D ud on ud.ID_ENTIDAD=c.ID_ENTIDAD and ud.C1_1D_ID=c.C1_5_ID\n"
                + "where ud.C1_1D=1 and ud.P1_1D_1=1 and P1_5_16=1 and P1_5_3=1 and P1_5_72 is null "
                + " AND c.ID_ENTIDAD=" + ID_entidad + " AND c.Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//En caso de seleccionar la categoría "Sí" en la columna cond_reconocimiento_iniciativa_preferente de la tabla datos_generales y las categoría "Sí" en la columna cond_modificacion_información_ingreso_periodo 5_7 y "Persona titular del Poder Ejecutivo" en la columna tipo_promovente_iniciativa (P1_5_16).
    public ArrayList cond_reconocimiento_iniciativa_preferente(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  c.ID_ENTIDAD, c.ENTIDAD, c.C1_5_ID, c.P1_5_1, c.P1_5_7, c.P1_5_16, c.P1_5_72, ud.C1_1D\n"
                + "from TR_PLE_MEDS1_5 c \n"
                + "left join TR_PLE_MEDS1_1D ud \n"
                + "on ud.ID_ENTIDAD=c.ID_ENTIDAD \n"
                + "and ud.C1_1D_ID=c.C1_5_ID\n"
                + "where ud.C1_1D=1 and P1_5_7=1 and P1_5_16=1 and P1_5_72 is null "
                + " AND c.ID_ENTIDAD=" + ID_entidad + " AND c.Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    

//No debe seleccionar una categoria en P1_5_73-BU(cond_adhesion_iniciativa) debido a P1_5_7 (cond_modificacion_informacion_ingreso_periodo) se selecciono la categoria "No" (2).
    public ArrayList cond_adhesion_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_7, P1_5_73 from tr_ple_meds1_5 where P1_5_7 = 2 and P1_5_73 is not null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar el dato en P1_5_75-BW(nombre_comision_legislativa_1_primer_estudio) y P1_5_74-BV(ID_comision_legislativa_1_primer_estudio) debido a P1_5_8 (estatus_iniciativa) se selecciono una categoria diferente a "Estudio" (2), "Dictamen" (5), "Desechada o improcedente" (6) o "Aprobada o procedente" (7).
    public ArrayList NDCnombre_comision_legislativa_1_primer_estudio(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_8, P1_5_74, P1_5_75 from tr_ple_meds1_5 where P1_5_8 not in (2,5,6,7) and (P1_5_75 is not null and P1_5_75 is not null) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe capturar informacion en P1_5_75-BW(nombre_comision_legislativa_1_primer_estudio) y P1_5_74-BV(ID_comision_legislativa_1_primer_estudio) debido a P1_5_8 (estatus_iniciativa) se selecciono alguna de las categorias "Estudio" (2), "Dictamen" (5), "Desechada o improcedente" (6) o "Aprobada o procedente" (7).
    public ArrayList DCnombre_comision_legislativa_1_primer_estudio(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_8, P1_5_74, P1_5_75 from tr_ple_meds1_5 where P1_5_8 in (2,5,6,7) and ((P1_5_75 is null and P1_5_74 is not null) or (P1_5_75 is not null and P1_5_74 is null)) "
                + " AND (ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//QUERY CON FOR 
//No se deben de capturar los campos :ESTUDIO2, :ESTUDIO3 debido a que el campo :ESTUDIO1 viene vacio
    public ArrayList ESTUDIOL(String ID_entidad, String Legislatura, String Envio, String CAMPO1, String CAMPO2, String CAMPO3) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1," + CAMPO1 + ", " + CAMPO2 + "," + CAMPO3 + " "
                + " from TR_PLE_MEDS1_5 "
                + " where " + CAMPO1 + " is null and ( " + CAMPO2 + " is not null or " + CAMPO3 + " is not null)  "
                + " and ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No puede repetir el Identificador primer comisión legislativa primer estudio. 
    public ArrayList primer(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_74, P1_5_76, P1_5_78, P1_5_80, P1_5_82\n"
                + "from tr_ple_meds1_5\n"
                + "where \n"
                + "(P1_5_74 = P1_5_76 or P1_5_74 = P1_5_78 or P1_5_74 = P1_5_80 or P1_5_74 = P1_5_82 or \n"
                + "P1_5_76 = P1_5_78 or P1_5_76 = P1_5_80 or P1_5_76 = P1_5_82 or\n"
                + "P1_5_78 = P1_5_80 or P1_5_78 = P1_5_82 or\n"
                + "P1_5_80 = P1_5_82) "
                + " AND (ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//QUERY CON FOR 
//La comision ingresada en el campo :PARAMETRO1 no se encuentra caturada en la tabla Comisiones
    public ArrayList NCESTUDIO(String ID_entidad, String Legislatura, String Envio, String CAMPO1) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select i.ID_ENTIDAD, i.ENTIDAD, i.C1_5_ID, i.P1_5_1, i." + CAMPO1 + ", \n"
                + "      d.P1_2_1\n"
                + "from tr_ple_meds1_5 i\n"
                + "LEFT join tr_ple_meds1_2 d\n"
                + "on i.ID_ENTIDAD = d.ID_ENTIDAD and i.C1_5_ID = d.C1_2_ID AND i." + CAMPO1 + " = d.P1_2_1\n"
                + "where  i." + CAMPO1 + " <> 'COM_PER_'||i.ENTIDAD\n"
                + "AND i." + CAMPO1 + " is not null and d.P1_2_1 is null\n"
                + "AND i." + CAMPO1 + " NOT IN ('-1','-2','-3')  "
                + " and i.ID_ENTIDAD=" + ID_entidad + " AND i.Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar el dato en P1_5_85-CG(nombre_comision_legislativa_1_segundo_estudio) debido a P1_5_10(etapa_procesal_iniciativa) se selecciono una categoría diferente a "Segundo dictamen" (4).
    public ArrayList nombre_comision_legislativa_1_segundo_estudio(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_10, P1_5_84, P1_5_85 from tr_ple_meds1_5 where P1_5_10 = 4 and (P1_5_85 is not null and P1_5_84 is not null) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe capturar información en P1_5_85-CG(nombre_comision_legislativa_1_segundo_estudio) o P1_5_84-CF(ID_comision_legislativa_1_segundo_estudio) debido a que se selecciono información en cualquiera de las ya mencionadas.
    public ArrayList DCnombre_comision_legislativa_1_segundo_estudio(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_10, P1_5_84, P1_5_85 from tr_ple_meds1_5 where P1_5_10 = 4 and (P1_5_84 is null and P1_5_85 is not null)  or (P1_5_84 is not null and P1_5_85 is null) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//QUERY CON FOR 
//No se puede capturar informacion en las columnas :PARAMETRO2, :PARAMETRO3 debido a que el campo :PARAMETRO1 viene vacio 
    public ArrayList legislativa(String ID_entidad, String Legislatura, String Envio, String CAMPO1, String CAMPO2, String CAMPO3) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,\n"
                + "" + CAMPO1 + "," + CAMPO2 + "," + CAMPO3 + "\n"
                + "from TR_PLE_MEDS1_5 where " + CAMPO1 + " is null and (" + CAMPO2 + " is NOT null OR " + CAMPO3 + " IS NOT NULL)  "
                + " and ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No se puede repetir el identificador de la comisión legislativa en las columnas P1_5_86-CH(ID_comision_legislativa_2_segundo_estudio) Identificador primer comisión legislativa segundo estudio, P1_5_88-CJ(ID_comision_legislativa_3_segundo_estudio)	Identificador primer comisión legislativa segundo estudio, P1_5_90-CL(ID_comision_legislativa_4_segundo_estudio)	Identificador primer comisión legislativa segundo estudio, P1_5_92-CN(ID_comision_legislativa_5_segundo_estudio)	Identificador primer comisión legislativa segundo estudio
    public ArrayList comisi(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1,\n"
                + "P1_5_84,P1_5_86,P1_5_88,P1_5_90,P1_5_92\n"
                + "from TR_PLE_MEDS1_5 where \n"
                + "\n"
                + "P1_5_84=P1_5_86 or\n"
                + "P1_5_84=P1_5_88 or\n"
                + "P1_5_84=P1_5_90 or\n"
                + "P1_5_84=P1_5_92 or\n"
                + "P1_5_86=P1_5_88 or\n"
                + "P1_5_86=P1_5_90 or\n"
                + "P1_5_86=P1_5_92 or\n"
                + "P1_5_88=P1_5_90 or\n"
                + "P1_5_88=P1_5_92 or\n"
                + "\n"
                + "P1_5_90=P1_5_92  "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//QUERY CON FOR 
//La comision ingresada en el campo :PARAMETRO1 no se encuentra caturada en la tabla Comisiones
    public ArrayList Comisiones(String ID_entidad, String Legislatura, String Envio, String CAMPO1) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select  c.ID_ENTIDAD, c.ENTIDAD, c.C1_5_ID, c.P1_5_1,\n"
                + "c." + CAMPO1 + ", d.p1_2_1\n"
                + "from TR_PLE_MEDS1_5 c left join TR_PLE_MEDS1_2 d on d.ID_ENTIDAD=c.ID_ENTIDAD and c.C1_5_ID=d.C1_2_ID and d.p1_2_1=c." + CAMPO1 + "\n"
                + "\n"
                + "where c." + CAMPO1 + " is not null and d.P1_2_1 is null  "
                + " and c.ID_ENTIDAD=" + ID_entidad + " AND c.Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar el dato en P1_5_94-CP(tipo_primer_dictamen) y P1_5_96-CR(sentido_resolucion_primer_dictamen) debido a P1_5_8 (estatus_iniciativa) se selecciono una categoria difrente a "Dictamen" (5), "Desechada o improcedente" (6) o "Aprobada o procedente" (7).
    public ArrayList tipo_primer_dictamen(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_8, P1_5_94, P1_5_96 from tr_ple_meds1_5 where P1_5_8 not in (5,6,7) and P1_5_94 is not null and P1_5_96 is not null  "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe especificar el dato en P1_5_95-CQ(otro_tipo_primer_dictamen_especifique) debido a P1_5_94 (tipo_primer_dictamen) se selecciono la categoria "Otro tipo (especifique)" (8).
    public ArrayList DCotro_tipo_primer_dictamen_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_94, P1_5_95 from tr_ple_meds1_5 where P1_5_94 = 8 and P1_5_95 is null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar el dato en P1_5_95-CQ(otro_tipo_primer_dictamen_especifique) debido a P1_5_94 (tipo_primer_dictamen) se selecciono una categoria diferente a "Otro tipo (especifique)" (8).
    public ArrayList NDCotro_tipo_primer_dictamen_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_94, P1_5_95 from tr_ple_meds1_5 where P1_5_94 <> 8 and P1_5_95 is not null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//En caso de que haya seleccionado la categoría "Aprobada o procedente" (7) en P1_5_8-H(estatus_iniciativa), únicamente puede seleccionar la categoría "En sentido positivo (totalmente)" (1), "En sentido positivo (parcialmente)" (2) o "En otro sentido de resolución (especifique)" (4) en P1_5_96-CR(sentido_resolucion_primer_dictamen).
    public ArrayList Aprobada(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_8, P1_5_96 from tr_ple_meds1_5 where P1_5_8 = 7 and P1_5_96 not in (1,2,4) and P1_5_96 not in ('-1','-2','-3') "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe especificar el dato en P1_5_97-CS(otro_sentido_resolucion_primer_dictamen_especifique) debido a P1_5_96 (entido_resolucion_primer_dictamen) se selecciono "En otro sentido de resolución (especifique)" (4).
    public ArrayList otro_sentido_resolucion_primer_dictamen_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_96, P1_5_97 from tr_ple_meds1_5 where P1_5_96 = 4 and P1_5_97 is null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar el dato en P1_5_97-CS(otro_sentido_resolucion_primer_dictamen_especifique) debido a P1_5_96 (entido_resolucion_primer_dictamen) se selecciono una categoria diferente a "En otro sentido de resolución (especifique)" (4).
    public ArrayList NDCotro_sentido_resolucion_primer_dictamen_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_96, P1_5_97 from tr_ple_meds1_5 where P1_5_96 <> 4 and P1_5_97 is not null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe selecciona una categoria en P1_5_98-CT(tipo_segundo_dictamen) y P1_5_100-CV(sentido_resolucion_segundo_dictamen) debido a P1_5_10 (etapa_procesal_iniciativa) se selecciono una categoria diferente a  "Segundo dictamen" (4).
    public ArrayList tipo_segundo_dictamen(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_10, P1_5_98, P1_5_100\n"
                + "from tr_ple_meds1_5\n"
                + "where P1_5_10 <> 4\n"
                + "and (P1_5_98 is NOT null and  P1_5_100 is NOT null) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe especificar el dato en P1_5_99-CU(otro_tipo_segundo_dictamen_especifique) debido a P1_5_98 (tipo_segundo_dictamen) se selecciono la categoria "Otro tipo (especifique)" (8).
    public ArrayList otro_tipo_segundo_dictamen_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_98, P1_5_99 from tr_ple_meds1_5 where P1_5_98 = 8 and P1_5_99 is null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar el dato en P1_5_99-CU(otro_tipo_segundo_dictamen_especifique) debido a P1_5_98 (tipo_segundo_dictamen) se selecciono una categoria diferente a "Otro tipo (especifique)" (8).
    public ArrayList NDCotro_tipo_segundo_dictamen_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_98, P1_5_99 from tr_ple_meds1_5 where P1_5_98 <> 8 and P1_5_99 is not null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Debe especificar el dato en P1_5_101-CW(otro_sentido_resolucion_segundo_dictamen_especifique) debido a P1_5_100 (sentido_resolucion_segundo_dictamen) se selecciono  "En otro sentido de resolución (especifique)" (4).
    public ArrayList DCotro_sentido_resolucion_segundo_dictamen_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_100, P1_5_101 from tr_ple_meds1_5 where P1_5_100 = 4 and P1_5_101 is null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe especificar el dato en P1_5_101-CW(otro_sentido_resolucion_segundo_dictamen_especifique) debido a P1_5_100 (sentido_resolucion_segundo_dictamen) se selecciono una categoria diferente a "En otro sentido de resolución (especifique)" (4).
    public ArrayList NDCotro_sentido_resolucion_segundo_dictamen_especifique(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_100, P1_5_101 from tr_ple_meds1_5 where P1_5_100 <> 4 and P1_5_101 is not null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe introducir un dato en P1_5_102-CX(fecha_resolucion_pleno_iniciativa), P1_5_103-CY(sentido_resolucion_pleno_iniciativa), P1_5_104-CZ(total_votaciones_pleno_iniciativa), P1_5_105-DA(votaciones_pleno_a_favor_iniciativa), P1_5_106-DB(votaciones_pleno_en_contra_iniciativa) y P1_5_107-DC(votaciones_pleno_abstencion_iniciativa) debido a P1_5_8 (estatus_iniciativa) se selecciono una categoria diferente a "Desechada o improcedente" (6) o "Aprobada o procedente" (7)
    public ArrayList fecha_resolucion_pleno_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_8, P1_5_102, P1_5_103, P1_5_104, P1_5_105, P1_5_106, P1_5_107 from tr_ple_meds1_5 where P1_5_8 not in (6, 7) and (P1_5_102 is not null  and P1_5_103 is not null and P1_5_104 is not null and P1_5_105 is not null and P1_5_106 is not null and P1_5_107 is not null) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//La fecha registrada en P1_5_102-CX(fecha_resolucion_pleno_iniciativa) debe ser mayor o igual a la fecha registrada en P1_5_13-M(fecha_sesion_presentacion_iniciativa).
    public ArrayList fecha_resolucion_pleno_iniciativaM(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ENTIDAD, ENTIDAD, \n"
                + "    C1_5_ID, P1_5_1,  to_date(P1_5_102)P1_5_102,\n"
                + "    to_date(P1_5_13)P1_5_13\n"
                + "FROM TR_PLE_MEDS1_5\n"
                + "WHERE \n"
                + "    REGEXP_LIKE(P1_5_13, '^\\d{2}/\\d{2}/\\d{4}$')\n"
                + "AND\n"
                + "    REGEXP_LIKE(P1_5_102, '^\\d{2}/\\d{2}/\\d{4}$') \n"
                + "    AND SUBSTR(P1_5_13, 1, 2) BETWEEN '01' AND '31' \n"
                + "    AND SUBSTR(P1_5_13, 4, 2) BETWEEN '01' AND '12' \n"
                + "    AND SUBSTR(P1_5_102, 1, 2) BETWEEN '01' AND '31' \n"
                + "    AND SUBSTR(P1_5_102, 4, 2) BETWEEN '01' AND '12' \n"
                + "    AND TO_DATE(P1_5_13, 'DD/MM/YYYY') IS NOT NULL \n"
                + "    AND TO_DATE(P1_5_102, 'DD/MM/YYYY') IS NOT NULL\n"
                + "    AND  to_date(P1_5_102,'DD/MM/YYYY')<to_date(P1_5_13,'DD/MM/YYYY')\n"
                + "    and ( to_date(P1_5_102,'DD/MM/YYYY') <> '09/09/1899' AND  to_date(P1_5_102,'DD/MM/YYYY') <> '09/09/1799') "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//En caso de que haya seleccionado la categoría "Desechada o improcedente" (6) en P1_5_8-H(estatus_iniciativa), únicamente puede seleccionar la categoría "Desechado" (1) en P1_5_103-CY(sentido_resolucion_pleno_iniciativa).
    public ArrayList Desechada(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_8, P1_5_103 from tr_ple_meds1_5 where P1_5_8 = 6 and P1_5_103 <> 1 "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//En caso de que haya seleccionado la categoría "Aprobada o procedente" (7) en la columna P1_5_8-H(estatus_iniciativa), únicamente puede seleccionar la categoría "Aprobado" (2) en P1_5_103-CY(sentido_resolucion_pleno_iniciativa).
    public ArrayList estatus_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_8, P1_5_103 from tr_ple_meds1_5 where P1_5_8 = 7 and P1_5_103 <> 2 "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//El total de votaciones en P1_5_104-CZ(total_votaciones_pleno_iniciativa) debe ser igual o menor a la suma de las cantidades reportadas en "P1_1_5(distritos_uninominales)" y "P1_1_6(diputaciones_plurinominales)" de la tabla datos_generales.
    public ArrayList total_votaciones_pleno_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select i.ID_ENTIDAD, i.ENTIDAD, i.C1_5_ID, i.P1_5_1, i.P1_5_104, dg.P1_1_5, dg.P1_1_6, dg.P1_1_5 + dg.P1_1_6 as total from tr_ple_meds1_5 i inner join tr_ple_meds1_1 dg on i.ID_ENTIDAD = dg.ID_ENTIDAD and i.C1_5_ID = dg.C1_1_ID where i.P1_5_104 > (dg.P1_1_5 + dg.P1_1_6) "
                + " AND i.ID_ENTIDAD=" + ID_entidad + " AND i.Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//El total de votaciones en P1_5_104-CZ(total_votaciones_pleno_iniciativa) debe ser igual a la suma de las cantidades reportadas en P1_5_105-DA(votaciones_pleno_a_favor_iniciativa), P1_5_106-DB(votaciones_pleno_en_contra_iniciativa) y P1_5_107-DC(votaciones_pleno_abstencion_iniciativa).
    public ArrayList NDCtotal_votaciones_pleno_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_104, P1_5_105 + P1_5_106 + P1_5_107 as total, P1_5_105, P1_5_106, P1_5_107 from tr_ple_meds1_5 where P1_5_104 <> (P1_5_105 + P1_5_106 + P1_5_107) and P1_5_104 not in ('-1','-2','-3') and P1_5_105 not in ('-1','-2','-3') and P1_5_106 not in ('-1','-2','-3') and P1_5_107 not in ('-1','-2','-3') "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe introducir un dato en P1_5_108-DD(fecha_remision_ejecutivo_iniciativa) y P1_5_109-DE(sentido_resolucion_ejecutivo_iniciativa) debido a P1_5_8 (estatus_iniciativa) se selecciono una categoria diferente a "Aprobada o procedente" (7).
    public ArrayList fecha_remision_ejecutivo_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_8, P1_5_108, P1_5_109 from tr_ple_meds1_5 where P1_5_8 <> 7 and (P1_5_108 is not null and P1_5_109 is not null) "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//La fecha registrada en P1_5_108-DD(fecha_remision_ejecutivo_iniciativa) debe ser igual o mayor a la fecha registrada en P1_5_102-CX(fecha_resolucion_pleno_iniciativa)
    public ArrayList Igfecha_remision_ejecutivo_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ENTIDAD, ENTIDAD, \n"
                + "    C1_5_ID, P1_5_1,  to_date(P1_5_108)P1_5_108,\n"
                + "    to_date(P1_5_102)P1_5_102\n"
                + "FROM TR_PLE_MEDS1_5\n"
                + "WHERE \n"
                + "    REGEXP_LIKE(P1_5_102, '^\\d{2}/\\d{2}/\\d{4}$')\n"
                + "AND\n"
                + "    REGEXP_LIKE(P1_5_108, '^\\d{2}/\\d{2}/\\d{4}$') \n"
                + "    AND SUBSTR(P1_5_102, 1, 2) BETWEEN '01' AND '31' \n"
                + "    AND SUBSTR(P1_5_102, 4, 2) BETWEEN '01' AND '12' \n"
                + "    AND SUBSTR(P1_5_108, 1, 2) BETWEEN '01' AND '31' \n"
                + "    AND SUBSTR(P1_5_108, 4, 2) BETWEEN '01' AND '12' \n"
                + "    AND TO_DATE(P1_5_102, 'DD/MM/YYYY') IS NOT NULL \n"
                + "    AND TO_DATE(P1_5_108, 'DD/MM/YYYY') IS NOT NULL\n"
                + "    AND  to_date(P1_5_108,'DD/MM/YYYY')<to_date(P1_5_102,'DD/MM/YYYY')\n"
                + "    and ( to_date(P1_5_108,'DD/MM/YYYY') <> '09/09/1899' AND  to_date(P1_5_108,'DD/MM/YYYY') <> '09/09/1799') "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//No debe introducir una fecha en P1_5_110-DF(fecha_publicacion_gaceta_oficial_iniciativa) debido a P1_5_109 (sentido_resolucion_ejecutivo_iniciativa) se selecciono una categoria diferente a "Aprobado" (2).
    public ArrayList fecha_publicacion_gaceta_oficial_iniciativa(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ID_ENTIDAD, ENTIDAD, C1_5_ID, P1_5_1, P1_5_109, P1_5_110 from tr_ple_meds1_5 where P1_5_109 = 2 and P1_5_110 is not null "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//La fecha registrada en P1_5_110-DF(fecha_publicacion_gaceta_oficial_iniciativa) debe ser igual o mayor a la fecha registrada en P1_5_108-DD(fecha_remision_ejecutivo_iniciativa).
    public ArrayList fecha(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ENTIDAD, ENTIDAD, \n"
                + "    C1_5_ID, P1_5_1,  to_date(P1_5_110)P1_5_110,\n"
                + "    to_date(P1_5_108)P1_5_108\n"
                + "FROM TR_PLE_MEDS1_5\n"
                + "WHERE \n"
                + "    REGEXP_LIKE(P1_5_108, '^\\d{2}/\\d{2}/\\d{4}$')\n"
                + "AND\n"
                + "    REGEXP_LIKE(P1_5_110, '^\\d{2}/\\d{2}/\\d{4}$') \n"
                + "    AND SUBSTR(P1_5_108, 1, 2) BETWEEN '01' AND '31' \n"
                + "    AND SUBSTR(P1_5_108, 4, 2) BETWEEN '01' AND '12' \n"
                + "    AND SUBSTR(P1_5_110, 1, 2) BETWEEN '01' AND '31' \n"
                + "    AND SUBSTR(P1_5_110, 4, 2) BETWEEN '01' AND '12' \n"
                + "    AND TO_DATE(P1_5_108, 'DD/MM/YYYY') IS NOT NULL \n"
                + "    AND TO_DATE(P1_5_110, 'DD/MM/YYYY') IS NOT NULL\n"
                + "    AND  to_date(P1_5_110,'DD/MM/YYYY')<to_date(P1_5_108,'DD/MM/YYYY')\n"
                + "    and ( to_date(P1_5_110,'DD/MM/YYYY') <> '09/09/1899' AND  to_date(P1_5_110,'DD/MM/YYYY') <> '09/09/1799') "
                + " AND ID_ENTIDAD=" + ID_entidad + " AND Legislatura=" + Legislatura + " AND C1_5_ID='" + Envio + "'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    
    //ID_Iniciativa (A) no tiene en su estructura el número romano correspondiente a la legislatura reportada , en el campo cond_presentacion_iniciativa_legislatura_actual (B) se indica que Sí se presentó la iniciativa en la legislatura acutal.

    public ArrayList ID_LEGISLATURA(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "WITH ESTRUCTURA_ID AS (\n" +
            " SELECT tr.C1_5_ID, TO_ROMAN(tr.legislatura) AS LEGIS_ROMAN, tr.legislatura, tr.ENTIDAD, tr.P1_5_1, tr_1.estatus AS estatus,\n" +
            "        'IN_' || TO_ROMAN(tr.legislatura) || '_' || tr.ENTIDAD || '_' || tr.P1_5_5 AS ID_ESTRUCTURA_Correcta,\n" +
            "        tr.p1_5_2 AS presento_en_legislatura_actual, tr.P1_5_5 AS TURNO_LEGISLATURA\n" +
            "    FROM TR_PLE_MEDS1_5 tr\n" +
               "    FULL JOIN TR_PLE_MEDS1_1_ tr_1 ON tr_1.ID_ENTIDAD = tr.id_entidad AND tr_1.LEGISLATURA = tr.LEGISLATURA AND tr_1.C1_1_ID = tr.C1_5_ID)\n" +
               "SELECT C1_5_ID AS ENVIO, legislatura, LEGIS_ROMAN, ENTIDAD, TURNO_LEGISLATURA,\n" +
            "    ID_ESTRUCTURA_Correcta, P1_5_1 AS ID_actual, estatus, presento_en_legislatura_actual\n" +
            "FROM ESTRUCTURA_ID WHERE  (ENTIDAD=" + ID_entidad + " AND LEGISLATURA=" + Legislatura + "  AND C1_5_ID='" + Envio + "')AND\n" +
            "P1_5_1 <> ID_ESTRUCTURA_Correcta  AND presento_en_legislatura_actual = 1\n" +
            "    AND SUBSTR(P1_5_1, INSTR(P1_5_1, '_') + 1, INSTR(P1_5_1, '_', 1, 2) - INSTR(P1_5_1, '_') - 1) <> LEGIS_ROMAN";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ENTIDAD"),
                    resul.getString("ID_ACTUAL")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }
    // Se debe completar el campo cond_presentacion_iniciativa_periodo (C) en caso de seleccionar la categoría "Sí" en la columna cond_presentacion_iniciativa_legislatura_actual (B).
public ArrayList  P1_5_3_null(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT entidad,C1_5_ID,legislatura, P1_5_1, P1_5_2,P1_5_3 FROM TR_PLE_MEDS1_5\n" +
                "where P1_5_3 is null and P1_5_2 =1"
                + " AND (ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_5_ID = '" + Envio +"')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

// Es necesario capturar P1_5_1-A(ID_iniciativa) debido a que es un campo obligatorio y tiene que contener información.
public ArrayList INI_NOTNULL_P1_5_1(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ENTIDAD, C1_5_ID, LEGISLATURA, P1_5_1, P1_5_1 FROM TR_PLE_MEDS1_5 WHERE P1_5_1 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_5_ID = '" + Envio +"'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

// Es necesario capturar P1_5_2-B(cond_presentacion_iniciativa_legislatura_actual) debido a que es un campo obligatorio y tiene que contener información.
public ArrayList INI_NOTNULL_P1_5_2 (String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ENTIDAD, C1_5_ID, LEGISLATURA, P1_5_1, P1_5_2 FROM TR_PLE_MEDS1_5 WHERE P1_5_2 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_5_ID = '" + Envio +"'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

// Es necesario capturar P1_5_5-E(turno_iniciativa) debido a que es un campo obligatorio y tiene que contener información.
public ArrayList INI_NOTNULL_P1_5_5(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ID_ENTIDAD, C1_5_ID, LEGISLATURA, P1_5_1, P1_5_5 FROM TR_PLE_MEDS1_5 WHERE P1_5_5 IS NULL AND ID_ENTIDAD = '" + ID_entidad + "' AND Legislatura = '" + Legislatura + "' AND C1_5_ID = '" + Envio +"'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("P1_5_1")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }


//Los campos tipo_primer_dictamen (CP)  y  sentido_resolucion_primer_dictamen (CR) deben contener información pues se seleccionó alguna de las siguientes categorías en la columna estatus_iniciativa (H) : "5.Dictamen", "6.Desechada o improcedente" o "7.Aprobada o procedente"
public ArrayList Dictamen_sentido_resolucion(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select TR.ID_ENTIDAD,C1_5_ID AS ENVIO, TR.P1_5_1 as ID_INICIATIVA, TC_ESTATUS.DESCRIPCION AS ESTATUS_INICIATIVA, TC_DICTAMEN.DESCRIPCION  AS tipo_primer_dictamen, SENTIDO_DICTAMEN.descripcion as sentido_dictamen\n" +
            "from TR_PLE_MEDS1_5 TR\n" +
            "full JOIN TC_TIPO_DICTAMEN TC_DICTAMEN on tr.P1_5_94= TC_DICTAMEN.id \n" +
            "full JOIN TC_ESTATUS_INICIATIVA TC_ESTATUS on tr.P1_5_8= TC_ESTATUS.id \n" +
            "full JOIN  TC_SENTIDO_RESOLUCION_DICTAMEN SENTIDO_DICTAMEN ON tr.P1_5_96 = SENTIDO_DICTAMEN.id\n" +
            "WHERE tr.P1_5_8  in (5,6,7) \n" +
            "AND ( ( tr.P1_5_94 IS  NULL) or  ( tr.P1_5_96 IS  NULL) )\n" +
            "AND TR.ID_ENTIDAD = '" + ID_entidad + "' AND TR.Legislatura = '" + Legislatura + "' AND TR.C1_5_ID = '" + Envio +"'";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_ENTIDAD"),
                    resul.getString("ID_INICIATIVA")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
