/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.insert.CPF;

import Convertir_UTF8.TEPJF.Conver_Utf8;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mx.org.inegi.bean.CPF.BeanTR_GF_CONTRATACIONES_PUBLICAS_2023;
import mx.org.inegi.conexion.PSF.OracleDAOFactoryPSF;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author ANTONIO.CORIA
 */
public class TR_GF_CONTRATACIONES_PUBLICAS {

    public void TR_GF_CONTRATACIONES_PUBLICAS(String Ruta, String Año) throws Exception {

        ArrayList<String[]> Array;
        Array = new ArrayList();
        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int TotalRegistros = 0;
        Conver_Utf8 conUTF8 = new Conver_Utf8();
        String NuevaRuta = "";

        conUTF8.Convertir_utf8_EBaseDatos(Ruta);
        NuevaRuta = Ruta.replace(".csv", "UTF8.csv");

        try ( BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(NuevaRuta))) {
            byte[] bytes = new byte[3];
            int bytesRead = inputStream.read(bytes);

            if (bytesRead >= 3 && bytes[0] == (byte) 0xEF && bytes[1] == (byte) 0xBB && bytes[2] == (byte) 0xBF) {
                System.out.println("El archivo parece estar en UTF-8.");
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(NuevaRuta), StandardCharsets.UTF_8));  CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                    int numeroColumnas = 0;
                    CSVRecord firstRecord = csvParser.iterator().next();
                    numeroColumnas = firstRecord.size();
                    System.out.println("numero de columnas" + numeroColumnas);
                    if (numeroColumnas == 30) {
                        System.out.println("+hellooou+" + numeroColumnas);

                        ArrayList<BeanTR_GF_CONTRATACIONES_PUBLICAS_2023> ad = new ArrayList<>();
                        for (CSVRecord record : csvParser) {
                            //System.out.println("llenado de csv");
                            TotalRegistros++;
                            BeanTR_GF_CONTRATACIONES_PUBLICAS_2023 c = new BeanTR_GF_CONTRATACIONES_PUBLICAS_2023();
                            c.SetID_CONTRATO(record.get(0));
                            c.SetCODIGO_EXPEDIENTE(record.get(1));
                            c.SetNUMERO_PROCEDIMIENTO(record.get(2));
                            c.SetFECHA_PUBLICACION_CONVOCATORIA(record.get(3));
                            c.SetENTIDAD_FEDERATIVA(record.get(4));
                            c.SetID_INSTITUCION(record.get(5));
                            c.SetNOMBRE_INSTITUCION(record.get(6));
                            c.SetUNIDAD_COMPRADORA(record.get(7));
                            c.SetCARACTER_PROCEDIMIENTO(record.get(8));
                            c.SetMATERIA_PROCEDIMIENTO(record.get(9));
                            c.SetTIPO_PROCEDIMIENTO(record.get(10));
                            c.SetOTRO_TIPO_PROCEDIMIENTO_ESPECIFIQUE(record.get(11));
                            c.SetFORMA_PARTICIPACION_PROCEDIMIENTO(record.get(12));
                            c.SetFECHA_PUBLICACION_FALLO(record.get(13));
                            c.SetFECHA_FIRMA_CONTRATO(record.get(14));
                            c.SetTITULO_CONTRATO(record.get(15));
                            c.SetMONTO_CONTRATO(record.get(16));
                            c.SetMONEDA_CONTRATO(record.get(17));
                            c.SetRAZON_SOCIAL_PROVEEDOR_CONTRATISTA_CONTRATO(record.get(18));
                            c.SetESTATUS_CONTRATO(record.get(19));
                            c.SetFECHA_INICIO_CONTRATO(record.get(20));
                            c.SetFECHA_CONCLUSION_CONTRATO(record.get(21));
                            c.SetCOND_CONVENIO_MODIFICATORIO(record.get(22));
                            c.SetCOND_CONTRATO_MARCO(record.get(23));
                            c.SetCOND_COMPRA_CONSOLIDADA(record.get(24));
                            c.SetCOND_PRESENTACION_GARANTIA(record.get(25));
                            c.SetTIPO_GARANTIA_PRESENTADA_1(record.get(26));
                            c.SetTIPO_GARANTIA_PRESENTADA_2(record.get(27));
                            c.SetTIPO_GARANTIA_PRESENTADA_3(record.get(28));
                            c.SetCOMENTARIOS(record.get(29));
                            ad.add(c);
                        }
                        System.out.println("entro 1");
                        if (TotalRegistros > 0) {
                            con = OracleDAOFactoryPSF.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_GF_CONTRATACIONES_PUBLICAS_2024", con);
                            structs = new STRUCT[ad.size()];
                            System.out.println("entro 2");
                            System.out.println("tamaño " + ad.size());

                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }

                            System.out.println("entro 3");
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_GF_CONTRATACIONES_PUBLICAS_2024", con);
                            System.out.println("entro 4");
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            System.out.println("entro 5");
                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM_2024.TMP_GF_CONTRATACIONES_PUBLICAS_2024(?))}");
                            System.out.println("entro 6");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            System.out.println("entro 7");
                            st.setArray(2, array_to_pass);
                            System.out.println("entro 8");
                            st.execute();
                            System.out.println("entro 9");
                            //JOptionPane.showMessageDialog(null, "Favor de revisar TABLA -*TR_PSF_OBSERVACIONES*- Total registros en .CSV:" + TotalRegistros);

                        } else {
                            JOptionPane.showMessageDialog(null, "Archivo .CSV sin Registros");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El total de numero de columnas en el archivo .CSV no coincide con la bd Oracle");
                    }
                } catch (IOException e) {
                    System.out.println("++" + e);
                } finally {
                    try {
                        array_to_pass = null;
                        structs = null;
                        descriptor = null;
                        if (con != null) {
                            System.out.println("cierraaa");
                            //JOptionPane.showMessageDialog(null, "CONEXION CERRADA!!");
                            con.close();
                            con = null;
                        }
                    } catch (SQLException ex) {
                        throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no esta en formato UTF-8");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
