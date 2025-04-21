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
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_6;
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


public class Tmp_ple_meds1_6 {
    
     public void Tmp_ple_meds1_6(String Entidad, String Envio, String Legislatura) throws Exception {

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

            ArrayList<BeanTMP_PLE_MEDS1_6> ad = new ArrayList<>();
            Array_xlsm xlsm = new Array_xlsm();
            Pestaña = "iniciativas_urgente_obvia";
            fila = xlsm.LeerExcel(4, 0, 73, Pestaña);
            String Entid = "";
            int numero = Integer.parseInt(Entidad);

            if (numero >= 1 && numero <= 9) {
                Entid = "0" + Entidad;
            } else {
                Entid = Entidad;
            }

            for (int i = 0; i < fila.size(); i++) {
                BeanTMP_PLE_MEDS1_6 c = new BeanTMP_PLE_MEDS1_6();
                ArrayList<String> filaActual = fila.get(i);
                for (int j = 0; j < 74; j++) {
                    c.SetID_ENTIDAD_TMP(Entidad);
                    c.SetENTIDAD(Entid);
                    c.SetC1_6_ID_TMP(Envio);
                    c.SetP1_6_1(filaActual.get(0).trim().replace(" ", ""));
                    c.SetP1_6_2(filaActual.get(1));
                    c.SetP1_6_3(filaActual.get(2));
                    c.SetP1_6_4(filaActual.get(3));
                    c.SetP1_6_5(filaActual.get(4));
                    c.SetP1_6_6(filaActual.get(5));
                    c.SetP1_6_7(filaActual.get(6));
                    c.SetP1_6_8(filaActual.get(7));
                    c.SetP1_6_9(filaActual.get(8));
                    c.SetP1_6_10(filaActual.get(9));
                    c.SetP1_6_11(filaActual.get(10));
                    c.SetP1_6_12(filaActual.get(11));
                    c.SetP1_6_13(filaActual.get(12));
                    c.SetP1_6_14(filaActual.get(13));
                    c.SetP1_6_15(filaActual.get(14));
                    c.SetP1_6_16(filaActual.get(15));
                    c.SetP1_6_17(filaActual.get(16));
                    c.SetP1_6_18(filaActual.get(17));
                    c.SetP1_6_19(filaActual.get(18));
                    c.SetP1_6_20(filaActual.get(19));
                    c.SetP1_6_21(filaActual.get(20));
                    c.SetP1_6_22(filaActual.get(21));
                    c.SetP1_6_23(filaActual.get(22));
                    c.SetP1_6_24(filaActual.get(23));
                    c.SetP1_6_25(filaActual.get(24));
                    c.SetP1_6_26(filaActual.get(25));
                    c.SetP1_6_27(filaActual.get(26));
                    c.SetP1_6_28(filaActual.get(27));
                    c.SetP1_6_29(filaActual.get(28));
                    c.SetP1_6_30(filaActual.get(29));
                    c.SetP1_6_31(filaActual.get(30));
                    c.SetP1_6_32(filaActual.get(31));
                    c.SetP1_6_33(filaActual.get(32));
                    c.SetP1_6_34(filaActual.get(33));
                    c.SetP1_6_35(filaActual.get(34));
                    c.SetP1_6_36(filaActual.get(35));
                    c.SetP1_6_37(filaActual.get(36));
                    c.SetP1_6_38(filaActual.get(37));
                    c.SetP1_6_39(filaActual.get(38));
                    c.SetP1_6_40(filaActual.get(39));
                    c.SetP1_6_41(filaActual.get(40));
                    c.SetP1_6_42(filaActual.get(41));
                    c.SetP1_6_43(filaActual.get(42));
                    c.SetP1_6_44(filaActual.get(43));
                    c.SetP1_6_45(filaActual.get(44));
                    c.SetP1_6_46(filaActual.get(45));
                    c.SetP1_6_47(filaActual.get(46));
                    c.SetP1_6_48(filaActual.get(47));
                    c.SetP1_6_49(filaActual.get(48));
                    c.SetP1_6_50(filaActual.get(49));
                    c.SetP1_6_51(filaActual.get(50));
                    c.SetP1_6_52(filaActual.get(51));
                    c.SetP1_6_53(filaActual.get(52));
                    c.SetP1_6_54(filaActual.get(53));
                    c.SetP1_6_55(filaActual.get(54));
                    c.SetP1_6_56(filaActual.get(55));
                    c.SetP1_6_57(filaActual.get(56));
                    c.SetP1_6_58(filaActual.get(57));
                    c.SetP1_6_59(filaActual.get(58));
                    c.SetP1_6_60(filaActual.get(59));
                    c.SetP1_6_61(filaActual.get(60));
                    c.SetP1_6_62(filaActual.get(61));
                    c.SetP1_6_63(filaActual.get(62));
                    c.SetP1_6_64(filaActual.get(63));
                    c.SetP1_6_65(filaActual.get(64));
                    c.SetP1_6_66(filaActual.get(65));
                    c.SetP1_6_67(filaActual.get(66));
                    c.SetP1_6_68(filaActual.get(67));
                    c.SetP1_6_69(filaActual.get(68));
                    c.SetP1_6_70(filaActual.get(69));
                    c.SetP1_6_71(filaActual.get(70));
                    c.SetP1_6_72(filaActual.get(71));
                    c.SetP1_6_73(filaActual.get(72));
                    c.SetP1_6_74(filaActual.get(73));
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
            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_6", con);
            structs = new STRUCT[ad.size()];
            System.out.println("entro 1");
            System.out.println("tamaño " + ad.size());
            for (int i = 0; i < ad.size(); i++) {
                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
            }
            System.out.println("entro 2");
            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_6", con);
            System.out.println("entro 3");
            array_to_pass = new ARRAY(descriptor, con, structs);
            System.out.println("entro 4");
            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_6(?))}");
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
              JOptionPane.showMessageDialog(null, "Pestaña iniciativas_urgente_obvia sin registros");
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
