/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.LeeOracleTR_PSF;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.org.inegi.conexion.PSF.DaoConexionPSF;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class QueryTR_PSF {

    ResultSet resul;
    String sql = "", sql2 = "";
    ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
    DaoConexionPSF conexion = new DaoConexionPSF();

    public ArrayList<ArrayList<String>> TR_GF_PROGRAMAS_SOCIALES() throws SQLException {
        conexion.Conectar();
        String sql = "SELECT ID_PROGRAMA_SOCIAL,\n"
                + "NOMBRE_PROGRAMA_SOCIAL,\n"
                + "ID_INSTITUCION_ENCARGADA_1,\n"
                + "NOMBRE_INSTITUCION_ENCARGADA_1,\n"
                + "ID_INSTITUCION_ENCARGADA_2,\n"
                + "NOMBRE_INSTITUCION_ENCARGADA_2,\n"
                + "ID_INSTITUCION_ENCARGADA_3,\n"
                + "NOMBRE_INSTITUCION_ENCARGADA_3,\n"
                + "ID_INSTITUCION_ENCARGADA_4,\n"
                + "NOMBRE_INSTITUCION_ENCARGADA_4,\n"
                + "ID_INSTITUCION_ENCARGADA_5,\n"
                + "NOMBRE_INSTITUCION_ENCARGADA_5,\n"
                + "PRESUPUESTO_EJERCIDO,\n"
                + "CONVER_TC_GF_PS_COND_REGLAS_LINEAM_2024(COND_REGLAS_LINEAMIENTOS_OPERACION)COND_REGLAS_LINEAMIENTOS_OPERACION,\n"
                + "URL_REGLAS_LINEAMIENTOS_OPERACION,\n"
                + "CONVER_TC_GF_PS_COND_PERSONAS_BENEF_2024(COND_PADRON_PERSONAS_BENEFICIARIAS)COND_PADRON_PERSONAS_BENEFICIARIAS,\n"
                + "CONVER_TC_GF_PS_DERECHO_SOCIAL_ATEND_2024(DERECHO_SOCIAL_ATENDIDO_1)DERECHO_SOCIAL_ATENDIDO_1,\n"
                + "CONVER_TC_GF_PS_DERECHO_SOCIAL_ATEND_2024(DERECHO_SOCIAL_ATENDIDO_2)DERECHO_SOCIAL_ATENDIDO_2,\n"
                + "CONVER_TC_GF_PS_DERECHO_SOCIAL_ATEND_2024(DERECHO_SOCIAL_ATENDIDO_3)DERECHO_SOCIAL_ATENDIDO_3,\n"
                + "CONVER_TC_GF_PS_DERECHO_SOCIAL_ATEND_2024(DERECHO_SOCIAL_ATENDIDO_4)DERECHO_SOCIAL_ATENDIDO_4,\n"
                + "CONVER_TC_GF_PS_DERECHO_SOCIAL_ATEND_2024(DERECHO_SOCIAL_ATENDIDO_5)DERECHO_SOCIAL_ATENDIDO_5,\n"
                + "CONVER_TC_GF_PS_AMBITO_ATENCION_2024(AMBITO_ATENCION)AMBITO_ATENCION,\n"
                + "CONVER_TC_GF_PS_TIPO_APOYO_ENTR_2024(TIPO_APOYO_ENTREGADO_1)TIPO_APOYO_ENTREGADO_1,\n"
                + "CONVER_TC_GF_PS_TIPO_APOYO_ENTR_2024(TIPO_APOYO_ENTREGADO_2)TIPO_APOYO_ENTREGADO_2,\n"
                + "CONVER_TC_GF_PS_TIPO_APOYO_ENTR_2024(TIPO_APOYO_ENTREGADO_3)TIPO_APOYO_ENTREGADO_3,\n"
                + "CONVER_TC_GF_PS_TIPO_APOYO_ENTR_2024(TIPO_APOYO_ENTREGADO_4)TIPO_APOYO_ENTREGADO_4,\n"
                + "CONVER_TC_GF_PS_TIPO_APOYO_ENTR_2024(TIPO_APOYO_ENTREGADO_5)TIPO_APOYO_ENTREGADO_5,\n"
                + "OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE,\n"
                + "POBLACION_ATENDIDA_PERSONAS,\n"
                + "POBLACION_ATENDIDA_INSTITUCIONES,\n"
                + "POBLACION_ATENDIDA_PERSONAS_MORALES,\n"
                + "POBLACION_ATENDIDA_TERRITORIAL,\n"
                + "POBLACION_ATENDIDA_OTRO_TIPO,\n"
                + "POBLACION_ATENDIDA_NO_IDENTIFICADA,\n"
                + "POBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE,\n"
                + "POBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE,\n"
                + "CONVER_TC_GF_PS_GPO_VULNERABLE_BENEF_2024(GRUPO_VULNERABLE_BENEFICIADO_1)GRUPO_VULNERABLE_BENEFICIADO_1,\n"
                + "CONVER_TC_GF_PS_GPO_VULNERABLE_BENEF_2024(GRUPO_VULNERABLE_BENEFICIADO_2)GRUPO_VULNERABLE_BENEFICIADO_2,\n"
                + "CONVER_TC_GF_PS_GPO_VULNERABLE_BENEF_2024(GRUPO_VULNERABLE_BENEFICIADO_3)GRUPO_VULNERABLE_BENEFICIADO_3,\n"
                + "CONVER_TC_GF_PS_GPO_VULNERABLE_BENEF_2024(GRUPO_VULNERABLE_BENEFICIADO_4)GRUPO_VULNERABLE_BENEFICIADO_4,\n"
                + "CONVER_TC_GF_PS_GPO_VULNERABLE_BENEF_2024(GRUPO_VULNERABLE_BENEFICIADO_5)GRUPO_VULNERABLE_BENEFICIADO_5,\n"
                + "CONVER_TC_GF_PS_GPO_VULNERABLE_BENEF_2024(GRUPO_VULNERABLE_BENEFICIADO_6)GRUPO_VULNERABLE_BENEFICIADO_6,\n"
                + "CONVER_TC_GF_PS_GPO_VULNERABLE_BENEF_2024(GRUPO_VULNERABLE_BENEFICIADO_7)GRUPO_VULNERABLE_BENEFICIADO_7,\n"
                + "CONVER_TC_GF_PS_GPO_VULNERABLE_BENEF_2024(GRUPO_VULNERABLE_BENEFICIADO_8)GRUPO_VULNERABLE_BENEFICIADO_8,\n"
                + "OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE,\n"
                + "COMENTARIOS\n"
                + "FROM TMP_GF_PROG_SOCIALES_GEN";
        System.out.println(sql);
        ResultSet resul = conexion.consultar(sql);

        try {
            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna
                fila.add(resul.getString(7)); // Añadir la séptima columna
                fila.add(resul.getString(8)); // Añadir la octava columna
                fila.add(resul.getString(9)); // Añadir la novena columna
                fila.add(resul.getString(10)); // Añadir la décima columna
                fila.add(resul.getString(11)); // Añadir la onceava columna
                fila.add(resul.getString(12)); // Añadir la doceava columna
                fila.add(resul.getString(13)); // Añadir la treceava columna
                fila.add(resul.getString(14)); // Añadir la catorceava columna
                fila.add(resul.getString(15)); // Añadir la quinceava columna
                fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                fila.add(resul.getString(20)); // Añadir la veinteava columna
                fila.add(resul.getString(21)); // Añadir la veintiunava columna
                fila.add(resul.getString(22)); // Añadir la veintidosava columna
                fila.add(resul.getString(23)); // Añadir la veintitresava columna
                fila.add(resul.getString(24)); // Añadir la diecisieteava columna
                fila.add(resul.getString(25)); // Añadir la dieciochoava columna
                fila.add(resul.getString(26)); // Añadir la diecinueveava columna
                fila.add(resul.getString(27)); // Añadir la veinteava columna
                fila.add(resul.getString(28)); // Añadir la veintiunava columna
                fila.add(resul.getString(29)); // Añadir la veintidosava columna
                fila.add(resul.getString(30)); // Añadir la veintitresava columna
                fila.add(resul.getString(31)); // Añadir la primera columna
                fila.add(resul.getString(32)); // Añadir la segunda columna
                fila.add(resul.getString(33)); // Añadir la tercera columna
                fila.add(resul.getString(34)); // Añadir la cuarta columna
                fila.add(resul.getString(35)); // Añadir la quinta columna
                fila.add(resul.getString(36)); // Añadir la sexta columna
                fila.add(resul.getString(37)); // Añadir la séptima columna
                fila.add(resul.getString(38)); // Añadir la octava columna
                fila.add(resul.getString(39)); // Añadir la novena columna
                fila.add(resul.getString(40)); // Añadir la décima columna
                fila.add(resul.getString(41)); // Añadir la onceava columna
                fila.add(resul.getString(42)); // Añadir la doceava columna
                fila.add(resul.getString(43)); // Añadir la treceava columna
                fila.add(resul.getString(44)); // Añadir la catorceava columna
                fila.add(resul.getString(45)); // Añadir la quinceava columna
                fila.add(resul.getString(46)); // Añadir la dieciseisava columna
                arrayList.add(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryTR_PSF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public ArrayList<ArrayList<String>> TR_GF_POBLACION_ATEND_MPIO() throws SQLException {
        conexion.Conectar();
        String sql = "SELECT ID_PROGRAMA_SOCIAL,\n"
                + "ID_MUNICIPIO,\n"
                + "NOMBRE_MUNICIPIO,\n"
                + "TOTAL_POBLACION,\n"
                + "COMENTARIOS \n"
                + "FROM TMP_GF_POBLACION_ATEND_MPIO_GEN";
        System.out.println(sql);
        ResultSet resul = conexion.consultar(sql);

        try {
            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                arrayList.add(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryTR_PSF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public ArrayList<ArrayList<String>> TR_GF_CONTRATACIONES_PUBLICAS() throws SQLException {
        conexion.Conectar();
        String sql = "SELECT \n"
                + "ID_CONTRATO,\n"
                + "CODIGO_EXPEDIENTE,\n"
                + "NUMERO_PROCEDIMIENTO,\n"
                + "to_char(FECHA_PUBLICACION_CONVOCATORIA,'DD/MM/YYYY')FECHA_PUBLICACION_CONVOCATORIA,\n"
                + "CONVER_TC_GF_CP_ENTIDAD_FEDERATIVA_2024(ENTIDAD_FEDERATIVA)ENTIDAD_FEDERATIVA,\n"
                + "CONVER_TC_GF_CP_INSTITUCIONES_2024(ID_INSTITUCION)ID_INSTITUCION,\n"
                + "NOMBRE_INSTITUCION,\n"
                + "UNIDAD_COMPRADORA,\n"
                + "CONVER_TC_GF_CP_CARACTER_PROCED_2024(CARACTER_PROCEDIMIENTO)CARACTER_PROCEDIMIENTO,\n"
                + "CONVER_TC_GF_CP_TIPO_MATERIA_2024(MATERIA_PROCEDIMIENTO)MATERIA_PROCEDIMIENTO,\n"
                + "CONVER_TC_GF_CP_PROCEDIMIENTO_CONTRATACION_2024(TIPO_PROCEDIMIENTO)TIPO_PROCEDIMIENTO,\n"
                + "OTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE,\n"
                + "CONVER_TC_GF_CP_FORMA_PARTICIPACION_2024(FORMA_PARTICIPACION_PROCEDIMIENTO)FORMA_PARTICIPACION_PROCEDIMIENTO,\n"
                + "to_char(FECHA_PUBLICACION_FALLO,'DD/MM/YYYY')FECHA_PUBLICACION_FALLO,\n"
                + "to_char(FECHA_FIRMA_CONTRATO,'DD/MM/YYYY')FECHA_FIRMA_CONTRATO,\n"
                + "TITULO_CONTRATO,\n"
                + "MONTO_CONTRATO,\n"
                + "CONVER_TC_GF_CP_MONEDA_CONTRATO_2024(MONEDA_CONTRATO)MONEDA_CONTRATO,\n"
                + "RAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO,\n"
                + "CONVER_TC_GF_CP_ESTATUS_CONTRATO_2024(ESTATUS_CONTRATO)ESTATUS_CONTRATO,\n"
                + "to_char(FECHA_INICIO_CONTRATO,'DD/MM/YYYY')FECHA_INICIO_CONTRATO,\n"
                + "to_char(FECHA_CONCLUSION_CONTRATO,'DD/MM/YYYY')FECHA_CONCLUSION_CONTRATO,\n"
                + "CONVER_TC_GF_CP_GENERAL_CONDICION_EXISTENCIA_2024(COND_CONVENIO_MODIFICATORIO)COND_CONVENIO_MODIFICATORIO,\n"
                + "CONVER_TC_GF_CP_GENERAL_CONDICION_EXISTENCIA_2024(COND_CONTRATO_MARCO)COND_CONTRATO_MARCO,\n"
                + "CONVER_TC_GF_CP_GENERAL_CONDICION_EXISTENCIA_2024(COND_COMPRA_CONSOLIDADA)COND_COMPRA_CONSOLIDADA,\n"
                + "CONVER_TC_GF_CP_GENERAL_CONDICION_EXISTENCIA_2024(COND_PRESENTACION_GARANTIA)COND_PRESENTACION_GARANTIA,\n"
                + "CONVER_TC_GF_CP_TIPO_GARANTIA_2024(TIPO_GARANTIA_PRESENTADA_1)TIPO_GARANTIA_PRESENTADA_1,\n"
                + "CONVER_TC_GF_CP_TIPO_GARANTIA_2024(TIPO_GARANTIA_PRESENTADA_2)TIPO_GARANTIA_PRESENTADA_2,\n"
                + "CONVER_TC_GF_CP_TIPO_GARANTIA_2024(TIPO_GARANTIA_PRESENTADA_3)TIPO_GARANTIA_PRESENTADA_3,\n"
                + "COMENTARIOS\n"
                + "FROM TMP_GF_CONTRATACIONES_PUBLICAS_GEN";
        System.out.println(sql);
        ResultSet resul = conexion.consultar(sql);

        try {
            while (resul.next()) {
                ArrayList<String> fila = new ArrayList<>();
                fila.add(resul.getString(1)); // Añadir la primera columna
                fila.add(resul.getString(2)); // Añadir la segunda columna
                fila.add(resul.getString(3)); // Añadir la tercera columna
                fila.add(resul.getString(4)); // Añadir la cuarta columna
                fila.add(resul.getString(5)); // Añadir la quinta columna
                fila.add(resul.getString(6)); // Añadir la sexta columna
                fila.add(resul.getString(7)); // Añadir la séptima columna
                fila.add(resul.getString(8)); // Añadir la octava columna
                fila.add(resul.getString(9)); // Añadir la novena columna
                fila.add(resul.getString(10)); // Añadir la décima columna
                fila.add(resul.getString(11)); // Añadir la onceava columna
                fila.add(resul.getString(12)); // Añadir la doceava columna
                fila.add(resul.getString(13)); // Añadir la treceava columna
                fila.add(resul.getString(14)); // Añadir la catorceava columna
                fila.add(resul.getString(15)); // Añadir la quinceava columna
                fila.add(resul.getString(16)); // Añadir la dieciseisava columna
                fila.add(resul.getString(17)); // Añadir la diecisieteava columna
                fila.add(resul.getString(18)); // Añadir la dieciochoava columna
                fila.add(resul.getString(19)); // Añadir la diecinueveava columna
                fila.add(resul.getString(20)); // Añadir la veinteava columna
                fila.add(resul.getString(21)); // Añadir la veintiunava columna
                fila.add(resul.getString(22)); // Añadir la veintidosava columna
                fila.add(resul.getString(23)); // Añadir la veintitresava columna
                fila.add(resul.getString(24)); // Añadir la diecisieteava columna
                fila.add(resul.getString(25)); // Añadir la dieciochoava columna
                fila.add(resul.getString(26)); // Añadir la diecinueveava columna
                fila.add(resul.getString(27)); // Añadir la veinteava columna
                fila.add(resul.getString(28)); // Añadir la veintiunava columna
                fila.add(resul.getString(29)); // Añadir la veintidosava columna
                fila.add(resul.getString(30)); // Añadir la veintitresava columna
                arrayList.add(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueryTR_PSF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resul != null) {
                    resul.close();
                }
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
