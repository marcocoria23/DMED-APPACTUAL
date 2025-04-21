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
public class BeanTMP_PLE_MEDS1_9  extends Bean implements SQLData  {

    private String SQLTypeName;
    private String ID_ENTIDAD_TMP;
    private String ENTIDAD;
    private String C1_9_ID_TMP;
    private String P1_9_1;
    private String P1_9_2;
    private String P1_9_3;
    private String P1_9_4;
    private String P1_9_5;
    private String P1_9_6;
    private String P1_9_7;
    private String P1_9_8;
    private String P1_9_9;
    private String P1_9_10;
    private String P1_9_11;
    private String P1_9_12;
    private String P1_9_13;
    private String P1_9_14;
    private String P1_9_15;
    private String P1_9_16;
    private String P1_9_17;
    private String P1_9_18;
    private String P1_9_19;
    private String P1_9_20;
    private String P1_9_21;
    private String P1_9_22;
    private String P1_9_23;
    private String P1_9_24;
    private String P1_9_25;
    private String P1_9_26;
    private String LEGISLATURA_TMP;

    public String GetID_ENTIDAD_TMP() {
        return ID_ENTIDAD_TMP;
    }

    public String GetENTIDAD() {
        return ENTIDAD;
    }

    public String GetC1_9_ID_TMP() {
        return C1_9_ID_TMP;
    }

    public String GetP1_9_1() {
        return P1_9_1;
    }

    public String GetP1_9_2() {
        return P1_9_2;
    }

    public String GetP1_9_3() {
        return P1_9_3;
    }

    public String GetP1_9_4() {
        return P1_9_4;
    }

    public String GetP1_9_5() {
        return P1_9_5;
    }

    public String GetP1_9_6() {
        return P1_9_6;
    }

    public String GetP1_9_7() {
        return P1_9_7;
    }

    public String GetP1_9_8() {
        return P1_9_8;
    }

    public String GetP1_9_9() {
        return P1_9_9;
    }

    public String GetP1_9_10() {
        return P1_9_10;
    }

    public String GetP1_9_11() {
        return P1_9_11;
    }

    public String GetP1_9_12() {
        return P1_9_12;
    }

    public String GetP1_9_13() {
        return P1_9_13;
    }

    public String GetP1_9_14() {
        return P1_9_14;
    }

    public String GetP1_9_15() {
        return P1_9_15;
    }

    public String GetP1_9_16() {
        return P1_9_16;
    }

    public String GetP1_9_17() {
        return P1_9_17;
    }

    public String GetP1_9_18() {
        return P1_9_18;
    }

    public String GetP1_9_19() {
        return P1_9_19;
    }

    public String GetP1_9_20() {
        return P1_9_20;
    }

    public String GetP1_9_21() {
        return P1_9_21;
    }

    public String GetP1_9_22() {
        return P1_9_22;
    }

    public String GetP1_9_23() {
        return P1_9_23;
    }

    public String GetP1_9_24() {
        return P1_9_24;
    }

    public String GetP1_9_25() {
        return P1_9_25;
    }

    public String GetP1_9_26() {
        return P1_9_26;
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

    public void SetC1_9_ID_TMP(String C1_9_ID_TMP) {
        this.C1_9_ID_TMP = C1_9_ID_TMP;
    }

    public void SetP1_9_1(String P1_9_1) {
        this.P1_9_1 = P1_9_1;
    }

    public void SetP1_9_2(String P1_9_2) {
        this.P1_9_2 = P1_9_2;
    }

    public void SetP1_9_3(String P1_9_3) {
        this.P1_9_3 = P1_9_3;
    }

    public void SetP1_9_4(String P1_9_4) {
        this.P1_9_4 = P1_9_4;
    }

    public void SetP1_9_5(String P1_9_5) {
        this.P1_9_5 = P1_9_5;
    }

    public void SetP1_9_6(String P1_9_6) {
        this.P1_9_6 = P1_9_6;
    }

    public void SetP1_9_7(String P1_9_7) {
        this.P1_9_7 = P1_9_7;
    }

    public void SetP1_9_8(String P1_9_8) {
        this.P1_9_8 = P1_9_8;
    }

    public void SetP1_9_9(String P1_9_9) {
        this.P1_9_9 = P1_9_9;
    }

    public void SetP1_9_10(String P1_9_10) {
        this.P1_9_10 = P1_9_10;
    }

    public void SetP1_9_11(String P1_9_11) {
        this.P1_9_11 = P1_9_11;
    }

    public void SetP1_9_12(String P1_9_12) {
        this.P1_9_12 = P1_9_12;
    }

    public void SetP1_9_13(String P1_9_13) {
        this.P1_9_13 = P1_9_13;
    }

    public void SetP1_9_14(String P1_9_14) {
        this.P1_9_14 = P1_9_14;
    }

    public void SetP1_9_15(String P1_9_15) {
        this.P1_9_15 = P1_9_15;
    }

    public void SetP1_9_16(String P1_9_16) {
        this.P1_9_16 = P1_9_16;
    }

    public void SetP1_9_17(String P1_9_17) {
        this.P1_9_17 = P1_9_17;
    }

    public void SetP1_9_18(String P1_9_18) {
        this.P1_9_18 = P1_9_18;
    }

    public void SetP1_9_19(String P1_9_19) {
        this.P1_9_19 = P1_9_19;
    }

    public void SetP1_9_20(String P1_9_20) {
        this.P1_9_20 = P1_9_20;
    }

    public void SetP1_9_21(String P1_9_21) {
        this.P1_9_21 = P1_9_21;
    }

    public void SetP1_9_22(String P1_9_22) {
        this.P1_9_22 = P1_9_22;
    }

    public void SetP1_9_23(String P1_9_23) {
        this.P1_9_23 = P1_9_23;
    }

    public void SetP1_9_24(String P1_9_24) {
        this.P1_9_24 = P1_9_24;
    }

    public void SetP1_9_25(String P1_9_25) {
        this.P1_9_25 = P1_9_25;
    }

    public void SetP1_9_26(String P1_9_26) {
        this.P1_9_26 = P1_9_26;
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
            GetC1_9_ID_TMP(),
            GetP1_9_1(),
            GetP1_9_2(),
            GetP1_9_3(),
            GetP1_9_4(),
            GetP1_9_5(),
            GetP1_9_6(),
            GetP1_9_7(),
            GetP1_9_8(),
            GetP1_9_9(),
            GetP1_9_10(),
            GetP1_9_11(),
            GetP1_9_12(),
            GetP1_9_13(),
            GetP1_9_14(),
            GetP1_9_15(),
            GetP1_9_16(),
            GetP1_9_17(),
            GetP1_9_18(),
            GetP1_9_19(),
            GetP1_9_20(),
            GetP1_9_21(),
            GetP1_9_22(),
            GetP1_9_23(),
            GetP1_9_24(),
            GetP1_9_25(),
            GetP1_9_26(),
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
