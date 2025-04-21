/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.ExportaPlantillaSenap;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.org.inegi.conexion.SENAP.ConOracle;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class ExportaPAseguramientos {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportarPAseguramientos(String Entidad, String Periodo, String CSVFILE) throws SQLException {
        String sql = "SELECT \n"
                + "ENTIDADID,\n"
                + "ENTFISASEGID,\n"
                + "ENTFISASEGID_FISCALIA,\n"
                + "CATFISCALIAID,\n"
                + "CARPETAID,\n"
                + "CARPETAID_FISCALIA,\n"
                + "converi_clasificacionbienasegurado(CATCLASBIENSEG)CATCLASBIENSEG,\n"
                + "CONVERI_TIPOBIENASEGURADO(CATTIPBIENSEG)CATTIPBIENSEG,\n"
                + "CANTBIESEG,\n"
                + "converi_UNIDADMEDIDA(CATUNIDADMEDIDAID)CATUNIDADMEDIDAID\n"
                + "FROM\n"
                + "TR_SENAP_ASEGURAMIENTOS\n"
                + "where Entidadid='" + Entidad + "' and PERIODO='" + Periodo + "'  ";
        conexion.Conectar(); // Conexión a la base de datos
        resul = conexion.consultar(sql);

        //try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
        try ( PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(CSVFILE), StandardCharsets.UTF_8))) {
            // Escribir encabezados
            int columnCount = resul.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                writer.print(resul.getMetaData().getColumnName(i));
                if (i < columnCount) {
                    writer.print(","); // Separador
                }
            }
            writer.println();

            // Escribir filas
            while (resul.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    writer.print(resul.getString(i));
                    if (i < columnCount) {
                        writer.print(","); // Separador
                    }
                }
                writer.println();
            }

            System.out.println("Archivo CSV exportado con éxito: " + CSVFILE);
            //JOptionPane.showMessageDialog(null, "El archivo con nombre PControl se ha exportado satisfactoriamente!!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resul != null) {
                try {
                    resul.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            conexion.close();
        }
    }

}
