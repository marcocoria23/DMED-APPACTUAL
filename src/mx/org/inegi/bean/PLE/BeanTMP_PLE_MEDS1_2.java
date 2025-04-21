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
public class BeanTMP_PLE_MEDS1_2 extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_ENTIDAD_TMP;
    private String ENTIDAD;
    private String C1_2_ID_TMP;
    private String P1_2_1;
    private String P1_2_2;
    private String P1_2_3;
    private String P1_2_4;
    private String P1_2_5;
    private String P1_2_6;
    private String P1_2_7;
    private String P1_2_8;
    private String P1_2_9;
    private String P1_2_10;
    private String P1_2_11;
    private String P1_2_12;
    private String P1_2_13;
    private String P1_2_14;
    private String P1_2_15;
    private String P1_2_16;
    private String P1_2_17;
    private String P1_2_18;
    private String P1_2_19;
    private String LEGISLATURA_TMP;

    public String GetID_ENTIDAD_TMP() {
        return ID_ENTIDAD_TMP;
    }

    public String GetENTIDAD() {
        return ENTIDAD;
    }

    public String GetC1_2_ID_TMP() {
        return C1_2_ID_TMP;
    }

    public String GetP1_2_1() {
        return P1_2_1;
    }

    public String GetP1_2_2() {
        return P1_2_2;
    }

    public String GetP1_2_3() {
        return P1_2_3;
    }

    public String GetP1_2_4() {
        return P1_2_4;
    }

    public String GetP1_2_5() {
        return P1_2_5;
    }

    public String GetP1_2_6() {
        return P1_2_6;
    }

    public String GetP1_2_7() {
        return P1_2_7;
    }

    public String GetP1_2_8() {
        return P1_2_8;
    }

    public String GetP1_2_9() {
        return P1_2_9;
    }

    public String GetP1_2_10() {
        return P1_2_10;
    }

    public String GetP1_2_11() {
        return P1_2_11;
    }

    public String GetP1_2_12() {
        return P1_2_12;
    }

    public String GetP1_2_13() {
        return P1_2_13;
    }

    public String GetP1_2_14() {
        return P1_2_14;
    }

    public String GetP1_2_15() {
        return P1_2_15;
    }

    public String GetP1_2_16() {
        return P1_2_16;
    }

    public String GetP1_2_17() {
        return P1_2_17;
    }

    public String GetP1_2_18() {
        return P1_2_18;
    }

    public String GetP1_2_19() {
        return P1_2_19;
    }

    public String GetLEGISLATURA_TMP() {
        return LEGISLATURA_TMP;
    }

    public void SetID_ENTIDAD_TMP(String ID_ENTIDAD_TMP) {
        this.ID_ENTIDAD_TMP = ID_ENTIDAD_TMP;
    }

    public void SetENTIDAD(String ENTIDAD) {
        this.ENTIDAD = ENTIDAD;
    }

    public void SetC1_2_ID_TMP(String C1_2_ID_TMP) {
        this.C1_2_ID_TMP = C1_2_ID_TMP;
    }

    public void SetP1_2_1(String P1_2_1) {
        this.P1_2_1 = P1_2_1;
    }

    public void SetP1_2_2(String P1_2_2) {
        this.P1_2_2 = P1_2_2;
    }

    public void SetP1_2_3(String P1_2_3) {
        this.P1_2_3 = P1_2_3;
    }

    public void SetP1_2_4(String P1_2_4) {
        this.P1_2_4 = P1_2_4;
    }

    public void SetP1_2_5(String P1_2_5) {
        this.P1_2_5 = P1_2_5;
    }

    public void SetP1_2_6(String P1_2_6) {
        this.P1_2_6 = P1_2_6;
    }

    public void SetP1_2_7(String P1_2_7) {
        this.P1_2_7 = P1_2_7;
    }

    public void SetP1_2_8(String P1_2_8) {
        this.P1_2_8 = P1_2_8;
    }

    public void SetP1_2_9(String P1_2_9) {
        this.P1_2_9 = P1_2_9;
    }

    public void SetP1_2_10(String P1_2_10) {
        this.P1_2_10 = P1_2_10;
    }

    public void SetP1_2_11(String P1_2_11) {
        this.P1_2_11 = P1_2_11;
    }

    public void SetP1_2_12(String P1_2_12) {
        this.P1_2_12 = P1_2_12;
    }

    public void SetP1_2_13(String P1_2_13) {
        this.P1_2_13 = P1_2_13;
    }

    public void SetP1_2_14(String P1_2_14) {
        this.P1_2_14 = P1_2_14;
    }

    public void SetP1_2_15(String P1_2_15) {
        this.P1_2_15 = P1_2_15;
    }

    public void SetP1_2_16(String P1_2_16) {
        this.P1_2_16 = P1_2_16;
    }

    public void SetP1_2_17(String P1_2_17) {
        this.P1_2_17 = P1_2_17;
    }

    public void SetP1_2_18(String P1_2_18) {
        this.P1_2_18 = P1_2_18;
    }

    public void SetP1_2_19(String P1_2_19) {
        this.P1_2_19 = P1_2_19;
    }

    public void SetLEGISLATURA_TMP(String LEGISLATURA_TMP) {
        this.LEGISLATURA_TMP = LEGISLATURA_TMP;
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
            GetENTIDAD(),
            GetC1_2_ID_TMP(),
            GetP1_2_1(),
            GetP1_2_2(),
            GetP1_2_3(),
            GetP1_2_4(),
            GetP1_2_5(),
            GetP1_2_6(),
            GetP1_2_7(),
            GetP1_2_8(),
            GetP1_2_9(),
            GetP1_2_10(),
            GetP1_2_11(),
            GetP1_2_12(),
            GetP1_2_13(),
            GetP1_2_14(),
            GetP1_2_15(),
            GetP1_2_16(),
            GetP1_2_17(),
            GetP1_2_18(),
            GetP1_2_19(),
            GetLEGISLATURA_TMP()
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
