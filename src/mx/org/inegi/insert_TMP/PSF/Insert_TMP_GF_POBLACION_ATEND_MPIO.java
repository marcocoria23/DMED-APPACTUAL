/*/
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TMP.PSF;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.bean.PSF_TR.BeanTMP_GF_POBLACION_ATEND_MPIO;
import mx.org.inegi.conexion.PSF.OracleDAOFactoryPSF;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

/**@author LAURA.MEDINAJ*/

public class Insert_TMP_GF_POBLACION_ATEND_MPIO {

    private static final Logger LOGGER = Logger.getLogger(Insert_TMP_GF_POBLACION_ATEND_MPIO.class.getName());

    /**
     * Procesa datos leidos directamente desde Excel.
     *
     * Estructura esperada:
     * Fila 1: ID_programa_social, ID_MUNICIPIO_1, ID_MUNICIPIO_2, ..., Comentarios
     * Fila 2: descripcion, NOMBRE_MUNICIPIO_1, NOMBRE_MUNICIPIO_2, ..., descripcion comentarios
     * Fila 3 en adelante: ID_PROGRAMA_SOCIAL, TOTAL_POBLACION por municipio, ..., COMENTARIOS
     *
     * @param datosExcel Lista de arrays con los datos de las filas del Excel
     * @throws Exception
     */
public void procesarDatosExcel(List<String[]> datosExcel) throws Exception {
    ARRAY array_to_pass = null;
    CallableStatement st = null;
    Connection con = null;
    STRUCT[] structs = null;
    StructDescriptor sd = null;
    ArrayDescriptor descriptor = null;

    if (datosExcel == null || datosExcel.size() < 3) {
        LOGGER.info("La hoja POBLACION_ATEND_MPIO no tiene filas suficientes.");
        return;
    }

    final int FILA_ID_MUNICIPIO = 0;
    final int FILA_NOMBRE_MUNICIPIO = 1;
    final int FILA_INICIO_PROGRAMAS = 2;
    final int COL_ID_PROGRAMA_SOCIAL = 0;
    final int COL_INICIO_MUNICIPIOS = 1;
    final int COL_COMENTARIOS = excelColumnToIndex("CRQ"); // CRQ = 2512 base cero

    try {
        ArrayList<BeanTMP_GF_POBLACION_ATEND_MPIO> ad = new ArrayList<>();

        String[] filaMunicipios = datosExcel.get(FILA_ID_MUNICIPIO);
        String[] filaNombresMunicipios = datosExcel.get(FILA_NOMBRE_MUNICIPIO);

        for (int fila = FILA_INICIO_PROGRAMAS; fila < datosExcel.size(); fila++) {
            String[] filaActual = datosExcel.get(fila);

            String idProgramaSocial = getValor(filaActual, COL_ID_PROGRAMA_SOCIAL);

            if (idProgramaSocial.isEmpty()) {
                continue;
            }

            String comentarios = getValor(filaActual, COL_COMENTARIOS);

            for (int col = COL_INICIO_MUNICIPIOS; col < COL_COMENTARIOS; col++) {
                String idMunicipio = getValor(filaMunicipios, col);
                String nombreMunicipio = getValor(filaNombresMunicipios, col);

                if (idMunicipio.isEmpty()) {
                    continue;
                }

                String totalPoblacion = getValor(filaActual, col);

                BeanTMP_GF_POBLACION_ATEND_MPIO c = new BeanTMP_GF_POBLACION_ATEND_MPIO();

                c.SetID_PROGRAMA_SOCIAL(idProgramaSocial);
                c.SetID_MUNICIPIO(idMunicipio);
                c.SetNOMBRE_MUNICIPIO(nombreMunicipio);
                c.SetTOTAL_POBLACION(totalPoblacion);
                c.SetCOMENTARIOS(comentarios);

                ad.add(c);
            }
        }

        if (ad.isEmpty()) {
            LOGGER.info("No hay registros para procesar en POBLACION_ATEND_MPIO.");
            return;
        }

        con = OracleDAOFactoryPSF.creaConexion();

        sd = StructDescriptor.createDescriptor("OBJ_TMP_GF_POBLACION_ATEND_MPIO", con);
        structs = new STRUCT[ad.size()];

        LOGGER.info("Procesando " + ad.size() + " registros de POBLACION_ATEND_MPIO");

        for (int i = 0; i < ad.size(); i++) {
            structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
        }

        descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_GF_POBLACION_ATEND_MPIO", con);
        array_to_pass = new ARRAY(descriptor, con, structs);

        st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM_TMP.TMP_GF_POBLACION_ATEND_MPIO(?))}");
        st.registerOutParameter(1, OracleTypes.INTEGER);
        st.setArray(2, array_to_pass);
        st.execute();

        int resultado = st.getInt(1);
        LOGGER.info("Resultado de inserción POBLACION_ATEND_MPIO: " + resultado);

    } finally {
        try {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error cerrando conexión", ex);
        }
    }
}

private int excelColumnToIndex(String columnaExcel) {
    int resultado = 0;

    for (int i = 0; i < columnaExcel.length(); i++) {
        resultado = resultado * 26 + (columnaExcel.charAt(i) - 'A' + 1);
    }

    return resultado - 1;
}
    private int obtenerColumnaComentarios(String[] filaMunicipios) {
        for (int i = 0; i < filaMunicipios.length; i++) {
            if ("Comentarios".equalsIgnoreCase(getValor(filaMunicipios, i))) {
                return i;
            }
        }
        return filaMunicipios.length;
    }

    /**
     * Obtiene un valor seguro de un array de strings.
     *
     * @param fila Array de datos
     * @param indice Indice a acceder
     * @return Valor del array o string vacio si esta fuera de rango o es null
     */
    private String getValor(String[] fila, int indice) {
        if (fila != null && indice >= 0 && indice < fila.length && fila[indice] != null) {
            return fila[indice].trim();
        }
        return "";
    }

    private String getValorRequerido(String[] fila, int indice) {
        String valor = getValor(fila, indice);
        return valor.isEmpty() ? " " : valor;
    }
}
