/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.insert.PSF;

import Convertir_UTF8.Conver_Utf8;
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
import mx.org.inegi.bean.PSF_TR.BeanTR_GF_PROGRAMAS_SOCIALES;
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
public class TR_GF_PROGRAMAS_SOCIALES {

    public void TR_GF_PROGRAMAS_SOCIALES(String Ruta) throws Exception {

        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;
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

                    ArrayList<BeanTR_GF_PROGRAMAS_SOCIALES> ad = new ArrayList<>();
                    int numeroColumnas = 0;
                    CSVRecord firstRecord = csvParser.iterator().next();
                    numeroColumnas = firstRecord.size();
                    System.out.println("numero de columnas: " + numeroColumnas);

                    if (numeroColumnas >= 46) { // Se espera que el archivo tenga al menos 45 columnas

                        for (CSVRecord record : csvParser) {
                            if (record.get(0).isEmpty()) {
                                break; // Ignorar registros vacíos
                            }

                            BeanTR_GF_PROGRAMAS_SOCIALES c = new BeanTR_GF_PROGRAMAS_SOCIALES();
                            c.SetID_PROGRAMA_SOCIAL(record.get(0));
                            c.SetNOMBRE_PROGRAMA_SOCIAL(record.get(1));
                            c.SetID_INSTITUCION_ENCARGADA_1(record.get(2));
                            c.SetNOMBRE_INSTITUCION_ENCARGADA_1(record.get(3));
                            c.SetID_INSTITUCION_ENCARGADA_2(record.get(4));
                            c.SetNOMBRE_INSTITUCION_ENCARGADA_2(record.get(5));
                            c.SetID_INSTITUCION_ENCARGADA_3(record.get(6));
                            c.SetNOMBRE_INSTITUCION_ENCARGADA_3(record.get(7));
                            c.SetID_INSTITUCION_ENCARGADA_4(record.get(8));
                            c.SetNOMBRE_INSTITUCION_ENCARGADA_4(record.get(9));
                            c.SetID_INSTITUCION_ENCARGADA_5(record.get(10));
                            c.SetNOMBRE_INSTITUCION_ENCARGADA_5(record.get(11));
                            c.SetPRESUPUESTO_EJERCIDO(record.get(12));
                            c.SetCOND_REGLAS_LINEAMIENTOS_OPERACION(record.get(13));
                            c.SetURL_REGLAS_LINEAMIENTOS_OPERACION(record.get(14));
                            c.SetCOND_PADRON_PERSONAS_BENEFICIARIAS(record.get(15));
                            c.SetDERECHO_SOCIAL_ATENDIDO_1(record.get(16));
                            c.SetDERECHO_SOCIAL_ATENDIDO_2(record.get(17));
                            c.SetDERECHO_SOCIAL_ATENDIDO_3(record.get(18));
                            c.SetDERECHO_SOCIAL_ATENDIDO_4(record.get(19));
                            c.SetDERECHO_SOCIAL_ATENDIDO_5(record.get(20));
                            c.SetAMBITO_ATENCION(record.get(21));
                            c.SetTIPO_APOYO_ENTREGADO_1(record.get(22));
                            c.SetTIPO_APOYO_ENTREGADO_2(record.get(23));
                            c.SetTIPO_APOYO_ENTREGADO_3(record.get(24));
                            c.SetTIPO_APOYO_ENTREGADO_4(record.get(25));
                            c.SetTIPO_APOYO_ENTREGADO_5(record.get(26));
                            c.SetOTRO_TIPO_APOYO_ENTREGADO_ESPECIFIQUE(record.get(27));
                            c.SetPOBLACION_ATENDIDA_PERSONAS(record.get(28));
                            c.SetPOBLACION_ATENDIDA_INSTITUCIONES(record.get(29));
                            c.SetPOBLACION_ATENDIDA_PERSONAS_MORALES_(record.get(30));
                            c.SetPOBLACION_ATENDIDA_TERRITORIAL(record.get(31));
                            c.SetPOBLACION__ATENDIDA_OTRO_TIPO(record.get(32));
                            c.SetPOBLACION_ATENDIDA_NO_IDENTIFICADA(record.get(33));
                            c.SetPOBLACION_ATENDIDA_TERRITORIAL_ESPECIFIQUE(record.get(34));
                            c.SetPOBLACION_ATENDIDA_OTRO_TIPO_ESPECIFIQUE(record.get(35));
                            c.SetGRUPO_VULNERABLE_BENEFICIADO_1(record.get(36));
                            c.SetGRUPO_VULNERABLE_BENEFICIADO_2(record.get(37));
                            c.SetGRUPO_VULNERABLE_BENEFICIADO_3(record.get(38));
                            c.SetGRUPO_VULNERABLE_BENEFICIADO_4(record.get(39));
                            c.SetGRUPO_VULNERABLE_BENEFICIADO_5(record.get(40));
                            c.SetGRUPO_VULNERABLE_BENEFICIADO_6(record.get(41));
                            c.SetGRUPO_VULNERABLE_BENEFICIADO_7(record.get(42));
                            c.SetGRUPO_VULNERABLE_BENEFICIADO_8(record.get(43));
                            c.SetOTRO_GRUPO_VULNERABLE_BENEFICIADO_ESPECIFIQUE(record.get(44));
                            c.SetCOMENTARIOS(record.get(45));
                            ad.add(c);
                            CFilas++;
                        }

                        if (CFilas > 0) {
                            con = OracleDAOFactoryPSF.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TMP_GF_PROGRAMAS_SOCIALES", con);
                            structs = new STRUCT[ad.size()];

                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }

                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_GF_PROGRAMAS_SOCIALES", con);
                            array_to_pass = new ARRAY(descriptor, con, structs);

                            st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM_TMP.TMP_GF_PROGRAMAS_SOCIALES(?))}");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            st.setArray(2, array_to_pass);
                            st.execute();
                        } else {
                            JOptionPane.showMessageDialog(null, "Pestaña programas_sociales sin registros");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El número de columnas no es el esperado.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        array_to_pass = null;
                        structs = null;
                        descriptor = null;
                        if (con != null) {
                            con.close();
                            con = null;
                        }
                    } catch (SQLException ex) {
                        throw new SQLException("[actualiza]: " + ex.getLocalizedMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no está en formato UTF-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
