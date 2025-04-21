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
public class BeanTMP_PLE_MEDS1_3 extends Bean implements SQLData {

    private String SQLTypeName;
    private String ID_ENTIDAD_TMP;
    private String ENTIDAD;
    private String C1_3_ID_TMP;
    private String P1_3_1;
    private String P1_3_2;
    private String P1_3_3;
    private String P1_3_4;
    private String P1_3_5;
    private String P1_3_6;
    private String P1_3_7;
    private String P1_3_8;
    private String P1_3_9;
    private String P1_3_10;
    private String P1_3_11;
    private String P1_3_12;
    private String P1_3_13;
    private String P1_3_14;
    private String P1_3_15;
    private String P1_3_16;
    private String P1_3_17;
    private String P1_3_18;
    private String P1_3_19;
    private String P1_3_20;
    private String P1_3_21;
    private String P1_3_22;
    private String P1_3_23;
    private String P1_3_24;
    private String P1_3_25;
    private String P1_3_26;
    private String P1_3_27;
    private String P1_3_28;
    private String P1_3_29;
    private String P1_3_30;
    private String P1_3_31;
    private String P1_3_32;
    private String P1_3_33;
    private String P1_3_34;
    private String P1_3_35;
    private String P1_3_36;
    private String P1_3_37;
    private String P1_3_38;
    private String P1_3_39;
    private String P1_3_40;
    private String P1_3_41;
    private String P1_3_42;
    private String P1_3_43;
    private String P1_3_44;
    private String P1_3_45;
    private String P1_3_46;
    private String P1_3_47;
    private String P1_3_48;
    private String P1_3_49;
    private String P1_3_50;
    private String P1_3_51;
    private String P1_3_52;
    private String P1_3_53;
    private String P1_3_54;
    private String P1_3_55;
    private String P1_3_56;
    private String P1_3_57;
    private String P1_3_58;
    private String P1_3_59;
    private String P1_3_60;
    private String P1_3_61;
    private String P1_3_62;
    private String P1_3_63;
    private String P1_3_64;
    private String P1_3_65;
    private String P1_3_66;
    private String P1_3_67;
    private String P1_3_68;
    private String P1_3_69;
    private String P1_3_70;
    private String P1_3_71;
    private String P1_3_72;
    private String P1_3_73;
    private String P1_3_74;
    private String P1_3_75;
    private String P1_3_76;
    private String P1_3_77;
    private String P1_3_78;
    private String P1_3_79;
    private String P1_3_80;
    private String P1_3_81;
    private String P1_3_82;
    private String P1_3_83;
    private String P1_3_84;
    private String P1_3_85;
    private String P1_3_86;
    private String P1_3_87;
    private String P1_3_88;
    private String P1_3_89;
    private String P1_3_90;
    private String P1_3_91;
    private String P1_3_92;
    private String P1_3_93;
    private String P1_3_94;
    private String P1_3_95;
    private String P1_3_96;
    private String P1_3_97;
    private String P1_3_98;
    private String P1_3_99;
    private String P1_3_100;
    private String P1_3_101;
    private String P1_3_102;
    private String P1_3_103;
    private String P1_3_104;
    private String P1_3_105;
    private String P1_3_106;
    private String P1_3_107;
    private String P1_3_108;
    private String P1_3_109;
    private String P1_3_110;
    private String P1_3_111;
    private String P1_3_112;
    private String P1_3_113;
    private String P1_3_114;
    private String P1_3_115;
    private String P1_3_116;
    private String P1_3_117;
    private String P1_3_118;
    private String P1_3_119;
    private String LEGISLATURA_TMP;

    public String GetID_ENTIDAD_TMP() {
        return ID_ENTIDAD_TMP;
    }

    public String GetENTIDAD() {
        return ENTIDAD;
    }

    public String GetC1_3_ID_TMP() {
        return C1_3_ID_TMP;
    }

    public String GetP1_3_1() {
        return P1_3_1;
    }

    public String GetP1_3_2() {
        return P1_3_2;
    }

    public String GetP1_3_3() {
        return P1_3_3;
    }

