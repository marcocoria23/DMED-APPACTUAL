/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.ExportaPlantillaSenap;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import mx.org.inegi.conexion.SENAP.ConOracle;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class ExportaPActosInvestigacion {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportaPActosInvestigacion(String Entidad, String Periodo) throws SQLException {
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

        // Abrir diálogo para guardar archivo
        FileDialog fileDialog = new FileDialog((Frame) null, "Selecciona dónde guardar el archivo CSV", FileDialog.SAVE);
        fileDialog.setFile("PActosInvestigacion.csv"); // Nombre del archivo
        fileDialog.setVisible(true);

        // Obtener ruta y nombre del archivo seleccionado
        String fileName = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        if (fileName != null && directory != null) {
            String csvFile = new File(directory, fileName).getAbsolutePath();

            // Asegurarse de que el archivo tenga extensión .csv
            if (!csvFile.toLowerCase().endsWith(".csv")) {
                csvFile += ".csv";
            }

            try ( PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
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

                System.out.println("Archivo CSV exportado con éxito: " + csvFile);
                JOptionPane.showMessageDialog(null, "El archivo con nombre PActosInvestigacion se ha exportado satisfactoriamente!");

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
        } else {
            System.out.println("Exportación cancelada por el usuario.");
        }
    }
}
