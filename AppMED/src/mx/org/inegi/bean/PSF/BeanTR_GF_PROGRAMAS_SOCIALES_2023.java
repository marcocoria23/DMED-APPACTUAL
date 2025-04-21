/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.bean.PSF;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANTONIO.CORIA
 */
public class BeanTR_GF_PROGRAMAS_SOCIALES_2023 extends Bean implements SQLData{

    private String SQLTypeName;
    private String ID_PROGRAMA_SOCIAL;
    private String NOMBRE_PROGRAMA_SOCIAL;
    private String ID_INSTITUCION_ENCARGADA_1;
    private String NOMBRE_INSTITUCION_ENCARGADA_1;
    private String ID_INSTITUCION_ENCARGADA_2;
    private String NOMBRE_INSTITUCION_ENCARGADA_2;
    private String ID_INSTITUCION_ENCARGADA_3;
    private String NOMBRE_INSTITUCION_ENCARGADA_3;
    private String ID_INSTITUCION_ENCARGADA_4;
    private String NOMBRE_INSTITUCION_ENCARGADA_4;
    private String ID_INSTITUCION_ENCARGADA_5;
    private String NOMBRE_INSTITUCION_ENCARGADA_5;
    private String PRESUPUESTO_EJERCIDO;
    private String COND_REGLAS_LINEAMIENTOS_OPERACION;
    private String URL_REGLAS_LINEAMIENTOS_OPERACION;
    private String COND_PADRON_PERSONAS_BENEFICIARIAS;
    private String DERECHO_SOCIAL_ATENDIDO_1;
    private String DERECHO_SOCIAL_ATENDIDO_2;
    private String DERECHO_SOCIAL_ATENDIDO_3;
    private String DERECHO_SOCIAL_ATENDIDO_4;
    private String DERECHO_SOCIAL_ATENDIDO_5;
    private String AMBITO_ATENCION;
    private String TIPO_APOYO_ENTREGADO_1;
    private String TIPO_APOYO_ENTREGADO_2;
    private String TIPO_APOYO_ENTREGADO_3;
    private String TIPO_APOYO_ENTREGADO_4;
    private String TIPO_APOYO_ENTREGADO_5;
    private String OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE;
    private String POBLACION_ATENDIDA_PERSONAS;
    private String POBLACION_ATENDIDA_INSTITUCIONES;
    private String POBLACION_ATENDIDA_PERSONAS_MORALES_;
    private String POBLACION_ATENDIDA_TERRITORIAL;
    private String POBLACION__ATENDIDA_OTRO_TIPO;
    private String POBLACION_ATENDIDA_NO_IDENTIFICADA;
    private String POBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE;
    private String POBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE;
    private String GRUPO_VULNERABLE_BENEFICIADO_1;
    private String GRUPO_VULNERABLE_BENEFICIADO_2;
    private String GRUPO_VULNERABLE_BENEFICIADO_3;
    private String GRUPO_VULNERABLE_BENEFICIADO_4;
    private String GRUPO_VULNERABLE_BENEFICIADO_5;
    private String GRUPO_VULNERABLE_BENEFICIADO_6;
    private String GRUPO_VULNERABLE_BENEFICIADO_7;
    private String GRUPO_VULNERABLE_BENEFICIADO_8;
    private String OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE;
    private String COMENTARIOS;

    public BeanTR_GF_PROGRAMAS_SOCIALES_2023() {
    }

    public String GetID_PROGRAMA_SOCIAL() {
        return ID_PROGRAMA_SOCIAL;
    }

    public void SetID_PROGRAMA_SOCIAL(String ID_PROGRAMA_SOCIAL) {
        this.ID_PROGRAMA_SOCIAL = ID_PROGRAMA_SOCIAL;
    }

    public String GetNOMBRE_PROGRAMA_SOCIAL() {
        return NOMBRE_PROGRAMA_SOCIAL;
    }

    public void SetNOMBRE_PROGRAMA_SOCIAL(String NOMBRE_PROGRAMA_SOCIAL) {
        this.NOMBRE_PROGRAMA_SOCIAL = NOMBRE_PROGRAMA_SOCIAL;
    }

