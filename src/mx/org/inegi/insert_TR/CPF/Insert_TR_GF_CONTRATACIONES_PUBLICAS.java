/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TR.CPF;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.org.inegi.LeeOracleTR_PSF.QueryTR_PSF;
import mx.org.inegi.bean.CPF.BeanTR_GF_CONTRATACIONES_PUBLICAS;
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
public class Insert_TR_GF_CONTRATACIONES_PUBLICAS {

    public void TR_GF_CONTRATACIONES_PUBLICAS() throws Exception {
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
            ArrayList<BeanTR_GF_CONTRATACIONES_PUBLICAS> ad = new ArrayList<>();
            QueryTR_PSF DBOData = new QueryTR_PSF();
            fila = DBOData.TR_GF_CONTRATACIONES_PUBLICAS();

            for (int i = 0; i < fila.size(); i++) {
                BeanTR_GF_CONTRATACIONES_PUBLICAS c = new BeanTR_GF_CONTRATACIONES_PUBLICAS();
                ArrayList<String> filaActual = fila.get(i);
                c.SetID_CONTRATO(filaActual.get(0));
                c.SetCODIGO_EXPEDIENTE(filaActual.get(1));
                c.SetNUMERO_PROCEDIMIENTO(filaActual.get(2));
                c.SetFECHA_PUBLICACION_CONVOCATORIA(filaActual.get(3));
                c.SetENTIDAD_FEDERATIVA(filaActual.get(4));
                c.SetID_INSTITUCION(filaActual.get(5));
                c.SetNOMBRE_INSTITUCION(filaActual.get(6));
                c.SetUNIDAD_COMPRADORA(filaActual.get(7));
                c.SetCARACTER_PROCEDIMIENTO(filaActual.get(8));
                c.SetMATERIA_PROCEDIMIENTO(filaActual.get(9));
                c.SetTIPO_PROCEDIMIENTO(filaActual.get(10));
                c.SetOTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE(filaActual.get(11));
                c.SetFORMA_PARTICIPACION_PROCEDIMIENTO(filaActual.get(12));
                c.SetFECHA_PUBLICACION_FALLO(filaActual.get(13));
                c.SetFECHA_FIRMA_CONTRATO(filaActual.get(14));
                c.SetTITULO_CONTRATO(filaActual.get(15));
                c.SetMONTO_CONTRATO(filaActual.get(16));
                c.SetMONEDA_CONTRATO(filaActual.get(17));
                c.SetRAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO(filaActual.get(18));
                c.SetESTATUS_CONTRATO(filaActual.get(19));
                c.SetFECHA_INICIO_CONTRATO(filaActual.get(20));
                c.SetFECHA_CONCLUSION_CONTRATO(filaActual.get(21));
                c.SetCOND_CONVENIO_MODIFICATORIO(filaActual.get(22));
                c.SetCOND_CONTRATO_MARCO(filaActual.get(23));
                c.SetCOND_COMPRA_CONSOLIDADA(filaActual.get(24));
                c.SetCOND_PRESENTACION_GARANTIA(filaActual.get(25));
                c.SetTIPO_GARANTIA_PRESENTADA_1(filaActual.get(26));
                c.SetTIPO_GARANTIA_PRESENTADA_2(filaActual.get(27));
                c.SetTIPO_GARANTIA_PRESENTADA_3(filaActual.get(28));
                c.SetCOMENTARIOS(filaActual.get(29));
                
     /*           System.out.println("Contrato ID: " + c.GetID_CONTRATO());
    System.out.println("Codigo Expediente: " + c.GetCODIGO_EXPEDIENTE());
    System.out.println("Numero Procedimiento: " + c.GetNUMERO_PROCEDIMIENTO());
    System.out.println("Fecha Publicacion Convocatoria: " + c.GetFECHA_PUBLICACION_CONVOCATORIA());
    System.out.println("Entidad Federativa: " + c.GetENTIDAD_FEDERATIVA());
    System.out.println("ID Institucion: " + c.GetID_INSTITUCION());
    System.out.println("Nombre Institucion: " + c.GetNOMBRE_INSTITUCION());
    System.out.println("Unidad Compradora: " + c.GetUNIDAD_COMPRADORA());
    System.out.println("Caracter Procedimiento: " + c.GetCARACTER_PROCEDIMIENTO());
    System.out.println("Materia Procedimiento: " + c.GetMATERIA_PROCEDIMIENTO());
    System.out.println("Tipo Procedimiento: " + c.GetTIPO_PROCEDIMIENTO());
    System.out.println("Otro Tipo Procedimiento: " + c.GetOTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE());
    System.out.println("Forma Participacion Procedimiento: " + c.GetFORMA_PARTICIPACION_PROCEDIMIENTO());
    System.out.println("Fecha Publicacion Fallo: " + c.GetFECHA_PUBLICACION_FALLO());
    System.out.println("Fecha Firma Contrato: " + c.GetFECHA_FIRMA_CONTRATO());
    System.out.println("Titulo Contrato: " + c.GetTITULO_CONTRATO());
    System.out.println("Monto Contrato: " + c.GetMONTO_CONTRATO());
    System.out.println("Moneda Contrato: " + c.GetMONEDA_CONTRATO());
    System.out.println("Razon Social Proveedor: " + c.GetRAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO());
    System.out.println("Estatus Contrato: " + c.GetESTATUS_CONTRATO());
    System.out.println("Fecha Inicio Contrato: " + c.GetFECHA_INICIO_CONTRATO());
    System.out.println("Fecha Conclusion Contrato: " + c.GetFECHA_CONCLUSION_CONTRATO());
    System.out.println("Cond Convenio Modificatorio: " + c.GetCOND_CONVENIO_MODIFICATORIO());
    System.out.println("Cond Contrato Marco: " + c.GetCOND_CONTRATO_MARCO());
    System.out.println("Cond Compra Consolidada: " + c.GetCOND_COMPRA_CONSOLIDADA());
    System.out.println("Cond Presentacion Garantia: " + c.GetCOND_PRESENTACION_GARANTIA());
    System.out.println("Tipo Garantia Presentada 1: " + c.GetTIPO_GARANTIA_PRESENTADA_1());
    System.out.println("Tipo Garantia Presentada 2: " + c.GetTIPO_GARANTIA_PRESENTADA_2());
    System.out.println("Tipo Garantia Presentada 3: " + c.GetTIPO_GARANTIA_PRESENTADA_3());
    System.out.println("Comentarios: " + c.GetCOMENTARIOS());*/
                
                ad.add(c);
                CFilas++;
            }
            
            if (CFilas > 0) {
                sd = StructDescriptor.createDescriptor("OBJ_TR_GF_CONTRATACIONES_PUBLICAS", con);
                structs = new STRUCT[ad.size()];
                System.out.println("entro 1");
                System.out.println("tamaño " + ad.size());
                for (int i = 0; i < ad.size(); i++) {
                    structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                }
                System.out.println("entro 2");
                descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_GF_CONTRATACIONES_PUBLICAS", con);
                System.out.println("entro 3");
                array_to_pass = new ARRAY(descriptor, con, structs);
                System.out.println("entro 4");
                st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM_TR.TR_GF_CONTRATACIONES_PUBLICAS(?))}");
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
