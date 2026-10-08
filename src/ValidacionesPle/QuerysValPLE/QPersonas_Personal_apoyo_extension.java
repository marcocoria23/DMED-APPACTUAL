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
 * @author Laura.medina
 */
public class QPersonas_Personal_apoyo_extension {

    DaoConexion conexion = new DaoConexion();
    String sql;
    ArrayList<String[]> Array;
    ResultSet resul;




    // No se encontró registro del ID persona legisladora en la tabla personas_legisladoras
    public ArrayList ID_PERSONA_LEGISLADORA_4A(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();

        sql = "SELECT P.P1_4_38, P.ID_ENTIDAD "
                + "FROM TR_PLE_MEDS1_4A P "
                + "LEFT JOIN TR_PLE_MEDS1_3 S "
                + "ON P.ID_ENTIDAD = S.ID_ENTIDAD "
                + "AND P.LEGISLATURA = S.LEGISLATURA "
                + "AND P.C1_4A_ID = S.C1_3_ID "
                + "AND P.P1_4_38 = S.P1_3_1 "
                + "WHERE S.P1_3_1 IS NULL "
                + "AND P.P1_4_38 IS NOT NULL "
                + "AND P.ID_ENTIDAD = '" + ID_entidad + "' "
                + "AND P.LEGISLATURA = '" + Legislatura + "' "
                + "AND P.C1_4A_ID = '" + Envio + "'";

        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("P1_4_38"),
                    resul.getString("ID_ENTIDAD")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QPersonas_Personal_apoyo_extension.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //  // No se encontró registro del ID de la comisión en la tabla comisione_legislatias
    public ArrayList ID_COMISION_4A(String ID_entidad, String Legislatura, String Envio) {
        conexion.Conectar();
        Array = new ArrayList();

        sql = "SELECT P.P1_4_40, P.ID_ENTIDAD "
                + "FROM TR_PLE_MEDS1_4A P "
                + "LEFT JOIN TR_PLE_MEDS1_2 S "
                + "ON P.ID_ENTIDAD = S.ID_ENTIDAD "
                + "AND P.LEGISLATURA = S.LEGISLATURA "
                + "AND P.C1_4A_ID = S.C1_2_ID "
                + "AND P.P1_4_40 = S.P1_2_1 "
                + "WHERE S.P1_2_1 IS NULL "
                + "AND P.P1_4_40 IS NOT NULL "
                + "AND P.ID_ENTIDAD = '" + ID_entidad + "' "
                + "AND P.LEGISLATURA = '" + Legislatura + "' "
                + "AND P.C1_4A_ID = '" + Envio + "'";

        System.out.println(sql);
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("P1_4_40"),
                    resul.getString("ID_ENTIDAD")
                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(QPersonas_Personal_apoyo_extension.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

}
