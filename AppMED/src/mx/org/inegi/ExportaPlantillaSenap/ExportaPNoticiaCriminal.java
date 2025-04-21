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
public class ExportaPNoticiaCriminal {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportarPNoticiCriminal(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar(); // Conexión a la base de datos
        String sql = "SELECT \n"
                + "NC.ENTIDADID,\n"
                + "NC.NOTICIACRIMINALID,\n"
                + "NC.NOMBREFISREGIOESPECIALIZADA,\n"
                + "CONVERI_TIPOFISCALIAREGESPECIAL(NC.CATFISREGIOESPECIALIZADAID)CATFISREGIOESPECIALIZADAID,\n"
                + "NC.NOMBREAGEMINISTERIOPUBLICO,\n"
                + "CONVERI_AGENCIA(NC.CATTIPOAGENCIAID)CATTIPOAGENCIAID,\n"
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
                + "NC.NOMAGEMINISTERIOPUBLICORESP,\n"
                + "NC.IDAGEMINISTERIOPUBLICORESP,\n"
                + "CONVERI_MEDIOCONOCIMIENTOHECHOS(NC.CATMEDCONOCHECHOSID)CATMEDCONOCHECHOSID,\n"
                + "TO_CHAR(NC.FECHAPRESDENUNQUERELLA,'DD/MM/YYYY')FECHAPRESDENUNQUERELLA,\n"
                + "NC.HORAREPREDENUNQUERELLA,\n"
                + "CONVERI_AUTORIDADRECIBIODENUNCIAQUER(NC.CATAUTORDENUNQUERELLAID)CATAUTORDENUNQUERELLAID,\n"
                + "CONVERI_RESPUESTASGENERICAS(NC.BRINDOALGUNTIPOATENCION)BRINDOALGUNTIPOATENCION,\n"
                + "CONVERI_TIPOATENCION(AT.CATTIPOATENCIONID)CATTIPOATENCIONID,\n"
                + "AT.NUMEROATENCION,\n"
                + "TO_CHAR(AT.FECHAINICIOATENCION,'DD/MM/YYYY')FECHAINICIOATENCION,\n"
                + "AT.FECHCONCLUATE,\n"
                + "CONVERI_SENTIDOCONCLUSIONATENCION(AT.CATSENTCONCLUATEID)CATSENTCONCLUATEID,\n"
                + "NC.NOTICIACRIMINALID_FISCALIA,\n"
                + "NC.PERIODO\n"
                + "FROM TR_SENAP_NOTICIACRIMINAL NC LEFT JOIN TR_SENAP_DIRECCIONUBICACION DU\n"
                + "ON NC.ENTIDADID=DU.ENTIDADID AND NC.PERIODO=DU.PERIODO AND NC.DIRECCIONUBICACIONID=DU.UBICACIONID\n"
                + "LEFT JOIN TR_SENAP_ATENCIONES AT\n"
                + "ON\n"
                + "NC.ENTIDADID=AT.ENTIDADID AND NC.PERIODO=AT.PERIODO AND NC.NOTICIACRIMINALID=AT.NOTICIACRIMINALID WHERE (NC.ENTIDADID='" + Entidad + "' and NC.PERIODO='" + Periodo + "')";
        resul = conexion.consultar(sql);

        // Abrir diálogo para guardar archivo
        FileDialog fileDialog = new FileDialog((Frame) null, "Selecciona dónde guardar el archivo CSV", FileDialog.SAVE);
        fileDialog.setFile("PNoticiaCriminal.csv"); // Nombre del archivo
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
                JOptionPane.showMessageDialog(null, "El archivo con nombre PNoticiaCriminal se ha exportado satisfactoriamente!");

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
