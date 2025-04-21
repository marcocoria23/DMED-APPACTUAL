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
public class ExportaPCarpetaInvestigacion {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void ExportaPCarpetaInvestigacion(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar();
        String sql = "SELECT \n"
                + "CI.ENTIDADID,\n"
                + "CI.CARPETAID,\n"
                + "CI.NOTICIACRIMINALID,\n"
                + "CI.NOMBREFISREGIOESPECIALIZADA,\n"
                + "CONVERI_TIPOFISCALIAREGESPECIAL(CI.CATFISREGIOESPECIALIZADAID)CATFISREGIOESPECIALIZADAID,\n"
                + "CI.NOMBREAGEMINISTERIOPUBLICO,\n"
                + "CONVERI_AGENCIA(CI.CATTIPOAGENCIAID)CATTIPOAGENCIAID,\n"
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
                + "CI.NOMAGEMINISTERIOPUBLICORESP,\n"
                + "CI.IDAGEMINISTERIOPUBLICORESP,\n"
                + "CONVERI_MEDIOCONOCIMIENTOHECHOS(CI.CATMEDCONOCHECHOSID)CATMEDCONOCHECHOSID,\n"
                + "CI.NUMCARPINVE,\n"
                + "CI.ANIOFOLIOCARPETA,\n"
                + "TO_CHAR(CI.FECHACARINVE,'DD/MM/YYYY')FECHACARINVE,\n"
                + "CI.HORAPECARINVE,\n"
                + "CONVERI_FORMAINICIOCARPETAINVESTIGAC(CI.CATFORMINICARINVEID)CATFORMINICARINVEID,\n"
                + "CONVERI_RESPUESTASGENERICAS(CI.REALACTINVE)CONVERI,\n"
                + "CI.CANTIDADDELITOS,\n"
                + "CI.CANTIDADVICTIMAS,\n"
                + "CI.CANTIDADIMPUTADOS,\n"
                + "CONVERI_HECHOCI(CI.CATHECHOCIID)CATHECHOCIID,\n"
                + "CONVERI_RESPUESTASGENERICAS(CI.REALIZARONASEGURAMIENTOS)REALIZARONASEGURAMIENTOS,\n"
                + "CONVERI_ETAPAPROCESAL(CI.CATETAPAPROCESALID)CATETAPAPROCESALID,\n"
                + "CI.DESCRIPCIONHECHOS,\n"
                + "CI.CARPETAID_FISCALIA,\n"
                + "CI.PERIODO\n"
                + "FROM TR_SENAP_CARPETAINVESTIGACION CI LEFT JOIN TR_SENAP_DIRECCIONUBICACION DU\n"
                + "ON CI.ENTIDADID=DU.ENTIDADID AND CI.PERIODO=DU.PERIODO AND CI.DIRECCIONUBICACIONID=DU.UBICACIONID\n"
                + "WHERE (CI.ENTIDADID='" + Entidad + "' and CI.PERIODO='" + Periodo + "')";
        resul = conexion.consultar(sql);
        
        // Abrir diálogo para guardar archivo
        FileDialog fileDialog = new FileDialog((Frame) null, "Selecciona dónde guardar el archivo CSV", FileDialog.SAVE);
        fileDialog.setFile("PCarpetaInvestigacion.csv"); // Nombre del archivo
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
                JOptionPane.showMessageDialog(null, "El archivo con nombre PCarpetaInvestigacion se ha exportado satisfactoriamente!");

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
