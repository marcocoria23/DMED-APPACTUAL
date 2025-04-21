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
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import mx.org.inegi.conexion.SENAP.ConOracle;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class ExportaPNoticiaCriminal {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportarPNoticiCriminal(String Entidad, String Periodo,String csvFile) throws SQLException {
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

        // Crear un Vector para los encabezados personalizados
        Vector<String> encabezados = new Vector<>();
        encabezados.add("Identificador Entidad");
        encabezados.add("NoticiaCriminalID");
        encabezados.add("Nombre de la fiscalía regional o especializada");
        encabezados.add("Tipo de fiscalía regional o especializada");
        encabezados.add("Nombre y número de agencia del ministerio público");
        encabezados.add("Tipo de agencia");
        encabezados.add("Tipo de vialidad");
        encabezados.add("Nombre de la vialidad (Calle)");
        encabezados.add("Tipo de asentamiento");
        encabezados.add("Nombre del asentamiento (Colonia)");
        encabezados.add("Número exterior");
        encabezados.add("Número interior");
        encabezados.add("Código postal");
        encabezados.add("Localidad");
        encabezados.add("Municipio /Demarcación territorial");
        encabezados.add("Entidad federativa");
        encabezados.add("Latitud");
        encabezados.add("Longitud");
        encabezados.add("Nombre del agente del ministerio público responsable");
        encabezados.add("Identificador del agente del ministerio público responsable");
        encabezados.add("Medio de conocimiento de los hechos");
        encabezados.add("Fecha de presentación de la denuncia o querella");
        encabezados.add("Hora de presentación de la denuncia o querella");
        encabezados.add("Autoridad que recibió la denuncia o querella");
        encabezados.add("En caso de no abrir carpeta de investigación ¿se brindó algún tipo de atención?");
        encabezados.add("Tipo de atención");
        encabezados.add("Número de la atención");
        encabezados.add("Fecha de inicio de la atención");
        encabezados.add("Fecha de conclusión de la atención");
        encabezados.add("Sentido de la conclusión de la atención");
        encabezados.add("IdentificadorFiscalia");
        encabezados.add("Periodo");

        // Abrir diálogo para guardar archivo
     
 
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"))) {
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
