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
public class ExportaPDelitos {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportaPDelitos(String Entidad, String Periodo, String csvFile) throws SQLException {
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

        Vector<String> encabezados = new Vector<>();
        encabezados.add("IDENTIFICADOR ENTIDAD");
        encabezados.add("DelitoID ");
        encabezados.add("CarpetaID");
        encabezados.add("Delito de acuerdo con la ley penal ");
        encabezados.add("Señalamiento normativo ");
        encabezados.add("Fuero");
        encabezados.add("Delito de acuerdo con la Norma Técnica (INEGI) ");
        encabezados.add("Fecha de ocurrencia (exacta /aproximada/continua)");
        encabezados.add("Hora de ocurrencia  (exacta/ aproximada/continua)");
        encabezados.add("Tipo de vialidad ");
        encabezados.add("Nombre de la vialidad (Calle)");
        encabezados.add("Tipo de asentamiento ");
        encabezados.add("Nombre del asentamiento (Colonia)");
        encabezados.add("Número exterior");
        encabezados.add("Número interior");
        encabezados.add("Código postal");
        encabezados.add("Localidad");
        encabezados.add("Municipio/ Demarcación territorial ");
        encabezados.add("Entidad federativa ");
        encabezados.add("Latitud");
        encabezados.add("Longitud ");
        encabezados.add("Tipo de sitio de ocurrencia  ");
        encabezados.add("Grado de consumación ");
        encabezados.add("Calificación del delito");
        encabezados.add("Forma de comisión");
        encabezados.add("Forma de acción");
        encabezados.add("Modalidad");
        encabezados.add("Instrumentos para la comisión");
        encabezados.add("Contexto situacional (solo para homicidio y lesiones)");
        encabezados.add("¿Hubo reclasificación del delito?");
        encabezados.add("Momento en el que se llevó a cabo la reclasificación ");
        encabezados.add("Fecha de la reclasificación");
        encabezados.add("DelitoID_Reclasificado ");
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