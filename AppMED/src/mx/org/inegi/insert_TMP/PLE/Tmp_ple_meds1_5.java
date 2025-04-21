/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.insert_TMP.PLE;

/**
 *
 * @author ANTONIO.CORIA
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_5;
import mx.org.inegi.conexion.PLE.OracleDAOFactory;
import mx.org.inegi.xlsm.Array_xlsm;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

public class Tmp_ple_meds1_5 {
    
    public void Tmp_ple_meds1_5(String Entidad, String Envio, String Legislatura) throws Exception {

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

            ArrayList<BeanTMP_PLE_MEDS1_5> ad = new ArrayList<>();
            Array_xlsm xlsm = new Array_xlsm();
            Pestaña = "iniciativas";
            fila = xlsm.LeerExcel(4, 0, 109, Pestaña);
            String Entid = "";
            int numero = Integer.parseInt(Entidad);

            if (numero >= 1 && numero <= 9) {
                Entid = "0" + Entidad;
            } else {
                Entid = Entidad;
            }

            for (int i = 0; i < fila.size(); i++) {
                BeanTMP_PLE_MEDS1_5 c = new BeanTMP_PLE_MEDS1_5();
                ArrayList<String> filaActual = fila.get(i);
                for (int j = 0; j < 110; j++) {
                    c.SetID_ENTIDAD_TMP(Entidad);
                    c.SetENTIDAD(Entid);
                    c.SetC1_5_ID_TMP(Envio);
                    c.SetP1_5_1(filaActual.get(0).trim().replace(" ", ""));
                    c.SetP1_5_2(filaActual.get(1));
                    c.SetP1_5_3(filaActual.get(2));
                    c.SetP1_5_4(filaActual.get(3));
                    c.SetP1_5_5(filaActual.get(4));
                    c.SetP1_5_6(filaActual.get(5));
                    c.SetP1_5_7(filaActual.get(6));
                    c.SetP1_5_8(filaActual.get(7));
                    c.SetP1_5_9(filaActual.get(8));
                    c.SetP1_5_10(filaActual.get(9));
                    c.SetP1_5_11(filaActual.get(10));
                    c.SetP1_5_12(filaActual.get(11));
                    c.SetP1_5_13(filaActual.get(12));
                    c.SetP1_5_14(filaActual.get(13));
                    c.SetP1_5_15(filaActual.get(14));
                    c.SetP1_5_16(filaActual.get(15));
                    c.SetP1_5_17(filaActual.get(16));
                    c.SetP1_5_18(filaActual.get(17));
                    c.SetP1_5_19(filaActual.get(18));
                    c.SetP1_5_20(filaActual.get(19));
                    c.SetP1_5_21(filaActual.get(20));
                    c.SetP1_5_22(filaActual.get(21));
                    c.SetP1_5_23(filaActual.get(22));
                    c.SetP1_5_24(filaActual.get(23));
                    c.SetP1_5_25(filaActual.get(24));
                    c.SetP1_5_26(filaActual.get(25));
                    c.SetP1_5_27(filaActual.get(26));
                    c.SetP1_5_28(filaActual.get(27));
                    c.SetP1_5_29(filaActual.get(28));
                    c.SetP1_5_30(filaActual.get(29));
                    c.SetP1_5_31(filaActual.get(30));
                    c.SetP1_5_32(filaActual.get(31));
                    c.SetP1_5_33(filaActual.get(32));
                    c.SetP1_5_34(filaActual.get(33));
                    c.SetP1_5_35(filaActual.get(34));
                    c.SetP1_5_36(filaActual.get(35));
                    c.SetP1_5_37(filaActual.get(36));
                    c.SetP1_5_38(filaActual.get(37));
                    c.SetP1_5_39(filaActual.get(38));
                    c.SetP1_5_40(filaActual.get(39));
                    c.SetP1_5_41(filaActual.get(40));
                    c.SetP1_5_42(filaActual.get(41));
                    c.SetP1_5_43(filaActual.get(42));
                    c.SetP1_5_44(filaActual.get(43));
                    c.SetP1_5_45(filaActual.get(44));
                    c.SetP1_5_46(filaActual.get(45));
                    c.SetP1_5_47(filaActual.get(46));
                    c.SetP1_5_48(filaActual.get(47));
                    c.SetP1_5_49(filaActual.get(48));
                    c.SetP1_5_50(filaActual.get(49));
                    c.SetP1_5_51(filaActual.get(50));
                    c.SetP1_5_52(filaActual.get(51));
                    c.SetP1_5_53(filaActual.get(52));
                    c.SetP1_5_54(filaActual.get(53));
                    c.SetP1_5_55(filaActual.get(54));
                    c.SetP1_5_56(filaActual.get(55));
                    c.SetP1_5_57(filaActual.get(56));
                    c.SetP1_5_58(filaActual.get(57));
                    c.SetP1_5_59(filaActual.get(58));
                    c.SetP1_5_60(filaActual.get(59));
                    c.SetP1_5_61(filaActual.get(60));
                    c.SetP1_5_62(filaActual.get(61));
                    c.SetP1_5_63(filaActual.get(62));
                    c.SetP1_5_64(filaActual.get(63));
                    c.SetP1_5_65(filaActual.get(64));
                    c.SetP1_5_66(filaActual.get(65));
                    c.SetP1_5_67(filaActual.get(66));
                    c.SetP1_5_68(filaActual.get(67));
                    c.SetP1_5_69(filaActual.get(68));
                    c.SetP1_5_70(filaActual.get(69));
                    c.SetP1_5_71(filaActual.get(70));
                    c.SetP1_5_72(filaActual.get(71));
                    c.SetP1_5_73(filaActual.get(72));
                    c.SetP1_5_74(filaActual.get(73));
                    c.SetP1_5_75(filaActual.get(74));
                    c.SetP1_5_76(filaActual.get(75));
                    c.SetP1_5_77(filaActual.get(76));
                    c.SetP1_5_78(filaActual.get(77));
                    c.SetP1_5_79(filaActual.get(78));
                    c.SetP1_5_80(filaActual.get(79));
                    c.SetP1_5_81(filaActual.get(80));
                    c.SetP1_5_82(filaActual.get(81));
                    c.SetP1_5_83(filaActual.get(82));
                    c.SetP1_5_84(filaActual.get(83));
                    c.SetP1_5_85(filaActual.get(84));
                    c.SetP1_5_86(filaActual.get(85));
                    c.SetP1_5_87(filaActual.get(86));
                    c.SetP1_5_88(filaActual.get(87));
                    c.SetP1_5_89(filaActual.get(88));
                    c.SetP1_5_90(filaActual.get(89));
                    c.SetP1_5_91(filaActual.get(90));
                    c.SetP1_5_92(filaActual.get(91));
                    c.SetP1_5_93(filaActual.get(92));
                    c.SetP1_5_94(filaActual.get(93));
                    c.SetP1_5_95(filaActual.get(94));
                    c.SetP1_5_96(filaActual.get(95));
                    c.SetP1_5_97(filaActual.get(96));
                    c.SetP1_5_98(filaActual.get(97));
                    c.SetP1_5_99(filaActual.get(98));
                    c.SetP1_5_100(filaActual.get(99));
                    c.SetP1_5_101(filaActual.get(100));
                    c.SetP1_5_102(filaActual.get(101));
                    c.SetP1_5_103(filaActual.get(102));
                    c.SetP1_5_104(filaActual.get(103));
                    c.SetP1_5_105(filaActual.get(104));
                    c.SetP1_5_106(filaActual.get(105));
                    c.SetP1_5_107(filaActual.get(106));
                    c.SetP1_5_108(filaActual.get(107));
                    c.SetP1_5_109(filaActual.get(108));
                    c.SetP1_5_110(filaActual.get(109));
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
            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_5", con);
            structs = new STRUCT[ad.size()];
            System.out.println("entro 1");
            System.out.println("tamaño " + ad.size());
            for (int i = 0; i < ad.size(); i++) {
                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
            }
            System.out.println("entro 2");
            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_5", con);
            System.out.println("entro 3");
            array_to_pass = new ARRAY(descriptor, con, structs);
            System.out.println("entro 4");
            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_5(?))}");
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
              JOptionPane.showMessageDialog(null, "Pestaña iniciativas sin registros");
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
