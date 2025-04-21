/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidacionesSENAP;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.SENAP.ConOracle;

/**
 *
 * @author ANTONIO.CORIA
 */
public class VAtenciones {

    ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";

    //El campo Fecha de inicio de la atención (columna AA) no debe ser mayor al campo Fecha de conclusión de la atención (columna AB).
    public ArrayList FECHAINICIOATENCION(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,ATENCIONID,PERIODO\n"
                + "FROM TR_SENAP_ATENCIONES\n"
                + "WHERE FECHAINICIOATENCION > FECHCONCLUATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ATENCIONID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //El campo Fecha de inicio de la atención (columna AA) no debe ser mayor a la Fecha Actual.
    public ArrayList FECHAINICIOATENCIONMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,ATENCIONID,PERIODO\n"
                + "FROM TR_SENAP_ATENCIONES\n"
                + "WHERE FECHAINICIOATENCION > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ATENCIONID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }

    //El campo Fecha de conclusión de la atención (columna AB) no debe ser mayor a la Fecha Actual.
    public ArrayList FECHCONCLUATEMayor(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "SELECT ENTIDADID,ATENCIONID,PERIODO\n"
                + "FROM TR_SENAP_ATENCIONES\n"
                + "WHERE FECHCONCLUATE > SYSDATE AND (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "'  )";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("ATENCIONID")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VNoticiaCriminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    }


}
