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
public class QPersonas_legisladoras_extension {

    DaoConexion conexion = new DaoConexion();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;

//ID_COMISION_LEGISLATIVA P1_3A_122 DE LA TABLA TR_PLE_MEDS1_3A DEBE DE EXISTIR EN LA TABLA 2
    public ArrayList ID_COMISION_LEGISLATIVA(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT P1_3A_121,P1_3A_122,ID_ENTIDAD,P1_2_1,C1_3A_ID,Legislatura FROM(\n"
                + "select P.P1_3A_121,P.P1_3A_122,P.ID_ENTIDAD,S.P1_2_1,P.C1_3A_ID,P.Legislatura from TR_PLE_MEDS1_3A P LEFT JOIN\n"
                + "TR_PLE_MEDS1_2 S \n"
                + "ON P.ID_ENTIDAD= S.ID_ENTIDAD\n"
                + "AND P.C1_3A_ID=  S.C1_2_ID\n"
                + "AND P.LEGISLATURA=S.LEGISLATURA\n"
                + "AND P.P1_3A_122=S.P1_2_1\n"
                + ")WHERE P1_2_1 IS NULL \n"
                + " AND (ID_ENTIDAD='" + ID_entidad + "' AND Legislatura='" + Legislatura + "' AND C1_3A_ID='" + Envio + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("P1_3A_121"),
                    resul.getString("P1_3A_122"),
                    resul.getString("ID_ENTIDAD")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//ID_persona_legisladora DE LA TABLA TR_PLE_MEDS1_3A Extension debe de existir en ID_persona_legisladora en la tabla TR_PLE_MEDS1_3 pestala Persona_legisladora
    public ArrayList ID_PERSONA_LEGISLADORA(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT P1_3A_120,P1_3A_121,P1_3A_122,P1_3_1,C1_3A_ID,Legislatura,ID_ENTIDAD FROM(\n"
                + "select P.P1_3A_120,P.P1_3A_121,p.P1_3A_122,S.P1_3_1,P.C1_3A_ID,P.Legislatura,P.ID_ENTIDAD from TR_PLE_MEDS1_3A P LEFT JOIN\n"
                + "TR_PLE_MEDS1_3 S \n"
                + "ON P.ID_ENTIDAD= S.ID_ENTIDAD\n"
                + "AND P.C1_3A_ID=  S.C1_3_ID\n"
                + "AND P.LEGISLATURA=S.LEGISLATURA\n"
                + "AND P.P1_3A_121=S.P1_3_1\n"
                + ")WHERE P1_3_1 IS NULL\n"
                + " AND (ID_ENTIDAD='" + ID_entidad + "' AND Legislatura='" + Legislatura + "' AND C1_3A_ID='" + Envio + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("P1_3A_121"),
                    resul.getString("P1_3A_122"),
                    resul.getString("ID_ENTIDAD")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

//Cantidad de reuniones de la comisión legislativa asistidas por la persona legisladora P1_3A_125 de la tabla TR_PLE_MEDS1_3A Personas_legisladoras_Extension  Debe ser igual o menor a la columna cant_reuniones_celebradas_comision_legislativa CAMPO  P1_2_15 (P)   TABLA  (TR_PLE_MEDS1_2)
    public ArrayList Cant_Reuniones(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT P1_3A_120,P1_3A_121, P1_3A_122,P1_3A_125 ,P1_2_15,C1_3A_ID,Legislatura,ID_ENTIDAD FROM(\n"
                + "select P.P1_3A_120,P1_3A_121, P1_3A_122,P.P1_3A_125 ,S.P1_2_15,P.C1_3A_ID,P.Legislatura,P.ID_ENTIDAD from TR_PLE_MEDS1_3A P LEFT JOIN\n"
                + "TR_PLE_MEDS1_2 S \n"
                + "ON P.ID_ENTIDAD= S.ID_ENTIDAD\n"
                + "AND P.C1_3A_ID=  S.C1_2_ID\n"
                + "AND P.LEGISLATURA=S.LEGISLATURA\n"
                + "AND P.P1_3A_125>= S.P1_2_15\n"
                + ")WHERE P1_2_15 IS NULL and P1_2_15 is not null\n"
                + " AND (ID_ENTIDAD='" + ID_entidad + "' AND Legislatura='" + Legislatura + "' AND C1_3A_ID='" + Envio + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    //resul.getString("P1_3A_120"),
                    //resul.getString("P1_3A_125")
                    resul.getString("P1_3A_121"),
                    resul.getString("P1_3A_122"),
                    resul.getString("ID_ENTIDAD")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////El ID_COMISION_LEGISLATIVA (P1_3A_122) de la tabla Personas_Legisladoras_extension YA EXISTE en la tabla Personas Legisladoras. Favor de revisar la duplicidad para los ID que se indican
    public ArrayList COMISION_REPETIDA(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT PER_EXT.P1_3A_120 AS Numero_consecutivo_extension , \n"
                + "PER_EXT.P1_3A_121 AS ID_persona_legisladora_extension, \n"
                + "PER.P1_3_1 as ID_PERSONA_ORIGEN, \n"
                + "PER_EXT.P1_3A_122 AS ID_comision_legislativa_extension,\n"
                + "PER.P1_3_80 as COM_1,\n"
                + "PER.P1_3_84 as COM_2,PER.P1_3_88 AS COM_3,\n"
                + "PER.P1_3_92 AS COM_4,PER.P1_3_96 AS COM_5, \n"
                + "PER.P1_3_100 AS COM_6,PER.P1_3_104 as COM_7,\n"
                + "PER.P1_3_108 AS COM_8,PER.P1_3_112 AS COM_9,\n"
                + "PER.P1_3_116 AS COM_10, \n"
                + "PER_EXT.C1_3A_ID AS ENVIO, \n"
                + "PER_EXT.Legislatura,\n"
                + "PER_EXT.ID_ENTIDAD \n"
                + "from TR_PLE_MEDS1_3A PER_EXT\n"
                + "LEFT JOIN TR_PLE_MEDS1_3 PER \n"
                + "ON PER_EXT.ID_ENTIDAD= PER.ID_ENTIDAD\n"
                + "AND PER_EXT.C1_3A_ID=  PER.C1_3_ID\n"
                + "AND PER_EXT.LEGISLATURA=PER.LEGISLATURA\n"
                + "AND PER_EXT.P1_3A_121=PER.P1_3_1\n"
                + "--comparar que no haya repetidos\n"
                + "WHERE ( PER.P1_3_80 = PER_EXT.P1_3A_122 \n"
                + "OR PER.P1_3_84=PER_EXT.P1_3A_122 \n"
                + "OR  PER.P1_3_88=PER_EXT.P1_3A_122 \n"
                + "OR PER.P1_3_92= PER_EXT.P1_3A_122 \n"
                + "OR PER.P1_3_96= PER_EXT.P1_3A_122\n"
                + "OR PER.P1_3_100=PER_EXT.P1_3A_122 \n"
                + "OR  PER.P1_3_104=PER_EXT.P1_3A_122 \n"
                + "OR PER.P1_3_108= PER_EXT.P1_3A_122 \n"
                + "OR PER.P1_3_112= PER_EXT.P1_3A_122\n"
                + "OR PER.P1_3_116= PER_EXT.P1_3A_122 )\n"
                + "AND (PER_EXT.ID_ENTIDAD='" + ID_entidad + "' AND PER_EXT.Legislatura='" + Legislatura + "' AND PER_EXT.C1_3A_ID='" + Envio + "')";
        /*sql = "SELECT PER_EXT.P1_3A_120 AS Numero_consecutivo_extension , PER_EXT.P1_3A_121 AS ID_persona_legisladora_extension, \n"
                + "PER.P1_3_1 as ID_PERSONA_ORIGEN, PER_EXT.P1_3A_122 AS ID_comision_legislativa_extension,\n"
                + "PER.P1_3_80 as COM_1,PER.P1_3_84 as COM_2,PER.P1_3_88 AS COM_3,PER.P1_3_92 AS COM_4,PER.P1_3_96 AS COM_5, \n"
                + "PER.P1_3_100 AS COM_6,PER.P1_3_104 as COM_7,PER.P1_3_108 AS COM_8,PER.P1_3_112 AS COM_9,PER.P1_3_116 AS COM_10, \n"
                + "PER_EXT.C1_3A_ID AS ENVIO, PER_EXT.Legislatura,PER_EXT.ID_ENTIDAD \n"
                + "from TR_PLE_MEDS1_3A PER_EXT\n"
                + "LEFT JOIN TR_PLE_MEDS1_3 PER \n"
                + "ON PER_EXT.ID_ENTIDAD= PER.ID_ENTIDAD\n"
                + "AND PER_EXT.C1_3A_ID=  PER.C1_3_ID\n"
                + "AND PER_EXT.LEGISLATURA=PER.LEGISLATURA\n"
                + "AND PER_EXT.P1_3A_121=PER.P1_3_1\n"
                + "--comparar que no haya repetidos\n"
                + "WHERE  PER.P1_3_80=PER_EXT.P1_3A_122 OR PER.P1_3_84=PER_EXT.P1_3A_122 OR  PER.P1_3_88=PER_EXT.P1_3A_122 OR PER.P1_3_92= PER_EXT.P1_3A_122 OR PER.P1_3_96= PER_EXT.P1_3A_122\n"
                + "OR PER.P1_3_100=PER_EXT.P1_3A_122 OR  PER.P1_3_104=PER_EXT.P1_3A_122 OR PER.P1_3_108= PER_EXT.P1_3A_122 OR PER.P1_3_112= PER_EXT.P1_3A_122\n"
                + "OR PER.P1_3_116= PER_EXT.P1_3A_122 AND (PER_EXT.ID_ENTIDAD='" + ID_entidad + "' AND PER_EXT.Legislatura='" + Legislatura + "' AND PER_EXT.C1_3A_ID='" + Envio + "')";*/
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_persona_legisladora_extension"),
                    resul.getString("ID_comision_legislativa_extension"),
                    resul.getString("ID_ENTIDAD")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

////Aún hay espacio en la tabla personas_legisladoras para anotar Comisiones legislativas. Favor de eliminar los registros de la tabla de extensión y completar los espacios vacíos de comisiones para el ID de personas que se indica
    public ArrayList COMISION_ESPACIO_DISPONIBLE(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT PER_EXT.P1_3A_120 AS Numero_consecutivo_extension , PER_EXT.P1_3A_121 AS ID_persona_legisladora_extension, \n"
                + "PER.P1_3_1 as ID_PERSONA_ORIGEN, PER_EXT.P1_3A_122 AS Numero_comision_legislativa,\n"
                + "PER.P1_3_80 as COM_1,PER.P1_3_84 as COM_2,PER.P1_3_88 AS COM_3,PER.P1_3_92 AS COM_4,PER.P1_3_96 AS COM_5, \n"
                + "PER.P1_3_100 AS COM_6,PER.P1_3_104 as COM_7,PER.P1_3_108 AS COM_8,PER.P1_3_112 AS COM_9,PER.P1_3_116 AS COM_10, \n"
                + "PER_EXT.C1_3A_ID AS ENVIO, PER_EXT.Legislatura,PER_EXT.ID_ENTIDAD \n"
                + "from TR_PLE_MEDS1_3A PER_EXT\n"
                + "LEFT JOIN TR_PLE_MEDS1_3 PER \n"
                + "ON PER_EXT.ID_ENTIDAD= PER.ID_ENTIDAD\n"
                + "AND PER_EXT.C1_3A_ID=  PER.C1_3_ID\n"
                + "AND PER_EXT.LEGISLATURA=PER.LEGISLATURA\n"
                + "AND PER_EXT.P1_3A_121=PER.P1_3_1\n"
                + "--comparar que no haya repetidos\n"
                + "WHERE (PER.P1_3_80 is null OR PER.P1_3_84 is null OR  PER.P1_3_88 is null OR PER.P1_3_92 is null OR PER.P1_3_96 is null\n"
                + "OR PER.P1_3_100 is null OR  PER.P1_3_104 is null OR PER.P1_3_108 is null OR PER.P1_3_112 is null OR PER.P1_3_116 is null)\n"
                + " AND (PER_EXT.ID_ENTIDAD='" + ID_entidad + "' AND PER_EXT.Legislatura='" + Legislatura + "' AND PER_EXT.C1_3A_ID='" + Envio + "')";
        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ID_persona_legisladora_extension"),
                    resul.getString("Numero_comision_legislativa"),
                    resul.getString("ID_ENTIDAD"),});
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QComisiones_Legislativas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
