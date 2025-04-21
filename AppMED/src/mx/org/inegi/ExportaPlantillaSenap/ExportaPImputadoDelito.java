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
public class ExportaPImputadoDelito {

    private ConOracle conexion = new ConOracle();
    private ResultSet resul;

    public void exportaPImputadoDelito(String Entidad, String Periodo) throws SQLException {
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

        // Abrir diálogo para guardar archivo
        FileDialog fileDialog = new FileDialog((Frame) null, "Selecciona dónde guardar el archivo CSV", FileDialog.SAVE);
        fileDialog.setFile("PImputadoDelito.csv"); // Nombre del archivo
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
                JOptionPane.showMessageDialog(null, "El archivo con nombre PImputadoDelito se ha exportado satisfactoriamente!");

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
