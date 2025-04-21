/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.org.inegi.insert_TR.JA;

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
import mx.org.inegi.bean.JA_TR.BeanTR_JA_ASUNTOS_HIDROCARBUROS;
import mx.org.inegi.conexion.JA.OracleDAOFactoryJA;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import static Pantallas_JA.IntegraJA_TR.directorio;

/**
 *
 * @author ANDREA.HERNANDEZL
 */
public class TR_JA_ASUNTOS_HIDROCARBUROS {
    public static int CFilas2 =0;

    public void TR_JA_ASUNTOS_HIDROCARBUROS() throws Exception {

        ARRAY array_to_pass;
        CallableStatement st;
        Connection con = null;
        STRUCT[] structs;
        StructDescriptor sd;
        ArrayDescriptor descriptor;
        int CFilas = 0;
        Conver_Utf8 conUTF8 = new Conver_Utf8();
        String NuevaRuta = directorio+"Asuntos_hidrocarburos.csv";
        conUTF8.Convertir_utf8_EBaseDatos(NuevaRuta);
        NuevaRuta = NuevaRuta.replace(".csv", "UTF8.csv");
        try ( BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(NuevaRuta))) {
            byte[] bytes = new byte[3];
            int bytesRead = inputStream.read(bytes);
             System.out.println("Leyendo: " + NuevaRuta);
            if (bytesRead >= 3 && bytes[0] == (byte) 0xEF && bytes[1] == (byte) 0xBB && bytes[2] == (byte) 0xBF) {
                try ( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(NuevaRuta), StandardCharsets.UTF_8));  CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
                    ArrayList<BeanTR_JA_ASUNTOS_HIDROCARBUROS> ad = new ArrayList<>();
                    int numeroColumnas = 0;
                    CSVRecord firstRecord = csvParser.iterator().next();
                    numeroColumnas = firstRecord.size();
                    System.out.println("Número de columnas: " + numeroColumnas+"---->if (numeroColumnas <= 14) continúa...");

                    if (numeroColumnas <= 14) { // Cambiar el valor según el número de columnas esperado
                        for (CSVRecord record : csvParser) {
                            if (record.get(0).isEmpty()) {
                                break; // Ignorar registros vacíos
                            }

                            BeanTR_JA_ASUNTOS_HIDROCARBUROS c = new BeanTR_JA_ASUNTOS_HIDROCARBUROS();
                            c.SetNOMBRE_ORGANO_JURIS(record.get(0));
                            c.SetCLAVE_ORGANO(record.get(1));
                            c.SetPERIODO(record.get(2));
                            c.SetTOTAL_ASUNTOS(record.get(3));
                            c.SetVALIDACION_CONTRATOS(record.get(4));
                            c.SetSOLICITUD_DECLARACION(record.get(5));
                            c.SetNULIDAD_CONTRATOS(record.get(6));
                            c.SetOTRAS_CONTROV(record.get(7));
                            c.SetTOTAL_ASUNTOS_CONCLUIDOS(record.get(8));
                            c.SetRESOLUCION_VALIDA(record.get(9));
                            c.SetRESOLUCION_NOVALIDA(record.get(10));
                            c.SetACUERDO_CADUCIDAD(record.get(11));
                            c.SetOTRA_FORMA_CONCL(record.get(12));
                            c.SetCOMENTARIOS(record.get(13));
                            ad.add(c);
                            CFilas++;
                        }
                        CFilas2 = CFilas;
                        if (CFilas > 0) {
                            con = OracleDAOFactoryJA.creaConexion();
                            sd = StructDescriptor.createDescriptor("OBJ_TR_JA_ASUNTOS_HIDROCARBUROS_GEN", con);
                            structs = new STRUCT[ad.size()];
                            for (int i = 0; i < ad.size(); i++) {
                                structs[i] = new STRUCT(sd, con, ad.get(i).toArray());
                            }
                            descriptor = ArrayDescriptor.createDescriptor("ARR_OBJ_TR_JA_ASUNTOS_HIDROCARBUROS_GEN", con);
                            array_to_pass = new ARRAY(descriptor, con, structs);
                            st = con.prepareCall("{? = call(PKG_INTEGRADOR_JA.TR_JA_ASUNTOS_HIDROCARBUROS_GEN(?))}");
                            st.registerOutParameter(1, OracleTypes.INTEGER);
                            st.setArray(2, array_to_pass);
                            st.execute();
                            System.out.println("Se ejecutó paquete integrador Asuntos_hidrocarburos, filas: "+CFilas+" \n");
                        } else {
                            JOptionPane.showMessageDialog(null, "Pestaña Asuntos_hidrocarburos sin registros");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El número de columnas de la Pestaña Asuntos_hidrocarburos no es el esperado.");
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
