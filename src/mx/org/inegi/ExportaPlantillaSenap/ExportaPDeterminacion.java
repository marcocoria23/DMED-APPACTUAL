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
public class ExportaPDeterminacion {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportaPDeterminacion(String Entidad, String Periodo, String csvFile) throws SQLException {
        conexion.Conectar(); // Conexión a la base de datos
        String sql = "SELECT \n"
                + "ENTIDADID,\n"
                + "DETERMINACIONID,\n"
                + "CARPETAID,\n"
                + "IMPUTADOID,\n"
                + "IMPUTADODELITOID,\n"
                + "CONVERI_ESTATUSCARPETAINVESTIGAC(CATESTATUSCARPETAID)CATESTATUSCARPETAID,\n"
                + "CONVERI_SENTIDODETERMINACION(CATSENDETID)CATSENDETID,\n"
                + "CONVERI_TIPOACUERDOREPARATORIO(CATACURECID)CATACURECID,   \n"
                + "CONVERI_RESPUESTASGENERICAS(HUBOREACTCARPETAINVEST)HUBOREACTCARPETAINVEST,\n"
                + "TO_CHAR(FECHADETERMINACION,'DD/MM/YYYY')FECHADETERMINACION,\n"
                + "CATETAPAPROCESALID,\n"
                + "DETERMINACIONID_FISCALIA,\n"
                + "PERIODO\n"
                + "FROM TR_SENAP_DETERMINACION"
                + " WHERE (ENTIDADID='" + Entidad + "' and PERIODO='" + Periodo + "')";
        resul = conexion.consultar(sql);

        Vector<String> encabezados = new Vector<>();
        encabezados.add("ENTIDADID");
        encabezados.add("DeterminacionID");
        encabezados.add("CarpetaID");
        encabezados.add("ImputadoID");
        encabezados.add("ImputadoDelitoID");
        encabezados.add("Estatus de la carpeta de investigación ");
        encabezados.add("Sentido de la determinación");
        encabezados.add("En caso de acuerdos reparatorios ¿tipo de acuerdos reparatorios?");
        encabezados.add("En caso de archivo temporal ¿hubo reactivación de la carpeta de investigación? ");
        encabezados.add("Fecha de la determinación (aplica también para fecha de reactivación en caso de archivo temporal y criterio de oportunidad) ");
        encabezados.add("Etapa procesal en la que se dictó la determinación");
        encabezados.add("IdentificadorFiscalia");
        encabezados.add("PERIODO");

        try ( BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"))) {
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

                System.out.println("Archivo CSV exportado con éxito: " + csvFile);
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