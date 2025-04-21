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
import mx.org.inegi.bean.PLE.BeanTMP_PLE_MEDS1_2;
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
public class Tmp_ple_meds1_2 {

    public void Tmp_ple_meds1_2(String Entidad, String Envio, String Legislatura) throws Exception {

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
            
            ArrayList<BeanTMP_PLE_MEDS1_2> ad = new ArrayList<>();
            Array_xlsm xlsm = new Array_xlsm();
            Pestaña = "comisiones_legislativas";
            fila = xlsm.LeerExcel(2, 1, 19, Pestaña);
            String Entid = "";
             int numero = Integer.parseInt(Entidad);
             
            if (numero >=1 && numero <=9) {
                Entid = "0" + Entidad;
            } else {
                Entid = Entidad;
            }
            
            for (int i = 0; i < fila.size(); i++) {
                BeanTMP_PLE_MEDS1_2 c = new BeanTMP_PLE_MEDS1_2();
                ArrayList<String> filaActual = fila.get(i);
                for (int j = 0; j < 20; j++) {
                    c.SetID_ENTIDAD_TMP(Entidad);
                    c.SetENTIDAD(Entid);
                    c.SetC1_2_ID_TMP(Envio);
                    c.SetP1_2_1(filaActual.get(0).trim().replace(" ", ""));
                    c.SetP1_2_2(filaActual.get(1));
                    c.SetP1_2_3(filaActual.get(2));
                    c.SetP1_2_4(filaActual.get(3));
                    c.SetP1_2_5(filaActual.get(4));
                    c.SetP1_2_6(filaActual.get(5));
                    c.SetP1_2_7(filaActual.get(6));
                    c.SetP1_2_8(filaActual.get(7));
                    c.SetP1_2_9(filaActual.get(8));
                    c.SetP1_2_10(filaActual.get(9));
                    c.SetP1_2_11(filaActual.get(10));
                    c.SetP1_2_12(filaActual.get(11));
                    c.SetP1_2_13(filaActual.get(12));
                    c.SetP1_2_14(filaActual.get(13));
                    c.SetP1_2_15(filaActual.get(14));
                    c.SetP1_2_16(filaActual.get(15));
                    c.SetP1_2_17(filaActual.get(16));
                    c.SetP1_2_18(filaActual.get(17));
                    c.SetP1_2_19(filaActual.get(18));
                    c.SetLEGISLATURA_TMP(Legislatura);
                }
                if (filaActual.get(0).equals("") || filaActual.get(0).equals("-2")){
                    break;  
                    }
                else{
                    ad.add(c);
                    CFilas++;
                }
            }
            
            for (BeanTMP_PLE_MEDS1_2 objeto : ad) {
        System.out.println(objeto.toString()); // Llama al método toString() personalizado para imprimir los detalles del objeto
    }
            
        
    if (CFilas>0)
    {
           sd = StructDescriptor.createDescriptor("OBJ_TMP_PLE_MEDS1_2", con);
            structs = new STRUCT[ad.size()];
            System.out.println("entro 1");
            System.out.println("tamaño " + ad.size());
            for (int i = 0; i < ad.size(); i++) {
                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
            }
            System.out.println("entro 2");
            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_PLE_MEDS1_2", con);
            System.out.println("entro 3");
            array_to_pass = new ARRAY(descriptor, con, structs);
            System.out.println("entro 4");
            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM.TMP_PLE_MEDS1_2(?))}");
            System.out.println("entro 5");
            st.registerOutParameter(1, OracleTypes.INTEGER);
            System.out.println("entro 6");
            st.setArray(2, array_to_pass);
            System.out.println("entro 7");
            st.execute();
            System.out.println("entro 8");
    }else
    {
         JOptionPane.showMessageDialog(null, "Pestaña comisiones_legislativas sin registros");
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
