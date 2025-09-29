/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.bean.TEPJF;

/**
 *
 * @author ANTONIO.CORIA
 */
import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class BeanTEMP_TEPJF_EXPEDIENTE extends Bean implements SQLData {

    private String SQLTypeName;
    
    
    private String ID_TEPJF_EXPEDIENTE;
private String ID_EXP_ACUMULADO;
private String PERIODO;
private String ID_SALA;
private String DES_SALA;
private String NOMBRE_MAGISTRADO;
private String FECHA_INGRESO;
private String ID_ESTATUS_EXP;
private String FECHA_ING_ARCHIVO;
private String ID_AMBITO_ASUNTO;
private String ID_AGEE;
private String DES_AGEE;
private String ID_AGEM;
private String DES_AGEM;
private String ID_AGEE_FUERA_CIRC;
private String DES_AGEE_FUERA_CIRC;
private String ID_AGEM_FUERA_CIRC;
private String DES_AGEM_FUERA_CIRC;
private String ID_AGEE_FEDERAL;
private String DES_AGEE_FEDERAL;
private String ID_AGEM_FEDERAL;
private String DES_AGEM_FEDERAL;
private String ID_MEDIO_IMPUGNACION;
private String DES_MEDIO_IMPUGNACION;
private String ID_MATERIA;
private String ID_VINCULACION_PROCESO;
private String TEMA1_IMPUGNACION_N1;
private String TEMA1_IMPUGNACION_N2;
private String TEMA1_IMPUGNACION_N3;
private String TEMA1_IMPUGNACION_N4;
private String TEMA2_IMPUGNACION_N1;
private String TEMA2_IMPUGNACION_N2;
private String TEMA2_IMPUGNACION_N3;
private String TEMA2_IMPUGNACION_N4;
private String TEMA3_IMPUGNACION_N1;
private String TEMA3_IMPUGNACION_N2;
private String TEMA3_IMPUGNACION_N3;
private String TEMA3_IMPUGNACION_N4;
private String TEMA4_IMPUGNACION_N1;
private String TEMA4_IMPUGNACION_N2;
private String TEMA4_IMPUGNACION_N3;
private String TEMA4_IMPUGNACION_N4;
private String TEMA5_IMPUGNACION_N1;
private String TEMA5_IMPUGNACION_N2;
private String TEMA5_IMPUGNACION_N3;
private String TEMA5_IMPUGNACION_N4;
private String TEMA6_IMPUGNACION_N1;
private String TEMA6_IMPUGNACION_N2;
private String TEMA6_IMPUGNACION_N3;
private String TEMA6_IMPUGNACION_N4;
private String OTRO_TEMA1;
private String OTRO_TEMA2;
private String OTRO_TEMA3;
private String OTRO_TEMA4;
private String OTRO_TEMA5;
private String OTRO_TEMA6;
private String CANT_ACTORES;
private String CANT_RESPONSABLES;
private String CANT_TERCEROS_INTERESADOS;
private String OBSERVACIONES;

    public String getID_TEPJF_EXPEDIENTE() {
        return ID_TEPJF_EXPEDIENTE;
    }

    public void setID_TEPJF_EXPEDIENTE(String ID_TEPJF_EXPEDIENTE) {
        this.ID_TEPJF_EXPEDIENTE = ID_TEPJF_EXPEDIENTE;
    }

    public String GetID_EXP_ACUMULADO() {
        return ID_EXP_ACUMULADO;
    }

    public void SetID_EXP_ACUMULADO(String ID_EXP_ACUMULADO) {
        this.ID_EXP_ACUMULADO = ID_EXP_ACUMULADO;
    }

    public String GetPERIODO() {
        return PERIODO;
    }

    public void SetPERIODO(String PERIODO) {
        this.PERIODO = PERIODO;
    }

    public String GetID_SALA() {
        return ID_SALA;
    }

    public void SetID_SALA(String ID_SALA) {
        this.ID_SALA = ID_SALA;
    }

    public String GetDES_SALA() {
        return DES_SALA;
    }

    public void SetDES_SALA(String DES_SALA) {
        this.DES_SALA = DES_SALA;
    }

    public String GetNOMBRE_MAGISTRADO() {
        return NOMBRE_MAGISTRADO;
    }

    public void SetNOMBRE_MAGISTRADO(String NOMBRE_MAGISTRADO) {
        this.NOMBRE_MAGISTRADO = NOMBRE_MAGISTRADO;
    }

    public String GetFECHA_INGRESO() {
        return FECHA_INGRESO;
    }

    public void SetFECHA_INGRESO(String FECHA_INGRESO) {
        this.FECHA_INGRESO = FECHA_INGRESO;
    }

    public String GetID_ESTATUS_EXP() {
        return ID_ESTATUS_EXP;
    }

    public void SetID_ESTATUS_EXP(String ID_ESTATUS_EXP) {
        this.ID_ESTATUS_EXP = ID_ESTATUS_EXP;
    }

    public String GetFECHA_ING_ARCHIVO() {
        return FECHA_ING_ARCHIVO;
    }

    public void SetFECHA_ING_ARCHIVO(String FECHA_ING_ARCHIVO) {
        this.FECHA_ING_ARCHIVO = FECHA_ING_ARCHIVO;
    }

    public String GetID_AMBITO_ASUNTO() {
        return ID_AMBITO_ASUNTO;
    }

    public void SetID_AMBITO_ASUNTO(String ID_AMBITO_ASUNTO) {
        this.ID_AMBITO_ASUNTO = ID_AMBITO_ASUNTO;
    }

    public String GetID_AGEE() {
        return ID_AGEE;
    }

    public void SetID_AGEE(String ID_AGEE) {
        this.ID_AGEE = ID_AGEE;
    }

    public String GetDES_AGEE() {
        return DES_AGEE;
    }

    public void SetDES_AGEE(String DES_AGEE) {
        this.DES_AGEE = DES_AGEE;
    }
    
    public String GetID_AGEM() {
        return ID_AGEM;
    }

    public void SetID_AGEM(String ID_AGEM) {
        this.ID_AGEM = ID_AGEM;
    }
    
    
    
      public String GetDES_AGEM() {
        return DES_AGEM;
    }

    public void SetDES_AGEM(String DES_AGEM) {
        this.DES_AGEM = DES_AGEM;
    }

    public String GetID_AGEE_FUERA_CIRC() {
        return ID_AGEE_FUERA_CIRC;
    }

    public void SetID_AGEE_FUERA_CIRC(String ID_AGEE_FUERA_CIRC) {
        this.ID_AGEE_FUERA_CIRC = ID_AGEE_FUERA_CIRC;
    }

    public String GetDES_AGEE_FUERA_CIRC() {
        return DES_AGEE_FUERA_CIRC;
    }

    public void SetDES_AGEE_FUERA_CIRC(String DES_AGEE_FUERA_CIRC) {
        this.DES_AGEE_FUERA_CIRC = DES_AGEE_FUERA_CIRC;
    }
    
     public String GetID_AGEM_FUERA_CIRC() {
        return ID_AGEM_FUERA_CIRC;
    }

    public void SetID_AGEM_FUERA_CIRC(String ID_AGEM_FUERA_CIRC) {
        this.ID_AGEM_FUERA_CIRC = ID_AGEM_FUERA_CIRC;
    }

    public String GetDES_AGEM_FUERA_CIRC() {
        return DES_AGEM_FUERA_CIRC;
    }

    public void SetDES_AGEM_FUERA_CIRC(String DES_AGEM_FUERA_CIRC) {
        this.DES_AGEM_FUERA_CIRC = DES_AGEM_FUERA_CIRC;
    }
    
    
    public String GetID_AGEE_FEDERAL() {
        return ID_AGEE_FEDERAL;
    }

    public void SetID_AGEE_FEDERAL(String ID_AGEE_FEDERAL) {
        this.ID_AGEE_FEDERAL = ID_AGEE_FEDERAL;
    }

    public String GetDES_AGEE_FEDERAL() {
        return DES_AGEE_FEDERAL;
    }

    public void SetDES_AGEE_FEDERAL(String DES_AGEE_FEDERAL) {
        this.DES_AGEE_FEDERAL = DES_AGEE_FEDERAL;
    }

    
    public String GetID_AGEM_FEDERAL() {
        return ID_AGEM_FEDERAL;
    }

    public void SetID_AGEM_FEDERAL(String ID_AGEM_FEDERAL) {
        this.ID_AGEM_FEDERAL = ID_AGEM_FEDERAL;
    }

    public String GetDES_AGEM_FEDERAL() {
        return DES_AGEM_FEDERAL;
    }

    public void SetDES_AGEM_FEDERAL(String DES_AGEM_FEDERAL) {
        this.DES_AGEM_FEDERAL = DES_AGEM_FEDERAL;
    }

    public String GetID_MEDIO_IMPUGNACION() {
        return ID_MEDIO_IMPUGNACION;
    }

    public void SetID_MEDIO_IMPUGNACION(String ID_MEDIO_IMPUGNACION) {
        this.ID_MEDIO_IMPUGNACION = ID_MEDIO_IMPUGNACION;
    }

    public String GetDES_MEDIO_IMPUGNACION() {
        return DES_MEDIO_IMPUGNACION;
    }

    public void SetDES_MEDIO_IMPUGNACION(String DES_MEDIO_IMPUGNACION) {
        this.DES_MEDIO_IMPUGNACION = DES_MEDIO_IMPUGNACION;
    }

    public String GetID_MATERIA() {
        return ID_MATERIA;
    }

    public void SetID_MATERIA(String ID_MATERIA) {
        this.ID_MATERIA = ID_MATERIA;
    }

    public String GetID_VINCULACION_PROCESO() {
        return ID_VINCULACION_PROCESO;
    }

    public void SetID_VINCULACION_PROCESO(String ID_VINCULACION_PROCESO) {
        this.ID_VINCULACION_PROCESO = ID_VINCULACION_PROCESO;
    }

    public String GetTEMA1_IMPUGNACION_N1() {
        return TEMA1_IMPUGNACION_N1;
    }

    public void SetTEMA1_IMPUGNACION_N1(String TEMA1_IMPUGNACION_N1) {
        this.TEMA1_IMPUGNACION_N1 = TEMA1_IMPUGNACION_N1;
    }

    public String GetTEMA1_IMPUGNACION_N2() {
        return TEMA1_IMPUGNACION_N2;
    }

    public void SetTEMA1_IMPUGNACION_N2(String TEMA1_IMPUGNACION_N2) {
        this.TEMA1_IMPUGNACION_N2 = TEMA1_IMPUGNACION_N2;
    }

    public String GetTEMA1_IMPUGNACION_N3() {
        return TEMA1_IMPUGNACION_N3;
    }

    public void SetTEMA1_IMPUGNACION_N3(String TEMA1_IMPUGNACION_N3) {
        this.TEMA1_IMPUGNACION_N3 = TEMA1_IMPUGNACION_N3;
    }

    public String GetTEMA1_IMPUGNACION_N4() {
        return TEMA1_IMPUGNACION_N4;
    }

    public void SetTEMA1_IMPUGNACION_N4(String TEMA1_IMPUGNACION_N4) {
        this.TEMA1_IMPUGNACION_N4 = TEMA1_IMPUGNACION_N4;
    }

    public String GetTEMA2_IMPUGNACION_N1() {
        return TEMA2_IMPUGNACION_N1;
    }

    public void SetTEMA2_IMPUGNACION_N1(String TEMA2_IMPUGNACION_N1) {
        this.TEMA2_IMPUGNACION_N1 = TEMA2_IMPUGNACION_N1;
    }

    public String GetTEMA2_IMPUGNACION_N2() {
        return TEMA2_IMPUGNACION_N2;
    }

    public void SetTEMA2_IMPUGNACION_N2(String TEMA2_IMPUGNACION_N2) {
        this.TEMA2_IMPUGNACION_N2 = TEMA2_IMPUGNACION_N2;
    }

    public String GetTEMA2_IMPUGNACION_N3() {
        return TEMA2_IMPUGNACION_N3;
    }

    public void SetTEMA2_IMPUGNACION_N3(String TEMA2_IMPUGNACION_N3) {
        this.TEMA2_IMPUGNACION_N3 = TEMA2_IMPUGNACION_N3;
    }

    public String GetTEMA2_IMPUGNACION_N4() {
        return TEMA2_IMPUGNACION_N4;
    }

    public void SetTEMA2_IMPUGNACION_N4(String TEMA2_IMPUGNACION_N4) {
        this.TEMA2_IMPUGNACION_N4 = TEMA2_IMPUGNACION_N4;
    }

    public String GetTEMA3_IMPUGNACION_N1() {
        return TEMA3_IMPUGNACION_N1;
    }

    public void SetTEMA3_IMPUGNACION_N1(String TEMA3_IMPUGNACION_N1) {
        this.TEMA3_IMPUGNACION_N1 = TEMA3_IMPUGNACION_N1;
    }

    public String GetTEMA3_IMPUGNACION_N2() {
        return TEMA3_IMPUGNACION_N2;
    }

    public void SetTEMA3_IMPUGNACION_N2(String TEMA3_IMPUGNACION_N2) {
        this.TEMA3_IMPUGNACION_N2 = TEMA3_IMPUGNACION_N2;
    }

    public String GetTEMA3_IMPUGNACION_N3() {
        return TEMA3_IMPUGNACION_N3;
    }

    public void SetTEMA3_IMPUGNACION_N3(String TEMA3_IMPUGNACION_N3) {
        this.TEMA3_IMPUGNACION_N3 = TEMA3_IMPUGNACION_N3;
    }

    public String GetTEMA3_IMPUGNACION_N4() {
        return TEMA3_IMPUGNACION_N4;
    }

    public void SetTEMA3_IMPUGNACION_N4(String TEMA3_IMPUGNACION_N4) {
        this.TEMA3_IMPUGNACION_N4 = TEMA3_IMPUGNACION_N4;
    }

    public String GetTEMA4_IMPUGNACION_N1() {
        return TEMA4_IMPUGNACION_N1;
    }

    public void SetTEMA4_IMPUGNACION_N1(String TEMA4_IMPUGNACION_N1) {
        this.TEMA4_IMPUGNACION_N1 = TEMA4_IMPUGNACION_N1;
    }

    public String GetTEMA4_IMPUGNACION_N2() {
        return TEMA4_IMPUGNACION_N2;
    }

    public void SetTEMA4_IMPUGNACION_N2(String TEMA4_IMPUGNACION_N2) {
        this.TEMA4_IMPUGNACION_N2 = TEMA4_IMPUGNACION_N2;
    }

    public String GetTEMA4_IMPUGNACION_N3() {
        return TEMA4_IMPUGNACION_N3;
    }

    public void SetTEMA4_IMPUGNACION_N3(String TEMA4_IMPUGNACION_N3) {
        this.TEMA4_IMPUGNACION_N3 = TEMA4_IMPUGNACION_N3;
    }

    public String GetTEMA4_IMPUGNACION_N4() {
        return TEMA4_IMPUGNACION_N4;
    }

    public void SetTEMA4_IMPUGNACION_N4(String TEMA4_IMPUGNACION_N4) {
        this.TEMA4_IMPUGNACION_N4 = TEMA4_IMPUGNACION_N4;
    }

    public String GetTEMA5_IMPUGNACION_N1() {
        return TEMA5_IMPUGNACION_N1;
    }

    public void SetTEMA5_IMPUGNACION_N1(String TEMA5_IMPUGNACION_N1) {
        this.TEMA5_IMPUGNACION_N1 = TEMA5_IMPUGNACION_N1;
    }

    public String GetTEMA5_IMPUGNACION_N2() {
        return TEMA5_IMPUGNACION_N2;
    }

    public void SetTEMA5_IMPUGNACION_N2(String TEMA5_IMPUGNACION_N2) {
        this.TEMA5_IMPUGNACION_N2 = TEMA5_IMPUGNACION_N2;
    }

    public String GetTEMA5_IMPUGNACION_N3() {
        return TEMA5_IMPUGNACION_N3;
    }

    public void SetTEMA5_IMPUGNACION_N3(String TEMA5_IMPUGNACION_N3) {
        this.TEMA5_IMPUGNACION_N3 = TEMA5_IMPUGNACION_N3;
    }

    public String GetTEMA5_IMPUGNACION_N4() {
        return TEMA5_IMPUGNACION_N4;
    }

    public void SetTEMA5_IMPUGNACION_N4(String TEMA5_IMPUGNACION_N4) {
        this.TEMA5_IMPUGNACION_N4 = TEMA5_IMPUGNACION_N4;
    }

    public String getTEMA6_IMPUGNACION_N1() {
        return TEMA6_IMPUGNACION_N1;
    }

    public void setTEMA6_IMPUGNACION_N1(String TEMA6_IMPUGNACION_N1) {
        this.TEMA6_IMPUGNACION_N1 = TEMA6_IMPUGNACION_N1;
    }

    public String getTEMA6_IMPUGNACION_N2() {
        return TEMA6_IMPUGNACION_N2;
    }

    public void setTEMA6_IMPUGNACION_N2(String TEMA6_IMPUGNACION_N2) {
        this.TEMA6_IMPUGNACION_N2 = TEMA6_IMPUGNACION_N2;
    }

    public String getTEMA6_IMPUGNACION_N3() {
        return TEMA6_IMPUGNACION_N3;
    }

    public void setTEMA6_IMPUGNACION_N3(String TEMA6_IMPUGNACION_N3) {
        this.TEMA6_IMPUGNACION_N3 = TEMA6_IMPUGNACION_N3;
    }

    public String getTEMA6_IMPUGNACION_N4() {
        return TEMA6_IMPUGNACION_N4;
    }

    public void setTEMA6_IMPUGNACION_N4(String TEMA6_IMPUGNACION_N4) {
        this.TEMA6_IMPUGNACION_N4 = TEMA6_IMPUGNACION_N4;
    }
    
    
    
    
    

    public String GetOTRO_TEMA1() {
        return OTRO_TEMA1;
    }

    public void SetOTRO_TEMA1(String OTRO_TEMA1) {
        this.OTRO_TEMA1 = OTRO_TEMA1;
    }

    public String GetOTRO_TEMA2() {
        return OTRO_TEMA2;
    }

    public void SetOTRO_TEMA2(String OTRO_TEMA2) {
        this.OTRO_TEMA2 = OTRO_TEMA2;
    }

    public String GetOTRO_TEMA3() {
        return OTRO_TEMA3;
    }

    public void SetOTRO_TEMA3(String OTRO_TEMA3) {
        this.OTRO_TEMA3 = OTRO_TEMA3;
    }

    public String GetOTRO_TEMA4() {
        return OTRO_TEMA4;
    }

    public void SetOTRO_TEMA4(String OTRO_TEMA4) {
        this.OTRO_TEMA4 = OTRO_TEMA4;
    }

    public String GetOTRO_TEMA5() {
        return OTRO_TEMA5;
    }

    public void SetOTRO_TEMA5(String OTRO_TEMA5) {
        this.OTRO_TEMA5 = OTRO_TEMA5;
    }

    public String getOTRO_TEMA6() {
        return OTRO_TEMA6;
    }

    public void setOTRO_TEMA6(String OTRO_TEMA6) {
        this.OTRO_TEMA6 = OTRO_TEMA6;
    }
    
    

    public String GetCANT_ACTORES() {
        return CANT_ACTORES;
    }

    public void SetCANT_ACTORES(String CANT_ACTORES) {
        this.CANT_ACTORES = CANT_ACTORES;
    }

    public String GetCANT_RESPONSABLES() {
        return CANT_RESPONSABLES;
    }

    public void SetCANT_RESPONSABLES(String CANT_RESPONSABLES) {
        this.CANT_RESPONSABLES = CANT_RESPONSABLES;
    }

    public String GetCANT_TERCEROS_INTERESADOS() {
        return CANT_TERCEROS_INTERESADOS;
    }

    public void SetCANT_TERCEROS_INTERESADOS(String CANT_TERCEROS_INTERESADOS) {
        this.CANT_TERCEROS_INTERESADOS = CANT_TERCEROS_INTERESADOS;
    }

    public String GetOBSERVACIONES() {
        return OBSERVACIONES;
    }

    public void SetOBSERVACIONES(String OBSERVACIONES) {
        this.OBSERVACIONES = OBSERVACIONES;
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
            getID_TEPJF_EXPEDIENTE() ,
GetID_EXP_ACUMULADO() ,
GetPERIODO() ,
GetID_SALA() ,
GetDES_SALA() ,
GetNOMBRE_MAGISTRADO() ,
GetFECHA_INGRESO() ,
GetID_ESTATUS_EXP() ,
GetFECHA_ING_ARCHIVO() ,
GetID_AMBITO_ASUNTO() ,
GetID_AGEE() ,
GetDES_AGEE() ,
GetID_AGEM() ,
GetDES_AGEM() ,
GetID_AGEE_FUERA_CIRC() ,
GetDES_AGEE_FUERA_CIRC() ,
GetID_AGEM_FUERA_CIRC() ,
GetDES_AGEM_FUERA_CIRC() ,
GetID_AGEE_FEDERAL() ,
GetDES_AGEE_FEDERAL() ,
GetID_AGEM_FEDERAL() ,
GetDES_AGEM_FEDERAL() ,
GetID_MEDIO_IMPUGNACION() ,
GetDES_MEDIO_IMPUGNACION() ,
GetID_MATERIA() ,
GetID_VINCULACION_PROCESO() ,
GetTEMA1_IMPUGNACION_N1() ,
GetTEMA1_IMPUGNACION_N2() ,
GetTEMA1_IMPUGNACION_N3() ,
GetTEMA1_IMPUGNACION_N4() ,
GetTEMA2_IMPUGNACION_N1() ,
GetTEMA2_IMPUGNACION_N2() ,
GetTEMA2_IMPUGNACION_N3() ,
GetTEMA2_IMPUGNACION_N4() ,
GetTEMA3_IMPUGNACION_N1() ,
GetTEMA3_IMPUGNACION_N2() ,
GetTEMA3_IMPUGNACION_N3() ,
GetTEMA3_IMPUGNACION_N4() ,
GetTEMA4_IMPUGNACION_N1() ,
GetTEMA4_IMPUGNACION_N2() ,
GetTEMA4_IMPUGNACION_N3() ,
GetTEMA4_IMPUGNACION_N4() ,
GetTEMA5_IMPUGNACION_N1() ,
GetTEMA5_IMPUGNACION_N2() ,
GetTEMA5_IMPUGNACION_N3() ,
GetTEMA5_IMPUGNACION_N4() ,
getTEMA6_IMPUGNACION_N1() ,
getTEMA6_IMPUGNACION_N2() ,
getTEMA6_IMPUGNACION_N3() ,
getTEMA6_IMPUGNACION_N4() ,
GetOTRO_TEMA1() ,
GetOTRO_TEMA2() ,
GetOTRO_TEMA3() ,
GetOTRO_TEMA4() ,
GetOTRO_TEMA5() ,
getOTRO_TEMA6() ,
GetCANT_ACTORES() ,
GetCANT_RESPONSABLES() ,
GetCANT_TERCEROS_INTERESADOS() ,
            GetOBSERVACIONES()
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
