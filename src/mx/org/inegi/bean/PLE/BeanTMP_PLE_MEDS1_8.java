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
public class BeanTMP_PLE_MEDS1_8  extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_ENTIDAD_TMP;
    private String ENTIDAD;
    private String C1_8_ID_TMP;
    private String P1_8_1;
    private String P1_8_2;
    private String P1_8_3;
    private String P1_8_4;
    private String P1_8_5;
    private String P1_8_6;
    private String P1_8_7;
    private String P1_8_8;
    private String P1_8_9;
    private String P1_8_10;
    private String P1_8_11;
    private String P1_8_12;
    private String P1_8_13;
    private String P1_8_14;
    private String P1_8_15;
    private String P1_8_16;
    private String P1_8_17;
    private String P1_8_18;
    private String P1_8_19;
    private String P1_8_20;
    private String P1_8_21;
    private String P1_8_22;
    private String P1_8_23;
    private String P1_8_24;
    private String P1_8_25;
    private String P1_8_26;
    private String P1_8_27;
    private String P1_8_28;
    private String P1_8_29;
    private String P1_8_30;
    private String P1_8_31;
    private String P1_8_32;
    private String P1_8_33;
    private String LEGISLATURA_TMP;

    public String GetID_ENTIDAD_TMP() {
        return ID_ENTIDAD_TMP;
    }

    public String GetENTIDAD() {
        return ENTIDAD;
    }

    public String GetC1_8_ID_TMP() {
        return C1_8_ID_TMP;
    }

    public String GetP1_8_1() {
        return P1_8_1;
    }

    public String GetP1_8_2() {
        return P1_8_2;
    }

    public String GetP1_8_3() {
        return P1_8_3;
    }

    public String GetP1_8_4() {
        return P1_8_4;
    }

    public String GetP1_8_5() {
        return P1_8_5;
    }

    public String GetP1_8_6() {
        return P1_8_6;
    }

    public String GetP1_8_7() {
        return P1_8_7;
    }

    public String GetP1_8_8() {
        return P1_8_8;
    }

    public String GetP1_8_9() {
        return P1_8_9;
    }

    public String GetP1_8_10() {
        return P1_8_10;
    }

    public String GetP1_8_11() {
        return P1_8_11;
    }

    public String GetP1_8_12() {
        return P1_8_12;
    }

    public String GetP1_8_13() {
        return P1_8_13;
    }

    public String GetP1_8_14() {
        return P1_8_14;
    }

    public String GetP1_8_15() {
        return P1_8_15;
    }

    public String GetP1_8_16() {
        return P1_8_16;
    }

    public String GetP1_8_17() {
        return P1_8_17;
    }

    public String GetP1_8_18() {
        return P1_8_18;
    }

    public String GetP1_8_19() {
        return P1_8_19;
    }

    public String GetP1_8_20() {
        return P1_8_20;
    }

    public String GetP1_8_21() {
        return P1_8_21;
    }

    public String GetP1_8_22() {
        return P1_8_22;
    }

    public String GetP1_8_23() {
        return P1_8_23;
    }

    public String GetP1_8_24() {
        return P1_8_24;
    }

    public String GetP1_8_25() {
        return P1_8_25;
    }

    public String GetP1_8_26() {
        return P1_8_26;
    }

    public String GetP1_8_27() {
        return P1_8_27;
    }

    public String GetP1_8_28() {
        return P1_8_28;
    }

    public String GetP1_8_29() {
        return P1_8_29;
    }

    public String GetP1_8_30() {
        return P1_8_30;
    }

    public String GetP1_8_31() {
        return P1_8_31;
    }

    public String GetP1_8_32() {
        return P1_8_32;
    }

    public String GetP1_8_33() {
        return P1_8_33;
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

    public void SetC1_8_ID_TMP(String C1_8_ID_TMP) {
        this.C1_8_ID_TMP = C1_8_ID_TMP;
    }

    public void SetP1_8_1(String P1_8_1) {
        this.P1_8_1 = P1_8_1;
    }

    public void SetP1_8_2(String P1_8_2) {
        this.P1_8_2 = P1_8_2;
    }

    public void SetP1_8_3(String P1_8_3) {
        this.P1_8_3 = P1_8_3;
    }

    public void SetP1_8_4(String P1_8_4) {
        this.P1_8_4 = P1_8_4;
    }

    public void SetP1_8_5(String P1_8_5) {
        this.P1_8_5 = P1_8_5;
    }

    public void SetP1_8_6(String P1_8_6) {
        this.P1_8_6 = P1_8_6;
    }

    public void SetP1_8_7(String P1_8_7) {
        this.P1_8_7 = P1_8_7;
    }

    public void SetP1_8_8(String P1_8_8) {
        this.P1_8_8 = P1_8_8;
    }

    public void SetP1_8_9(String P1_8_9) {
        this.P1_8_9 = P1_8_9;
    }

    public void SetP1_8_10(String P1_8_10) {
        this.P1_8_10 = P1_8_10;
    }

    public void SetP1_8_11(String P1_8_11) {
        this.P1_8_11 = P1_8_11;
    }

    public void SetP1_8_12(String P1_8_12) {
        this.P1_8_12 = P1_8_12;
    }

    public void SetP1_8_13(String P1_8_13) {
        this.P1_8_13 = P1_8_13;
    }

    public void SetP1_8_14(String P1_8_14) {
        this.P1_8_14 = P1_8_14;
    }

    public void SetP1_8_15(String P1_8_15) {
        this.P1_8_15 = P1_8_15;
    }

    public void SetP1_8_16(String P1_8_16) {
        this.P1_8_16 = P1_8_16;
    }

    public void SetP1_8_17(String P1_8_17) {
        this.P1_8_17 = P1_8_17;
    }

    public void SetP1_8_18(String P1_8_18) {
        this.P1_8_18 = P1_8_18;
    }

    public void SetP1_8_19(String P1_8_19) {
        this.P1_8_19 = P1_8_19;
    }

    public void SetP1_8_20(String P1_8_20) {
        this.P1_8_20 = P1_8_20;
    }

    public void SetP1_8_21(String P1_8_21) {
        this.P1_8_21 = P1_8_21;
    }

    public void SetP1_8_22(String P1_8_22) {
        this.P1_8_22 = P1_8_22;
    }

    public void SetP1_8_23(String P1_8_23) {
        this.P1_8_23 = P1_8_23;
    }

    public void SetP1_8_24(String P1_8_24) {
        this.P1_8_24 = P1_8_24;
    }

    public void SetP1_8_25(String P1_8_25) {
        this.P1_8_25 = P1_8_25;
    }

    public void SetP1_8_26(String P1_8_26) {
        this.P1_8_26 = P1_8_26;
    }

    public void SetP1_8_27(String P1_8_27) {
        this.P1_8_27 = P1_8_27;
    }

    public void SetP1_8_28(String P1_8_28) {
        this.P1_8_28 = P1_8_28;
    }

    public void SetP1_8_29(String P1_8_29) {
        this.P1_8_29 = P1_8_29;
    }

    public void SetP1_8_30(String P1_8_30) {
        this.P1_8_30 = P1_8_30;
    }

    public void SetP1_8_31(String P1_8_31) {
        this.P1_8_31 = P1_8_31;
    }

    public void SetP1_8_32(String P1_8_32) {
        this.P1_8_32 = P1_8_32;
    }

    public void SetP1_8_33(String P1_8_33) {
        this.P1_8_33 = P1_8_33;
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
            GetC1_8_ID_TMP(),
            GetP1_8_1(),
            GetP1_8_2(),
            GetP1_8_3(),
            GetP1_8_4(),
            GetP1_8_5(),
            GetP1_8_6(),
            GetP1_8_7(),
            GetP1_8_8(),
            GetP1_8_9(),
            GetP1_8_10(),
            GetP1_8_11(),
            GetP1_8_12(),
            GetP1_8_13(),
            GetP1_8_14(),
            GetP1_8_15(),
            GetP1_8_16(),
            GetP1_8_17(),
            GetP1_8_18(),
            GetP1_8_19(),
            GetP1_8_20(),
            GetP1_8_21(),
            GetP1_8_22(),
            GetP1_8_23(),
            GetP1_8_24(),
            GetP1_8_25(),
            GetP1_8_26(),
            GetP1_8_27(),
            GetP1_8_28(),
            GetP1_8_29(),
            GetP1_8_30(),
            GetP1_8_31(),
            GetP1_8_32(),
            GetP1_8_33(),
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
