/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author LAURA.MEDINAJ
 */
public class VMedidaCautelar {
      ConOracle conexion = new ConOracle();
    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<String[]> Array;
    public static String Query = "";

    //Regla Adicional -- Favor de verificar el campo Tipo de medida cautelar	CATMEDIDAID debido a que debe tener una opcion valida.
    public ArrayList CATMEDIDAID122024(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        Array = new ArrayList();
        sql = "select ENTIDADID, PERIODO, CARPETAID, PROCESOID, MEDIDACAUTELARID, CATMEDIDAID\n" +
"from TR_SENAP_MEDIDASCAUTELARES\n" +
"where CATMEDIDAID in (0) or CATMEDIDAID is null"
                + " and  (ENTIDADID='" + Entidad + "' AND PERIODO='" + Periodo + "')";
        System.out.println(sql);
        Query = sql;
        resul = conexion.consultar(sql);
        try {
            while (resul.next()) {
                Array.add(new String[]{
                    resul.getString("MEDIDACAUTELARID, ")

                });
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(VCarpetaInvetigacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Array;
    } 
    
    
}
