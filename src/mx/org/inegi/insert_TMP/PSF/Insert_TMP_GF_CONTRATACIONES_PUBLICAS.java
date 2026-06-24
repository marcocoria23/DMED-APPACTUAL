/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TMP.PSF;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.bean.CPF.BeanTMP_GF_CONTRATACIONES_PUBLICAS;
import mx.org.inegi.conexion.PSF.OracleDAOFactoryPSF;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class Insert_TMP_GF_CONTRATACIONES_PUBLICAS {

    private static final Logger LOGGER = Logger.getLogger(Insert_TMP_GF_CONTRATACIONES_PUBLICAS.class.getName());

    /**
     * Procesa datos leídos directamente desde Excel (sin conversión a CSV)
     * @param datosExcel Lista de arrays con los datos de las filas del Excel
     * @throws Exception
     */
    public void procesarDatosExcel(List<String[]> datosExcel) throws Exception {
        PreparedStatement pstmt = null;
        CallableStatement cstmt = null;
        Connection con = null;
        int registrosInsertados = 0;
        int registrosError = 0;

        con = OracleDAOFactoryPSF.creaConexion();

        try {
            // Desactivar autocommit
            con.setAutoCommit(false);
            
            ArrayList<BeanTMP_GF_CONTRATACIONES_PUBLICAS> ad = new ArrayList<>();

            // Saltar la primera fila (headers) y leer desde la fila 3 (índice 2)
            for (int i = 2; i < datosExcel.size(); i++) {
                String[] filaActual = datosExcel.get(i);
                
                // Validar que la fila no esté vacía
                if (filaActual.length == 0 || filaActual[0].trim().isEmpty()) {
                    continue;
                }

                try {
                    BeanTMP_GF_CONTRATACIONES_PUBLICAS c = new BeanTMP_GF_CONTRATACIONES_PUBLICAS();
                    
                    // Usar método seguro para obtener valores
                    c.SetID_CONTRATO(getValor(filaActual, 0));
                    c.SetCODIGO_EXPEDIENTE(getValor(filaActual, 1));
                    c.SetNUMERO_PROCEDIMIENTO(getValor(filaActual, 2));
                    c.SetENTIDAD_FEDERATIVA(getValor(filaActual, 3));
                    c.SetINSTITUCION(getValor(filaActual, 4));
                    c.SetOTRA_INSTITUCION_ESPECIFIQUE(getValor(filaActual, 5));           
                    c.SetUNIDAD_COMPRADORA(getValor(filaActual, 6));                       
                    c.SetCARACTER_PROCEDIMIENTO(getValor(filaActual, 7));                 
                    c.SetMATERIA_PROCEDIMIENTO(getValor(filaActual, 8));                
                    c.SetTIPO_PROCEDIMIENTO(getValor(filaActual, 9));                     
                    c.SetOTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE(getValor(filaActual, 10));   
                    c.SetFORMA_PARTICIPACION_PROCEDIMIENTO(getValor(filaActual, 11));    
                    c.SetTITULO_CONTRATO(getValor(filaActual, 12));                     
                    c.SetMONTO_CONTRATO(getValor(filaActual, 13));                        
                    c.SetMONEDA_CONTRATO(getValor(filaActual, 14));                      
                    c.SetRAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO(getValor(filaActual, 15));  
                    c.SetESTATUS_CONTRATO(getValor(filaActual, 16));                    
                    c.SetFECHA_INICIO_CONTRATO(convertirFecha(getValor(filaActual, 17)));  
                    c.SetFECHA_CONCLUSION_CONTRATO(convertirFecha(getValor(filaActual, 18)));  
                    c.SetCOND_CONVENIO_MODIFICATORIO(getValor(filaActual, 19)); 
                    c.SetCOND_CONTRATO_MARCO(getValor(filaActual, 20));        
                    c.SetCOND_COMPRA_CONSOLIDADA(getValor(filaActual, 21));            
                    c.SetCOND_PRESENTACION_GARANTIA(getValor(filaActual, 22));         
                    c.SetTIPO_GARANTIA_PRESENTADA_1(getValor(filaActual, 23));   
                    c.SetTIPO_GARANTIA_PRESENTADA_2(getValor(filaActual, 24));         
                    c.SetTIPO_GARANTIA_PRESENTADA_3(getValor(filaActual, 25));           
                    c.SetCOMENTARIOS(getValor(filaActual, 26));      
                    
                    ad.add(c);
                    
                } catch (Exception ex) {
                    LOGGER.log(Level.WARNING, "Error procesando fila " + i, ex);
                }
            }

            if (ad.size() > 0) {
                LOGGER.info("Procesando " + ad.size() + " registros de CONTRATACIONES_PUBLICAS");
                
                // SQL INSERT directo en la tabla TMP
               String sqlInsert = "INSERT INTO TMP_GF_CONTRATACIONES_PUBLICAS_GEN (" +
                    "ID_CONTRATO, CODIGO_EXPEDIENTE, NUMERO_PROCEDIMIENTO, ENTIDAD_FEDERATIVA, " +
                    "INSTITUCION, OTRA_INSTITUCION_ESPECIFIQUE, UNIDAD_COMPRADORA, CARACTER_PROCEDIMIENTO, MATERIA_PROCEDIMIENTO, " +
                    "TIPO_PROCEDIMIENTO, OTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE, FORMA_PARTICIPACION_PROCEDIMIENTO, " +
                    "TITULO_CONTRATO, MONTO_CONTRATO, MONEDA_CONTRATO, RAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO, " +
                    "ESTATUS_CONTRATO, FECHA_INICIO_CONTRATO, FECHA_CONCLUSION_CONTRATO, COND_CONVENIO_MODIFICATORIO, " +
                    "COND_CONTRATO_MARCO, COND_COMPRA_CONSOLIDADA, COND_PRESENTACION_GARANTIA, " +
                    "TIPO_GARANTIA_PRESENTADA_1, TIPO_GARANTIA_PRESENTADA_2, TIPO_GARANTIA_PRESENTADA_3, COMENTARIOS" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                pstmt = con.prepareStatement(sqlInsert);
                
                // Insertar cada registro
                for (int i = 0; i < ad.size(); i++) {
                    BeanTMP_GF_CONTRATACIONES_PUBLICAS bean = ad.get(i);
                    
                   try {
                    pstmt.setString(1, bean.GetID_CONTRATO());
                    pstmt.setString(2, bean.GetCODIGO_EXPEDIENTE());
                    pstmt.setString(3, bean.GetNUMERO_PROCEDIMIENTO());
                    pstmt.setString(4, bean.GetENTIDAD_FEDERATIVA());
                    pstmt.setString(5, bean.GetINSTITUCION());
                    pstmt.setString(6, bean.GetOTRA_INSTITUCION_ESPECIFIQUE());  
                    pstmt.setString(7, bean.GetUNIDAD_COMPRADORA());
                    pstmt.setString(8, bean.GetCARACTER_PROCEDIMIENTO());
                    pstmt.setString(9, bean.GetMATERIA_PROCEDIMIENTO());
                    pstmt.setString(10, bean.GetTIPO_PROCEDIMIENTO());
                    pstmt.setString(11, bean.GetOTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE());
                    pstmt.setString(12, bean.GetFORMA_PARTICIPACION_PROCEDIMIENTO());
                    pstmt.setString(13, bean.GetTITULO_CONTRATO());
                    pstmt.setString(14, bean.GetMONTO_CONTRATO());
                    pstmt.setString(15, bean.GetMONEDA_CONTRATO());
                    pstmt.setString(16, bean.GetRAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO());
                    pstmt.setString(17, bean.GetESTATUS_CONTRATO());
                    pstmt.setString(18, bean.GetFECHA_INICIO_CONTRATO());
                    pstmt.setString(19, bean.GetFECHA_CONCLUSION_CONTRATO());
                    pstmt.setString(20, bean.GetCOND_CONVENIO_MODIFICATORIO());
                    pstmt.setString(21, bean.GetCOND_CONTRATO_MARCO());
                    pstmt.setString(22, bean.GetCOND_COMPRA_CONSOLIDADA());
                    pstmt.setString(23, bean.GetCOND_PRESENTACION_GARANTIA());
                    pstmt.setString(24, bean.GetTIPO_GARANTIA_PRESENTADA_1());
                    pstmt.setString(25, bean.GetTIPO_GARANTIA_PRESENTADA_2());
                    pstmt.setString(26, bean.GetTIPO_GARANTIA_PRESENTADA_3());
                    pstmt.setString(27, bean.GetCOMENTARIOS());

                    pstmt.addBatch();

                    // Ejecutar batch cada 10 registros
                    if ((i + 1) % 10 == 0) {
                        int[] resultados = pstmt.executeBatch();
                        con.commit();
                        LOGGER.info("Batch de 10 registros insertado. Total: " + (i + 1));
                    }

                } catch (SQLException ex) {
                    registrosError++;
                    LOGGER.log(Level.WARNING, "Error insertando registro " + (i + 1) + ": " + ex.getMessage(), ex);
                    registrarErrorEnBD(con, bean.GetID_CONTRATO(), "TMP_GF_CONTRATACIONES_PUBLICAS_GEN", 
                        "Error al insertar: " + ex.getMessage());
                }
                }
                
                // Ejecutar registros restantes
                if (pstmt != null) {
                    try {
                        int[] resultados = pstmt.executeBatch();
                        con.commit();
                    } catch (SQLException ex) {
                        LOGGER.log(Level.WARNING, "Error en batch final: " + ex.getMessage(), ex);
                        con.rollback();
                    }
                }
                registrosInsertados = ad.size() - registrosError;
                
                LOGGER.info("Inserción completada: " + registrosInsertados + " registros insertados, " + 
                            registrosError + " errores");
                
            } else {
                LOGGER.info("No hay registros para procesar en CONTRATACIONES_PUBLICAS");
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en la inserción: " + ex.getMessage(), ex);
            try {
                con.rollback();
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Error en rollback: " + e.getMessage(), e);
            }
            ex.printStackTrace();
            throw ex;
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (cstmt != null) {
                    cstmt.close();
                }
                if (con != null) {
                    con.setAutoCommit(true); // Restaurar autocommit
                    con.close();
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Error cerrando conexión", ex);
            }
        }
    }

    /**
     * Convierte fecha de formato Date (Fri Aug 02 00:00:00 CST 2024) a DD/MM/YYYY
     * @param fechaStr Cadena de fecha en cualquier formato
     * @return Fecha en formato DD/MM/YYYY
     */
   private String convertirFecha(String fechaStr) {
    if (fechaStr == null || fechaStr.trim().isEmpty()) {
        return "";
    }
    
    String valor = fechaStr.trim();
    
    // Si contiene texto que no es fecha, retornarlo tal cual
    if (valor.matches(".*[a-zA-Z].*") && !valor.matches(".*\\d{1,2}/\\d{1,2}/\\d{4}.*") && 
        !valor.matches(".*[A-Za-z]{3}.*")) {
        // Es texto descriptivo como "No formalizado", "Rescindido", etc.
        LOGGER.info("Valor de texto (no fecha) preservado: " + valor);
        return valor;
    }
    
    try {
        // Intentar parsear como formato de Date toString() con Locale ENGLISH
        // Formato: "Fri Aug 02 00:00:00 CST 2024"
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", java.util.Locale.ENGLISH);
        java.util.Date date = formatoEntrada.parse(valor);
        SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
        String resultado = formatoSalida.format(date);
        LOGGER.info("Fecha convertida: " + valor + " -> " + resultado);
        return resultado;
    } catch (Exception e1) {
        try {
            // Si falla, intentar como DD/MM/YYYY
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = formatoEntrada.parse(valor);
            SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
            String resultado = formatoSalida.format(date);
            LOGGER.info("Fecha ya en formato DD/MM/YYYY: " + resultado);
            return resultado;
        } catch (Exception e2) {
            try {
                // Intentar como MM/DD/YYYY (formato US)
                SimpleDateFormat formatoEntrada = new SimpleDateFormat("MM/dd/yyyy");
                java.util.Date date = formatoEntrada.parse(valor);
                SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");
                String resultado = formatoSalida.format(date);
                LOGGER.info("Fecha convertida de MM/DD/YYYY: " + valor + " -> " + resultado);
                return resultado;
            } catch (Exception e3) {
                // Si todas las conversiones fallan, retornar el valor original
                LOGGER.info("No se pudo convertir fecha, se preserva valor original: " + valor);
                return valor;
            }
        }
    }
}

    /**
     * Registra errores en la tabla de observaciones
     */
    private void registrarErrorEnBD(Connection con, String idTabla, String tabla, String descripcion) {
        try {
            con.setAutoCommit(false); // Desactivar autocommit temporalmente
            String sqlError = "INSERT INTO TR_PSF_OBSERVACIONES(ID_OBSERVACION, ID_TABLA, TABLA, DESCRIPCION, FECHA) " +
                            "VALUES(TR_ID_OBSERVACIONPSF.NEXTVAL, ?, ?, ?, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI:SS'))";
            PreparedStatement pstmtError = con.prepareStatement(sqlError);
            pstmtError.setString(1, idTabla);
            pstmtError.setString(2, tabla);
            pstmtError.setString(3, descripcion);
            pstmtError.executeUpdate();
            con.commit();
            pstmtError.close();
            con.setAutoCommit(true); // Reactivar autocommit
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error registrando error en BD: " + ex.getMessage(), ex);
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