    public String GetID_INSTITUCION_ENCARGADA_1() {
        return ID_INSTITUCION_ENCARGADA_1;
    }

    public void SetID_INSTITUCION_ENCARGADA_1(String ID_INSTITUCION_ENCARGADA_1) {
        this.ID_INSTITUCION_ENCARGADA_1 = ID_INSTITUCION_ENCARGADA_1;
    }

    public String GetNOMBRE_INSTITUCION_ENCARGADA_1() {
        return NOMBRE_INSTITUCION_ENCARGADA_1;
    }

    public void SetNOMBRE_INSTITUCION_ENCARGADA_1(String NOMBRE_INSTITUCION_ENCARGADA_1) {
        this.NOMBRE_INSTITUCION_ENCARGADA_1 = NOMBRE_INSTITUCION_ENCARGADA_1;
    }

    public String GetID_INSTITUCION_ENCARGADA_2() {
        return ID_INSTITUCION_ENCARGADA_2;
    }

    public void SetID_INSTITUCION_ENCARGADA_2(String ID_INSTITUCION_ENCARGADA_2) {
        this.ID_INSTITUCION_ENCARGADA_2 = ID_INSTITUCION_ENCARGADA_2;
    }

    public String GetNOMBRE_INSTITUCION_ENCARGADA_2() {
        return NOMBRE_INSTITUCION_ENCARGADA_2;
    }

    public void SetNOMBRE_INSTITUCION_ENCARGADA_2(String NOMBRE_INSTITUCION_ENCARGADA_2) {
        this.NOMBRE_INSTITUCION_ENCARGADA_2 = NOMBRE_INSTITUCION_ENCARGADA_2;
    }

    public String GetID_INSTITUCION_ENCARGADA_3() {
        return ID_INSTITUCION_ENCARGADA_3;
    }

    public void SetID_INSTITUCION_ENCARGADA_3(String ID_INSTITUCION_ENCARGADA_3) {
        this.ID_INSTITUCION_ENCARGADA_3 = ID_INSTITUCION_ENCARGADA_3;
    }

    public String GetNOMBRE_INSTITUCION_ENCARGADA_3() {
        return NOMBRE_INSTITUCION_ENCARGADA_3;
    }

    public void SetNOMBRE_INSTITUCION_ENCARGADA_3(String NOMBRE_INSTITUCION_ENCARGADA_3) {
        this.NOMBRE_INSTITUCION_ENCARGADA_3 = NOMBRE_INSTITUCION_ENCARGADA_3;
    }

    public String GetID_INSTITUCION_ENCARGADA_4() {
        return ID_INSTITUCION_ENCARGADA_4;
    }

    public void SetID_INSTITUCION_ENCARGADA_4(String ID_INSTITUCION_ENCARGADA_4) {
        this.ID_INSTITUCION_ENCARGADA_4 = ID_INSTITUCION_ENCARGADA_4;
    }

    public String GetNOMBRE_INSTITUCION_ENCARGADA_4() {
        return NOMBRE_INSTITUCION_ENCARGADA_4;
    }

    public void SetNOMBRE_INSTITUCION_ENCARGADA_4(String NOMBRE_INSTITUCION_ENCARGADA_4) {
        this.NOMBRE_INSTITUCION_ENCARGADA_4 = NOMBRE_INSTITUCION_ENCARGADA_4;
    }

    public String GetID_INSTITUCION_ENCARGADA_5() {
        return ID_INSTITUCION_ENCARGADA_5;
    }

    public void SetID_INSTITUCION_ENCARGADA_5(String ID_INSTITUCION_ENCARGADA_5) {
        this.ID_INSTITUCION_ENCARGADA_5 = ID_INSTITUCION_ENCARGADA_5;
    }

    public String GetNOMBRE_INSTITUCION_ENCARGADA_5() {
        return NOMBRE_INSTITUCION_ENCARGADA_5;
    }

