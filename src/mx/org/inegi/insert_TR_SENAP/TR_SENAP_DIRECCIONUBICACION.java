/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.inegi.insert_TR_SENAP;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.inegi.LeeOracleTR_SENAP.QueryTRSENAP;
import mx.org.inegi.bean.SENAP_TR.BeanTR_SENAP_DIRECCIONUBICACION;
import mx.org.inegi.conexion.SENAP.ConORACLEFactory;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

/**
 *
 * @author ANTONIO.CORIA
 */
public class TR_SENAP_DIRECCIONUBICACION {

    public void TR_SENAP_DIRECCIONUBICACION(String Entidad, String Periodo) throws Exception {

        ARRAY array_to_pass;
        ArrayList<ArrayList<String>> fila;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        con = ConORACLEFactory.creaConexion();
        int CFilas = 0;

        try {

            ArrayList<BeanTR_SENAP_DIRECCIONUBICACION> ad = new ArrayList<>();
            QueryTRSENAP DBOData = new QueryTRSENAP();
            fila = DBOData.TMP_SENAP_DIRECCIONUBICACION(Entidad, Periodo);
             System.out.println("entroyeeees");
            for (int i = 0; i < fila.size(); i++) {
                BeanTR_SENAP_DIRECCIONUBICACION c = new BeanTR_SENAP_DIRECCIONUBICACION();
                ArrayList<String> filaActual = fila.get(i);
                    c.SetENTIDADID(filaActual.get(0));
                    c.SetUBICACIONID(filaActual.get(1));
                    c.SetCATTIPOVIALIDADID(filaActual.get(2));
                    c.SetCALLEVIALIDAD(filaActual.get(3));
                    c.SetCATCOLONIAID(filaActual.get(4));
                    c.SetNUMEROEXTERIOR(filaActual.get(5));
                    c.SetNUMEROINTERIOR(filaActual.get(6));
                    c.SetCODIGOPOSTAL(filaActual.get(7));
                    c.SetLOCALIDAD(filaActual.get(8));
                    c.SetCATDEMARCACIONID(filaActual.get(9));
                    c.SetCATENTFEDID(filaActual.get(10));
                    c.SetLATITUD(filaActual.get(11));
                    c.SetLONGITUD(filaActual.get(12));
                    c.SetCATSUBPROREFID(filaActual.get(13));
                    c.SetBORRADO(filaActual.get(14));
                    c.SetFECHAALTA(filaActual.get(15));
                    c.SetUSUARIOALTA(filaActual.get(16));
                    c.SetCOLONIA(filaActual.get(17));
                    c.SetUBICACION(filaActual.get(18));
                    c.SetCATFISCALIAID(filaActual.get(19));
                    c.SetFECHACORTE(filaActual.get(20));
                    c.SetFECHAACTUALIZACION(filaActual.get(21));
                    c.SetPERIODO(filaActual.get(22));
                ad.add(c);
                CFilas++;
            }
              System.out.println("entroyeeees1");
            if (CFilas > 0) {
                sd = StructDescriptor.createDescriptor("OBJ_TR_SENAP_DIRECCIONUBICACION", con);
                structs = new STRUCT[ad.size()];
                System.out.println("entro 1");
                System.out.println("tamaño " + ad.size());
                for (int i = 0; i < ad.size(); i++) {
                    structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                }
                System.out.println("entro 2");
                descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_SENAP_DIRECCIONUBICACION", con);
                System.out.println("entro 3");
                array_to_pass = new ARRAY(descriptor, con, structs);
                System.out.println("entro 4");
                st = con.prepareCall("{? = call(PKG_INTEGRADOR_SENAP_BAK_TR.TR_SENAP_DIRECCIONUBICACION(?))}");
                System.out.println("entro 5");
                st.registerOutParameter(1, OracleTypes.INTEGER);
                System.out.println("entro 6");
                st.setArray(2, array_to_pass);
                System.out.println("entro 7");
                st.execute();
                System.out.println("entro 8");
            } else {
                //JOptionPane.showMessageDialog(null, "TABLA TMP_SENAP_DIRECCIONUBICACION sin registros");
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
