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
public class ExportaPVictimasDelitos {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportaPVictimasDelito(String Entidad, String Periodo, String csvFile) throws SQLException {
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

        Vector<String> encabezados = new Vector<>();
        encabezados.add("IDENTIFICADOR ENTIDAD");
        encabezados.add("VictimaDelitoID");
        encabezados.add("DelitoID ");
        encabezados.add("VictimaID");
        encabezados.add("CarpetaID");
        encabezados.add("Nombre de la víctima ");
        encabezados.add("Tipo de víctima");
        encabezados.add("CURP ");
        encabezados.add("Fecha de nacimiento");
        encabezados.add("Edad al momento que sucedieron los hechos");
        encabezados.add("Sexo ");
        encabezados.add("Situación conyugal ");
        encabezados.add("Vestimenta y rasgos visibles (en caso de que la víctima no esté identificada)  ");
        encabezados.add("Nacionalidad ");
        encabezados.add("Situación migratoria ");
        encabezados.add("País de nacimiento ");
        encabezados.add("Entidad de nacimiento");
        encabezados.add("Municipio/ Demarcación territorial de nacimiento ");
        encabezados.add("País de residencia habitual");
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
        encabezados.add("Teléfono ");
        encabezados.add("¿Habla español?");
        encabezados.add("¿Habla lengua extranjera?");
        encabezados.add("Tipo de lengua extranjera");
        encabezados.add("¿Habla lengua indígena?");
        encabezados.add("Tipo de lengua indígena");
        encabezados.add("Durante el desarrollo del proceso penal ¿utilizó traductor y/o interprete?");
        encabezados.add("¿Presenta algún tipo de discapacidad?");
        encabezados.add("Condición de discapacidad");
        encabezados.add("¿Utilizó intérprete y/o medio tecnológico por discapacidad?");
        encabezados.add("¿Pertenece a alguna población indígena?");
        encabezados.add("Población indígena a la que pertenece");
        encabezados.add("¿Pertenece a alguna población LGBTTTI? ");
        encabezados.add("Población LGBTTTI a la que pertenece ");
        encabezados.add("¿Pertenece a población en situación de calle?");
        encabezados.add("¿Sabe leer y escribir? ");
        encabezados.add("Escolaridad");
        encabezados.add("Ocupación");
        encabezados.add("Rango de ingreso mensual neto");
        encabezados.add("En hechos anteriores ¿la víctima manifestó haber sufrido de cualquier tipo de violencia?");
        encabezados.add("¿Contó con asesor jurídico?");
        encabezados.add("Tipo de asesor jurídico");
        encabezados.add("¿Recibió atención médica en caso de tratarse de violencia? ");
        encabezados.add("¿Recibió atención psicológica en caso de tratarse de violencia?");
        encabezados.add("Medidas de protección otorgadas a la víctima ");
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