    public String GetP1_3_4() {
        return P1_3_4;
    }

    public String GetP1_3_5() {
        return P1_3_5;
    }

    public String GetP1_3_6() {
        return P1_3_6;
    }

    public String GetP1_3_7() {
        return P1_3_7;
    }

    public String GetP1_3_8() {
        return P1_3_8;
    }

    public String GetP1_3_9() {
        return P1_3_9;
    }

    public String GetP1_3_10() {
        return P1_3_10;
    }

    public String GetP1_3_11() {
        return P1_3_11;
    }

    public String GetP1_3_12() {
        return P1_3_12;
    }

    public String GetP1_3_13() {
        return P1_3_13;
    }

    public String GetP1_3_14() {
        return P1_3_14;
    }

    public String GetP1_3_15() {
        return P1_3_15;
    }

    public String GetP1_3_16() {
        return P1_3_16;
    }

    public String GetP1_3_17() {
        return P1_3_17;
    }

    public String GetP1_3_18() {
        return P1_3_18;
    }

    public String GetP1_3_19() {
        return P1_3_19;
    }

    public String GetP1_3_20() {
        return P1_3_20;
    }

    public String GetP1_3_21() {
        return P1_3_21;
    }

    public String GetP1_3_22() {
        return P1_3_22;
    }

    public String GetP1_3_23() {
        return P1_3_23;
    }

    public String GetP1_3_24() {
        return P1_3_24;
    }

    public String GetP1_3_25() {
        return P1_3_25;
    }

    public String GetP1_3_26() {
        return P1_3_26;
    }

    public String GetP1_3_27() {
        return P1_3_27;
    }

    public String GetP1_3_28() {
        return P1_3_28;
    }

    public String GetP1_3_29() {
        return P1_3_29;
    }

    public String GetP1_3_30() {
        return P1_3_30;
    }

    public String GetP1_3_31() {
        return P1_3_31;
    }

    public String GetP1_3_32() {
        return P1_3_32;
    }

    public String GetP1_3_33() {
        return P1_3_33;
    }

    public String GetP1_3_34() {
        return P1_3_34;
    }

    public String GetP1_3_35() {
        return P1_3_35;
    }

    public String GetP1_3_36() {
        return P1_3_36;
    }

    public String GetP1_3_37() {
        return P1_3_37;
    }

    public String GetP1_3_38() {
        return P1_3_38;
    }

    public String GetP1_3_39() {
        return P1_3_39;
    }

    public String GetP1_3_40() {
        return P1_3_40;
    }

    public String GetP1_3_41() {
        return P1_3_41;
    }

    public String GetP1_3_42() {
        return P1_3_42;
    }

    public String GetP1_3_43() {
        return P1_3_43;
    }

    public String GetP1_3_44() {
        return P1_3_44;
    }

    public String GetP1_3_45() {
        return P1_3_45;
    }

    public String GetP1_3_46() {
        return P1_3_46;
    }

    public String GetP1_3_47() {
        return P1_3_47;
    }

    public String GetP1_3_48() {
        return P1_3_48;
    }

    public String GetP1_3_49() {
        return P1_3_49;
    }

    public String GetP1_3_50() {
        return P1_3_50;
    }

    public String GetP1_3_51() {
        return P1_3_51;
    }

    public String GetP1_3_52() {
        return P1_3_52;
    }

    public String GetP1_3_53() {
        return P1_3_53;
    }

    public String GetP1_3_54() {
        return P1_3_54;
    }

    public String GetP1_3_55() {
        return P1_3_55;
    }

    public String GetP1_3_56() {
        return P1_3_56;
    }

    public String GetP1_3_57() {
        return P1_3_57;
    }

    public String GetP1_3_58() {
        return P1_3_58;
    }

    public String GetP1_3_59() {
        return P1_3_59;
    }

    public String GetP1_3_60() {
        return P1_3_60;
    }

    public String GetP1_3_61() {
        return P1_3_61;
    }

    public String GetP1_3_62() {
        return P1_3_62;
    }

    public String GetP1_3_63() {
        return P1_3_63;
    }

