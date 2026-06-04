/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidacionesPSF;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.PSF.DaoConexionPSF;

/**
 * Validaciones de Contrataciones Públicas
 * @author LAURA.MEDINAJ
 */
public class QContrataciones_Publicas {

    private static final Logger LOGGER = Logger.getLogger(QContrataciones_Publicas.class.getName());
    private DaoConexionPSF conexion;
    private ResultSet resul;

    public QContrataciones_Publicas() {
        this.conexion = new DaoConexionPSF();
    }

    // ===== VALIDACIONES =====

    /**
     * Valida otro_tipo_procedimiento_especifique cuando tipo_procedimiento='4'
     */
    public ArrayList<String[]> tipo_garantia_presentada_1_ND() {
        return ejecutarValidacion(
            "select ID_CONTRATO, REPLACE(COMENTARIOS,',','') COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where cond_presentacion_garantia <> '1' " +
            "and tipo_garantia_presentada_1 is not null"
        );
    }
    
    public ArrayList<String[]> otro_tipo_procedimiento_especifique() {
        return ejecutarValidacion(
            "select ID_CONTRATO, REPLACE(COMENTARIOS,',','') COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where tipo_procedimiento = '4' and otro_tipo_procedimiento_especifique is null"
        );
    }

    /**
     * Valida que NO capture otro_tipo_procedimiento_especifique cuando tipo_procedimiento <> '4'
     */
    public ArrayList<String[]> otro_tipo_procedimiento_especifiqueNDC() {
        return ejecutarValidacion(
            "select ID_CONTRATO, REPLACE(COMENTARIOS,',','') COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where tipo_procedimiento <> '4' and otro_tipo_procedimiento_especifique is not null"
        );
    }

    /**
     * Valida que fecha_publicacion_fallo >= fecha_publicacion_convocatoria
     */
    public ArrayList<String[]> fecha_publicacion_fallo() {
        return ejecutarValidacion(
            "select ID_CONTRATO, REPLACE(COMENTARIOS,',','') COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where FECHA_PUBLICACION_FALLO < FECHA_PUBLICACION_CONVOCATORIA " +
            "and comentarios is null " +
            "and FECHA_PUBLICACION_FALLO not like '09/09/99'"
        );
    }

    /**
     * Valida que fecha_firma_contrato >= fecha_publicacion_fallo
     */
    public ArrayList<String[]> fecha_firma_contrato() {
        return ejecutarValidacion(
            "select ID_CONTRATO, REPLACE(COMENTARIOS,',','') COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where fecha_firma_contrato < FECHA_PUBLICACION_FALLO " +
            "and comentarios is null " +
            "and FECHA_PUBLICACION_FALLO not like '09/09/99' " +
            "and fecha_firma_contrato not like '09/09/99'"
        );
    }

    /**
     * Valida que fecha_inicio_contrato >= fecha_firma_contrato
     */
    public ArrayList<String[]> fecha_inicio_contrato() {
        return ejecutarValidacion(
            "select ID_CONTRATO, REPLACE(COMENTARIOS,',','') COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where fecha_inicio_contrato < fecha_firma_contrato " +
            "and comentarios is null " +
            "and fecha_firma_contrato not like '09/09/99' " +
            "and fecha_inicio_contrato not like '09/09/99'"
        );
    }

    /**
     * Valida que fecha_conclusion_contrato >= fecha_inicio_contrato
     */
    public ArrayList<String[]> fecha_conclusion_contrato() {
        return ejecutarValidacion(
            "select ID_CONTRATO, REPLACE(COMENTARIOS,',','') COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where fecha_conclusion_contrato < fecha_inicio_contrato " +
            "and comentarios is null " +
            "and fecha_inicio_contrato not like '09/09/99' " +
            "and fecha_conclusion_contrato not like '09/09/99'"
        );
    }

    /**
     * Valida que tipo_garantia_presentada_1 tenga valor cuando cond_presentacion_garantia='1'
     */
    public ArrayList<String[]> tipo_garantia_presentada_1() {
        return ejecutarValidacion(
            "select ID_CONTRATO, REPLACE(COMENTARIOS,',','') COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where cond_presentacion_garantia = '1' " +
            "and tipo_garantia_presentada_1 is null"
        );
    }

    /**
     * Valida que NO SE REPITA TIPO DE GARANTÍA'
     */
    public ArrayList<String[]> tipo_garantia_presentada_REPETIDA() {
        return ejecutarValidacion(
            "select ID_CONTRATO, REPLACE(COMENTARIOS,',','') COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where cond_presentacion_garantia <> '1' " +
            "and tipo_garantia_presentada_1 is not null"
        );
    }

    // ===== MÉTODO GENÉRICO =====

    /**
     * Ejecuta una consulta y retorna los resultados como ArrayList
     * @param sql Consulta SQL a ejecutar
     * @return ArrayList con ID_CONTRATO y COMENTARIOS
     */
    private ArrayList<String[]> ejecutarValidacion(String sql) {
        ArrayList<String[]> resultado = new ArrayList<>();
        
        try {
            conexion.Conectar();
            LOGGER.info("Ejecutando: " + sql);           
            resul = conexion.consultar(sql);          
            while (resul.next()) {
                resultado.add(new String[]{ resul.getString("ID_CONTRATO"), resul.getString("COMENTARIOS") });
            }           
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en validación: " + sql, ex);
        } finally {
            try {
                conexion.close();
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Error cerrando conexión", ex);
            }
        }
        
        return resultado;
    }
}