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
public class BeanTMP_PLE_MEDS1_6 extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_ENTIDAD_TMP;
    private String ENTIDAD;
    private String C1_6_ID_TMP;
    private String P1_6_1;
    private String P1_6_2;
    private String P1_6_3;
    private String P1_6_4;
    private String P1_6_5;
    private String P1_6_6;
    private String P1_6_7;
    private String P1_6_8;
    private String P1_6_9;
    private String P1_6_10;
    private String P1_6_11;
    private String P1_6_12;
    private String P1_6_13;
    private String P1_6_14;
    private String P1_6_15;
    private String P1_6_16;
    private String P1_6_17;
    private String P1_6_18;
    private String P1_6_19;
    private String P1_6_20;
    private String P1_6_21;
    private String P1_6_22;
    private String P1_6_23;
    private String P1_6_24;
    private String P1_6_25;
    private String P1_6_26;
    private String P1_6_27;
    private String P1_6_28;
    private String P1_6_29;
    private String P1_6_30;
    private String P1_6_31;
    private String P1_6_32;
    private String P1_6_33;
    private String P1_6_34;
    private String P1_6_35;
    private String P1_6_36;
    private String P1_6_37;
    private String P1_6_38;
    private String P1_6_39;
    private String P1_6_40;
    private String P1_6_41;
    private String P1_6_42;
    private String P1_6_43;
    private String P1_6_44;
    private String P1_6_45;
    private String P1_6_46;
    private String P1_6_47;
    private String P1_6_48;
    private String P1_6_49;
    private String P1_6_50;
    private String P1_6_51;
    private String P1_6_52;
    private String P1_6_53;
    private String P1_6_54;
    private String P1_6_55;
    private String P1_6_56;
    private String P1_6_57;
    private String P1_6_58;
    private String P1_6_59;
    private String P1_6_60;
    private String P1_6_61;
    private String P1_6_62;
    private String P1_6_63;
    private String P1_6_64;
    private String P1_6_65;
    private String P1_6_66;
    private String P1_6_67;
    private String P1_6_68;
    private String P1_6_69;
    private String P1_6_70;
    private String P1_6_71;
    private String P1_6_72;
    private String P1_6_73;
    private String P1_6_74;
    private String LEGISLATURA_TMP;

    public String GetID_ENTIDAD_TMP() {
        return ID_ENTIDAD_TMP;
    }

    public String GetENTIDAD() {
        return ENTIDAD;
    }

    public String GetC1_6_ID_TMP() {
        return C1_6_ID_TMP;
    }

    public String GetP1_6_1() {
        return P1_6_1;
    }

    public String GetP1_6_2() {
        return P1_6_2;
    }

    public String GetP1_6_3() {
        return P1_6_3;
    }

    public String GetP1_6_4() {
        return P1_6_4;
    }

    public String GetP1_6_5() {
        return P1_6_5;
    }

    public String GetP1_6_6() {
        return P1_6_6;
    }

    public String GetP1_6_7() {
        return P1_6_7;
    }

    public String GetP1_6_8() {
        return P1_6_8;
    }

    public String GetP1_6_9() {
        return P1_6_9;
    }

    public String GetP1_6_10() {
        return P1_6_10;
    }

    public String GetP1_6_11() {
        return P1_6_11;
    }

    public String GetP1_6_12() {
        return P1_6_12;
    }

    public String GetP1_6_13() {
        return P1_6_13;
    }

    public String GetP1_6_14() {
        return P1_6_14;
    }

    public String GetP1_6_15() {
        return P1_6_15;
    }

    public String GetP1_6_16() {
        return P1_6_16;
    }

    public String GetP1_6_17() {
        return P1_6_17;
    }

    public String GetP1_6_18() {
        return P1_6_18;
    }

    public String GetP1_6_19() {
        return P1_6_19;
    }

    public String GetP1_6_20() {
        return P1_6_20;
    }

    public String GetP1_6_21() {
        return P1_6_21;
    }

    public String GetP1_6_22() {
        return P1_6_22;
    }

    public String GetP1_6_23() {
        return P1_6_23;
    }

    public String GetP1_6_24() {
        return P1_6_24;
    }

    public String GetP1_6_25() {
        return P1_6_25;
    }

    public String GetP1_6_26() {
        return P1_6_26;
    }

    public String GetP1_6_27() {
        return P1_6_27;
    }

    public String GetP1_6_28() {
        return P1_6_28;
    }

    public String GetP1_6_29() {
        return P1_6_29;
    }

    public String GetP1_6_30() {
        return P1_6_30;
    }

    public String GetP1_6_31() {
        return P1_6_31;
    }

    public String GetP1_6_32() {
        return P1_6_32;
    }

    public String GetP1_6_33() {
        return P1_6_33;
    }

    public String GetP1_6_34() {
        return P1_6_34;
    }

    public String GetP1_6_35() {
        return P1_6_35;
    }

    public String GetP1_6_36() {
        return P1_6_36;
    }

    public String GetP1_6_37() {
        return P1_6_37;
    }

    public String GetP1_6_38() {
        return P1_6_38;
    }

    public String GetP1_6_39() {
        return P1_6_39;
    }

    public String GetP1_6_40() {
        return P1_6_40;
    }

    public String GetP1_6_41() {
        return P1_6_41;
    }

    public String GetP1_6_42() {
        return P1_6_42;
    }

    public String GetP1_6_43() {
        return P1_6_43;
    }

    public String GetP1_6_44() {
        return P1_6_44;
    }

    public String GetP1_6_45() {
        return P1_6_45;
    }

    public String GetP1_6_46() {
        return P1_6_46;
    }

    public String GetP1_6_47() {
        return P1_6_47;
    }

    public String GetP1_6_48() {
        return P1_6_48;
    }

    public String GetP1_6_49() {
        return P1_6_49;
    }

    public String GetP1_6_50() {
        return P1_6_50;
    }

    public String GetP1_6_51() {
        return P1_6_51;
    }

    public String GetP1_6_52() {
        return P1_6_52;
    }

    public String GetP1_6_53() {
        return P1_6_53;
    }

    public String GetP1_6_54() {
        return P1_6_54;
    }

    public String GetP1_6_55() {
        return P1_6_55;
    }

    public String GetP1_6_56() {
        return P1_6_56;
    }

    public String GetP1_6_57() {
        return P1_6_57;
    }

    public String GetP1_6_58() {
        return P1_6_58;
    }

    public String GetP1_6_59() {
        return P1_6_59;
    }

    public String GetP1_6_60() {
        return P1_6_60;
    }

    public String GetP1_6_61() {
        return P1_6_61;
    }

    public String GetP1_6_62() {
        return P1_6_62;
    }

    public String GetP1_6_63() {
        return P1_6_63;
    }

    public String GetP1_6_64() {
        return P1_6_64;
    }

    public String GetP1_6_65() {
        return P1_6_65;
    }

    public String GetP1_6_66() {
        return P1_6_66;
    }

    public String GetP1_6_67() {
        return P1_6_67;
    }

    public String GetP1_6_68() {
        return P1_6_68;
    }

    public String GetP1_6_69() {
        return P1_6_69;
    }

    public String GetP1_6_70() {
        return P1_6_70;
    }

    public String GetP1_6_71() {
        return P1_6_71;
    }

    public String GetP1_6_72() {
        return P1_6_72;
    }

    public String GetP1_6_73() {
        return P1_6_73;
    }

    public String GetP1_6_74() {
        return P1_6_74;
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

    public void SetC1_6_ID_TMP(String C1_6_ID_TMP) {
        this.C1_6_ID_TMP = C1_6_ID_TMP;
    }

    public void SetP1_6_1(String P1_6_1) {
        this.P1_6_1 = P1_6_1;
    }

    public void SetP1_6_2(String P1_6_2) {
        this.P1_6_2 = P1_6_2;
    }

    public void SetP1_6_3(String P1_6_3) {
        this.P1_6_3 = P1_6_3;
    }

    public void SetP1_6_4(String P1_6_4) {
        this.P1_6_4 = P1_6_4;
    }

    public void SetP1_6_5(String P1_6_5) {
        this.P1_6_5 = P1_6_5;
    }

    public void SetP1_6_6(String P1_6_6) {
        this.P1_6_6 = P1_6_6;
    }

    public void SetP1_6_7(String P1_6_7) {
        this.P1_6_7 = P1_6_7;
    }

    public void SetP1_6_8(String P1_6_8) {
        this.P1_6_8 = P1_6_8;
    }

    public void SetP1_6_9(String P1_6_9) {
        this.P1_6_9 = P1_6_9;
    }

    public void SetP1_6_10(String P1_6_10) {
        this.P1_6_10 = P1_6_10;
    }

    public void SetP1_6_11(String P1_6_11) {
        this.P1_6_11 = P1_6_11;
    }

    public void SetP1_6_12(String P1_6_12) {
        this.P1_6_12 = P1_6_12;
    }

    public void SetP1_6_13(String P1_6_13) {
        this.P1_6_13 = P1_6_13;
    }

    public void SetP1_6_14(String P1_6_14) {
        this.P1_6_14 = P1_6_14;
    }

    public void SetP1_6_15(String P1_6_15) {
        this.P1_6_15 = P1_6_15;
    }

    public void SetP1_6_16(String P1_6_16) {
        this.P1_6_16 = P1_6_16;
    }

    public void SetP1_6_17(String P1_6_17) {
        this.P1_6_17 = P1_6_17;
    }

    public void SetP1_6_18(String P1_6_18) {
        this.P1_6_18 = P1_6_18;
    }

    public void SetP1_6_19(String P1_6_19) {
        this.P1_6_19 = P1_6_19;
    }

    public void SetP1_6_20(String P1_6_20) {
        this.P1_6_20 = P1_6_20;
    }

    public void SetP1_6_21(String P1_6_21) {
        this.P1_6_21 = P1_6_21;
    }

    public void SetP1_6_22(String P1_6_22) {
        this.P1_6_22 = P1_6_22;
    }

    public void SetP1_6_23(String P1_6_23) {
        this.P1_6_23 = P1_6_23;
    }

    public void SetP1_6_24(String P1_6_24) {
        this.P1_6_24 = P1_6_24;
    }

    public void SetP1_6_25(String P1_6_25) {
        this.P1_6_25 = P1_6_25;
    }

    public void SetP1_6_26(String P1_6_26) {
        this.P1_6_26 = P1_6_26;
    }

    public void SetP1_6_27(String P1_6_27) {
        this.P1_6_27 = P1_6_27;
    }

    public void SetP1_6_28(String P1_6_28) {
        this.P1_6_28 = P1_6_28;
    }

    public void SetP1_6_29(String P1_6_29) {
        this.P1_6_29 = P1_6_29;
    }

    public void SetP1_6_30(String P1_6_30) {
        this.P1_6_30 = P1_6_30;
    }

    public void SetP1_6_31(String P1_6_31) {
        this.P1_6_31 = P1_6_31;
    }

    public void SetP1_6_32(String P1_6_32) {
        this.P1_6_32 = P1_6_32;
    }

    public void SetP1_6_33(String P1_6_33) {
        this.P1_6_33 = P1_6_33;
    }

    public void SetP1_6_34(String P1_6_34) {
        this.P1_6_34 = P1_6_34;
    }

    public void SetP1_6_35(String P1_6_35) {
        this.P1_6_35 = P1_6_35;
    }

    public void SetP1_6_36(String P1_6_36) {
        this.P1_6_36 = P1_6_36;
    }

    public void SetP1_6_37(String P1_6_37) {
        this.P1_6_37 = P1_6_37;
    }

    public void SetP1_6_38(String P1_6_38) {
        this.P1_6_38 = P1_6_38;
    }

    public void SetP1_6_39(String P1_6_39) {
        this.P1_6_39 = P1_6_39;
    }

    public void SetP1_6_40(String P1_6_40) {
        this.P1_6_40 = P1_6_40;
    }

    public void SetP1_6_41(String P1_6_41) {
        this.P1_6_41 = P1_6_41;
    }

    public void SetP1_6_42(String P1_6_42) {
        this.P1_6_42 = P1_6_42;
    }

    public void SetP1_6_43(String P1_6_43) {
        this.P1_6_43 = P1_6_43;
    }

    public void SetP1_6_44(String P1_6_44) {
        this.P1_6_44 = P1_6_44;
    }

    public void SetP1_6_45(String P1_6_45) {
        this.P1_6_45 = P1_6_45;
    }

    public void SetP1_6_46(String P1_6_46) {
        this.P1_6_46 = P1_6_46;
    }

    public void SetP1_6_47(String P1_6_47) {
        this.P1_6_47 = P1_6_47;
    }

    public void SetP1_6_48(String P1_6_48) {
        this.P1_6_48 = P1_6_48;
    }

    public void SetP1_6_49(String P1_6_49) {
        this.P1_6_49 = P1_6_49;
    }

    public void SetP1_6_50(String P1_6_50) {
        this.P1_6_50 = P1_6_50;
    }

    public void SetP1_6_51(String P1_6_51) {
        this.P1_6_51 = P1_6_51;
    }

    public void SetP1_6_52(String P1_6_52) {
        this.P1_6_52 = P1_6_52;
    }

    public void SetP1_6_53(String P1_6_53) {
        this.P1_6_53 = P1_6_53;
    }

    public void SetP1_6_54(String P1_6_54) {
        this.P1_6_54 = P1_6_54;
    }

    public void SetP1_6_55(String P1_6_55) {
        this.P1_6_55 = P1_6_55;
    }

    public void SetP1_6_56(String P1_6_56) {
        this.P1_6_56 = P1_6_56;
    }

    public void SetP1_6_57(String P1_6_57) {
        this.P1_6_57 = P1_6_57;
    }

    public void SetP1_6_58(String P1_6_58) {
        this.P1_6_58 = P1_6_58;
    }

    public void SetP1_6_59(String P1_6_59) {
        this.P1_6_59 = P1_6_59;
    }

    public void SetP1_6_60(String P1_6_60) {
        this.P1_6_60 = P1_6_60;
    }

    public void SetP1_6_61(String P1_6_61) {
        this.P1_6_61 = P1_6_61;
    }

    public void SetP1_6_62(String P1_6_62) {
        this.P1_6_62 = P1_6_62;
    }

    public void SetP1_6_63(String P1_6_63) {
        this.P1_6_63 = P1_6_63;
    }

    public void SetP1_6_64(String P1_6_64) {
        this.P1_6_64 = P1_6_64;
    }

    public void SetP1_6_65(String P1_6_65) {
        this.P1_6_65 = P1_6_65;
    }

    public void SetP1_6_66(String P1_6_66) {
        this.P1_6_66 = P1_6_66;
    }

    public void SetP1_6_67(String P1_6_67) {
        this.P1_6_67 = P1_6_67;
    }

    public void SetP1_6_68(String P1_6_68) {
        this.P1_6_68 = P1_6_68;
    }

    public void SetP1_6_69(String P1_6_69) {
        this.P1_6_69 = P1_6_69;
    }

    public void SetP1_6_70(String P1_6_70) {
        this.P1_6_70 = P1_6_70;
    }

    public void SetP1_6_71(String P1_6_71) {
        this.P1_6_71 = P1_6_71;
    }

    public void SetP1_6_72(String P1_6_72) {
        this.P1_6_72 = P1_6_72;
    }

    public void SetP1_6_73(String P1_6_73) {
        this.P1_6_73 = P1_6_73;
    }

    public void SetP1_6_74(String P1_6_74) {
        this.P1_6_74 = P1_6_74;
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
            GetC1_6_ID_TMP(),
            GetP1_6_1(),
            GetP1_6_2(),
            GetP1_6_3(),
            GetP1_6_4(),
            GetP1_6_5(),
            GetP1_6_6(),
            GetP1_6_7(),
            GetP1_6_8(),
            GetP1_6_9(),
            GetP1_6_10(),
            GetP1_6_11(),
            GetP1_6_12(),
            GetP1_6_13(),
            GetP1_6_14(),
            GetP1_6_15(),
            GetP1_6_16(),
            GetP1_6_17(),
            GetP1_6_18(),
            GetP1_6_19(),
            GetP1_6_20(),
            GetP1_6_21(),
            GetP1_6_22(),
            GetP1_6_23(),
            GetP1_6_24(),
            GetP1_6_25(),
            GetP1_6_26(),
            GetP1_6_27(),
            GetP1_6_28(),
            GetP1_6_29(),
            GetP1_6_30(),
            GetP1_6_31(),
            GetP1_6_32(),
            GetP1_6_33(),
            GetP1_6_34(),
            GetP1_6_35(),
            GetP1_6_36(),
            GetP1_6_37(),
            GetP1_6_38(),
            GetP1_6_39(),
            GetP1_6_40(),
            GetP1_6_41(),
            GetP1_6_42(),
            GetP1_6_43(),
            GetP1_6_44(),
            GetP1_6_45(),
            GetP1_6_46(),
            GetP1_6_47(),
            GetP1_6_48(),
            GetP1_6_49(),
            GetP1_6_50(),
            GetP1_6_51(),
            GetP1_6_52(),
            GetP1_6_53(),
            GetP1_6_54(),
            GetP1_6_55(),
            GetP1_6_56(),
            GetP1_6_57(),
            GetP1_6_58(),
            GetP1_6_59(),
            GetP1_6_60(),
            GetP1_6_61(),
            GetP1_6_62(),
            GetP1_6_63(),
            GetP1_6_64(),
            GetP1_6_65(),
            GetP1_6_66(),
            GetP1_6_67(),
            GetP1_6_68(),
            GetP1_6_69(),
            GetP1_6_70(),
            GetP1_6_71(),
            GetP1_6_72(),
            GetP1_6_73(),
            GetP1_6_74(),
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