    public String GetP1_3_64() {
        return P1_3_64;
    }

    public String GetP1_3_65() {
        return P1_3_65;
    }

    public String GetP1_3_66() {
        return P1_3_66;
    }

    public String GetP1_3_67() {
        return P1_3_67;
    }

    public String GetP1_3_68() {
        return P1_3_68;
    }

    public String GetP1_3_69() {
        return P1_3_69;
    }

    public String GetP1_3_70() {
        return P1_3_70;
    }

    public String GetP1_3_71() {
        return P1_3_71;
    }

    public String GetP1_3_72() {
        return P1_3_72;
    }

    public String GetP1_3_73() {
        return P1_3_73;
    }

    public String GetP1_3_74() {
        return P1_3_74;
    }

    public String GetP1_3_75() {
        return P1_3_75;
    }

    public String GetP1_3_76() {
        return P1_3_76;
    }

    public String GetP1_3_77() {
        return P1_3_77;
    }

    public String GetP1_3_78() {
        return P1_3_78;
    }

    public String GetP1_3_79() {
        return P1_3_79;
    }

    public String GetP1_3_80() {
        return P1_3_80;
    }

    public String GetP1_3_81() {
        return P1_3_81;
    }

    public String GetP1_3_82() {
        return P1_3_82;
    }

    public String GetP1_3_83() {
        return P1_3_83;
    }

    public String GetP1_3_84() {
        return P1_3_84;
    }

    public String GetP1_3_85() {
        return P1_3_85;
    }

    public String GetP1_3_86() {
        return P1_3_86;
    }

    public String GetP1_3_87() {
        return P1_3_87;
    }

    public String GetP1_3_88() {
        return P1_3_88;
    }

    public String GetP1_3_89() {
        return P1_3_89;
    }

    public String GetP1_3_90() {
        return P1_3_90;
    }

    public String GetP1_3_91() {
        return P1_3_91;
    }

    public String GetP1_3_92() {
        return P1_3_92;
    }

    public String GetP1_3_93() {
        return P1_3_93;
    }

    public String GetP1_3_94() {
        return P1_3_94;
    }

    public String GetP1_3_95() {
        return P1_3_95;
    }

    public String GetP1_3_96() {
        return P1_3_96;
    }

    public String GetP1_3_97() {
        return P1_3_97;
    }

    public String GetP1_3_98() {
        return P1_3_98;
    }

    public String GetP1_3_99() {
        return P1_3_99;
    }

    public String GetP1_3_100() {
        return P1_3_100;
    }

    public String GetP1_3_101() {
        return P1_3_101;
    }

    public String GetP1_3_102() {
        return P1_3_102;
    }

    public String GetP1_3_103() {
        return P1_3_103;
    }

    public String GetP1_3_104() {
        return P1_3_104;
    }

    public String GetP1_3_105() {
        return P1_3_105;
    }

    public String GetP1_3_106() {
        return P1_3_106;
    }

    public String GetP1_3_107() {
        return P1_3_107;
    }

    public String GetP1_3_108() {
        return P1_3_108;
    }

    public String GetP1_3_109() {
        return P1_3_109;
    }

    public String GetP1_3_110() {
        return P1_3_110;
    }

    public String GetP1_3_111() {
        return P1_3_111;
    }

    public String GetP1_3_112() {
        return P1_3_112;
    }

    public String GetP1_3_113() {
        return P1_3_113;
    }

    public String GetP1_3_114() {
        return P1_3_114;
    }

    public String GetP1_3_115() {
        return P1_3_115;
    }

    public String GetP1_3_116() {
        return P1_3_116;
    }

    public String GetP1_3_117() {
        return P1_3_117;
    }

    public String GetP1_3_118() {
        return P1_3_118;
    }

