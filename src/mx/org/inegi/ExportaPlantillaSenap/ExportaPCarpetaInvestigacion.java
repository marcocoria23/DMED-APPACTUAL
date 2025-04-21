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
public class ExportaPCarpetaInvestigacion {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;
    
    public void ExportaPCarpetaInvestigacion(String Entidad, String Periodo,String csvFile) throws SQLException {
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

    Vector<String> encabezados = new Vector<>();
            encabezados.add("Identificador Entidad");
            encabezados.add("CarpetaID");
            encabezados.add("NoticiaCriminalID");
            encabezados.add("Nombre de la fiscalía regional o especializada");
            encabezados.add("Tipo de fiscalía regional o especializada");
            encabezados.add("Nombre y número de agencia del ministerio público");
            encabezados.add("Tipo de agencia");
            encabezados.add("Ubicación de la agencia del ministerio público");
            encabezados.add("Nombre de la vialidad (Calle)");
            encabezados.add("Tipo de asentamiento");
            encabezados.add("Nombre del asentamiento (Colonia)");
            encabezados.add("Número exterior");
            encabezados.add("Número interior");
            encabezados.add("Código postal");
            encabezados.add("Localidad");
            encabezados.add("Municipio/ Demarcación territorial");
            encabezados.add("Entidad federativa");
            encabezados.add("Latitud");
            encabezados.add("Longitud");
            encabezados.add("Nombre del agente del ministerio público responsable");
            encabezados.add("Identificador del agente del ministerio público responsable");
            encabezados.add("Medio de conocimiento de los hechos");
            encabezados.add("Número de la carpeta de investigación");
            encabezados.add("Año de carpeta de Investigación");
            encabezados.add("Fecha de apertura de la carpeta de investigación");
            encabezados.add("Hora en la que el ministerio público abrió carpeta de investigación");
            encabezados.add("Forma de inicio de la carpeta de investigación");
            encabezados.add("¿Se realizaron actos de investigación?");
            encabezados.add("Cantidad de delitos");
            encabezados.add("Cantidad de víctimas");
            encabezados.add("Cantidad de personas imputadas");
            encabezados.add("Tipo de hecho por el que se abrió la carpeta de investigación");
            encabezados.add("¿Se realizaron aseguramientos?");
            encabezados.add("Etapa procesal en que se encuentra la carpeta de investigación");
            encabezados.add("Breve descripción o narración de los hechos");
            encabezados.add("IdentificadorFiscalia");
            encabezados.add("Periodo");
            
    
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
