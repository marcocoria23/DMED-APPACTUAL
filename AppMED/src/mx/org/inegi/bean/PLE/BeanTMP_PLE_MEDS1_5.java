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
public class BeanTMP_PLE_MEDS1_5 extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_ENTIDAD_TMP;
    private String ENTIDAD;
    private String C1_5_ID_TMP;
    private String P1_5_1;
    private String P1_5_2;
    private String P1_5_3;
    private String P1_5_4;
    private String P1_5_5;
    private String P1_5_6;
    private String P1_5_7;
    private String P1_5_8;
    private String P1_5_9;
    private String P1_5_10;
    private String P1_5_11;
    private String P1_5_12;
    private String P1_5_13;
    private String P1_5_14;
    private String P1_5_15;
    private String P1_5_16;
    private String P1_5_17;
    private String P1_5_18;
    private String P1_5_19;
    private String P1_5_20;
    private String P1_5_21;
    private String P1_5_22;
    private String P1_5_23;
    private String P1_5_24;
    private String P1_5_25;
    private String P1_5_26;
    private String P1_5_27;
    private String P1_5_28;
    private String P1_5_29;
    private String P1_5_30;
    private String P1_5_31;
    private String P1_5_32;
    private String P1_5_33;
    private String P1_5_34;
    private String P1_5_35;
    private String P1_5_36;
    private String P1_5_37;
    private String P1_5_38;
    private String P1_5_39;
    private String P1_5_40;
    private String P1_5_41;
    private String P1_5_42;
    private String P1_5_43;
    private String P1_5_44;
    private String P1_5_45;
    private String P1_5_46;
    private String P1_5_47;
    private String P1_5_48;
    private String P1_5_49;
    private String P1_5_50;
    private String P1_5_51;
    private String P1_5_52;
    private String P1_5_53;
    private String P1_5_54;
    private String P1_5_55;
    private String P1_5_56;
    private String P1_5_57;
    private String P1_5_58;
    private String P1_5_59;
    private String P1_5_60;
    private String P1_5_61;
    private String P1_5_62;
    private String P1_5_63;
    private String P1_5_64;
    private String P1_5_65;
    private String P1_5_66;
    private String P1_5_67;
    private String P1_5_68;
    private String P1_5_69;
    private String P1_5_70;
    private String P1_5_71;
    private String P1_5_72;
    private String P1_5_73;
    private String P1_5_74;
    private String P1_5_75;
    private String P1_5_76;
    private String P1_5_77;
    private String P1_5_78;
    private String P1_5_79;
    private String P1_5_80;
    private String P1_5_81;
    private String P1_5_82;
    private String P1_5_83;
    private String P1_5_84;
    private String P1_5_85;
    private String P1_5_86;
    private String P1_5_87;
    private String P1_5_88;
    private String P1_5_89;
    private String P1_5_90;
    private String P1_5_91;
    private String P1_5_92;
    private String P1_5_93;
    private String P1_5_94;
    private String P1_5_95;
    private String P1_5_96;
    private String P1_5_97;
    private String P1_5_98;
    private String P1_5_99;
    private String P1_5_100;
    private String P1_5_101;
    private String P1_5_102;
    private String P1_5_103;
    private String P1_5_104;
    private String P1_5_105;
    private String P1_5_106;
    private String P1_5_107;
    private String P1_5_108;
    private String P1_5_109;
    private String P1_5_110;
    private String LEGISLATURA_TMP;

    public String GetID_ENTIDAD_TMP() {
        return ID_ENTIDAD_TMP;
    }

    public String GetENTIDAD() {
        return ENTIDAD;
    }

    public String GetC1_5_ID_TMP() {
        return C1_5_ID_TMP;
    }

    public String GetP1_5_1() {
        return P1_5_1;
    }

    public String GetP1_5_2() {
        return P1_5_2;
    }

    public String GetP1_5_3() {
        return P1_5_3;
    }

    public String GetP1_5_4() {
        return P1_5_4;
    }

    public String GetP1_5_5() {
        return P1_5_5;
    }

    public String GetP1_5_6() {
        return P1_5_6;
    }

    public String GetP1_5_7() {
        return P1_5_7;
    }

    public String GetP1_5_8() {
        return P1_5_8;
    }

    public String GetP1_5_9() {
        return P1_5_9;
    }

    public String GetP1_5_10() {
        return P1_5_10;
    }

    public String GetP1_5_11() {
        return P1_5_11;
    }

    public String GetP1_5_12() {
        return P1_5_12;
    }

    public String GetP1_5_13() {
        return P1_5_13;
    }

    public String GetP1_5_14() {
        return P1_5_14;
    }

    public String GetP1_5_15() {
        return P1_5_15;
    }

    public String GetP1_5_16() {
        return P1_5_16;
    }

    public String GetP1_5_17() {
        return P1_5_17;
    }

    public String GetP1_5_18() {
        return P1_5_18;
    }

    public String GetP1_5_19() {
        return P1_5_19;
    }

    public String GetP1_5_20() {
        return P1_5_20;
    }

    public String GetP1_5_21() {
        return P1_5_21;
    }

    public String GetP1_5_22() {
        return P1_5_22;
    }

    public String GetP1_5_23() {
        return P1_5_23;
    }

    public String GetP1_5_24() {
        return P1_5_24;
    }

    public String GetP1_5_25() {
        return P1_5_25;
    }

    public String GetP1_5_26() {
        return P1_5_26;
    }

    public String GetP1_5_27() {
        return P1_5_27;
    }

    public String GetP1_5_28() {
        return P1_5_28;
    }

    public String GetP1_5_29() {
        return P1_5_29;
    }

    public String GetP1_5_30() {
        return P1_5_30;
    }

    public String GetP1_5_31() {
        return P1_5_31;
    }

    public String GetP1_5_32() {
        return P1_5_32;
    }

    public String GetP1_5_33() {
        return P1_5_33;
    }

    public String GetP1_5_34() {
        return P1_5_34;
    }

    public String GetP1_5_35() {
        return P1_5_35;
    }

    public String GetP1_5_36() {
        return P1_5_36;
    }

    public String GetP1_5_37() {
        return P1_5_37;
    }

    public String GetP1_5_38() {
        return P1_5_38;
    }

    public String GetP1_5_39() {
        return P1_5_39;
    }

    public String GetP1_5_40() {
        return P1_5_40;
    }

    public String GetP1_5_41() {
        return P1_5_41;
    }

    public String GetP1_5_42() {
        return P1_5_42;
    }

    public String GetP1_5_43() {
        return P1_5_43;
    }

    public String GetP1_5_44() {
        return P1_5_44;
    }

    public String GetP1_5_45() {
        return P1_5_45;
    }

    public String GetP1_5_46() {
        return P1_5_46;
    }

    public String GetP1_5_47() {
        return P1_5_47;
    }

    public String GetP1_5_48() {
        return P1_5_48;
    }

    public String GetP1_5_49() {
        return P1_5_49;
    }

    public String GetP1_5_50() {
        return P1_5_50;
    }

    public String GetP1_5_51() {
        return P1_5_51;
    }

    public String GetP1_5_52() {
        return P1_5_52;
    }

    public String GetP1_5_53() {
        return P1_5_53;
    }

    public String GetP1_5_54() {
        return P1_5_54;
    }

    public String GetP1_5_55() {
        return P1_5_55;
    }

    public String GetP1_5_56() {
        return P1_5_56;
    }

    public String GetP1_5_57() {
        return P1_5_57;
    }

    public String GetP1_5_58() {
        return P1_5_58;
    }

    public String GetP1_5_59() {
        return P1_5_59;
    }

    public String GetP1_5_60() {
        return P1_5_60;
    }

    public String GetP1_5_61() {
        return P1_5_61;
    }

    public String GetP1_5_62() {
        return P1_5_62;
    }

    public String GetP1_5_63() {
        return P1_5_63;
    }

    public String GetP1_5_64() {
        return P1_5_64;
    }

    public String GetP1_5_65() {
        return P1_5_65;
    }

    public String GetP1_5_66() {
        return P1_5_66;
    }

    public String GetP1_5_67() {
        return P1_5_67;
    }

    public String GetP1_5_68() {
        return P1_5_68;
    }

    public String GetP1_5_69() {
        return P1_5_69;
    }

    public String GetP1_5_70() {
        return P1_5_70;
    }

    public String GetP1_5_71() {
        return P1_5_71;
    }

    public String GetP1_5_72() {
        return P1_5_72;
    }

    public String GetP1_5_73() {
        return P1_5_73;
    }

    public String GetP1_5_74() {
        return P1_5_74;
    }

    public String GetP1_5_75() {
        return P1_5_75;
    }

    public String GetP1_5_76() {
        return P1_5_76;
    }

    public String GetP1_5_77() {
        return P1_5_77;
    }

    public String GetP1_5_78() {
        return P1_5_78;
    }

    public String GetP1_5_79() {
        return P1_5_79;
    }

    public String GetP1_5_80() {
        return P1_5_80;
    }

    public String GetP1_5_81() {
        return P1_5_81;
    }

    public String GetP1_5_82() {
        return P1_5_82;
    }

    public String GetP1_5_83() {
        return P1_5_83;
    }

    public String GetP1_5_84() {
        return P1_5_84;
    }

    public String GetP1_5_85() {
        return P1_5_85;
    }

    public String GetP1_5_86() {
        return P1_5_86;
    }

    public String GetP1_5_87() {
        return P1_5_87;
    }

    public String GetP1_5_88() {
        return P1_5_88;
    }

    public String GetP1_5_89() {
        return P1_5_89;
    }

    public String GetP1_5_90() {
        return P1_5_90;
    }

    public String GetP1_5_91() {
        return P1_5_91;
    }

    public String GetP1_5_92() {
        return P1_5_92;
    }

    public String GetP1_5_93() {
        return P1_5_93;
    }

    public String GetP1_5_94() {
        return P1_5_94;
    }

    public String GetP1_5_95() {
        return P1_5_95;
    }

    public String GetP1_5_96() {
        return P1_5_96;
    }

    public String GetP1_5_97() {
        return P1_5_97;
    }

    public String GetP1_5_98() {
        return P1_5_98;
    }

    public String GetP1_5_99() {
        return P1_5_99;
    }

    public String GetP1_5_100() {
        return P1_5_100;
    }

    public String GetP1_5_101() {
        return P1_5_101;
    }

    public String GetP1_5_102() {
        return P1_5_102;
    }

    public String GetP1_5_103() {
        return P1_5_103;
    }

    public String GetP1_5_104() {
        return P1_5_104;
    }

    public String GetP1_5_105() {
        return P1_5_105;
    }

    public String GetP1_5_106() {
        return P1_5_106;
    }

    public String GetP1_5_107() {
        return P1_5_107;
    }

    public String GetP1_5_108() {
        return P1_5_108;
    }

    public String GetP1_5_109() {
        return P1_5_109;
    }

    public String GetP1_5_110() {
        return P1_5_110;
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

    public void SetC1_5_ID_TMP(String C1_5_ID_TMP) {
        this.C1_5_ID_TMP = C1_5_ID_TMP;
    }

    public void SetP1_5_1(String P1_5_1) {
        this.P1_5_1 = P1_5_1;
    }

    public void SetP1_5_2(String P1_5_2) {
        this.P1_5_2 = P1_5_2;
    }

    public void SetP1_5_3(String P1_5_3) {
        this.P1_5_3 = P1_5_3;
    }

    public void SetP1_5_4(String P1_5_4) {
        this.P1_5_4 = P1_5_4;
    }

    public void SetP1_5_5(String P1_5_5) {
        this.P1_5_5 = P1_5_5;
    }

    public void SetP1_5_6(String P1_5_6) {
        this.P1_5_6 = P1_5_6;
    }

    public void SetP1_5_7(String P1_5_7) {
        this.P1_5_7 = P1_5_7;
    }

    public void SetP1_5_8(String P1_5_8) {
        this.P1_5_8 = P1_5_8;
    }

    public void SetP1_5_9(String P1_5_9) {
        this.P1_5_9 = P1_5_9;
    }

    public void SetP1_5_10(String P1_5_10) {
        this.P1_5_10 = P1_5_10;
    }

    public void SetP1_5_11(String P1_5_11) {
        this.P1_5_11 = P1_5_11;
    }

    public void SetP1_5_12(String P1_5_12) {
        this.P1_5_12 = P1_5_12;
    }

    public void SetP1_5_13(String P1_5_13) {
        this.P1_5_13 = P1_5_13;
    }

    public void SetP1_5_14(String P1_5_14) {
        this.P1_5_14 = P1_5_14;
    }

    public void SetP1_5_15(String P1_5_15) {
        this.P1_5_15 = P1_5_15;
    }

    public void SetP1_5_16(String P1_5_16) {
        this.P1_5_16 = P1_5_16;
    }

    public void SetP1_5_17(String P1_5_17) {
        this.P1_5_17 = P1_5_17;
    }

    public void SetP1_5_18(String P1_5_18) {
        this.P1_5_18 = P1_5_18;
    }

    public void SetP1_5_19(String P1_5_19) {
        this.P1_5_19 = P1_5_19;
    }

    public void SetP1_5_20(String P1_5_20) {
        this.P1_5_20 = P1_5_20;
    }

    public void SetP1_5_21(String P1_5_21) {
        this.P1_5_21 = P1_5_21;
    }

    public void SetP1_5_22(String P1_5_22) {
        this.P1_5_22 = P1_5_22;
    }

    public void SetP1_5_23(String P1_5_23) {
        this.P1_5_23 = P1_5_23;
    }

    public void SetP1_5_24(String P1_5_24) {
        this.P1_5_24 = P1_5_24;
    }

    public void SetP1_5_25(String P1_5_25) {
        this.P1_5_25 = P1_5_25;
    }

    public void SetP1_5_26(String P1_5_26) {
        this.P1_5_26 = P1_5_26;
    }

    public void SetP1_5_27(String P1_5_27) {
        this.P1_5_27 = P1_5_27;
    }

    public void SetP1_5_28(String P1_5_28) {
        this.P1_5_28 = P1_5_28;
    }

    public void SetP1_5_29(String P1_5_29) {
        this.P1_5_29 = P1_5_29;
    }

    public void SetP1_5_30(String P1_5_30) {
        this.P1_5_30 = P1_5_30;
    }

    public void SetP1_5_31(String P1_5_31) {
        this.P1_5_31 = P1_5_31;
    }

    public void SetP1_5_32(String P1_5_32) {
        this.P1_5_32 = P1_5_32;
    }

    public void SetP1_5_33(String P1_5_33) {
        this.P1_5_33 = P1_5_33;
    }

    public void SetP1_5_34(String P1_5_34) {
        this.P1_5_34 = P1_5_34;
    }

    public void SetP1_5_35(String P1_5_35) {
        this.P1_5_35 = P1_5_35;
    }

    public void SetP1_5_36(String P1_5_36) {
        this.P1_5_36 = P1_5_36;
    }

    public void SetP1_5_37(String P1_5_37) {
        this.P1_5_37 = P1_5_37;
    }

    public void SetP1_5_38(String P1_5_38) {
        this.P1_5_38 = P1_5_38;
    }

    public void SetP1_5_39(String P1_5_39) {
        this.P1_5_39 = P1_5_39;
    }

    public void SetP1_5_40(String P1_5_40) {
        this.P1_5_40 = P1_5_40;
    }

    public void SetP1_5_41(String P1_5_41) {
        this.P1_5_41 = P1_5_41;
    }

    public void SetP1_5_42(String P1_5_42) {
        this.P1_5_42 = P1_5_42;
    }

    public void SetP1_5_43(String P1_5_43) {
        this.P1_5_43 = P1_5_43;
    }

    public void SetP1_5_44(String P1_5_44) {
        this.P1_5_44 = P1_5_44;
    }

    public void SetP1_5_45(String P1_5_45) {
        this.P1_5_45 = P1_5_45;
    }

    public void SetP1_5_46(String P1_5_46) {
        this.P1_5_46 = P1_5_46;
    }

    public void SetP1_5_47(String P1_5_47) {
        this.P1_5_47 = P1_5_47;
    }

    public void SetP1_5_48(String P1_5_48) {
        this.P1_5_48 = P1_5_48;
    }

    public void SetP1_5_49(String P1_5_49) {
        this.P1_5_49 = P1_5_49;
    }

    public void SetP1_5_50(String P1_5_50) {
        this.P1_5_50 = P1_5_50;
    }

    public void SetP1_5_51(String P1_5_51) {
        this.P1_5_51 = P1_5_51;
    }

    public void SetP1_5_52(String P1_5_52) {
        this.P1_5_52 = P1_5_52;
    }

    public void SetP1_5_53(String P1_5_53) {
        this.P1_5_53 = P1_5_53;
    }

    public void SetP1_5_54(String P1_5_54) {
        this.P1_5_54 = P1_5_54;
    }

    public void SetP1_5_55(String P1_5_55) {
        this.P1_5_55 = P1_5_55;
    }

    public void SetP1_5_56(String P1_5_56) {
        this.P1_5_56 = P1_5_56;
    }

    public void SetP1_5_57(String P1_5_57) {
        this.P1_5_57 = P1_5_57;
    }

    public void SetP1_5_58(String P1_5_58) {
        this.P1_5_58 = P1_5_58;
    }

    public void SetP1_5_59(String P1_5_59) {
        this.P1_5_59 = P1_5_59;
    }

    public void SetP1_5_60(String P1_5_60) {
        this.P1_5_60 = P1_5_60;
    }

    public void SetP1_5_61(String P1_5_61) {
        this.P1_5_61 = P1_5_61;
    }

    public void SetP1_5_62(String P1_5_62) {
        this.P1_5_62 = P1_5_62;
    }

    public void SetP1_5_63(String P1_5_63) {
        this.P1_5_63 = P1_5_63;
    }

    public void SetP1_5_64(String P1_5_64) {
        this.P1_5_64 = P1_5_64;
    }

    public void SetP1_5_65(String P1_5_65) {
        this.P1_5_65 = P1_5_65;
    }

    public void SetP1_5_66(String P1_5_66) {
        this.P1_5_66 = P1_5_66;
    }

    public void SetP1_5_67(String P1_5_67) {
        this.P1_5_67 = P1_5_67;
    }

    public void SetP1_5_68(String P1_5_68) {
        this.P1_5_68 = P1_5_68;
    }

    public void SetP1_5_69(String P1_5_69) {
        this.P1_5_69 = P1_5_69;
    }

    public void SetP1_5_70(String P1_5_70) {
        this.P1_5_70 = P1_5_70;
    }

    public void SetP1_5_71(String P1_5_71) {
        this.P1_5_71 = P1_5_71;
    }

    public void SetP1_5_72(String P1_5_72) {
        this.P1_5_72 = P1_5_72;
    }

    public void SetP1_5_73(String P1_5_73) {
        this.P1_5_73 = P1_5_73;
    }

    public void SetP1_5_74(String P1_5_74) {
        this.P1_5_74 = P1_5_74;
    }

    public void SetP1_5_75(String P1_5_75) {
        this.P1_5_75 = P1_5_75;
    }

    public void SetP1_5_76(String P1_5_76) {
        this.P1_5_76 = P1_5_76;
    }

    public void SetP1_5_77(String P1_5_77) {
        this.P1_5_77 = P1_5_77;
    }

    public void SetP1_5_78(String P1_5_78) {
        this.P1_5_78 = P1_5_78;
    }

    public void SetP1_5_79(String P1_5_79) {
        this.P1_5_79 = P1_5_79;
    }

    public void SetP1_5_80(String P1_5_80) {
        this.P1_5_80 = P1_5_80;
    }

    public void SetP1_5_81(String P1_5_81) {
        this.P1_5_81 = P1_5_81;
    }

    public void SetP1_5_82(String P1_5_82) {
        this.P1_5_82 = P1_5_82;
    }

    public void SetP1_5_83(String P1_5_83) {
        this.P1_5_83 = P1_5_83;
    }

    public void SetP1_5_84(String P1_5_84) {
        this.P1_5_84 = P1_5_84;
    }

    public void SetP1_5_85(String P1_5_85) {
        this.P1_5_85 = P1_5_85;
    }

    public void SetP1_5_86(String P1_5_86) {
        this.P1_5_86 = P1_5_86;
    }

    public void SetP1_5_87(String P1_5_87) {
        this.P1_5_87 = P1_5_87;
    }

    public void SetP1_5_88(String P1_5_88) {
        this.P1_5_88 = P1_5_88;
    }

    public void SetP1_5_89(String P1_5_89) {
        this.P1_5_89 = P1_5_89;
    }

    public void SetP1_5_90(String P1_5_90) {
        this.P1_5_90 = P1_5_90;
    }

    public void SetP1_5_91(String P1_5_91) {
        this.P1_5_91 = P1_5_91;
    }

    public void SetP1_5_92(String P1_5_92) {
        this.P1_5_92 = P1_5_92;
    }

    public void SetP1_5_93(String P1_5_93) {
        this.P1_5_93 = P1_5_93;
    }

    public void SetP1_5_94(String P1_5_94) {
        this.P1_5_94 = P1_5_94;
    }

    public void SetP1_5_95(String P1_5_95) {
        this.P1_5_95 = P1_5_95;
    }

    public void SetP1_5_96(String P1_5_96) {
        this.P1_5_96 = P1_5_96;
    }

    public void SetP1_5_97(String P1_5_97) {
        this.P1_5_97 = P1_5_97;
    }

    public void SetP1_5_98(String P1_5_98) {
        this.P1_5_98 = P1_5_98;
    }

    public void SetP1_5_99(String P1_5_99) {
        this.P1_5_99 = P1_5_99;
    }

    public void SetP1_5_100(String P1_5_100) {
        this.P1_5_100 = P1_5_100;
    }

    public void SetP1_5_101(String P1_5_101) {
        this.P1_5_101 = P1_5_101;
    }

    public void SetP1_5_102(String P1_5_102) {
        this.P1_5_102 = P1_5_102;
    }

    public void SetP1_5_103(String P1_5_103) {
        this.P1_5_103 = P1_5_103;
    }

    public void SetP1_5_104(String P1_5_104) {
        this.P1_5_104 = P1_5_104;
    }

    public void SetP1_5_105(String P1_5_105) {
        this.P1_5_105 = P1_5_105;
    }

    public void SetP1_5_106(String P1_5_106) {
        this.P1_5_106 = P1_5_106;
    }

    public void SetP1_5_107(String P1_5_107) {
        this.P1_5_107 = P1_5_107;
    }

    public void SetP1_5_108(String P1_5_108) {
        this.P1_5_108 = P1_5_108;
    }

    public void SetP1_5_109(String P1_5_109) {
        this.P1_5_109 = P1_5_109;
    }

    public void SetP1_5_110(String P1_5_110) {
        this.P1_5_110 = P1_5_110;
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
            GetC1_5_ID_TMP(),
            GetP1_5_1(),
            GetP1_5_2(),
            GetP1_5_3(),
            GetP1_5_4(),
            GetP1_5_5(),
            GetP1_5_6(),
            GetP1_5_7(),
            GetP1_5_8(),
            GetP1_5_9(),
            GetP1_5_10(),
            GetP1_5_11(),
            GetP1_5_12(),
            GetP1_5_13(),
            GetP1_5_14(),
            GetP1_5_15(),
            GetP1_5_16(),
            GetP1_5_17(),
            GetP1_5_18(),
            GetP1_5_19(),
            GetP1_5_20(),
            GetP1_5_21(),
            GetP1_5_22(),
            GetP1_5_23(),
            GetP1_5_24(),
            GetP1_5_25(),
            GetP1_5_26(),
            GetP1_5_27(),
            GetP1_5_28(),
            GetP1_5_29(),
            GetP1_5_30(),
            GetP1_5_31(),
            GetP1_5_32(),
            GetP1_5_33(),
            GetP1_5_34(),
            GetP1_5_35(),
            GetP1_5_36(),
            GetP1_5_37(),
            GetP1_5_38(),
            GetP1_5_39(),
            GetP1_5_40(),
            GetP1_5_41(),
            GetP1_5_42(),
            GetP1_5_43(),
            GetP1_5_44(),
            GetP1_5_45(),
            GetP1_5_46(),
            GetP1_5_47(),
            GetP1_5_48(),
            GetP1_5_49(),
            GetP1_5_50(),
            GetP1_5_51(),
            GetP1_5_52(),
            GetP1_5_53(),
            GetP1_5_54(),
            GetP1_5_55(),
            GetP1_5_56(),
            GetP1_5_57(),
            GetP1_5_58(),
            GetP1_5_59(),
            GetP1_5_60(),
            GetP1_5_61(),
            GetP1_5_62(),
            GetP1_5_63(),
            GetP1_5_64(),
            GetP1_5_65(),
            GetP1_5_66(),
            GetP1_5_67(),
            GetP1_5_68(),
            GetP1_5_69(),
            GetP1_5_70(),
            GetP1_5_71(),
            GetP1_5_72(),
            GetP1_5_73(),
            GetP1_5_74(),
            GetP1_5_75(),
            GetP1_5_76(),
            GetP1_5_77(),
            GetP1_5_78(),
            GetP1_5_79(),
            GetP1_5_80(),
            GetP1_5_81(),
            GetP1_5_82(),
            GetP1_5_83(),
            GetP1_5_84(),
            GetP1_5_85(),
            GetP1_5_86(),
            GetP1_5_87(),
            GetP1_5_88(),
            GetP1_5_89(),
            GetP1_5_90(),
            GetP1_5_91(),
            GetP1_5_92(),
            GetP1_5_93(),
            GetP1_5_94(),
            GetP1_5_95(),
            GetP1_5_96(),
            GetP1_5_97(),
            GetP1_5_98(),
            GetP1_5_99(),
            GetP1_5_100(),
            GetP1_5_101(),
            GetP1_5_102(),
            GetP1_5_103(),
            GetP1_5_104(),
            GetP1_5_105(),
            GetP1_5_106(),
            GetP1_5_107(),
            GetP1_5_108(),
            GetP1_5_109(),
            GetP1_5_110(),
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