    public void SetNOMBRE_INSTITUCION_ENCARGADA_5(String NOMBRE_INSTITUCION_ENCARGADA_5) {
        this.NOMBRE_INSTITUCION_ENCARGADA_5 = NOMBRE_INSTITUCION_ENCARGADA_5;
    }

    public String GetPRESUPUESTO_EJERCIDO() {
        return PRESUPUESTO_EJERCIDO;
    }

    public void SetPRESUPUESTO_EJERCIDO(String PRESUPUESTO_EJERCIDO) {
        this.PRESUPUESTO_EJERCIDO = PRESUPUESTO_EJERCIDO;
    }

    public String GetCOND_REGLAS_LINEAMIENTOS_OPERACION() {
        return COND_REGLAS_LINEAMIENTOS_OPERACION;
    }

    public void SetCOND_REGLAS_LINEAMIENTOS_OPERACION(String COND_REGLAS_LINEAMIENTOS_OPERACION) {
        this.COND_REGLAS_LINEAMIENTOS_OPERACION = COND_REGLAS_LINEAMIENTOS_OPERACION;
    }

    public String GetURL_REGLAS_LINEAMIENTOS_OPERACION() {
        return URL_REGLAS_LINEAMIENTOS_OPERACION;
    }

    public void SetURL_REGLAS_LINEAMIENTOS_OPERACION(String URL_REGLAS_LINEAMIENTOS_OPERACION) {
        this.URL_REGLAS_LINEAMIENTOS_OPERACION = URL_REGLAS_LINEAMIENTOS_OPERACION;
    }

    public String GetCOND_PADRON_PERSONAS_BENEFICIARIAS() {
        return COND_PADRON_PERSONAS_BENEFICIARIAS;
    }

    public void SetCOND_PADRON_PERSONAS_BENEFICIARIAS(String COND_PADRON_PERSONAS_BENEFICIARIAS) {
        this.COND_PADRON_PERSONAS_BENEFICIARIAS = COND_PADRON_PERSONAS_BENEFICIARIAS;
    }

    public String GetDERECHO_SOCIAL_ATENDIDO_1() {
        return DERECHO_SOCIAL_ATENDIDO_1;
    }

    public void SetDERECHO_SOCIAL_ATENDIDO_1(String DERECHO_SOCIAL_ATENDIDO_1) {
        this.DERECHO_SOCIAL_ATENDIDO_1 = DERECHO_SOCIAL_ATENDIDO_1;
    }

    public String GetDERECHO_SOCIAL_ATENDIDO_2() {
        return DERECHO_SOCIAL_ATENDIDO_2;
    }

    public void SetDERECHO_SOCIAL_ATENDIDO_2(String DERECHO_SOCIAL_ATENDIDO_2) {
        this.DERECHO_SOCIAL_ATENDIDO_2 = DERECHO_SOCIAL_ATENDIDO_2;
    }

    public String GetDERECHO_SOCIAL_ATENDIDO_3() {
        return DERECHO_SOCIAL_ATENDIDO_3;
    }

    public void SetDERECHO_SOCIAL_ATENDIDO_3(String DERECHO_SOCIAL_ATENDIDO_3) {
        this.DERECHO_SOCIAL_ATENDIDO_3 = DERECHO_SOCIAL_ATENDIDO_3;
    }

    public String GetDERECHO_SOCIAL_ATENDIDO_4() {
        return DERECHO_SOCIAL_ATENDIDO_4;
    }

    public void SetDERECHO_SOCIAL_ATENDIDO_4(String DERECHO_SOCIAL_ATENDIDO_4) {
        this.DERECHO_SOCIAL_ATENDIDO_4 = DERECHO_SOCIAL_ATENDIDO_4;
    }

    public String GetDERECHO_SOCIAL_ATENDIDO_5() {
        return DERECHO_SOCIAL_ATENDIDO_5;
    }

    public void SetDERECHO_SOCIAL_ATENDIDO_5(String DERECHO_SOCIAL_ATENDIDO_5) {
        this.DERECHO_SOCIAL_ATENDIDO_5 = DERECHO_SOCIAL_ATENDIDO_5;
    }

