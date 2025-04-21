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
import mx.org.inegi.bean.PSF_TR.BeanTR_GF_PROGRAMAS_SOCIALES;
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
public class Insert_TR_GF_PROGRAMAS_SOCIALES {

    public void TR_GF_PROGRAMAS_SOCIALES() throws Exception {
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
            ArrayList<BeanTR_GF_PROGRAMAS_SOCIALES> ad = new ArrayList<>();
            QueryTR_PSF DBOData = new QueryTR_PSF();
            fila = DBOData.TR_GF_PROGRAMAS_SOCIALES();

            for (int i = 0; i < fila.size(); i++) {
                BeanTR_GF_PROGRAMAS_SOCIALES c = new BeanTR_GF_PROGRAMAS_SOCIALES();
                ArrayList<String> filaActual = fila.get(i);
                c.SetID_PROGRAMA_SOCIAL(filaActual.get(0));
                c.SetNOMBRE_PROGRAMA_SOCIAL(filaActual.get(1));
                c.SetID_INSTITUCION_ENCARGADA_1(filaActual.get(2));
                c.SetNOMBRE_INSTITUCION_ENCARGADA_1(filaActual.get(3));
                c.SetID_INSTITUCION_ENCARGADA_2(filaActual.get(4));
                c.SetNOMBRE_INSTITUCION_ENCARGADA_2(filaActual.get(5));
                c.SetID_INSTITUCION_ENCARGADA_3(filaActual.get(6));
                c.SetNOMBRE_INSTITUCION_ENCARGADA_3(filaActual.get(7));
                c.SetID_INSTITUCION_ENCARGADA_4(filaActual.get(8));
                c.SetNOMBRE_INSTITUCION_ENCARGADA_4(filaActual.get(9));
                c.SetID_INSTITUCION_ENCARGADA_5(filaActual.get(10));
                c.SetNOMBRE_INSTITUCION_ENCARGADA_5(filaActual.get(11));
                c.SetPRESUPUESTO_EJERCIDO(filaActual.get(12));
                c.SetCOND_REGLAS_LINEAMIENTOS_OPERACION(filaActual.get(13));
                c.SetURL_REGLAS_LINEAMIENTOS_OPERACION(filaActual.get(14));
                c.SetCOND_PADRON_PERSONAS_BENEFICIARIAS(filaActual.get(15));
                c.SetDERECHO_SOCIAL_ATENDIDO_1(filaActual.get(16));
                c.SetDERECHO_SOCIAL_ATENDIDO_2(filaActual.get(17));
                c.SetDERECHO_SOCIAL_ATENDIDO_3(filaActual.get(18));
                c.SetDERECHO_SOCIAL_ATENDIDO_4(filaActual.get(19));
                c.SetDERECHO_SOCIAL_ATENDIDO_5(filaActual.get(20));
                c.SetAMBITO_ATENCION(filaActual.get(21));
                c.SetTIPO_APOYO_ENTREGADO_1(filaActual.get(22));
                c.SetTIPO_APOYO_ENTREGADO_2(filaActual.get(23));
                c.SetTIPO_APOYO_ENTREGADO_3(filaActual.get(24));
                c.SetTIPO_APOYO_ENTREGADO_4(filaActual.get(25));
                c.SetTIPO_APOYO_ENTREGADO_5(filaActual.get(26));
                c.SetOTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE(filaActual.get(27));
                c.SetPOBLACION_ATENDIDA_PERSONAS(filaActual.get(28));
                c.SetPOBLACION_ATENDIDA_INSTITUCIONES(filaActual.get(29));
                c.SetPOBLACION_ATENDIDA_PERSONAS_MORALES_(filaActual.get(30));
                c.SetPOBLACION_ATENDIDA_TERRITORIAL(filaActual.get(31));
                c.SetPOBLACION__ATENDIDA_OTRO_TIPO(filaActual.get(32));
                c.SetPOBLACION_ATENDIDA_NO_IDENTIFICADA(filaActual.get(33));
                c.SetPOBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE(filaActual.get(34));
                c.SetPOBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE(filaActual.get(35));
                c.SetGRUPO_VULNERABLE_BENEFICIADO_1(filaActual.get(36));
                c.SetGRUPO_VULNERABLE_BENEFICIADO_2(filaActual.get(37));
                c.SetGRUPO_VULNERABLE_BENEFICIADO_3(filaActual.get(38));
                c.SetGRUPO_VULNERABLE_BENEFICIADO_4(filaActual.get(39));
                c.SetGRUPO_VULNERABLE_BENEFICIADO_5(filaActual.get(40));
                c.SetGRUPO_VULNERABLE_BENEFICIADO_6(filaActual.get(41));
                c.SetGRUPO_VULNERABLE_BENEFICIADO_7(filaActual.get(42));
                c.SetGRUPO_VULNERABLE_BENEFICIADO_8(filaActual.get(43));
                c.SetOTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE(filaActual.get(44));
                c.SetCOMENTARIOS(filaActual.get(45));
                ad.add(c);
                CFilas++;
            }

            if (CFilas > 0) {
                sd = StructDescriptor.createDescriptor("OBJ_TR_GF_PROGRAMAS_SOCIALES", con);
                structs = new STRUCT[ad.size()];
                System.out.println("entro 1");
                System.out.println("tamaño " + ad.size());
                for (int i = 0; i < ad.size(); i++) {
                    structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                }
                System.out.println("entro 2");
                descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_GF_PROGRAMAS_SOCIALES", con);
                System.out.println("entro 3");
                array_to_pass = new ARRAY(descriptor, con, structs);
                System.out.println("entro 4");
                st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM_TR.TR_GF_PROGRAMAS_SOCIALES(?))}");
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
