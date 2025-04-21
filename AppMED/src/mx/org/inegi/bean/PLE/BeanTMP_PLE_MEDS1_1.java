/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.bean.PLE;

import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 *
 * @author ANTONIO.CORIA
 */
public class BeanTMP_PLE_MEDS1_1 extends Bean implements SQLData{
   
    private String SQLTypeName;
    private String ID_ENTIDAD_TMP;
    private String ENTIDAD_TMP;
    private String P1_1_1;
    private String P1_1_2;
    private String P1_1_3;
    private String P1_1_4;
    private String P1_1_5;
    private String P1_1_6;
    private String P1_1_7;
    private String P1_1_8;
    private String P1_1_9;
    private String LEGISLATURA_TMP;
    private String C1_1_ID_TMP;
    private String ESTATUS;
    
    public BeanTMP_PLE_MEDS1_1 (){
}
    
     public String GetID_ENTIDAD_TMP() {
        return ID_ENTIDAD_TMP;
    }

    public void SetID_ENTIDAD_TMP(String ID_ENTIDAD_TMP) {
        this.ID_ENTIDAD_TMP = ID_ENTIDAD_TMP;
    }
    
     public String GetENTIDAD_TMP() {
        return ENTIDAD_TMP;
    }

    public void SetENTIDAD_TMP(String ENTIDAD_TMP) {
        this.ENTIDAD_TMP = ENTIDAD_TMP;
    }
    
     public String GetP1_1_1() {
        return P1_1_1;
    }

    public void SetP1_1_1(String P1_1_1) {
        this.P1_1_1 = P1_1_1;
    }
    
     public String GetP1_1_2() {
        return P1_1_2;
    }

    public void SetP1_1_2(String P1_1_2) {
        this.P1_1_2 = P1_1_2;
    }
    
     public String GetP1_1_3() {
        return P1_1_3;
    }

    public void SetP1_1_3(String P1_1_3) {
        this.P1_1_3 = P1_1_3;
    }
    
     public String GetP1_1_4() {
        return P1_1_4;
    }

    public void SetP1_1_4(String P1_1_4) {
        this.P1_1_4 = P1_1_4;
    }
    
     public String GetP1_1_5() {
        return P1_1_5;
    }

    public void SetP1_1_5(String P1_1_5) {
        this.P1_1_5 = P1_1_5;
    }
    
     public String GetP1_1_6() {
        return P1_1_6;
    }

    public void SetP1_1_6(String P1_1_6) {
        this.P1_1_6 = P1_1_6;
    }
    
     public String GetP1_1_7() {
        return P1_1_7;
    }

    public void SetP1_1_7(String P1_1_7) {
        this.P1_1_7 = P1_1_7;
    }
    
     public String GetP1_1_8() {
        return P1_1_8;
    }

    public void SetP1_1_8(String P1_1_8) {
        this.P1_1_8 = P1_1_8;
    }
    
     public String GetP1_1_9() {
        return P1_1_9;
    }

    public void SetP1_1_9(String P1_1_9) {
        this.P1_1_9 = P1_1_9;
    }
    
     public String GetLEGISLATURA_TMP() {
        return LEGISLATURA_TMP;
    }

    public void SetLEGISLATURA_TMP(String LEGISLATURA_TMP) {
        this.LEGISLATURA_TMP = LEGISLATURA_TMP;
    }
    
     public String GetC1_1_ID_TMP() {
        return C1_1_ID_TMP;
    }

    public void SetC1_1_ID_TMP(String C1_1_ID_TMP) {
        this.C1_1_ID_TMP = C1_1_ID_TMP;
    }
    
    public String GetESTATUS() {
        return ESTATUS;
    }

    public void SetESTATUS(String ESTATUS) {
        this.ESTATUS = ESTATUS;
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
         GetID_ENTIDAD_TMP(),
         GetENTIDAD_TMP(),
         GetP1_1_1(),
         GetP1_1_2(),
         GetP1_1_3(),
         GetP1_1_4(),
         GetP1_1_5(),
         GetP1_1_6(),
         GetP1_1_7(),
         GetP1_1_8(),
         GetP1_1_9(),
         GetLEGISLATURA_TMP(),
         GetC1_1_ID_TMP(),
         GetESTATUS()
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