    public String GetAMBITO_ATENCION() {
        return AMBITO_ATENCION;
    }

    public void SetAMBITO_ATENCION(String AMBITO_ATENCION) {
        this.AMBITO_ATENCION = AMBITO_ATENCION;
    }

    public String GetTIPO_APOYO_ENTREGADO_1() {
        return TIPO_APOYO_ENTREGADO_1;
    }

    public void SetTIPO_APOYO_ENTREGADO_1(String TIPO_APOYO_ENTREGADO_1) {
        this.TIPO_APOYO_ENTREGADO_1 = TIPO_APOYO_ENTREGADO_1;
    }

    public String GetTIPO_APOYO_ENTREGADO_2() {
        return TIPO_APOYO_ENTREGADO_2;
    }

    public void SetTIPO_APOYO_ENTREGADO_2(String TIPO_APOYO_ENTREGADO_2) {
        this.TIPO_APOYO_ENTREGADO_2 = TIPO_APOYO_ENTREGADO_2;
    }

    public String GetTIPO_APOYO_ENTREGADO_3() {
        return TIPO_APOYO_ENTREGADO_3;
    }

    public void SetTIPO_APOYO_ENTREGADO_3(String TIPO_APOYO_ENTREGADO_3) {
        this.TIPO_APOYO_ENTREGADO_3 = TIPO_APOYO_ENTREGADO_3;
    }

    public String GetTIPO_APOYO_ENTREGADO_4() {
        return TIPO_APOYO_ENTREGADO_4;
    }

    public void SetTIPO_APOYO_ENTREGADO_4(String TIPO_APOYO_ENTREGADO_4) {
        this.TIPO_APOYO_ENTREGADO_4 = TIPO_APOYO_ENTREGADO_4;
    }

    public String GetTIPO_APOYO_ENTREGADO_5() {
        return TIPO_APOYO_ENTREGADO_5;
    }

    public void SetTIPO_APOYO_ENTREGADO_5(String TIPO_APOYO_ENTREGADO_5) {
        this.TIPO_APOYO_ENTREGADO_5 = TIPO_APOYO_ENTREGADO_5;
    }

    public String GetOTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE() {
        return OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE;
    }

    public void SetOTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE(String OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE) {
        this.OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE = OTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE;
    }

    public String GetPOBLACION_ATENDIDA_PERSONAS() {
        return POBLACION_ATENDIDA_PERSONAS;
    }

    public void SetPOBLACION_ATENDIDA_PERSONAS(String POBLACION_ATENDIDA_PERSONAS) {
        this.POBLACION_ATENDIDA_PERSONAS = POBLACION_ATENDIDA_PERSONAS;
    }

    public String GetPOBLACION_ATENDIDA_INSTITUCIONES() {
        return POBLACION_ATENDIDA_INSTITUCIONES;
    }

    public void SetPOBLACION_ATENDIDA_INSTITUCIONES(String POBLACION_ATENDIDA_INSTITUCIONES) {
        this.POBLACION_ATENDIDA_INSTITUCIONES = POBLACION_ATENDIDA_INSTITUCIONES;
    }

    public String GetPOBLACION_ATENDIDA_PERSONAS_MORALES_() {
        return POBLACION_ATENDIDA_PERSONAS_MORALES_;
    }

    public void SetPOBLACION_ATENDIDA_PERSONAS_MORALES_(String POBLACION_ATENDIDA_PERSONAS_MORALES_) {
        this.POBLACION_ATENDIDA_PERSONAS_MORALES_ = POBLACION_ATENDIDA_PERSONAS_MORALES_;
    }

    public String GetPOBLACION_ATENDIDA_TERRITORIAL() {
        return POBLACION_ATENDIDA_TERRITORIAL;
    }

    public void SetPOBLACION_ATENDIDA_TERRITORIAL(String POBLACION_ATENDIDA_TERRITORIAL) {
        this.POBLACION_ATENDIDA_TERRITORIAL = POBLACION_ATENDIDA_TERRITORIAL;
    }

