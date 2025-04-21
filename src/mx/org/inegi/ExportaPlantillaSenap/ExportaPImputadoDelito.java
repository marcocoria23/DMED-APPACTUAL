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
public class ExportaPImputadoDelito {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportaPImputadoDelito(String Entidad, String Periodo, String csvFile) throws SQLException {
        conexion.Conectar(); // Conexión a la base de datos
        String sql = "SELECT \n"
                + "IMP.ENTIDADID,\n"
                + "CASE WHEN IMPDEL.IMPUTADODELITOID IS NULL THEN -1 ELSE IMPDEL.IMPUTADODELITOID END IMPUTADODELITOID,\n"
                + "CASE WHEN IMPDEL.DELITOID IS NULL THEN -1 ELSE IMPDEL.DELITOID END DELITOID,\n"
                + "CASE WHEN IMP.IMPUTADOID IS NULL THEN -1 ELSE IMP.IMPUTADOID END IMPUTADOID,\n"
                + "CASE WHEN IMP.CARPETAID IS NULL THEN -1 ELSE IMP.CARPETAID END CARPETAID,\n"
                + "IMP.NOMBREIMPUTADO,\n"
                + "IMP.ALIASAPODO,\n"
                + "CONVERI_TIPOPERSONAIMPUTADA(IMP.CATTIPOPERSONAIMPUTADAID)CATTIPOPERSONAIMPUTADAID,\n"
                + "CONVERI_TIPOPERSONAMORAL(CATTIPOPERSONAMORALID)CATTIPOPERSONAMORALID,\n"
                + "IMP.CURP,\n"
                + "TO_CHAR(IMP.FECHANACIMIENTO,'DD/MM/YYYY')FECHANACIMIENTO,\n"
                + "IMP.EDADMOMENTOSUCEDIERONHECHOS,\n"
                + "CONVERI_SEXO(IMP.CATSEXOID)CATSEXOID,\n"
                + "CONVERI_SITUACIONCONYUGAL(IMP.CATSITUACIONCONYUGALID)CATSITUACIONCONYUGALID,\n"
                + "IMP.MEDIAFILIACION,\n"
                + "CONVERI_NACIONALIDAD(IMP.CATNACIONALIDADID)CATNACIONALIDADID,\n"
                + "CONVERI_SITUACIONMIGRATORIA(IMP.CATSITUACIONMIGRATORIAID)CATSITUACIONMIGRATORIAID,\n"
                + "CONVERI_PAIS(IMP.CATPAISNACIMIENTOID)CATPAISNACIMIENTOID,\n"
                + "CONVERI_ENTIDADFEDERATIVA(IMP.CATENTIDADNACIMIENTOID)CATENTIDADNACIMIENTOID,\n"
                + "CONVERI_MUNICIPIODEMARCACIONTERRITOR(CATMUNICIPIOID)CATMUNICIPIOID,\n"
                + " CONVERI_PAIS(CATPAISRESIDENCIAHABITUALID)CATPAISRESIDENCIAHABITUALID,\n"
                + " CONVERI_TIPOVIALIDAD(DU.CATTIPOVIALIDADID)CATTIPOVIALIDADID,\n"
                + "DU.CALLEVIALIDAD,\n"
                + "CONVERI_COLONIA(DU.CATCOLONIAID)CATCOLONIAID,\n"
                + "DU.COLONIA,\n"
                + "DU.NUMEROEXTERIOR,\n"
                + "DU.NUMEROINTERIOR,\n"
                + "DU.CODIGOPOSTAL,\n"
                + "DU.LOCALIDAD,\n"
                + "CONVERI_MUNICIPIODEMARCACIONTERRITOR(DU.CATDEMARCACIONID)CATDEMARCACIONID,\n"
                + "CONVERI_ENTIDADFEDERATIVA(DU.CATENTFEDID)CATENTFEDID,\n"
                + "DU.LATITUD,\n"
                + "DU.LONGITUD,\n"
                + "NUMEROTELEFONICO,\n"
                + "CONVERI_RESPUESTASGENERICAS(HABLAESPANIOL)HABLAESPANIOL,\n"
                + "CONVERI_RESPUESTASGENERICAS(HABLALENGUAEXTRANJERA)HABLALENGUAEXTRANJERA,\n"
                + "CONVERI_TIPOLENGUAEXTRANJERA(CATTIPOLENGUAEXTRANJERAID)CATTIPOLENGUAEXTRANJERAID,\n"
                + "CONVERI_RESPUESTASGENERICAS(HABLALENGUAINDIGENA)HABLALENGUAINDIGENA,\n"
                + "CONVERI_TIPOLENGUAINDIGENA(CATTIPOLENGUAINDIGENAID)CATTIPOLENGUAINDIGENAID,\n"
                + "CONVERI_RESPUESTASGENERICAS(UTILIZOTRADUCTORINTERPRETE)UTILIZOTRADUCTORINTERPRETE,\n"
                + "CONVERI_RESPUESTASGENERICAS(PRESENTADISCAPACIDAD)PRESENTADISCAPACIDAD,\n"
                + "CONVERI_TIPODISCAPACIDAD(CATTIPODISCAPACIDADID)CATTIPODISCAPACIDADID,\n"
                + "CONVERI_RESPUESTASGENERICAS(MEDIOTECDISCAPACIDAD)MEDIOTECDISCAPACIDAD,\n"
                + "CONVERI_RESPUESTASGENERICAS(PERTENECEPOBLACIONINDIGENA)PERTENECEPOBLACIONINDIGENA,\n"
                + "CONVERI_POBLACIONINDIGENAPERTENECE(CATTIPOPOBLACIONINDIGENAID)CATTIPOPOBLACIONINDIGENAID,\n"
                + "CONVERI_RESPUESTASGENERICAS(PERTENECEPOBLACIONLGBTTTI)PERTENECEPOBLACIONLGBTTTI,\n"
                + "CONVERI_POBLACIONLGBTTTIPERTENECE(CATTIPOLGBTTTIID)CATTIPOLGBTTTIID,    \n"
                + "CONVERI_RESPUESTASGENERICAS(PERTENECEPOBLACIONSITUACIONCALLE)PERTENECEPOBLACIONSITUACIONCALLE,   \n"
                + "CONVERI_RESPUESTASGENERICAS(SABELEERESCRIBIR)SABELEERESCRIBIR,\n"
                + "CONVERI_NIVELESCOLARIDAD(CATNIVELESCOLARIDADID)CATNIVELESCOLARIDADID,\n"
                + "CONVERI_OCUPACION(CATOCUPACIONID)CATOCUPACIONID,\n"
                + "RANGOINGRESOMENSUALNETO,\n"
                + "CONVERI_RESPUESTASGENERICAS(IMPUTADOPERTENECEGRUPODELICTIVO)IMPUTADOPERTENECEGRUPODELICTIVO,\n"
                + "GRUPODELICTIVO,\n"
                + "CONVERI_GRADOAUTORIAPARTICIPACIONCOM(CATCOMISIONDELITOID)CATCOMISIONDELITOID,\n"
                + "CONVERI_RESPUESTASGENERICAS(ANTECEDENTESPENALES)ANTECEDENTESPENALES,\n"
                + "CONVERI_ESTADOPSICOFISICO(CATESTADOPSICOFISICOID)CATESTADOPSICOFISICOID,\n"
                + "CONVERI_RESPUESTASGENERICAS(CONTODEFENSOR)CONTODEFENSOR,\n"
                + "CONVERI_TIPODEFENSOR(CATTIPODEFENSORID)CATTIPODEFENSORID,\n"
                + "CONVERI_FORMAPROCESO(CATFORMAPROCESOID)CATFORMAPROCESOID,\n"
                + "TO_CHAR(FECHADETENCION,'DD/MM/YYYY')FECHADETENCION,\n"
                + "HORADETENCION,\n"
                + "CONVERI_TIPODETENCION(CATTIPODETENCIONID)CATTIPODETENCIONID,\n"
                + "CONVERI_TIPOVIALIDAD(DU1.CATTIPOVIALIDADID)CATTIPOVIALIDADID,\n"
                + "DU1.CALLEVIALIDAD,\n"
                + "CONVERI_COLONIA(DU1.CATCOLONIAID)CATCOLONIAID,\n"
                + "DU1.COLONIA,\n"
                + "DU1.NUMEROEXTERIOR,\n"
                + "DU1.NUMEROINTERIOR,\n"
                + "DU1.CODIGOPOSTAL,\n"
                + "DU1.LOCALIDAD,\n"
                + "CONVERI_MUNICIPIODEMARCACIONTERRITOR(DU1.CATDEMARCACIONID)CATDEMARCACIONID,\n"
                + "CONVERI_ENTIDADFEDERATIVA(DU1.CATENTFEDID)CATENTFEDID,\n"
                + "DU1.LATITUD,\n"
                + "DU1.LONGITUD,\n"
                + "CONVERI_AUTORIDADCARGODETENCION(CATAUTORIDADCARGODETENCIONID)CATAUTORIDADCARGODETENCIONID,\n"
                + "CONVERI_RESPUESTASGENERICAS(IMPUTADOFUELIBERADO)IMPUTADOFUELIBERADO,\n"
                + "TO_CHAR(FECHAAUDIENCIACONTROLDETENCION,'DD/MM/YYYY')FECHAAUDIENCIACONTROLDETENCION,\n"
                + "CONVERI_RESPUESTASGENERICAS(CALIFICOLEGALDETENCION)CALIFICOLEGALDETENCION,\n"
                + "CASE WHEN IMPDEL.DELITOID_FISCALIA IS NULL THEN -1 ELSE IMPDEL.DELITOID_FISCALIA END DELITOID_FISCALIA,\n"
                + "IMP.PERIODO\n"
                + "FROM TR_SENAP_IMPUTADO IMP LEFT JOIN TR_SENAP_IMPUTADODELITO IMPDEL\n"
                + "ON IMP.ENTIDADID=IMPDEL.ENTIDADID AND IMP.PERIODO=IMPDEL.PERIODO AND IMP.IMPUTADOID=IMPDEL.IMPUTADOID\n"
                + "LEFT JOIN TR_SENAP_DIRECCIONUBICACION DU\n"
                + "ON IMP.ENTIDADID=DU.ENTIDADID AND IMP.PERIODO=DU.PERIODO AND IMP.UBICACIONID=DU.UBICACIONID\n"
                + "LEFT JOIN TR_SENAP_DIRECCIONUBICACION DU1\n"
                + "ON IMP.ENTIDADID=DU1.ENTIDADID AND IMP.PERIODO=DU1.PERIODO AND IMP.DIRECCIONUBICACIONID=DU1.UBICACIONID"
                + " WHERE (IMP.ENTIDADID='" + Entidad + "' and IMP.PERIODO='" + Periodo + "')";
        resul = conexion.consultar(sql);