    public String GetP1_3_119() {
        return P1_3_119;
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

    public void SetC1_3_ID_TMP(String C1_3_ID_TMP) {
        this.C1_3_ID_TMP = C1_3_ID_TMP;
    }

    public void SetP1_3_1(String P1_3_1) {
        this.P1_3_1 = P1_3_1;
    }

    public void SetP1_3_2(String P1_3_2) {
        this.P1_3_2 = P1_3_2;
    }

    public void SetP1_3_3(String P1_3_3) {
        this.P1_3_3 = P1_3_3;
    }

    public void SetP1_3_4(String P1_3_4) {
        this.P1_3_4 = P1_3_4;
    }

    public void SetP1_3_5(String P1_3_5) {
        this.P1_3_5 = P1_3_5;
    }

    public void SetP1_3_6(String P1_3_6) {
        this.P1_3_6 = P1_3_6;
    }

    public void SetP1_3_7(String P1_3_7) {
        this.P1_3_7 = P1_3_7;
    }

    public void SetP1_3_8(String P1_3_8) {
        this.P1_3_8 = P1_3_8;
    }

    public void SetP1_3_9(String P1_3_9) {
        this.P1_3_9 = P1_3_9;
    }

    public void SetP1_3_10(String P1_3_10) {
        this.P1_3_10 = P1_3_10;
    }

    public void SetP1_3_11(String P1_3_11) {
        this.P1_3_11 = P1_3_11;
    }

    public void SetP1_3_12(String P1_3_12) {
        this.P1_3_12 = P1_3_12;
    }

    public void SetP1_3_13(String P1_3_13) {
        this.P1_3_13 = P1_3_13;
    }

    public void SetP1_3_14(String P1_3_14) {
        this.P1_3_14 = P1_3_14;
    }

    public void SetP1_3_15(String P1_3_15) {
        this.P1_3_15 = P1_3_15;
    }

    public void SetP1_3_16(String P1_3_16) {
        this.P1_3_16 = P1_3_16;
    }

    public void SetP1_3_17(String P1_3_17) {
        this.P1_3_17 = P1_3_17;
    }

    public void SetP1_3_18(String P1_3_18) {
        this.P1_3_18 = P1_3_18;
    }

    public void SetP1_3_19(String P1_3_19) {
        this.P1_3_19 = P1_3_19;
    }

    public void SetP1_3_20(String P1_3_20) {
        this.P1_3_20 = P1_3_20;
    }

    public void SetP1_3_21(String P1_3_21) {
        this.P1_3_21 = P1_3_21;
    }

    public void SetP1_3_22(String P1_3_22) {
        this.P1_3_22 = P1_3_22;
    }

    public void SetP1_3_23(String P1_3_23) {
        this.P1_3_23 = P1_3_23;
    }

    public void SetP1_3_24(String P1_3_24) {
        this.P1_3_24 = P1_3_24;
    }

    public void SetP1_3_25(String P1_3_25) {
        this.P1_3_25 = P1_3_25;
    }

    public void SetP1_3_26(String P1_3_26) {
        this.P1_3_26 = P1_3_26;
    }

    public void SetP1_3_27(String P1_3_27) {
        this.P1_3_27 = P1_3_27;
    }

    public void SetP1_3_28(String P1_3_28) {
        this.P1_3_28 = P1_3_28;
    }

    public void SetP1_3_29(String P1_3_29) {
        this.P1_3_29 = P1_3_29;
    }

    public void SetP1_3_30(String P1_3_30) {
        this.P1_3_30 = P1_3_30;
    }

    public void SetP1_3_31(String P1_3_31) {
        this.P1_3_31 = P1_3_31;
    }

    public void SetP1_3_32(String P1_3_32) {
        this.P1_3_32 = P1_3_32;
    }

    public void SetP1_3_33(String P1_3_33) {
        this.P1_3_33 = P1_3_33;
    }

    public void SetP1_3_34(String P1_3_34) {
        this.P1_3_34 = P1_3_34;
    }

    public void SetP1_3_35(String P1_3_35) {
        this.P1_3_35 = P1_3_35;
    }

    public void SetP1_3_36(String P1_3_36) {
        this.P1_3_36 = P1_3_36;
    }

    public void SetP1_3_37(String P1_3_37) {
        this.P1_3_37 = P1_3_37;
    }

    public void SetP1_3_38(String P1_3_38) {
        this.P1_3_38 = P1_3_38;
    }

    public void SetP1_3_39(String P1_3_39) {
        this.P1_3_39 = P1_3_39;
    }

    public void SetP1_3_40(String P1_3_40) {
        this.P1_3_40 = P1_3_40;
    }

    public void SetP1_3_41(String P1_3_41) {
        this.P1_3_41 = P1_3_41;
    }

    public void SetP1_3_42(String P1_3_42) {
        this.P1_3_42 = P1_3_42;
    }

    public void SetP1_3_43(String P1_3_43) {
        this.P1_3_43 = P1_3_43;
    }

    public void SetP1_3_44(String P1_3_44) {
        this.P1_3_44 = P1_3_44;
    }

    public void SetP1_3_45(String P1_3_45) {
        this.P1_3_45 = P1_3_45;
    }

    public void SetP1_3_46(String P1_3_46) {
        this.P1_3_46 = P1_3_46;
    }

    public void SetP1_3_47(String P1_3_47) {
        this.P1_3_47 = P1_3_47;
    }

    public void SetP1_3_48(String P1_3_48) {
        this.P1_3_48 = P1_3_48;
    }

    public void SetP1_3_49(String P1_3_49) {
        this.P1_3_49 = P1_3_49;
    }

    public void SetP1_3_50(String P1_3_50) {
        this.P1_3_50 = P1_3_50;
    }

    public void SetP1_3_51(String P1_3_51) {
        this.P1_3_51 = P1_3_51;
    }

    public void SetP1_3_52(String P1_3_52) {
        this.P1_3_52 = P1_3_52;
    }

    public void SetP1_3_53(String P1_3_53) {
        this.P1_3_53 = P1_3_53;
    }

    public void SetP1_3_54(String P1_3_54) {
        this.P1_3_54 = P1_3_54;
    }

    public void SetP1_3_55(String P1_3_55) {
        this.P1_3_55 = P1_3_55;
    }

    public void SetP1_3_56(String P1_3_56) {
        this.P1_3_56 = P1_3_56;
    }

    public void SetP1_3_57(String P1_3_57) {
        this.P1_3_57 = P1_3_57;
    }

    public void SetP1_3_58(String P1_3_58) {
        this.P1_3_58 = P1_3_58;
    }

    public void SetP1_3_59(String P1_3_59) {
        this.P1_3_59 = P1_3_59;
    }

    public void SetP1_3_60(String P1_3_60) {
        this.P1_3_60 = P1_3_60;
    }

    public void SetP1_3_61(String P1_3_61) {
        this.P1_3_61 = P1_3_61;
    }

    public void SetP1_3_62(String P1_3_62) {
        this.P1_3_62 = P1_3_62;
    }

    public void SetP1_3_63(String P1_3_63) {
        this.P1_3_63 = P1_3_63;
    }

    public void SetP1_3_64(String P1_3_64) {
        this.P1_3_64 = P1_3_64;
    }

    public void SetP1_3_65(String P1_3_65) {
        this.P1_3_65 = P1_3_65;
    }

    public void SetP1_3_66(String P1_3_66) {
        this.P1_3_66 = P1_3_66;
    }

    public void SetP1_3_67(String P1_3_67) {
        this.P1_3_67 = P1_3_67;
    }

    public void SetP1_3_68(String P1_3_68) {
        this.P1_3_68 = P1_3_68;
    }

    public void SetP1_3_69(String P1_3_69) {
        this.P1_3_69 = P1_3_69;
    }

    public void SetP1_3_70(String P1_3_70) {
        this.P1_3_70 = P1_3_70;
    }

    public void SetP1_3_71(String P1_3_71) {
        this.P1_3_71 = P1_3_71;
    }

    public void SetP1_3_72(String P1_3_72) {
        this.P1_3_72 = P1_3_72;
    }

    public void SetP1_3_73(String P1_3_73) {
        this.P1_3_73 = P1_3_73;
    }

    public void SetP1_3_74(String P1_3_74) {
        this.P1_3_74 = P1_3_74;
    }

    public void SetP1_3_75(String P1_3_75) {
        this.P1_3_75 = P1_3_75;
    }

    public void SetP1_3_76(String P1_3_76) {
        this.P1_3_76 = P1_3_76;
    }

    public void SetP1_3_77(String P1_3_77) {
        this.P1_3_77 = P1_3_77;
    }

    public void SetP1_3_78(String P1_3_78) {
        this.P1_3_78 = P1_3_78;
    }

    public void SetP1_3_79(String P1_3_79) {
        this.P1_3_79 = P1_3_79;
    }

    public void SetP1_3_80(String P1_3_80) {
        this.P1_3_80 = P1_3_80;
    }

    public void SetP1_3_81(String P1_3_81) {
        this.P1_3_81 = P1_3_81;
    }

    public void SetP1_3_82(String P1_3_82) {
        this.P1_3_82 = P1_3_82;
    }

    public void SetP1_3_83(String P1_3_83) {
        this.P1_3_83 = P1_3_83;
    }

    public void SetP1_3_84(String P1_3_84) {
        this.P1_3_84 = P1_3_84;
    }

    public void SetP1_3_85(String P1_3_85) {
        this.P1_3_85 = P1_3_85;
    }

    public void SetP1_3_86(String P1_3_86) {
        this.P1_3_86 = P1_3_86;
    }

    public void SetP1_3_87(String P1_3_87) {
        this.P1_3_87 = P1_3_87;
    }

    public void SetP1_3_88(String P1_3_88) {
        this.P1_3_88 = P1_3_88;
    }

    public void SetP1_3_89(String P1_3_89) {
        this.P1_3_89 = P1_3_89;
    }

    public void SetP1_3_90(String P1_3_90) {
        this.P1_3_90 = P1_3_90;
    }

    public void SetP1_3_91(String P1_3_91) {
        this.P1_3_91 = P1_3_91;
    }

    public void SetP1_3_92(String P1_3_92) {
        this.P1_3_92 = P1_3_92;
    }

    public void SetP1_3_93(String P1_3_93) {
        this.P1_3_93 = P1_3_93;
    }

    public void SetP1_3_94(String P1_3_94) {
        this.P1_3_94 = P1_3_94;
    }

    public void SetP1_3_95(String P1_3_95) {
        this.P1_3_95 = P1_3_95;
    }

    public void SetP1_3_96(String P1_3_96) {
        this.P1_3_96 = P1_3_96;
    }

    public void SetP1_3_97(String P1_3_97) {
        this.P1_3_97 = P1_3_97;
    }

    public void SetP1_3_98(String P1_3_98) {
        this.P1_3_98 = P1_3_98;
    }

    public void SetP1_3_99(String P1_3_99) {
        this.P1_3_99 = P1_3_99;
    }

    public void SetP1_3_100(String P1_3_100) {
        this.P1_3_100 = P1_3_100;
    }

    public void SetP1_3_101(String P1_3_101) {
        this.P1_3_101 = P1_3_101;
    }

    public void SetP1_3_102(String P1_3_102) {
        this.P1_3_102 = P1_3_102;
    }

    public void SetP1_3_103(String P1_3_103) {
        this.P1_3_103 = P1_3_103;
    }

    public void SetP1_3_104(String P1_3_104) {
        this.P1_3_104 = P1_3_104;
    }

    public void SetP1_3_105(String P1_3_105) {
        this.P1_3_105 = P1_3_105;
    }

    public void SetP1_3_106(String P1_3_106) {
        this.P1_3_106 = P1_3_106;
    }

    public void SetP1_3_107(String P1_3_107) {
        this.P1_3_107 = P1_3_107;
    }

    public void SetP1_3_108(String P1_3_108) {
        this.P1_3_108 = P1_3_108;
    }

    public void SetP1_3_109(String P1_3_109) {
        this.P1_3_109 = P1_3_109;
    }

    public void SetP1_3_110(String P1_3_110) {
        this.P1_3_110 = P1_3_110;
    }

    public void SetP1_3_111(String P1_3_111) {
        this.P1_3_111 = P1_3_111;
    }

    public void SetP1_3_112(String P1_3_112) {
        this.P1_3_112 = P1_3_112;
    }

    public void SetP1_3_113(String P1_3_113) {
        this.P1_3_113 = P1_3_113;
    }

    public void SetP1_3_114(String P1_3_114) {
        this.P1_3_114 = P1_3_114;
    }

    public void SetP1_3_115(String P1_3_115) {
        this.P1_3_115 = P1_3_115;
    }

    public void SetP1_3_116(String P1_3_116) {
        this.P1_3_116 = P1_3_116;
    }

    public void SetP1_3_117(String P1_3_117) {
        this.P1_3_117 = P1_3_117;
    }

    public void SetP1_3_118(String P1_3_118) {
        this.P1_3_118 = P1_3_118;
    }

    public void SetP1_3_119(String P1_3_119) {
        this.P1_3_119 = P1_3_119;
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
GetC1_3_ID_TMP(),
GetP1_3_1(),
GetP1_3_2(),
GetP1_3_3(),
GetP1_3_4(),
GetP1_3_5(),
GetP1_3_6(),
GetP1_3_7(),
GetP1_3_8(),
GetP1_3_9(),
GetP1_3_10(),
GetP1_3_11(),
GetP1_3_12(),
GetP1_3_13(),
GetP1_3_14(),
GetP1_3_15(),
GetP1_3_16(),
GetP1_3_17(),
GetP1_3_18(),
GetP1_3_19(),
GetP1_3_20(),
GetP1_3_21(),
GetP1_3_22(),
GetP1_3_23(),
GetP1_3_24(),
GetP1_3_25(),
GetP1_3_26(),
GetP1_3_27(),
GetP1_3_28(),
GetP1_3_29(),
GetP1_3_30(),
GetP1_3_31(),
GetP1_3_32(),
GetP1_3_33(),
GetP1_3_34(),
GetP1_3_35(),
GetP1_3_36(),
GetP1_3_37(),
GetP1_3_38(),
GetP1_3_39(),
GetP1_3_40(),
GetP1_3_41(),
GetP1_3_42(),
GetP1_3_43(),
GetP1_3_44(),
GetP1_3_45(),
GetP1_3_46(),
GetP1_3_47(),
GetP1_3_48(),
GetP1_3_49(),
GetP1_3_50(),
GetP1_3_51(),
GetP1_3_52(),
GetP1_3_53(),
GetP1_3_54(),
GetP1_3_55(),
GetP1_3_56(),
GetP1_3_57(),
GetP1_3_58(),
GetP1_3_59(),
GetP1_3_60(),
GetP1_3_61(),
GetP1_3_62(),
GetP1_3_63(),
GetP1_3_64(),
GetP1_3_65(),
GetP1_3_66(),
GetP1_3_67(),
GetP1_3_68(),
GetP1_3_69(),
GetP1_3_70(),
GetP1_3_71(),
GetP1_3_72(),
GetP1_3_73(),
GetP1_3_74(),
GetP1_3_75(),
GetP1_3_76(),
GetP1_3_77(),
GetP1_3_78(),
GetP1_3_79(),
GetP1_3_80(),
GetP1_3_81(),
GetP1_3_82(),
GetP1_3_83(),
GetP1_3_84(),
GetP1_3_85(),
GetP1_3_86(),
GetP1_3_87(),
GetP1_3_88(),
GetP1_3_89(),
GetP1_3_90(),
GetP1_3_91(),
GetP1_3_92(),
GetP1_3_93(),
GetP1_3_94(),
GetP1_3_95(),
GetP1_3_96(),
GetP1_3_97(),
GetP1_3_98(),
GetP1_3_99(),
GetP1_3_100(),
GetP1_3_101(),
GetP1_3_102(),
GetP1_3_103(),
GetP1_3_104(),
GetP1_3_105(),
GetP1_3_106(),
GetP1_3_107(),
GetP1_3_108(),
GetP1_3_109(),
GetP1_3_110(),
GetP1_3_111(),
GetP1_3_112(),
GetP1_3_113(),
GetP1_3_114(),
GetP1_3_115(),
GetP1_3_116(),
GetP1_3_117(),
GetP1_3_118(),
GetP1_3_119(),
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