    public String GetPOBLACION__ATENDIDA_OTRO_TIPO() {
        return POBLACION__ATENDIDA_OTRO_TIPO;
    }

    public void SetPOBLACION__ATENDIDA_OTRO_TIPO(String POBLACION__ATENDIDA_OTRO_TIPO) {
        this.POBLACION__ATENDIDA_OTRO_TIPO = POBLACION__ATENDIDA_OTRO_TIPO;
    }

    public String GetPOBLACION_ATENDIDA_NO_IDENTIFICADA() {
        return POBLACION_ATENDIDA_NO_IDENTIFICADA;
    }

    public void SetPOBLACION_ATENDIDA_NO_IDENTIFICADA(String POBLACION_ATENDIDA_NO_IDENTIFICADA) {
        this.POBLACION_ATENDIDA_NO_IDENTIFICADA = POBLACION_ATENDIDA_NO_IDENTIFICADA;
    }

    public String GetPOBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE() {
        return POBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE;
    }

    public void SetPOBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE(String POBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE) {
        this.POBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE = POBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE;
    }

    public String GetPOBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE() {
        return POBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE;
    }

    public void SetPOBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE(String POBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE) {
        this.POBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE = POBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE;
    }

    public String GetGRUPO_VULNERABLE_BENEFICIADO_1() {
        return GRUPO_VULNERABLE_BENEFICIADO_1;
    }

    public void SetGRUPO_VULNERABLE_BENEFICIADO_1(String GRUPO_VULNERABLE_BENEFICIADO_1) {
        this.GRUPO_VULNERABLE_BENEFICIADO_1 = GRUPO_VULNERABLE_BENEFICIADO_1;
    }

    public String GetGRUPO_VULNERABLE_BENEFICIADO_2() {
        return GRUPO_VULNERABLE_BENEFICIADO_2;
    }

    public void SetGRUPO_VULNERABLE_BENEFICIADO_2(String GRUPO_VULNERABLE_BENEFICIADO_2) {
        this.GRUPO_VULNERABLE_BENEFICIADO_2 = GRUPO_VULNERABLE_BENEFICIADO_2;
    }

    public String GetGRUPO_VULNERABLE_BENEFICIADO_3() {
        return GRUPO_VULNERABLE_BENEFICIADO_3;
    }

    public void SetGRUPO_VULNERABLE_BENEFICIADO_3(String GRUPO_VULNERABLE_BENEFICIADO_3) {
        this.GRUPO_VULNERABLE_BENEFICIADO_3 = GRUPO_VULNERABLE_BENEFICIADO_3;
    }

    public String GetGRUPO_VULNERABLE_BENEFICIADO_4() {
        return GRUPO_VULNERABLE_BENEFICIADO_4;
    }

    public void SetGRUPO_VULNERABLE_BENEFICIADO_4(String GRUPO_VULNERABLE_BENEFICIADO_4) {
        this.GRUPO_VULNERABLE_BENEFICIADO_4 = GRUPO_VULNERABLE_BENEFICIADO_4;
    }

    public String GetGRUPO_VULNERABLE_BENEFICIADO_5() {
        return GRUPO_VULNERABLE_BENEFICIADO_5;
    }

    public void SetGRUPO_VULNERABLE_BENEFICIADO_5(String GRUPO_VULNERABLE_BENEFICIADO_5) {
        this.GRUPO_VULNERABLE_BENEFICIADO_5 = GRUPO_VULNERABLE_BENEFICIADO_5;
    }

    public String GetGRUPO_VULNERABLE_BENEFICIADO_6() {
        return GRUPO_VULNERABLE_BENEFICIADO_6;
    }

    public void SetGRUPO_VULNERABLE_BENEFICIADO_6(String GRUPO_VULNERABLE_BENEFICIADO_6) {
        this.GRUPO_VULNERABLE_BENEFICIADO_6 = GRUPO_VULNERABLE_BENEFICIADO_6;
    }

