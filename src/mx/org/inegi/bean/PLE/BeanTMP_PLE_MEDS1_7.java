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
public class BeanTMP_PLE_MEDS1_7 extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_ENTIDAD_TMP;
    private String ENTIDAD;
    private String C1_7_ID_TMP;
    private String P1_7_1;
    private String P1_7_2;
    private String P1_7_3;
    private String P1_7_4;
    private String P1_7_5;
    private String P1_7_6;
    private String P1_7_7;
    private String P1_7_8;
    private String P1_7_9;
    private String P1_7_10;
    private String P1_7_11;
    private String P1_7_12;
    private String P1_7_13;
    private String P1_7_14;
    private String P1_7_15;
    private String P1_7_16;
    private String P1_7_17;
    private String P1_7_18;
    private String P1_7_19;
    private String P1_7_20;
    private String P1_7_21;
    private String P1_7_22;
    private String P1_7_23;
    private String P1_7_24;
    private String P1_7_25;
    private String P1_7_26;
    private String P1_7_27;
    private String P1_7_28;
    private String P1_7_29;
    private String P1_7_30;
    private String P1_7_31;
    private String P1_7_32;
    private String P1_7_33;
    private String P1_7_34;
    private String P1_7_35;
    private String P1_7_36;
    private String P1_7_37;
    private String LEGISLATURA_TMP;

    public String GetID_ENTIDAD_TMP() {
        return ID_ENTIDAD_TMP;
    }

    public String GetENTIDAD() {
        return ENTIDAD;
    }

    public String GetC1_7_ID_TMP() {
        return C1_7_ID_TMP;
    }

    public String GetP1_7_1() {
        return P1_7_1;
    }

    public String GetP1_7_2() {
        return P1_7_2;
    }

    public String GetP1_7_3() {
        return P1_7_3;
    }

    public String GetP1_7_4() {
        return P1_7_4;
    }

    public String GetP1_7_5() {
        return P1_7_5;
    }

    public String GetP1_7_6() {
        return P1_7_6;
    }

    public String GetP1_7_7() {
        return P1_7_7;
    }

    public String GetP1_7_8() {
        return P1_7_8;
    }

    public String GetP1_7_9() {
        return P1_7_9;
    }

    public String GetP1_7_10() {
        return P1_7_10;
    }

    public String GetP1_7_11() {
        return P1_7_11;
    }

    public String GetP1_7_12() {
        return P1_7_12;
    }

    public String GetP1_7_13() {
        return P1_7_13;
    }

    public String GetP1_7_14() {
        return P1_7_14;
    }

    public String GetP1_7_15() {
        return P1_7_15;
    }

    public String GetP1_7_16() {
        return P1_7_16;
    }

    public String GetP1_7_17() {
        return P1_7_17;
    }

    public String GetP1_7_18() {
        return P1_7_18;
    }

    public String GetP1_7_19() {
        return P1_7_19;
    }

    public String GetP1_7_20() {
        return P1_7_20;
    }

    public String GetP1_7_21() {
        return P1_7_21;
    }

    public String GetP1_7_22() {
        return P1_7_22;
    }

    public String GetP1_7_23() {
        return P1_7_23;
    }

    public String GetP1_7_24() {
        return P1_7_24;
    }

    public String GetP1_7_25() {
        return P1_7_25;
    }

    public String GetP1_7_26() {
        return P1_7_26;
    }

    public String GetP1_7_27() {
        return P1_7_27;
    }

    public String GetP1_7_28() {
        return P1_7_28;
    }

    public String GetP1_7_29() {
        return P1_7_29;
    }

    public String GetP1_7_30() {
        return P1_7_30;
    }

    public String GetP1_7_31() {
        return P1_7_31;
    }

    public String GetP1_7_32() {
        return P1_7_32;
    }

    public String GetP1_7_33() {
        return P1_7_33;
    }

    public String GetP1_7_34() {
        return P1_7_34;
    }

    public String GetP1_7_35() {
        return P1_7_35;
    }

    public String GetP1_7_36() {
        return P1_7_36;
    }

    public String GetP1_7_37() {
        return P1_7_37;
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

    public void SetC1_7_ID_TMP(String C1_7_ID_TMP) {
        this.C1_7_ID_TMP = C1_7_ID_TMP;
    }

    public void SetP1_7_1(String P1_7_1) {
        this.P1_7_1 = P1_7_1;
    }

    public void SetP1_7_2(String P1_7_2) {
        this.P1_7_2 = P1_7_2;
    }

    public void SetP1_7_3(String P1_7_3) {
        this.P1_7_3 = P1_7_3;
    }

    public void SetP1_7_4(String P1_7_4) {
        this.P1_7_4 = P1_7_4;
    }

    public void SetP1_7_5(String P1_7_5) {
        this.P1_7_5 = P1_7_5;
    }

    public void SetP1_7_6(String P1_7_6) {
        this.P1_7_6 = P1_7_6;
    }

    public void SetP1_7_7(String P1_7_7) {
        this.P1_7_7 = P1_7_7;
    }

    public void SetP1_7_8(String P1_7_8) {
        this.P1_7_8 = P1_7_8;
    }

    public void SetP1_7_9(String P1_7_9) {
        this.P1_7_9 = P1_7_9;
    }

    public void SetP1_7_10(String P1_7_10) {
        this.P1_7_10 = P1_7_10;
    }

    public void SetP1_7_11(String P1_7_11) {
        this.P1_7_11 = P1_7_11;
    }

    public void SetP1_7_12(String P1_7_12) {
        this.P1_7_12 = P1_7_12;
    }

    public void SetP1_7_13(String P1_7_13) {
        this.P1_7_13 = P1_7_13;
    }

    public void SetP1_7_14(String P1_7_14) {
        this.P1_7_14 = P1_7_14;
    }

    public void SetP1_7_15(String P1_7_15) {
        this.P1_7_15 = P1_7_15;
    }

    public void SetP1_7_16(String P1_7_16) {
        this.P1_7_16 = P1_7_16;
    }

    public void SetP1_7_17(String P1_7_17) {
        this.P1_7_17 = P1_7_17;
    }

    public void SetP1_7_18(String P1_7_18) {
        this.P1_7_18 = P1_7_18;
    }

    public void SetP1_7_19(String P1_7_19) {
        this.P1_7_19 = P1_7_19;
    }

    public void SetP1_7_20(String P1_7_20) {
        this.P1_7_20 = P1_7_20;
    }

    public void SetP1_7_21(String P1_7_21) {
        this.P1_7_21 = P1_7_21;
    }

    public void SetP1_7_22(String P1_7_22) {
        this.P1_7_22 = P1_7_22;
    }

    public void SetP1_7_23(String P1_7_23) {
        this.P1_7_23 = P1_7_23;
    }

    public void SetP1_7_24(String P1_7_24) {
        this.P1_7_24 = P1_7_24;
    }

    public void SetP1_7_25(String P1_7_25) {
        this.P1_7_25 = P1_7_25;
    }

    public void SetP1_7_26(String P1_7_26) {
        this.P1_7_26 = P1_7_26;
    }

    public void SetP1_7_27(String P1_7_27) {
        this.P1_7_27 = P1_7_27;
    }

    public void SetP1_7_28(String P1_7_28) {
        this.P1_7_28 = P1_7_28;
    }

    public void SetP1_7_29(String P1_7_29) {
        this.P1_7_29 = P1_7_29;
    }

    public void SetP1_7_30(String P1_7_30) {
        this.P1_7_30 = P1_7_30;
    }

    public void SetP1_7_31(String P1_7_31) {
        this.P1_7_31 = P1_7_31;
    }

    public void SetP1_7_32(String P1_7_32) {
        this.P1_7_32 = P1_7_32;
    }

    public void SetP1_7_33(String P1_7_33) {
        this.P1_7_33 = P1_7_33;
    }

    public void SetP1_7_34(String P1_7_34) {
        this.P1_7_34 = P1_7_34;
    }

    public void SetP1_7_35(String P1_7_35) {
        this.P1_7_35 = P1_7_35;
    }

    public void SetP1_7_36(String P1_7_36) {
        this.P1_7_36 = P1_7_36;
    }

    public void SetP1_7_37(String P1_7_37) {
        this.P1_7_37 = P1_7_37;
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
            GetC1_7_ID_TMP(),
            GetP1_7_1(),
            GetP1_7_2(),
            GetP1_7_3(),
            GetP1_7_4(),
            GetP1_7_5(),
            GetP1_7_6(),
            GetP1_7_7(),
            GetP1_7_8(),
            GetP1_7_9(),
            GetP1_7_10(),
            GetP1_7_11(),
            GetP1_7_12(),
            GetP1_7_13(),
            GetP1_7_14(),
            GetP1_7_15(),
            GetP1_7_16(),
            GetP1_7_17(),
            GetP1_7_18(),
            GetP1_7_19(),
            GetP1_7_20(),
            GetP1_7_21(),
            GetP1_7_22(),
            GetP1_7_23(),
            GetP1_7_24(),
            GetP1_7_25(),
            GetP1_7_26(),
            GetP1_7_27(),
            GetP1_7_28(),
            GetP1_7_29(),
            GetP1_7_30(),
            GetP1_7_31(),
            GetP1_7_32(),
            GetP1_7_33(),
            GetP1_7_34(),
            GetP1_7_35(),
            GetP1_7_36(),
            GetP1_7_37(),
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
