/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.bean.CPF;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANTONIO.CORIA
 */
public class BeanTR_GF_CONTRATACIONES_PUBLICAS extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_CONTRATO;
    private String CODIGO_EXPEDIENTE;
    private String NUMERO_PROCEDIMIENTO;
    private String FECHA_PUBLICACION_CONVOCATORIA;
    private String ENTIDAD_FEDERATIVA;
    private String ID_INSTITUCION;
    private String NOMBRE_INSTITUCION;
    private String UNIDAD_COMPRADORA;
    private String CARACTER_PROCEDIMIENTO;
    private String MATERIA_PROCEDIMIENTO;
    private String TIPO_PROCEDIMIENTO;
    private String OTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE;
    private String FORMA_PARTICIPACION_PROCEDIMIENTO;
    private String FECHA_PUBLICACION_FALLO;
    private String FECHA_FIRMA_CONTRATO;
    private String TITULO_CONTRATO;
    private String MONTO_CONTRATO;
    private String MONEDA_CONTRATO;
    private String RAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO;
    private String ESTATUS_CONTRATO;
    private String FECHA_INICIO_CONTRATO;
    private String FECHA_CONCLUSION_CONTRATO;
    private String COND_CONVENIO_MODIFICATORIO;
    private String COND_CONTRATO_MARCO;
    private String COND_COMPRA_CONSOLIDADA;
    private String COND_PRESENTACION_GARANTIA;
    private String TIPO_GARANTIA_PRESENTADA_1;
    private String TIPO_GARANTIA_PRESENTADA_2;
    private String TIPO_GARANTIA_PRESENTADA_3;
    private String COMENTARIOS;

    public BeanTR_GF_CONTRATACIONES_PUBLICAS() {
    }

    public String GetID_CONTRATO() {
        return ID_CONTRATO;
    }

    public void SetID_CONTRATO(String ID_CONTRATO) {
        this.ID_CONTRATO = ID_CONTRATO;
    }

    public String GetCODIGO_EXPEDIENTE() {
        return CODIGO_EXPEDIENTE;
    }

    public void SetCODIGO_EXPEDIENTE(String CODIGO_EXPEDIENTE) {
        this.CODIGO_EXPEDIENTE = CODIGO_EXPEDIENTE;
    }

    public String GetNUMERO_PROCEDIMIENTO() {
        return NUMERO_PROCEDIMIENTO;
    }

    public void SetNUMERO_PROCEDIMIENTO(String NUMERO_PROCEDIMIENTO) {
        this.NUMERO_PROCEDIMIENTO = NUMERO_PROCEDIMIENTO;
    }

    public String GetFECHA_PUBLICACION_CONVOCATORIA() {
        return FECHA_PUBLICACION_CONVOCATORIA;
    }

    public void SetFECHA_PUBLICACION_CONVOCATORIA(String FECHA_PUBLICACION_CONVOCATORIA) {
        this.FECHA_PUBLICACION_CONVOCATORIA = FECHA_PUBLICACION_CONVOCATORIA;
    }

    public String GetENTIDAD_FEDERATIVA() {
        return ENTIDAD_FEDERATIVA;
    }

    public void SetENTIDAD_FEDERATIVA(String ENTIDAD_FEDERATIVA) {
        this.ENTIDAD_FEDERATIVA = ENTIDAD_FEDERATIVA;
    }

    public String GetID_INSTITUCION() {
        return ID_INSTITUCION;
    }

    public void SetID_INSTITUCION(String ID_INSTITUCION) {
        this.ID_INSTITUCION = ID_INSTITUCION;
    }

    public String GetNOMBRE_INSTITUCION() {
        return NOMBRE_INSTITUCION;
    }

    public void SetNOMBRE_INSTITUCION(String NOMBRE_INSTITUCION) {
        this.NOMBRE_INSTITUCION = NOMBRE_INSTITUCION;
    }

    public String GetUNIDAD_COMPRADORA() {
        return UNIDAD_COMPRADORA;
    }

    public void SetUNIDAD_COMPRADORA(String UNIDAD_COMPRADORA) {
        this.UNIDAD_COMPRADORA = UNIDAD_COMPRADORA;
    }

    public String GetCARACTER_PROCEDIMIENTO() {
        return CARACTER_PROCEDIMIENTO;
    }

    public void SetCARACTER_PROCEDIMIENTO(String CARACTER_PROCEDIMIENTO) {
        this.CARACTER_PROCEDIMIENTO = CARACTER_PROCEDIMIENTO;
    }

    public String GetMATERIA_PROCEDIMIENTO() {
        return MATERIA_PROCEDIMIENTO;
    }

    public void SetMATERIA_PROCEDIMIENTO(String MATERIA_PROCEDIMIENTO) {
        this.MATERIA_PROCEDIMIENTO = MATERIA_PROCEDIMIENTO;
    }

    public String GetTIPO_PROCEDIMIENTO() {
        return TIPO_PROCEDIMIENTO;
    }

    public void SetTIPO_PROCEDIMIENTO(String TIPO_PROCEDIMIENTO) {
        this.TIPO_PROCEDIMIENTO = TIPO_PROCEDIMIENTO;
    }

    public String GetOTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE() {
        return OTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE;
    }

    public void SetOTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE(String OTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE) {
        this.OTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE = OTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE;
    }

    public String GetFORMA_PARTICIPACION_PROCEDIMIENTO() {
        return FORMA_PARTICIPACION_PROCEDIMIENTO;
    }

    public void SetFORMA_PARTICIPACION_PROCEDIMIENTO(String FORMA_PARTICIPACION_PROCEDIMIENTO) {
        this.FORMA_PARTICIPACION_PROCEDIMIENTO = FORMA_PARTICIPACION_PROCEDIMIENTO;
    }

    public String GetFECHA_PUBLICACION_FALLO() {
        return FECHA_PUBLICACION_FALLO;
    }

    public void SetFECHA_PUBLICACION_FALLO(String FECHA_PUBLICACION_FALLO) {
        this.FECHA_PUBLICACION_FALLO = FECHA_PUBLICACION_FALLO;
    }

    public String GetFECHA_FIRMA_CONTRATO() {
        return FECHA_FIRMA_CONTRATO;
    }

    public void SetFECHA_FIRMA_CONTRATO(String FECHA_FIRMA_CONTRATO) {
        this.FECHA_FIRMA_CONTRATO = FECHA_FIRMA_CONTRATO;
    }

    public String GetTITULO_CONTRATO() {
        return TITULO_CONTRATO;
    }

    public void SetTITULO_CONTRATO(String TITULO_CONTRATO) {
        this.TITULO_CONTRATO = TITULO_CONTRATO;
    }

    public String GetMONTO_CONTRATO() {
        return MONTO_CONTRATO;
    }

    public void SetMONTO_CONTRATO(String MONTO_CONTRATO) {
        this.MONTO_CONTRATO = MONTO_CONTRATO;
    }

    public String GetMONEDA_CONTRATO() {
        return MONEDA_CONTRATO;
    }

    public void SetMONEDA_CONTRATO(String MONEDA_CONTRATO) {
        this.MONEDA_CONTRATO = MONEDA_CONTRATO;
    }

    public String GetRAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO() {
        return RAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO;
    }

    public void SetRAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO(String RAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO) {
        this.RAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO = RAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO;
    }

    public String GetESTATUS_CONTRATO() {
        return ESTATUS_CONTRATO;
    }

    public void SetESTATUS_CONTRATO(String ESTATUS_CONTRATO) {
        this.ESTATUS_CONTRATO = ESTATUS_CONTRATO;
    }

    public String GetFECHA_INICIO_CONTRATO() {
        return FECHA_INICIO_CONTRATO;
    }

    public void SetFECHA_INICIO_CONTRATO(String FECHA_INICIO_CONTRATO) {
        this.FECHA_INICIO_CONTRATO = FECHA_INICIO_CONTRATO;
    }

    public String GetFECHA_CONCLUSION_CONTRATO() {
        return FECHA_CONCLUSION_CONTRATO;
    }

    public void SetFECHA_CONCLUSION_CONTRATO(String FECHA_CONCLUSION_CONTRATO) {
        this.FECHA_CONCLUSION_CONTRATO = FECHA_CONCLUSION_CONTRATO;
    }

    public String GetCOND_CONVENIO_MODIFICATORIO() {
        return COND_CONVENIO_MODIFICATORIO;
    }

    public void SetCOND_CONVENIO_MODIFICATORIO(String COND_CONVENIO_MODIFICATORIO) {
        this.COND_CONVENIO_MODIFICATORIO = COND_CONVENIO_MODIFICATORIO;
    }

    public String GetCOND_CONTRATO_MARCO() {
        return COND_CONTRATO_MARCO;
    }

    public void SetCOND_CONTRATO_MARCO(String COND_CONTRATO_MARCO) {
        this.COND_CONTRATO_MARCO = COND_CONTRATO_MARCO;
    }

    public String GetCOND_COMPRA_CONSOLIDADA() {
        return COND_COMPRA_CONSOLIDADA;
    }

    public void SetCOND_COMPRA_CONSOLIDADA(String COND_COMPRA_CONSOLIDADA) {
        this.COND_COMPRA_CONSOLIDADA = COND_COMPRA_CONSOLIDADA;
    }

    public String GetCOND_PRESENTACION_GARANTIA() {
        return COND_PRESENTACION_GARANTIA;
    }

    public void SetCOND_PRESENTACION_GARANTIA(String COND_PRESENTACION_GARANTIA) {
        this.COND_PRESENTACION_GARANTIA = COND_PRESENTACION_GARANTIA;
    }

    public String GetTIPO_GARANTIA_PRESENTADA_1() {
        return TIPO_GARANTIA_PRESENTADA_1;
    }

    public void SetTIPO_GARANTIA_PRESENTADA_1(String TIPO_GARANTIA_PRESENTADA_1) {
        this.TIPO_GARANTIA_PRESENTADA_1 = TIPO_GARANTIA_PRESENTADA_1;
    }

    public String GetTIPO_GARANTIA_PRESENTADA_2() {
        return TIPO_GARANTIA_PRESENTADA_2;
    }

    public void SetTIPO_GARANTIA_PRESENTADA_2(String TIPO_GARANTIA_PRESENTADA_2) {
        this.TIPO_GARANTIA_PRESENTADA_2 = TIPO_GARANTIA_PRESENTADA_2;
    }

    public String GetTIPO_GARANTIA_PRESENTADA_3() {
        return TIPO_GARANTIA_PRESENTADA_3;
    }

    public void SetTIPO_GARANTIA_PRESENTADA_3(String TIPO_GARANTIA_PRESENTADA_3) {
        this.TIPO_GARANTIA_PRESENTADA_3 = TIPO_GARANTIA_PRESENTADA_3;
    }

    public String GetCOMENTARIOS() {
        return COMENTARIOS;
    }

    public void SetCOMENTARIOS(String COMENTARIOS) {
        this.COMENTARIOS = COMENTARIOS;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return SQLTypeName;
        //throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] getLlave() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        Object[] array = {
            GetID_CONTRATO(),
            GetCODIGO_EXPEDIENTE(),
            GetNUMERO_PROCEDIMIENTO(),
            GetFECHA_PUBLICACION_CONVOCATORIA(),
            GetENTIDAD_FEDERATIVA(),
            GetID_INSTITUCION(),
            GetNOMBRE_INSTITUCION(),
            GetUNIDAD_COMPRADORA(),
            GetCARACTER_PROCEDIMIENTO(),
            GetMATERIA_PROCEDIMIENTO(),
            GetTIPO_PROCEDIMIENTO(),
            GetOTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE(),
            GetFORMA_PARTICIPACION_PROCEDIMIENTO(),
            GetFECHA_PUBLICACION_FALLO(),
            GetFECHA_FIRMA_CONTRATO(),
            GetTITULO_CONTRATO(),
            GetMONTO_CONTRATO(),
            GetMONEDA_CONTRATO(),
            GetRAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO(),
            GetESTATUS_CONTRATO(),
            GetFECHA_INICIO_CONTRATO(),
            GetFECHA_CONCLUSION_CONTRATO(),
            GetCOND_CONVENIO_MODIFICATORIO(),
            GetCOND_CONTRATO_MARCO(),
            GetCOND_COMPRA_CONSOLIDADA(),
            GetCOND_PRESENTACION_GARANTIA(),
            GetTIPO_GARANTIA_PRESENTADA_1(),
            GetTIPO_GARANTIA_PRESENTADA_2(),
            GetTIPO_GARANTIA_PRESENTADA_3(),
            GetCOMENTARIOS()
        };
        return array;
    }

    @Override
    public void setAtributos(Object[] obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizaDesc(Connection conn) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String ots(Object obj) {
        String val = null;
        if (obj != null) {
            val = obj.toString();
        }
        return val;
    }

    private Integer oti(Object obj) {
        Integer num = null;
        if (obj != null) {
            try {
                num = (Integer) obj;
            } catch (Exception ex) {
                System.out.println("Error en casteo de numero [" + obj + "]");
            }
        }
        return num;
    }

}