    public String GetGRUPO_VULNERABLE_BENEFICIADO_7() {
        return GRUPO_VULNERABLE_BENEFICIADO_7;
    }

    public void SetGRUPO_VULNERABLE_BENEFICIADO_7(String GRUPO_VULNERABLE_BENEFICIADO_7) {
        this.GRUPO_VULNERABLE_BENEFICIADO_7 = GRUPO_VULNERABLE_BENEFICIADO_7;
    }

    public String GetGRUPO_VULNERABLE_BENEFICIADO_8() {
        return GRUPO_VULNERABLE_BENEFICIADO_8;
    }

    public void SetGRUPO_VULNERABLE_BENEFICIADO_8(String GRUPO_VULNERABLE_BENEFICIADO_8) {
        this.GRUPO_VULNERABLE_BENEFICIADO_8 = GRUPO_VULNERABLE_BENEFICIADO_8;
    }

    public String GetOTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE() {
        return OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE;
    }

    public void SetOTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE(String OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE) {
        this.OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE = OTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE;
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
            GetID_PROGRAMA_SOCIAL(),
            GetNOMBRE_PROGRAMA_SOCIAL(),
            GetID_INSTITUCION_ENCARGADA_1(),
            GetNOMBRE_INSTITUCION_ENCARGADA_1(),
            GetID_INSTITUCION_ENCARGADA_2(),
            GetNOMBRE_INSTITUCION_ENCARGADA_2(),
            GetID_INSTITUCION_ENCARGADA_3(),
            GetNOMBRE_INSTITUCION_ENCARGADA_3(),
            GetID_INSTITUCION_ENCARGADA_4(),
            GetNOMBRE_INSTITUCION_ENCARGADA_4(),
            GetID_INSTITUCION_ENCARGADA_5(),
            GetNOMBRE_INSTITUCION_ENCARGADA_5(),
            GetPRESUPUESTO_EJERCIDO(),
            GetCOND_REGLAS_LINEAMIENTOS_OPERACION(),
            GetURL_REGLAS_LINEAMIENTOS_OPERACION(),
            GetCOND_PADRON_PERSONAS_BENEFICIARIAS(),
            GetDERECHO_SOCIAL_ATENDIDO_1(),
            GetDERECHO_SOCIAL_ATENDIDO_2(),
            GetDERECHO_SOCIAL_ATENDIDO_3(),
            GetDERECHO_SOCIAL_ATENDIDO_4(),
            GetDERECHO_SOCIAL_ATENDIDO_5(),
            GetAMBITO_ATENCION(),
            GetTIPO_APOYO_ENTREGADO_1(),
            GetTIPO_APOYO_ENTREGADO_2(),
            GetTIPO_APOYO_ENTREGADO_3(),
            GetTIPO_APOYO_ENTREGADO_4(),
            GetTIPO_APOYO_ENTREGADO_5(),
            GetOTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE(),
            GetPOBLACION_ATENDIDA_PERSONAS(),
            GetPOBLACION_ATENDIDA_INSTITUCIONES(),
            GetPOBLACION_ATENDIDA_PERSONAS_MORALES_(),
            GetPOBLACION_ATENDIDA_TERRITORIAL(),
            GetPOBLACION__ATENDIDA_OTRO_TIPO(),
            GetPOBLACION_ATENDIDA_NO_IDENTIFICADA(),
            GetPOBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE(),
            GetPOBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE(),
            GetGRUPO_VULNERABLE_BENEFICIADO_1(),
            GetGRUPO_VULNERABLE_BENEFICIADO_2(),
            GetGRUPO_VULNERABLE_BENEFICIADO_3(),
            GetGRUPO_VULNERABLE_BENEFICIADO_4(),
            GetGRUPO_VULNERABLE_BENEFICIADO_5(),
            GetGRUPO_VULNERABLE_BENEFICIADO_6(),
            GetGRUPO_VULNERABLE_BENEFICIADO_7(),
            GetGRUPO_VULNERABLE_BENEFICIADO_8(),
            GetOTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE(),
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
