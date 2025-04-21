/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.insert_TMP.PLE;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_1;
import mx.org.inegi.conexion.PLE.OracleDAOFactory;
import mx.org.inegi.xlsm.DatosGenerales_xlsm;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

/**
 *
 * @author ANTONIO.CORIA
 */
public class Tmp_ple_meds1_1 {

    public void In_Tmp_ple_meds1_1(String Entidad, String Envio, String Legislatura, String Estatus) throws Exception {

        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        con = OracleDAOFactory.creaConexion();
        try {
            ArrayList<BeanTMP_PLE_MEDS1_1> ad = new ArrayList<>();
            BeanTMP_PLE_MEDS1_1 c = new BeanTMP_PLE_MEDS1_1();
            DatosGenerales_xlsm xlsm = new DatosGenerales_xlsm();
            String Entid = "";
            int numero = Integer.parseInt(Entidad);
            if (numero >=1 && numero <=9) {
                Entid = "0" + Entidad;
            } else {
                Entid = Entidad;
            }
            c.SetID_ENTIDAD_TMP(Entidad);
            c.SetENTIDAD_TMP(Entid);
            c.SetP1_1_1(Legislatura);
            c.SetP1_1_2(xlsm.LeerExcel(13, 10));
            c.SetP1_1_3(xlsm.LeerExcel(18, 5));
            c.SetP1_1_4(xlsm.LeerExcel(18, 11));
            c.SetP1_1_5(xlsm.LeerExcel(18, 24));
            c.SetP1_1_6(xlsm.LeerExcel(18, 29));
            c.SetP1_1_7(xlsm.LeerExcel(22, 12));
            c.SetP1_1_8(xlsm.LeerExcel(22, 21));
            c.SetP1_1_9(xlsm.LeerExcel(22, 28));
            c.SetLEGISLATURA_TMP(Legislatura);
            c.SetC1_1_ID_TMP(Envio);
            c.SetESTATUS(Estatus);
            ad.add(c);

            //imprimir
            for (BeanTMP_PLE_MEDS1_1 elemento : ad) {
                System.out.println("ID_ENTIDAD_TMP: " + elemento.GetID_ENTIDAD_TMP());
                System.out.println("P1_1_1: " + elemento.GetP1_1_1());
                System.out.println("P1_1_2: " + elemento.GetP1_1_2());
                System.out.println("P1_1_3: " + elemento.GetP1_1_3());
                System.out.println("P1_1_4: " + elemento.GetP1_1_4());
                System.out.println("P1_1_5: " + elemento.GetP1_1_5());
                System.out.println("P1_1_6: " + elemento.GetP1_1_6());
                System.out.println("P1_1_7: " + elemento.GetP1_1_7());
                System.out.println("P1_1_8: " + elemento.GetP1_1_8());
                System.out.println("P1_1_9: " + elemento.GetP1_1_9());
                System.out.println("---------------------------------------");
            }

            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_1", con);
            structs = new STRUCT[ad.size()];
            System.out.println("entro 1");
            System.out.println("tamaño " + ad.size());
            for (int i = 0; i < ad.size(); i++) {
                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
            }
            System.out.println("entro 2");
            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_1", con);
            System.out.println("entro 3");
            array_to_pass = new ARRAY(descriptor, con, structs);
            System.out.println("entro 4");
            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_1(?))}");
            System.out.println("entro 5");
            st.registerOutParameter(1, OracleTypes.INTEGER);
            System.out.println("entro 6");
            st.setArray(2, array_to_pass);
            System.out.println("entro 7");
            st.execute();
            System.out.println("entro 8");
            // JOptionPane.showMessageDialog(null, "Registros insertados en tabla TMP_PLE_MEDS1_1, Favor de revisar pantalla Erores de insert");
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