        Vector<String> encabezados = new Vector<>();
        encabezados.add("IDENTIFICADOR ENTIDAD");
        encabezados.add("ImputadoDelitoID ");
        encabezados.add("DELITOID ");
        encabezados.add("ImputadoID ");
        encabezados.add("CarpetaID");
        encabezados.add("Nombre de la persona imputada");
        encabezados.add("Alias o apodo");
        encabezados.add("Tipo de persona imputada ");
        encabezados.add("Tipo de persona moral");
        encabezados.add("CURP ");
        encabezados.add("Fecha de nacimiento");
        encabezados.add("Edad al momento que sucedieron los hechos");
        encabezados.add("Sexo ");
        encabezados.add("Situación conyugal ");
        encabezados.add("Media filiación  ");
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
        encabezados.add("¿La persona imputada manifestó pertenecer a un probable grupo delictivo? ");
        encabezados.add("Nombre del grupo al que pertenece");
        encabezados.add("Grado de autoría y participación en la comisión del(os) delitos(s) ");
        encabezados.add("Antecedentes penales ");
        encabezados.add("Estado psicofísico al momento de cometer la conducta ");
        encabezados.add("¿Contó con persona defensora?");
        encabezados.add("Tipo de persona defensora");
        encabezados.add("Forma en la que lleva el imputado su proceso ");
        encabezados.add("Fecha de detención ");
        encabezados.add("Hora de detención");
        encabezados.add("Tipo de detención");
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
        encabezados.add("Autoridad a cargo de la detención");
        encabezados.add("En caso de verificación de flagrancia por parte del ministerio público ¿el imputado fue liberado? ");
        encabezados.add("Fecha de audiencia de control de la detención");
        encabezados.add("¿Se calificó de legal la detención?");
        encabezados.add("Delitos por los que se encuentra imputada (selección de los ya registrados) DELITOID_FISCALIA");
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