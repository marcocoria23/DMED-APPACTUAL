/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.insert_TMP.PLE;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_3;
import mx.org.inegi.conexion.PLE.OracleDAOFactory;
import mx.org.inegi.xlsm.Array_xlsm;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Tmp_ple_meds1_3 {

    public void Tmp_ple_meds1_3(String Entidad, String Envio, String Legislatura) throws Exception {

        ARRAY array_to_pass;
        ArrayList<ArrayList<String>> fila;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        String Pestaña;
        con = OracleDAOFactory.creaConexion();
        int CFilas=0;

        try {

            ArrayList<BeanTMP_PLE_MEDS1_3> ad = new ArrayList<>();
            Array_xlsm xlsm = new Array_xlsm();
            Pestaña = "personas_legisladoras";
            fila = xlsm.LeerExcel(3, 1, 119, Pestaña);
            String Entid = "";
            int numero = Integer.parseInt(Entidad);

            if (numero >= 1 && numero <= 9) {
                Entid = "0" + Entidad;
            } else {
                Entid = Entidad;
            }

            for (int i = 0; i < fila.size(); i++) {
                BeanTMP_PLE_MEDS1_3 c = new BeanTMP_PLE_MEDS1_3();
                ArrayList<String> filaActual = fila.get(i);
                for (int j = 0; j < 120; j++) {
                    c.SetID_ENTIDAD_TMP(Entidad);
                    c.SetENTIDAD(Entid);
                    c.SetC1_3_ID_TMP(Envio);
                    c.SetP1_3_1(filaActual.get(0).trim().replace(" ", ""));
                    c.SetP1_3_2(filaActual.get(1));
                    c.SetP1_3_3(filaActual.get(2));
                    c.SetP1_3_4(filaActual.get(3));
                    c.SetP1_3_5(filaActual.get(4));
                    c.SetP1_3_6(filaActual.get(5));
                    c.SetP1_3_7(filaActual.get(6));
                    c.SetP1_3_8(filaActual.get(7));
                    c.SetP1_3_9(filaActual.get(8));
                    c.SetP1_3_10(filaActual.get(9));
                    c.SetP1_3_11(filaActual.get(10));
                    c.SetP1_3_12(filaActual.get(11));
                    c.SetP1_3_13(filaActual.get(12));
                    c.SetP1_3_14(filaActual.get(13));
                    c.SetP1_3_15(filaActual.get(14));
                    c.SetP1_3_16(filaActual.get(15));
                    c.SetP1_3_17(filaActual.get(16));
                    c.SetP1_3_18(filaActual.get(17));
                    c.SetP1_3_19(filaActual.get(18));
                    c.SetP1_3_20(filaActual.get(19));
                    c.SetP1_3_21(filaActual.get(20));
                    c.SetP1_3_22(filaActual.get(21));
                    c.SetP1_3_23(filaActual.get(22));
                    c.SetP1_3_24(filaActual.get(23));
                    c.SetP1_3_25(filaActual.get(24));
                    c.SetP1_3_26(filaActual.get(25));
                    c.SetP1_3_27(filaActual.get(26));
                    c.SetP1_3_28(filaActual.get(27));
                    c.SetP1_3_29(filaActual.get(28));
                    c.SetP1_3_30(filaActual.get(29));
                    c.SetP1_3_31(filaActual.get(30));
                    c.SetP1_3_32(filaActual.get(31));
                    c.SetP1_3_33(filaActual.get(32));
                    c.SetP1_3_34(filaActual.get(33));
                    c.SetP1_3_35(filaActual.get(34));
                    c.SetP1_3_36(filaActual.get(35));
                    c.SetP1_3_37(filaActual.get(36));
                    c.SetP1_3_38(filaActual.get(37));
                    c.SetP1_3_39(filaActual.get(38));
                    c.SetP1_3_40(filaActual.get(39));
                    c.SetP1_3_41(filaActual.get(40));
                    c.SetP1_3_42(filaActual.get(41));
                    c.SetP1_3_43(filaActual.get(42));
                    c.SetP1_3_44(filaActual.get(43));
                    c.SetP1_3_45(filaActual.get(44));
                    c.SetP1_3_46(filaActual.get(45));
                    c.SetP1_3_47(filaActual.get(46));
                    c.SetP1_3_48(filaActual.get(47));
                    c.SetP1_3_49(filaActual.get(48));
                    c.SetP1_3_50(filaActual.get(49));
                    c.SetP1_3_51(filaActual.get(50));
                    c.SetP1_3_52(filaActual.get(51));
                    c.SetP1_3_53(filaActual.get(52));
                    c.SetP1_3_54(filaActual.get(53));
                    c.SetP1_3_55(filaActual.get(54));
                    c.SetP1_3_56(filaActual.get(55));
                    c.SetP1_3_57(filaActual.get(56));
                    c.SetP1_3_58(filaActual.get(57));
                    c.SetP1_3_59(filaActual.get(58));
                    c.SetP1_3_60(filaActual.get(59));
                    c.SetP1_3_61(filaActual.get(60));
                    c.SetP1_3_62(filaActual.get(61));
                    c.SetP1_3_63(filaActual.get(62));
                    c.SetP1_3_64(filaActual.get(63));
                    c.SetP1_3_65(filaActual.get(64));
                    c.SetP1_3_66(filaActual.get(65));
                    c.SetP1_3_67(filaActual.get(66));
                    c.SetP1_3_68(filaActual.get(67));
                    c.SetP1_3_69(filaActual.get(68));
                    c.SetP1_3_70(filaActual.get(69));
                    c.SetP1_3_71(filaActual.get(70));
                    c.SetP1_3_72(filaActual.get(71));
                    c.SetP1_3_73(filaActual.get(72));
                    c.SetP1_3_74(filaActual.get(73));
                    c.SetP1_3_75(filaActual.get(74));
                    c.SetP1_3_76(filaActual.get(75));
                    c.SetP1_3_77(filaActual.get(76));
                    c.SetP1_3_78(filaActual.get(77));
                    c.SetP1_3_79(filaActual.get(78));
                    c.SetP1_3_80(filaActual.get(79));
                    c.SetP1_3_81(filaActual.get(80));
                    c.SetP1_3_82(filaActual.get(81));
                    c.SetP1_3_83(filaActual.get(82));
                    c.SetP1_3_84(filaActual.get(83));
                    c.SetP1_3_85(filaActual.get(84));
                    c.SetP1_3_86(filaActual.get(85));
                    c.SetP1_3_87(filaActual.get(86));
                    c.SetP1_3_88(filaActual.get(87));
                    c.SetP1_3_89(filaActual.get(88));
                    c.SetP1_3_90(filaActual.get(89));
                    c.SetP1_3_91(filaActual.get(90));
                    c.SetP1_3_92(filaActual.get(91));
                    c.SetP1_3_93(filaActual.get(92));
                    c.SetP1_3_94(filaActual.get(93));
                    c.SetP1_3_95(filaActual.get(94));
                    c.SetP1_3_96(filaActual.get(95));
                    c.SetP1_3_97(filaActual.get(96));
                    c.SetP1_3_98(filaActual.get(97));
                    c.SetP1_3_99(filaActual.get(98));
                    c.SetP1_3_100(filaActual.get(99));
                    c.SetP1_3_101(filaActual.get(100));
                    c.SetP1_3_102(filaActual.get(101));
                    c.SetP1_3_103(filaActual.get(102));
                    c.SetP1_3_104(filaActual.get(103));
                    c.SetP1_3_105(filaActual.get(104));
                    c.SetP1_3_106(filaActual.get(105));
                    c.SetP1_3_107(filaActual.get(106));
                    c.SetP1_3_108(filaActual.get(107));
                    c.SetP1_3_109(filaActual.get(108));
                    c.SetP1_3_110(filaActual.get(109));
                    c.SetP1_3_111(filaActual.get(110));
                    c.SetP1_3_112(filaActual.get(111));
                    c.SetP1_3_113(filaActual.get(112));
                    c.SetP1_3_114(filaActual.get(113));
                    c.SetP1_3_115(filaActual.get(114));
                    c.SetP1_3_116(filaActual.get(115));
                    c.SetP1_3_117(filaActual.get(116));
                    c.SetP1_3_118(filaActual.get(117));
                    c.SetP1_3_119(filaActual.get(118));
                   c.SetLEGISLATURA_TMP(Legislatura);
                }
                if (filaActual.get(0).equals("")) {
                    break;
                } else {
                    ad.add(c);
                    CFilas++;
                }
            }
       
          if (CFilas>0)
          {
            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_3", con);
            structs = new STRUCT[ad.size()];
            System.out.println("entro 1");
            System.out.println("tamaño " + ad.size());
            for (int i = 0; i < ad.size(); i++) {
                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
            }
            System.out.println("entro 2");
            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_3", con);
            System.out.println("entro 3");
            array_to_pass = new ARRAY(descriptor, con, structs);
            System.out.println("entro 4");
            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_3(?))}");
            System.out.println("entro 5");
            st.registerOutParameter(1, OracleTypes.INTEGER);
            System.out.println("entro 6");
            st.setArray(2, array_to_pass);
            System.out.println("entro 7");
            st.execute();
            System.out.println("entro 8");
          }
          else
          {
              JOptionPane.showMessageDialog(null, "Pestaña personas_legisladoras sin registros");
          }
        } finally {
            try {
                array_to_pass = null;
                structs = null;
                descriptor = null;
                if (con != null) {
                    System.out.println("cierraaa");
                    // JOptionPane.showMessageDialog(null, "CONEXION CERRADA!!-TMP_PLE_MEDS1_1");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
        }
    }

}
