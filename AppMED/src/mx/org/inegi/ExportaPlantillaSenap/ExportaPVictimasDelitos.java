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
public class ExportaPVictimasDelitos {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportaPVictimasDelito(String Entidad, String Periodo) throws SQLException {
        conexion.Conectar(); // Conexión a la base de datos
        String sql = "SELECT \n"
                + "VIC.ENTIDADID,\n"
                + "DEL.VICTIMASDELITOID,\n"
                + "DEL.DELITOID,\n"
                + "DEL.VICTIMAID,\n"
                + "VIC.CARPETAID,\n"
                + "VIC.NOMBREVICTIMA,\n"
                + "CONVERI_TIPOVICTIMA(VIC.CATTIPOVICTIMAID)CATTIPOVICTIMAID,\n"
                + "VIC.CURP,\n"
                + "TO_CHAR(VIC.FECHANACIMIENTO,'DD/MM/YYYY')FECHANACIMIENTO,\n"
                + "VIC.EDADMOMSUCHEC,\n"
                + "CONVERI_SEXO(VIC.CATSEXOID)CATSEXOID,\n"
                + "CONVERI_SITUACIONCONYUGAL(VIC.CATSITUACIONCONYUGALID)CATSITUACIONCONYUGALID,\n"
                + "VIC.VESTIMENTARASGOSVISIBLES,\n"
                + "CONVERI_NACIONALIDAD(CATNACIONALIDADID)CATNACIONALIDADID,\n"
                + "CONVERI_SITUACIONMIGRATORIA (CATSITUACIONMIGRATORIAID)CATSITUACIONMIGRATORIAID,\n"
                + "CONVERI_PAIS(CATPAISNACIMIENTOID)CATPAISNACIMIENTOID,\n"
                + "CONVERI_ENTIDADFEDERATIVA (CATENTIDADNACIMIENTOID)CATENTIDADNACIMIENTOID,\n"
                + "CONVERI_MUNICIPIODEMARCACIONTERRITOR(CATMUNICIPIOID)CATMUNICIPIOID,\n"
                + "CONVERI_PAIS(CATPAISRESHAB)CATPAISRESHAB,\n"
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
                + "VIC.NUMEROTELEFONICO,\n"
                + "CONVERI_RESPUESTASGENERICAS (HABLAESPANIOL)HABLAESPANIOL,\n"
                + "CONVERI_RESPUESTASGENERICAS  (HABLALENGUAEXTRANJERA)HABLALENGUAEXTRANJERA,\n"
                + "CONVERI_TIPOLENGUAEXTRANJERA (CATTIPLEGEXT)CATTIPLEGEXT,\n"
                + "CONVERI_RESPUESTASGENERICAS(HABLALENGUAINDIGENA)HABLALENGUAINDIGENA,\n"
                + "CONVERI_TIPOLENGUAINDIGENA(CATTIPOLENGUAINDIGENAID)CATTIPOLENGUAINDIGENAID,\n"
                + "CONVERI_RESPUESTASGENERICAS(UTITRAINT)UTITRAINT,\n"
                + "CONVERI_RESPUESTASGENERICAS(PRESENTADISCAPACIDAD)PRESENTADISCAPACIDAD,\n"
                + "CONVERI_TIPODISCAPACIDAD(CATTIPODISCAPACIDADID)CATTIPODISCAPACIDADID,\n"
                + "CONVERI_RESPUESTASGENERICAS(MEDIOTECDISCAPACIDAD)MEDIOTECDISCAPACIDAD,\n"
                + "CONVERI_RESPUESTASGENERICAS(PERPOPIND)PERPOPIND,\n"
                + "CONVERI_POBLACIONINDIGENAPERTENECE(CATTIPPOPIND)CATTIPPOPIND,\n"
                + "CONVERI_RESPUESTASGENERICAS(PERPOBLGBTTTI)PERPOBLGBTTTI,\n"
                + "CONVERI_POBLACIONLGBTTTIPERTENECE(CATTIPOLGBTTTIID)CATTIPOLGBTTTIID,\n"
                + "CONVERI_RESPUESTASGENERICAS (PERPOBSITCALLE)PERPOBSITCALLE,\n"
                + " CONVERI_RESPUESTASGENERICAS(SABELEERESCRIBIR)SABELEERESCRIBIR,\n"
                + " CONVERI_NIVELESCOLARIDAD(CATNIVELESCOLARIDADID)CATNIVELESCOLARIDADID,\n"
                + " CONVERI_OCUPACION (CATOCUPACIONID)CATOCUPACIONID,\n"
                + " VIC.RANINGMENNET,\n"
                + " CONVERI_RESPUESTASGENERICAS(HECANTVICMANSUFVIOL)HECANTVICMANSUFVIOL,\n"
                + "  CONVERI_RESPUESTASGENERICAS(CONTOASESORJURIDICO)CONTOASESORJURIDICO,\n"
                + "  CONVERI_TIPOASESORJURIDICO(CATTIPOASESORJURIDICOID)CATTIPOASESORJURIDICOID,\n"
                + "  CONVERI_RESPUESTASGENERICAS(RECIBIOATENCIONMEDICA)RECIBIOATENCIONMEDICA,\n"
                + "  CONVERI_RESPUESTASGENERICAS (RECATEPSICO)RECATEPSICO,\n"
                + "CONVERI_MEDIDAPROTECCION( MP.CATMEDIDAPROTECCION)CATMEDIDAPROTECCION,\n"
                + "VIC.VICTIMAID_FISCALIA,\n"
                + "VIC.PERIODO\n"
                + "FROM TR_SENAP_VICTIMAS VIC LEFT JOIN TR_SENAP_VICTIMASDELITO DEL\n"
                + "ON VIC.ENTIDADID=DEL.ENTIDADID AND VIC.PERIODO=DEL.PERIODO AND VIC.VICTIMAID=DEL.VICTIMAID\n"
                + "LEFT JOIN TR_SENAP_DIRECCIONUBICACION DU\n"
                + "ON VIC.ENTIDADID=DU.ENTIDADID AND VIC.PERIODO=DU.PERIODO AND VIC.DIRECCIONUBICACIONID=DU.UBICACIONID\n"
                + "LEFT JOIN TR_SENAP_MEDIDAS_PROTECCION MP ON\n"
                + "VIC.ENTIDADID=MP.ENTIDADID AND VIC.PERIODO=MP.PERIODO AND VIC.CARPETAID=MP.CARPETAID AND VIC.VICTIMAID=MP.VICTIMAID"
                + " WHERE (VIC.ENTIDADID='" + Entidad + "' and VIC.PERIODO='" + Periodo + "')";
        resul = conexion.consultar(sql);

        // Abrir diálogo para guardar archivo
        FileDialog fileDialog = new FileDialog((Frame) null, "Selecciona dónde guardar el archivo CSV", FileDialog.SAVE);
        fileDialog.setFile("PVictimasDelito.csv"); // Nombre del archivo
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
                JOptionPane.showMessageDialog(null, "El archivo con nombre PVictimasDelito se ha exportado satisfactoriamente!");

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
