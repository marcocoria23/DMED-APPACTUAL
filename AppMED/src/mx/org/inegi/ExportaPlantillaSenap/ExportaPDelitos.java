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
public class ExportaPDelitos {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportaPDelitos(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar(); // Conexión a la base de datos
        String sql = "SELECT\n"
                + "DELI.ENTIDADID,\n"
                + "DELITOID,\n"
                + "CARPETAID,\n"
                + "DELITOLEYPENAL,\n"
                + "SENALAMIENTONORMATIVO,\n"
                + "CONVERI_FUERO(CATFUEROID)CATFUEROID,\n"
                + "CONVERI_DELITONORMATECNICA(CATDELITONORMATECNICAID)CATDELITONORMATECNICAID,\n"
                + "TO_CHAR(FECHAOCURRENCIA,'DD/MM/YYYY'),\n"
                + "HORAOCURRENCIA,\n"
                + "CONVERI_TIPOVIALIDAD(DU.CATTIPOVIALIDADID)CATTIPOVIALIDADID,\n"
                + "DU.CALLEVIALIDAD,\n"
                + "CONVERI_COLONIA(DU.CATCOLONIAID)CATCOLONIAID,\n"
                + "COLONIA,\n"
                + "DU.NUMEROEXTERIOR,\n"
                + "DU.NUMEROINTERIOR,\n"
                + "DU.CODIGOPOSTAL,\n"
                + "DU.LOCALIDAD,\n"
                + "CONVERI_MUNICIPIODEMARCACIONTERRITOR(DU.CATDEMARCACIONID)CATDEMARCACIONID,\n"
                + "CONVERI_ENTIDADFEDERATIVA(DU.CATENTFEDID)CATENTFEDID,\n"
                + "DU.LATITUD,\n"
                + "DU.LONGITUD,\n"
                + "CONVERI_TIPOSITIOOCURRENCIA(CATTIPOSITIOOCURRENCIAID)CATTIPOSITIOOCURRENCIAID,\n"
                + "CONVERI_GRADOCONSUMACION(CATGRADOCONSUMACIONID)CATGRADOCONSUMACIONID,\n"
                + "CONVERI_CALIFICACIONDELITO(CATCALIFICACIONDELITOID)CATCALIFICACIONDELITOID,\n"
                + "CONVERI_FORMACOMISION(CATFORMACOMISIONID)CATFORMACOMISIONID,\n"
                + "CONVERI_FORMAACCION(CATFORMAACCIONID)CATFORMAACCIONID,\n"
                + "CONVERI_MODALIDAD (CATMODALIDADID)CATMODALIDADID,\n"
                + "CONVERI_INSTRUMENTOSCOMISION (CATINSTRUMENTOSCOMISIONID)CATINSTRUMENTOSCOMISIONID,\n"
                + "CONVERI_CONTEXTOSITUACIONAL (CATCONTEXTOSITUACIONALID)CATCONTEXTOSITUACIONALID,\n"
                + "CONVERI_RESPUESTASGENERICAS(HUBORECLASIFICACION)HUBORECLASIFICACION,\n"
                + "CONVERI_MOMENTORECLASIFICACION(CATMOMENTORECLASIFICACIONID)CATMOMENTORECLASIFICACIONID,\n"
                + "TO_CHAR(FECHARECLASIFICACION,'DD/MM/YYYY')FECHARECLASIFICACION,\n"
                + "DELITOID_RECLASIFICADO,\n"
                + "DELITOID_FISCALIA,\n"
                + "DELI.PERIODO\n"
                + "FROM TR_SENAP_DELITOS DELI LEFT JOIN TR_SENAP_DIRECCIONUBICACION DU\n"
                + "ON DELI.ENTIDADID=DU.ENTIDADID AND DELI.PERIODO=DU.PERIODO AND DELI.DIRECCIONUBICACIONID=DU.UBICACIONID"
                + " WHERE (DELI.ENTIDADID='" + Entidad + "' and DELI.PERIODO='" + Periodo + "')";
        resul = conexion.consultar(sql);

        // Abrir diálogo para guardar archivo
        FileDialog fileDialog = new FileDialog((Frame) null, "Selecciona dónde guardar el archivo CSV", FileDialog.SAVE);
        fileDialog.setFile("PDelitos.csv"); // Nombre del archivo
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
                JOptionPane.showMessageDialog(null, "El archivo con nombre PDelitos se ha exportado satisfactoriamente!");

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
