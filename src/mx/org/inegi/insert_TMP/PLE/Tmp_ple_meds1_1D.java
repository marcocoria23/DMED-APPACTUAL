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
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_1D;
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
public class Tmp_ple_meds1_1D {

    public void Tmp_ple_meds1_1D(String Entidad, String Envio, String Legislatura) throws Exception {

        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        con = OracleDAOFactory.creaConexion();

        try {
            ArrayList<BeanTMP_PLE_MEDS1_1D> ad = new ArrayList<>();
            DatosGenerales_xlsm xlsm = new DatosGenerales_xlsm();
            int ContadorFil = 2;

            for (int i = 0; i < 5; i++) {
                BeanTMP_PLE_MEDS1_1D c = new BeanTMP_PLE_MEDS1_1D();
                String Entid = "";
                 int numero = Integer.parseInt(Entidad);
            if (numero >=1 && numero <=9) {
                Entid = "0" + Entidad;
            } else {
                Entid = Entidad;
            }
                c.SetID_ENTIDAD_TMP(Entidad);
                c.SetENTIDAD(Entid);
                c.SetC1_1D(String.valueOf(i + 1));
                c.SetP1_1D_1(xlsm.LeerExcel(44 + ContadorFil, 28));
                c.SetLEGISLATURA_TMP(Legislatura);
                c.SetC1_1D_ID_TMP(Envio);
                ad.add(c);
                ContadorFil = ContadorFil + 2;
            }

            for (BeanTMP_PLE_MEDS1_1D elemento : ad) {
                System.out.println("ID_ENTIDAD_TMP: " + elemento.GetID_ENTIDAD_TMP());
                System.out.println("ENTIDAD: " + elemento.GetENTIDAD());
                System.out.println("C1_1D: " + elemento.GetC1_1D());
                System.out.println("P1_1D_1: " + elemento.GetP1_1D_1());
                System.out.println("LEGISLATURA_TMP: " + elemento.GetLEGISLATURA_TMP());
                System.out.println("C1_1D_ID_TMP: " + elemento.GetC1_1D_ID_TMP());
                System.out.println("---------------------------------------------");
            }

            sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_1D", con);
            structs = new STRUCT[ad.size()];
            System.out.println("entro 1");
            System.out.println("tamaño " + ad.size());
            for (int i = 0; i < ad.size(); i++) {
                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
            }
            System.out.println("entro 2");
            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_1D", con);
            System.out.println("entro 3");
            array_to_pass = new ARRAY(descriptor, con, structs);
            System.out.println("entro 4");
            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_1D(?))}");
            System.out.println("entro 5");
            st.registerOutParameter(1, OracleTypes.INTEGER);
            System.out.println("entro 6");
            st.setArray(2, array_to_pass);
            System.out.println("entro 7");
            st.execute();
            System.out.println("entro 8");
            //JOptionPane.showMessageDialog(null, "Registros insertados en tabla TMP_PLE_MEDS1_1D, Favor de revisar pantalla Erores de insert");
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
