/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.ExportaPlantillaSenap;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import mx.org.inegi.conexion.SENAP.ConOracle;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class ExportaPActosInvestigacion {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportaPActosInvestigacion(String Entidad, String Periodo,String CSVFILE) throws SQLException {
        conexion.Conectar(); // Conexión a la base de datos
        String sql = "SELECT \n"
                + "ENTIDADID, \n"
                + "ACTOSID,\n"
                + "CARPETAID,\n"
                + "CATCLASIFICACIONACTOSID,\n"
                + "CONVERI_CLASIFICACIONACTOS(CATCLASIFICACIONACTOSID)DESC_CATCLASIFICACIONACTOSID,\n"
                + "CATACTOSINVESTJUDICIAL,\n"
                + "CONVERI_TIPOACTOSINVESTIGACIONCONTROL(CATACTOSINVESTJUDICIAL)DESC_CATACTOSINVESTJUDICIAL,\n"
                + "ACTOSID_FISCALIA,\n"
                + "PERIODO\n"
                + "FROM TR_SENAP_ACTOSINVESTIGACION"
                + " WHERE (ENTIDADID='" + Entidad + "' and PERIODO='" + Periodo + "')";
        resul = conexion.consultar(sql);

        Vector<String> encabezados = new Vector<>();
        encabezados.add("Identificador Entidad");
        encabezados.add("ActoID ");
        encabezados.add("CarpetaID");
        encabezados.add("ClasificacionActosID ");
        encabezados.add("Descripción Tipo de actos de investigación (sin control judicial o con control judicial)");
        encabezados.add("CatTipoActosInvestigacionControlJudicialID ");
        encabezados.add("DescripcionTipoActoInvestigacionControlJudicial");
        encabezados.add("IdentificadorFiscalia");
        encabezados.add("Periodo");

       
 
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(CSVFILE), "UTF-8"))) {
            // Escribir BOM para UTF-8 (Opcional, útil para Excel)
            writer.write('\uFEFF');
 
            // Escribir encabezados personalizados (del vector)
            /*writer.write("Encabezados personalizados:");
            writer.newLine();*/
            writer.write(String.join(",", encabezados));
            writer.newLine();
 
            // Escribir encabezados del query
           /* writer.write("Encabezados del query:");
            writer.newLine();*/
            StringBuilder columnHeaders = new StringBuilder();
            for (int i = 1; i <= resul.getMetaData().getColumnCount(); i++) {
                columnHeaders.append(resul.getMetaData().getColumnLabel(i));
                if (i < resul.getMetaData().getColumnCount()) {
                    columnHeaders.append(",");
                }
            }
            writer.write(columnHeaders.toString());
            writer.newLine();
 
            // Escribir filas del query
            while (resul.next()) {
                StringBuilder row = new StringBuilder();
                for (int i = 1; i <= resul.getMetaData().getColumnCount(); i++) {
                    String value = resul.getString(i);
                    if (value != null) {
                        value = value.replace("\"", "\"\""); // Escapar comillas dobles
                        if (value.contains(",") || value.contains("\n")) {
                            value = "\"" + value + "\""; // Encapsular en comillas si contiene comas o saltos de línea
                        }
                    } else {
                        value = ""; // Manejar valores nulos
                    }
                    row.append(value);
                    if (i < resul.getMetaData().getColumnCount()) {
                        row.append(",");
                    }
                }
                writer.write(row.toString());
                writer.newLine();
            }
 
            System.out.println("Archivo CSV exportado con éxito: " + CSVFILE);
            //JOptionPane.showMessageDialog(null, "El archivo se ha exportado satisfactoriamente!");
 
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
