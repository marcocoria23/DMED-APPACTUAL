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

    public ArrayList<String[]> camposObligatoriosNull() {
        String[] camposObligatorios = {
            "FORMA_PARTICIPACION_PROCEDIMIENTO",
            "TITULO_CONTRATO",
            "MONTO_CONTRATO",
            "MONEDA_CONTRATO",
            "RAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO",
            "ESTATUS_CONTRATO",
            "FECHA_INICIO_CONTRATO",
            "FECHA_CONCLUSION_CONTRATO",
            "COND_CONVENIO_MODIFICATORIO",
            "COND_CONTRATO_MARCO",
            "COND_COMPRA_CONSOLIDADA",
            "COND_PRESENTACION_GARANTIA",
            "UNIDAD_COMPRADORA",
            "CARACTER_PROCEDIMIENTO",
            "MATERIA_PROCEDIMIENTO",
            "TIPO_PROCEDIMIENTO",
            "ID_CONTRATO",
            "CODIGO_EXPEDIENTE",
            "NUMERO_PROCEDIMIENTO",
            "ENTIDAD_FEDERATIVA",
            "NOMBRE_INSTITUCION"
        };

        ArrayList<String[]> resultado = new ArrayList<>();
        for (String campo : camposObligatorios) {
            resultado.addAll(ejecutarValidacion(
                "select ID_CONTRATO, '" + campo + "' COMENTARIOS " +
                "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
                "where " + campo + " is null"
            ));
        }
        return resultado;
    }

    /**
     * Valida otro_tipo_procedimiento_especifique cuando tipo_procedimiento='4'
     */
    public ArrayList<String[]> tipo_garantia_presentada_1_ND() {
        return ejecutarValidacion(
            "select ID_CONTRATO, 'TIPO_GARANTIA_PRESENTADA_1' COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where cond_presentacion_garantia <> '1' " +
            "and tipo_garantia_presentada_1 is not null"
        );
    }
    
    public ArrayList<String[]> otro_tipo_procedimiento_especifique() {
        return ejecutarValidacion(
            "select ID_CONTRATO, 'OTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE' COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where tipo_procedimiento = '4' and otro_tipo_procedimiento_especifique is null"
        );
    }

    /**
     * Valida que NO capture otro_tipo_procedimiento_especifique cuando tipo_procedimiento <> '4'
     */
    public ArrayList<String[]> otro_tipo_procedimiento_especifiqueNDC() {
        return ejecutarValidacion(
            "select ID_CONTRATO, 'OTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE' COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where tipo_procedimiento <> '4' and otro_tipo_procedimiento_especifique is not null"
        );
    }

    /**
     * Valida que fecha_publicacion_fallo >= fecha_publicacion_convocatoria
     */
    public ArrayList<String[]> fecha_publicacion_fallo() {
        return ejecutarValidacion(
            "select ID_CONTRATO, 'FECHA_PUBLICACION_FALLO' COMENTARIOS " +
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
            "select ID_CONTRATO, 'FECHA_FIRMA_CONTRATO' COMENTARIOS " +
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
            "select ID_CONTRATO, 'FECHA_INICIO_CONTRATO' COMENTARIOS " +
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
            "select ID_CONTRATO, 'FECHA_CONCLUSION_CONTRATO' COMENTARIOS " +
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
            "select ID_CONTRATO, 'TIPO_GARANTIA_PRESENTADA_1' COMENTARIOS " +
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
            "select ID_CONTRATO, 'TIPO_GARANTIA_PRESENTADA_1' COMENTARIOS " +
            "from TR_GF_CONTRATACIONES_PUBLICAS_GEN " +
            "where cond_presentacion_garantia <> '1' " +
            "and tipo_garantia_presentada_1 is not null"
        );
    }

    // ===== MÉTODO GENÉRICO =====
 
    private ArrayList<String[]> ejecutarValidacion(String sql) {
        ArrayList<String[]> resultado = new ArrayList<>();
        
        try {
            conexion.Conectar();
            LOGGER.info("Ejecutando: " + sql);
            resul = conexion.consultar(sql);
        if (resul != null) {
            while (resul.next()) {
                resultado.add(new String[]{
                    resul.getString("ID_CONTRATO"),
                    resul.getString("COMENTARIOS")
                });
            }
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
