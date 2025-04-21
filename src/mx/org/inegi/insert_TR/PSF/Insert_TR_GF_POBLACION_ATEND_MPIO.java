/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TR.PSF;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.org.inegi.LeeOracleTR_PSF.QueryTR_PSF;
import mx.org.inegi.bean.PSF_TR.BeanTR_GF_POBLACION_ATEND_MPIO;
import mx.org.inegi.conexion.PSF.OracleDAOFactoryPSF;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class Insert_TR_GF_POBLACION_ATEND_MPIO {

    public void TR_GF_POBLACION_ATEND_MPIO() throws Exception {

        ARRAY array_to_pass;
        ArrayList<ArrayList<String>> fila;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        con = OracleDAOFactoryPSF.creaConexion();
        int CFilas = 0;

        try {
            ArrayList<BeanTR_GF_POBLACION_ATEND_MPIO> ad = new ArrayList<>();
            QueryTR_PSF DBOData = new QueryTR_PSF();
            fila = DBOData.TR_GF_POBLACION_ATEND_MPIO();

            for (int i = 0; i < fila.size(); i++) {
                BeanTR_GF_POBLACION_ATEND_MPIO c = new BeanTR_GF_POBLACION_ATEND_MPIO();
                ArrayList<String> filaActual = fila.get(i);
                c.SetID_PROGRAMA_SOCIAL(filaActual.get(0));
                c.SetID_MUNICIPIO(filaActual.get(1));
                c.SetNOMBRE_MUNICIPIO(filaActual.get(2));
                c.SetTOTAL_POBLACION(filaActual.get(3));
                c.SetCOMENTARIOS(filaActual.get(4));
                ad.add(c);
                CFilas++;
            }

            if (CFilas > 0) {
                sd = StructDescriptor.createDescriptor("OBJ_TR_GF_POBLACION_ATEND_MPIO", con);
                structs = new STRUCT[ad.size()];
                System.out.println("entro 1");
                System.out.println("tamaño " + ad.size());
                for (int i = 0; i < ad.size(); i++) {
                    structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                }

                System.out.println("entro 2");
                descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_GF_POBLACION_ATEND_MPIO", con);
                System.out.println("entro 3");
                array_to_pass = new ARRAY(descriptor, con, structs);
                System.out.println("entro 4");
                st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM_TR.TR_GF_POBLACION_ATEND_MPIO(?))}");
                System.out.println("entro 5");
                st.registerOutParameter(1, OracleTypes.INTEGER);
                System.out.println("entro 6");
                st.setArray(2, array_to_pass);
                System.out.println("entro 7");
                st.execute();
                System.out.println("entro 8");
            } else {
                // JOptionPane.showMessageDialog(null, "TABLA TMP_SENAP_ACTOSINVESTIGACION sin registros");
            }
        } finally {
            try {
                array_to_pass = null;
                structs = null;
                descriptor = null;
                if (con != null) {
                    System.out.println("cierraaa");
                    // JOptionPane.showMessageDialog(null, "CONEXION CERRADA!!-TR_PLE_MEDS1_1");
                    con.close();
                    con = null;
                }
            } catch (SQLException ex) {
                throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
            }
        }
    }
}
