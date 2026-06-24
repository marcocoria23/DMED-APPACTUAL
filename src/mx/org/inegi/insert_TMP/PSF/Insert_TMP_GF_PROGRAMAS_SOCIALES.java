package mx.org.inegi.insert_TMP.PSF;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.bean.PSF_TR.BeanTMP_GF_PROGRAMAS_SOCIALES;
import mx.org.inegi.conexion.PSF.OracleDAOFactoryPSF;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class Insert_TMP_GF_PROGRAMAS_SOCIALES {

    private static final Logger LOGGER = Logger.getLogger(Insert_TMP_GF_PROGRAMAS_SOCIALES.class.getName());

    /**
     * Procesa datos leídos directamente desde Excel (sin conversión a CSV)
     * @param datosExcel Lista de arrays con los datos de las filas del Excel
     * @throws Exception
     */
    public void procesarDatosExcel(List<String[]> datosExcel) throws Exception {
        ARRAY array_to_pass = null;
        CallableStatement st = null;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;

        con = OracleDAOFactoryPSF.creaConexion();

        try {
            ArrayList<BeanTMP_GF_PROGRAMAS_SOCIALES> ad = new ArrayList<>();

            // Saltar la primera fila (headers)
            for (int i = 2; i < datosExcel.size(); i++) {
                String[] filaActual = datosExcel.get(i);
                
                // Validar que la fila no esté vacía
                if (filaActual.length == 0 || filaActual[0].trim().isEmpty()) {
                    continue;
                }

                try {
                    BeanTMP_GF_PROGRAMAS_SOCIALES c = new BeanTMP_GF_PROGRAMAS_SOCIALES();
                    
                    // Usar método seguro para obtener valores
                    c.SetID_PROGRAMA_SOCIAL(getValor(filaActual, 0));
                    c.SetNOMBRE_PROGRAMA_SOCIAL(getValor(filaActual, 1));
                    c.SetID_INSTITUCION_ENCARGADA_1(getValor(filaActual, 2));
                    c.SetNOMBRE_INSTITUCION_ENCARGADA_1(getValor(filaActual, 3));
                    c.SetID_INSTITUCION_ENCARGADA_2(getValor(filaActual, 4));
                    c.SetNOMBRE_INSTITUCION_ENCARGADA_2(getValor(filaActual, 5));
                    c.SetID_INSTITUCION_ENCARGADA_3(getValor(filaActual, 6));
                    c.SetNOMBRE_INSTITUCION_ENCARGADA_3(getValor(filaActual, 7));
                    c.SetID_INSTITUCION_ENCARGADA_4(getValor(filaActual, 8));
                    c.SetNOMBRE_INSTITUCION_ENCARGADA_4(getValor(filaActual, 9));
                    c.SetID_INSTITUCION_ENCARGADA_5(getValor(filaActual, 10));
                    c.SetNOMBRE_INSTITUCION_ENCARGADA_5(getValor(filaActual, 11));
                    c.SetPRESUPUESTO_EJERCIDO(getValor(filaActual, 12));
                    c.SetCOND_REGLAS_LINEAMIENTOS_OPERACION(getValor(filaActual, 13));
                    c.SetURL_REGLAS_LINEAMIENTOS_OPERACION(getValor(filaActual, 14));
                    c.SetCOND_PADRON_PERSONAS_BENEFICIARIAS(getValor(filaActual, 15));
                    c.SetDERECHO_SOCIAL_ATENDIDO_1(getValor(filaActual, 16));
                    c.SetDERECHO_SOCIAL_ATENDIDO_2(getValor(filaActual, 17));
                    c.SetDERECHO_SOCIAL_ATENDIDO_3(getValor(filaActual, 18));
                    c.SetDERECHO_SOCIAL_ATENDIDO_4(getValor(filaActual, 19));
                    c.SetDERECHO_SOCIAL_ATENDIDO_5(getValor(filaActual, 20));
                    c.SetAMBITO_ATENCION(getValor(filaActual, 21));
                    c.SetTIPO_APOYO_ENTREGADO_1(getValor(filaActual, 22));
                    c.SetTIPO_APOYO_ENTREGADO_2(getValor(filaActual, 23));
                    c.SetTIPO_APOYO_ENTREGADO_3(getValor(filaActual, 24));
                    c.SetTIPO_APOYO_ENTREGADO_4(getValor(filaActual, 25));
                    c.SetTIPO_APOYO_ENTREGADO_5(getValor(filaActual, 26));
                    c.SetOTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE(getValor(filaActual, 27));
                    c.SetPOBLACION_ATENDIDA_PERSONAS(getValor(filaActual, 28));
                    c.SetPOBLACION_ATENDIDA_INSTITUCIONES(getValor(filaActual, 29));
                    c.SetPOBLACION_ATENDIDA_PERSONAS_MORALES(getValor(filaActual, 30));
                    c.SetPOBLACION_ATENDIDA_TERRITORIAL(getValor(filaActual, 31));
                    c.SetPOBLACION__ATENDIDA_OTRO_TIPO(getValor(filaActual, 32));
                    c.SetPOBLACION_ATENDIDA_NO_IDENTIFICADA(getValor(filaActual, 33));
                    c.SetPOBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE(getValor(filaActual, 34));
                    c.SetPOBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE(getValor(filaActual, 35));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_1(getValor(filaActual, 36));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_2(getValor(filaActual, 37));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_3(getValor(filaActual, 38));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_4(getValor(filaActual, 39));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_5(getValor(filaActual, 40));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_6(getValor(filaActual, 41));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_7(getValor(filaActual, 42));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_8(getValor(filaActual, 43));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_9(getValor(filaActual, 44));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_10(getValor(filaActual, 45));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_11(getValor(filaActual, 46));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_12(getValor(filaActual, 47));
                    c.SetGRUPO_VULNERABLE_BENEFICIADO_13(getValor(filaActual, 48));
                    c.SetOTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE(getValor(filaActual, 49));
                    c.SetCOMENTARIOS(getValor(filaActual, 50));
                    
                    ad.add(c);
                    CFilas++;
                    
                } catch (Exception ex) {
                    LOGGER.log(Level.WARNING, "Error procesando fila " + i, ex);
                }
            }

            if (CFilas > 0) {
                sd = StructDescriptor.createDescriptor("OBJ_TMP_GF_PROGRAMAS_SOCIALES", con);
                structs = new STRUCT[ad.size()];
                LOGGER.info("Procesando " + ad.size() + " registros de PROGRAMAS_SOCIALES");
                
                for (int i = 0; i < ad.size(); i++) {
                    structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                }
                
                descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_GF_PROGRAMAS_SOCIALES", con);
                array_to_pass = new ARRAY(descriptor, con, structs);
                
                st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM_TMP.TMP_GF_PROGRAMAS_SOCIALES(?))}");
                st.registerOutParameter(1, OracleTypes.INTEGER);
                st.setArray(2, array_to_pass);
                st.execute();
                
                int resultado = st.getInt(1);
                LOGGER.info("Resultado de inserción: " + resultado);
            } else {
                LOGGER.info("No hay registros para procesar en PROGRAMAS_SOCIALES");
            }
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

    /**
     * Obtiene un valor seguro de un array de strings
     * @param fila Array de datos
     * @param indice Índice a acceder
     * @return Valor del array o string vacío si está fuera de rango o es null
     */
    private String getValor(String[] fila, int indice) {
        if (indice >= 0 && indice < fila.length && fila[indice] != null) {
            return fila[indice].trim();
        }
        return "";
    }
    
    
}