/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.org.insert.PSF;

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
import mx.org.inegi.bean.PSF.BeanTR_GF_POBLACION_ATEND_MPIO_2023;
import mx.org.inegi.conexion.PSF.OracleDAOFactoryPSF;
import mx.org.inegi.xlsm.Array_xlsmPSF;
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
public class TR_GF_POBLACION_ATEND_MPIO {
    
   public void TR_GF_POBLACION_ATEND_MPIO(String Ruta,String Año) throws Exception {

    ARRAY array_to_pass;
    CallableStatement st;
    Connection con = null;
    STRUCT[] structs;
    StructDescriptor sd;
    ArrayDescriptor descriptor;
    int CFilas = 0;
     Conver_Utf8 conUTF8 = new Conver_Utf8();
        String NuevaRuta="";
    
         conUTF8.Convertir_utf8_EBaseDatos(Ruta);
         NuevaRuta=Ruta.replace(".csv", "UTF8.csv");

    try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(NuevaRuta))) {
        byte[] bytes = new byte[3];
        int bytesRead = inputStream.read(bytes);

        if (bytesRead >= 3 && bytes[0] == (byte) 0xEF && bytes[1] == (byte) 0xBB && bytes[2] == (byte) 0xBF) {
            System.out.println("El archivo parece estar en UTF-8.");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(NuevaRuta), StandardCharsets.UTF_8));
                 CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

                ArrayList<BeanTR_GF_POBLACION_ATEND_MPIO_2023> ad = new ArrayList<>();
                ArrayList<String> Lista_ID_mun = new ListMunicipio().ID_MUNICIPIO();
                ArrayList<String> Lista_ID_nombre_mun = new ListMunicipio().NOMBRE_MUNICIPIO();

                int numeroColumnas = 0;
                CSVRecord firstRecord = csvParser.iterator().next();
                numeroColumnas = firstRecord.size();
                System.out.println("numero de columnas: " + numeroColumnas);

                if (numeroColumnas >= 6) { // Cambiar el valor según el número de columnas esperado
                    for (CSVRecord record : csvParser) {
                        if (record.get(0).isEmpty()) {
                            break; // Ignorar registros vacíos
                        }

                        for (int m = 0; m < Lista_ID_mun.size(); m++) {
                            BeanTR_GF_POBLACION_ATEND_MPIO_2023 c = new BeanTR_GF_POBLACION_ATEND_MPIO_2023();
                            c.SetID_PROGRAMA_SOCIAL(record.get(0));
                            c.SetID_MUNICIPIO(Lista_ID_mun.get(m));
                            c.SetNOMBRE_MUNICIPIO(Lista_ID_nombre_mun.get(m));
                            c.SetTOTAL_POBLACION(record.get(m + 1));
                            c.SetCOMENTARIOS(record.get(2509));// Ajustar el índice según tu lógica
                            ad.add(c);
                            CFilas++;
                        }
                    }

                    if (CFilas > 0) {
                        con = OracleDAOFactoryPSF.creaConexion();
                        sd = StructDescriptor.createDescriptor("OBJ_TMP_GF_POBLACION_ATEND_MPIO_"+Año, con);
                        structs = new STRUCT[ad.size()];

                        for (int i = 0; i < ad.size(); i++) {
                            structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                        }

                        descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TMP_GF_POBLACION_ATEND_MPIO_2024", con);
                        array_to_pass = new ARRAY(descriptor, con, structs);

                        st = con.prepareCall("{? = call(PKG_INTEGRADORXLSM_2024.TMP_GF_POBLACION_ATEND_MPIO_2024(?))}");
                        st.registerOutParameter(1, OracleTypes.INTEGER);
                        st.setArray(2, array_to_pass);
                        st.execute();
                    } else {
                        JOptionPane.showMessageDialog(null, "Pestaña poblacion_atendida_municipio sin registros");
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
